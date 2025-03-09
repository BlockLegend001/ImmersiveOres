package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.util.ModTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public enum ModToolTiers implements Tier {

    VIBRANIUM(ModTags.Blocks.INCORRECT_FOR_VIBRANIUM_TOOL, 0, VibraniumConfig.speedVibraniumTier, VibraniumConfig.attackDamageBonusVibraniumTier, VibraniumConfig.enchantmentValueVibraniumTier, () -> Ingredient.of(ModItems.VIBRANIUM_INGOT.get())),
    VULPUS(ModTags.Blocks.INCORRECT_FOR_VULPUS_TOOL, 0, VulpusConfig.speedVulpusTier ,VulpusConfig.attackDamageBonusVulpusTier, VulpusConfig.enchantmentValueVulpusTier, () -> Ingredient.of(ModItems.VULPUS_INGOT.get())),
    ENDERIUM(ModTags.Blocks.INCORRECT_FOR_ENDERIUM_TOOL, 0, EnderiumConfig.speedEnderiumTier ,EnderiumConfig.attackDamageBonusEnderiumTier, EnderiumConfig.enchantmentValueEnderiumTier, () -> Ingredient.of(ModItems.ENDERIUM_INGOT.get()));

    private final TagKey<Block> incorrect;
    private final int uses;
    private final float speed;
    private final int damage;
    private final int enchantmentValue;
    private final Supplier<Ingredient> ingredient;

    ModToolTiers(TagKey<Block> incorrect, int uses, float speed, int damage, int enchantmentValue, Supplier<Ingredient> ingredient) {
        this.incorrect = incorrect;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.ingredient = ingredient;
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
        return this.damage;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return this.incorrect;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.ingredient.get();
    }
}


