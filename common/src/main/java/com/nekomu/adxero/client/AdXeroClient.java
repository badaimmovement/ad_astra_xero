package com.nekomu.adxero.client;

import com.nekomu.adxero.AdXero;
import com.nekomu.adxero.client.models.entities.XeroRocketModel;
import com.nekomu.adxero.client.renderers.blocks.CustomGlobeBlockEntityRenderer;
import com.nekomu.adxero.client.renderers.entities.AdXeroRenderer;
import com.nekomu.adxero.common.registry.ModBlockEntityTypes;
import com.nekomu.adxero.common.registry.ModBlocks;
import com.nekomu.adxero.common.registry.ModEntityTypes;
import com.nekomu.adxero.common.registry.ModItems;
import earth.terrarium.adastra.client.ClientPlatformUtils;
import earth.terrarium.adastra.client.renderers.entities.vehicles.RocketRenderer;
import earth.terrarium.botarium.client.ClientHooks;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import java.util.function.BiConsumer;
import java.util.function.Consumer;


public class AdXeroClient {

    public static void init() {
        registerEntityRenderers();
        registerBlockEntityRenderers();
        registerRenderLayers();
    }
    private static void registerEntityRenderers() {
        ClientHooks.registerEntityRenderer(ModEntityTypes.TIER_5_ROCKET, c -> new RocketRenderer(c, XeroRocketModel.TIER_5_LAYER, AdXeroRenderer.TIER_5_TEXTURE));
        ClientHooks.registerEntityRenderer(ModEntityTypes.TIER_6_ROCKET, c -> new RocketRenderer(c, XeroRocketModel.TIER_6_LAYER, AdXeroRenderer.TIER_6_TEXTURE));
        ClientHooks.registerEntityRenderer(ModEntityTypes.TIER_7_ROCKET, c -> new RocketRenderer(c, XeroRocketModel.TIER_7_LAYER, AdXeroRenderer.TIER_7_TEXTURE));
        ClientHooks.registerEntityRenderer(ModEntityTypes.TIER_8_ROCKET, c -> new RocketRenderer(c, XeroRocketModel.TIER_8_LAYER, AdXeroRenderer.TIER_8_TEXTURE));
        ClientHooks.registerEntityRenderer(ModEntityTypes.TIER_9_ROCKET, c -> new RocketRenderer(c, XeroRocketModel.TIER_9_LAYER, AdXeroRenderer.TIER_9_TEXTURE));
    }
    public static void onRegisterEntityLayers(ClientPlatformUtils.LayerDefinitionRegistry consumer) {
        XeroRocketModel.register(consumer);
    }
    public static void onRegisterItemRenderers(BiConsumer<Item, BlockEntityWithoutLevelRenderer> consumer) {
        consumer.accept(ModItems.TIER_5_ROCKET.get(), new RocketRenderer.ItemRenderer(XeroRocketModel.TIER_5_LAYER, AdXeroRenderer.TIER_5_TEXTURE));
        consumer.accept(ModItems.TIER_6_ROCKET.get(), new RocketRenderer.ItemRenderer(XeroRocketModel.TIER_6_LAYER, AdXeroRenderer.TIER_6_TEXTURE));
        consumer.accept(ModItems.TIER_7_ROCKET.get(), new RocketRenderer.ItemRenderer(XeroRocketModel.TIER_7_LAYER, AdXeroRenderer.TIER_7_TEXTURE));
        consumer.accept(ModItems.TIER_8_ROCKET.get(), new RocketRenderer.ItemRenderer(XeroRocketModel.TIER_8_LAYER, AdXeroRenderer.TIER_8_TEXTURE));
        consumer.accept(ModItems.TIER_9_ROCKET.get(), new RocketRenderer.ItemRenderer(XeroRocketModel.TIER_9_LAYER, AdXeroRenderer.TIER_9_TEXTURE));

        ModItems.GLOBES.stream().forEach(item -> consumer.accept(item.get(), new CustomGlobeBlockEntityRenderer.ItemRenderer()));
    }
    private static void registerBlockEntityRenderers() {
        ClientHooks.registerBlockEntityRenderers(ModBlockEntityTypes.GLOBE.get(), c -> new CustomGlobeBlockEntityRenderer());

    }
    public static void registerRenderLayers() {
    }
    public static void onRegisterModels(Consumer<ResourceLocation> consumer) {
        ModBlocks.GLOBES.stream().forEach(b -> consumer.accept(new ResourceLocation(AdXero.MOD_ID, "block/%s_cube".formatted(b.getId().getPath()))));
    }

}