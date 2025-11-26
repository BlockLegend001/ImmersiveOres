package com.blocklegend001.immersiveores.mixin;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
    private void onHurt(int amount, RandomSource random, ServerPlayer player, CallbackInfoReturnable<Boolean> cir) {
        ItemStack stack = (ItemStack)(Object)this;

        String id = stack.getItem().getDescriptionId();

        if (EnderiumConfig.unbreakableEnderium.get() && id.contains("enderium")) {
            cir.setReturnValue(false);
        }

        if (VibraniumConfig.unbreakableVibranium.get() && id.contains("vibranium")) {
            cir.setReturnValue(false);
        }

        if (VulpusConfig.unbreakableVulpus.get() && id.contains("vulpus")) {
            cir.setReturnValue(false);
        }
    }
}