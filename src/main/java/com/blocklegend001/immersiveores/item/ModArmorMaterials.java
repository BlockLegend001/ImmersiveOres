package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {

    VIBRANIUM(
            "vibranium",
            VibraniumConfig.durabilityVibranium.get(),
            new int[] {
        VibraniumConfig.protectionValueVibraniumBoots.get(),
                VibraniumConfig.protectionValueVibraniumLeggings.get(),
                VibraniumConfig.protectionValueVibraniumChestplate.get(),
                VibraniumConfig.protectionValueVibraniumHelmet.get()
    },
    VibraniumConfig.enchantmentValueVibraniumArmor.get(),
    SoundEvents.ARMOR_EQUIP_NETHERITE,
    VibraniumConfig.toughnessValueVibraniumArmor.get(),
            VibraniumConfig.knockbackResistanceValueVibraniumArmor.get().floatValue(),
            () -> Ingredient.of(ModItems.VIBRANIUM_INGOT.get())
            ),

    VULPUS(
            "vulpus",
            VulpusConfig.durabilityVulpus.get(),
            new int[] {
        VulpusConfig.protectionValueVulpusBoots.get(),
                VulpusConfig.protectionValueVulpusLeggings.get(),
                VulpusConfig.protectionValueVulpusChestplate.get(),
                VulpusConfig.protectionValueVulpusHelmet.get()
    },
    VulpusConfig.enchantmentValueVulpusArmor.get(),
    SoundEvents.ARMOR_EQUIP_NETHERITE,
    VulpusConfig.toughnessValueVulpusArmor.get(),
            VulpusConfig.knockbackResistanceValueVulpusArmor.get().floatValue(),
            () -> Ingredient.of(ModItems.VULPUS_INGOT.get())
            ),

    ENDERIUM(
            "enderium",
            EnderiumConfig.durabilityEnderium.get(),
            new int[] {
        EnderiumConfig.protectionValueEnderiumBoots.get(),
                EnderiumConfig.protectionValueEnderiumLeggings.get(),
                EnderiumConfig.protectionValueEnderiumChestplate.get(),
                EnderiumConfig.protectionValueEnderiumHelmet.get()
    },
    EnderiumConfig.enchantmentValueEnderiumArmor.get(),
    SoundEvents.ARMOR_EQUIP_NETHERITE,
    EnderiumConfig.toughnessValueEnderiumArmor.get(),
            EnderiumConfig.knockbackResistanceValueEnderiumArmor.get().floatValue(),
            () -> Ingredient.of(ModItems.ENDERIUM_INGOT.get())
            );

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