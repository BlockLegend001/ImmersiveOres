package com.blocklegend001.immersiveores.mixin;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.event.ModEventHandler;
import com.blocklegend001.immersiveores.item.ModItems;
import io.github.ladysnake.pal.AbilitySource;
import io.github.ladysnake.pal.Pal;
import io.github.ladysnake.pal.VanillaAbilities;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    private static final Map<UUID, Boolean> FlyByBoots = new HashMap<>();
    private static final AbilitySource BOOT_SOURCE = Pal.getAbilitySource(ImmersiveOres.MOD_ID, "enderium_boots");

    @Inject(method = "tick", at = @At("HEAD"))
    public void onPlayerTick(CallbackInfo ci) {
        PlayerEntity player = (PlayerEntity) (Object) this;
        UUID uuid = player.getUuid();

        if (player.getWorld().isClient) return;

        if (player.isCreative() || player.isSpectator()) return;

        boolean wearingBoots = player.getEquippedStack(EquipmentSlot.FEET).getItem() == ModItems.ENDERIUM_BOOTS;
        boolean hadBootFlight = FlyByBoots.getOrDefault(uuid, false);

        if (wearingBoots && ImmersiveOres.ENDERIUM_CONFIG.armorAbilities().canFly) {
            FlyByBoots.put(uuid, true);

            if (!VanillaAbilities.ALLOW_FLYING.getTracker(player).isGrantedBy(BOOT_SOURCE)) {
                VanillaAbilities.ALLOW_FLYING.getTracker(player).addSource(BOOT_SOURCE);
            }

            player.fallDistance = 0.0f;
            return;
        }

        if (!wearingBoots && hadBootFlight) {
            FlyByBoots.put(uuid, false);

            if (VanillaAbilities.ALLOW_FLYING.getTracker(player).isGrantedBy(BOOT_SOURCE)) {
                VanillaAbilities.ALLOW_FLYING.getTracker(player).removeSource(BOOT_SOURCE);
            }

            ModEventHandler.onBootsRemoved();
        }

        if (player.isOnGround() && ModEventHandler.shouldPreventFallDamage()) {
            player.fallDistance = 0.0f;
            ModEventHandler.resetFallDamagePrevention();
        }
    }
}