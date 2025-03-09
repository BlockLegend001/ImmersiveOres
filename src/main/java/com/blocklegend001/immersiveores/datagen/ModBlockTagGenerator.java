package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.blocks.ModBlocks;
import com.blocklegend001.immersiveores.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Blocks.BEACON_BASE_BLOCKS)
                .add(ModBlocks.VIBRANIUM_BLOCK,
                        ModBlocks.VULPUS_BLOCK,
                        ModBlocks.ENDERIUM_BLOCK);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.VIBRANIUM_BLOCK,
                        ModBlocks.VULPUS_BLOCK,
                        ModBlocks.ENDERIUM_BLOCK,
                        ModBlocks.VIBRANIUM_ORE,
                        ModBlocks.VULPUS_ORE,
                        ModBlocks.ENDERIUM_ORE,
                        ModBlocks.RAW_VIBRANIUM_BLOCK,
                        ModBlocks.RAW_VULPUS_BLOCK,
                        ModBlocks.RAW_ENDERIUM_BLOCK);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.VIBRANIUM_BLOCK,
                        ModBlocks.VIBRANIUM_ORE,
                        ModBlocks.RAW_VIBRANIUM_BLOCK);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_VIBRANIUM_TOOL)
                .add(ModBlocks.VULPUS_BLOCK,
                        ModBlocks.VULPUS_ORE,
                        ModBlocks.RAW_VULPUS_BLOCK);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_VULPUS_TOOL)
                .add(ModBlocks.ENDERIUM_BLOCK,
                        ModBlocks.ENDERIUM_ORE,
                        ModBlocks.RAW_ENDERIUM_BLOCK);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_ENDERIUM_TOOL)
                .add(ModBlocks.ENDERIUM_BLOCK,
                        ModBlocks.ENDERIUM_ORE,
                        ModBlocks.RAW_ENDERIUM_BLOCK);

        getOrCreateTagBuilder(ModTags.Blocks.VIBRANIUM_PAXEL_MINEABLE)
                .forceAddTag(BlockTags.PICKAXE_MINEABLE)
                .forceAddTag(BlockTags.AXE_MINEABLE)
                .forceAddTag(BlockTags.SHOVEL_MINEABLE)
                .forceAddTag(ModTags.Blocks.NEEDS_VIBRANIUM_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.VULPUS_PAXEL_MINEABLE)
                .forceAddTag(BlockTags.PICKAXE_MINEABLE)
                .forceAddTag(BlockTags.AXE_MINEABLE)
                .forceAddTag(BlockTags.SHOVEL_MINEABLE)
                .forceAddTag(ModTags.Blocks.NEEDS_VULPUS_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.ENDERIUM_PAXEL_MINEABLE)
                .forceAddTag(BlockTags.PICKAXE_MINEABLE)
                .forceAddTag(BlockTags.AXE_MINEABLE)
                .forceAddTag(BlockTags.SHOVEL_MINEABLE)
                .forceAddTag(ModTags.Blocks.NEEDS_ENDERIUM_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.INCORRECT_FOR_ENDERIUM_TOOL)
                .forceAddTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.INCORRECT_FOR_VULPUS_TOOL)
                .forceAddTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.INCORRECT_FOR_VIBRANIUM_TOOL)
                .forceAddTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL);
    }
}
