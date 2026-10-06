package com.blocklegend001.immersiveores.blocks.custom.vulpus;

import com.blocklegend001.immersiveores.util.tooltip.TooltipBlock;
import com.blocklegend001.immersiveores.util.color.ColoredBlock;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.Nullable;

public class VulpusBlock extends Block implements TooltipBlock, ColoredBlock {
    public VulpusBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public @Nullable TextColor getColor() {
        return TextColor.fromLegacyFormat(ChatFormatting.RED);
    }

    @Override
    public void appendClientTooltip(ItemStack stack, TooltipAccept tooltips) {
        tooltips.accept(Component.translatable("tooltip.immersiveores.breakvulpus.tooltip").withStyle(ChatFormatting.RED));
    }
}
