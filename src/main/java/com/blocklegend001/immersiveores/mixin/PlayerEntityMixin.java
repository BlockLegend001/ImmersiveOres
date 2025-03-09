package com.blocklegend001.immersiveores.mixin;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.event.ModEventHandler;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    @NotNull
    private static final Map<UUID, Boolean> Fly = new HashMap<>();
    private boolean wasWearingBoots = false;

    @Inject(method = "tick", at = @At("HEAD"))
    public void onPlayerTick(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;

        boolean isWearingBoots = player.getEquippedStack(EquipmentSlot.FEET).getItem() == ModItems.ENDERIUM_BOOTS;

        if (!player.isCreative() && !player.isSpectator()) {

            if (isWearingBoots && EnderiumConfig.canFlyEnderiumArmor) {
                Fly.put(player.getUuid(), true);  // Permetti il volo con i boots
                player.getAbilities().allowFlying = true;
                player.sendAbilitiesUpdate();
                wasWearingBoots = true;
            } else {
                if (wasWearingBoots && !isWearingBoots) {
                    ModEventHandler.onBootsRemoved();
                    wasWearingBoots = false;
                }

                if (player.isOnGround()) {
                    ModEventHandler.resetFallDamagePrevention();
                }

                if (!isWearingBoots) {
                    player.getAbilities().allowFlying = Fly.getOrDefault(player.getUuid(), false);
                    player.getAbilities().flying = false;
                    Fly.replace(player.getUuid(), player.getAbilities().allowFlying, false);
                    player.sendAbilitiesUpdate();
                }

                boolean canFlyForOtherReasons = Fly.getOrDefault(player.getUuid(), false);

                if (!isWearingBoots && !canFlyForOtherReasons) {
                    player.getAbilities().allowFlying = false;  // Disabilita il volo solo se non ci sono altri motivi
                    player.getAbilities().flying = false;
                    Fly.put(player.getUuid(), false);  // Aggiorna lo stato del volo nel map
                    player.sendAbilitiesUpdate();
                }
            }
        }
    }
}
