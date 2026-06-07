package com.blocklegend001.immersiveores.mixin;

import com.blocklegend001.immersiveores.blocks.ModBlocks;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public class CanHarvestVulpus {

    @Inject(method = "hasCorrectToolForDrops", at = @At("HEAD"), cancellable = true)
    private void canHarvest(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        Player player = (Player) (Object) this;
        ItemStack itemInHand = player.getMainHandItem();

        if (state.is(ModBlocks.VULPUS_BLOCK)) {
            if (itemInHand.is(ModItems.ENDERIUM_PICKAXE)
                    || itemInHand.is(ModItems.VULPUS_PICKAXE)
                    || itemInHand.is(ModItems.VIBRANIUM_PICKAXE)
                    || itemInHand.is(ModItems.ENDERIUM_HAMMER)
                    || itemInHand.is(ModItems.VULPUS_HAMMER)
                    || itemInHand.is(ModItems.VIBRANIUM_HAMMER)
                    || itemInHand.is(ModItems.VIBRANIUM_PAXEL)
                    || itemInHand.is(ModItems.ENDERIUM_PAXEL)
                    || itemInHand.is(ModItems.VULPUS_PAXEL)) {
                cir.setReturnValue(true);
            } else {
                cir.setReturnValue(false);
            }
        } else if (state.is(ModBlocks.VULPUS_ORE)) {
            if (itemInHand.is(ModItems.ENDERIUM_PICKAXE)
                    || itemInHand.is(ModItems.VULPUS_PICKAXE)
                    || itemInHand.is(ModItems.VIBRANIUM_PICKAXE)
                    || itemInHand.is(ModItems.ENDERIUM_HAMMER)
                    || itemInHand.is(ModItems.VULPUS_HAMMER)
                    || itemInHand.is(ModItems.VIBRANIUM_HAMMER)
                    || itemInHand.is(ModItems.VIBRANIUM_PAXEL)
                    || itemInHand.is(ModItems.ENDERIUM_PAXEL)
                    || itemInHand.is(ModItems.VULPUS_PAXEL)) {
                cir.setReturnValue(true);
            } else {
                cir.setReturnValue(false);
            }
        } else if (state.is(ModBlocks.RAW_VULPUS_BLOCK)) {
            if (itemInHand.is(ModItems.ENDERIUM_PICKAXE)
                    || itemInHand.is(ModItems.VULPUS_PICKAXE)
                    || itemInHand.is(ModItems.VIBRANIUM_PICKAXE)
                    || itemInHand.is(ModItems.ENDERIUM_HAMMER)
                    || itemInHand.is(ModItems.VULPUS_HAMMER)
                    || itemInHand.is(ModItems.VIBRANIUM_HAMMER)
                    || itemInHand.is(ModItems.VIBRANIUM_PAXEL)
                    || itemInHand.is(ModItems.ENDERIUM_PAXEL)
                    || itemInHand.is(ModItems.VULPUS_PAXEL)) {
                cir.setReturnValue(true);
            } else {
                cir.setReturnValue(false);
            }
        }
    }
}
