package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial{

    VIBRANIUM(
            "vibranium",
            VibraniumConfig.durabilityVibranium,
            new int[] {
                    VibraniumConfig.protectionValueVibraniumBoots,
                    VibraniumConfig.protectionValueVibraniumLeggings,
                    VibraniumConfig.protectionValueVibraniumChestplate,
                    VibraniumConfig.protectionValueVibraniumHelmet
            },
            VibraniumConfig.enchantmentValueVibraniumArmor,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            VibraniumConfig.toughnessValueVibraniumArmor,
            (float) VibraniumConfig.knockbackResistanceValueVibraniumArmor,
            () -> Ingredient.ofItems(ModItems.VIBRANIUM_INGOT)
    ),

    VULPUS(
            "vulpus",
            VulpusConfig.durabilityVulpus,
            new int[] {
                    VulpusConfig.protectionValueVulpusBoots,
                    VulpusConfig.protectionValueVulpusLeggings,
                    VulpusConfig.protectionValueVulpusChestplate,
                    VulpusConfig.protectionValueVulpusHelmet
            },
            VulpusConfig.enchantmentValueVulpusArmor,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            VulpusConfig.toughnessValueVulpusArmor,
            (float) VulpusConfig.knockbackResistanceValueVulpusArmor,
            () -> Ingredient.ofItems(ModItems.VULPUS_INGOT)
    ),

    ENDERIUM(
            "enderium",
            EnderiumConfig.durabilityEnderium,
            new int[] {
                    EnderiumConfig.protectionValueEnderiumBoots,
                    EnderiumConfig.protectionValueEnderiumLeggings,
                    EnderiumConfig.protectionValueEnderiumChestplate,
                    EnderiumConfig.protectionValueEnderiumHelmet
            },
            EnderiumConfig.enchantmentValueEnderiumArmor,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            EnderiumConfig.toughnessValueEnderiumArmor,
            (float) EnderiumConfig.knockbackResistanceValueEnderiumArmor,
            () -> Ingredient.ofItems(ModItems.ENDERIUM_INGOT)
    );

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 11, 16, 15, 13 };

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound,
                      float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
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
        return ImmersiveOres.MOD_ID + ":" + this.name;
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
