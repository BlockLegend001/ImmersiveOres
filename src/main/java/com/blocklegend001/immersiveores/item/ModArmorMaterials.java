package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.util.ModEquipmentAssets;
import com.blocklegend001.immersiveores.util.ModTags;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.EnumMap;

public final class ModArmorMaterials {

    public static final ArmorMaterial VIBRANIUM = new ArmorMaterial(0, Util.make(new EnumMap<>(ArmorType.class),
            attribute -> {
                attribute.put(ArmorType.BOOTS, VibraniumConfig.protectionValueVibraniumBoots);
                attribute.put(ArmorType.LEGGINGS, VibraniumConfig.protectionValueVibraniumLeggings);
                attribute.put(ArmorType.CHESTPLATE, VibraniumConfig.protectionValueVibraniumChestplate);
                attribute.put(ArmorType.HELMET, VibraniumConfig.protectionValueVibraniumHelmet);
            }), VibraniumConfig.enchantmentValueVibraniumArmor, SoundEvents.ARMOR_EQUIP_NETHERITE,
            VibraniumConfig.toughnessValueVibraniumArmor, VibraniumConfig.knockbackResistanceValueVibraniumArmor,
            ModTags.Items.VIBRANIUM_REPAIRS,
            ModEquipmentAssets.VIBRANIUM);

    public static final ArmorMaterial VULPUS = new ArmorMaterial(0, Util.make(new EnumMap<>(ArmorType.class),
            attribute -> {
                attribute.put(ArmorType.BOOTS, VulpusConfig.protectionValueVulpusBoots);
                attribute.put(ArmorType.LEGGINGS, VulpusConfig.protectionValueVulpusLeggings);
                attribute.put(ArmorType.CHESTPLATE, VulpusConfig.protectionValueVulpusChestplate);
                attribute.put(ArmorType.HELMET, VulpusConfig.protectionValueVulpusHelmet);
            }), VulpusConfig.enchantmentValueVulpusArmor, SoundEvents.ARMOR_EQUIP_NETHERITE,
            VulpusConfig.toughnessValueVulpusArmor, VulpusConfig.knockbackResistanceValueVulpusArmor,
            ModTags.Items.VULPUS_REPAIRS,
            ModEquipmentAssets.VULPUS);

    public static final ArmorMaterial ENDERIUM = new ArmorMaterial(0, Util.make(new EnumMap<>(ArmorType.class),
            attribute -> {
                attribute.put(ArmorType.BOOTS, EnderiumConfig.protectionValueEnderiumBoots);
                attribute.put(ArmorType.LEGGINGS, EnderiumConfig.protectionValueEnderiumLeggings);
                attribute.put(ArmorType.CHESTPLATE, EnderiumConfig.protectionValueEnderiumChestplate);
                attribute.put(ArmorType.HELMET, EnderiumConfig.protectionValueEnderiumHelmet);
            }), EnderiumConfig.enchantmentValueEnderiumArmor, SoundEvents.ARMOR_EQUIP_NETHERITE,
            EnderiumConfig.toughnessValueEnderiumArmor, EnderiumConfig.knockbackResistanceValueEnderiumArmor,
            ModTags.Items.ENDERIUM_REPAIRS,
            ModEquipmentAssets.ENDERIUM);
}