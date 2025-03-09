package com.blocklegend001.immersiveores.util;

import net.minecraft.recipe.Ingredient;

public interface BowTier {
    int getUses();

    Double getAttackDamageBonus();

    int getEnchantmentValue();

    Ingredient getRepairIngredient();
}
