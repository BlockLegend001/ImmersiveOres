package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.util.ModEquipmentAssets;
import net.minecraft.client.data.models.EquipmentAssetProvider;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class ModEquipmentAssetProvider extends EquipmentAssetProvider
{
    protected final PackOutput.PathProvider pathProvider;

    public ModEquipmentAssetProvider(PackOutput packOutput)
    {
        super(packOutput);
        this.pathProvider = packOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "equipment");
    }

    @Override
    public CompletableFuture<?> run(CachedOutput output)
    {
        Map<ResourceKey<EquipmentAsset>, EquipmentClientInfo> map = new HashMap<>();
        ModEquipmentAssets.bootstrap((key, info) -> {
            if (map.putIfAbsent(key, info) != null)
            {
                throw new IllegalStateException("Duplicate equipment model for id: " + key.location().toString());
            }
        });
        return DataProvider.saveAll(output, EquipmentClientInfo.CODEC, this.pathProvider::json, map);
    }
}