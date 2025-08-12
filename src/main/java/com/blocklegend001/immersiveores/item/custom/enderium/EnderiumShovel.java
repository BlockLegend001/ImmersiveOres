package com.blocklegend001.immersiveores.item.custom.enderium;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.item.ModToolMaterials;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class EnderiumShovel extends ShovelItem {
    private static Settings createSettings(Settings base, boolean unbreakable, int durability) {
        base.maxDamage(durability).fireproof();
        if (unbreakable) {
            base.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true));
        }
        return base;
    }

    public EnderiumShovel(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed,
                createSettings(settings, EnderiumConfig.unbreakableEnderium, EnderiumConfig.durabilityEnderium));
    }

    @Override
    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().formatted(Formatting.DARK_AQUA);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType options) {
        if(Screen.hasShiftDown()) {
            if (EnderiumConfig.unbreakableEnderium) {
                tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.DARK_AQUA));
            }
            tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.DARK_AQUA));
        } else {
            tooltip.add(Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").formatted(Formatting.DARK_AQUA));
        }
    }
}
