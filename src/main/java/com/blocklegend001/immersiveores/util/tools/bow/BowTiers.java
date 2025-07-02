package com.blocklegend001.immersiveores.util.tools.bow;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public enum BowTiers implements BowTier {

    ENDERIUM(EnderiumConfig.DURABILITY_ENDERIUM.get(), EnderiumConfig.DAMAGE_ENDERIUM_BOW.get(), EnderiumConfig.ENCHANTMENT_VALUE_ENDERIUM_BOW.get(), () -> {
        return Ingredient.of(ModItems.ENDERIUM_INGOT);
    }),

    VIBRANIUM(VibraniumConfig.DURABILITY_VIBRANIUM.get(), VibraniumConfig.DAMAGE_VIBRANIUM_BOW.get(), VibraniumConfig.ENCHANTMENT_VALUE_VIBRANIUM_BOW.get(), () -> {
        return Ingredient.of(ModItems.VIBRANIUM_INGOT);
    }),

    VULPUS(VulpusConfig.DURABILITY_VULPUS.get(), VulpusConfig.DAMAGE_VULPUS_BOW.get(), VulpusConfig.ENCHANTMENT_VALUE_VULPUS_BOW.get(), () -> {
        return Ingredient.of(ModItems.VULPUS_INGOT);
    });

    private final int uses;
    private final Double damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    private BowTiers(int uses, Integer damage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.uses = uses;
        this.damage = Double.valueOf(damage);
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = new LazyLoadedValue<Ingredient>(repairIngredient);
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
