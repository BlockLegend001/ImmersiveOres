package com.blocklegend001.immersiveores.blocks.custom.vulpus;

import com.blocklegend001.immersiveores.util.color.ColoredBlock;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VulpusBlock extends Block implements ColoredBlock {
    public VulpusBlock(Settings p_49795_) {
        super(p_49795_);
    }

    @Override
    public Formatting getColor() {
        return Formatting.RED;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView context, List<Text> tooltip, TooltipContext options) {

        {
            tooltip.add(Text.translatable("tooltip.immersiveores.breakvulpus.tooltip").formatted(Formatting.RED));
        }

        super.appendTooltip(stack, context, tooltip, options);
    }
}
