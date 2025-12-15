package com.nekomu.adxero;

import com.nekomu.adxero.common.registry.*;
import net.minecraft.core.RegistryAccess;

import java.util.function.Supplier;

public final class AdXero {
    public static final String MOD_ID = "adxero";

    private static Supplier<RegistryAccess> registryAccessSupplier;

    public static void init() {
        ModBlocks.BLOCKS.init();
        ModBlockEntityTypes.BLOCK_ENTITY_TYPES.init();
        ModCreativeTab.init();
        ModItems.ITEMS.init();
        ModEntityTypes.ENTITY_TYPES.init();
    }
    public static void postInit() {
    }
    public static void setRegistryAccess(Supplier<RegistryAccess> supplier) {
        registryAccessSupplier = supplier;
    }

    public static RegistryAccess getRegistryAccess() {
        return registryAccessSupplier.get();
    }
}

