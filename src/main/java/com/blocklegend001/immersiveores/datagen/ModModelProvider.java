package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.blocks.ModBlocks;
import com.blocklegend001.immersiveores.item.ModItems;
import com.blocklegend001.immersiveores.util.ModEquipmentAssets;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.client.render.entity.equipment.EquipmentModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.util.Identifier;

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

        itemModelGenerator.registerArmor(ModItems.VIBRANIUM_HELMET, ModEquipmentAssets.VIBRANIUM,
                "vibranium", false);

        itemModelGenerator.registerArmor(ModItems.VIBRANIUM_CHESTPLATE, ModEquipmentAssets.VIBRANIUM,
                "vibranium", false);

        itemModelGenerator.registerArmor(ModItems.VIBRANIUM_LEGGINGS, ModEquipmentAssets.VIBRANIUM,
                "vibranium", false);

        itemModelGenerator.registerArmor(ModItems.VIBRANIUM_BOOTS, ModEquipmentAssets.VIBRANIUM,
                "vibranium", false);

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

        itemModelGenerator.registerArmor(ModItems.VULPUS_HELMET, ModEquipmentAssets.VULPUS,
                "vulpus", false);

        itemModelGenerator.registerArmor(ModItems.VULPUS_CHESTPLATE, ModEquipmentAssets.VULPUS,
                "vulpus", false);

        itemModelGenerator.registerArmor(ModItems.VULPUS_LEGGINGS, ModEquipmentAssets.VULPUS,
                "vulpus", false);

        itemModelGenerator.registerArmor(ModItems.VULPUS_BOOTS, ModEquipmentAssets.VULPUS,
                "vulpus", false);

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

        itemModelGenerator.registerArmor(ModItems.ENDERIUM_HELMET, ModEquipmentAssets.ENDERIUM,
                "enderium", false);

        itemModelGenerator.registerArmor(ModItems.ENDERIUM_CHESTPLATE, ModEquipmentAssets.ENDERIUM,
                "enderium", false);

        itemModelGenerator.registerArmor(ModItems.ENDERIUM_LEGGINGS, ModEquipmentAssets.ENDERIUM,
                "enderium", false);

        itemModelGenerator.registerArmor(ModItems.ENDERIUM_BOOTS, ModEquipmentAssets.ENDERIUM,
                "enderium", false);
    }
}
