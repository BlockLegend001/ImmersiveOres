package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.util.ModTags;
import com.google.common.base.Suppliers;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {

    VIBRANIUM(ModTags.Blocks.INCORRECT_FOR_VIBRANIUM_TOOL,
            ImmersiveOres.VIBRANIUM_CONFIG.toolTier().durability,
            ImmersiveOres.VIBRANIUM_CONFIG.toolTier().speed,
            ImmersiveOres.VIBRANIUM_CONFIG.toolTier().attackDamageBonus,
            ImmersiveOres.VIBRANIUM_CONFIG.toolTier().enchantmentValue,
            () -> Ingredient.ofItems(ModItems.VIBRANIUM_INGOT)),

    VULPUS(ModTags.Blocks.INCORRECT_FOR_VULPUS_TOOL,
            VulpusConfig.durabilityVulpus,
            VulpusConfig.speedVulpusTier ,
            VulpusConfig.attackDamageBonusVulpusTier,
            VulpusConfig.enchantmentValueVulpusTier,
            () -> Ingredient.ofItems(ModItems.VULPUS_INGOT)),

    ENDERIUM(ModTags.Blocks.INCORRECT_FOR_ENDERIUM_TOOL,
            ImmersiveOres.ENDERIUM_CONFIG.toolTier().durability,
            ImmersiveOres.ENDERIUM_CONFIG.toolTier().speed,
            ImmersiveOres.ENDERIUM_CONFIG.toolTier().attackDamageBonus,
            ImmersiveOres.ENDERIUM_CONFIG.toolTier().enchantmentValue,
            () -> Ingredient.ofItems(ModItems.ENDERIUM_INGOT));

    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterials(final TagKey<Block> inverseTag, final int itemDurability,final float miningSpeed,
                     final float attackDamage, final int enchantability,final Supplier<Ingredient> repairIngredient) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
