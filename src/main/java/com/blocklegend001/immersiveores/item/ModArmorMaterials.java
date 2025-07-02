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
            attribute.put(ArmorItem.Type.BOOTS, VibraniumConfig.PROTECTION_VALUE_VIBRANIUM_BOOTS.get());
            attribute.put(ArmorItem.Type.LEGGINGS, VibraniumConfig.PROTECTION_VALUE_VIBRANIUM_LEGGINGS.get());
            attribute.put(ArmorItem.Type.CHESTPLATE, VibraniumConfig.PROTECTION_VALUE_VIBRANIUM_CHESTPLATE.get());
            attribute.put(ArmorItem.Type.HELMET, VibraniumConfig.PROTECTION_VALUE_VIBRANIUM_HELMET.get());
        }), VibraniumConfig.ENCHANTMENT_VALUE_VIBRANIUM_ARMOR.get(), VibraniumConfig.TOUGHNESS_VALUE_VIBRANIUM_ARMOR.get(), VibraniumConfig.KNOCKBACK_RESISTANCE_VALUE_VIBRANIUM_ARMOR.get(), ModItems.VIBRANIUM_INGOT.get());

        VULPUS = register("vulpus", Util.make(new EnumMap<>(ArmorItem.Type.class), (attribute) -> {
            attribute.put(ArmorItem.Type.BOOTS, VulpusConfig.PROTECTION_VALUE_VULPUS_BOOTS.get());
            attribute.put(ArmorItem.Type.LEGGINGS, VulpusConfig.PROTECTION_VALUE_VULPUS_LEGGINGS.get());
            attribute.put(ArmorItem.Type.CHESTPLATE, VulpusConfig.PROTECTION_VALUE_VULPUS_CHESTPLATE.get());
            attribute.put(ArmorItem.Type.HELMET, VulpusConfig.PROTECTION_VALUE_VULPUS_HELMET.get());
        }), VulpusConfig.ENCHANTMENT_VALUE_VULPUS_ARMOR.get(), VulpusConfig.TOUGHNESS_VALUE_VULPUS_ARMOR.get(), VulpusConfig.KNOCKBACK_RESISTANCE_VALUE_VULPUS_ARMOR.get(), ModItems.VULPUS_INGOT.get());

        ENDERIUM = register("enderium", Util.make(new EnumMap<>(ArmorItem.Type.class), (attribute) -> {
            attribute.put(ArmorItem.Type.BOOTS, EnderiumConfig.PROTECTION_VALUE_ENDERIUM_BOOTS.get());
            attribute.put(ArmorItem.Type.LEGGINGS, EnderiumConfig.PROTECTION_VALUE_ENDERIUM_LEGGINGS.get());
            attribute.put(ArmorItem.Type.CHESTPLATE, EnderiumConfig.PROTECTION_VALUE_ENDERIUM_CHESTPLATE.get());
            attribute.put(ArmorItem.Type.HELMET, EnderiumConfig.PROTECTION_VALUE_ENDERIUM_HELMET.get());
        }), EnderiumConfig.ENCHANTMENT_VALUE_ENDERIUM_ARMOR.get(), EnderiumConfig.TOUGHNESS_VALUE_ENDERIUM_ARMOR.get(), EnderiumConfig.KNOCKBACK_RESISTANCE_VALUE_ENDERIUM_ARMOR.get(), ModItems.ENDERIUM_INGOT.get());
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