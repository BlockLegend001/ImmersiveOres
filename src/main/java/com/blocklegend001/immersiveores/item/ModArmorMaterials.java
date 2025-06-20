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

    public static final ArmorMaterial VIBRANIUM = new ArmorMaterial(VibraniumConfig.durabilityVibranium.get(), Util.make(new EnumMap<>(ArmorType.class),
            attribute -> {
            attribute.put(ArmorType.BOOTS, VibraniumConfig.protectionValueVibraniumBoots.get());
            attribute.put(ArmorType.LEGGINGS, VibraniumConfig.protectionValueVibraniumLeggings.get());
            attribute.put(ArmorType.CHESTPLATE, VibraniumConfig.protectionValueVibraniumChestplate.get());
            attribute.put(ArmorType.HELMET, VibraniumConfig.protectionValueVibraniumHelmet.get());
    }), VibraniumConfig.enchantmentValueVibraniumArmor.get(), SoundEvents.ARMOR_EQUIP_NETHERITE,
            VibraniumConfig.toughnessValueVibraniumArmor.get(), VibraniumConfig.knockbackResistanceValueVibraniumArmor.get(),
            ModTags.Items.VIBRANIUM_REPAIRS,
            ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vibranium"));

    public static final ArmorMaterial VULPUS = new ArmorMaterial(VulpusConfig.durabilityVulpus.get(), Util.make(new EnumMap<>(ArmorType.class),
            attribute -> {
                attribute.put(ArmorType.BOOTS, VulpusConfig.protectionValueVulpusBoots.get());
                attribute.put(ArmorType.LEGGINGS, VulpusConfig.protectionValueVulpusLeggings.get());
                attribute.put(ArmorType.CHESTPLATE, VulpusConfig.protectionValueVulpusChestplate.get());
                attribute.put(ArmorType.HELMET, VulpusConfig.protectionValueVulpusHelmet.get());
            }), VulpusConfig.enchantmentValueVulpusArmor.get(), SoundEvents.ARMOR_EQUIP_NETHERITE,
            VulpusConfig.toughnessValueVulpusArmor.get(), VulpusConfig.knockbackResistanceValueVulpusArmor.get(),
            ModTags.Items.VULPUS_REPAIRS,
            ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vulpus"));

    public static final ArmorMaterial ENDERIUM = new ArmorMaterial(EnderiumConfig.durabilityEnderium.get(), Util.make(new EnumMap<>(ArmorType.class),
            attribute -> {
                attribute.put(ArmorType.BOOTS, EnderiumConfig.protectionValueEnderiumBoots.get());
                attribute.put(ArmorType.LEGGINGS, EnderiumConfig.protectionValueEnderiumLeggings.get());
                attribute.put(ArmorType.CHESTPLATE, EnderiumConfig.protectionValueEnderiumChestplate.get());
                attribute.put(ArmorType.HELMET, EnderiumConfig.protectionValueEnderiumHelmet.get());
            }), EnderiumConfig.enchantmentValueEnderiumArmor.get(), SoundEvents.ARMOR_EQUIP_NETHERITE,
            EnderiumConfig.toughnessValueEnderiumArmor.get(), EnderiumConfig.knockbackResistanceValueEnderiumArmor.get(),
            ModTags.Items.ENDERIUM_REPAIRS,
            ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "enderium"));
}