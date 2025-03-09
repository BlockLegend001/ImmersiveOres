package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public final class ModArmorMaterials {

    public static final Holder<ArmorMaterial> VIBRANIUM;
    public static final Holder<ArmorMaterial> VULPUS;
    public static final Holder<ArmorMaterial> ENDERIUM;

    static {
        VIBRANIUM = register("vibranium", Util.make(new EnumMap<>(ArmorItem.Type.class), (attribute) -> {
            attribute.put(ArmorItem.Type.BOOTS, VibraniumConfig.protectionValueVibraniumBoots);
            attribute.put(ArmorItem.Type.LEGGINGS, VibraniumConfig.protectionValueVibraniumLeggings);
            attribute.put(ArmorItem.Type.CHESTPLATE, VibraniumConfig.protectionValueVibraniumChestplate);
            attribute.put(ArmorItem.Type.HELMET, VibraniumConfig.protectionValueVibraniumHelmet);
        }), VibraniumConfig.enchantmentValueVibraniumArmor, VibraniumConfig.toughnessValueVibraniumArmor, VibraniumConfig.knockbackResistanceValueVibraniumArmor, ModItems.VIBRANIUM_INGOT.get());

        VULPUS = register("vulpus", Util.make(new EnumMap<>(ArmorItem.Type.class), (attribute) -> {
            attribute.put(ArmorItem.Type.BOOTS, VulpusConfig.protectionValueVulpusBoots);
            attribute.put(ArmorItem.Type.LEGGINGS, VulpusConfig.protectionValueVulpusLeggings);
            attribute.put(ArmorItem.Type.CHESTPLATE, VulpusConfig.protectionValueVulpusChestplate);
            attribute.put(ArmorItem.Type.HELMET, VulpusConfig.protectionValueVulpusHelmet);
        }), VulpusConfig.enchantmentValueVulpusArmor, VulpusConfig.toughnessValueVulpusArmor, VulpusConfig.knockbackResistanceValueVulpusArmor, ModItems.VULPUS_INGOT.get());

        ENDERIUM = register("enderium", Util.make(new EnumMap<>(ArmorItem.Type.class), (attribute) -> {
            attribute.put(ArmorItem.Type.BOOTS, EnderiumConfig.protectionValueEnderiumBoots);
            attribute.put(ArmorItem.Type.LEGGINGS, EnderiumConfig.protectionValueEnderiumLeggings);
            attribute.put(ArmorItem.Type.CHESTPLATE, EnderiumConfig.protectionValueEnderiumChestplate);
            attribute.put(ArmorItem.Type.HELMET, EnderiumConfig.protectionValueEnderiumHelmet);
        }), EnderiumConfig.enchantmentValueEnderiumArmor, EnderiumConfig.toughnessValueEnderiumArmor, EnderiumConfig.knockbackResistanceValueEnderiumArmor, ModItems.ENDERIUM_INGOT.get());
    }

    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> typeProtections, int enchantability, float toughness, float knockbackResistance, Item repairItem) {
        ResourceLocation loc = ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, name);
        Holder<SoundEvent> soundEvent = SoundEvents.ARMOR_EQUIP_NETHERITE;
        Supplier<Ingredient> repairIngredient = () -> Ingredient.of(repairItem);
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(loc));

        EnumMap<ArmorItem.Type, Integer> typeMap = new EnumMap<>(ArmorItem.Type.class);
        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            typeMap.put(type, typeProtections.get(type));
        }

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, loc, new ArmorMaterial(typeProtections, enchantability, soundEvent, repairIngredient, layers, toughness, knockbackResistance));
    }

}