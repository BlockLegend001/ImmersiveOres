package com.blocklegend001.immersiveores.item.custom.vibranium;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.item.ModToolTiers;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.Unbreakable;

import java.util.List;

public class VibraniumHoe extends HoeItem {
    private static Properties createSettings(boolean unbreakable, int durability) {
        Properties settings = new Properties()
                .durability(durability)
                .attributes(VibraniumHoe.createAttributes(
                        ModToolTiers.VIBRANIUM,
                        VibraniumConfig.ATTACK_DAMAGE_VIBRANIUM_HOE.get(),
                        (float) VibraniumConfig.ATTACK_SPEED_VIBRANIUM_HOE.get().doubleValue()
                ));

        if (unbreakable) {
            settings.component(DataComponents.UNBREAKABLE, new Unbreakable(true));
        }
        return settings;
    }

    public VibraniumHoe(Tier p_42961_, int p_42962_, float p_42963_, Properties p_42964_) {
        super(p_42961_, createSettings(VibraniumConfig.UNBREAKABLE_VIBRANIUM.get(), VibraniumConfig.DURABILITY_VIBRANIUM.get()));
    }

    @Override
    public Component getName(ItemStack stack) {
        return super.getName(stack).copy().withStyle(ChatFormatting.LIGHT_PURPLE);
    }

    @Override
    public boolean isEnchantable(ItemStack p_41456_) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> components, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()) {
            if (VibraniumConfig.UNBREAKABLE_VIBRANIUM.get()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
            }
            components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
        } else {
            components.add(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
        }
    }
}
