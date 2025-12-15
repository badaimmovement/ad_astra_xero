package com.nekomu.adxero.client.forge;


import com.nekomu.adxero.client.AdXeroClient;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AdXeroClientForge {

    public static final Map<Item, BlockEntityWithoutLevelRenderer> ITEM_RENDERERS = new HashMap<>();

    public static void init() {}

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(AdXeroClient::init);
        AdXeroClient.onRegisterItemRenderers(ITEM_RENDERERS::put);
    }

    @SubscribeEvent
    public static void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        AdXeroClient.onRegisterEntityLayers(event::registerLayerDefinition);
    }
    @SubscribeEvent
    public static void modelLoading(ModelEvent.RegisterAdditional event) {
        AdXeroClient.onRegisterModels(event::register);
    }
}
