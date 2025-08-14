package com.blocklegend001.immersiveores.item.custom.vulpus;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.item.ModToolMaterials;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class VulpusPickaxe extends PickaxeItem {
    private static Settings createSettings(boolean unbreakable, int durability) {
        var base = VulpusPickaxe.createAttributeModifiers(
                        ModToolMaterials.VULPUS,
                        VulpusConfig.attackDamageVulpusPickaxe,
                        (float) VulpusConfig.attackSpeedVulpusPickaxe
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

    public VulpusPickaxe(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material,
                createSettings(VulpusConfig.unbreakableVulpus, VulpusConfig.durabilityVulpus));
    }

    @Override
    public boolean isEnchantable(ItemStack p_41456_) {
        return true;
    }

    @Override
    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().formatted(Formatting.RED);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType options) {
        if(Screen.hasShiftDown()) {
            if (VulpusConfig.unbreakableVulpus) {
                tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.RED));
            }
            tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.RED));
        } else {
            tooltip.add(Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").formatted(Formatting.RED));
        }
    }
}
