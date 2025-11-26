package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.util.ModTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public enum ModToolTiers implements Tier {

    VIBRANIUM(ModTags.Blocks.INCORRECT_FOR_VIBRANIUM_TOOL, VibraniumConfig.durabilityVibranium.get(), VibraniumConfig.speedVibraniumTier.get() ,VibraniumConfig.attackDamageBonusVibraniumTier.get(), VibraniumConfig.enchantmentValueVibraniumTier.get(), () -> Ingredient.of(ModItems.VIBRANIUM_INGOT.get()), 5),
    VULPUS(ModTags.Blocks.INCORRECT_FOR_VULPUS_TOOL, VulpusConfig.durabilityVulpus.get(), VulpusConfig.speedVulpusTier.get() ,VulpusConfig.attackDamageBonusVulpusTier.get(), VulpusConfig.enchantmentValueVulpusTier.get(), () -> Ingredient.of(ModItems.VULPUS_INGOT.get()), 6),
    ENDERIUM(ModTags.Blocks.INCORRECT_FOR_ENDERIUM_TOOL, EnderiumConfig.durabilityEnderium.get(), EnderiumConfig.speedEnderiumTier.get() ,EnderiumConfig.attackDamageBonusEnderiumTier.get(), EnderiumConfig.enchantmentValueEnderiumTier.get(), () -> Ingredient.of(ModItems.ENDERIUM_INGOT.get()), 7);

    private final TagKey<Block> incorrectBlocks;
    private final int uses;
    private final float speed;
    private final float attackDamage;
    private final int enchantmentValue;
    private final Supplier<Ingredient> repairIngredient;
    private final int level;

    ModToolTiers(
            TagKey<Block> incorrectBlocks,
            int uses, float speed,
            float attackDamage, int enchantmentValue,
            Supplier<Ingredient> repairIngredient,
            int level
    ) {
        this.incorrectBlocks = incorrectBlocks;
        this.uses = uses;
        this.speed = speed;
        this.attackDamage = attackDamage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = repairIngredient;
        this.level = level;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.attackDamage;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}