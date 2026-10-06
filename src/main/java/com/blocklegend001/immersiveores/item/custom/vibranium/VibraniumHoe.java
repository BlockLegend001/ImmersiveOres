package com.blocklegend001.immersiveores.item.custom.vibranium;

import com.blocklegend001.immersiveores.ImmersiveOresClient;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Unit;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

public class VibraniumHoe extends Item {
    private static Item.Properties createSettings(ToolMaterial material, Item.Properties settings, float attackDamage, float attackSpeed, boolean unbreakable, int durability) {
        settings.hoe(wrapMaterial(material, material.durability()), attackDamage, attackSpeed)
                .durability(durability).fireResistant();
        if (unbreakable) {
            settings.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);
        }
        return settings;
    }

    public VibraniumHoe(ToolMaterial material, int attackDamage, float attackSpeed, Item.Properties settings) {
        super(createSettings(material, settings, attackDamage, attackSpeed, VibraniumConfig.unbreakableVibranium, VibraniumConfig.durabilityVibranium));
    }

    @Override
    public Component getName(ItemStack stack) {
        return super.getName(stack).copy().withStyle(ChatFormatting.LIGHT_PURPLE);
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
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltip, Consumer<Component> textConsumer, TooltipFlag options) {
        if(ImmersiveOresClient.isShiftKeyPressed()) {
            if (VibraniumConfig.unbreakableVibranium) {
                textConsumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
            }
            textConsumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
        } else {
            textConsumer.accept(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
        }
    }
}
