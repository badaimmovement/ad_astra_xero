package com.nekomu.adxero.common.registry;

import com.nekomu.adxero.AdXero;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import com.nekomu.adxero.common.blockentities.CustomGlobeBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntityTypes {
    public static final ResourcefulRegistry<BlockEntityType<?>> BLOCK_ENTITY_TYPES = ResourcefulRegistries.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, AdXero.MOD_ID);

    public static final RegistryEntry<BlockEntityType<CustomGlobeBlockEntity>> GLOBE = BLOCK_ENTITY_TYPES.register(
            "globe",
            () -> createBlockEntityType(
                    CustomGlobeBlockEntity::new,
                    ModBlocks.GLOBES));

    public static <E extends BlockEntity> BlockEntityType<E> createBlockEntityType(BlockEntityType.BlockEntitySupplier<E> factory, ResourcefulRegistry<Block> registry) {
        return BlockEntityType.Builder.of(factory,
                        registry.stream()
                                .map(RegistryEntry::get)
                                .toArray(Block[]::new))
                .build(null);
    }
}