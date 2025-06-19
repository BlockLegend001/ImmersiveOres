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
            attribute.put(ArmorItem.Type.BOOTS, VibraniumConfig.protectionValueVibraniumBoots.get());
            attribute.put(ArmorItem.Type.LEGGINGS, VibraniumConfig.protectionValueVibraniumLeggings.get());
            attribute.put(ArmorItem.Type.CHESTPLATE, VibraniumConfig.protectionValueVibraniumChestplate.get());
            attribute.put(ArmorItem.Type.HELMET, VibraniumConfig.protectionValueVibraniumHelmet.get());
        }), VibraniumConfig.enchantmentValueVibraniumArmor.get(), VibraniumConfig.toughnessValueVibraniumArmor.get(), VibraniumConfig.knockbackResistanceValueVibraniumArmor.get(), ModItems.VIBRANIUM_INGOT.get());

        VULPUS = register("vulpus", Util.make(new EnumMap<>(ArmorItem.Type.class), (attribute) -> {
            attribute.put(ArmorItem.Type.BOOTS, VulpusConfig.protectionValueVulpusBoots.get());
            attribute.put(ArmorItem.Type.LEGGINGS, VulpusConfig.protectionValueVulpusLeggings.get());
            attribute.put(ArmorItem.Type.CHESTPLATE, VulpusConfig.protectionValueVulpusChestplate.get());
            attribute.put(ArmorItem.Type.HELMET, VulpusConfig.protectionValueVulpusHelmet.get());
        }), VulpusConfig.enchantmentValueVulpusArmor.get(), VulpusConfig.toughnessValueVulpusArmor.get(), VulpusConfig.knockbackResistanceValueVulpusArmor.get(), ModItems.VULPUS_INGOT.get());

        ENDERIUM = register("enderium", Util.make(new EnumMap<>(ArmorItem.Type.class), (attribute) -> {
            attribute.put(ArmorItem.Type.BOOTS, EnderiumConfig.protectionValueEnderiumBoots.get());
            attribute.put(ArmorItem.Type.LEGGINGS, EnderiumConfig.protectionValueEnderiumLeggings.get());
            attribute.put(ArmorItem.Type.CHESTPLATE, EnderiumConfig.protectionValueEnderiumChestplate.get());
            attribute.put(ArmorItem.Type.HELMET, EnderiumConfig.protectionValueEnderiumHelmet.get());
        }), EnderiumConfig.enchantmentValueEnderiumArmor.get(), EnderiumConfig.toughnessValueEnderiumArmor.get(), EnderiumConfig.knockbackResistanceValueEnderiumArmor.get(), ModItems.ENDERIUM_INGOT.get());
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