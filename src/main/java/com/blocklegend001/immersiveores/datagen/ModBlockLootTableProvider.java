package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.blocks.ModBlocks;
import com.blocklegend001.immersiveores.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {
    public ModBlockLootTableProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(packOutput, registriesFuture);
    }
    @Override
    public void generate() {
        dropSelf(ModBlocks.VIBRANIUM_BLOCK);
        dropSelf(ModBlocks.VULPUS_BLOCK);
        dropSelf(ModBlocks.ENDERIUM_BLOCK);
        dropSelf(ModBlocks.RAW_VIBRANIUM_BLOCK);
        dropSelf(ModBlocks.RAW_VULPUS_BLOCK);
        dropSelf(ModBlocks.RAW_ENDERIUM_BLOCK);

        add(ModBlocks.VIBRANIUM_ORE, createOreDrop(ModBlocks.VIBRANIUM_ORE, ModItems.RAW_VIBRANIUM));
        add(ModBlocks.VULPUS_ORE, createOreDrop(ModBlocks.VULPUS_ORE, ModItems.RAW_VULPUS));
        add(ModBlocks.ENDERIUM_ORE, createOreDrop(ModBlocks.ENDERIUM_ORE, ModItems.RAW_ENDERIUM));

    }
}

