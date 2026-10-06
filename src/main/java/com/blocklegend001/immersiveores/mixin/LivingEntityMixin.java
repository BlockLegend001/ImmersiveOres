package com.blocklegend001.immersiveores.mixin;

import com.blocklegend001.immersiveores.event.ModEventHandler;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "causeFallDamage", at = @At("HEAD"), cancellable = true)
    public void onHandleFallDamage(double fallDistance, float damagePerDistance, DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        if (damageSource.is(DamageTypes.FALL)) {
            if (ModEventHandler.shouldPreventFallDamage()) {
                cir.setReturnValue(false);
            }
        }
    }
}
