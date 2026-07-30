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
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_VIBRANIUM_ORE_KEY = registerKey("vibranium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_VULPUS_ORE_KEY = registerKey("nether_vulpus_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_ENDERIUM_ORE_KEY = registerKey("end_enderium_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> VIBRANIUM_GEODE_KEY = registerKey("vibranium_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VULPUS_GEODE_KEY = registerKey("vulpus_geode");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ENDERIUM_GEODE_KEY = registerKey("enderium_geode");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<Block> blockLookup = context.lookup(Registries.BLOCK);
        HolderSet<Block> featuresCannotReplace = blockLookup.getOrThrow(BlockTags.FEATURES_CANNOT_REPLACE);
        HolderSet<Block> geodeInvalidBlocks = blockLookup.getOrThrow(BlockTags.GEODE_INVALID_BLOCKS);

        RuleTest deepslateReplacables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplacables = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplacables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldVibraniumOres = List.of(OreConfiguration.target(deepslateReplacables,
                ModBlocks.VIBRANIUM_ORE.defaultBlockState()));
        List<OreConfiguration.TargetBlockState> netherVulpusOres = List.of(OreConfiguration.target(netherReplacables,
                ModBlocks.VULPUS_ORE.defaultBlockState()));
        List<OreConfiguration.TargetBlockState> endEnderiumOres = List.of(OreConfiguration.target(endReplacables,
                ModBlocks.ENDERIUM_ORE.defaultBlockState()));

        register(context, OVERWORLD_VIBRANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldVibraniumOres, 5));
        register(context, NETHER_VULPUS_ORE_KEY, Feature.ORE, new OreConfiguration(netherVulpusOres, 4));
        register(context, END_ENDERIUM_ORE_KEY, Feature.ORE, new OreConfiguration(endEnderiumOres, 4));

        register(context, VIBRANIUM_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(
                        BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(Blocks.DEEPSLATE),
                        BlockStateProvider.simple(ModBlocks.VIBRANIUM_ORE),
                        BlockStateProvider.simple(ModBlocks.VIBRANIUM_BLOCK),
                        BlockStateProvider.simple(Blocks.COBBLED_DEEPSLATE),
                        List.of(ModBlocks.VIBRANIUM_ORE.defaultBlockState(), ModBlocks.VIBRANIUM_BLOCK.defaultBlockState()),
                        featuresCannotReplace,
                        geodeInvalidBlocks),
                        new GeodeLayerSettings(2.1D, 2.0D, 1.6D, 3.0D),
                        new GeodeCrackSettings(0.25D, 1.5D, 1), 0.5D, 0.1D,
                        true, UniformInt.of(4, 8),
                        UniformInt.of(2, 5),
                        UniformInt.of(1, 3),
                        3, 4, 0.05D, 2));

        register(context, VULPUS_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(
                        BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(Blocks.NETHERRACK),
                        BlockStateProvider.simple(ModBlocks.VULPUS_ORE),
                        BlockStateProvider.simple(ModBlocks.VULPUS_BLOCK),
                        BlockStateProvider.simple(Blocks.NETHER_GOLD_ORE),
                        List.of(ModBlocks.VULPUS_ORE.defaultBlockState(), ModBlocks.VULPUS_BLOCK.defaultBlockState()),
                        featuresCannotReplace,
                        geodeInvalidBlocks),
                        new GeodeLayerSettings(2.1D, 2.0D, 1.6D, 3.0D),
                        new GeodeCrackSettings(0.25D, 1.5D, 1), 0.5D, 0.1D,
                        true, UniformInt.of(3, 6),
                        UniformInt.of(2, 4),
                        UniformInt.of(1, 3),
                        3, 4, 0.05D, 2));

        register(context, ENDERIUM_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(
                        BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(Blocks.END_STONE),
                        BlockStateProvider.simple(ModBlocks.ENDERIUM_ORE),
                        BlockStateProvider.simple(ModBlocks.ENDERIUM_BLOCK),
                        BlockStateProvider.simple(Blocks.END_STONE_BRICKS),
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


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Identifier.fromNamespaceAndPath(ImmersiveOres.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}