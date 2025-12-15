package com.nekomu.adxero.common.registry;

import com.nekomu.adxero.AdXero;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.adastra.common.items.rendered.RenderedBlockItem;
import earth.terrarium.adastra.common.items.vehicles.RocketItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class ModItems {
    public static final ResourcefulRegistry<Item> ITEMS = ResourcefulRegistries.create(BuiltInRegistries.ITEM, AdXero.MOD_ID);
    public static final ResourcefulRegistry<Item> BASIC_ITEMS = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> VEHICLES = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> GLOBES = ResourcefulRegistries.create(ITEMS);

    public static final RegistryEntry<Item> TIER_5_ROCKET = VEHICLES.register("tier_5_rocket", () -> new RocketItem(ModEntityTypes.TIER_5_ROCKET::get, new Item.Properties().stacksTo(1).fireResistant()));
    public static final RegistryEntry<Item> TIER_6_ROCKET = VEHICLES.register("tier_6_rocket", () -> new RocketItem(ModEntityTypes.TIER_6_ROCKET::get, new Item.Properties().stacksTo(1).fireResistant()));
    public static final RegistryEntry<Item> TIER_7_ROCKET = VEHICLES.register("tier_7_rocket", () -> new RocketItem(ModEntityTypes.TIER_7_ROCKET::get, new Item.Properties().stacksTo(1).fireResistant()));
    public static final RegistryEntry<Item> TIER_8_ROCKET = VEHICLES.register("tier_8_rocket", () -> new RocketItem(ModEntityTypes.TIER_8_ROCKET::get, new Item.Properties().stacksTo(1).fireResistant()));
    public static final RegistryEntry<Item> TIER_9_ROCKET = VEHICLES.register("tier_9_rocket", () -> new RocketItem(ModEntityTypes.TIER_9_ROCKET::get, new Item.Properties().stacksTo(1).fireResistant()));

   // io
    public static final RegistryEntry<Item> IO_STONE = ITEMS.register("io_stone", () -> new BlockItem(ModBlocks.IO_STONE.get(), new Item.Properties()));
    //public static final RegistryEntry<Item> POLISHED_IO_STONE = ITEMS.register("polished_io_stone", () -> new BlockItem(ModBlocks.POLISHED_IO_STONE.get(), new Item.Properties()));
    //europa
    public static final RegistryEntry<Item> EUROPA_STONE = ITEMS.register("europa_stone", () -> new BlockItem(ModBlocks.EUROPA_STONE.get(), new Item.Properties()));
    //public static final RegistryEntry<Item> POLISHED_EUROPA_STONE = ITEMS.register("polished_europa_stone", () -> new BlockItem(ModBlocks.POLISHED_EUROPA_STONE.get(), new Item.Properties()));
    //ganymede
    public static final RegistryEntry<Item> GANYMEDE_STONE = ITEMS.register("ganymede_stone", () -> new BlockItem(ModBlocks.GANYMEDE_STONE.get(), new Item.Properties()));
    //public static final RegistryEntry<Item> POLISHED_GANYMEDE_STONE = ITEMS.register("polished_ganymede_stone", () -> new BlockItem(ModBlocks.POLISHED_GANYMEDE_STONE.get(), new Item.Properties()));
    // callisto
    public static final RegistryEntry<Item> CALLISTO_STONE = ITEMS.register("callisto_stone", () -> new BlockItem(ModBlocks.CALLISTO_STONE.get(), new Item.Properties()));
    //public static final RegistryEntry<Item> POLISHED_CALLISTO_STONE = ITEMS.register("polished_callisto_stone", () -> new BlockItem(ModBlocks.POLISHED_CALLISTO_STONE.get(), new Item.Properties()));
    // ceres
    public static final RegistryEntry<Item> CERES_STONE = ITEMS.register("ceres_stone", () -> new BlockItem(ModBlocks.CERES_STONE.get(), new Item.Properties()));
    //public static final RegistryEntry<Item> POLISHED_CERES_STONE = ITEMS.register("polished_ceres_stone", () -> new BlockItem(ModBlocks.POLISHED_CERES_STONE.get(), new Item.Properties()));
    //titan
    public static final RegistryEntry<Item> TITAN_STONE = ITEMS.register("titan_stone", () -> new BlockItem(ModBlocks.TITAN_STONE.get(), new Item.Properties()));
    //public static final RegistryEntry<Item> POLISHED_TITAN_STONE = ITEMS.register("polished_titan_stone", () -> new BlockItem(ModBlocks.POLISHED_TITAN_STONE.get(), new Item.Properties()));
    //enceladus
    public static final RegistryEntry<Item> ENCELADUS_STONE = ITEMS.register("enceladus_stone", () -> new BlockItem(ModBlocks.ENCELADUS_STONE.get(), new Item.Properties()));
    //public static final RegistryEntry<Item> POLISHED_ENCELADUS_STONE = ITEMS.register("polished_enceladus_stone", () -> new BlockItem(ModBlocks.POLISHED_ENCELADUS_STONE.get(), new Item.Properties()));
    //pluto
    public static final RegistryEntry<Item> PLUTO_STONE = ITEMS.register("pluto_stone", () -> new BlockItem(ModBlocks.PLUTO_STONE.get(), new Item.Properties()));
    //public static final RegistryEntry<Item> POLISHED_PLUTO_STONE = ITEMS.register("polished_pluto_stone", () -> new BlockItem(ModBlocks.POLISHED_PLUTO_STONE.get(), new Item.Properties()));
    //haumea
    public static final RegistryEntry<Item> HAUMEA_STONE = ITEMS.register("haumea_stone", () -> new BlockItem(ModBlocks.HAUMEA_STONE.get(), new Item.Properties()));
    //public static final RegistryEntry<Item> POLISHED_HAUMEA_STONE = ITEMS.register("polished_haumea_stone", () -> new BlockItem(ModBlocks.POLISHED_HAUMEA_STONE.get(), new Item.Properties()));
    //makemake
    public static final RegistryEntry<Item> MAKEMAKE_STONE = ITEMS.register("makemake_stone", () -> new BlockItem(ModBlocks.MAKEMAKE_STONE.get(), new Item.Properties()));
    //public static final RegistryEntry<Item> POLISHED_MAKEMAKE_STONE = ITEMS.register("polished_makemake_stone", () -> new BlockItem(ModBlocks.POLISHED_MAKEMAKE_STONE.get(), new Item.Properties()));
    //eris
    public static final RegistryEntry<Item> ERIS_STONE = ITEMS.register("eris_stone", () -> new BlockItem(ModBlocks.ERIS_STONE.get(), new Item.Properties()));
    //public static final RegistryEntry<Item> POLISHED_ERIS_STONE = ITEMS.register("polished_eris_stone", () -> new BlockItem(ModBlocks.POLISHED_ERIS_STONE.get(), new Item.Properties()));
}
