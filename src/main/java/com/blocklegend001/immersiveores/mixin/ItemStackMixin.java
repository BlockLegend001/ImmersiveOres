package com.blocklegend001.immersiveores.mixin;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public class ItemStackMixin {

    @Inject(
            method = "damage(ILnet/minecraft/util/math/random/Random;Lnet/minecraft/server/network/ServerPlayerEntity;)Z",
            at = @At("HEAD"),
            cancellable = true
    )
    private void immersiveores$noItemDamage(int amount, Random random, ServerPlayerEntity player, CallbackInfoReturnable<Boolean> cir) {

        ItemStack stack = (ItemStack)(Object)this;
        Item item = stack.getItem();

        // ENDERIUM
        if (EnderiumConfig.unbreakableEnderium &&
                item.getTranslationKey().contains("enderium")) {
            cir.setReturnValue(false); // non subisce danno
        }

        // VIBRANIUM
        if (VibraniumConfig.unbreakableVibranium &&
                item.getTranslationKey().contains("vibranium")) {
            cir.setReturnValue(false);
        }

        // VULPUS
        if (VulpusConfig.unbreakableVulpus &&
                item.getTranslationKey().contains("vulpus")) {
            cir.setReturnValue(false);
        }
    }
}
