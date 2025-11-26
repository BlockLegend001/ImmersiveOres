package com.blocklegend001.immersiveores.mixin;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EndermanEntity.class)
public abstract class EndermanMixinEnderium extends Entity {
    protected EndermanMixinEnderium(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(at = @At("HEAD"), cancellable = true, method = "isPlayerStaring")
    private void isPlayerWearingEnderMask(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        ItemStack stack = (ItemStack) player.getInventory().getArmorStack(3);
        if (stack.getItem() == ModItems.ENDERIUM_HELMET && EnderiumConfig.endermanWillNotBeAngryWithYouEnderium) {
            cir.setReturnValue(false);
        }
    }
}
