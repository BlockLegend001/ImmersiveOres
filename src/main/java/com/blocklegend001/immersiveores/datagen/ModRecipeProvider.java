package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.blocks.ModBlocks;
import com.blocklegend001.immersiveores.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemLike> VIBRANIUM_SMELTABLES = List.of(
            ModItems.RAW_VIBRANIUM,
            ModBlocks.VIBRANIUM_ORE);

    private static final List<ItemLike> VULPUS_SMELTABLES = List.of(
            ModItems.RAW_VULPUS,
            ModBlocks.VULPUS_ORE);
    
    private static final List<ItemLike> ENDERIUM_SMELTABLES = List.of(
            ModItems.RAW_ENDERIUM,
            ModBlocks.ENDERIUM_ORE);

    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                //VIBRANIUM
                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_VIBRANIUM_BLOCK)
                        .define('V', ModItems.RAW_VIBRANIUM)
                        .pattern("VVV")
                        .pattern("VVV")
                        .pattern("VVV")
                        .unlockedBy("has_raw_vibranium", has(ModItems.RAW_VIBRANIUM))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VIBRANIUM_BLOCK)
                        .define('V', ModItems.VIBRANIUM_INGOT)
                        .pattern("VVV")
                        .pattern("VVV")
                        .pattern("VVV")
                        .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT))
                        .save(output);

                oreSmelting(VIBRANIUM_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.VIBRANIUM_INGOT,
                        1.0f, 200, "immersiveores:vibranium_ingot_cooked");

                oreBlasting(VIBRANIUM_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.VIBRANIUM_INGOT,
                        1.0f, 100, "immersiveores:vibranium_ingot_cooked_blast");

                shapeless(RecipeCategory.MISC, ModItems.VIBRANIUM_NUGGET, 9)
                        .requires(Ingredient.of(ModItems.VIBRANIUM_INGOT.asItem()))
                        .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT))
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.RAW_VIBRANIUM, 9)
                        .requires(Ingredient.of(ModBlocks.RAW_VIBRANIUM_BLOCK.asItem()))
                        .unlockedBy("has_vibranium_block", has(ModBlocks.RAW_VIBRANIUM_BLOCK))
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.VIBRANIUM_INGOT, 9)
                        .requires(Ingredient.of(ModBlocks.VIBRANIUM_BLOCK.asItem()))
                        .unlockedBy("has_vibranium_block", has(ModBlocks.VIBRANIUM_BLOCK))
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.VIBRANIUM_INGOT)
                        .define('E', ModItems.VIBRANIUM_NUGGET)
                        .pattern("EEE")
                        .pattern("EEE")
                        .pattern("EEE")
                        .unlockedBy("has_vibranium_nugget", has(ModItems.VIBRANIUM_NUGGET))
                        .save(output, "immersiveores:vibranium_ingot_craft");

                shaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_HELMET)
                        .define('V', ModItems.VIBRANIUM_INGOT)
                        .define('N', Items.NETHERITE_HELMET)
                        .pattern("VVV")
                        .pattern("VNV")
                        .pattern("   ")
                        .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_CHESTPLATE)
                        .define('V', ModItems.VIBRANIUM_INGOT)
                        .define('N', Items.NETHERITE_CHESTPLATE)
                        .pattern("VNV")
                        .pattern("VVV")
                        .pattern("VVV")
                        .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_LEGGINGS)
                        .define('V', ModItems.VIBRANIUM_INGOT)
                        .define('N', Items.NETHERITE_LEGGINGS)
                        .pattern("VVV")
                        .pattern("VNV")
                        .pattern("V V")
                        .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_BOOTS)
                        .define('V', ModItems.VIBRANIUM_INGOT)
                        .define('N', Items.NETHERITE_BOOTS)
                        .pattern("   ")
                        .pattern("V V")
                        .pattern("VNV")
                        .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_HORSE_ARMOR)
                        .define('E', ModItems.VIBRANIUM_INGOT)
                        .define('W', ItemTags.WOOL)
                        .pattern("E E")
                        .pattern("EEE")
                        .pattern("EWE")
                        .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT))
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.VIBRANIUM_STICK, 2)
                        .define('E', ModItems.VIBRANIUM_INGOT)
                        .pattern("   ")
                        .pattern(" E ")
                        .pattern(" E ")
                        .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_HAMMER)
                        .define('E', ModItems.VIBRANIUM_INGOT)
                        .define('W', ModBlocks.VIBRANIUM_BLOCK)
                        .define('S', ModItems.VIBRANIUM_STICK)
                        .pattern("WEW")
                        .pattern(" S ")
                        .pattern(" S ")
                        .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_EXCAVATOR)
                        .define('E', ModItems.VIBRANIUM_INGOT)
                        .define('W', ModBlocks.VIBRANIUM_BLOCK)
                        .define('S', ModItems.VIBRANIUM_STICK)
                        .pattern(" E ")
                        .pattern("WSW")
                        .pattern(" S ")
                        .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_PAXEL)
                        .define('E', ModItems.VIBRANIUM_AXE)
                        .define('W', ModItems.VIBRANIUM_PICKAXE)
                        .define('T', ModItems.VIBRANIUM_SHOVEL)
                        .define('S', ModItems.VIBRANIUM_STICK)
                        .pattern("WTE")
                        .pattern(" S ")
                        .pattern(" S ")
                        .unlockedBy("has_vibranium_stick", has(ModItems.VIBRANIUM_STICK))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_AXE)
                        .define('E', ModItems.VIBRANIUM_INGOT)
                        .define('S', ModItems.VIBRANIUM_STICK)
                        .pattern(" EE")
                        .pattern(" SE")
                        .pattern(" S ")
                        .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_PICKAXE)
                        .define('E', ModItems.VIBRANIUM_INGOT)
                        .define('S', ModItems.VIBRANIUM_STICK)
                        .pattern("EEE")
                        .pattern(" S ")
                        .pattern(" S ")
                        .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_SWORD)
                        .define('E', ModItems.VIBRANIUM_INGOT)
                        .define('S', ModItems.VIBRANIUM_STICK)
                        .pattern(" E ")
                        .pattern(" E ")
                        .pattern(" S ")
                        .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_SHOVEL)
                        .define('E', ModItems.VIBRANIUM_INGOT)
                        .define('S', ModItems.VIBRANIUM_STICK)
                        .pattern(" E ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_HOE)
                        .define('E', ModItems.VIBRANIUM_INGOT)
                        .define('S', ModItems.VIBRANIUM_STICK)
                        .pattern(" EE")
                        .pattern(" S ")
                        .pattern(" S ")
                        .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_BOW)
                        .define('E', ModItems.VIBRANIUM_INGOT)
                        .define('S', ModItems.VIBRANIUM_STICK)
                        .define('D', Items.STRING)
                        .pattern(" SD")
                        .pattern("SED")
                        .pattern(" SD")
                        .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT))
                        .save(output);

                //VULPUS
                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_VULPUS_BLOCK)
                        .define('V', ModItems.RAW_VULPUS)
                        .pattern("VVV")
                        .pattern("VVV")
                        .pattern("VVV")
                        .unlockedBy("has_raw_vulpus", has(ModItems.RAW_VULPUS))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VULPUS_BLOCK)
                        .define('V', ModItems.VULPUS_INGOT)
                        .pattern("VVV")
                        .pattern("VVV")
                        .pattern("VVV")
                        .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT))
                        .save(output);

                oreSmelting(VULPUS_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.VULPUS_INGOT,
                        1.0f, 225, "immersiveores:vulpus_ingot_cooked");

                oreBlasting(VULPUS_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.VULPUS_INGOT,
                        1.0f, 112, "immersiveores:vulpus_ingot_cooked_blast");

                shapeless(RecipeCategory.MISC, ModItems.VULPUS_NUGGET, 9)
                        .requires(Ingredient.of(ModItems.VULPUS_INGOT.asItem()))
                        .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT))
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.RAW_VULPUS, 9)
                        .requires(Ingredient.of(ModBlocks.RAW_VULPUS_BLOCK.asItem()))
                        .unlockedBy("has_vulpus_block", has(ModBlocks.RAW_VULPUS_BLOCK))
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.VULPUS_INGOT, 9)
                        .requires(Ingredient.of(ModBlocks.VULPUS_BLOCK.asItem()))
                        .unlockedBy("has_vulpus_block", has(ModBlocks.VULPUS_BLOCK))
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.VULPUS_INGOT)
                        .define('E', ModItems.VULPUS_NUGGET)
                        .pattern("EEE")
                        .pattern("EEE")
                        .pattern("EEE")
                        .unlockedBy("has_vulpus_nugget", has(ModItems.VULPUS_NUGGET))
                        .save(output, "immersiveores:vulpus_ingot_craft");

                shaped(RecipeCategory.COMBAT, ModItems.VULPUS_HELMET)
                        .define('E', ModItems.VULPUS_INGOT)
                        .define('N', ModItems.VIBRANIUM_HELMET)
                        .pattern("EEE")
                        .pattern("ENE")
                        .pattern("   ")
                        .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.VULPUS_CHESTPLATE)
                        .define('E', ModItems.VULPUS_INGOT)
                        .define('N', ModItems.VIBRANIUM_CHESTPLATE)
                        .pattern("ENE")
                        .pattern("EEE")
                        .pattern("EEE")
                        .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.VULPUS_LEGGINGS)
                        .define('E', ModItems.VULPUS_INGOT)
                        .define('N', ModItems.VIBRANIUM_LEGGINGS)
                        .pattern("EEE")
                        .pattern("ENE")
                        .pattern("E E")
                        .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.VULPUS_BOOTS)
                        .define('E', ModItems.VULPUS_INGOT)
                        .define('N', ModItems.VIBRANIUM_BOOTS)
                        .pattern("   ")
                        .pattern("E E")
                        .pattern("ENE")
                        .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.VULPUS_HORSE_ARMOR)
                        .define('E', ModItems.VULPUS_INGOT)
                        .define('W', ModItems.VIBRANIUM_HORSE_ARMOR)
                        .pattern("E E")
                        .pattern("EEE")
                        .pattern("EWE")
                        .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT))
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.VULPUS_STICK, 2)
                        .define('E', ModItems.VULPUS_INGOT)
                        .pattern("   ")
                        .pattern(" E ")
                        .pattern(" E ")
                        .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.VULPUS_HAMMER)
                        .define('E', ModItems.VULPUS_INGOT)
                        .define('W', ModBlocks.VULPUS_BLOCK)
                        .define('S', ModItems.VULPUS_STICK)
                        .pattern("WEW")
                        .pattern(" S ")
                        .pattern(" S ")
                        .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.VULPUS_EXCAVATOR)
                        .define('E', ModItems.VULPUS_INGOT)
                        .define('W', ModBlocks.VULPUS_BLOCK)
                        .define('S', ModItems.VULPUS_STICK)
                        .pattern(" E ")
                        .pattern("WSW")
                        .pattern(" S ")
                        .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.VULPUS_PAXEL)
                        .define('E', ModItems.VULPUS_AXE)
                        .define('W', ModItems.VULPUS_PICKAXE)
                        .define('T', ModItems.VULPUS_SHOVEL)
                        .define('S', ModItems.VULPUS_STICK)
                        .pattern("WTE")
                        .pattern(" S ")
                        .pattern(" S ")
                        .unlockedBy("has_vulpus_stick", has(ModItems.VULPUS_STICK))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.VULPUS_AXE)
                        .define('E', ModItems.VULPUS_INGOT)
                        .define('S', ModItems.VULPUS_STICK)
                        .pattern(" EE")
                        .pattern(" SE")
                        .pattern(" S ")
                        .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.VULPUS_PICKAXE)
                        .define('E', ModItems.VULPUS_INGOT)
                        .define('S', ModItems.VULPUS_STICK)
                        .pattern("EEE")
                        .pattern(" S ")
                        .pattern(" S ")
                        .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.VULPUS_SWORD)
                        .define('E', ModItems.VULPUS_INGOT)
                        .define('S', ModItems.VULPUS_STICK)
                        .pattern(" E ")
                        .pattern(" E ")
                        .pattern(" S ")
                        .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.VULPUS_SHOVEL)
                        .define('E', ModItems.VULPUS_INGOT)
                        .define('S', ModItems.VULPUS_STICK)
                        .pattern(" E ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.VULPUS_HOE)
                        .define('E', ModItems.VULPUS_INGOT)
                        .define('S', ModItems.VULPUS_STICK)
                        .pattern(" EE")
                        .pattern(" S ")
                        .pattern(" S ")
                        .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.VULPUS_BOW)
                        .define('E', ModItems.VULPUS_INGOT)
                        .define('S', ModItems.VULPUS_STICK)
                        .define('D', Items.STRING)
                        .pattern(" SD")
                        .pattern("SED")
                        .pattern(" SD")
                        .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT))
                        .save(output);

                //ENDERIUM
                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_ENDERIUM_BLOCK)
                        .define('E', ModItems.RAW_ENDERIUM)
                        .pattern("EEE")
                        .pattern("EEE")
                        .pattern("EEE")
                        .unlockedBy("has_raw_enderium", has(ModItems.RAW_ENDERIUM))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENDERIUM_BLOCK)
                        .define('E', ModItems.ENDERIUM_INGOT)
                        .pattern("EEE")
                        .pattern("EEE")
                        .pattern("EEE")
                        .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT))
                        .save(output);

                oreSmelting(ENDERIUM_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.ENDERIUM_INGOT,
                        1.0f, 250, "immersiveores:enderium_ingot_cooked");

                oreBlasting(ENDERIUM_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.ENDERIUM_INGOT,
                        1.0f, 125, "immersiveores:enderium_ingot_cooked_blast");

                shapeless(RecipeCategory.MISC, ModItems.ENDERIUM_NUGGET, 9)
                        .requires(Ingredient.of(ModItems.ENDERIUM_INGOT.asItem()))
                        .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT))
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.RAW_ENDERIUM, 9)
                        .requires(Ingredient.of(ModBlocks.RAW_ENDERIUM_BLOCK.asItem()))
                        .unlockedBy("has_enderium_block", has(ModBlocks.RAW_ENDERIUM_BLOCK))
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.ENDERIUM_INGOT, 9)
                        .requires(Ingredient.of(ModBlocks.ENDERIUM_BLOCK.asItem()))
                        .unlockedBy("has_enderium_block", has(ModBlocks.ENDERIUM_BLOCK))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.ENDERIUM_HORSE_ARMOR)
                        .define('E', ModItems.ENDERIUM_INGOT)
                        .define('W', ModItems.VULPUS_HORSE_ARMOR)
                        .pattern("E E")
                        .pattern("EEE")
                        .pattern("EWE")
                        .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT))
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.ENDERIUM_STICK, 2)
                        .define('E', ModItems.ENDERIUM_INGOT)
                        .pattern("   ")
                        .pattern(" E ")
                        .pattern(" E ")
                        .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT))
                        .save(output);

                shaped(RecipeCategory.MISC, ModItems.ENDERIUM_INGOT)
                        .define('E', ModItems.ENDERIUM_NUGGET)
                        .pattern("EEE")
                        .pattern("EEE")
                        .pattern("EEE")
                        .unlockedBy("has_enderium_nugget", has(ModItems.ENDERIUM_NUGGET))
                        .save(output, "immersiveores:enderium_ingot_craft");

                shaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_HAMMER)
                        .define('E', ModItems.ENDERIUM_INGOT)
                        .define('W', ModBlocks.ENDERIUM_BLOCK)
                        .define('S', ModItems.ENDERIUM_STICK)
                        .pattern("WEW")
                        .pattern(" S ")
                        .pattern(" S ")
                        .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_EXCAVATOR)
                        .define('E', ModItems.ENDERIUM_INGOT)
                        .define('W', ModBlocks.ENDERIUM_BLOCK)
                        .define('S', ModItems.ENDERIUM_STICK)
                        .pattern(" E ")
                        .pattern("WSW")
                        .pattern(" S ")
                        .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_PAXEL)
                        .define('E', ModItems.ENDERIUM_AXE)
                        .define('W', ModItems.ENDERIUM_PICKAXE)
                        .define('T', ModItems.ENDERIUM_SHOVEL)
                        .define('S', ModItems.ENDERIUM_STICK)
                        .pattern("WTE")
                        .pattern(" S ")
                        .pattern(" S ")
                        .unlockedBy("has_enderium_stick", has(ModItems.ENDERIUM_STICK))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_AXE)
                        .define('E', ModItems.ENDERIUM_INGOT)
                        .define('S', ModItems.ENDERIUM_STICK)
                        .pattern(" EE")
                        .pattern(" SE")
                        .pattern(" S ")
                        .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_PICKAXE)
                        .define('E', ModItems.ENDERIUM_INGOT)
                        .define('S', ModItems.ENDERIUM_STICK)
                        .pattern("EEE")
                        .pattern(" S ")
                        .pattern(" S ")
                        .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.ENDERIUM_SWORD)
                        .define('E', ModItems.ENDERIUM_INGOT)
                        .define('S', ModItems.ENDERIUM_STICK)
                        .pattern(" E ")
                        .pattern(" E ")
                        .pattern(" S ")
                        .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_SHOVEL)
                        .define('E', ModItems.ENDERIUM_INGOT)
                        .define('S', ModItems.ENDERIUM_STICK)
                        .pattern(" E ")
                        .pattern(" S ")
                        .pattern(" S ")
                        .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT))
                        .save(output);

                shaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_HOE)
                        .define('E', ModItems.ENDERIUM_INGOT)
                        .define('S', ModItems.ENDERIUM_STICK)
                        .pattern(" EE")
                        .pattern(" S ")
                        .pattern(" S ")
                        .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.ENDERIUM_BOW)
                        .define('E', ModItems.ENDERIUM_INGOT)
                        .define('S', ModItems.ENDERIUM_STICK)
                        .define('D', Items.STRING)
                        .pattern(" SD")
                        .pattern("SED")
                        .pattern(" SD")
                        .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.ENDERIUM_HELMET)
                        .define('E', ModItems.ENDERIUM_INGOT)
                        .define('N', ModItems.VULPUS_HELMET)
                        .pattern("EEE")
                        .pattern("ENE")
                        .pattern("   ")
                        .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.ENDERIUM_CHESTPLATE)
                        .define('E', ModItems.ENDERIUM_INGOT)
                        .define('N', ModItems.VULPUS_CHESTPLATE)
                        .pattern("ENE")
                        .pattern("EEE")
                        .pattern("EEE")
                        .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.ENDERIUM_LEGGINGS)
                        .define('E', ModItems.ENDERIUM_INGOT)
                        .define('N', ModItems.VULPUS_LEGGINGS)
                        .pattern("EEE")
                        .pattern("ENE")
                        .pattern("E E")
                        .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT))
                        .save(output);

                shaped(RecipeCategory.COMBAT, ModItems.ENDERIUM_BOOTS)
                        .define('E', ModItems.ENDERIUM_INGOT)
                        .define('N', ModItems.VULPUS_BOOTS)
                        .pattern("   ")
                        .pattern("E E")
                        .pattern("ENE")
                        .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT))
                        .save(output);
            }
        };
    }


    @Override
    public String getName() {
        return "ImmersiveOres Recipes";
    }
}