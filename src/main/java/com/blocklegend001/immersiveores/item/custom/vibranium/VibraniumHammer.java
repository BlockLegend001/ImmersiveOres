package com.blocklegend001.immersiveores.item.custom.vibranium;

import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.item.ModToolTiers;
import com.blocklegend001.immersiveores.item.custom.base.Hammer;
import com.blocklegend001.immersiveores.util.map.RadiusMap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Unit;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.List;
import java.util.function.Consumer;

public class VibraniumHammer extends Hammer {
    private static Properties createSettings(Properties properties, boolean unbreakable, int durability) {
        properties.durability(durability);

        if (unbreakable) {
            properties.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);
        }
        return properties;
    }

    public VibraniumHammer(ModToolTiers pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, createSettings(pProperties, VibraniumConfig.unbreakableVibranium.get(), VibraniumConfig.durabilityVibranium.get()));
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> consumer, TooltipFlag tooltipFlag) {
        super.appendHoverText(pStack, context, tooltipDisplay, consumer, tooltipFlag);
        int radius = getRadiusForHammer(pStack);
        int widht = radius * 2 + 1;

        if(Screen.hasShiftDown()) {
            if (VibraniumConfig.unbreakableVibranium.get()) {
                consumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
            }
            consumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));

            Component text = Component.literal("Dig area: ")
                    .withStyle(ChatFormatting.LIGHT_PURPLE)
                    .append(Component.literal(widht + "x1").withStyle(ChatFormatting.YELLOW));

            consumer.accept(text);
        } else {
            consumer.accept(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
        }
    }

    private int getRadiusForHammer(ItemStack stack) {
        if (RadiusMap.getHammerRadius().containsKey(stack.getItem())) {
            return RadiusMap.getHammerRadius().get(stack.getItem());
        }
        return 0;
    }
}

