package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.blocks.ModBlocks;
import com.blocklegend001.immersiveores.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

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
        handheldItem(itemModelGenerator, ModItems.VIBRANIUM_SWORD);
        handheldItem(itemModelGenerator, ModItems.VIBRANIUM_PAXEL);
        handheldItem(itemModelGenerator, ModItems.VIBRANIUM_PICKAXE);
        handheldItem(itemModelGenerator, ModItems.VIBRANIUM_SHOVEL);
        handheldItem(itemModelGenerator, ModItems.VIBRANIUM_HOE);
        handheldItem(itemModelGenerator, ModItems.VIBRANIUM_HAMMER);
        handheldItem(itemModelGenerator, ModItems.VIBRANIUM_EXCAVATOR);
        handheldItem(itemModelGenerator, ModItems.VIBRANIUM_AXE);
        simpleItem(itemModelGenerator, ModItems.VIBRANIUM_HORSE_ARMOR);
        simpleItem(itemModelGenerator, ModItems.RAW_VIBRANIUM);
        simpleItem(itemModelGenerator, ModItems.VIBRANIUM_INGOT);
        simpleItem(itemModelGenerator, ModItems.VIBRANIUM_NUGGET);
        simpleItem(itemModelGenerator, ModItems.VIBRANIUM_STICK);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.VIBRANIUM_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.VIBRANIUM_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.VIBRANIUM_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.VIBRANIUM_BOOTS);

        handheldItem(itemModelGenerator, ModItems.VULPUS_SWORD);
        handheldItem(itemModelGenerator, ModItems.VULPUS_PAXEL);
        handheldItem(itemModelGenerator, ModItems.VULPUS_PICKAXE);
        handheldItem(itemModelGenerator, ModItems.VULPUS_SHOVEL);
        handheldItem(itemModelGenerator, ModItems.VULPUS_HOE);
        handheldItem(itemModelGenerator, ModItems.VULPUS_HAMMER);
        handheldItem(itemModelGenerator, ModItems.VULPUS_EXCAVATOR);
        handheldItem(itemModelGenerator, ModItems.VULPUS_AXE);
        simpleItem(itemModelGenerator, ModItems.VULPUS_HORSE_ARMOR);
        simpleItem(itemModelGenerator, ModItems.RAW_VULPUS);
        simpleItem(itemModelGenerator, ModItems.VULPUS_INGOT);
        simpleItem(itemModelGenerator, ModItems.VULPUS_NUGGET);
        simpleItem(itemModelGenerator, ModItems.VULPUS_STICK);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.VULPUS_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.VULPUS_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.VULPUS_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.VULPUS_BOOTS);

        handheldItem(itemModelGenerator, ModItems.ENDERIUM_SWORD);
        handheldItem(itemModelGenerator, ModItems.ENDERIUM_PAXEL);
        handheldItem(itemModelGenerator, ModItems.ENDERIUM_PICKAXE);
        handheldItem(itemModelGenerator, ModItems.ENDERIUM_SHOVEL);
        handheldItem(itemModelGenerator, ModItems.ENDERIUM_HOE);
        handheldItem(itemModelGenerator, ModItems.ENDERIUM_HAMMER);
        handheldItem(itemModelGenerator, ModItems.ENDERIUM_EXCAVATOR);
        handheldItem(itemModelGenerator, ModItems.ENDERIUM_AXE);
        simpleItem(itemModelGenerator, ModItems.ENDERIUM_HORSE_ARMOR);
        simpleItem(itemModelGenerator, ModItems.RAW_ENDERIUM);
        simpleItem(itemModelGenerator, ModItems.ENDERIUM_INGOT);
        simpleItem(itemModelGenerator, ModItems.ENDERIUM_NUGGET);
        simpleItem(itemModelGenerator, ModItems.ENDERIUM_STICK);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.ENDERIUM_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ENDERIUM_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ENDERIUM_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ENDERIUM_BOOTS);
    }

    private void simpleItem(ItemModelGenerator generator, Item item) {
        generator.register(item, Models.GENERATED);
    }

    private void handheldItem(ItemModelGenerator generator, Item item) {
        generator.register(item, Models.HANDHELD);
    }
}
