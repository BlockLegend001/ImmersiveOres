package com.blocklegend001.immersiveores.util;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public enum BowTiers implements BowTier {

    ENDERIUM(0, EnderiumConfig.damageEnderiumBow, EnderiumConfig.enchantmentValueEnderiumBow, () -> {
        return Ingredient.of(ModItems.ENDERIUM_INGOT.get());
    }),

    VIBRANIUM(0, VibraniumConfig.damageVibraniumBow, VibraniumConfig.enchantmentValueVibraniumBow, () -> {
        return Ingredient.of(ModItems.VIBRANIUM_INGOT.get());
    }),

    VULPUS(0, VulpusConfig.damageVulpusBow, VulpusConfig.enchantmentValueVulpusBow, () -> {
        return Ingredient.of(ModItems.VULPUS_INGOT.get());
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
