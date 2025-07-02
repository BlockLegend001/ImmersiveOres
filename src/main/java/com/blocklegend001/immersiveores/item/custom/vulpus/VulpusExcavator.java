package com.blocklegend001.immersiveores.item.custom.vulpus;

import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.item.custom.base.Excavator;
import com.blocklegend001.immersiveores.util.map.RadiusMap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.Unbreakable;

import java.util.List;

public class VulpusExcavator extends Excavator {
    private static Properties createSettings(Properties properties, boolean unbreakable, int durability) {
        properties.durability(durability);

        if (unbreakable) {
            properties.component(DataComponents.UNBREAKABLE, new Unbreakable(true));
        }
        return properties;
    }

    public VulpusExcavator(ToolMaterial pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, createSettings(pProperties, VulpusConfig.unbreakableVulpus.get(), VulpusConfig.durabilityVulpus.get()));
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> components, TooltipFlag pTooltipFlag) {
        int radius = getRadiusForHammer(pStack);
        int widht = radius * 2 + 1;

        if(Screen.hasShiftDown()) {
            if (VulpusConfig.unbreakableVulpus.get()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.RED));
            }
            components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.RED));

            Component text = Component.literal("Dig area: ")
                    .withStyle(ChatFormatting.RED)
                    .append(Component.literal(widht + "x1").withStyle(ChatFormatting.YELLOW));

            components.add(text);
        } else {
            components.add(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.RED));
        }
    }

    private int getRadiusForHammer(ItemStack stack) {
        if (RadiusMap.getExcavatorRadius().containsKey(stack.getItem())) {
            return RadiusMap.getExcavatorRadius().get(stack.getItem());
        }
        return 0;
    }
}

