package com.nekomu.adxero.common.entities;

import com.nekomu.adxero.common.utils.tags.ModFluidTags;
import earth.terrarium.adastra.common.entities.vehicles.Rocket;
import com.nekomu.adxero.common.registry.ModEntityTypes;
import com.nekomu.adxero.common.registry.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

import java.util.Map;

public class XeroRocket extends Rocket {
    private static final RocketProperties TIER_5_PROPERTIES = new RocketProperties(5, ModItems.TIER_5_ROCKET.get(), 1.7f, ModFluidTags.TIER_5_ROCKET_FUEL);
    private static final RocketProperties TIER_6_PROPERTIES = new RocketProperties(6, ModItems.TIER_6_ROCKET.get(), 1.7f, ModFluidTags.TIER_6_ROCKET_FUEL);
    private static final RocketProperties TIER_7_PROPERTIES = new RocketProperties(7, ModItems.TIER_7_ROCKET.get(), 1.7f, ModFluidTags.TIER_7_ROCKET_FUEL);
    private static final RocketProperties TIER_8_PROPERTIES = new RocketProperties(8, ModItems.TIER_8_ROCKET.get(), 1.7f, ModFluidTags.TIER_8_ROCKET_FUEL);
    private static final RocketProperties TIER_9_PROPERTIES = new RocketProperties(9, ModItems.TIER_9_ROCKET.get(), 1.7f, ModFluidTags.TIER_9_ROCKET_FUEL);


    public static final Map<EntityType<?>, RocketProperties> AD_XERO_PROPERTIES = Map.of(
            ModEntityTypes.TIER_5_ROCKET.get(), TIER_5_PROPERTIES,
            ModEntityTypes.TIER_6_ROCKET.get(), TIER_6_PROPERTIES,
            ModEntityTypes.TIER_7_ROCKET.get(), TIER_7_PROPERTIES,
            ModEntityTypes.TIER_8_ROCKET.get(), TIER_8_PROPERTIES,
            ModEntityTypes.TIER_9_ROCKET.get(), TIER_9_PROPERTIES);

    public XeroRocket(EntityType<?> type, Level level) {
        super(type, level, AD_XERO_PROPERTIES.get(type));
    }
}
