package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.blocks.ModBlocks;
import com.blocklegend001.immersiveores.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTables extends FabricBlockLootTableProvider {
    public ModBlockLootTables(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.VIBRANIUM_BLOCK);
        addDrop(ModBlocks.VULPUS_BLOCK);
        addDrop(ModBlocks.ENDERIUM_BLOCK);
        addDrop(ModBlocks.RAW_VIBRANIUM_BLOCK);
        addDrop(ModBlocks.RAW_VULPUS_BLOCK);
        addDrop(ModBlocks.RAW_ENDERIUM_BLOCK);

        addDrop(ModBlocks.VIBRANIUM_ORE, oreDrops(ModBlocks.VIBRANIUM_ORE, ModItems.RAW_VIBRANIUM));
        addDrop(ModBlocks.VULPUS_ORE, oreDrops(ModBlocks.VULPUS_ORE, ModItems.RAW_VULPUS));
        addDrop(ModBlocks.ENDERIUM_ORE, oreDrops(ModBlocks.ENDERIUM_ORE, ModItems.RAW_ENDERIUM));

    }
}

