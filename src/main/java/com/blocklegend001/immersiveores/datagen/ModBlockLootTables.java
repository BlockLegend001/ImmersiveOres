package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.block.ModBlocks;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class ModBlockLootTables extends LootTableProvider {
    public ModBlockLootTables() {
        super(Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(ModBlockLootSubProvider::new, LootContextParamSets.BLOCK)
        ));
    }

    private record ModLootables(LootTableSubProvider.Context output) implements LootTableSubProvider {
        @Override
        public void run() {

        }
    }

    private static class ModBlockLootSubProvider extends BlockLootSubProvider {
        protected ModBlockLootSubProvider(LootTableSubProvider.Context context) {
            super(Set.of(), FeatureFlags.REGISTRY.allFlags(), context);
        }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.VIBRANIUM_BLOCK.get());
        this.dropSelf(ModBlocks.VULPUS_BLOCK.get());
        this.dropSelf(ModBlocks.ENDERIUM_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_VIBRANIUM_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_VULPUS_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_ENDERIUM_BLOCK.get());

        this.add(ModBlocks.VIBRANIUM_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.VIBRANIUM_ORE.get(), ModItems.RAW_VIBRANIUM.get()));
        this.add(ModBlocks.VULPUS_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.VULPUS_ORE.get(), ModItems.RAW_VULPUS.get()));
        this.add(ModBlocks.ENDERIUM_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.ENDERIUM_ORE.get(), ModItems.RAW_ENDERIUM.get()));

    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
    }
}

