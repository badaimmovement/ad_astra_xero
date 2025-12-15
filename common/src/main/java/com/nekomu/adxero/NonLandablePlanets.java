package com.nekomu.adxero;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

import java.util.Set;

public class NonLandablePlanets {
    private static final Set<ResourceLocation> NON_LANDABLE = Set.of(
            new ResourceLocation("adxero", "saturn"),
            new ResourceLocation("adxero", "jupiter"),
            new ResourceLocation("adxero", "uranus"),
            new ResourceLocation("adxero", "neptune")
    );

    public static boolean isNonLandable(ResourceKey<Level> dimension) {
        return NON_LANDABLE.contains(dimension.location());
    }
}
