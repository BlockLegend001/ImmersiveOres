package com.blocklegend001.immersiveores.mixin;

import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.PowderSnowBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PowderSnowBlock.class)
public class PowderSnowBlockMixinVibranium {
    @Inject(method = "canEntityWalkOnPowderSnow", at = @At("HEAD"), cancellable = true)
    private static void canWalkOnPowderSnow(net.minecraft.world.entity.Entity entity, CallbackInfoReturnable<Boolean> cir) {
        if (entity instanceof Player player && VibraniumConfig.canWalkOnPowderedSnowVibranium) {
            ItemStack boots = player.getItemBySlot(net.minecraft.world.entity.EquipmentSlot.FEET);
            if (boots.getItem() == ModItems.VIBRANIUM_BOOTS) {
                cir.setReturnValue(true);
            }
        }
    }
}