package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.util.ModEquipmentAssets;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Util;
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
            ItemTags.REPAIRS_NETHERITE_ARMOR,
            ModEquipmentAssets.VIBRANIUM);

    public static final ArmorMaterial VULPUS = new ArmorMaterial(VulpusConfig.durabilityVulpus.get(), Util.make(new EnumMap<>(ArmorType.class),
            attribute -> {
                attribute.put(ArmorType.BOOTS, VulpusConfig.protectionValueVulpusBoots.get());
                attribute.put(ArmorType.LEGGINGS, VulpusConfig.protectionValueVulpusLeggings.get());
                attribute.put(ArmorType.CHESTPLATE, VulpusConfig.protectionValueVulpusChestplate.get());
                attribute.put(ArmorType.HELMET, VulpusConfig.protectionValueVulpusHelmet.get());
            }), VulpusConfig.enchantmentValueVulpusArmor.get(), SoundEvents.ARMOR_EQUIP_NETHERITE,
            VulpusConfig.toughnessValueVulpusArmor.get(), VulpusConfig.knockbackResistanceValueVulpusArmor.get(),
            ItemTags.REPAIRS_NETHERITE_ARMOR,
            ModEquipmentAssets.VULPUS);

    public static final ArmorMaterial ENDERIUM = new ArmorMaterial(EnderiumConfig.durabilityEnderium.get(), Util.make(new EnumMap<>(ArmorType.class),
            attribute -> {
                attribute.put(ArmorType.BOOTS, EnderiumConfig.protectionValueEnderiumBoots.get());
                attribute.put(ArmorType.LEGGINGS, EnderiumConfig.protectionValueEnderiumLeggings.get());
                attribute.put(ArmorType.CHESTPLATE, EnderiumConfig.protectionValueEnderiumChestplate.get());
                attribute.put(ArmorType.HELMET, EnderiumConfig.protectionValueEnderiumHelmet.get());
            }), EnderiumConfig.enchantmentValueEnderiumArmor.get(), SoundEvents.ARMOR_EQUIP_NETHERITE,
            EnderiumConfig.toughnessValueEnderiumArmor.get(), EnderiumConfig.knockbackResistanceValueEnderiumArmor.get(),
            ItemTags.REPAIRS_NETHERITE_ARMOR,
            ModEquipmentAssets.ENDERIUM);
}