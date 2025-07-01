package com.blocklegend001.immersiveores.item.custom.vibranium;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.item.ModToolTiers;
import com.blocklegend001.immersiveores.item.custom.base.Excavator;
import com.blocklegend001.immersiveores.item.custom.vulpus.VulpusAxe;
import com.blocklegend001.immersiveores.item.custom.vulpus.VulpusExcavator;
import com.blocklegend001.immersiveores.util.map.RadiusMap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.Unbreakable;

import java.util.List;

public class VibraniumExcavator extends Excavator {
    private static Properties createSettings(boolean unbreakable, int durability) {
        Properties settings = new Properties()
                .durability(durability)
                .attributes(VulpusExcavator.createAttributes(
                        ModToolTiers.VIBRANIUM,
                        VibraniumConfig.attackDamageVibraniumExcavator.get(),
                        (float) VibraniumConfig.attackSpeedVibraniumExcavator.get().doubleValue()
                ));

        if (unbreakable) {
            settings.component(DataComponents.UNBREAKABLE, new Unbreakable(true));
        }
        return settings;
    }

    public VibraniumExcavator(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, createSettings(VibraniumConfig.unbreakableVibranium.get(), VibraniumConfig.durabilityVibranium.get()));
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> components, TooltipFlag pTooltipFlag) {
        int radius = getRadiusForHammer(pStack);
        int widht = radius * 2 + 1;

        if(Screen.hasShiftDown()) {
            if (VibraniumConfig.unbreakableVibranium.get()) {
                components.add(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
            }
            components.add(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));

            Component text = Component.literal("Dig area: ")
                    .withStyle(ChatFormatting.GRAY)
                    .append(Component.literal(widht + "x1").withStyle(ChatFormatting.YELLOW));

            components.add(text);
        } else {
            components.add(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
        }
    }

    private int getRadiusForHammer(ItemStack stack) {
        if (RadiusMap.getExcavatorRadius().containsKey(stack.getItem())) {
            return RadiusMap.getExcavatorRadius().get(stack.getItem());
        }
        return 0;
    }
}
