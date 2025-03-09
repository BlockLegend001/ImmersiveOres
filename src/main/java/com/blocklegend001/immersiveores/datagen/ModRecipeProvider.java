package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.block.ModBlocks;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements net.neoforged.neoforge.common.conditions.IConditionBuilder {

    protected ModRecipeProvider(HolderLookup.Provider p_361709_, RecipeOutput p_365321_) {
        super(p_361709_, p_365321_);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> providerCompletableFuture) {
            super(output, providerCompletableFuture);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new ModRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "Recipes";
        }
    }

    @Override
    protected void buildRecipes() {
        //VIBRANIUM
        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_VIBRANIUM_BLOCK.get())
                .define('V', ModItems.RAW_VIBRANIUM.get())
                .pattern("VVV")
                .pattern("VVV")
                .pattern("VVV")
                .unlockedBy("has_raw_vibranium", has(ModItems.RAW_VIBRANIUM.get()))
                .save(this.output);

        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VIBRANIUM_BLOCK.get())
                .define('V', ModItems.VIBRANIUM_INGOT.get())
                .pattern("VVV")
                .pattern("VVV")
                .pattern("VVV")
                .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT.get()))
                .save(this.output);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.RAW_VIBRANIUM.get()),
                        RecipeCategory.MISC, ModItems.VIBRANIUM_INGOT.get(), 1.0f, 200)
                .unlockedBy("has_raw_vibranium", has(ModItems.RAW_VIBRANIUM.get()))
                .save(this.output, "immersiveores:vibranium_ingot_cooked");

        shapeless(RecipeCategory.MISC, ModItems.VIBRANIUM_NUGGET.get(), 9)
                .requires(Ingredient.of(ModItems.VIBRANIUM_INGOT.get().asItem()))
                .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT.get()))
                .save(this.output);

        shapeless(RecipeCategory.MISC, ModItems.RAW_VIBRANIUM.get(), 9)
                .requires(Ingredient.of(ModBlocks.RAW_VIBRANIUM_BLOCK.get().asItem()))
                .unlockedBy("has_vibranium_block", has(ModBlocks.RAW_VIBRANIUM_BLOCK.get()))
                .save(this.output);

        shapeless(RecipeCategory.MISC, ModItems.VIBRANIUM_INGOT.get(), 9)
                .requires(Ingredient.of(ModBlocks.VIBRANIUM_BLOCK.get().asItem()))
                .unlockedBy("has_vibranium_block", has(ModBlocks.VIBRANIUM_BLOCK.get()))
                .save(this.output);

        shaped(RecipeCategory.MISC, ModItems.VIBRANIUM_INGOT.get())
                .define('E', ModItems.VIBRANIUM_NUGGET.get())
                .pattern("EEE")
                .pattern("EEE")
                .pattern("EEE")
                .unlockedBy("has_vibranium_nugget", has(ModItems.VIBRANIUM_NUGGET.get()))
                .save(this.output, "immersiveores:vibranium_ingot_craft");

        shaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_HELMET.get())
                .define('V', ModItems.VIBRANIUM_INGOT.get())
                .define('N', Items.NETHERITE_HELMET)
                .pattern("VVV")
                .pattern("VNV")
                .pattern("   ")
                .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_CHESTPLATE.get())
                .define('V', ModItems.VIBRANIUM_INGOT.get())
                .define('N', Items.NETHERITE_CHESTPLATE)
                .pattern("VNV")
                .pattern("VVV")
                .pattern("VVV")
                .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_LEGGINGS.get())
                .define('V', ModItems.VIBRANIUM_INGOT.get())
                .define('N', Items.NETHERITE_LEGGINGS)
                .pattern("VVV")
                .pattern("VNV")
                .pattern("V V")
                .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_BOOTS.get())
                .define('V', ModItems.VIBRANIUM_INGOT.get())
                .define('N', Items.NETHERITE_BOOTS)
                .pattern("   ")
                .pattern("V V")
                .pattern("VNV")
                .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_HORSE_ARMOR.get())
                .define('E', ModItems.VIBRANIUM_INGOT.get())
                .define('W', ItemTags.WOOL)
                .pattern("E E")
                .pattern("EEE")
                .pattern("EWE")
                .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.MISC, ModItems.VIBRANIUM_STICK.get())
                .define('E', ModItems.VIBRANIUM_INGOT.get())
                .pattern("   ")
                .pattern(" E ")
                .pattern(" E ")
                .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_HAMMER.get())
                .define('E', ModItems.VIBRANIUM_INGOT.get())
                .define('W', ModBlocks.VIBRANIUM_BLOCK.get())
                .define('S', ModItems.VIBRANIUM_STICK.get())
                .pattern("WEW")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_EXCAVATOR.get())
                .define('E', ModItems.VIBRANIUM_INGOT.get())
                .define('W', ModBlocks.VIBRANIUM_BLOCK.get())
                .define('S', ModItems.VIBRANIUM_STICK.get())
                .pattern(" E ")
                .pattern("WSW")
                .pattern(" S ")
                .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_PAXEL.get())
                .define('E', ModItems.VIBRANIUM_AXE.get())
                .define('W', ModItems.VIBRANIUM_PICKAXE.get())
                .define('T', ModItems.VIBRANIUM_SHOVEL.get())
                .define('S', ModItems.VIBRANIUM_STICK.get())
                .pattern("WTE")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_vibranium_stick", has(ModItems.VIBRANIUM_STICK.get()))
                .save(this.output);

        shaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_AXE.get())
                .define('E', ModItems.VIBRANIUM_INGOT.get())
                .define('S', ModItems.VIBRANIUM_STICK.get())
                .pattern(" EE")
                .pattern(" SE")
                .pattern(" S ")
                .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_PICKAXE.get())
                .define('E', ModItems.VIBRANIUM_INGOT.get())
                .define('S', ModItems.VIBRANIUM_STICK.get())
                .pattern("EEE")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_SWORD.get())
                .define('E', ModItems.VIBRANIUM_INGOT.get())
                .define('S', ModItems.VIBRANIUM_STICK.get())
                .pattern(" E ")
                .pattern(" E ")
                .pattern(" S ")
                .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_SHOVEL.get())
                .define('E', ModItems.VIBRANIUM_INGOT.get())
                .define('S', ModItems.VIBRANIUM_STICK.get())
                .pattern(" E ")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_HOE.get())
                .define('E', ModItems.VIBRANIUM_INGOT.get())
                .define('S', ModItems.VIBRANIUM_STICK.get())
                .pattern(" EE")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_BOW.get())
                .define('E', ModItems.VIBRANIUM_INGOT.get())
                .define('S', ModItems.VIBRANIUM_STICK.get())
                .define('D', Items.STRING)
                .pattern(" SD")
                .pattern("SED")
                .pattern(" SD")
                .unlockedBy("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT.get()))
                .save(this.output);

        //VULPUS
        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_VULPUS_BLOCK.get())
                .define('V', ModItems.RAW_VULPUS.get())
                .pattern("VVV")
                .pattern("VVV")
                .pattern("VVV")
                .unlockedBy("has_raw_vulpus", has(ModItems.RAW_VULPUS.get()))
                .save(this.output);

        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VULPUS_BLOCK.get())
                .define('V', ModItems.VULPUS_INGOT.get())
                .pattern("VVV")
                .pattern("VVV")
                .pattern("VVV")
                .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT.get()))
                .save(this.output);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.RAW_VULPUS.get()), RecipeCategory.MISC,
                        ModItems.VULPUS_INGOT.get(), 1.0f, 225)
                .unlockedBy("has_raw_vulpus", has(ModItems.RAW_VULPUS.get()))
                .save(this.output, "immersiveores:vulpus_ingot_cooked");

        shapeless(RecipeCategory.MISC, ModItems.VULPUS_NUGGET.get(), 9)
                .requires(Ingredient.of(ModItems.VULPUS_INGOT.get().asItem()))
                .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT.get()))
                .save(this.output);

        shapeless(RecipeCategory.MISC, ModItems.RAW_VULPUS.get(), 9)
                .requires(Ingredient.of(ModBlocks.RAW_VULPUS_BLOCK.get().asItem()))
                .unlockedBy("has_vulpus_block", has(ModBlocks.RAW_VULPUS_BLOCK.get()))
                .save(this.output);

        shapeless(RecipeCategory.MISC, ModItems.VULPUS_INGOT.get(), 9)
                .requires(Ingredient.of(ModBlocks.VULPUS_BLOCK.get().asItem()))
                .unlockedBy("has_vulpus_block", has(ModBlocks.VULPUS_BLOCK.get()))
                .save(this.output);

        shaped(RecipeCategory.MISC, ModItems.VULPUS_INGOT.get())
                .define('E', ModItems.VULPUS_NUGGET.get())
                .pattern("EEE")
                .pattern("EEE")
                .pattern("EEE")
                .unlockedBy("has_vulpus_nugget", has(ModItems.VULPUS_NUGGET.get()))
                .save(this.output, "immersiveores:vulpus_ingot_craft");

        shaped(RecipeCategory.COMBAT, ModItems.VULPUS_HELMET.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .define('N', ModItems.VIBRANIUM_HELMET.get())
                .pattern("EEE")
                .pattern("ENE")
                .pattern("   ")
                .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.COMBAT, ModItems.VULPUS_CHESTPLATE.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .define('N', ModItems.VIBRANIUM_CHESTPLATE.get())
                .pattern("ENE")
                .pattern("EEE")
                .pattern("EEE")
                .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.COMBAT, ModItems.VULPUS_LEGGINGS.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .define('N', ModItems.VIBRANIUM_LEGGINGS.get())
                .pattern("EEE")
                .pattern("ENE")
                .pattern("E E")
                .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.COMBAT, ModItems.VULPUS_BOOTS.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .define('N', ModItems.VIBRANIUM_BOOTS.get())
                .pattern("   ")
                .pattern("E E")
                .pattern("ENE")
                .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.COMBAT, ModItems.VULPUS_HORSE_ARMOR.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .define('W', ModItems.VIBRANIUM_HORSE_ARMOR.get())
                .pattern("E E")
                .pattern("EEE")
                .pattern("EWE")
                .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.MISC, ModItems.VULPUS_STICK.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .pattern("   ")
                .pattern(" E ")
                .pattern(" E ")
                .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.TOOLS, ModItems.VULPUS_HAMMER.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .define('W', ModBlocks.VULPUS_BLOCK.get())
                .define('S', ModItems.VULPUS_STICK.get())
                .pattern("WEW")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.TOOLS, ModItems.VULPUS_EXCAVATOR.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .define('W', ModBlocks.VULPUS_BLOCK.get())
                .define('S', ModItems.VULPUS_STICK.get())
                .pattern(" E ")
                .pattern("WSW")
                .pattern(" S ")
                .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.TOOLS, ModItems.VULPUS_PAXEL.get())
                .define('E', ModItems.VULPUS_AXE.get())
                .define('W', ModItems.VULPUS_PICKAXE.get())
                .define('T', ModItems.VULPUS_SHOVEL.get())
                .define('S', ModItems.VULPUS_STICK.get())
                .pattern("WTE")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_vulpus_stick", has(ModItems.VULPUS_STICK.get()))
                .save(this.output);

        shaped(RecipeCategory.TOOLS, ModItems.VULPUS_AXE.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .define('S', ModItems.VULPUS_STICK.get())
                .pattern(" EE")
                .pattern(" SE")
                .pattern(" S ")
                .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.TOOLS, ModItems.VULPUS_PICKAXE.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .define('S', ModItems.VULPUS_STICK.get())
                .pattern("EEE")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.COMBAT, ModItems.VULPUS_SWORD.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .define('S', ModItems.VULPUS_STICK.get())
                .pattern(" E ")
                .pattern(" E ")
                .pattern(" S ")
                .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.TOOLS, ModItems.VULPUS_SHOVEL.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .define('S', ModItems.VULPUS_STICK.get())
                .pattern(" E ")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.TOOLS, ModItems.VULPUS_HOE.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .define('S', ModItems.VULPUS_STICK.get())
                .pattern(" EE")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.COMBAT, ModItems.VULPUS_BOW.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .define('S', ModItems.VULPUS_STICK.get())
                .define('D', Items.STRING)
                .pattern(" SD")
                .pattern("SED")
                .pattern(" SD")
                .unlockedBy("has_vulpus_ingot", has(ModItems.VULPUS_INGOT.get()))
                .save(this.output);

        //ENDERIUM
        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_ENDERIUM_BLOCK.get())
                .define('E', ModItems.RAW_ENDERIUM.get())
                .pattern("EEE")
                .pattern("EEE")
                .pattern("EEE")
                .unlockedBy("has_raw_enderium", has(ModItems.RAW_ENDERIUM.get()))
                .save(this.output);

        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENDERIUM_BLOCK.get())
                .define('E', ModItems.ENDERIUM_INGOT.get())
                .pattern("EEE")
                .pattern("EEE")
                .pattern("EEE")
                .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT.get()))
                .save(this.output);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.RAW_ENDERIUM.get()),
                        RecipeCategory.MISC, ModItems.ENDERIUM_INGOT.get(), 1.0f, 250)
                .unlockedBy("has_raw_enderium", has(ModItems.RAW_ENDERIUM.get()))
                .save(this.output, "immersiveores:enderium_ingot_cooked");

        shapeless(RecipeCategory.MISC, ModItems.ENDERIUM_NUGGET.get(), 9)
                .requires(Ingredient.of(ModItems.ENDERIUM_INGOT.get().asItem()))
                .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT.get()))
                .save(this.output);

        shapeless(RecipeCategory.MISC, ModItems.RAW_ENDERIUM.get(), 9)
                .requires(Ingredient.of(ModBlocks.RAW_ENDERIUM_BLOCK.get().asItem()))
                .unlockedBy("has_enderium_block", has(ModBlocks.RAW_ENDERIUM_BLOCK.get()))
                .save(this.output);

        shapeless(RecipeCategory.MISC, ModItems.ENDERIUM_INGOT.get(), 9)
                .requires(Ingredient.of(ModBlocks.ENDERIUM_BLOCK.get().asItem()))
                .unlockedBy("has_enderium_block", has(ModBlocks.ENDERIUM_BLOCK.get()))
                .save(this.output);

        shaped(RecipeCategory.COMBAT, ModItems.ENDERIUM_HORSE_ARMOR.get())
                .define('E', ModItems.ENDERIUM_INGOT.get())
                .define('W', ModItems.VULPUS_HORSE_ARMOR.get())
                .pattern("E E")
                .pattern("EEE")
                .pattern("EWE")
                .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.MISC, ModItems.ENDERIUM_STICK.get())
                .define('E', ModItems.ENDERIUM_INGOT.get())
                .pattern("   ")
                .pattern(" E ")
                .pattern(" E ")
                .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.MISC, ModItems.ENDERIUM_INGOT.get())
                .define('E', ModItems.ENDERIUM_NUGGET.get())
                .pattern("EEE")
                .pattern("EEE")
                .pattern("EEE")
                .unlockedBy("has_enderium_nugget", has(ModItems.ENDERIUM_NUGGET.get()))
                .save(this.output, "immersiveores:enderium_ingot_craft");

        shaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_HAMMER.get())
                .define('E', ModItems.ENDERIUM_INGOT.get())
                .define('W', ModBlocks.ENDERIUM_BLOCK.get())
                .define('S', ModItems.ENDERIUM_STICK.get())
                .pattern("WEW")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_EXCAVATOR.get())
                .define('E', ModItems.ENDERIUM_INGOT.get())
                .define('W', ModBlocks.ENDERIUM_BLOCK.get())
                .define('S', ModItems.ENDERIUM_STICK.get())
                .pattern(" E ")
                .pattern("WSW")
                .pattern(" S ")
                .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_PAXEL.get())
                .define('E', ModItems.ENDERIUM_AXE.get())
                .define('W', ModItems.ENDERIUM_PICKAXE.get())
                .define('T', ModItems.ENDERIUM_SHOVEL.get())
                .define('S', ModItems.ENDERIUM_STICK.get())
                .pattern("WTE")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_enderium_stick", has(ModItems.ENDERIUM_STICK.get()))
                .save(this.output);

        shaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_AXE.get())
                .define('E', ModItems.ENDERIUM_INGOT.get())
                .define('S', ModItems.ENDERIUM_STICK.get())
                .pattern(" EE")
                .pattern(" SE")
                .pattern(" S ")
                .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_PICKAXE.get())
                .define('E', ModItems.ENDERIUM_INGOT.get())
                .define('S', ModItems.ENDERIUM_STICK.get())
                .pattern("EEE")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.COMBAT, ModItems.ENDERIUM_SWORD.get())
                .define('E', ModItems.ENDERIUM_INGOT.get())
                .define('S', ModItems.ENDERIUM_STICK.get())
                .pattern(" E ")
                .pattern(" E ")
                .pattern(" S ")
                .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_SHOVEL.get())
                .define('E', ModItems.ENDERIUM_INGOT.get())
                .define('S', ModItems.ENDERIUM_STICK.get())
                .pattern(" E ")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_HOE.get())
                .define('E', ModItems.ENDERIUM_INGOT.get())
                .define('S', ModItems.ENDERIUM_STICK.get())
                .pattern(" EE")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.COMBAT, ModItems.ENDERIUM_BOW.get())
                .define('E', ModItems.ENDERIUM_INGOT.get())
                .define('S', ModItems.ENDERIUM_STICK.get())
                .define('D', Items.STRING)
                .pattern(" SD")
                .pattern("SED")
                .pattern(" SD")
                .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.COMBAT, ModItems.ENDERIUM_HELMET.get())
                .define('E', ModItems.ENDERIUM_INGOT.get())
                .define('N', ModItems.VULPUS_HELMET.get())
                .pattern("EEE")
                .pattern("ENE")
                .pattern("   ")
                .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.COMBAT, ModItems.ENDERIUM_CHESTPLATE.get())
                .define('E', ModItems.ENDERIUM_INGOT.get())
                .define('N', ModItems.VULPUS_CHESTPLATE.get())
                .pattern("ENE")
                .pattern("EEE")
                .pattern("EEE")
                .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.COMBAT, ModItems.ENDERIUM_LEGGINGS.get())
                .define('E', ModItems.ENDERIUM_INGOT.get())
                .define('N', ModItems.VULPUS_LEGGINGS.get())
                .pattern("EEE")
                .pattern("ENE")
                .pattern("E E")
                .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT.get()))
                .save(this.output);

        shaped(RecipeCategory.COMBAT, ModItems.ENDERIUM_BOOTS.get())
                .define('E', ModItems.ENDERIUM_INGOT.get())
                .define('N', ModItems.VULPUS_BOOTS.get())
                .pattern("   ")
                .pattern("E E")
                .pattern("ENE")
                .unlockedBy("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT.get()))
                .save(this.output);
    }
}
