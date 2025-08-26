package com.blocklegend001.immersiveores.item.custom.vulpus;

import com.blocklegend001.immersiveores.config.VulpusConfig;
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

public class VulpusHoe extends HoeItem {
    private static Properties createSettings(boolean unbreakable, int durability) {
        Properties settings = new Properties()
                .durability(durability)
                .attributes(VulpusHoe.createAttributes(
                        ModToolTiers.VULPUS,
                        VulpusConfig.ATTACK_DAMAGE_VULPUS_HOE.get(),
                        (float) VulpusConfig.ATTACK_SPEED_VULPUS_HOE.get().doubleValue()
                ));

        if (unbreakable) {
            settings.component(DataComponents.UNBREAKABLE, new Unbreakable(true));
        }
        return settings;
    }

    public VulpusHoe(Tier p_42961_, int p_42962_, float p_42963_, Properties p_42964_) {
        super(p_42961_, createSettings(VulpusConfig.UNBREAKABLE_VULPUS.get(), VulpusConfig.DURABILITY_VULPUS.get()));
    }

    @Override
    public Component getName(ItemStack stack) {
        return super.getName(stack).copy().withStyle(ChatFormatting.RED);
    }

    @Override
    public boolean isEnchantable(ItemStack p_41456_) {
        return true;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> components, TooltipFlag pTooltipFlag) {
        if(Screen.hasShiftDown()) {
            if (VulpusConfig.UNBREAKABLE_VULPUS.get()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.RED));
            }
            components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.RED));
        } else {
            components.add(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.RED));
        }
    }
}
