package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.block.ModBlocks;
import com.blocklegend001.immersiveores.item.ModItems;
import com.blocklegend001.immersiveores.util.ModEquipmentAssets;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.model.BlockStateModelWrapper;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.properties.numeric.UseDuration;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.level.block.Block;

import java.util.*;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput packOutput, String modId) {
        super(packOutput, ImmersiveOres.MODID);
    }

    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        blockModel(blockModels, ModBlocks.VIBRANIUM_ORE.get());
        blockModel(blockModels, ModBlocks.VULPUS_ORE.get());
        blockModel(blockModels, ModBlocks.ENDERIUM_ORE.get());
        blockModel(blockModels, ModBlocks.VIBRANIUM_BLOCK.get());
        blockModel(blockModels, ModBlocks.VULPUS_BLOCK.get());
        blockModel(blockModels, ModBlocks.ENDERIUM_BLOCK.get());
        blockModel(blockModels, ModBlocks.RAW_VIBRANIUM_BLOCK.get());
        blockModel(blockModels, ModBlocks.RAW_VULPUS_BLOCK.get());
        blockModel(blockModels, ModBlocks.RAW_ENDERIUM_BLOCK.get());

        itemModel(itemModels, ModItems.VIBRANIUM_INGOT.get());
        itemModel(itemModels, ModItems.VULPUS_INGOT.get());
        itemModel(itemModels, ModItems.ENDERIUM_INGOT.get());

        itemModel(itemModels, ModItems.VIBRANIUM_NUGGET.get());
        itemModel(itemModels, ModItems.VULPUS_NUGGET.get());
        itemModel(itemModels, ModItems.ENDERIUM_NUGGET.get());

        itemModel(itemModels, ModItems.VIBRANIUM_STICK.get());
        itemModel(itemModels, ModItems.VULPUS_STICK.get());
        itemModel(itemModels, ModItems.ENDERIUM_STICK.get());

        itemModel(itemModels, ModItems.RAW_VIBRANIUM.get());
        itemModel(itemModels, ModItems.RAW_VULPUS.get());
        itemModel(itemModels, ModItems.RAW_ENDERIUM.get());

        armorModel(itemModels, ModItems.VIBRANIUM_HORSE_ARMOR.get(), ModEquipmentAssets.VIBRANIUM);
        armorModel(itemModels, ModItems.VULPUS_HORSE_ARMOR.get(), ModEquipmentAssets.VULPUS);
        armorModel(itemModels, ModItems.ENDERIUM_HORSE_ARMOR.get(), ModEquipmentAssets.ENDERIUM);

        armorModel(itemModels, ModItems.VIBRANIUM_HELMET.get(), ModEquipmentAssets.VIBRANIUM);
        armorModel(itemModels, ModItems.VIBRANIUM_CHESTPLATE.get(), ModEquipmentAssets.VIBRANIUM);
        armorModel(itemModels, ModItems.VIBRANIUM_LEGGINGS.get(), ModEquipmentAssets.VIBRANIUM);
        armorModel(itemModels, ModItems.VIBRANIUM_BOOTS.get(), ModEquipmentAssets.VIBRANIUM);

        armorModel(itemModels, ModItems.VULPUS_HELMET.get(), ModEquipmentAssets.VULPUS);
        armorModel(itemModels, ModItems.VULPUS_CHESTPLATE.get(), ModEquipmentAssets.VULPUS);
        armorModel(itemModels, ModItems.VULPUS_LEGGINGS.get(), ModEquipmentAssets.VULPUS);
        armorModel(itemModels, ModItems.VULPUS_BOOTS.get(), ModEquipmentAssets.VULPUS);

        armorModel(itemModels, ModItems.ENDERIUM_HELMET.get(), ModEquipmentAssets.ENDERIUM);
        armorModel(itemModels, ModItems.ENDERIUM_CHESTPLATE.get(), ModEquipmentAssets.ENDERIUM);
        armorModel(itemModels, ModItems.ENDERIUM_LEGGINGS.get(), ModEquipmentAssets.ENDERIUM);
        armorModel(itemModels, ModItems.ENDERIUM_BOOTS.get(), ModEquipmentAssets.ENDERIUM);

        toolModel(itemModels, ModItems.VIBRANIUM_PICKAXE.get());
        toolModel(itemModels, ModItems.VULPUS_PICKAXE.get());
        toolModel(itemModels, ModItems.ENDERIUM_PICKAXE.get());

        toolModel(itemModels, ModItems.VIBRANIUM_SWORD.get());
        toolModel(itemModels, ModItems.VULPUS_SWORD.get());
        toolModel(itemModels, ModItems.ENDERIUM_SWORD.get());

        toolModel(itemModels, ModItems.VIBRANIUM_AXE.get());
        toolModel(itemModels, ModItems.VULPUS_AXE.get());
        toolModel(itemModels, ModItems.ENDERIUM_AXE.get());

        toolModel(itemModels, ModItems.VIBRANIUM_SHOVEL.get());
        toolModel(itemModels, ModItems.VULPUS_SHOVEL.get());
        toolModel(itemModels, ModItems.ENDERIUM_SHOVEL.get());

        toolModel(itemModels, ModItems.VIBRANIUM_HOE.get());
        toolModel(itemModels, ModItems.VULPUS_HOE.get());
        toolModel(itemModels, ModItems.ENDERIUM_HOE.get());

        toolModel(itemModels, ModItems.VIBRANIUM_HAMMER.get());
        toolModel(itemModels, ModItems.VULPUS_HAMMER.get());
        toolModel(itemModels, ModItems.ENDERIUM_HAMMER.get());

        toolModel(itemModels, ModItems.VIBRANIUM_EXCAVATOR.get());
        toolModel(itemModels, ModItems.VULPUS_EXCAVATOR.get());
        toolModel(itemModels, ModItems.ENDERIUM_EXCAVATOR.get());

        toolModel(itemModels, ModItems.VIBRANIUM_PAXEL.get());
        toolModel(itemModels, ModItems.VULPUS_PAXEL.get());
        toolModel(itemModels, ModItems.ENDERIUM_PAXEL.get());

        bowModel(itemModels, ModItems.VIBRANIUM_BOW.get());
        bowModel(itemModels, ModItems.VULPUS_BOW.get());
        bowModel(itemModels, ModItems.ENDERIUM_BOW.get());
    }

    public void blockModel(BlockModelGenerators blockModels, Block block)
    {
        blockModels.createTrivialCube(block);
    }

    public void itemModel(ItemModelGenerators itemModels, Item item)
    {
        itemModels.generateFlatItem(item, ModelTemplates.FLAT_ITEM);
    }

    public void toolModel(ItemModelGenerators itemModels, Item item)
    {
        itemModels.generateFlatItem(item, ModelTemplates.FLAT_HANDHELD_ITEM);
    }

    public void bowModel(ItemModelGenerators itemModels, Item item) {
        ItemModel.Unbaked itemmodel$unbaked = ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(item));
        ItemModel.Unbaked itemmodel = ItemModelUtils.plainModel(itemModels.createFlatItemModel(item, ModelTemplates.FLAT_ITEM));
        ItemModel.Unbaked itemmodel$unbaked1 = ItemModelUtils.plainModel(itemModels.createFlatItemModel(item, "_pulling_0", ModelTemplates.BOW));
        ItemModel.Unbaked itemmodel$unbaked2 = ItemModelUtils.plainModel(itemModels.createFlatItemModel(item, "_pulling_1", ModelTemplates.BOW));
        ItemModel.Unbaked itemmodel$unbaked3 = ItemModelUtils.plainModel(itemModels.createFlatItemModel(item, "_pulling_2", ModelTemplates.BOW));
        itemModels.itemModelOutput
                .accept(
                        item,
                        ItemModelUtils.conditional(
                                ItemModelUtils.isUsingItem(),
                                ItemModelUtils.rangeSelect(
                                        new UseDuration(false),
                                        0.05F,
                                        itemmodel$unbaked1,
                                        ItemModelUtils.override(itemmodel$unbaked2, 0.65F),
                                        ItemModelUtils.override(itemmodel$unbaked3, 0.9F)
                                ),
                                itemmodel$unbaked
                        )
                );
    }

    public void armorModel(ItemModelGenerators itemModels, Item item, ResourceKey<EquipmentAsset> equipmentKey) {
        Identifier id = BuiltInRegistries.ITEM.getKey(item);
        Identifier trimPrefix;
        if (id.getPath().contains("helmet"))
            trimPrefix = ItemModelGenerators.TRIM_PREFIX_HELMET;
        else if (id.getPath().contains("chestplate"))
            trimPrefix = ItemModelGenerators.TRIM_PREFIX_CHESTPLATE;
        else if (id.getPath().contains("leggings"))
            trimPrefix = ItemModelGenerators.TRIM_PREFIX_LEGGINGS;
        else if (id.getPath().contains("boots"))
            trimPrefix = ItemModelGenerators.TRIM_PREFIX_BOOTS;
        else
            trimPrefix = ItemModelGenerators.TRIM_PREFIX_HELMET;

        itemModels.generateTrimmableItem(item, equipmentKey, trimPrefix, false);
    }
}