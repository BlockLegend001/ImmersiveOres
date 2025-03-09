package com.blocklegend001.immersiveores.mixin;

import com.blocklegend001.immersiveores.blocks.ModBlocks;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class CanHarvestVibranium {
    
    @Inject(method = "canHarvest", at = @At("HEAD"), cancellable = true)
    private void canHarvest(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        ItemStack itemInHand = player.getMainHandStack();

        if (state.isOf(ModBlocks.VIBRANIUM_BLOCK)) {
            if (itemInHand.isOf(Items.NETHERITE_PICKAXE)
                    || itemInHand.isOf(ModItems.VIBRANIUM_PICKAXE)
                    || itemInHand.isOf(ModItems.ENDERIUM_PICKAXE)
                    || itemInHand.isOf(ModItems.VULPUS_PICKAXE)
                    || itemInHand.isOf(ModItems.VIBRANIUM_HAMMER)
                    || itemInHand.isOf(ModItems.ENDERIUM_HAMMER)
                    || itemInHand.isOf(ModItems.VULPUS_HAMMER)
                    || itemInHand.isOf(ModItems.VIBRANIUM_PAXEL)
                    || itemInHand.isOf(ModItems.ENDERIUM_PAXEL)
                    || itemInHand.isOf(ModItems.VULPUS_PAXEL)) {
                cir.setReturnValue(true);
            } else {
                cir.setReturnValue(false);
            }
        } else if (state.isOf(ModBlocks.VIBRANIUM_ORE)) {
            if (itemInHand.isOf(Items.NETHERITE_PICKAXE)
                    || itemInHand.isOf(ModItems.VIBRANIUM_PICKAXE)
                    || itemInHand.isOf(ModItems.ENDERIUM_PICKAXE)
                    || itemInHand.isOf(ModItems.VULPUS_PICKAXE)
                    || itemInHand.isOf(ModItems.VIBRANIUM_HAMMER)
                    || itemInHand.isOf(ModItems.ENDERIUM_HAMMER)
                    || itemInHand.isOf(ModItems.VULPUS_HAMMER)
                    || itemInHand.isOf(ModItems.VIBRANIUM_PAXEL)
                    || itemInHand.isOf(ModItems.ENDERIUM_PAXEL)
                    || itemInHand.isOf(ModItems.VULPUS_PAXEL)) {
                cir.setReturnValue(true);
            } else {
                cir.setReturnValue(false);
            }
        } else if (state.isOf(ModBlocks.RAW_VIBRANIUM_BLOCK)) {
            if (itemInHand.isOf(Items.NETHERITE_PICKAXE)
                    || itemInHand.isOf(ModItems.VIBRANIUM_PICKAXE)
                    || itemInHand.isOf(ModItems.ENDERIUM_PICKAXE)
                    || itemInHand.isOf(ModItems.VULPUS_PICKAXE)
                    || itemInHand.isOf(ModItems.VIBRANIUM_HAMMER)
                    || itemInHand.isOf(ModItems.ENDERIUM_HAMMER)
                    || itemInHand.isOf(ModItems.VULPUS_HAMMER)
                    || itemInHand.isOf(ModItems.VIBRANIUM_PAXEL)
                    || itemInHand.isOf(ModItems.ENDERIUM_PAXEL)
                    || itemInHand.isOf(ModItems.VULPUS_PAXEL)) {

                cir.setReturnValue(true);
            } else {
                cir.setReturnValue(false);
            }
        }
    }
}
