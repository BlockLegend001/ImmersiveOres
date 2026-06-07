package com.blocklegend001.immersiveores.item.custom.vulpus;

import com.blocklegend001.immersiveores.ImmersiveOresClient;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Unit;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

public class VulpusHoe extends HoeItem {
    private static Properties createSettings(Properties base, boolean unbreakable, int durability) {
        base.durability(durability).fireResistant();
        if (unbreakable) {
            base.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);
        }
        return base;
    }

    public VulpusHoe(ToolMaterial material, int attackDamage, float attackSpeed, Properties settings) {
        super(material, attackDamage, attackSpeed,
                createSettings(settings, VulpusConfig.unbreakableVulpus, VulpusConfig.durabilityVulpus));
    }

    @Override
    public Component getName(ItemStack stack) {
        return super.getName(stack).copy().withStyle(ChatFormatting.RED);
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
