package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.blocks.ModBlocks;
import com.blocklegend001.immersiveores.item.ModItems;
import com.blocklegend001.immersiveores.util.ModEquipmentAssets;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.Variant;
import net.minecraft.client.data.models.blockstates.VariantProperties;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.BlockModelWrapper;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.level.block.Block;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class ModModelProvider extends ModelProvider {
    private final PackOutput.PathProvider blockStatePathProvider;
    private final PackOutput.PathProvider itemInfoPathProvider;
    private final PackOutput.PathProvider modelPathProvider;
    protected final String modId;

    public ModModelProvider(PackOutput packOutput, String modId) {
        super(packOutput);
        this.blockStatePathProvider = packOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "blockstates");
        this.itemInfoPathProvider = packOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "items");
        this.modelPathProvider = packOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "models");
        this.modId = modId;
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
    }

    public void blockModel(BlockModelGenerators blockModels, Block block) {
        blockModels.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block, Variant.variant().with(VariantProperties.MODEL, TexturedModel.CUBE.create(block, blockModels.modelOutput))));
        ResourceLocation blockId = BuiltInRegistries.BLOCK.getKey(block);
        ResourceLocation textureLoc = ResourceLocation.fromNamespaceAndPath(blockId.getNamespace(), "block/" + blockId.getPath());
        blockModels.itemModelOutput.accept(block.asItem(), new BlockModelWrapper.Unbaked(textureLoc, Collections.emptyList()));
    }

    public void itemModel(ItemModelGenerators itemModels, Item item) {
        this.itemModel(itemModels, item, ModelTemplates.FLAT_ITEM);
    }

    public void toolModel(ItemModelGenerators itemModels, Item item) {
        this.itemModel(itemModels, item, ModelTemplates.FLAT_HANDHELD_ITEM);
    }

    public void itemModel(ItemModelGenerators itemModels, Item item, ModelTemplate template) {
        ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
        ResourceLocation textureLoc = ResourceLocation.fromNamespaceAndPath(itemId.getNamespace(), "item/" + itemId.getPath());
        TextureMapping textureMapping = new TextureMapping().put(TextureSlot.LAYER0, textureLoc);
        itemModels.itemModelOutput.accept(item, new BlockModelWrapper.Unbaked(template.create(item, textureMapping, itemModels.modelOutput), Collections.emptyList()));
    }

    public void armorModel(ItemModelGenerators itemModels, Item item, ResourceKey<EquipmentAsset> equipmentKey) {
        ResourceLocation id = BuiltInRegistries.ITEM.getKey(item);
        String armorType = "";
        if (id.getPath().contains("helmet"))
            armorType = "helmet";
        else if (id.getPath().contains("chestplate"))
            armorType = "chestplate";
        else if (id.getPath().contains("leggings"))
            armorType = "leggings";
        else if (id.getPath().contains("boots"))
            armorType = "boots";
        itemModels.generateTrimmableItem(item, equipmentKey, armorType, false);
    }

    @Override
    public CompletableFuture<?> run(CachedOutput output) {
        ItemInfoCollector itemCollector = new ItemInfoCollector(this::getKnownItems);
        BlockStateGeneratorCollector blockStateCollector = new BlockStateGeneratorCollector(this::getKnownBlocks);
        SimpleModelCollector simpleModelCollector = new SimpleModelCollector();
        this.registerModels(new BlockModelGenerators(blockStateCollector, itemCollector, simpleModelCollector), new ItemModelGenerators(itemCollector, simpleModelCollector));
        blockStateCollector.validate();
        itemCollector.finalizeAndValidate();
        return CompletableFuture.allOf(
                blockStateCollector.save(output, this.blockStatePathProvider),
                simpleModelCollector.save(output, this.modelPathProvider),
                itemCollector.save(output, this.itemInfoPathProvider)
        );
    }

    @Override
    protected Stream<Block> getKnownBlocks() {
        return BuiltInRegistries.BLOCK.stream()
                .filter((block) -> Optional.of(BuiltInRegistries.BLOCK.getKey(block))
                        .filter((key) -> key.getNamespace().equals(this.modId))
                        .isPresent());
    }

    @Override
    protected Stream<Item> getKnownItems() {
        return BuiltInRegistries.ITEM.stream()
                .filter((item) -> Optional.of(BuiltInRegistries.ITEM.getKey(item))
                        .filter((key) -> key.getNamespace().equals(this.modId))
                        .isPresent())
                .filter((item) -> !isExcluded(item)); // Filtra gli archi da escludere
    }

    private boolean isExcluded(Item item) {
        return item == ModItems.ENDERIUM_BOW.get() || item == ModItems.VIBRANIUM_BOW.get() || item == ModItems.VULPUS_BOW.get();
    }
}