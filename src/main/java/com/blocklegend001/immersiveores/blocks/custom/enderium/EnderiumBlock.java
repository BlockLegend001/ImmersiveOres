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

public class EnderiumBlock extends Block implements ColoredBlock {
    public EnderiumBlock(Settings settings) {
        super(settings);
    }

    @Override
    public Formatting getColor() {
        return Formatting.DARK_AQUA;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView context, List<Text> tooltip, TooltipContext options) {

        {
            tooltip.add(Text.translatable("tooltip.immersiveores.breakenderium.tooltip").formatted(Formatting.DARK_AQUA));
        }

        super.appendTooltip(stack, context, tooltip, options);
    }
}
