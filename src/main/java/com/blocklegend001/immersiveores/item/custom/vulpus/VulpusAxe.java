package com.blocklegend001.immersiveores.item.custom.vulpus;

import com.blocklegend001.immersiveores.ImmersiveOresClient;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Unit;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

public class VulpusAxe extends Item {
    public VulpusAxe(ToolMaterial material, float attackDamage, float attackSpeed, Properties settings) {
        super(computeSettings(material, settings, attackDamage, attackSpeed, VulpusConfig.unbreakableVulpus, VulpusConfig.durabilityVulpus));
    }

    private static Properties computeSettings(ToolMaterial material, Properties settings, float attackDamage, float attackSpeed, boolean unbreakable, int durability) {
        settings.axe(wrapMaterial(material, material.durability()), attackDamage, attackSpeed)
                .durability(durability).fireResistant();
        if (unbreakable) {
            settings.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);
        }
        return settings;
    }

    @Override
    public Component getName(ItemStack stack) {
        return super.getName(stack).copy().withStyle(ChatFormatting.RED);
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
            if (VulpusConfig.unbreakableVulpus) {
                textConsumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.RED));
            }
            textConsumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.RED));
        } else {
            textConsumer.accept(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.RED));
        }
    }
}
