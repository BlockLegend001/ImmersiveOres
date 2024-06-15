package com.blocklegend001.immersiveores.event;

import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Mod.EventBusSubscriber
public class ModEventHandler {

    private static final Map<UUID, Boolean> Fly = new HashMap<>();

    @SubscribeEvent
    public static void onLivingEquipmentChange(LivingEquipmentChangeEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        ItemStack from = event.getFrom();
        ItemStack to = event.getTo();
        if (!from.getItem().equals(ModItems.ENDERIUM_BOOTS.get()) && to.getItem().equals(ModItems.ENDERIUM_BOOTS.get())) {
            Fly.put(player.getUUID(), player.getAbilities().mayfly);
            player.getAbilities().mayfly = true;
            player.onUpdateAbilities();
        } else if (from.getItem().equals(ModItems.ENDERIUM_BOOTS.get()) && !to.getItem().equals(ModItems.ENDERIUM_BOOTS.get())) {
            player.getAbilities().mayfly = Fly.get(player.getUUID());
            Fly.remove(player.getUUID());
            if (player.getAbilities().flying && !player.getAbilities().mayfly) player.getAbilities().flying = false;
            player.onUpdateAbilities();
        }
    }
}

