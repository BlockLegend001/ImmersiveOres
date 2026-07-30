package com.blocklegend001.immersiveores.mixin;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnderMan.class)
public abstract class EndermanMixinEnderium extends Entity {
    protected EndermanMixinEnderium(EntityType<?> type, Level world) {
        super(type, world);
    }

    @Inject(at = @At("HEAD"), cancellable = true, method = "isBeingStaredBy")
    private void isPlayerWearingEnderMask(Player player, CallbackInfoReturnable<Boolean> cir) {
        ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);
        if (helmet.getItem() == ModItems.ENDERIUM_HELMET && EnderiumConfig.endermanWillNotBeAngryWithYouEnderium) {
            cir.setReturnValue(false);
        }
    }
}
