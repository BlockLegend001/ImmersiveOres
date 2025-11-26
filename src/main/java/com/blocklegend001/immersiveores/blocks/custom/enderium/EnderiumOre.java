package com.blocklegend001.immersiveores.blocks.custom.enderium;

import com.blocklegend001.immersiveores.util.color.ColoredBlock;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EnderiumOre extends Block implements ColoredBlock {
    public EnderiumOre(Settings arg) {
        super(arg);
    }

    @Override
    public Formatting getColor() {
        return Formatting.DARK_AQUA;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView context, List<Text> tooltip, TooltipContext options) {

        {
            tooltip.add(Text.translatable("tooltip.immersiveores.enderiumore.tooltip").formatted(Formatting.DARK_AQUA));
            tooltip.add(Text.translatable("tooltip.immersiveores.enderiumorelevel.tooltip").formatted(Formatting.DARK_AQUA));
            tooltip.add(Text.translatable("tooltip.immersiveores.breakenderium.tooltip").formatted(Formatting.DARK_AQUA));
        }

        super.appendTooltip(stack, context, tooltip, options);
    }
}
