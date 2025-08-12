package com.blocklegend001.immersiveores.item.custom.vibranium;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.item.ModToolMaterials;
import com.blocklegend001.immersiveores.item.custom.base.Excavator;
import com.blocklegend001.immersiveores.util.map.RadiusMap;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class VibraniumExcavator extends Excavator {
    private static Settings createSettings(Settings base, boolean unbreakable, int durability) {
        base.maxDamage(durability).fireproof();
        if (unbreakable) {
            base.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true));
        }
        return base;
    }

    public VibraniumExcavator(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed,
                createSettings(settings, VibraniumConfig.unbreakableVibranium, VibraniumConfig.durabilityVibranium));
    }

    @Override
    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().formatted(Formatting.LIGHT_PURPLE);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType options) {
        int radius = getRadiusForExcavator(stack);
        int widht = radius * 2 + 1;

        if (Screen.hasShiftDown()) {
            if (VibraniumConfig.unbreakableVibranium) {
                tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.LIGHT_PURPLE));
            }
            tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.LIGHT_PURPLE));
            Text text = Text.literal("Dig area: ")
                    .formatted(Formatting.LIGHT_PURPLE)
                    .append(Text.literal(widht + "x1").formatted(Formatting.YELLOW));

            tooltip.add(text);

            super.appendTooltip(stack, context, tooltip, options);
        } else {
            tooltip.add(Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").formatted(Formatting.LIGHT_PURPLE));
        }
    }

    private int getRadiusForExcavator(ItemStack stack) {
        if (RadiusMap.VIBRANIUM_EXCAVATOR_RADIUS.containsKey(stack.getItem())) {
            return RadiusMap.VIBRANIUM_EXCAVATOR_RADIUS.get(stack.getItem());
        }
        return 0;
    }
}
