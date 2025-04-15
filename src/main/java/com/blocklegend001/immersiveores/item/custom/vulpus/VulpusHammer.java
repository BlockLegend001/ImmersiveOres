package com.blocklegend001.immersiveores.item.custom.vulpus;

import com.blocklegend001.immersiveores.item.custom.base.Hammer;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.List;
import java.util.function.Consumer;

public class VulpusHammer extends Hammer {

    public VulpusHammer(ToolMaterial pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext p_333372_, TooltipDisplay p_396484_, Consumer<Component> consumer, TooltipFlag p_41424_) {
        super.appendHoverText(pStack, p_333372_, p_396484_, consumer, p_41424_);
        if(Screen.hasShiftDown()) {
            consumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.RED));
            consumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.RED));
            consumer.accept(Component.translatable("tooltip.immersiveores.5x5.tooltip").withStyle(ChatFormatting.RED));
        } else {
            consumer.accept(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.RED));
        }
    }
}

