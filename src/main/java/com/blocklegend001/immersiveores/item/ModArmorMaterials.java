package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {

    public static final RegistryEntry<ArmorMaterial> VIBRANIUM = registerArmorMaterial("vibranium",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, ImmersiveOres.VIBRANIUM_CONFIG.armor().boots);
                map.put(ArmorItem.Type.LEGGINGS, ImmersiveOres.VIBRANIUM_CONFIG.armor().leggings);
                map.put(ArmorItem.Type.CHESTPLATE, ImmersiveOres.VIBRANIUM_CONFIG.armor().chestplate);
                map.put(ArmorItem.Type.HELMET, ImmersiveOres.VIBRANIUM_CONFIG.armor().helmet);
            }), ImmersiveOres.VIBRANIUM_CONFIG.armor().enchantmentValue, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(ModItems.ENDERIUM_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(ImmersiveOres.MOD_ID, "vibranium"))), ImmersiveOres.VIBRANIUM_CONFIG.armor().toughness, ImmersiveOres.VIBRANIUM_CONFIG.armor().knockbackResistance));

    public static final RegistryEntry<ArmorMaterial> VULPUS = registerArmorMaterial("vulpus",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, VulpusConfig.protectionValueVulpusBoots);
                map.put(ArmorItem.Type.LEGGINGS, VulpusConfig.protectionValueVulpusLeggings);
                map.put(ArmorItem.Type.CHESTPLATE, VulpusConfig.protectionValueVulpusChestplate);
                map.put(ArmorItem.Type.HELMET, VulpusConfig.protectionValueVulpusHelmet);
            }), VulpusConfig.enchantmentValueVulpusArmor, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(ModItems.VULPUS_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(ImmersiveOres.MOD_ID, "vulpus"))), VulpusConfig.toughnessValueVulpusArmor, VulpusConfig.knockbackResistanceValueVulpusArmor));

    public static final RegistryEntry<ArmorMaterial> ENDERIUM = registerArmorMaterial("enderium",
            () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, ImmersiveOres.ENDERIUM_CONFIG.armor().boots);
                map.put(ArmorItem.Type.LEGGINGS, ImmersiveOres.ENDERIUM_CONFIG.armor().leggings);
                map.put(ArmorItem.Type.CHESTPLATE, ImmersiveOres.ENDERIUM_CONFIG.armor().chestplate);
                map.put(ArmorItem.Type.HELMET, ImmersiveOres.ENDERIUM_CONFIG.armor().helmet);
            }), ImmersiveOres.ENDERIUM_CONFIG.armor().enchantmentValue, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, () -> Ingredient.ofItems(ModItems.ENDERIUM_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(ImmersiveOres.MOD_ID, "enderium"))), ImmersiveOres.ENDERIUM_CONFIG.armor().toughness, ImmersiveOres.ENDERIUM_CONFIG.armor().knockbackResistance));

    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material) {
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(ImmersiveOres.MOD_ID, name), material.get());
    }
}
