package com.blocklegend001.immersiveores.item.custom.vulpus;

import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.item.ModToolMaterials;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class VulpusAxe extends AxeItem {
    private static Item.Settings createSettings(boolean unbreakable, int durability) {
        Item.Settings settings = new Item.Settings()
                .maxDamage(durability)
                .fireproof()
                .attributeModifiers(VulpusAxe.createAttributeModifiers(ModToolMaterials.VULPUS,
                        VulpusConfig.attackDamageVulpusAxe, (float) VulpusConfig.attackSpeedVulpusAxe));

        if (unbreakable) {
            settings.component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true));
        }

        return settings;
    }

    public VulpusAxe(ToolMaterial material, int attackDamage, float attackSpeed) {
        super(material,
                createSettings(VulpusConfig.unbreakableVulpus, VulpusConfig.durabilityVulpus));
    }


    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
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
