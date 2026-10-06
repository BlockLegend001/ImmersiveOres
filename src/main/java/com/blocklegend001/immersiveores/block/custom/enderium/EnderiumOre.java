package com.blocklegend001.immersiveores.block.custom.enderium;

import com.blocklegend001.immersiveores.block.ModBlocks;
import com.blocklegend001.immersiveores.item.ModItems;
import com.blocklegend001.immersiveores.util.color.ColoredBlock;
import com.blocklegend001.immersiveores.util.tooltip.TooltipBlock;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class EnderiumOre extends Block implements TooltipBlock, ColoredBlock {
    public EnderiumOre(Properties arg) {
        super(arg);
    }

    @Override
    public boolean canHarvestBlock(BlockState state, BlockGetter level, BlockPos pos, Player player) {
        ItemStack itemInHand = player.getMainHandItem();

        if (state.getBlock() == ModBlocks.ENDERIUM_ORE.get()) {
            return  itemInHand.is(ModItems.VULPUS_PICKAXE.get())
                    || itemInHand.is(ModItems.ENDERIUM_PICKAXE.get())
                    || itemInHand.is(ModItems.VULPUS_HAMMER.get())
                    || itemInHand.is(ModItems.ENDERIUM_HAMMER.get())
                    || itemInHand.is(ModItems.VULPUS_PAXEL.get())
                    || itemInHand.is(ModItems.ENDERIUM_PAXEL.get());
        }
        return super.canHarvestBlock(state, level, pos, player);
    }

    @Override
    public ChatFormatting getColor() {
        return ChatFormatting.DARK_AQUA;
    }

    @Override
    public void appendClientTooltip(ItemStack stack, TooltipAccept tooltips) {
        tooltips.accept(Component.translatable("tooltip.immersiveores.enderiumore.tooltip").withStyle(ChatFormatting.DARK_AQUA));
        tooltips.accept(Component.translatable("tooltip.immersiveores.enderiumorelevel.tooltip").withStyle(ChatFormatting.DARK_AQUA));
        tooltips.accept(Component.translatable("tooltip.immersiveores.breakenderium.tooltip").withStyle(ChatFormatting.DARK_AQUA));
    }
}
