package com.blocklegend001.immersiveores.blocks;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.blocks.custom.enderium.*;
import com.blocklegend001.immersiveores.blocks.custom.vibranium.*;
import com.blocklegend001.immersiveores.blocks.custom.vulpus.*;
import com.blocklegend001.immersiveores.util.color.ColoredBlock;
import com.blocklegend001.immersiveores.util.color.ColoredBlockItem;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block VIBRANIUM_BLOCK = registerBlock("vibranium_block",
            new VibraniumBlock(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK)
                    .strength(6.5f, 1200.0F).requiresTool()));

    public static final Block VULPUS_BLOCK = registerBlock("vulpus_block",
            new VulpusBlock(AbstractBlock.Settings.copy(ModBlocks.VIBRANIUM_BLOCK)
                    .strength(6.5f, 1200.0F).requiresTool()));

    public static final Block ENDERIUM_BLOCK = registerBlock("enderium_block",
            new EnderiumBlock(AbstractBlock.Settings.copy(ModBlocks.VULPUS_BLOCK)
                    .strength(6.5f, 1200.0F).requiresTool()));

    public static final Block RAW_VIBRANIUM_BLOCK = registerBlock("raw_vibranium_block",
            new RawVibraniumBlock(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK)
                    .strength(6.5f, 1200.0F).requiresTool()));

    public static final Block RAW_VULPUS_BLOCK = registerBlock("raw_vulpus_block",
            new RawVulpusBlock(AbstractBlock.Settings.copy(ModBlocks.RAW_VIBRANIUM_BLOCK)
                    .strength(6.5f, 1200.0F).requiresTool()));

    public static final Block RAW_ENDERIUM_BLOCK = registerBlock("raw_enderium_block",
            new RawEnderiumBlock(AbstractBlock.Settings.copy(ModBlocks.RAW_VULPUS_BLOCK)
                    .strength(6.5f, 1200.0F).requiresTool()));

    public static final Block VIBRANIUM_ORE = registerBlock("vibranium_ore",
            new VibraniumOre(AbstractBlock.Settings.copy(Blocks.ANCIENT_DEBRIS)
                    .strength(6f, 1200.0F).requiresTool()));

    public static final Block VULPUS_ORE = registerBlock("vulpus_ore",
            new VulpusOre(AbstractBlock.Settings.copy(ModBlocks.VIBRANIUM_ORE)
                    .strength(6f, 1200.0F).requiresTool()));

    public static final Block ENDERIUM_ORE = registerBlock("enderium_ore",
            new EnderiumOre(AbstractBlock.Settings.copy(ModBlocks.VULPUS_ORE)
                    .strength(6f, 1200.0F).requiresTool()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ImmersiveOres.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        if (block instanceof ColoredBlock) {
            Registry.register(Registries.ITEM, Identifier.of(ImmersiveOres.MOD_ID, name),
                    new ColoredBlockItem(block, new Item.Settings().fireproof(), ((ColoredBlock) block).getColor()));
        } else {
            Registry.register(Registries.ITEM, Identifier.of(ImmersiveOres.MOD_ID, name),
                    new BlockItem(block, new Item.Settings().fireproof()));
        }
    }

    public static void registerModels() {
        ImmersiveOres.LOGGER.info("Registering Mod Blocks for " + ImmersiveOres.MOD_ID);
    }
}
