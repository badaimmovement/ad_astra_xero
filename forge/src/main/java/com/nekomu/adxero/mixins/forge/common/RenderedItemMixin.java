package com.nekomu.adxero.mixins.forge.common;


import com.nekomu.adxero.client.forge.AdXeroClientForge;
import earth.terrarium.adastra.common.items.rendered.RenderedBlockItem;
import earth.terrarium.adastra.common.items.rendered.RenderedItem;
import earth.terrarium.adastra.common.items.rendered.TooltipRenderedBlockItem;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.spongepowered.asm.mixin.Mixin;

import java.util.function.Consumer;

@Mixin({RenderedItem.class, RenderedBlockItem.class, TooltipRenderedBlockItem.class})
public class RenderedItemMixin extends Item {

    public RenderedItemMixin(Properties properties) {
        super(properties);
    }
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return AdXeroClientForge.ITEM_RENDERERS.get(RenderedItemMixin.this);
            }
        });
    }
}