package com.nekomu.adxero.datagen.provider.client;

import com.nekomu.adxero.AdXero;
import com.nekomu.adxero.common.registry.ModItems;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, AdXero.MOD_ID, existingFileHelper);
    }
    @Override
    protected void registerModels() {
        ModItems.BASIC_ITEMS.getEntries().stream().map(RegistryEntry::get).forEach(this::basicItem);
    }
}
