package com.blocklegend001.immersiveores.blocks;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.blocks.custom.enderium.*;
import com.blocklegend001.immersiveores.blocks.custom.vibranium.*;
import com.blocklegend001.immersiveores.blocks.custom.vulpus.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block VIBRANIUM_BLOCK = registerBlock("vibranium_block",
             new VibraniumBlock(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK)
                    .strength(6.5f).requiresTool()
                     .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ImmersiveOres.MOD_ID, "vibranium_block")))));

    public static final Block VULPUS_BLOCK = registerBlock("vulpus_block",
             new VulpusBlock(AbstractBlock.Settings.copy(ModBlocks.VIBRANIUM_BLOCK)
                    .strength(6.5f).requiresTool()
                     .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ImmersiveOres.MOD_ID, "vulpus_block")))));

    public static final Block ENDERIUM_BLOCK = registerBlock("enderium_block",
             new EnderiumBlock(AbstractBlock.Settings.copy(ModBlocks.VULPUS_BLOCK)
                    .strength(6.5f).requiresTool()
                     .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ImmersiveOres.MOD_ID, "enderium_block")))));

    public static final Block RAW_VIBRANIUM_BLOCK = registerBlock("raw_vibranium_block",
             new RawVibraniumBlock(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK)
                    .strength(6.5f).requiresTool()
                     .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ImmersiveOres.MOD_ID, "raw_vibranium_block")))));

    public static final Block RAW_VULPUS_BLOCK = registerBlock("raw_vulpus_block",
             new RawVulpusBlock(AbstractBlock.Settings.copy(ModBlocks.RAW_VIBRANIUM_BLOCK)
                    .strength(6.5f).requiresTool()
                     .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ImmersiveOres.MOD_ID, "raw_vulpus_block")))));

    public static final Block RAW_ENDERIUM_BLOCK = registerBlock("raw_enderium_block",
             new RawEnderiumBlock(AbstractBlock.Settings.copy(ModBlocks.RAW_VULPUS_BLOCK)
                    .strength(6.5f).requiresTool()
                     .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ImmersiveOres.MOD_ID, "raw_enderium_block")))));

    public static final Block VIBRANIUM_ORE = registerBlock("vibranium_ore",
             new VibraniumOre(AbstractBlock.Settings.copy(Blocks.ANCIENT_DEBRIS)
                    .strength(6f).requiresTool()
                     .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ImmersiveOres.MOD_ID, "vibranium_ore")))));

    public static final Block VULPUS_ORE = registerBlock("vulpus_ore",
             new VulpusOre(AbstractBlock.Settings.copy(ModBlocks.VIBRANIUM_ORE)
                    .strength(6f).requiresTool()
                     .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ImmersiveOres.MOD_ID, "vulpus_ore")))));

    public static final Block ENDERIUM_ORE = registerBlock("enderium_ore",
             new EnderiumOre(AbstractBlock.Settings.copy(ModBlocks.VULPUS_ORE)
                    .strength(6f).requiresTool()
                     .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(ImmersiveOres.MOD_ID, "enderium_ore")))));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(ImmersiveOres.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(ImmersiveOres.MOD_ID, name),
                new BlockItem(block, new Item.Settings()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, name))).useBlockPrefixedTranslationKey()));
    }

    public static void registerModels() {
        ImmersiveOres.LOGGER.info("Registering Mod Blocks for " + ImmersiveOres.MOD_ID);
    }
}
