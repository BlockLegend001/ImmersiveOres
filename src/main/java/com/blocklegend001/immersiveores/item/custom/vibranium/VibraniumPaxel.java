package com.blocklegend001.immersiveores.item.custom.vibranium;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.item.ModToolMaterials;
import com.blocklegend001.immersiveores.item.custom.base.Paxel;
import com.blocklegend001.immersiveores.util.ModTags;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class VibraniumPaxel extends Paxel {
    private static Settings createSettings(boolean unbreakable, int durability) {
        Settings settings = new Settings()
                .maxDamage(durability)
                .fireproof()
                .attributeModifiers(VibraniumPaxel.createAttributeModifiers(ModToolMaterials.VIBRANIUM,
                        VibraniumConfig.attackDamageVibraniumPaxel, (float) VibraniumConfig.attackSpeedVibraniumPaxel));

        if (unbreakable) {
            settings.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true));
        }

        return settings;
    }

    public VibraniumPaxel(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material, ModTags.Blocks.VIBRANIUM_PAXEL_MINEABLE,
                createSettings(VibraniumConfig.unbreakableVibranium, VibraniumConfig.durabilityVibranium));
    }

    @Override
    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().formatted(Formatting.LIGHT_PURPLE);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType options) {
        if(Screen.hasShiftDown()) {
            if (VibraniumConfig.unbreakableVibranium) {
                tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.LIGHT_PURPLE));
            }
            tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.LIGHT_PURPLE));
        } else {
            tooltip.add(Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").formatted(Formatting.LIGHT_PURPLE));
        }
    }
}
