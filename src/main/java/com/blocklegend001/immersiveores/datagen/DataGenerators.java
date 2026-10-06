package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.ImmersiveOres;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = ImmersiveOres.MODID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        var builder = new RegistrySetBuilder()
                .add(ModRecipeProvider.create())
                .add(Registries.LOOT_TABLE, new ModBlockLootTables())
                .add(Registries.ADVANCEMENT, new ModAdvancementProvider());
        event.createReloadableRegistryObjects(builder);
        event.createProvider(ModBlockTagGenerator::new);
        event.createProvider(ModItemTagGenerator::new);
        event.createProvider(ModModelProvider::new);
        event.createProvider(ModEquipmentAssetProvider::new);
        event.createWorldRegistryObjects(ModWorldGenProvider.BUILDER);
    }
}