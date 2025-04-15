package com.blocklegend001.immersiveores.item.custom.enderium;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.List;
import java.util.function.Consumer;

public class EnderiumHoe extends HoeItem {

    public EnderiumHoe(ToolMaterial p_369501_, float p_368838_, float p_361631_, Properties p_41339_) {
        super(p_369501_, p_368838_, p_361631_, p_41339_);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext p_333372_, TooltipDisplay p_396484_, Consumer<Component> consumer, TooltipFlag p_41424_) {
        super.appendHoverText(pStack, p_333372_, p_396484_, consumer, p_41424_);
        if(Screen.hasShiftDown()) {
            consumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.DARK_AQUA));
            consumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));

        } else {
            consumer.accept(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.DARK_AQUA));
        }
    }
}
