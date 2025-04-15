package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.util.ModEquipmentAssets;
import com.blocklegend001.immersiveores.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Util;

import java.util.EnumMap;

public class ModArmorMaterials {
    public static ArmorMaterial VIBRANIUM = new ArmorMaterial(0, Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, VibraniumConfig.protectionValueVibraniumBoots);
                map.put(EquipmentType.LEGGINGS, VibraniumConfig.protectionValueVibraniumLeggings);
                map.put(EquipmentType.CHESTPLATE, VibraniumConfig.protectionValueVibraniumChestplate);
                map.put(EquipmentType.HELMET, VibraniumConfig.protectionValueVibraniumHelmet);
    }), VibraniumConfig.enchantmentValueVibraniumArmor, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, VibraniumConfig.toughnessValueVibraniumArmor, VibraniumConfig.knockbackResistanceValueVibraniumArmor,
            ModTags.Items.VIBRANIUM_REPAIRS, ModEquipmentAssets.VIBRANIUM);

    public static ArmorMaterial VULPUS = new ArmorMaterial(0, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, VulpusConfig.protectionValueVulpusBoots);
        map.put(EquipmentType.LEGGINGS, VulpusConfig.protectionValueVulpusLeggings);
        map.put(EquipmentType.CHESTPLATE, VulpusConfig.protectionValueVulpusChestplate);
        map.put(EquipmentType.HELMET, VulpusConfig.protectionValueVulpusHelmet);
    }), VulpusConfig.enchantmentValueVulpusArmor, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, VulpusConfig.toughnessValueVulpusArmor, VulpusConfig.knockbackResistanceValueVulpusArmor,
            ModTags.Items.VULPUS_REPAIRS, ModEquipmentAssets.VULPUS);

    public static ArmorMaterial ENDERIUM = new ArmorMaterial(0, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, EnderiumConfig.protectionValueEnderiumBoots);
        map.put(EquipmentType.LEGGINGS, EnderiumConfig.protectionValueEnderiumLeggings);
        map.put(EquipmentType.CHESTPLATE, EnderiumConfig.protectionValueEnderiumChestplate);
        map.put(EquipmentType.HELMET, EnderiumConfig.protectionValueEnderiumHelmet);
    }), EnderiumConfig.enchantmentValueEnderiumArmor, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, EnderiumConfig.toughnessValueEnderiumArmor, EnderiumConfig.knockbackResistanceValueEnderiumArmor,
            ModTags.Items.ENDERIUM_REPAIRS, ModEquipmentAssets.ENDERIUM);
}
