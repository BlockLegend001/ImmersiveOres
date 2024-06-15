package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.ImmersiveOresConfig;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {

    VIBRANIUM("vibranium", 0, new int[]{ImmersiveOresConfig.protectionValueVibraniumBoots.get(), ImmersiveOresConfig.protectionValueVibraniumLeggings.get(), ImmersiveOresConfig.protectionValueVibraniumChestplate.get(), ImmersiveOresConfig.protectionValueVibraniumHelmet.get()}, ImmersiveOresConfig.enchantmentValueVibraniumArmor.get(),
            SoundEvents.ARMOR_EQUIP_NETHERITE, ImmersiveOresConfig.toughnessValueVibraniumArmor.get(), ImmersiveOresConfig.knockbackResistanceValueVibraniumArmor.get(),
            () -> Ingredient.of(ModItems.VIBRANIUM_INGOT.get())),

    VULPUS("vulpus", 0, new int[]{ImmersiveOresConfig.protectionValueVulpusBoots.get(), ImmersiveOresConfig.protectionValueVulpusLeggings.get(), ImmersiveOresConfig.protectionValueVulpusChestplate.get(), ImmersiveOresConfig.protectionValueVulpusHelmet.get()}, ImmersiveOresConfig.enchantmentValueVulpusArmor.get(),
            SoundEvents.ARMOR_EQUIP_NETHERITE, ImmersiveOresConfig.toughnessValueVulpusArmor.get(), ImmersiveOresConfig.knockbackResistanceValueVulpusArmor.get(),
            () -> Ingredient.of(ModItems.VULPUS_INGOT.get())),

    ENDERIUM("enderium", 0, new int[]{ImmersiveOresConfig.protectionValueEnderiumBoots.get(), ImmersiveOresConfig.protectionValueEnderiumLeggings.get(), ImmersiveOresConfig.protectionValueEnderiumChestplate.get(), ImmersiveOresConfig.protectionValueEnderiumHelmet.get()}, ImmersiveOresConfig.enchantmentValueEnderiumArmor.get(),
            SoundEvents.ARMOR_EQUIP_NETHERITE, ImmersiveOresConfig.toughnessValueEnderiumArmor.get(), ImmersiveOresConfig.knockbackResistanceValueEnderiumArmor.get(),
            () -> Ingredient.of(ModItems.ENDERIUM_INGOT.get()));

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 11, 16, 16, 13 };

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue, SoundEvent equipSound,
                      float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return BASE_DURABILITY[pType.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionAmounts[pType.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return ImmersiveOres.MODID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}