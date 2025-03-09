package com.blocklegend001.immersiveores.event;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent;
import net.neoforged.neoforge.event.entity.living.LivingFallEvent;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@EventBusSubscriber
public class ModEventHandler {

    @NotNull
    private static final Map<UUID, Boolean> Fly = new HashMap<>();
    private static boolean preventFallDamageOnce = false;

    @SubscribeEvent
    public static void onLivingEquipmentChange(LivingEquipmentChangeEvent event) {
        Level level = event.getEntity().level();
        Entity entity = event.getEntity();
        if (!level.isClientSide() && entity instanceof Player player) {
            UUID playerUUID = player.getUUID();

            if (player.getItemBySlot(EquipmentSlot.FEET).getItem() == ModItems.ENDERIUM_BOOTS.get() && EnderiumConfig.canFlyEnderiumArmor) {
                Fly.putIfAbsent(playerUUID, player.getAbilities().mayfly);

                player.getAbilities().mayfly = true;
                preventFallDamageOnce = true;
                player.onUpdateAbilities();

            } else if (Fly.containsKey(playerUUID)) {
                player.getAbilities().mayfly = Fly.get(playerUUID);

                if (!player.getAbilities().mayfly) {
                    player.getAbilities().flying = false;
                }

                Fly.remove(playerUUID);
                player.onUpdateAbilities();
            }
        }
    }

    @SubscribeEvent
    public static void cancelPlayerFallDamage(LivingFallEvent event) {
        Level level = event.getEntity().level();
        Entity entity = event.getEntity();
        if (!level.isClientSide() && entity instanceof Player) {
            if (preventFallDamageOnce) {
                event.setDistance(0);
                preventFallDamageOnce = false;
            }
        }
    }
}
