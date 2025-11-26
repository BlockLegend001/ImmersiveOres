package com.blocklegend001.immersiveores.blocks.custom.vibranium;

import com.blocklegend001.immersiveores.util.color.ColoredBlock;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VibraniumOre extends Block implements ColoredBlock {
    public VibraniumOre(Settings arg) {
        super(arg);
    }

    @Override
    public Formatting getColor() {
        return Formatting.LIGHT_PURPLE;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        {
            tooltip.add(Text.translatable("tooltip.immersiveores.vibraniumore.tooltip").formatted(Formatting.LIGHT_PURPLE));
            tooltip.add(Text.translatable("tooltip.immersiveores.vibraniumorelevel.tooltip").formatted(Formatting.LIGHT_PURPLE));
            tooltip.add(Text.translatable("tooltip.immersiveores.breakvibranium.tooltip").formatted(Formatting.LIGHT_PURPLE));
        }

        super.appendTooltip(stack, world, tooltip, options);
    }
}