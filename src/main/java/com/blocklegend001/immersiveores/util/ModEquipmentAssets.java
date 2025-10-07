package com.blocklegend001.immersiveores.util;

import com.blocklegend001.immersiveores.ImmersiveOres;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.equipment.EquipmentAsset;

import java.util.function.BiConsumer;

public final class ModEquipmentAssets {
    private static final ResourceKey<? extends Registry<EquipmentAsset>> ROOT_ID = ResourceKey.createRegistryKey(ResourceLocation.withDefaultNamespace("equipment_asset"));

    public static final ResourceKey<EquipmentAsset> VIBRANIUM = id("vibranium");
    public static final ResourceKey<EquipmentAsset> VULPUS = id("vulpus");
    public static final ResourceKey<EquipmentAsset> ENDERIUM = id("enderium");

    private static ResourceKey<EquipmentAsset> id(String name) {
        return ResourceKey.create(ROOT_ID, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, name));
    }

    public static void bootstrap(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> consumer) {
        registerAssetWithLayers(consumer, ModEquipmentAssets.VIBRANIUM, "vibranium");
        registerAssetWithLayers(consumer, ModEquipmentAssets.VULPUS, "vulpus");
        registerAssetWithLayers(consumer, ModEquipmentAssets.ENDERIUM, "enderium");
    }

    private static void registerAssetWithLayers(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> consumer,
                                                ResourceKey<EquipmentAsset> asset, String name) {
        consumer.accept(asset, EquipmentClientInfo.builder()
                .addHumanoidLayers(ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, name))
                .addLayers(EquipmentClientInfo.LayerType.HORSE_BODY,
                        new EquipmentClientInfo.Layer(ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, name)))
                .build());
    }

}
