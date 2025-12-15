package com.nekomu.adxero.datagen;


import com.nekomu.adxero.AdXero;
import com.nekomu.adxero.datagen.provider.client.ModBlockStateProvider;
import com.nekomu.adxero.datagen.provider.client.ModItemModelProvider;
import com.nekomu.adxero.datagen.provider.server.tags.ModBlockTagProvider;
import com.nekomu.adxero.datagen.provider.server.tags.ModEntityTypeTagProvider;
import com.nekomu.adxero.datagen.provider.server.tags.ModFluidTagProvider;
import com.nekomu.adxero.datagen.provider.server.tags.ModItemTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = AdXero.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class AdXeroDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        // client
        //generator.addProvider(event.includeClient(), new ModLangProvider(packOutput));
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));

        // tags
        //generator.addProvider(event.includeServer(), new ModBlockTagProvider(packOutput, lookupProvider, existingFileHelper));
        //generator.addProvider(event.includeServer(), new ModItemTagProvider(packOutput, lookupProvider, existingFileHelper));
        //generator.addProvider(event.includeServer(), new ModFluidTagProvider(packOutput, lookupProvider, existingFileHelper));
        //generator.addProvider(event.includeServer(), new ModEntityTypeTagProvider(packOutput, lookupProvider, existingFileHelper));
    }
}
