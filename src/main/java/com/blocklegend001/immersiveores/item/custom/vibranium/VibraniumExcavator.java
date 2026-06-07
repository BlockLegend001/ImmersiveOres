package com.blocklegend001.immersiveores.item.custom.vibranium;

import com.blocklegend001.immersiveores.ImmersiveOresClient;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.item.custom.base.Excavator;
import com.blocklegend001.immersiveores.util.map.RadiusMap;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Unit;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

public class VibraniumExcavator extends Excavator {

    private static Properties createSettings(Properties base, boolean unbreakable, int durability) {
        base.durability(durability).fireResistant();
        if (unbreakable) {
            base.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);
        }
        return base;
    }

    public VibraniumExcavator(ToolMaterial material, int attackDamage, float attackSpeed, Properties settings) {
        super(material, attackDamage, attackSpeed,
                createSettings(settings, VibraniumConfig.unbreakableVibranium, VibraniumConfig.durabilityVibranium));
    }

    @Override
    public Component getName(ItemStack stack) {
        return super.getName(stack).copy().withStyle(ChatFormatting.LIGHT_PURPLE);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltip, Consumer<Component> textConsumer, TooltipFlag options) {
        int radius = getRadiusForExcavator(stack);
        int widht = radius * 2 + 1;

        if (ImmersiveOresClient.isShiftKeyPressed()) {
            if (VibraniumConfig.unbreakableVibranium) {
                textConsumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
            }
            textConsumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
            Component text = Component.literal("Dig area: ")
                    .withStyle(ChatFormatting.LIGHT_PURPLE)
                    .append(Component.literal(widht + "x1").withStyle(ChatFormatting.YELLOW));

            textConsumer.accept(text);

            super.appendHoverText(stack, context, tooltip, textConsumer, options);
        } else {
            textConsumer.accept(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
        }
    }

    private int getRadiusForExcavator(ItemStack stack) {
        if (RadiusMap.VIBRANIUM_EXCAVATOR_RADIUS.containsKey(stack.getItem())) {
            return RadiusMap.VIBRANIUM_EXCAVATOR_RADIUS.get(stack.getItem());
        }
        return 0;
    }
}
