package com.blocklegend001.immersiveores.item.custom.vulpus;

import com.blocklegend001.immersiveores.item.custom.base.Paxel;
import com.blocklegend001.immersiveores.util.ModTags;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class VulpusPaxel extends Paxel {

    public VulpusPaxel(ToolMaterial pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, ModTags.Blocks.VULPUS_PAXEL_MINEABLE, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> components, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()) {
            components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.RED));
            components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.RED));
        } else {
            components.add(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.RED));
        }
    }
}
