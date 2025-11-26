package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {

    VIBRANIUM(
            4,
            ModTags.Blocks.INCORRECT_FOR_VIBRANIUM_TOOL,
            VibraniumConfig.durabilityVibranium,
            VibraniumConfig.speedVibraniumTier,
            VibraniumConfig.attackDamageBonusVibraniumTier,
            VibraniumConfig.enchantmentValueVibraniumTier,
            () -> Ingredient.ofItems(ModItems.VIBRANIUM_INGOT)
    ),

    VULPUS(
            4,
            ModTags.Blocks.INCORRECT_FOR_VULPUS_TOOL,
            VulpusConfig.durabilityVulpus,
            VulpusConfig.speedVulpusTier,
            VulpusConfig.attackDamageBonusVulpusTier,
            VulpusConfig.enchantmentValueVulpusTier,
            () -> Ingredient.ofItems(ModItems.VULPUS_INGOT)
    ),

    ENDERIUM(
            5,
            ModTags.Blocks.INCORRECT_FOR_ENDERIUM_TOOL,
            EnderiumConfig.durabilityEnderium,
            EnderiumConfig.speedEnderiumTier,
            EnderiumConfig.attackDamageBonusEnderiumTier,
            EnderiumConfig.enchantmentValueEnderiumTier,
            () -> Ingredient.ofItems(ModItems.ENDERIUM_INGOT)
    );

    private final int miningLevel;
    private final TagKey<Block> incorrectTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterials(int miningLevel,
                     TagKey<Block> incorrectTag,
                     int itemDurability,
                     float miningSpeed,
                     float attackDamage,
                     int enchantability,
                     Supplier<Ingredient> repairIngredient) {

        this.miningLevel = miningLevel;
        this.incorrectTag = incorrectTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    public TagKey<Block> getIncorrectTag() {
        return incorrectTag;
    }

    @Override
    public int getDurability() {
        return itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return miningLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }
}
