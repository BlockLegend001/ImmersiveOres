package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.blocks.ModBlocks;
import com.blocklegend001.immersiveores.item.ModItems;
import com.blocklegend001.immersiveores.util.ModEquipmentAssets;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.EquippableComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import java.util.Map;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VIBRANIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VIBRANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_VIBRANIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDERIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDERIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_ENDERIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VULPUS_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VULPUS_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_VULPUS_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.VIBRANIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VIBRANIUM_PAXEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VIBRANIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VIBRANIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VIBRANIUM_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VIBRANIUM_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VIBRANIUM_EXCAVATOR, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VIBRANIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VIBRANIUM_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_VIBRANIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.VIBRANIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.VIBRANIUM_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.VIBRANIUM_STICK, Models.GENERATED);

        registerArmor(ModItems.VIBRANIUM_HELMET, itemModelGenerator, ModEquipmentAssets.VIBRANIUM);
        registerArmor(ModItems.VIBRANIUM_CHESTPLATE, itemModelGenerator, ModEquipmentAssets.VIBRANIUM);
        registerArmor(ModItems.VIBRANIUM_LEGGINGS, itemModelGenerator, ModEquipmentAssets.VIBRANIUM);
        registerArmor(ModItems.VIBRANIUM_BOOTS, itemModelGenerator, ModEquipmentAssets.VIBRANIUM);

        itemModelGenerator.register(ModItems.VULPUS_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VULPUS_PAXEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VULPUS_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VULPUS_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VULPUS_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VULPUS_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VULPUS_EXCAVATOR, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VULPUS_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VULPUS_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_VULPUS, Models.GENERATED);
        itemModelGenerator.register(ModItems.VULPUS_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.VULPUS_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.VULPUS_STICK, Models.GENERATED);

        registerArmor(ModItems.VULPUS_HELMET, itemModelGenerator, ModEquipmentAssets.VULPUS);
        registerArmor(ModItems.VULPUS_CHESTPLATE, itemModelGenerator, ModEquipmentAssets.VULPUS);
        registerArmor(ModItems.VULPUS_LEGGINGS, itemModelGenerator, ModEquipmentAssets.VULPUS);
        registerArmor(ModItems.VULPUS_BOOTS, itemModelGenerator, ModEquipmentAssets.VULPUS);

        itemModelGenerator.register(ModItems.ENDERIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERIUM_PAXEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERIUM_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERIUM_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERIUM_EXCAVATOR, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ENDERIUM_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_ENDERIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDERIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDERIUM_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENDERIUM_STICK, Models.GENERATED);

        registerArmor(ModItems.ENDERIUM_HELMET, itemModelGenerator, ModEquipmentAssets.ENDERIUM);
        registerArmor(ModItems.ENDERIUM_CHESTPLATE, itemModelGenerator, ModEquipmentAssets.ENDERIUM);
        registerArmor(ModItems.ENDERIUM_LEGGINGS, itemModelGenerator, ModEquipmentAssets.ENDERIUM);
        registerArmor(ModItems.ENDERIUM_BOOTS, itemModelGenerator, ModEquipmentAssets.ENDERIUM);
    }

    public void registerArmor(Item item, ItemModelGenerator itemModels, RegistryKey<EquipmentAsset> equipmentKey)
    {
        Identifier id = Registries.ITEM.getId(item);
        Identifier armorType = null;
        if (id.getPath().contains("helmet"))
            armorType = ItemModelGenerator.HELMET_TRIM_ID_PREFIX;
        else if (id.getPath().contains("chestplate"))
            armorType = ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX;
        else if (id.getPath().contains("leggings"))
            armorType = ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX;
        else if (id.getPath().contains("boots"))
            armorType = ItemModelGenerator.BOOTS_TRIM_ID_PREFIX;
        itemModels.registerArmor(item, equipmentKey, armorType, false);
    }
}
