package com.blocklegend001.immersiveores.util.tools.excavator;

import com.blocklegend001.immersiveores.item.custom.enderium.EnderiumExcavator;
import com.blocklegend001.immersiveores.item.custom.vibranium.VibraniumExcavator;
import com.blocklegend001.immersiveores.item.custom.vulpus.VulpusExcavator;
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

public final class ModEventsExcavator implements PlayerBlockBreakEvents.Before {

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

        if (!isExcavator(item)) return true;

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

    private boolean isExcavator(Item item) {
        return item instanceof EnderiumExcavator
                || item instanceof VibraniumExcavator
                || item instanceof VulpusExcavator;
    }

    private int getRadius(Item item) {
        if (item instanceof EnderiumExcavator)
            return RadiusMap.ENDERIUM_EXCAVATOR_RADIUS.getOrDefault(item, 0);
        if (item instanceof VibraniumExcavator)
            return RadiusMap.VIBRANIUM_EXCAVATOR_RADIUS.getOrDefault(item, 0);
        if (item instanceof VulpusExcavator)
            return RadiusMap.VULPUS_EXCAVATOR_RADIUS.getOrDefault(item, 0);
        return 0;
    }

    private Iterable<BlockPos> getBlocks(Item item,
                                         int radius,
                                         BlockPos origin,
                                         ServerPlayerEntity player) {

        if (item instanceof EnderiumExcavator)
            return EnderiumExcavator.getBlocksToBeDestroyed(radius, origin, player);

        if (item instanceof VibraniumExcavator)
            return VibraniumExcavator.getBlocksToBeDestroyed(radius, origin, player);

        if (item instanceof VulpusExcavator)
            return VulpusExcavator.getBlocksToBeDestroyed(radius, origin, player);

        return Set.of();
    }

    private boolean isSuitable(Item item, ItemStack stack, BlockState state) {
        if (item instanceof EnderiumExcavator ex)
            return ex.isSuitableFor(stack, state);
        if (item instanceof VibraniumExcavator ex)
            return ex.isSuitableFor(stack, state);
        if (item instanceof VulpusExcavator ex)
            return ex.isSuitableFor(stack, state);
        return false;
    }
}
