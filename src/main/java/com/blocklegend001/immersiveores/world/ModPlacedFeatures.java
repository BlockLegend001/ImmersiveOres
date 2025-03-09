package com.blocklegend001.immersiveores.world;

import com.blocklegend001.immersiveores.ImmersiveOres;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> VIBRANIUM_ORE_PLACED_KEY = registerKey("vibranium_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_VULPUS_ORE_PLACED_KEY = registerKey("nether_vulpus_ore_placed");
    public static final RegistryKey<PlacedFeature> END_ENDERIUM_ORE_PLACED_KEY = registerKey("end_enderium_ore_placed");

    public static final RegistryKey<PlacedFeature> VIBRANIUM_GEODE_PLACED_KEY = registerKey("vibranium_geode_placed");
    public static final RegistryKey<PlacedFeature> VULPUS_GEODE_PLACED_KEY = registerKey("vulpus_geode_placed");
    public static final RegistryKey<PlacedFeature> ENDERIUM_GEODE_PLACED_KEY = registerKey("enderium_geode_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
                
        register(context, VIBRANIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.OVERWORLD_VIBRANIUM_ORE_KEY),
                ModOrePlacement.modifiersWithCount(6,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(0))));
        register(context, NETHER_VULPUS_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NETHER_VULPUS_ORE_KEY),
                ModOrePlacement.modifiersWithCount(5,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(125))));
        register(context, END_ENDERIUM_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.END_ENDERIUM_ORE_KEY),
                ModOrePlacement.modifiersWithCount(4,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(125))));

        register(context, VIBRANIUM_GEODE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.VIBRANIUM_GEODE_KEY), List.of(
                RarityFilterPlacementModifier.of(40), SquarePlacementModifier.of(),
                HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(0))));
        register(context, VULPUS_GEODE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.VULPUS_GEODE_KEY), List.of(
                RarityFilterPlacementModifier.of(50), SquarePlacementModifier.of(),
                HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(125))));
        register(context, ENDERIUM_GEODE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ENDERIUM_GEODE_KEY), List.of(
                RarityFilterPlacementModifier.of(55), SquarePlacementModifier.of(),
                HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.fixed(125))));
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(ImmersiveOres.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
