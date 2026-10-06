package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.util.ModTags;
import com.google.common.collect.Maps;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;

import java.util.Map;

public class ModArmorMaterials {
    static ResourceKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = ResourceKey.createRegistryKey(Identifier.parse("equipment_asset"));
    public static final ResourceKey<EquipmentAsset> VIBRANIUM_KEY = ResourceKey.create(REGISTRY_KEY, Identifier.fromNamespaceAndPath(ImmersiveOres.MOD_ID, "vibranium"));
    public static final ResourceKey<EquipmentAsset> VULPUS_KEY = ResourceKey.create(REGISTRY_KEY, Identifier.fromNamespaceAndPath(ImmersiveOres.MOD_ID, "vulpus"));
    public static final ResourceKey<EquipmentAsset> ENDERIUM_KEY = ResourceKey.create(REGISTRY_KEY, Identifier.fromNamespaceAndPath(ImmersiveOres.MOD_ID, "enderium"));

    public static final ArmorMaterial VIBRANIUM = new ArmorMaterial(VibraniumConfig.durabilityVibranium,
        makeDefense(VibraniumConfig.protectionValueVibraniumBoots, VibraniumConfig.protectionValueVibraniumLeggings, VibraniumConfig.protectionValueVibraniumChestplate, VibraniumConfig.protectionValueVibraniumHelmet, 40),
        VibraniumConfig.enchantmentValueVibraniumArmor, SoundEvents.ARMOR_EQUIP_NETHERITE, VibraniumConfig.toughnessValueVibraniumArmor, (float) VibraniumConfig.knockbackResistanceValueVibraniumArmor,
            ModTags.Items.VIBRANIUM_REPAIRS, VIBRANIUM_KEY);

    public static final ArmorMaterial VULPUS = new ArmorMaterial(VibraniumConfig.durabilityVibranium,
            makeDefense(VulpusConfig.protectionValueVulpusBoots, VulpusConfig.protectionValueVulpusLeggings, VulpusConfig.protectionValueVulpusChestplate, VulpusConfig.protectionValueVulpusHelmet, 50),
            VulpusConfig.enchantmentValueVulpusArmor, SoundEvents.ARMOR_EQUIP_NETHERITE, VulpusConfig.toughnessValueVulpusArmor, (float) VulpusConfig.knockbackResistanceValueVulpusArmor,
            ModTags.Items.VULPUS_REPAIRS, VULPUS_KEY);

    public static final ArmorMaterial ENDERIUM = new ArmorMaterial(VibraniumConfig.durabilityVibranium,
            makeDefense(EnderiumConfig.protectionValueEnderiumBoots, EnderiumConfig.protectionValueEnderiumLeggings, EnderiumConfig.protectionValueEnderiumChestplate, EnderiumConfig.protectionValueEnderiumHelmet, 60),
            EnderiumConfig.enchantmentValueEnderiumArmor, SoundEvents.ARMOR_EQUIP_NETHERITE, EnderiumConfig.toughnessValueEnderiumArmor, (float) EnderiumConfig.knockbackResistanceValueEnderiumArmor,
            ModTags.Items.ENDERIUM_REPAIRS, ENDERIUM_KEY);

    static Map<ArmorType, Integer> makeDefense(final int boots, final int legs, final int chest, final int helm, final int body) {
        return Maps.newEnumMap(Map.of(ArmorType.BOOTS, boots, ArmorType.LEGGINGS, legs, ArmorType.CHESTPLATE, chest, ArmorType.HELMET, helm, ArmorType.BODY, body));
    }
}