package com.blocklegend001.immersiveores.world;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.blocks.ModBlocks;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.BlockReplacement;
import net.minecraft.world.level.levelgen.feature.GeodeFeature;
import net.minecraft.world.level.levelgen.feature.OreFeature;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<Feature> OVERWORLD_VIBRANIUM_ORE_KEY = registerKey("vibranium_ore");
    public static final ResourceKey<Feature> NETHER_VULPUS_ORE_KEY = registerKey("nether_vulpus_ore");
    public static final ResourceKey<Feature> END_ENDERIUM_ORE_KEY = registerKey("end_enderium_ore");

    public static final ResourceKey<Feature> VIBRANIUM_GEODE_KEY = registerKey("vibranium_geode");
    public static final ResourceKey<Feature> VULPUS_GEODE_KEY = registerKey("vulpus_geode");
    public static final ResourceKey<Feature> ENDERIUM_GEODE_KEY = registerKey("enderium_geode");

    public static void bootstrap(BootstrapContext<Feature> context) {
        HolderGetter<Block> blockLookup = context.lookup(Registries.BLOCK);
        HolderSet<Block> featuresCannotReplace = blockLookup.getOrThrow(BlockTags.FEATURES_CANNOT_REPLACE);
        HolderSet<Block> geodeInvalidBlocks = blockLookup.getOrThrow(BlockTags.GEODE_INVALID_BLOCKS);

        RuleTest deepslateReplacables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplacables = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplacables = new BlockMatchTest(Blocks.END_STONE);

        List<BlockReplacement> overworldVibraniumOres = List.of(BlockReplacement.replace(deepslateReplacables,
                ModBlocks.VIBRANIUM_ORE.defaultBlockState()));
        List<BlockReplacement> netherVulpusOres = List.of(BlockReplacement.replace(netherReplacables,
                ModBlocks.VULPUS_ORE.defaultBlockState()));
        List<BlockReplacement> endEnderiumOres = List.of(BlockReplacement.replace(endReplacables,
                ModBlocks.ENDERIUM_ORE.defaultBlockState()));

        context.register(OVERWORLD_VIBRANIUM_ORE_KEY, new OreFeature(overworldVibraniumOres, 5));
        context.register(NETHER_VULPUS_ORE_KEY, new OreFeature(netherVulpusOres, 4));
        context.register(END_ENDERIUM_ORE_KEY, new OreFeature(endEnderiumOres, 4));

        context.register(VIBRANIUM_GEODE_KEY,
                new GeodeFeature(new GeodeBlockSettings(
                        BlockStateProvider.holderOf(Blocks.AIR),
                        BlockStateProvider.holderOf(Blocks.DEEPSLATE),
                        BlockStateProvider.holderOf(ModBlocks.VIBRANIUM_ORE),
                        BlockStateProvider.holderOf(ModBlocks.VIBRANIUM_BLOCK),
                        BlockStateProvider.holderOf(Blocks.COBBLED_DEEPSLATE),
                        List.of(ModBlocks.VIBRANIUM_ORE.defaultBlockState(), ModBlocks.VIBRANIUM_BLOCK.defaultBlockState()),
                        featuresCannotReplace,
                        geodeInvalidBlocks),
                        new GeodeLayerSettings(2.1D, 2.0D, 1.6D, 3.0D),
                        new GeodeCrackSettings(0.25D, 1.5D, 1), 0.5D, 0.1D,
                        true, UniformInt.of(4, 8),
                        UniformInt.of(2, 5),
                        UniformInt.of(1, 3),
                        3, 4, 0.05D, 2));

        context.register(VULPUS_GEODE_KEY,
                new GeodeFeature(new GeodeBlockSettings(
                        BlockStateProvider.holderOf(Blocks.AIR),
                        BlockStateProvider.holderOf(Blocks.NETHERRACK),
                        BlockStateProvider.holderOf(ModBlocks.VULPUS_ORE),
                        BlockStateProvider.holderOf(ModBlocks.VULPUS_BLOCK),
                        BlockStateProvider.holderOf(Blocks.NETHER_GOLD_ORE),
                        List.of(ModBlocks.VULPUS_ORE.defaultBlockState(), ModBlocks.VULPUS_BLOCK.defaultBlockState()),
                        featuresCannotReplace,
                        geodeInvalidBlocks),
                        new GeodeLayerSettings(2.1D, 2.0D, 1.6D, 3.0D),
                        new GeodeCrackSettings(0.25D, 1.5D, 1), 0.5D, 0.1D,
                        true, UniformInt.of(3, 6),
                        UniformInt.of(2, 4),
                        UniformInt.of(1, 3),
                        3, 4, 0.05D, 2));

        context.register(ENDERIUM_GEODE_KEY,
                new GeodeFeature(new GeodeBlockSettings(
                        BlockStateProvider.holderOf(Blocks.AIR),
                        BlockStateProvider.holderOf(Blocks.END_STONE),
                        BlockStateProvider.holderOf(ModBlocks.ENDERIUM_ORE),
                        BlockStateProvider.holderOf(ModBlocks.ENDERIUM_BLOCK),
                        BlockStateProvider.holderOf(Blocks.END_STONE_BRICKS),
                        List.of(ModBlocks.ENDERIUM_ORE.defaultBlockState(), ModBlocks.ENDERIUM_BLOCK.defaultBlockState()),
                        featuresCannotReplace,
                        geodeInvalidBlocks),
                        new GeodeLayerSettings(2.1D, 2.0D, 1.6D, 3.0D),
                        new GeodeCrackSettings(0.25D, 1.5D, 1), 0.5D, 0.1D,
                        true, UniformInt.of(3, 6),
                        UniformInt.of(2, 5),
                        UniformInt.of(1, 3),
                        3, 4, 0.05D, 2));
    }


    public static ResourceKey<Feature> registerKey(String name) {
        return ResourceKey.create(Registries.FEATURE, Identifier.fromNamespaceAndPath(ImmersiveOres.MOD_ID, name));
    }
}