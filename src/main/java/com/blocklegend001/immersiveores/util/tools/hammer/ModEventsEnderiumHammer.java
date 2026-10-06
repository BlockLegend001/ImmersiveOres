package com.blocklegend001.immersiveores.util.tools.hammer;

import com.blocklegend001.immersiveores.item.custom.enderium.EnderiumHammer;
import com.blocklegend001.immersiveores.util.map.RadiusMap;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class ModEventsEnderiumHammer implements PlayerBlockBreakEvents.Before{
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    @Override
    public boolean beforeBlockBreak(Level world, Player player, BlockPos pos,
                                    BlockState state, @Nullable BlockEntity blockEntity) {
        if (!(player instanceof ServerPlayer serverPlayer)) return true;

        ItemStack mainHandItem = player.getMainHandItem();
        if (!(mainHandItem.getItem() instanceof EnderiumHammer hammer)) return true;
        if (state.getDestroySpeed(world, pos) == 0.0F)  return true;

        if (HARVESTED_BLOCKS.contains(pos)) return true;

        boolean isSneaking = player.isShiftKeyDown();

        HARVESTED_BLOCKS.add(pos);

        try {
            int radius = isSneaking ? 0 : RadiusMap.ENDERIUM_HAMMER_RADIUS.get(mainHandItem.getItem());

            for (BlockPos targetPos : EnderiumHammer.getBlocksToBeDestroyed(radius, pos, serverPlayer)) {
                if (targetPos.equals(pos)) continue;
                if (HARVESTED_BLOCKS.contains(targetPos)) continue;
                if (!hammer.isCorrectToolForDrops(mainHandItem, world.getBlockState(targetPos))) continue;

                HARVESTED_BLOCKS.add(targetPos);
                serverPlayer.gameMode.destroyBlock(targetPos);
                HARVESTED_BLOCKS.remove(targetPos);
            }
        } finally {
            HARVESTED_BLOCKS.remove(pos);
        }

        return true;
    }
}
