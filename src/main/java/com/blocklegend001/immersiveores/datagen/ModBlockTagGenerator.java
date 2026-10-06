package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.block.ModBlocks;
import com.blocklegend001.immersiveores.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvied) {
        super(packOutput, lookupProvied, ImmersiveOres.MODID);
    }

    private static ResourceKey<Block> key(DeferredBlock<?> block) {
        return block.unwrapKey().orElseThrow();
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.BEACON_BASE_BLOCKS)
                .add(key(ModBlocks.VIBRANIUM_BLOCK),
                        key(ModBlocks.VULPUS_BLOCK),
                        key(ModBlocks.ENDERIUM_BLOCK));

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(key(ModBlocks.VIBRANIUM_BLOCK),
                        key(ModBlocks.VULPUS_BLOCK),
                        key(ModBlocks.ENDERIUM_BLOCK),
                        key(ModBlocks.VIBRANIUM_ORE),
                        key(ModBlocks.VULPUS_ORE),
                        key(ModBlocks.ENDERIUM_ORE),
                        key(ModBlocks.RAW_VIBRANIUM_BLOCK),
                        key(ModBlocks.RAW_VULPUS_BLOCK),
                        key(ModBlocks.RAW_ENDERIUM_BLOCK));

        this.tag(ModTags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(key(ModBlocks.VIBRANIUM_BLOCK),
                        key(ModBlocks.VIBRANIUM_ORE),
                        key(ModBlocks.RAW_VIBRANIUM_BLOCK));

        this.tag(ModTags.Blocks.NEEDS_VIBRANIUM_TOOL)
                .add(key(ModBlocks.VULPUS_BLOCK),
                        key(ModBlocks.VULPUS_ORE),
                        key(ModBlocks.RAW_VULPUS_BLOCK));

        this.tag(ModTags.Blocks.NEEDS_VULPUS_TOOL)
                .add(key(ModBlocks.ENDERIUM_BLOCK),
                        key(ModBlocks.ENDERIUM_ORE),
                        key(ModBlocks.RAW_ENDERIUM_BLOCK));

        this.tag(ModTags.Blocks.NEEDS_ENDERIUM_TOOL)
                .add(key(ModBlocks.ENDERIUM_BLOCK),
                        key(ModBlocks.ENDERIUM_ORE),
                        key(ModBlocks.RAW_ENDERIUM_BLOCK));

        this.tag(ModTags.Blocks.VIBRANIUM_PAXEL_MINEABLE)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.MINEABLE_WITH_SHOVEL)
                .addTag(ModTags.Blocks.NEEDS_VIBRANIUM_TOOL);

        this.tag(ModTags.Blocks.VULPUS_PAXEL_MINEABLE)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.MINEABLE_WITH_SHOVEL)
                .addTag(ModTags.Blocks.NEEDS_VULPUS_TOOL);

        this.tag(ModTags.Blocks.ENDERIUM_PAXEL_MINEABLE)
                .addTag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(BlockTags.MINEABLE_WITH_AXE)
                .addTag(BlockTags.MINEABLE_WITH_SHOVEL)
                .addTag(ModTags.Blocks.NEEDS_ENDERIUM_TOOL);

        this.tag(ModTags.Blocks.INCORRECT_FOR_ENDERIUM_TOOL)
                .replace(true);

        this.tag(ModTags.Blocks.INCORRECT_FOR_VULPUS_TOOL)
                .replace(true);

        this.tag(ModTags.Blocks.INCORRECT_FOR_VIBRANIUM_TOOL)
                .add(key(ModBlocks.ENDERIUM_BLOCK),
                        key(ModBlocks.ENDERIUM_ORE),
                        key(ModBlocks.RAW_ENDERIUM_BLOCK))
                .replace(true);

        this.tag(Tags.Blocks.ORES)
                .add(key(ModBlocks.VIBRANIUM_ORE),
                        key(ModBlocks.VULPUS_ORE),
                        key(ModBlocks.ENDERIUM_ORE));

        this.tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
                .add(key(ModBlocks.VIBRANIUM_BLOCK),
                        key(ModBlocks.VULPUS_BLOCK),
                        key(ModBlocks.ENDERIUM_BLOCK),
                        key(ModBlocks.VIBRANIUM_ORE),
                        key(ModBlocks.VULPUS_ORE),
                        key(ModBlocks.ENDERIUM_ORE),
                        key(ModBlocks.RAW_VIBRANIUM_BLOCK),
                        key(ModBlocks.RAW_VULPUS_BLOCK),
                        key(ModBlocks.RAW_ENDERIUM_BLOCK));

        this.tag(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .add(key(ModBlocks.VIBRANIUM_BLOCK),
                        key(ModBlocks.VULPUS_BLOCK),
                        key(ModBlocks.ENDERIUM_BLOCK),
                        key(ModBlocks.VIBRANIUM_ORE),
                        key(ModBlocks.VULPUS_ORE),
                        key(ModBlocks.ENDERIUM_ORE),
                        key(ModBlocks.RAW_VIBRANIUM_BLOCK),
                        key(ModBlocks.RAW_VULPUS_BLOCK),
                        key(ModBlocks.RAW_ENDERIUM_BLOCK));

        this.tag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .add(key(ModBlocks.VIBRANIUM_BLOCK),
                        key(ModBlocks.VULPUS_BLOCK),
                        key(ModBlocks.ENDERIUM_BLOCK),
                        key(ModBlocks.VIBRANIUM_ORE),
                        key(ModBlocks.VULPUS_ORE),
                        key(ModBlocks.ENDERIUM_ORE),
                        key(ModBlocks.RAW_VIBRANIUM_BLOCK),
                        key(ModBlocks.RAW_VULPUS_BLOCK),
                        key(ModBlocks.RAW_ENDERIUM_BLOCK));

        this.tag(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                .add(key(ModBlocks.VIBRANIUM_BLOCK),
                        key(ModBlocks.VULPUS_BLOCK),
                        key(ModBlocks.ENDERIUM_BLOCK),
                        key(ModBlocks.VIBRANIUM_ORE),
                        key(ModBlocks.VULPUS_ORE),
                        key(ModBlocks.ENDERIUM_ORE),
                        key(ModBlocks.RAW_VIBRANIUM_BLOCK),
                        key(ModBlocks.RAW_VULPUS_BLOCK),
                        key(ModBlocks.RAW_ENDERIUM_BLOCK));

        this.tag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .add(key(ModBlocks.VIBRANIUM_BLOCK),
                        key(ModBlocks.VULPUS_BLOCK),
                        key(ModBlocks.ENDERIUM_BLOCK),
                        key(ModBlocks.VIBRANIUM_ORE),
                        key(ModBlocks.VULPUS_ORE),
                        key(ModBlocks.ENDERIUM_ORE),
                        key(ModBlocks.RAW_VIBRANIUM_BLOCK),
                        key(ModBlocks.RAW_VULPUS_BLOCK),
                        key(ModBlocks.RAW_ENDERIUM_BLOCK));

        this.tag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .add(key(ModBlocks.VULPUS_BLOCK),
                        key(ModBlocks.ENDERIUM_BLOCK),
                        key(ModBlocks.VULPUS_ORE),
                        key(ModBlocks.ENDERIUM_ORE),
                        key(ModBlocks.RAW_VULPUS_BLOCK),
                        key(ModBlocks.RAW_ENDERIUM_BLOCK));
    }
}