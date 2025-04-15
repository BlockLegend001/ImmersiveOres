package com.blocklegend001.immersiveores.util;

import net.minecraft.world.item.crafting.Ingredient;

public interface BowTier {
    int getUses();

    Double getAttackDamageBonus();

    int getEnchantmentValue();

    Ingredient getRepairIngredient();
}
