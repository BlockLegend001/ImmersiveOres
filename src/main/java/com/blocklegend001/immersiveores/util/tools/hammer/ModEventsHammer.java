package com.blocklegend001.immersiveores.util.tools.hammer;

import com.blocklegend001.immersiveores.item.custom.enderium.EnderiumHammer;
import com.blocklegend001.immersiveores.item.custom.vibranium.VibraniumHammer;
import com.blocklegend001.immersiveores.item.custom.vulpus.VulpusHammer;
import com.blocklegend001.immersiveores.util.map.RadiusMap;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public final class ModEventsHammer implements PlayerBlockBreakEvents.Before {

    private static final ThreadLocal<Set<BlockPos>> PROCESSING =
            ThreadLocal.withInitial(HashSet::new);

    @Override
    public boolean beforeBlockBreak(World world,
                                    PlayerEntity player,
                                    BlockPos pos,
                                    BlockState state,
                                    @Nullable BlockEntity blockEntity) {

        if (!(player instanceof ServerPlayerEntity serverPlayer)) return true;
        if (world.isClient()) return true;

        if (state.getHardness(world, pos) == 0.0F)  return true;

        ItemStack stack = player.getMainHandStack();
        Item item = stack.getItem();

        if (!isHammer(item)) return true;

        int radius = getRadius(item);
        if (radius <= 0) return true;

        Set<BlockPos> visited = PROCESSING.get();
        if (!visited.add(pos)) return true;

        try {
            for (BlockPos target : getBlocks(item, radius, pos, serverPlayer)) {

                if (visited.contains(target)) continue;
                if (target.equals(pos)) continue;

                if (!canBreak(world, serverPlayer, stack, target)) continue;

                visited.add(target);
                serverPlayer.interactionManager.tryBreakBlock(target);
                visited.remove(target);
            }
        } finally {
            visited.remove(pos);
        }

        return true;
    }

    private boolean canBreak(World world,
                             ServerPlayerEntity player,
                             ItemStack stack,
                             BlockPos pos) {

        BlockState state = world.getBlockState(pos);

        if (world.isAir(pos)) return false;
        if (state.getHardness(world, pos) < 0) return false;

        if (!world.canPlayerModifyAt(player, pos)) return false;
        if (!player.canModifyAt(world, pos)) return false;

        return isSuitable(stack.getItem(), stack, state);
    }

    private boolean isHammer(Item item) {
        return item instanceof EnderiumHammer
                || item instanceof VibraniumHammer
                || item instanceof VulpusHammer;
    }

    private int getRadius(Item item) {
        if (item instanceof EnderiumHammer)
            return RadiusMap.ENDERIUM_HAMMER_RADIUS.getOrDefault(item, 0);
        if (item instanceof VibraniumHammer)
            return RadiusMap.VIBRANIUM_HAMMER_RADIUS.getOrDefault(item, 0);
        if (item instanceof VulpusHammer)
            return RadiusMap.VULPUS_HAMMER_RADIUS.getOrDefault(item, 0);
        return 0;
    }

    private Iterable<BlockPos> getBlocks(Item item,
                                         int radius,
                                         BlockPos origin,
                                         ServerPlayerEntity player) {

        if (item instanceof EnderiumHammer)
            return EnderiumHammer.getBlocksToBeDestroyed(radius, origin, player);

        if (item instanceof VibraniumHammer)
            return VibraniumHammer.getBlocksToBeDestroyed(radius, origin, player);

        if (item instanceof VulpusHammer)
            return VulpusHammer.getBlocksToBeDestroyed(radius, origin, player);

        return Set.of();
    }

    private boolean isSuitable(Item item, ItemStack stack, BlockState state) {
        if (item instanceof EnderiumHammer ex)
            return ex.isSuitableFor(stack, state);
        if (item instanceof VibraniumHammer ex)
            return ex.isSuitableFor(stack, state);
        if (item instanceof VulpusHammer ex)
            return ex.isSuitableFor(stack, state);
        return false;
    }
}
