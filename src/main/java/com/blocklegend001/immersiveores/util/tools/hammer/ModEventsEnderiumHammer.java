package com.blocklegend001.immersiveores.util.tools.hammer;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.item.custom.enderium.EnderiumHammer;
import com.blocklegend001.immersiveores.util.map.RadiusMap;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid = ImmersiveOres.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEventsEnderiumHammer {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    @SubscribeEvent
    public static boolean onExcavatorUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if (!(player instanceof ServerPlayer serverPlayer)) return true;
        if (!(mainHandItem.getItem() instanceof EnderiumHammer excavator)) return true;
        if (HARVESTED_BLOCKS.contains(event.getPos())) return true;

        boolean isSneaking = player.isCrouching() || player.isShiftKeyDown();

        HARVESTED_BLOCKS.add(event.getPos());

        try {
            int radius = isSneaking ? 0 : RadiusMap.getEnderiumHammerRadius().get(mainHandItem.getItem());

            for (BlockPos targetPos : EnderiumHammer.getBlocksToBeDestroyed(radius, event.getPos(), serverPlayer)) {
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