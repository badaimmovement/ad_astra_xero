package com.nekomu.adxero.common.registry;

import com.nekomu.adxero.AdXero;
import com.teamresourceful.resourcefullib.common.item.tabs.ResourcefulCreativeTab;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.adastra.common.registry.ModFluids;
import earth.terrarium.adastra.common.utils.FluidUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class ModCreativeTab {
    public static final ResourcefulRegistry<CreativeModeTab> TABS = ResourcefulRegistries.create(BuiltInRegistries.CREATIVE_MODE_TAB, AdXero.MOD_ID);
    public static final Supplier<CreativeModeTab> TAB = new ResourcefulCreativeTab(new ResourceLocation(AdXero.MOD_ID, "main"))
            .setItemIcon(ModItems.TIER_9_ROCKET)
            .addContent(ModCreativeTab::getCustomNbtItems)
            .addRegistry(ModItems.ITEMS)
            .build();

    public static Stream<ItemStack> getCustomNbtItems() {
        List<ItemStack> list = new ArrayList<>();

        list.add(FluidUtils.fluidFilledItem(ModItems.TIER_5_ROCKET, ModFluids.FUEL));
        list.add(FluidUtils.fluidFilledItem(ModItems.TIER_6_ROCKET, ModFluids.FUEL));
        list.add(FluidUtils.fluidFilledItem(ModItems.TIER_7_ROCKET, ModFluids.FUEL));
        list.add(FluidUtils.fluidFilledItem(ModItems.TIER_8_ROCKET, ModFluids.FUEL));
        list.add(FluidUtils.fluidFilledItem(ModItems.TIER_9_ROCKET, ModFluids.FUEL));

        list.add(new ItemStack(ModItems.TIER_5_ROCKET.get()));
        list.add(new ItemStack(ModItems.TIER_6_ROCKET.get()));
        list.add(new ItemStack(ModItems.TIER_7_ROCKET.get()));
        list.add(new ItemStack(ModItems.TIER_8_ROCKET.get()));
        list.add(new ItemStack(ModItems.TIER_9_ROCKET.get()));
        return list.stream();
    }
    public static void init() {
    }
}

