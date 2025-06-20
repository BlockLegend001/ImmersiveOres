package com.blocklegend001.immersiveores.item.custom.vibranium;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.item.ModToolTiers;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.Unbreakable;

import java.util.List;

public class VibraniumSword extends SwordItem {
    private static Properties createSettings(boolean unbreakable, int durability) {
        Properties settings = new Properties()
                .durability(durability)
                .attributes(VibraniumSword.createAttributes(
                        ModToolTiers.VIBRANIUM,
                        VibraniumConfig.attackDamageVibraniumSword.get(),
                        (float) VibraniumConfig.attackSpeedVibraniumSword.get().doubleValue()
                ));

        if (unbreakable) {
            settings.component(DataComponents.UNBREAKABLE, new Unbreakable(true));
        }
        return settings;
    }

    public VibraniumSword(Tier p_42961_, int p_42962_, float p_42963_, Properties p_42964_) {
        super(p_42961_, createSettings(VibraniumConfig.unbreakableVibranium.get(), VibraniumConfig.durabilityVibranium.get()));
    }

    @Override
    public boolean isEnchantable(ItemStack p_41456_) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> components, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()) {
            if (VibraniumConfig.unbreakableVibranium.get()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
            }            components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
        } else {
            components.add(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
        }
    }
}
