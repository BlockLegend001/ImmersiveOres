package com.blocklegend001.immersiveores.item.custom.vulpus;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.Block;

import java.util.function.Consumer;

public class VulpusPickaxe extends Item {
    private static TagKey<Block> pickaxeMineable;

    public VulpusPickaxe(ToolMaterial material, float attackDamage, float attackSpeed, Item.Properties settings) {
        super(computeSettings(material, BlockTags.MINEABLE_WITH_PICKAXE, settings, attackDamage, attackSpeed));
    }

    private static Item.Properties computeSettings(ToolMaterial material, TagKey<Block> pickaxeMineable, Item.Properties settings, float attackDamage, float attackSpeed) {
        VulpusPickaxe.pickaxeMineable = pickaxeMineable;
        settings.pickaxe(wrapMaterial(material, material.durability()), attackDamage, attackSpeed);
        return settings;
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
    public void appendHoverText(ItemStack pStack, Item.TooltipContext p_333372_, TooltipDisplay p_396484_, Consumer<Component> consumer, TooltipFlag p_41424_) {
        super.appendHoverText(pStack, p_333372_, p_396484_, consumer, p_41424_);
        if(Screen.hasShiftDown()) {
            consumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.RED));
            consumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.RED));
        } else {
            consumer.accept(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.RED));
        }
    }
}
