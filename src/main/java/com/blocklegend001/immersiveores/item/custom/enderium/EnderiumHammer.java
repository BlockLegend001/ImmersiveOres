package com.blocklegend001.immersiveores.item.custom.enderium;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.item.custom.base.Hammer;
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

public class EnderiumHammer extends Hammer {
    private static Properties createSettings(Properties properties, boolean unbreakable, int durability) {
        properties.durability(durability);

        if (unbreakable) {
            properties.component(DataComponents.UNBREAKABLE, new Unbreakable(true));
        }
        return properties;
    }

    public EnderiumHammer(ToolMaterial pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, createSettings(pProperties, EnderiumConfig.unbreakableEnderium.get(), EnderiumConfig.durabilityEnderium.get()));
    }

    @Override
    public Component getName(ItemStack stack) {
        return super.getName(stack).copy().withStyle(ChatFormatting.DARK_AQUA);
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> components, TooltipFlag pTooltipFlag) {
        int radius = getRadiusForHammer(pStack);
        int widht = radius * 2 + 1;

        if(Screen.hasShiftDown()) {
            if (EnderiumConfig.unbreakableEnderium.get()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.DARK_AQUA));
            }
            components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));

            Component text = Component.literal("Dig area: ")
                    .withStyle(ChatFormatting.DARK_AQUA)
                    .append(Component.literal(widht + "x1").withStyle(ChatFormatting.YELLOW));

            components.add(text);
        } else {
            components.add(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.DARK_AQUA));
        }
    }

    private int getRadiusForHammer(ItemStack stack) {
        if (RadiusMap.getHammerRadius().containsKey(stack.getItem())) {
            return RadiusMap.getHammerRadius().get(stack.getItem());
        }
        return 0;
    }
}

