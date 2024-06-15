package com.blocklegend001.immersiveores.blocks.custom.vulpus;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VulpusOre extends Block {

    public VulpusOre(Properties arg) {
        super(arg);
    }

    @Override
    public void appendHoverText(ItemStack arg, @Nullable BlockGetter arg2, List<Component> components, TooltipFlag arg3) {

        {
            components.add(Component.translatable("tooltip.immersiveores.vulpusore.tooltip").withStyle(ChatFormatting.RED));
        }

        super.appendHoverText(arg, arg2, components, arg3);
    }
}
