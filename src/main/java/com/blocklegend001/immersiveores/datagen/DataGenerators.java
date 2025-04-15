package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.ImmersiveOres;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = ImmersiveOres.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        event.addProvider(new ModRecipeProvider.Runner(packOutput, lookupProvider));

        event.addProvider(new ModModelProvider(packOutput, ImmersiveOres.MODID));

        event.addProvider(ModLootTableProvider.create(packOutput, lookupProvider));

        ModBlockTagGenerator blockTagGenerator = event.addProvider(
                new ModBlockTagGenerator(packOutput, lookupProvider));

        event.addProvider(new ModItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter()));

        event.addProvider(new ModWorldGenProvider(packOutput, lookupProvider));

        event.addProvider(new ModAdvancementProvider(packOutput, lookupProvider));

        event.addProvider(new ModEquipmentAssetProvider(packOutput));
    }
}