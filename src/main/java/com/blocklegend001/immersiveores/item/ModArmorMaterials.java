package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.util.ModTags;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.EnumMap;

public final class ModArmorMaterials {

    public static final ArmorMaterial VIBRANIUM = new ArmorMaterial(VibraniumConfig.DURABILITY_VIBRANIUM.get(), Util.make(new EnumMap<>(ArmorType.class),
            attribute -> {
                attribute.put(ArmorType.BOOTS, VibraniumConfig.PROTECTION_VALUE_VIBRANIUM_BOOTS.get());
                attribute.put(ArmorType.LEGGINGS, VibraniumConfig.PROTECTION_VALUE_VIBRANIUM_LEGGINGS.get());
                attribute.put(ArmorType.CHESTPLATE, VibraniumConfig.PROTECTION_VALUE_VIBRANIUM_CHESTPLATE.get());
                attribute.put(ArmorType.HELMET, VibraniumConfig.PROTECTION_VALUE_VIBRANIUM_HELMET.get());
            }), VibraniumConfig.ENCHANTMENT_VALUE_VIBRANIUM_ARMOR.get(), SoundEvents.ARMOR_EQUIP_NETHERITE,
            VibraniumConfig.TOUGHNESS_VALUE_VIBRANIUM_ARMOR.get(), (float) VibraniumConfig.KNOCKBACK_RESISTANCE_VALUE_VIBRANIUM_ARMOR.getAsDouble(),
            ModTags.Items.VIBRANIUM_REPAIRS,
            ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vibranium"));

    public static final ArmorMaterial VULPUS = new ArmorMaterial(VulpusConfig.DURABILITY_VULPUS.get(), Util.make(new EnumMap<>(ArmorType.class),
            attribute -> {
                attribute.put(ArmorType.BOOTS, VulpusConfig.PROTECTION_VALUE_VULPUS_BOOTS.get());
                attribute.put(ArmorType.LEGGINGS, VulpusConfig.PROTECTION_VALUE_VULPUS_LEGGINGS.get());
                attribute.put(ArmorType.CHESTPLATE, VulpusConfig.PROTECTION_VALUE_VULPUS_CHESTPLATE.get());
                attribute.put(ArmorType.HELMET, VulpusConfig.PROTECTION_VALUE_VULPUS_HELMET.get());
            }), VulpusConfig.ENCHANTMENT_VALUE_VULPUS_ARMOR.get(), SoundEvents.ARMOR_EQUIP_NETHERITE,
            VulpusConfig.TOUGHNESS_VALUE_VULPUS_ARMOR.get(), (float) VulpusConfig.KNOCKBACK_RESISTANCE_VALUE_VULPUS_ARMOR.getAsDouble(),
            ModTags.Items.VULPUS_REPAIRS,
            ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vulpus"));

    public static final ArmorMaterial ENDERIUM = new ArmorMaterial(EnderiumConfig.DURABILITY_ENDERIUM.get(), Util.make(new EnumMap<>(ArmorType.class),
            attribute -> {
                attribute.put(ArmorType.BOOTS, EnderiumConfig.PROTECTION_VALUE_ENDERIUM_BOOTS.get());
                attribute.put(ArmorType.LEGGINGS, EnderiumConfig.PROTECTION_VALUE_ENDERIUM_LEGGINGS.get());
                attribute.put(ArmorType.CHESTPLATE, EnderiumConfig.PROTECTION_VALUE_ENDERIUM_CHESTPLATE.get());
                attribute.put(ArmorType.HELMET, EnderiumConfig.PROTECTION_VALUE_ENDERIUM_HELMET.get());
            }), EnderiumConfig.ENCHANTMENT_VALUE_ENDERIUM_ARMOR.get(), SoundEvents.ARMOR_EQUIP_NETHERITE,
            EnderiumConfig.TOUGHNESS_VALUE_ENDERIUM_ARMOR.get(), (float) EnderiumConfig.KNOCKBACK_RESISTANCE_VALUE_ENDERIUM_ARMOR.getAsDouble(),
            ModTags.Items.ENDERIUM_REPAIRS,
            ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "enderium"));
}