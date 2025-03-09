package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

import java.util.LinkedHashMap;
import java.util.List;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, ImmersiveOres.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        handheldItem(ModItems.VIBRANIUM_SWORD);
        handheldItem(ModItems.VIBRANIUM_PAXEL);
        handheldItem(ModItems.VIBRANIUM_PICKAXE);
        handheldItem(ModItems.VIBRANIUM_SHOVEL);
        handheldItem(ModItems.VIBRANIUM_HOE);
        handheldItem(ModItems.VIBRANIUM_HAMMER);
        handheldItem(ModItems.VIBRANIUM_EXCAVATOR);
        handheldItem(ModItems.VIBRANIUM_AXE);
        simpleItem(ModItems.VIBRANIUM_HORSE_ARMOR);
        simpleItem(ModItems.VIBRANIUM_HELMET);
        simpleItem(ModItems.VIBRANIUM_CHESTPLATE);
        simpleItem(ModItems.VIBRANIUM_LEGGINGS);
        simpleItem(ModItems.VIBRANIUM_BOOTS);
        simpleItem(ModItems.RAW_VIBRANIUM);
        simpleItem(ModItems.VIBRANIUM_INGOT);
        simpleItem(ModItems.VIBRANIUM_NUGGET);
        simpleItem(ModItems.VIBRANIUM_STICK);
        trimmedArmorItem(ModItems.VIBRANIUM_HELMET);
        trimmedArmorItem(ModItems.VIBRANIUM_CHESTPLATE);
        trimmedArmorItem(ModItems.VIBRANIUM_LEGGINGS);
        trimmedArmorItem(ModItems.VIBRANIUM_BOOTS);

        handheldItem(ModItems.ENDERIUM_SWORD);
        handheldItem(ModItems.ENDERIUM_PAXEL);
        handheldItem(ModItems.ENDERIUM_PICKAXE);
        handheldItem(ModItems.ENDERIUM_SHOVEL);
        handheldItem(ModItems.ENDERIUM_HOE);
        handheldItem(ModItems.ENDERIUM_HAMMER);
        handheldItem(ModItems.ENDERIUM_EXCAVATOR);
        handheldItem(ModItems.ENDERIUM_AXE);
        simpleItem(ModItems.ENDERIUM_HORSE_ARMOR);
        simpleItem(ModItems.ENDERIUM_HELMET);
        simpleItem(ModItems.ENDERIUM_CHESTPLATE);
        simpleItem(ModItems.ENDERIUM_LEGGINGS);
        simpleItem(ModItems.ENDERIUM_BOOTS);
        simpleItem(ModItems.RAW_ENDERIUM);
        simpleItem(ModItems.ENDERIUM_INGOT);
        simpleItem(ModItems.ENDERIUM_NUGGET);
        simpleItem(ModItems.ENDERIUM_STICK);
        trimmedArmorItem(ModItems.ENDERIUM_HELMET);
        trimmedArmorItem(ModItems.ENDERIUM_CHESTPLATE);
        trimmedArmorItem(ModItems.ENDERIUM_LEGGINGS);
        trimmedArmorItem(ModItems.ENDERIUM_BOOTS);

        handheldItem(ModItems.VULPUS_SWORD);
        handheldItem(ModItems.VULPUS_PAXEL);
        handheldItem(ModItems.VULPUS_PICKAXE);
        handheldItem(ModItems.VULPUS_SHOVEL);
        handheldItem(ModItems.VULPUS_HOE);
        handheldItem(ModItems.VULPUS_HAMMER);
        handheldItem(ModItems.VULPUS_EXCAVATOR);
        handheldItem(ModItems.VULPUS_AXE);
        simpleItem(ModItems.VULPUS_HORSE_ARMOR);
        simpleItem(ModItems.RAW_VULPUS);
        simpleItem(ModItems.VULPUS_INGOT);
        simpleItem(ModItems.VULPUS_NUGGET);
        simpleItem(ModItems.VULPUS_STICK);
        simpleItem(ModItems.VULPUS_HELMET);
        simpleItem(ModItems.VULPUS_CHESTPLATE);
        simpleItem(ModItems.VULPUS_LEGGINGS);
        simpleItem(ModItems.VULPUS_BOOTS);
        trimmedArmorItem(ModItems.VULPUS_HELMET);
        trimmedArmorItem(ModItems.VULPUS_CHESTPLATE);
        trimmedArmorItem(ModItems.VULPUS_LEGGINGS);
        trimmedArmorItem(ModItems.VULPUS_BOOTS);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID,"item/" + item.getId().getPath()));
    }

    private void trimmedArmorItem(RegistryObject<Item> itemRegistryObject) {
        final String MOD_ID = ImmersiveOres.MODID;

        if(itemRegistryObject.get() instanceof ArmorItem armorItem) {
            trimMaterials.entrySet().forEach(entry -> {

                ResourceKey<TrimMaterial> trimMaterial = entry.getKey();
                float trimValue = entry.getValue();

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = "item/" + itemRegistryObject.getId().getPath();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.fromNamespaceAndPath(MOD_ID, armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.withDefaultNamespace(trimPath);
                ResourceLocation trimNameResLoc = ResourceLocation.fromNamespaceAndPath(MOD_ID, currentTrimName);

                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc)
                        .texture("layer1", trimResLoc);

                this.withExistingParent(itemRegistryObject.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemRegistryObject.getId().getPath()));
            });
        }
    }
}