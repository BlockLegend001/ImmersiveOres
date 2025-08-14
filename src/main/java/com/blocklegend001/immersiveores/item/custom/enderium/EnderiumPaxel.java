package com.blocklegend001.immersiveores.item.custom.enderium;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.item.ModToolMaterials;
import com.blocklegend001.immersiveores.item.custom.base.Paxel;
import com.blocklegend001.immersiveores.util.ModTags;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class EnderiumPaxel extends Paxel {
    private static Item.Settings createSettings(boolean unbreakable, int durability) {
        var base = EnderiumPaxel.createAttributeModifiers(
                        ModToolMaterials.ENDERIUM,
                        EnderiumConfig.attackDamageEnderiumPaxel,
                        (float) EnderiumConfig.attackSpeedEnderiumPaxel
                )
                .with(
                        EntityAttributes.PLAYER_BLOCK_INTERACTION_RANGE,
                        new EntityAttributeModifier(
                                Identifier.of(ImmersiveOres.MOD_ID, "enderium_block_reach"),
                                EnderiumConfig.blockRangeEnderiumTool,
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

    public EnderiumPaxel(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, ModTags.Blocks.ENDERIUM_PAXEL_MINEABLE,
                createSettings(EnderiumConfig.unbreakableEnderium, EnderiumConfig.durabilityEnderium));
    }

    @Override
    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().formatted(Formatting.DARK_AQUA);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
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