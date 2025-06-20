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

    ENDERIUM(EnderiumConfig.durabilityEnderium.get(), EnderiumConfig.damageEnderiumBow.get(), EnderiumConfig.enchantmentValueEnderiumBow.get(), () -> {
        return Ingredient.of(ModItems.ENDERIUM_INGOT.get());
    }),

    VIBRANIUM(VibraniumConfig.durabilityVibranium.get(), VibraniumConfig.damageVibraniumBow.get(), VibraniumConfig.enchantmentValueVibraniumBow.get(), () -> {
        return Ingredient.of(ModItems.VIBRANIUM_INGOT.get());
    }),

    VULPUS(VulpusConfig.durabilityVulpus.get(), VulpusConfig.damageVulpusBow.get(), VulpusConfig.enchantmentValueVulpusBow.get(), () -> {
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
