package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.blocks.ModBlocks;
import com.blocklegend001.immersiveores.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeGenerator;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> VIBRANIUM_SMELTABLES = List.of(ModItems.RAW_VIBRANIUM,
            ModBlocks.VIBRANIUM_ORE, ModBlocks.RAW_VIBRANIUM_BLOCK);

    private static final List<ItemConvertible> VULPUS_SMELTABLES = List.of(ModItems.RAW_VULPUS,
            ModBlocks.VULPUS_ORE, ModBlocks.RAW_VULPUS_BLOCK);
    
    private static final List<ItemConvertible> ENDERIUM_SMELTABLES = List.of(ModItems.RAW_ENDERIUM,
            ModBlocks.ENDERIUM_ORE, ModBlocks.RAW_ENDERIUM_BLOCK);

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                //VIBRANIUM
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_VIBRANIUM_BLOCK)
                        .input('V', ModItems.RAW_VIBRANIUM)
                        .pattern("VVV")
                        .pattern("VVV")
                        .pattern("VVV")
                        .criterion("has_raw_vibranium", conditionsFromItem(ModItems.RAW_VIBRANIUM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VIBRANIUM_BLOCK)
                        .input('V', ModItems.VIBRANIUM_INGOT)
                        .pattern("VVV")
                        .pattern("VVV")
                        .pattern("VVV")
                        .criterion("has_vibranium_ingot", conditionsFromItem(ModItems.VIBRANIUM_INGOT))
                        .offerTo(exporter);

                offerSmelting(VIBRANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.VIBRANIUM_INGOT,
                        1.0f, 200, "immersiveores:vibranium_ingot_cooked");

                createShapeless(RecipeCategory.MISC, ModItems.VIBRANIUM_NUGGET, 9)
                        .input(Ingredient.ofItems(ModItems.VIBRANIUM_INGOT.asItem()))
                        .criterion("has_vibranium_ingot", conditionsFromItem(ModItems.VIBRANIUM_INGOT))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.MISC, ModItems.RAW_VIBRANIUM, 9)
                        .input(Ingredient.ofItems(ModBlocks.RAW_VIBRANIUM_BLOCK.asItem()))
                        .criterion("has_vibranium_block", conditionsFromItem(ModBlocks.RAW_VIBRANIUM_BLOCK))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.MISC, ModItems.VIBRANIUM_INGOT, 9)
                        .input(Ingredient.ofItems(ModBlocks.VIBRANIUM_BLOCK.asItem()))
                        .criterion("has_vibranium_block", conditionsFromItem(ModBlocks.VIBRANIUM_BLOCK))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.VIBRANIUM_INGOT)
                        .input('E', ModItems.VIBRANIUM_NUGGET)
                        .pattern("EEE")
                        .pattern("EEE")
                        .pattern("EEE")
                        .criterion("has_vibranium_nugget", conditionsFromItem(ModItems.VIBRANIUM_NUGGET))
                        .offerTo(exporter, "immersiveores:vibranium_ingot_craft");

                createShaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_HELMET)
                        .input('V', ModItems.VIBRANIUM_INGOT)
                        .input('N', Items.NETHERITE_HELMET)
                        .pattern("VVV")
                        .pattern("VNV")
                        .pattern("   ")
                        .criterion("has_vibranium_ingot", conditionsFromItem(ModItems.VIBRANIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_CHESTPLATE)
                        .input('V', ModItems.VIBRANIUM_INGOT)
                        .input('N', Items.NETHERITE_CHESTPLATE)
                        .pattern("VNV")
                        .pattern("VVV")
                        .pattern("VVV")
                        .criterion("has_vibranium_ingot", conditionsFromItem(ModItems.VIBRANIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_LEGGINGS)
                        .input('V', ModItems.VIBRANIUM_INGOT)
                        .input('N', Items.NETHERITE_LEGGINGS)
                        .pattern("VVV")
                        .pattern("VNV")
                        .pattern("V V")
                        .criterion("has_vibranium_ingot", conditionsFromItem(ModItems.VIBRANIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_BOOTS)
                        .input('V', ModItems.VIBRANIUM_INGOT)
                        .input('N', Items.NETHERITE_BOOTS)
                        .pattern("   ")
                        .pattern("V V")
                        .pattern("VNV")
                        .criterion("has_vibranium_ingot", conditionsFromItem(ModItems.VIBRANIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_HORSE_ARMOR)
                        .input('E', ModItems.VIBRANIUM_INGOT)
                        .input('W', ItemTags.WOOL)
                        .pattern("E E")
                        .pattern("EEE")
                        .pattern("EWE")
                        .criterion("has_vibranium_ingot", conditionsFromItem(ModItems.VIBRANIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.VIBRANIUM_STICK)
                        .input('E', ModItems.VIBRANIUM_INGOT)
                        .pattern("   ")
                        .pattern(" E ")
                        .pattern(" E ")
                        .criterion("has_vibranium_ingot", conditionsFromItem(ModItems.VIBRANIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_HAMMER)
                        .input('E', ModItems.VIBRANIUM_INGOT)
                        .input('W', ModBlocks.VIBRANIUM_BLOCK)
                        .input('S', ModItems.VIBRANIUM_STICK)
                        .pattern("WEW")
                        .pattern(" S ")
                        .pattern(" S ")
                        .criterion("has_vibranium_ingot", conditionsFromItem(ModItems.VIBRANIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_EXCAVATOR)
                        .input('E', ModItems.VIBRANIUM_INGOT)
                        .input('W', ModBlocks.VIBRANIUM_BLOCK)
                        .input('S', ModItems.VIBRANIUM_STICK)
                        .pattern(" E ")
                        .pattern("WSW")
                        .pattern(" S ")
                        .criterion("has_vibranium_ingot", conditionsFromItem(ModItems.VIBRANIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_PAXEL)
                        .input('E', ModItems.VIBRANIUM_AXE)
                        .input('W', ModItems.VIBRANIUM_PICKAXE)
                        .input('T', ModItems.VIBRANIUM_SHOVEL)
                        .input('S', ModItems.VIBRANIUM_STICK)
                        .pattern("WTE")
                        .pattern(" S ")
                        .pattern(" S ")
                        .criterion("has_vibranium_stick", conditionsFromItem(ModItems.VIBRANIUM_STICK))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_AXE)
                        .input('E', ModItems.VIBRANIUM_INGOT)
                        .input('S', ModItems.VIBRANIUM_STICK)
                        .pattern(" EE")
                        .pattern(" SE")
                        .pattern(" S ")
                        .criterion("has_vibranium_ingot", conditionsFromItem(ModItems.VIBRANIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_PICKAXE)
                        .input('E', ModItems.VIBRANIUM_INGOT)
                        .input('S', ModItems.VIBRANIUM_STICK)
                        .pattern("EEE")
                        .pattern(" S ")
                        .pattern(" S ")
                        .criterion("has_vibranium_ingot", conditionsFromItem(ModItems.VIBRANIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_SWORD)
                        .input('E', ModItems.VIBRANIUM_INGOT)
                        .input('S', ModItems.VIBRANIUM_STICK)
                        .pattern(" E ")
                        .pattern(" E ")
                        .pattern(" S ")
                        .criterion("has_vibranium_ingot", conditionsFromItem(ModItems.VIBRANIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_SHOVEL)
                        .input('E', ModItems.VIBRANIUM_INGOT)
                        .input('S', ModItems.VIBRANIUM_STICK)
                        .pattern(" E ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .criterion("has_vibranium_ingot", conditionsFromItem(ModItems.VIBRANIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_HOE)
                        .input('E', ModItems.VIBRANIUM_INGOT)
                        .input('S', ModItems.VIBRANIUM_STICK)
                        .pattern(" EE")
                        .pattern(" S ")
                        .pattern(" S ")
                        .criterion("has_vibranium_ingot", conditionsFromItem(ModItems.VIBRANIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_BOW)
                        .input('E', ModItems.VIBRANIUM_INGOT)
                        .input('S', ModItems.VIBRANIUM_STICK)
                        .input('D', Items.STRING)
                        .pattern(" SD")
                        .pattern("SED")
                        .pattern(" SD")
                        .criterion("has_vibranium_ingot", conditionsFromItem(ModItems.VIBRANIUM_INGOT))
                        .offerTo(exporter);

                //VULPUS
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_VULPUS_BLOCK)
                        .input('V', ModItems.RAW_VULPUS)
                        .pattern("VVV")
                        .pattern("VVV")
                        .pattern("VVV")
                        .criterion("has_raw_vulpus", conditionsFromItem(ModItems.RAW_VULPUS))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VULPUS_BLOCK)
                        .input('V', ModItems.VULPUS_INGOT)
                        .pattern("VVV")
                        .pattern("VVV")
                        .pattern("VVV")
                        .criterion("has_vulpus_ingot", conditionsFromItem(ModItems.VULPUS_INGOT))
                        .offerTo(exporter);

                offerSmelting(VULPUS_SMELTABLES, RecipeCategory.MISC, ModItems.VULPUS_INGOT,
                        1.0f, 225, "immersiveores:vulpus_ingot_cooked");

                createShapeless(RecipeCategory.MISC, ModItems.VULPUS_NUGGET, 9)
                        .input(Ingredient.ofItems(ModItems.VULPUS_INGOT.asItem()))
                        .criterion("has_vulpus_ingot", conditionsFromItem(ModItems.VULPUS_INGOT))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.MISC, ModItems.RAW_VULPUS, 9)
                        .input(Ingredient.ofItems(ModBlocks.RAW_VULPUS_BLOCK.asItem()))
                        .criterion("has_vulpus_block", conditionsFromItem(ModBlocks.RAW_VULPUS_BLOCK))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.MISC, ModItems.VULPUS_INGOT, 9)
                        .input(Ingredient.ofItems(ModBlocks.VULPUS_BLOCK.asItem()))
                        .criterion("has_vulpus_block", conditionsFromItem(ModBlocks.VULPUS_BLOCK))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.VULPUS_INGOT)
                        .input('E', ModItems.VULPUS_NUGGET)
                        .pattern("EEE")
                        .pattern("EEE")
                        .pattern("EEE")
                        .criterion("has_vulpus_nugget", conditionsFromItem(ModItems.VULPUS_NUGGET))
                        .offerTo(exporter, "immersiveores:vulpus_ingot_craft");

                createShaped(RecipeCategory.COMBAT, ModItems.VULPUS_HELMET)
                        .input('E', ModItems.VULPUS_INGOT)
                        .input('N', ModItems.VIBRANIUM_HELMET)
                        .pattern("EEE")
                        .pattern("ENE")
                        .pattern("   ")
                        .criterion("has_vulpus_ingot", conditionsFromItem(ModItems.VULPUS_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.VULPUS_CHESTPLATE)
                        .input('E', ModItems.VULPUS_INGOT)
                        .input('N', ModItems.VIBRANIUM_CHESTPLATE)
                        .pattern("ENE")
                        .pattern("EEE")
                        .pattern("EEE")
                        .criterion("has_vulpus_ingot", conditionsFromItem(ModItems.VULPUS_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.VULPUS_LEGGINGS)
                        .input('E', ModItems.VULPUS_INGOT)
                        .input('N', ModItems.VIBRANIUM_LEGGINGS)
                        .pattern("EEE")
                        .pattern("ENE")
                        .pattern("E E")
                        .criterion("has_vulpus_ingot", conditionsFromItem(ModItems.VULPUS_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.VULPUS_BOOTS)
                        .input('E', ModItems.VULPUS_INGOT)
                        .input('N', ModItems.VIBRANIUM_BOOTS)
                        .pattern("   ")
                        .pattern("E E")
                        .pattern("ENE")
                        .criterion("has_vulpus_ingot", conditionsFromItem(ModItems.VULPUS_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.VULPUS_HORSE_ARMOR)
                        .input('E', ModItems.VULPUS_INGOT)
                        .input('W', ModItems.VIBRANIUM_HORSE_ARMOR)
                        .pattern("E E")
                        .pattern("EEE")
                        .pattern("EWE")
                        .criterion("has_vulpus_ingot", conditionsFromItem(ModItems.VULPUS_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.VULPUS_STICK)
                        .input('E', ModItems.VULPUS_INGOT)
                        .pattern("   ")
                        .pattern(" E ")
                        .pattern(" E ")
                        .criterion("has_vulpus_ingot", conditionsFromItem(ModItems.VULPUS_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.VULPUS_HAMMER)
                        .input('E', ModItems.VULPUS_INGOT)
                        .input('W', ModBlocks.VULPUS_BLOCK)
                        .input('S', ModItems.VULPUS_STICK)
                        .pattern("WEW")
                        .pattern(" S ")
                        .pattern(" S ")
                        .criterion("has_vulpus_ingot", conditionsFromItem(ModItems.VULPUS_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.VULPUS_EXCAVATOR)
                        .input('E', ModItems.VULPUS_INGOT)
                        .input('W', ModBlocks.VULPUS_BLOCK)
                        .input('S', ModItems.VULPUS_STICK)
                        .pattern(" E ")
                        .pattern("WSW")
                        .pattern(" S ")
                        .criterion("has_vulpus_ingot", conditionsFromItem(ModItems.VULPUS_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.VULPUS_PAXEL)
                        .input('E', ModItems.VULPUS_AXE)
                        .input('W', ModItems.VULPUS_PICKAXE)
                        .input('T', ModItems.VULPUS_SHOVEL)
                        .input('S', ModItems.VULPUS_STICK)
                        .pattern("WTE")
                        .pattern(" S ")
                        .pattern(" S ")
                        .criterion("has_vulpus_stick", conditionsFromItem(ModItems.VULPUS_STICK))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.VULPUS_AXE)
                        .input('E', ModItems.VULPUS_INGOT)
                        .input('S', ModItems.VULPUS_STICK)
                        .pattern(" EE")
                        .pattern(" SE")
                        .pattern(" S ")
                        .criterion("has_vulpus_ingot", conditionsFromItem(ModItems.VULPUS_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.VULPUS_PICKAXE)
                        .input('E', ModItems.VULPUS_INGOT)
                        .input('S', ModItems.VULPUS_STICK)
                        .pattern("EEE")
                        .pattern(" S ")
                        .pattern(" S ")
                        .criterion("has_vulpus_ingot", conditionsFromItem(ModItems.VULPUS_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.VULPUS_SWORD)
                        .input('E', ModItems.VULPUS_INGOT)
                        .input('S', ModItems.VULPUS_STICK)
                        .pattern(" E ")
                        .pattern(" E ")
                        .pattern(" S ")
                        .criterion("has_vulpus_ingot", conditionsFromItem(ModItems.VULPUS_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.VULPUS_SHOVEL)
                        .input('E', ModItems.VULPUS_INGOT)
                        .input('S', ModItems.VULPUS_STICK)
                        .pattern(" E ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .criterion("has_vulpus_ingot", conditionsFromItem(ModItems.VULPUS_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.VULPUS_HOE)
                        .input('E', ModItems.VULPUS_INGOT)
                        .input('S', ModItems.VULPUS_STICK)
                        .pattern(" EE")
                        .pattern(" S ")
                        .pattern(" S ")
                        .criterion("has_vulpus_ingot", conditionsFromItem(ModItems.VULPUS_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.VULPUS_BOW)
                        .input('E', ModItems.VULPUS_INGOT)
                        .input('S', ModItems.VULPUS_STICK)
                        .input('D', Items.STRING)
                        .pattern(" SD")
                        .pattern("SED")
                        .pattern(" SD")
                        .criterion("has_vulpus_ingot", conditionsFromItem(ModItems.VULPUS_INGOT))
                        .offerTo(exporter);

                //ENDERIUM
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_ENDERIUM_BLOCK)
                        .input('E', ModItems.RAW_ENDERIUM)
                        .pattern("EEE")
                        .pattern("EEE")
                        .pattern("EEE")
                        .criterion("has_raw_enderium", conditionsFromItem(ModItems.RAW_ENDERIUM))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENDERIUM_BLOCK)
                        .input('E', ModItems.ENDERIUM_INGOT)
                        .pattern("EEE")
                        .pattern("EEE")
                        .pattern("EEE")
                        .criterion("has_enderium_ingot", conditionsFromItem(ModItems.ENDERIUM_INGOT))
                        .offerTo(exporter);

                offerSmelting(ENDERIUM_SMELTABLES, RecipeCategory.MISC, ModItems.ENDERIUM_INGOT,
                        1.0f, 250, "immersiveores:enderium_ingot_cooked");

                createShapeless(RecipeCategory.MISC, ModItems.ENDERIUM_NUGGET, 9)
                        .input(Ingredient.ofItems(ModItems.ENDERIUM_INGOT.asItem()))
                        .criterion("has_enderium_ingot", conditionsFromItem(ModItems.ENDERIUM_INGOT))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.MISC, ModItems.RAW_ENDERIUM, 9)
                        .input(Ingredient.ofItems(ModBlocks.RAW_ENDERIUM_BLOCK.asItem()))
                        .criterion("has_enderium_block", conditionsFromItem(ModBlocks.RAW_ENDERIUM_BLOCK))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.MISC, ModItems.ENDERIUM_INGOT, 9)
                        .input(Ingredient.ofItems(ModBlocks.ENDERIUM_BLOCK.asItem()))
                        .criterion("has_enderium_block", conditionsFromItem(ModBlocks.ENDERIUM_BLOCK))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.ENDERIUM_HORSE_ARMOR)
                        .input('E', ModItems.ENDERIUM_INGOT)
                        .input('W', ModItems.VULPUS_HORSE_ARMOR)
                        .pattern("E E")
                        .pattern("EEE")
                        .pattern("EWE")
                        .criterion("has_enderium_ingot", conditionsFromItem(ModItems.ENDERIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.ENDERIUM_STICK)
                        .input('E', ModItems.ENDERIUM_INGOT)
                        .pattern("   ")
                        .pattern(" E ")
                        .pattern(" E ")
                        .criterion("has_enderium_ingot", conditionsFromItem(ModItems.ENDERIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, ModItems.ENDERIUM_INGOT)
                        .input('E', ModItems.ENDERIUM_NUGGET)
                        .pattern("EEE")
                        .pattern("EEE")
                        .pattern("EEE")
                        .criterion("has_enderium_nugget", conditionsFromItem(ModItems.ENDERIUM_NUGGET))
                        .offerTo(exporter, "immersiveores:enderium_ingot_craft");

                createShaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_HAMMER)
                        .input('E', ModItems.ENDERIUM_INGOT)
                        .input('W', ModBlocks.ENDERIUM_BLOCK)
                        .input('S', ModItems.ENDERIUM_STICK)
                        .pattern("WEW")
                        .pattern(" S ")
                        .pattern(" S ")
                        .criterion("has_enderium_ingot", conditionsFromItem(ModItems.ENDERIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_EXCAVATOR)
                        .input('E', ModItems.ENDERIUM_INGOT)
                        .input('W', ModBlocks.ENDERIUM_BLOCK)
                        .input('S', ModItems.ENDERIUM_STICK)
                        .pattern(" E ")
                        .pattern("WSW")
                        .pattern(" S ")
                        .criterion("has_enderium_ingot", conditionsFromItem(ModItems.ENDERIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_PAXEL)
                        .input('E', ModItems.ENDERIUM_AXE)
                        .input('W', ModItems.ENDERIUM_PICKAXE)
                        .input('T', ModItems.ENDERIUM_SHOVEL)
                        .input('S', ModItems.ENDERIUM_STICK)
                        .pattern("WTE")
                        .pattern(" S ")
                        .pattern(" S ")
                        .criterion("has_enderium_stick", conditionsFromItem(ModItems.ENDERIUM_STICK))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_AXE)
                        .input('E', ModItems.ENDERIUM_INGOT)
                        .input('S', ModItems.ENDERIUM_STICK)
                        .pattern(" EE")
                        .pattern(" SE")
                        .pattern(" S ")
                        .criterion("has_enderium_ingot", conditionsFromItem(ModItems.ENDERIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_PICKAXE)
                        .input('E', ModItems.ENDERIUM_INGOT)
                        .input('S', ModItems.ENDERIUM_STICK)
                        .pattern("EEE")
                        .pattern(" S ")
                        .pattern(" S ")
                        .criterion("has_enderium_ingot", conditionsFromItem(ModItems.ENDERIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.ENDERIUM_SWORD)
                        .input('E', ModItems.ENDERIUM_INGOT)
                        .input('S', ModItems.ENDERIUM_STICK)
                        .pattern(" E ")
                        .pattern(" E ")
                        .pattern(" S ")
                        .criterion("has_enderium_ingot", conditionsFromItem(ModItems.ENDERIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_SHOVEL)
                        .input('E', ModItems.ENDERIUM_INGOT)
                        .input('S', ModItems.ENDERIUM_STICK)
                        .pattern(" E ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .criterion("has_enderium_ingot", conditionsFromItem(ModItems.ENDERIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_HOE)
                        .input('E', ModItems.ENDERIUM_INGOT)
                        .input('S', ModItems.ENDERIUM_STICK)
                        .pattern(" EE")
                        .pattern(" S ")
                        .pattern(" S ")
                        .criterion("has_enderium_ingot", conditionsFromItem(ModItems.ENDERIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.ENDERIUM_BOW)
                        .input('E', ModItems.ENDERIUM_INGOT)
                        .input('S', ModItems.ENDERIUM_STICK)
                        .input('D', Items.STRING)
                        .pattern(" SD")
                        .pattern("SED")
                        .pattern(" SD")
                        .criterion("has_enderium_ingot", conditionsFromItem(ModItems.ENDERIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.ENDERIUM_HELMET)
                        .input('E', ModItems.ENDERIUM_INGOT)
                        .input('N', ModItems.VULPUS_HELMET)
                        .pattern("EEE")
                        .pattern("ENE")
                        .pattern("   ")
                        .criterion("has_enderium_ingot", conditionsFromItem(ModItems.ENDERIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.ENDERIUM_CHESTPLATE)
                        .input('E', ModItems.ENDERIUM_INGOT)
                        .input('N', ModItems.VULPUS_CHESTPLATE)
                        .pattern("ENE")
                        .pattern("EEE")
                        .pattern("EEE")
                        .criterion("has_enderium_ingot", conditionsFromItem(ModItems.ENDERIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.ENDERIUM_LEGGINGS)
                        .input('E', ModItems.ENDERIUM_INGOT)
                        .input('N', ModItems.VULPUS_LEGGINGS)
                        .pattern("EEE")
                        .pattern("ENE")
                        .pattern("E E")
                        .criterion("has_enderium_ingot", conditionsFromItem(ModItems.ENDERIUM_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, ModItems.ENDERIUM_BOOTS)
                        .input('E', ModItems.ENDERIUM_INGOT)
                        .input('N', ModItems.VULPUS_BOOTS)
                        .pattern("   ")
                        .pattern("E E")
                        .pattern("ENE")
                        .criterion("has_enderium_ingot", conditionsFromItem(ModItems.ENDERIUM_INGOT))
                        .offerTo(exporter);
            }
        };
    }


    @Override
    public String getName() {
        return "ImmersiveOres Recipes";
    }
}