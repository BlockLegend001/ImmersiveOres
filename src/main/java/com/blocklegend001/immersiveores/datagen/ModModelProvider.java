package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.blocks.ModBlocks;
import com.blocklegend001.immersiveores.item.ModArmorMaterials;
import com.blocklegend001.immersiveores.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

import java.util.Map;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createTrivialCube(ModBlocks.VIBRANIUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(ModBlocks.VIBRANIUM_ORE);
        blockStateModelGenerator.createTrivialCube(ModBlocks.RAW_VIBRANIUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(ModBlocks.ENDERIUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(ModBlocks.ENDERIUM_ORE);
        blockStateModelGenerator.createTrivialCube(ModBlocks.RAW_ENDERIUM_BLOCK);
        blockStateModelGenerator.createTrivialCube(ModBlocks.VULPUS_BLOCK);
        blockStateModelGenerator.createTrivialCube(ModBlocks.VULPUS_ORE);
        blockStateModelGenerator.createTrivialCube(ModBlocks.RAW_VULPUS_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(ModItems.VIBRANIUM_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.VIBRANIUM_PAXEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.VIBRANIUM_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.VIBRANIUM_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.VIBRANIUM_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.VIBRANIUM_HAMMER, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.VIBRANIUM_EXCAVATOR, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.VIBRANIUM_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.VIBRANIUM_HORSE_ARMOR, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.RAW_VIBRANIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.VIBRANIUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.VIBRANIUM_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.VIBRANIUM_STICK, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateTrimmableItem(ModItems.VIBRANIUM_HELMET, ItemModelGenerators.TRIM_PREFIX_HELMET, false, Map.of());
        itemModelGenerator.generateTrimmableItem(ModItems.VIBRANIUM_CHESTPLATE, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false, Map.of());
        itemModelGenerator.generateTrimmableItem(ModItems.VIBRANIUM_LEGGINGS, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false, Map.of());
        itemModelGenerator.generateTrimmableItem(ModItems.VIBRANIUM_BOOTS, ItemModelGenerators.TRIM_PREFIX_BOOTS, false, Map.of());

        itemModelGenerator.generateFlatItem(ModItems.VULPUS_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.VULPUS_PAXEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.VULPUS_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.VULPUS_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.VULPUS_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.VULPUS_HAMMER, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.VULPUS_EXCAVATOR, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.VULPUS_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.VULPUS_HORSE_ARMOR, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.RAW_VULPUS, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.VULPUS_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.VULPUS_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.VULPUS_STICK, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateTrimmableItem(ModItems.VULPUS_HELMET, ItemModelGenerators.TRIM_PREFIX_HELMET, false, Map.of());
        itemModelGenerator.generateTrimmableItem(ModItems.VULPUS_CHESTPLATE, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false, Map.of());
        itemModelGenerator.generateTrimmableItem(ModItems.VULPUS_LEGGINGS, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false, Map.of());
        itemModelGenerator.generateTrimmableItem(ModItems.VULPUS_BOOTS, ItemModelGenerators.TRIM_PREFIX_BOOTS, false, Map.of());

        itemModelGenerator.generateFlatItem(ModItems.ENDERIUM_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ENDERIUM_PAXEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ENDERIUM_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ENDERIUM_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ENDERIUM_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ENDERIUM_HAMMER, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ENDERIUM_EXCAVATOR, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ENDERIUM_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ENDERIUM_HORSE_ARMOR, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.RAW_ENDERIUM, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ENDERIUM_INGOT, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ENDERIUM_NUGGET, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ENDERIUM_STICK, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateTrimmableItem(ModItems.ENDERIUM_HELMET, ItemModelGenerators.TRIM_PREFIX_HELMET, false, Map.of());
        itemModelGenerator.generateTrimmableItem(ModItems.ENDERIUM_CHESTPLATE, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false, Map.of());
        itemModelGenerator.generateTrimmableItem(ModItems.ENDERIUM_LEGGINGS, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false, Map.of());
        itemModelGenerator.generateTrimmableItem(ModItems.ENDERIUM_BOOTS, ItemModelGenerators.TRIM_PREFIX_BOOTS, false, Map.of());
    }
}
