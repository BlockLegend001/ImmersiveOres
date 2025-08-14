package com.blocklegend001.immersiveores.item.custom.vulpus;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.config.VulpusConfig;
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

public class VulpusHammer extends Hammer {
    private static Settings createSettings(boolean unbreakable, int durability) {
        var base = VulpusHammer.createAttributeModifiers(
                        ModToolMaterials.VULPUS,
                        VulpusConfig.attackDamageVulpusHammer,
                        (float) VulpusConfig.attackSpeedVulpusHammer
                )
                .with(
                        EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE,
                        new EntityAttributeModifier(
                                Identifier.of(ImmersiveOres.MOD_ID, "vulpus_block_reach"),
                                VulpusConfig.blockRangeVulpusTool,
                                EntityAttributeModifier.Operation.ADD_VALUE
                        ),
                        AttributeModifierSlot.MAINHAND
                );

        Settings settings = new Settings()
                .maxDamage(durability)
                .fireproof()
                .attributeModifiers(base);

        if (unbreakable) {
            settings.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true));
        }

        return settings;
    }

    public VulpusHammer(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material,
                createSettings(VulpusConfig.unbreakableVulpus, VulpusConfig.durabilityVulpus));
    }

    @Override
    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().formatted(Formatting.RED);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType options) {
        int radius = getRadiusForHammer(stack);
        int widht = radius * 2 + 1;

        if (Screen.hasShiftDown()) {
            if (VulpusConfig.unbreakableVulpus) {
                tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.RED));
            }
            tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.RED));
            Text text = Text.literal("Dig area: ")
                    .formatted(Formatting.RED)
                    .append(Text.literal(widht + "x1").formatted(Formatting.YELLOW));

            tooltip.add(text);

            super.appendTooltip(stack, context, tooltip, options);
        } else {
            tooltip.add(Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").formatted(Formatting.RED));
        }
    }

    private int getRadiusForHammer(ItemStack stack) {
        if (RadiusMap.VULPUS_HAMMER_RADIUS.containsKey(stack.getItem())) {
            return RadiusMap.VULPUS_HAMMER_RADIUS.get(stack.getItem());
        }
        return 0;
    }
}