package com.blocklegend001.immersiveores.world;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.blocks.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> OVERWORLD_VIBRANIUM_ORE_KEY = registerKey("vibranium_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_VULPUS_ORE_KEY = registerKey("nether_vulpus_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_ENDERIUM_ORE_KEY = registerKey("end_enderium_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> VIBRANIUM_GEODE_KEY = registerKey("vibranium_geode");
    public static final RegistryKey<ConfiguredFeature<?, ?>> VULPUS_GEODE_KEY = registerKey("vulpus_geode");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ENDERIUM_GEODE_KEY = registerKey("enderium_geode");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplacables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplacables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldVibraniumOres = List.of(OreFeatureConfig.createTarget(deepslateReplacables,
                ModBlocks.VIBRANIUM_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> netherVulpusOres = List.of(OreFeatureConfig.createTarget(netherReplacables,
                ModBlocks.VULPUS_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> endEnderiumOres = List.of(OreFeatureConfig.createTarget(endReplacables,
                ModBlocks.ENDERIUM_ORE.getDefaultState()));

        register(context, OVERWORLD_VIBRANIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldVibraniumOres, 4));
        register(context, NETHER_VULPUS_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherVulpusOres, 3));
        register(context, END_ENDERIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(endEnderiumOres, 3));

        register(context, VIBRANIUM_GEODE_KEY, Feature.GEODE,
                new GeodeFeatureConfig(new GeodeLayerConfig(
                        BlockStateProvider.of(Blocks.AIR),
                        BlockStateProvider.of(Blocks.DEEPSLATE),
                        BlockStateProvider.of(ModBlocks.VIBRANIUM_ORE),
                        BlockStateProvider.of(ModBlocks.VIBRANIUM_BLOCK),
                        BlockStateProvider.of(Blocks.COBBLED_DEEPSLATE),
                        List.of(ModBlocks.VIBRANIUM_ORE.getDefaultState(), ModBlocks.VIBRANIUM_BLOCK.getDefaultState()),
                        BlockTags.FEATURES_CANNOT_REPLACE,
                        BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerThicknessConfig(2.1D, 2.0D, 1.6D, 3.0D),
                        new GeodeCrackConfig(0.25D, 1.5D, 1), 0.5D, 0.1D,
                        true, UniformIntProvider.create(4, 8),
                        UniformIntProvider.create(2, 5),
                        UniformIntProvider.create(1, 3),
                        -80, 0, 0.075D, 1));

        register(context, VULPUS_GEODE_KEY, Feature.GEODE,
                new GeodeFeatureConfig(new GeodeLayerConfig(
                        BlockStateProvider.of(Blocks.AIR),
                        BlockStateProvider.of(Blocks.NETHERRACK),
                        BlockStateProvider.of(ModBlocks.VULPUS_ORE),
                        BlockStateProvider.of(ModBlocks.VULPUS_BLOCK),
                        BlockStateProvider.of(Blocks.NETHER_GOLD_ORE),
                        List.of(ModBlocks.VULPUS_ORE.getDefaultState(), ModBlocks.VULPUS_BLOCK.getDefaultState()),
                        BlockTags.FEATURES_CANNOT_REPLACE,
                        BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerThicknessConfig(2.1D, 2.0D, 1.6D, 3.0D),
                        new GeodeCrackConfig(0.25D, 1.5D, 1), 0.5D, 0.1D,
                        true, UniformIntProvider.create(3, 6),
                        UniformIntProvider.create(2, 4),
                        UniformIntProvider.create(1, 3),
                        0, 125, 0.075D, 1));

        register(context, ENDERIUM_GEODE_KEY, Feature.GEODE,
                new GeodeFeatureConfig(new GeodeLayerConfig(
                        BlockStateProvider.of(Blocks.AIR),
                        BlockStateProvider.of(Blocks.END_STONE),
                        BlockStateProvider.of(ModBlocks.ENDERIUM_ORE),
                        BlockStateProvider.of(ModBlocks.ENDERIUM_BLOCK),
                        BlockStateProvider.of(Blocks.END_STONE_BRICKS),
                        List.of(ModBlocks.ENDERIUM_ORE.getDefaultState(), ModBlocks.ENDERIUM_BLOCK.getDefaultState()),
                        BlockTags.FEATURES_CANNOT_REPLACE,
                        BlockTags.GEODE_INVALID_BLOCKS),
                        new GeodeLayerThicknessConfig(2.1D, 2.0D, 1.6D, 3.0D),
                        new GeodeCrackConfig(0.25D, 1.5D, 1), 0.5D, 0.1D,
                        true, UniformIntProvider.create(3, 6),
                        UniformIntProvider.create(2, 5),
                        UniformIntProvider.create(1, 3),
                        0, 125, 0.075D, 1));
    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(ImmersiveOres.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}