package com.blocklegend001.immersiveores.mixin;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.util.ModTags;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Iterator;

@Mixin({PiglinBrain.class})
public abstract class PiglinMixinEnderium {
    @Inject(method = {"isWearingPiglinSafeArmor"}, at = {@At("HEAD")}, cancellable = true)
    private static void isWearingGold(LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {
        for (ItemStack stack : entity.getArmorItems()) {
            if (stack.isIn(ModTags.Items.ENDERIUM_ARMOR) && EnderiumConfig.makesPiglinsNeutralEnderium)
                cir.setReturnValue(Boolean.valueOf(true));
        }
    }
}

