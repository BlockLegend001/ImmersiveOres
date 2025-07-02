package com.blocklegend001.immersiveores.util.tools;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.item.custom.base.Excavator;
import com.blocklegend001.immersiveores.item.custom.base.Hammer;
import com.blocklegend001.immersiveores.util.map.RadiusMap;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid = ImmersiveOres.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEventsToolHandler {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();
    public static boolean isSneaking = false;

    @SubscribeEvent
    public static void onToolUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        if (!(player instanceof ServerPlayer serverPlayer)) return;

        ItemStack mainHandItem = player.getMainHandItem();
        BlockPos origin = event.getPos();

        // Se lo abbiamo già gestito, saltiamo
        if (HARVESTED_BLOCKS.contains(origin)) return;

        HARVESTED_BLOCKS.add(origin);

        try {
            int radius = 0;
            Set<BlockPos> blocksToBreak = null;

            if (mainHandItem.getItem() instanceof Hammer hammer) {
                radius = isSneaking ? 0 : RadiusMap.getHammerRadius().getOrDefault(mainHandItem.getItem(), 0);
                blocksToBreak = new HashSet<>(Hammer.getBlocksToBeDestroyed(radius, origin, serverPlayer));
                processBlocks(blocksToBreak, origin, event, serverPlayer, mainHandItem, hammer);
            } else if (mainHandItem.getItem() instanceof Excavator excavator) {
                radius = isSneaking ? 0 : RadiusMap.getExcavatorRadius().getOrDefault(mainHandItem.getItem(), 0);
                blocksToBreak = new HashSet<>(Excavator.getBlocksToBeDestroyed(radius, origin, serverPlayer));
                processBlocks(blocksToBreak, origin, event, serverPlayer, mainHandItem, excavator);
            }

        } finally {
            HARVESTED_BLOCKS.remove(origin);
        }
    }

    private static <T> void processBlocks(Set<BlockPos> positions, BlockPos origin, BlockEvent.BreakEvent event, ServerPlayer player, ItemStack tool, T toolType) {
        if (positions == null) return;

        for (BlockPos pos : positions) {
            if (pos.equals(origin)) continue;
            if (HARVESTED_BLOCKS.contains(pos)) continue;

            boolean canHarvest = false;

            if (toolType instanceof Hammer hammer) {
                canHarvest = hammer.isCorrectToolForDrops(tool, event.getLevel().getBlockState(pos));
            } else if (toolType instanceof Excavator excavator) {
                canHarvest = excavator.isCorrectToolForDrops(tool, event.getLevel().getBlockState(pos));
            }

            if (!canHarvest) continue;

            HARVESTED_BLOCKS.add(pos);
            player.gameMode.destroyBlock(pos);
            HARVESTED_BLOCKS.remove(pos);
        }
    }
}