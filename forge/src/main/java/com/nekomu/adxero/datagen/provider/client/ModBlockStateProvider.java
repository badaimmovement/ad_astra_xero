package com.nekomu.adxero.datagen.provider.client;


import com.nekomu.adxero.AdXero;
import com.nekomu.adxero.common.registry.ModBlocks;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlockStateProvider extends BlockStateProvider {
    public static final ResourceLocation WATER_STILL = new ResourceLocation("block/water_still");
    protected static final ExistingFileHelper.ResourceType TEXTURE = new ExistingFileHelper.ResourceType(PackType.CLIENT_RESOURCES, ".png", "textures");

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AdXero.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        ModBlocks.FLUIDS.stream().map(RegistryEntry::get).forEach(this::fluidBlock);
        ModBlocks.CUBES.stream().map(RegistryEntry::get).forEach(this::basicBlock);
        ModBlocks.CTM_CUBES.stream().map(RegistryEntry::get).forEach(this::basicBlockNoState);
        ModBlocks.CUBE_COLUMNS.stream().map(RegistryEntry::get).forEach(this::basicCubeColumn);
        ModBlocks.GLOBES.stream().map(RegistryEntry::get).forEach(this::globe);
    }

    public void basicBlock(Block block) {
        simpleBlockItem(block, models().getBuilder(name(block)));
        simpleBlock(block);
    }

    public void basicBlock(Block block, ModelFile model) {
        simpleBlockItem(block, models().getBuilder(name(block)));
        simpleBlock(block, model);
    }

    public void basicBlockNoState(Block block) {
        simpleBlockItem(block, models().getBuilder(name(block)));
        cubeAll(block);
    }

    public void basicCubeColumn(Block block) {
        basicBlock(block,
                models().cubeColumn(
                        name(block),
                        modLoc("block/" + name(block)),
                        modLoc("block/" + name(block) + "_top")));
    }

    private void fluidBlock(Block block) {
        simpleBlock(block, models().getBuilder(name(block)).texture("particle", WATER_STILL.toString()));
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private String name(Block block) {
        return this.key(block).getPath();
    }

    public void existingBlock(Block block) {
        simpleBlock(block, models().getExistingFile(modLoc("block/%s".formatted(name(block)))));
    }

    private ResourceLocation findTexture(Block block, String replace) {
        ResourceLocation path = new ResourceLocation(AdXero.MOD_ID, blockTexture(block).getPath().replace(replace, ""));
        if (!models().existingFileHelper.exists(path, TEXTURE)) {
            path = new ResourceLocation(AdXero.MOD_ID, blockTexture(block).getPath().replace(replace, "s"));
            if (!models().existingFileHelper.exists(path, TEXTURE)) {
                path = new ResourceLocation(AdXero.MOD_ID, blockTexture(block).getPath().replace(replace, "_bricks"));
                if (!models().existingFileHelper.exists(path, TEXTURE)) {
                    path = new ResourceLocation(AdXero.MOD_ID, blockTexture(block).getPath().replace(replace, "_planks"));
                }
            }
        }
        return path;
    }
    public void globe(Block block) {
        itemModels().getBuilder(key(block).getPath()).parent(itemModels().getExistingFile(modLoc("item/rendered_item")));
        getVariantBuilder(block).forAllStates(state -> {
            String name = this.name(block);
            ResourceLocation texture = modLoc("block/globe/%s".formatted(name));

            ConfiguredModel.builder()
                    .modelFile(models().getBuilder(name + "_cube")
                            .texture("0", texture)
                            .parent(models().getExistingFile(modLoc("block/globe_cube"))))
                    .build();

            return ConfiguredModel.builder()
                    .modelFile(models().getBuilder(name)
                            .texture("0", texture)
                            .texture("particle", texture)
                            .parent(models().getExistingFile(modLoc("block/globe"))))
                    .build();
        });
    }
}