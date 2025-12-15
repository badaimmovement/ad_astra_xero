package com.nekomu.adxero.common.registry;

import com.nekomu.adxero.AdXero;
import com.nekomu.adxero.common.blocks.CustomGlobeBlock;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.adastra.common.items.rendered.RenderedBlockItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;


public class ModBlocks {
    public static final ResourcefulRegistry<Block> BLOCKS = ResourcefulRegistries.create(BuiltInRegistries.BLOCK, AdXero.MOD_ID);

    public static final ResourcefulRegistry<Block> FLUIDS = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> CUBES = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> CTM_CUBES = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> CUBE_COLUMNS = ResourcefulRegistries.create(BLOCKS);
    public static final ResourcefulRegistry<Block> GLOBES = ResourcefulRegistries.create(BLOCKS);



    public static final RegistryEntry<CustomGlobeBlock> CALLISTO_GLOBE =registerGlobe("callisto_globe");
    public static final RegistryEntry<CustomGlobeBlock> CERES_GLOBE = registerGlobe("ceres_globe");
    public static final RegistryEntry<CustomGlobeBlock> ENCELADUS_GLOBE = registerGlobe("enceladus_globe");
    public static final RegistryEntry<CustomGlobeBlock> ERIS_GLOBE = registerGlobe("eris_globe");
    public static final RegistryEntry<CustomGlobeBlock> EUROPA_GLOBE = registerGlobe("europa_globe");
    public static final RegistryEntry<CustomGlobeBlock> GANYMEDE_GLOBE = registerGlobe("ganymede_globe");
    public static final RegistryEntry<CustomGlobeBlock> HAUMEA_GLOBE = registerGlobe("haumea_globe");
    public static final RegistryEntry<CustomGlobeBlock> IO_GLOBE = registerGlobe("io_globe");
    public static final RegistryEntry<CustomGlobeBlock> JUPITER_GLOBE = registerGlobe("jupiter_globe");
    public static final RegistryEntry<CustomGlobeBlock> MAKEMAKE_GLOBE = registerGlobe("makemake_globe");
    public static final RegistryEntry<CustomGlobeBlock> NEPTUNE_GLOBE = registerGlobe("neptune_globe");
    public static final RegistryEntry<CustomGlobeBlock> PLUTO_GLOBE = registerGlobe("pluto_globe");
    public static final RegistryEntry<CustomGlobeBlock> SATURN_GLOBE = registerGlobe("saturn_globe");
    public static final RegistryEntry<CustomGlobeBlock> TITAN_GLOBE = registerGlobe("titan_globe");
    public static final RegistryEntry<CustomGlobeBlock> URANUS_GLOBE = registerGlobe("uranus_globe");
    // io
    public static final RegistryEntry<Block> IO_STONE = CUBES.register("io_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_ORANGE)));
    //public static final RegistryEntry<Block> POLISHED_IO_STONE = CUBES.register("polished_io_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_ORANGE)));
    //europa
    public static final RegistryEntry<Block> EUROPA_STONE = CUBES.register("europa_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_ORANGE)));
    //public static final RegistryEntry<Block> POLISHED_EUROPA_STONE = CUBES.register("polished_europa_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_ORANGE)));
    //ganymede
    public static final RegistryEntry<Block> GANYMEDE_STONE = CUBES.register("ganymede_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_ORANGE)));
    //public static final RegistryEntry<Block> POLISHED_GANYMEDE_STONE = CUBES.register("polished_ganymede_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_ORANGE)));
    //callisto
    public static final RegistryEntry<Block> CALLISTO_STONE = CUBES.register("callisto_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_ORANGE)));
    //public static final RegistryEntry<Block> POLISHED_CALLISTO_STONE = CUBES.register("polished_callisto_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_ORANGE)));
    // ceres
    public static final RegistryEntry<Block> CERES_STONE = CUBES.register("ceres_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_ORANGE)));
    //public static final RegistryEntry<Block> POLISHED_CERES_STONE = CUBES.register("polished_ceres_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_ORANGE)));
     //titan
    public static final RegistryEntry<Block> TITAN_STONE = CUBES.register("titan_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_ORANGE)));
    //public static final RegistryEntry<Block> POLISHED_TITAN_STONE = CUBES.register("polished_titan_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_ORANGE)));
    //enceladus
    public static final RegistryEntry<Block> ENCELADUS_STONE = CUBES.register("enceladus_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_ORANGE)));
    //public static final RegistryEntry<Block> POLISHED_ENCELADUS_STONE = CUBES.register("polished_enceladus_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_ORANGE)));
    //pluto
    public static final RegistryEntry<Block> PLUTO_STONE = CUBES.register("pluto_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_ORANGE)));
    //public static final RegistryEntry<Block> POLISHED_PLUTO_STONE = CUBES.register("polished_pluto_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_ORANGE)));
    //haumea
    public static final RegistryEntry<Block> HAUMEA_STONE = CUBES.register("haumea_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_ORANGE)));
    //public static final RegistryEntry<Block> POLISHED_HAUMEA_STONE = CUBES.register("polished_haumea_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_ORANGE)));
    //makemake
    public static final RegistryEntry<Block> MAKEMAKE_STONE = CUBES.register("makemake_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_ORANGE)));
    //public static final RegistryEntry<Block> POLISHED_MAKEMAKE_STONE = CUBES.register("polished_makemake_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_ORANGE)));
    //eris
    public static final RegistryEntry<Block> ERIS_STONE = CUBES.register("eris_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_ORANGE)));
    //public static final RegistryEntry<Block> POLISHED_ERIS_STONE = CUBES.register("polished_eris_stone", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_ORANGE)));

    private static RegistryEntry<CustomGlobeBlock> registerGlobe(String name) {
        RegistryEntry<CustomGlobeBlock> toReturn = GLOBES.register(name, () -> new CustomGlobeBlock(BlockBehaviour.Properties.of()
                .mapColor(MapColor.METAL)
                .instrument(NoteBlockInstrument.IRON_XYLOPHONE)
                .requiresCorrectToolForDrops()
                .strength(5, 6)
                .sound(SoundType.COPPER)
                .noOcclusion()));
        registerGlobeItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryEntry<Item> registerGlobeItem(String name, RegistryEntry<T> block) {
        return ModItems.GLOBES.register(name, () -> new RenderedBlockItem(block.get(), new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));
    }

}
