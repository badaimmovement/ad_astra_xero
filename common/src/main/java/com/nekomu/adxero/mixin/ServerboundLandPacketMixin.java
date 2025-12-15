package com.nekomu.adxero.mixin;

import com.nekomu.adxero.NonLandablePlanets;
import earth.terrarium.adastra.common.utils.ModUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ModUtils.class, remap = false)
public class ServerboundLandPacketMixin {
    @Inject(
            method = "land(Lnet/minecraft/server/level/ServerPlayer;Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/phys/Vec3;)V",
            at = @At("HEAD"),
            cancellable = true,
            remap = false
    )
    private static void blockNonLandablePlanets(ServerPlayer player, ServerLevel targetLevel, Vec3 pos, CallbackInfo ci) {
        if (NonLandablePlanets.isNonLandable(targetLevel.dimension())) {
            player.sendSystemMessage(Component.literal("この惑星には着陸できません。").withStyle(ChatFormatting.RED));
            ci.cancel();
        }
    }
}