package com.blocklegend001.immersiveores.util;

import com.blocklegend001.immersiveores.ImmersiveOresConfig;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public enum BowTiers implements BowTier {

    ENDERIUM(0, ImmersiveOresConfig.damageVibraniumBow.get(), ImmersiveOresConfig.enchantmentValueEnderiumBow.get(), () -> {
        return Ingredient.of(ModItems.ENDERIUM_INGOT.get());
    }),

    VIBRANIUM(0, ImmersiveOresConfig.damageVibraniumBow.get(), ImmersiveOresConfig.enchantmentValueVibraniumBow.get(), () -> {
        return Ingredient.of(ModItems.VIBRANIUM_INGOT.get());
    }),

    VULPUS(0, ImmersiveOresConfig.damageVulpusBow.get(), ImmersiveOresConfig.enchantmentValueVulpusBow.get(), () -> {
        return Ingredient.of(ModItems.VULPUS_INGOT.get());
    });

    private final int uses;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    private BowTiers(int uses, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.uses = uses;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = new LazyLoadedValue<Ingredient>(repairIngredient);
    }

    public int getUses() {
        return this.uses;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
