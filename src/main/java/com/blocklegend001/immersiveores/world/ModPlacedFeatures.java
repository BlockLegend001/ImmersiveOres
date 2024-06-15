package com.blocklegend001.immersiveores.world;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.ImmersiveOresConfig;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> VIBRANIUM_ORE_PLACED_KEY = registerKey("vibranium_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_VULPUS_ORE_PLACED_KEY = registerKey("nether_vulpus_ore_placed");
    public static final ResourceKey<PlacedFeature> END_ENDERIUM_ORE_PLACED_KEY = registerKey("end_enderium_ore_placed");

    public static final ResourceKey<PlacedFeature> VIBRANIUM_GEODE_PLACED_KEY = registerKey("vibranium_geode_placed");
    public static final ResourceKey<PlacedFeature> VULPUS_GEODE_PLACED_KEY = registerKey("vulpus_geode_placed");
    public static final ResourceKey<PlacedFeature> ENDERIUM_GEODE_PLACED_KEY = registerKey("enderium_geode_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, VIBRANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_VIBRANIUM_ORE_KEY),
                ModOrePlacement.commonOrePlacement(ImmersiveOresConfig.VeinsPerChunkVibranium.get(),
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(0))));
        register(context, NETHER_VULPUS_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_VULPUS_ORE_KEY),
                ModOrePlacement.commonOrePlacement(ImmersiveOresConfig.VeinsPerChunkVulpus.get(),
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(125))));
        register(context, END_ENDERIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_ENDERIUM_ORE_KEY),
                ModOrePlacement.commonOrePlacement(ImmersiveOresConfig.VeinsPerChunkEnderium.get(),
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(125))));

        register(context, VIBRANIUM_GEODE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.VIBRANIUM_GEODE_KEY), List.of(
                RarityFilter.onAverageOnceEvery(50), InSquarePlacement.spread(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(0)),
                BiomeFilter.biome()));
        register(context, VULPUS_GEODE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.VULPUS_GEODE_KEY), List.of(
                RarityFilter.onAverageOnceEvery(53), InSquarePlacement.spread(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(125)),
                BiomeFilter.biome()));
        register(context, ENDERIUM_GEODE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ENDERIUM_GEODE_KEY), List.of(
                RarityFilter.onAverageOnceEvery(55), InSquarePlacement.spread(),
                HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(125)),
                BiomeFilter.biome()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(ImmersiveOres.MODID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
