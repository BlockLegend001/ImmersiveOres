package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.world.ModBiomeModifiers;
import com.blocklegend001.immersiveores.world.ModConfiguredFeatures;
import com.blocklegend001.immersiveores.world.ModPlacedFeatures;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModWorldGenProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.FEATURE, ModConfiguredFeatures::boostrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);
}
