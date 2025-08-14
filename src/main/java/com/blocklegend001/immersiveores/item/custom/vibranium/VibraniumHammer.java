package com.blocklegend001.immersiveores.item.custom.vibranium;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.item.ModToolMaterials;
import com.blocklegend001.immersiveores.item.custom.base.Hammer;
import com.blocklegend001.immersiveores.util.map.RadiusMap;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class VibraniumHammer extends Hammer {
    private static Item.Settings createSettings(boolean unbreakable, int durability) {
        var base = VibraniumHammer.createAttributeModifiers(
                        ModToolMaterials.VIBRANIUM,
                        VibraniumConfig.attackDamageVibraniumHammer,
                        (float) VibraniumConfig.attackSpeedVibraniumHammer
                )
                .with(
                        EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE,
                        new EntityAttributeModifier(
                                Identifier.of(ImmersiveOres.MOD_ID, "vibranium_block_reach"),
                                VibraniumConfig.blockRangeVibraniumTool,
                                EntityAttributeModifier.Operation.ADD_VALUE
                        ),
                        AttributeModifierSlot.MAINHAND
                );

        Item.Settings settings = new Item.Settings()
                .maxDamage(durability)
                .fireproof()
                .attributeModifiers(base);

        if (unbreakable) {
            settings.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true));
        }

        return settings;
    }

    public VibraniumHammer(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material,
                createSettings(VibraniumConfig.unbreakableVibranium, VibraniumConfig.durabilityVibranium));
    }

    @Override
    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().formatted(Formatting.LIGHT_PURPLE);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        int radius = getRadiusForHammer(stack);
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

    private int getRadiusForHammer(ItemStack stack) {
        if (RadiusMap.VIBRANIUM_HAMMER_RADIUS.containsKey(stack.getItem())) {
            return RadiusMap.VIBRANIUM_HAMMER_RADIUS.get(stack.getItem());
        }
        return 0;
    }
}