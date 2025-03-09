package com.blocklegend001.immersiveores.block.custom.vulpus;

import com.blocklegend001.immersiveores.block.ModBlocks;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class VulpusBlock extends Block {
    public VulpusBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> components, TooltipFlag pTooltipFlag) {

        {
            components.add(Component.translatable("tooltip.immersiveores.breakvulpus.tooltip").withStyle(ChatFormatting.RED));
        }

        super.appendHoverText(pStack, pContext, components, pTooltipFlag);
    }

    @Override
    public boolean canHarvestBlock(BlockState state, BlockGetter level, BlockPos pos, Player player) {
        ItemStack itemInHand = player.getMainHandItem();

        if (state.getBlock() == ModBlocks.VULPUS_BLOCK.get()) {
            return itemInHand.is(ModItems.VIBRANIUM_PICKAXE.get())
                    || itemInHand.is(ModItems.VULPUS_PICKAXE.get())
                    || itemInHand.is(ModItems.ENDERIUM_PICKAXE.get())
                    || itemInHand.is(ModItems.VULPUS_HAMMER.get())
                    || itemInHand.is(ModItems.ENDERIUM_HAMMER.get())
                    || itemInHand.is(ModItems.VIBRANIUM_HAMMER.get())
                    || itemInHand.is(ModItems.VIBRANIUM_PAXEL.get())
                    || itemInHand.is(ModItems.VULPUS_PAXEL.get())
                    || itemInHand.is(ModItems.ENDERIUM_PAXEL.get());
        }
        return super.canHarvestBlock(state, level, pos, player);
    }
}
