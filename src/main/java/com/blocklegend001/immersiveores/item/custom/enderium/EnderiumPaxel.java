package com.blocklegend001.immersiveores.item.custom.enderium;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.item.custom.base.Paxel;
import com.blocklegend001.immersiveores.util.ModTags;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Unit;

import java.util.List;
import java.util.function.Consumer;

public class EnderiumPaxel extends Paxel {
    private static Settings createSettings(Settings base, boolean unbreakable, int durability) {
        base.maxDamage(durability).fireproof();
        if (unbreakable) {
            base.component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE);
        }
        return base;
    }

    public EnderiumPaxel(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, ModTags.Blocks.ENDERIUM_PAXEL_MINEABLE, attackDamage, attackSpeed,
                createSettings(settings, EnderiumConfig.unbreakableEnderium, EnderiumConfig.durabilityEnderium));
    }

    @Override
    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().formatted(Formatting.DARK_AQUA);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent tooltip, Consumer<Text> textConsumer, TooltipType options) {
        if(Screen.hasShiftDown()) {
            if (EnderiumConfig.unbreakableEnderium) {
                textConsumer.accept(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.DARK_AQUA));
            }
            textConsumer.accept(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.DARK_AQUA));
        } else {
            textConsumer.accept(Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").formatted(Formatting.DARK_AQUA));
        }
    }
}