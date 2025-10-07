package com.blocklegend001.immersiveores.util.tools.bow;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public enum BowTiers implements BowTier {

    ENDERIUM(ImmersiveOres.ENDERIUM_CONFIG.toolTier().durability, ImmersiveOres.ENDERIUM_CONFIG.bow().damage, ImmersiveOres.ENDERIUM_CONFIG.bow().enchantmentValue, () -> {
        return Ingredient.ofItems(ModItems.ENDERIUM_INGOT);
    }),

    VIBRANIUM(ImmersiveOres.VIBRANIUM_CONFIG.toolTier().durability, ImmersiveOres.VIBRANIUM_CONFIG.bow().damage, ImmersiveOres.VIBRANIUM_CONFIG.bow().enchantmentValue, () -> {
        return Ingredient.ofItems(ModItems.VIBRANIUM_INGOT);
    }),

    VULPUS(VulpusConfig.durabilityVulpus, VulpusConfig.damageVulpusBow, VulpusConfig.enchantmentValueVulpusBow, () -> {
        return Ingredient.ofItems(ModItems.VULPUS_INGOT);
    });

    private final int uses;
    private final Double damage;
    private final int enchantmentValue;
    private final Lazy<Ingredient> repairIngredient;

    private BowTiers(int uses, Integer damage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.uses = uses;
        this.damage = Double.valueOf(damage);
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = new Lazy<Ingredient>(repairIngredient);
    }

    public int getUses() {
        return this.uses;
    }

    public Double getAttackDamageBonus() {
        return this.damage;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
