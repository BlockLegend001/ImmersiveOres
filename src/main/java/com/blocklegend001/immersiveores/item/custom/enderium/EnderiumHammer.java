package com.blocklegend001.immersiveores.item.custom.enderium;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.item.custom.base.Hammer;
import com.blocklegend001.immersiveores.util.map.RadiusMap;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Unit;

import java.util.function.Consumer;

public class EnderiumHammer extends Hammer {

    private static Settings createSettings(Settings base, boolean unbreakable, int durability) {
        base.maxDamage(durability).fireproof();
        if (unbreakable) {
            base.component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE);
        }
        return base;
    }

    public EnderiumHammer(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed,
                createSettings(settings, EnderiumConfig.unbreakableEnderium, EnderiumConfig.durabilityEnderium));
    }


    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent tooltip, Consumer<Text> textConsumer, TooltipType options) {
        int radius = getRadiusForHammer(stack);
        int widht = radius * 2 + 1;

        if (Screen.hasShiftDown()) {
            textConsumer.accept(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.DARK_AQUA));
            textConsumer.accept(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.DARK_AQUA));
            Text text = Text.literal("Dig area: ")
                    .formatted(Formatting.DARK_AQUA)
                    .append(Text.literal(widht + "x1").formatted(Formatting.YELLOW));

            textConsumer.accept(text);

            super.appendTooltip(stack, context, tooltip, textConsumer, options);
        } else {
            textConsumer.accept(Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").formatted(Formatting.DARK_AQUA));
        }
    }

    private int getRadiusForHammer(ItemStack stack) {
        if (RadiusMap.ENDERIUM_HAMMER_RADIUS.containsKey(stack.getItem())) {
            return RadiusMap.ENDERIUM_HAMMER_RADIUS.get(stack.getItem());
        }
        return 0;
    }
}

