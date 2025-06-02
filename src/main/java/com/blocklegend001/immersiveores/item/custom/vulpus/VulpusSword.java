package com.blocklegend001.immersiveores.item.custom.vulpus;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;
import java.util.function.Consumer;

public class VulpusSword extends Item {
    public VulpusSword(ToolMaterial material, float attackDamage, float attackSpeed, Item.Settings settings) {
        super(computeSettings(material, settings, attackDamage, attackSpeed));
    }

    private static Item.Settings computeSettings(ToolMaterial material, Item.Settings settings, float attackDamage, float attackSpeed) {
        settings.sword(wrapMaterial(material, material.durability()), attackDamage, attackSpeed);
        return settings;
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setOnFireFor(15);
        super.postHit(stack, target, attacker);
    }

    private static ToolMaterial wrapMaterial(ToolMaterial toolMaterial, int durability) {
        return new ToolMaterial(
                toolMaterial.incorrectBlocksForDrops(),
                durability,
                toolMaterial.speed(),
                toolMaterial.attackDamageBonus(),
                toolMaterial.enchantmentValue(),
                toolMaterial.repairItems()
        );
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        if(Screen.hasShiftDown()) {
            textConsumer.accept(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.RED));
            textConsumer.accept(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.RED));
            textConsumer.accept(Text.translatable("tooltip.immersiveores.cansetmobonfire.tooltip").formatted(Formatting.RED));
        } else {
            textConsumer.accept(Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").formatted(Formatting.RED));
        }
    }
}