package com.nekomu.adxero.forge;

import com.nekomu.adxero.client.forge.AdXeroClientForge;
import com.nekomu.adxero.common.registry.ModBlocks;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;

import com.nekomu.adxero.AdXero;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(AdXero.MOD_ID)

public class AdXeroForge {
    public AdXeroForge() {
        AdXero.init();


        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::gatherData);
        if (FMLEnvironment.dist.isClient()) AdXeroClientForge.init();
    }
    private void gatherData(GatherDataEvent event) {
    }
}