package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.block.ModBlocks;
import com.blocklegend001.immersiveores.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvied, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, lookupProvied, ImmersiveOres.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.BEACON_BASE_BLOCKS)
                .add(ModBlocks.VIBRANIUM_BLOCK.get(),
                        ModBlocks.VULPUS_BLOCK.get(),
                        ModBlocks.ENDERIUM_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.VIBRANIUM_BLOCK.get(),
                        ModBlocks.VULPUS_BLOCK.get(),
                        ModBlocks.ENDERIUM_BLOCK.get(),
                        ModBlocks.VIBRANIUM_ORE.get(),
                        ModBlocks.VULPUS_ORE.get(),
                        ModBlocks.ENDERIUM_ORE.get(),
                        ModBlocks.RAW_VIBRANIUM_BLOCK.get(),
                        ModBlocks.RAW_VULPUS_BLOCK.get(),
                        ModBlocks.RAW_ENDERIUM_BLOCK.get());

        this.tag(ModTags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.VIBRANIUM_BLOCK.get(),
                        ModBlocks.VIBRANIUM_ORE.get(),
                        ModBlocks.RAW_VIBRANIUM_BLOCK.get());

        this.tag(ModTags.Blocks.NEEDS_VIBRANIUM_TOOL)
                .add(ModBlocks.VULPUS_BLOCK.get(),
                        ModBlocks.VULPUS_ORE.get(),
                        ModBlocks.RAW_VULPUS_BLOCK.get());

        this.tag(ModTags.Blocks.NEEDS_VULPUS_TOOL)
                .add(ModBlocks.ENDERIUM_BLOCK.get(),
                        ModBlocks.ENDERIUM_ORE.get(),
                        ModBlocks.RAW_ENDERIUM_BLOCK.get());

        this.tag(ModTags.Blocks.NEEDS_ENDERIUM_TOOL)
                .add(ModBlocks.ENDERIUM_BLOCK.get(),
                        ModBlocks.ENDERIUM_ORE.get(),
                        ModBlocks.RAW_ENDERIUM_BLOCK.get());

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
                .add(ModBlocks.ENDERIUM_BLOCK.get(),
                        ModBlocks.ENDERIUM_ORE.get(),
                        ModBlocks.RAW_ENDERIUM_BLOCK.get())
                .replace(true);

        this.tag(Tags.Blocks.ORES)
                .add(ModBlocks.VIBRANIUM_ORE.get(),
                        ModBlocks.VULPUS_ORE.get(),
                        ModBlocks.ENDERIUM_ORE.get());

        this.tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
                .add(ModBlocks.VIBRANIUM_BLOCK.get(),
                        ModBlocks.VULPUS_BLOCK.get(),
                        ModBlocks.ENDERIUM_BLOCK.get(),
                        ModBlocks.VIBRANIUM_ORE.get(),
                        ModBlocks.VULPUS_ORE.get(),
                        ModBlocks.ENDERIUM_ORE.get(),
                        ModBlocks.RAW_VIBRANIUM_BLOCK.get(),
                        ModBlocks.RAW_VULPUS_BLOCK.get(),
                        ModBlocks.RAW_ENDERIUM_BLOCK.get());

        this.tag(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .add(ModBlocks.VIBRANIUM_BLOCK.get(),
                        ModBlocks.VULPUS_BLOCK.get(),
                        ModBlocks.ENDERIUM_BLOCK.get(),
                        ModBlocks.VIBRANIUM_ORE.get(),
                        ModBlocks.VULPUS_ORE.get(),
                        ModBlocks.ENDERIUM_ORE.get(),
                        ModBlocks.RAW_VIBRANIUM_BLOCK.get(),
                        ModBlocks.RAW_VULPUS_BLOCK.get(),
                        ModBlocks.RAW_ENDERIUM_BLOCK.get());

        this.tag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .add(ModBlocks.VIBRANIUM_BLOCK.get(),
                        ModBlocks.VULPUS_BLOCK.get(),
                        ModBlocks.ENDERIUM_BLOCK.get(),
                        ModBlocks.VIBRANIUM_ORE.get(),
                        ModBlocks.VULPUS_ORE.get(),
                        ModBlocks.ENDERIUM_ORE.get(),
                        ModBlocks.RAW_VIBRANIUM_BLOCK.get(),
                        ModBlocks.RAW_VULPUS_BLOCK.get(),
                        ModBlocks.RAW_ENDERIUM_BLOCK.get());

        this.tag(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                .add(ModBlocks.VIBRANIUM_BLOCK.get(),
                        ModBlocks.VULPUS_BLOCK.get(),
                        ModBlocks.ENDERIUM_BLOCK.get(),
                        ModBlocks.VIBRANIUM_ORE.get(),
                        ModBlocks.VULPUS_ORE.get(),
                        ModBlocks.ENDERIUM_ORE.get(),
                        ModBlocks.RAW_VIBRANIUM_BLOCK.get(),
                        ModBlocks.RAW_VULPUS_BLOCK.get(),
                        ModBlocks.RAW_ENDERIUM_BLOCK.get());

        this.tag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .add(ModBlocks.VIBRANIUM_BLOCK.get(),
                        ModBlocks.VULPUS_BLOCK.get(),
                        ModBlocks.ENDERIUM_BLOCK.get(),
                        ModBlocks.VIBRANIUM_ORE.get(),
                        ModBlocks.VULPUS_ORE.get(),
                        ModBlocks.ENDERIUM_ORE.get(),
                        ModBlocks.RAW_VIBRANIUM_BLOCK.get(),
                        ModBlocks.RAW_VULPUS_BLOCK.get(),
                        ModBlocks.RAW_ENDERIUM_BLOCK.get());

        this.tag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .add(ModBlocks.VULPUS_BLOCK.get(),
                        ModBlocks.ENDERIUM_BLOCK.get(),
                        ModBlocks.VULPUS_ORE.get(),
                        ModBlocks.ENDERIUM_ORE.get(),
                        ModBlocks.RAW_VULPUS_BLOCK.get(),
                        ModBlocks.RAW_ENDERIUM_BLOCK.get());
    }
}
