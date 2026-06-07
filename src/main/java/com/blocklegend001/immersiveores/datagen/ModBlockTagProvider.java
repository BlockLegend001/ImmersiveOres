package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.blocks.ModBlocks;
import com.blocklegend001.immersiveores.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
    public ModBlockTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        valueLookupBuilder(ModTags.Blocks.BEACON_BASE_BLOCKS)
                .add(ModBlocks.VIBRANIUM_BLOCK,
                        ModBlocks.VULPUS_BLOCK,
                        ModBlocks.ENDERIUM_BLOCK);

        valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.VIBRANIUM_BLOCK,
                        ModBlocks.VULPUS_BLOCK,
                        ModBlocks.ENDERIUM_BLOCK,
                        ModBlocks.VIBRANIUM_ORE,
                        ModBlocks.VULPUS_ORE,
                        ModBlocks.ENDERIUM_ORE,
                        ModBlocks.RAW_VIBRANIUM_BLOCK,
                        ModBlocks.RAW_VULPUS_BLOCK,
                        ModBlocks.RAW_ENDERIUM_BLOCK);

        valueLookupBuilder(ModTags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.VIBRANIUM_BLOCK,
                        ModBlocks.VIBRANIUM_ORE,
                        ModBlocks.RAW_VIBRANIUM_BLOCK);

        valueLookupBuilder(ModTags.Blocks.NEEDS_VIBRANIUM_TOOL)
                .add(ModBlocks.VULPUS_BLOCK,
                        ModBlocks.VULPUS_ORE,
                        ModBlocks.RAW_VULPUS_BLOCK);

        valueLookupBuilder(ModTags.Blocks.NEEDS_VULPUS_TOOL)
                .add(ModBlocks.ENDERIUM_BLOCK,
                        ModBlocks.ENDERIUM_ORE,
                        ModBlocks.RAW_ENDERIUM_BLOCK);

        valueLookupBuilder(ModTags.Blocks.NEEDS_ENDERIUM_TOOL)
                .add(ModBlocks.ENDERIUM_BLOCK,
                        ModBlocks.ENDERIUM_ORE,
                        ModBlocks.RAW_ENDERIUM_BLOCK);

        valueLookupBuilder(ModTags.Blocks.VIBRANIUM_PAXEL_MINEABLE)
                .forceAddTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .forceAddTag(BlockTags.MINEABLE_WITH_AXE)
                .forceAddTag(BlockTags.MINEABLE_WITH_SHOVEL)
                .forceAddTag(ModTags.Blocks.NEEDS_VIBRANIUM_TOOL);

        valueLookupBuilder(ModTags.Blocks.VULPUS_PAXEL_MINEABLE)
                .forceAddTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .forceAddTag(BlockTags.MINEABLE_WITH_AXE)
                .forceAddTag(BlockTags.MINEABLE_WITH_SHOVEL)
                .forceAddTag(ModTags.Blocks.NEEDS_VULPUS_TOOL);

        valueLookupBuilder(ModTags.Blocks.ENDERIUM_PAXEL_MINEABLE)
                .forceAddTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .forceAddTag(BlockTags.MINEABLE_WITH_AXE)
                .forceAddTag(BlockTags.MINEABLE_WITH_SHOVEL)
                .forceAddTag(ModTags.Blocks.NEEDS_ENDERIUM_TOOL);

        valueLookupBuilder(ModTags.Blocks.INCORRECT_FOR_ENDERIUM_TOOL)
                .setReplace(true);

        valueLookupBuilder(ModTags.Blocks.INCORRECT_FOR_VULPUS_TOOL)
                .setReplace(true);

        valueLookupBuilder(ModTags.Blocks.INCORRECT_FOR_VIBRANIUM_TOOL)
                .add(ModBlocks.ENDERIUM_BLOCK,
                        ModBlocks.ENDERIUM_ORE,
                        ModBlocks.RAW_ENDERIUM_BLOCK)
                .setReplace(true);

        valueLookupBuilder(ConventionalBlockTags.ORES)
                .add(ModBlocks.VIBRANIUM_ORE,
                        ModBlocks.VULPUS_ORE,
                        ModBlocks.ENDERIUM_ORE);

        valueLookupBuilder(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
                .add(ModBlocks.VIBRANIUM_BLOCK,
                        ModBlocks.VULPUS_BLOCK,
                        ModBlocks.ENDERIUM_BLOCK,
                        ModBlocks.VIBRANIUM_ORE,
                        ModBlocks.VULPUS_ORE,
                        ModBlocks.ENDERIUM_ORE,
                        ModBlocks.RAW_VIBRANIUM_BLOCK,
                        ModBlocks.RAW_VULPUS_BLOCK,
                        ModBlocks.RAW_ENDERIUM_BLOCK);

        valueLookupBuilder(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .add(ModBlocks.VIBRANIUM_BLOCK,
                        ModBlocks.VULPUS_BLOCK,
                        ModBlocks.ENDERIUM_BLOCK,
                        ModBlocks.VIBRANIUM_ORE,
                        ModBlocks.VULPUS_ORE,
                        ModBlocks.ENDERIUM_ORE,
                        ModBlocks.RAW_VIBRANIUM_BLOCK,
                        ModBlocks.RAW_VULPUS_BLOCK,
                        ModBlocks.RAW_ENDERIUM_BLOCK);

        valueLookupBuilder(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .add(ModBlocks.VIBRANIUM_BLOCK,
                        ModBlocks.VULPUS_BLOCK,
                        ModBlocks.ENDERIUM_BLOCK,
                        ModBlocks.VIBRANIUM_ORE,
                        ModBlocks.VULPUS_ORE,
                        ModBlocks.ENDERIUM_ORE,
                        ModBlocks.RAW_VIBRANIUM_BLOCK,
                        ModBlocks.RAW_VULPUS_BLOCK,
                        ModBlocks.RAW_ENDERIUM_BLOCK);

        valueLookupBuilder(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                .add(ModBlocks.VIBRANIUM_BLOCK,
                        ModBlocks.VULPUS_BLOCK,
                        ModBlocks.ENDERIUM_BLOCK,
                        ModBlocks.VIBRANIUM_ORE,
                        ModBlocks.VULPUS_ORE,
                        ModBlocks.ENDERIUM_ORE,
                        ModBlocks.RAW_VIBRANIUM_BLOCK,
                        ModBlocks.RAW_VULPUS_BLOCK,
                        ModBlocks.RAW_ENDERIUM_BLOCK);

        valueLookupBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .add(ModBlocks.VIBRANIUM_BLOCK,
                        ModBlocks.VULPUS_BLOCK,
                        ModBlocks.ENDERIUM_BLOCK,
                        ModBlocks.VIBRANIUM_ORE,
                        ModBlocks.VULPUS_ORE,
                        ModBlocks.ENDERIUM_ORE,
                        ModBlocks.RAW_VIBRANIUM_BLOCK,
                        ModBlocks.RAW_VULPUS_BLOCK,
                        ModBlocks.RAW_ENDERIUM_BLOCK);

        valueLookupBuilder(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .add(ModBlocks.VULPUS_BLOCK,
                        ModBlocks.ENDERIUM_BLOCK,
                        ModBlocks.VULPUS_ORE,
                        ModBlocks.ENDERIUM_ORE,
                        ModBlocks.RAW_VULPUS_BLOCK,
                        ModBlocks.RAW_ENDERIUM_BLOCK);
    }
}