package com.blocklegend001.immersiveores.util.tools.hammer;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.item.custom.vibranium.VibraniumHammer;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;

import java.util.HashSet;
import java.util.Set;

@EventBusSubscriber(modid = ImmersiveOres.MODID, bus = EventBusSubscriber.Bus.GAME)
public class ModEventsVibraniumHammer {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();
    public static boolean isSneaking = false;

    @SubscribeEvent
    public static boolean onExcavatorUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if (!(player instanceof ServerPlayer serverPlayer)) return true;

        if (!(mainHandItem.getItem() instanceof VibraniumHammer excavator)) return true;

        if (HARVESTED_BLOCKS.contains(event.getPos())) return true;

        HARVESTED_BLOCKS.add(event.getPos());

        try {
            int radius = isSneaking ? 0 : 1;
            for (BlockPos targetPos : VibraniumHammer.getBlocksToBeDestroyed(radius, event.getPos(), serverPlayer)) {
                if (targetPos.equals(event.getPos())) continue;

                if (HARVESTED_BLOCKS.contains(targetPos)) continue;
                if (!excavator.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(targetPos))) continue;

                HARVESTED_BLOCKS.add(targetPos);
                serverPlayer.gameMode.destroyBlock(targetPos);
                HARVESTED_BLOCKS.remove(targetPos);
            }
        } finally {
            HARVESTED_BLOCKS.remove(event.getPos());
        }

        return true;
    }
}