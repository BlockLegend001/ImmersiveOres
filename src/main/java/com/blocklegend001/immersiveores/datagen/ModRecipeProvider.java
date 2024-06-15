package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.blocks.ModBlocks;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
       //VIBRANIUM
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_VIBRANIUM_BLOCK.get())
                .define('V', ModItems.RAW_VIBRANIUM.get())
                .pattern("VVV")
                .pattern("VVV")
                .pattern("VVV")
                .unlockedBy("has_raw_vibranium", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.RAW_VIBRANIUM.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VIBRANIUM_BLOCK.get())
                .define('V', ModItems.VIBRANIUM_INGOT.get())
                .pattern("VVV")
                .pattern("VVV")
                .pattern("VVV")
                .unlockedBy("has_vibranium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VIBRANIUM_INGOT.get()).build()))
                .save(consumer);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.RAW_VIBRANIUM.get()),
                        RecipeCategory.MISC, ModItems.VIBRANIUM_INGOT.get(), 1.0f, 200)
                .unlockedBy("has_raw_vibranium", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.RAW_VIBRANIUM.get()).build()))
                .save(consumer, "immersiveores:vibranium_ingot_cooked");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.VIBRANIUM_NUGGET.get(), 9)
                .requires(Ingredient.of(ModItems.VIBRANIUM_INGOT.get().asItem()))
                .unlockedBy("has_vibranium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VIBRANIUM_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.VIBRANIUM_INGOT.get())
                .define('E', ModItems.VIBRANIUM_NUGGET.get())
                .pattern("EEE")
                .pattern("EEE")
                .pattern("EEE")
                .unlockedBy("has_vibranium_nugget", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VIBRANIUM_NUGGET.get()).build()))
                .save(consumer, "immersiveores:vibranium_ingot_craft");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_HELMET.get())
                .define('V', ModItems.VIBRANIUM_INGOT.get())
                .define('N', Items.NETHERITE_HELMET)
                .pattern("VVV")
                .pattern("VNV")
                .pattern("   ")
                .unlockedBy("has_vibranium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VIBRANIUM_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_CHESTPLATE.get())
                .define('V', ModItems.VIBRANIUM_INGOT.get())
                .define('N', Items.NETHERITE_CHESTPLATE)
                .pattern("VNV")
                .pattern("VVV")
                .pattern("VVV")
                .unlockedBy("has_vibranium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VIBRANIUM_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_LEGGINGS.get())
                .define('V', ModItems.VIBRANIUM_INGOT.get())
                .define('N', Items.NETHERITE_LEGGINGS)
                .pattern("VVV")
                .pattern("VNV")
                .pattern("V V")
                .unlockedBy("has_vibranium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VIBRANIUM_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_BOOTS.get())
                .define('V', ModItems.VIBRANIUM_INGOT.get())
                .define('N', Items.NETHERITE_BOOTS)
                .pattern("   ")
                .pattern("V V")
                .pattern("VNV")
                .unlockedBy("has_vibranium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VIBRANIUM_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_HORSE_ARMOR.get())
                .define('E', ModItems.VIBRANIUM_INGOT.get())
                .define('W', ItemTags.WOOL)
                .pattern("E E")
                .pattern("EEE")
                .pattern("EWE")
                .unlockedBy("has_vibranium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VIBRANIUM_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.VIBRANIUM_STICK.get())
                .define('E', ModItems.VIBRANIUM_INGOT.get())
                .pattern("   ")
                .pattern(" E ")
                .pattern(" E ")
                .unlockedBy("has_vibranium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VIBRANIUM_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_HAMMER.get())
                .define('E', ModItems.VIBRANIUM_INGOT.get())
                .define('W', ModBlocks.VIBRANIUM_BLOCK.get())
                .define('S', ModItems.VIBRANIUM_STICK.get())
                .pattern("WEW")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_vibranium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VIBRANIUM_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_EXCAVATOR.get())
                .define('E', ModItems.VIBRANIUM_INGOT.get())
                .define('W', ModBlocks.VIBRANIUM_BLOCK.get())
                .define('S', ModItems.VIBRANIUM_STICK.get())
                .pattern(" E ")
                .pattern("WSW")
                .pattern(" S ")
                .unlockedBy("has_vibranium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VIBRANIUM_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_PAXEL.get())
                .define('E', ModItems.VIBRANIUM_AXE.get())
                .define('W', ModItems.VIBRANIUM_PICKAXE.get())
                .define('T', ModItems.VIBRANIUM_SHOVEL.get())
                .define('S', ModItems.VIBRANIUM_STICK.get())
                .pattern("WTE")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_vibranium_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VIBRANIUM_STICK.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_AXE.get())
                .define('E', ModItems.VIBRANIUM_INGOT.get())
                .define('S', ModItems.VIBRANIUM_STICK.get())
                .pattern(" EE")
                .pattern(" SE")
                .pattern(" S ")
                .unlockedBy("has_vibranium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VIBRANIUM_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_PICKAXE.get())
                .define('E', ModItems.VIBRANIUM_INGOT.get())
                .define('S', ModItems.VIBRANIUM_STICK.get())
                .pattern("EEE")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_vibranium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VIBRANIUM_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_SWORD.get())
                .define('E', ModItems.VIBRANIUM_INGOT.get())
                .define('S', ModItems.VIBRANIUM_STICK.get())
                .pattern(" E ")
                .pattern(" E ")
                .pattern(" S ")
                .unlockedBy("has_vibranium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VIBRANIUM_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_SHOVEL.get())
                .define('E', ModItems.VIBRANIUM_INGOT.get())
                .define('S', ModItems.VIBRANIUM_STICK.get())
                .pattern(" E ")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_vibranium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VIBRANIUM_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_HOE.get())
                .define('E', ModItems.VIBRANIUM_INGOT.get())
                .define('S', ModItems.VIBRANIUM_STICK.get())
                .pattern(" EE")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_vibranium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VIBRANIUM_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.VIBRANIUM_BOW.get())
                .define('E', ModItems.VIBRANIUM_INGOT.get())
                .define('S', ModItems.VIBRANIUM_STICK.get())
                .define('D', Items.STRING)
                .pattern(" SD")
                .pattern("SED")
                .pattern(" SD")
                .unlockedBy("has_vibranium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VIBRANIUM_INGOT.get()).build()))
                .save(consumer);

       //VULPUS
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_VULPUS_BLOCK.get())
                .define('V', ModItems.RAW_VULPUS.get())
                .pattern("VVV")
                .pattern("VVV")
                .pattern("VVV")
                .unlockedBy("has_raw_vulpus", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.RAW_VULPUS.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VULPUS_BLOCK.get())
                .define('V', ModItems.VULPUS_INGOT.get())
                .pattern("VVV")
                .pattern("VVV")
                .pattern("VVV")
                .unlockedBy("has_vulpus_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VULPUS_INGOT.get()).build()))
                .save(consumer);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.RAW_VULPUS.get()), RecipeCategory.MISC,
                        ModItems.VULPUS_INGOT.get(), 1.0f, 225)
                .unlockedBy("has_raw_vulpus", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.RAW_VULPUS.get()).build()))
                .save(consumer, "immersiveores:vulpus_ingot_cooked");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.VULPUS_NUGGET.get(), 9)
                .requires(Ingredient.of(ModItems.VULPUS_INGOT.get().asItem()))
                .unlockedBy("has_vulpus_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VULPUS_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.VULPUS_INGOT.get())
                .define('E', ModItems.VULPUS_NUGGET.get())
                .pattern("EEE")
                .pattern("EEE")
                .pattern("EEE")
                .unlockedBy("has_vulpus_nugget", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VULPUS_NUGGET.get()).build()))
                .save(consumer, "immersiveores:vulpus_ingot_craft");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.VULPUS_HELMET.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .define('N', ModItems.VIBRANIUM_HELMET.get())
                .pattern("EEE")
                .pattern("ENE")
                .pattern("   ")
                .unlockedBy("has_vibranium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VULPUS_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.VULPUS_CHESTPLATE.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .define('N', ModItems.VIBRANIUM_CHESTPLATE.get())
                .pattern("ENE")
                .pattern("EEE")
                .pattern("EEE")
                .unlockedBy("has_vibranium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VULPUS_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.VULPUS_LEGGINGS.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .define('N', ModItems.VIBRANIUM_LEGGINGS.get())
                .pattern("EEE")
                .pattern("ENE")
                .pattern("E E")
                .unlockedBy("has_vibranium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VULPUS_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.VULPUS_BOOTS.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .define('N', ModItems.VIBRANIUM_BOOTS.get())
                .pattern("   ")
                .pattern("E E")
                .pattern("ENE")
                .unlockedBy("has_vibranium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VULPUS_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.VULPUS_HORSE_ARMOR.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .define('W', ModItems.VIBRANIUM_HORSE_ARMOR.get())
                .pattern("E E")
                .pattern("EEE")
                .pattern("EWE")
                .unlockedBy("has_vulpus_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VULPUS_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.VULPUS_STICK.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .pattern("   ")
                .pattern(" E ")
                .pattern(" E ")
                .unlockedBy("has_vulpus_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VULPUS_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.VULPUS_HAMMER.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .define('W', ModBlocks.VULPUS_BLOCK.get())
                .define('S', ModItems.VULPUS_STICK.get())
                .pattern("WEW")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_vulpus_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VULPUS_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.VULPUS_EXCAVATOR.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .define('W', ModBlocks.VULPUS_BLOCK.get())
                .define('S', ModItems.VULPUS_STICK.get())
                .pattern(" E ")
                .pattern("WSW")
                .pattern(" S ")
                .unlockedBy("has_vulpus_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VULPUS_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.VULPUS_PAXEL.get())
                .define('E', ModItems.VULPUS_AXE.get())
                .define('W', ModItems.VULPUS_PICKAXE.get())
                .define('T', ModItems.VULPUS_SHOVEL.get())
                .define('S', ModItems.VULPUS_STICK.get())
                .pattern("WTE")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_vulpus_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VULPUS_STICK.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.VULPUS_AXE.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .define('S', ModItems.VULPUS_STICK.get())
                .pattern(" EE")
                .pattern(" SE")
                .pattern(" S ")
                .unlockedBy("has_vulpus_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VULPUS_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.VULPUS_PICKAXE.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .define('S', ModItems.VULPUS_STICK.get())
                .pattern("EEE")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_vulpus_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VULPUS_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.VULPUS_SWORD.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .define('S', ModItems.VULPUS_STICK.get())
                .pattern(" E ")
                .pattern(" E ")
                .pattern(" S ")
                .unlockedBy("has_vulpus_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VULPUS_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.VULPUS_SHOVEL.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .define('S', ModItems.VULPUS_STICK.get())
                .pattern(" E ")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_vulpus_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VULPUS_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.VULPUS_HOE.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .define('S', ModItems.VULPUS_STICK.get())
                .pattern(" EE")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_vulpus_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VULPUS_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.VULPUS_BOW.get())
                .define('E', ModItems.VULPUS_INGOT.get())
                .define('S', ModItems.VULPUS_STICK.get())
                .define('D', Items.STRING)
                .pattern(" SD")
                .pattern("SED")
                .pattern(" SD")
                .unlockedBy("has_vulpus_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.VULPUS_INGOT.get()).build()))
                .save(consumer);

        //ENDERIUM
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_ENDERIUM_BLOCK.get())
                .define('E', ModItems.RAW_ENDERIUM.get())
                .pattern("EEE")
                .pattern("EEE")
                .pattern("EEE")
                .unlockedBy("has_raw_enderium", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.RAW_ENDERIUM.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ENDERIUM_BLOCK.get())
                .define('E', ModItems.ENDERIUM_INGOT.get())
                .pattern("EEE")
                .pattern("EEE")
                .pattern("EEE")
                .unlockedBy("has_enderium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ENDERIUM_INGOT.get()).build()))
                .save(consumer);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.RAW_ENDERIUM.get()),
                        RecipeCategory.MISC, ModItems.ENDERIUM_INGOT.get(), 1.0f, 250)
                .unlockedBy("has_raw_enderium", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.RAW_ENDERIUM.get()).build()))
                .save(consumer, "immersiveores:enderium_ingot_cooked");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ENDERIUM_NUGGET.get(), 9)
                .requires(Ingredient.of(ModItems.ENDERIUM_INGOT.get().asItem()))
                .unlockedBy("has_enderium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ENDERIUM_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ENDERIUM_HORSE_ARMOR.get())
                .define('E', ModItems.ENDERIUM_INGOT.get())
                .define('W', ModItems.VULPUS_HORSE_ARMOR.get())
                .pattern("E E")
                .pattern("EEE")
                .pattern("EWE")
                .unlockedBy("has_enderium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ENDERIUM_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ENDERIUM_STICK.get())
                .define('E', ModItems.ENDERIUM_INGOT.get())
                .pattern("   ")
                .pattern(" E ")
                .pattern(" E ")
                .unlockedBy("has_enderium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ENDERIUM_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_HAMMER.get())
                .define('E', ModItems.ENDERIUM_INGOT.get())
                .define('W', ModBlocks.ENDERIUM_BLOCK.get())
                .define('S', ModItems.ENDERIUM_STICK.get())
                .pattern("WEW")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_enderium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ENDERIUM_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_EXCAVATOR.get())
                .define('E', ModItems.ENDERIUM_INGOT.get())
                .define('W', ModBlocks.ENDERIUM_BLOCK.get())
                .define('S', ModItems.ENDERIUM_STICK.get())
                .pattern(" E ")
                .pattern("WSW")
                .pattern(" S ")
                .unlockedBy("has_enderium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ENDERIUM_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_PAXEL.get())
                .define('E', ModItems.ENDERIUM_AXE.get())
                .define('W', ModItems.ENDERIUM_PICKAXE.get())
                .define('T', ModItems.ENDERIUM_SHOVEL.get())
                .define('S', ModItems.ENDERIUM_STICK.get())
                .pattern("WTE")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_enderium_stick", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ENDERIUM_STICK.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_AXE.get())
                .define('E', ModItems.ENDERIUM_INGOT.get())
                .define('S', ModItems.ENDERIUM_STICK.get())
                .pattern(" EE")
                .pattern(" SE")
                .pattern(" S ")
                .unlockedBy("has_enderium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ENDERIUM_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_PICKAXE.get())
                .define('E', ModItems.ENDERIUM_INGOT.get())
                .define('S', ModItems.ENDERIUM_STICK.get())
                .pattern("EEE")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_enderium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ENDERIUM_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ENDERIUM_SWORD.get())
                .define('E', ModItems.ENDERIUM_INGOT.get())
                .define('S', ModItems.ENDERIUM_STICK.get())
                .pattern(" E ")
                .pattern(" E ")
                .pattern(" S ")
                .unlockedBy("has_enderium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ENDERIUM_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_SHOVEL.get())
                .define('E', ModItems.ENDERIUM_INGOT.get())
                .define('S', ModItems.ENDERIUM_STICK.get())
                .pattern(" E ")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_enderium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ENDERIUM_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ENDERIUM_HOE.get())
                .define('E', ModItems.ENDERIUM_INGOT.get())
                .define('S', ModItems.ENDERIUM_STICK.get())
                .pattern(" EE")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_enderium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ENDERIUM_INGOT.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.ENDERIUM_BOW.get())
                .define('E', ModItems.ENDERIUM_INGOT.get())
                .define('S', ModItems.ENDERIUM_STICK.get())
                .define('D', Items.STRING)
                .pattern(" SD")
                .pattern("SED")
                .pattern(" SD")
                .unlockedBy("has_enderium_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.ENDERIUM_INGOT.get()).build()))
                .save(consumer);
    }
}
