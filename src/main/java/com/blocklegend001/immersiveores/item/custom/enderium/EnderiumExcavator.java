package com.blocklegend001.immersiveores.item.custom.enderium;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
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

public class EnderiumExcavator extends Excavator {

    private static Item.Settings createSettings(boolean unbreakable, int durability) {
        Item.Settings settings = new Item.Settings()
                .maxDamage(durability)
                .fireproof()
                .attributeModifiers(EnderiumExcavator.createAttributeModifiers(ModToolMaterials.ENDERIUM,
                        EnderiumConfig.attackDamageEnderiumExcavator, (float) EnderiumConfig.attackSpeedEnderiumExcavator));

        if (unbreakable) {
            settings.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true));
        }

        return settings;
    }

    public EnderiumExcavator(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material,
                createSettings(EnderiumConfig.unbreakableEnderium, EnderiumConfig.durabilityEnderium));
    }

    @Override
    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().formatted(Formatting.DARK_AQUA);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        int radius = getRadiusForExcavator(stack);
        int widht = radius * 2 + 1;

        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.DARK_AQUA));
            tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.DARK_AQUA));
            Text text = Text.literal("Dig area: ")
                    .formatted(Formatting.DARK_AQUA)
                    .append(Text.literal(widht + "x1").formatted(Formatting.YELLOW));

            tooltip.add(text);

            super.appendTooltip(stack, context, tooltip, options);
        } else {
            tooltip.add(Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").formatted(Formatting.DARK_AQUA));
        }
    }

    private int getRadiusForExcavator(ItemStack stack) {
        if (RadiusMap.ENDERIUM_EXCAVATOR_RADIUS.containsKey(stack.getItem())) {
            return RadiusMap.ENDERIUM_EXCAVATOR_RADIUS.get(stack.getItem());
        }
        return 0;
    }
}