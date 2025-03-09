package com.blocklegend001.immersiveores.mixin;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnderMan.class)
public abstract class EndermanMixin extends Entity {
    protected EndermanMixin(EntityType<?> type, Level world) {
        super(type, world);
    }

    @Inject(at = @At("HEAD"), cancellable = true, method = "isBeingStaredBy")
    private void isPlayerWearingEnderMask(Player player, CallbackInfoReturnable<Boolean> cir) {
        ItemStack stack = player.getInventory().getArmor(3);
        if (stack.getItem() == ModItems.ENDERIUM_HELMET.get() && EnderiumConfig.endermanWillNotBeAngryWithYouEnderium) {
            cir.setReturnValue(false);
        }
    }
}