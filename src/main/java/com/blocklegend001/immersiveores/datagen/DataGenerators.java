package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.ImmersiveOres;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.data.event.GatherDataRegistryEntriesEvent;

@EventBusSubscriber(modid = ImmersiveOres.MODID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        var builder = new RegistrySetBuilder()
                .add(Registries.LOOT_TABLE, new ModBlockLootTables())
                .add(Registries.ADVANCEMENT, new ModAdvancementProvider());
        event.getDefaultPackGenerator().createReloadableRegistryObjects(builder);
        event.createProvider(ModBlockTagGenerator::new);
        event.createProvider(ModItemTagGenerator::new);
        event.createProvider(ModModelProvider::new);
        event.createProvider(ModEquipmentAssetProvider::new);
        event.getDefaultPackGenerator().createWorldRegistryObjects(ModWorldGenProvider.BUILDER);
    }

    @SubscribeEvent
    public static void gatherRegistries(GatherDataRegistryEntriesEvent event) {
        event.add(ModRecipeProvider.create());
    }
}