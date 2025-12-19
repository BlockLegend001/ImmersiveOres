package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.item.ModItems;
import com.blocklegend001.immersiveores.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends FabricTagProvider.ItemTagProvider {
    public ModItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    public void configure(RegistryWrapper.WrapperLookup arg) {

        //Armor
        valueLookupBuilder(ItemTags.HEAD_ARMOR).add(ModItems.VIBRANIUM_HELMET,
                ModItems.VULPUS_HELMET,
                ModItems.ENDERIUM_HELMET);

        valueLookupBuilder(ItemTags.CHEST_ARMOR).add(ModItems.VIBRANIUM_CHESTPLATE,
                ModItems.VULPUS_CHESTPLATE,
                ModItems.ENDERIUM_CHESTPLATE);

        valueLookupBuilder(ItemTags.LEG_ARMOR).add(ModItems.VIBRANIUM_LEGGINGS,
                ModItems.VULPUS_LEGGINGS,
                ModItems.ENDERIUM_LEGGINGS);

        valueLookupBuilder(ItemTags.FOOT_ARMOR).add(ModItems.VIBRANIUM_BOOTS,
                ModItems.VULPUS_BOOTS,
                ModItems.ENDERIUM_BOOTS);

        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR).add(ModItems.VIBRANIUM_HELMET,
                ModItems.VIBRANIUM_CHESTPLATE,
                ModItems.VIBRANIUM_LEGGINGS,
                ModItems.VIBRANIUM_BOOTS,
                ModItems.VULPUS_HELMET,
                ModItems.VULPUS_CHESTPLATE,
                ModItems.VULPUS_LEGGINGS,
                ModItems.VULPUS_BOOTS,
                ModItems.ENDERIUM_HELMET,
                ModItems.ENDERIUM_CHESTPLATE,
                ModItems.ENDERIUM_LEGGINGS,
                ModItems.ENDERIUM_BOOTS);

        valueLookupBuilder(ModTags.Items.VIBRANIUM_ARMOR).add(ModItems.VIBRANIUM_HELMET,
                ModItems.VIBRANIUM_CHESTPLATE,
                ModItems.VIBRANIUM_LEGGINGS,
                ModItems.VIBRANIUM_BOOTS);

        valueLookupBuilder(ModTags.Items.VULPUS_ARMOR).add(ModItems.VULPUS_HELMET,
                ModItems.VULPUS_CHESTPLATE,
                ModItems.VULPUS_LEGGINGS,
                ModItems.VULPUS_BOOTS);

        valueLookupBuilder(ModTags.Items.ENDERIUM_ARMOR).add(ModItems.ENDERIUM_HELMET,
                ModItems.ENDERIUM_CHESTPLATE,
                ModItems.ENDERIUM_LEGGINGS,
                ModItems.ENDERIUM_BOOTS);

        valueLookupBuilder(ConventionalItemTags.ARMORS).add(ModItems.VIBRANIUM_HELMET,
                ModItems.VIBRANIUM_CHESTPLATE,
                ModItems.VIBRANIUM_LEGGINGS,
                ModItems.VIBRANIUM_BOOTS,
                ModItems.VULPUS_HELMET,
                ModItems.VULPUS_CHESTPLATE,
                ModItems.VULPUS_LEGGINGS,
                ModItems.VULPUS_BOOTS,
                ModItems.ENDERIUM_HELMET,
                ModItems.ENDERIUM_CHESTPLATE,
                ModItems.ENDERIUM_LEGGINGS,
                ModItems.ENDERIUM_BOOTS);

        //Tools, Sword, Bows ...
        valueLookupBuilder(ModTags.Items.VIBRANIUM_SWORD).add(ModItems.VIBRANIUM_SWORD);
        valueLookupBuilder(ModTags.Items.VULPUS_SWORD).add(ModItems.VULPUS_SWORD);
        valueLookupBuilder(ModTags.Items.ENDERIUM_SWORD).add(ModItems.ENDERIUM_SWORD);

        valueLookupBuilder(ModTags.Items.VIBRANIUM_AXE).add(ModItems.VIBRANIUM_AXE);
        valueLookupBuilder(ModTags.Items.VULPUS_AXE).add(ModItems.VULPUS_AXE);
        valueLookupBuilder(ModTags.Items.ENDERIUM_AXE).add(ModItems.ENDERIUM_AXE);

        valueLookupBuilder(ModTags.Items.VIBRANIUM_PICKAXE).add(ModItems.VIBRANIUM_PICKAXE);
        valueLookupBuilder(ModTags.Items.VULPUS_PICKAXE).add(ModItems.VULPUS_PICKAXE);
        valueLookupBuilder(ModTags.Items.ENDERIUM_PICKAXE).add(ModItems.ENDERIUM_PICKAXE);

        valueLookupBuilder(ModTags.Items.VIBRANIUM_SHOVEL).add(ModItems.VIBRANIUM_SHOVEL);
        valueLookupBuilder(ModTags.Items.VULPUS_SHOVEL).add(ModItems.VULPUS_SHOVEL);
        valueLookupBuilder(ModTags.Items.ENDERIUM_SHOVEL).add(ModItems.ENDERIUM_SHOVEL);

        valueLookupBuilder(ModTags.Items.VIBRANIUM_HOE).add(ModItems.VIBRANIUM_HOE);
        valueLookupBuilder(ModTags.Items.VULPUS_HOE).add(ModItems.VULPUS_HOE);
        valueLookupBuilder(ModTags.Items.ENDERIUM_HOE).add(ModItems.ENDERIUM_HOE);

        valueLookupBuilder(ModTags.Items.VIBRANIUM_HAMMER).add(ModItems.VIBRANIUM_HAMMER);
        valueLookupBuilder(ModTags.Items.VULPUS_HAMMER).add(ModItems.VULPUS_HAMMER);
        valueLookupBuilder(ModTags.Items.ENDERIUM_HAMMER).add(ModItems.ENDERIUM_HAMMER);

        valueLookupBuilder(ModTags.Items.VIBRANIUM_EXCAVATOR).add(ModItems.VIBRANIUM_EXCAVATOR);
        valueLookupBuilder(ModTags.Items.VULPUS_EXCAVATOR).add(ModItems.VULPUS_EXCAVATOR);
        valueLookupBuilder(ModTags.Items.ENDERIUM_EXCAVATOR).add(ModItems.ENDERIUM_EXCAVATOR);

        valueLookupBuilder(ModTags.Items.VIBRANIUM_PAXEL).add(ModItems.VIBRANIUM_PAXEL);
        valueLookupBuilder(ModTags.Items.VULPUS_PAXEL).add(ModItems.VULPUS_PAXEL);
        valueLookupBuilder(ModTags.Items.ENDERIUM_PAXEL).add(ModItems.ENDERIUM_PAXEL);

        valueLookupBuilder(ModTags.Items.VIBRANIUM_BOW).add(ModItems.VIBRANIUM_BOW);
        valueLookupBuilder(ModTags.Items.VULPUS_BOW).add(ModItems.VULPUS_BOW);
        valueLookupBuilder(ModTags.Items.ENDERIUM_BOW).add(ModItems.ENDERIUM_BOW);

        valueLookupBuilder(ItemTags.SWORDS).add(ModItems.VIBRANIUM_SWORD,
                ModItems.VULPUS_SWORD,
                ModItems.ENDERIUM_SWORD);

        valueLookupBuilder(ItemTags.AXES).add(ModItems.VIBRANIUM_AXE,
                ModItems.VULPUS_AXE,
                ModItems.ENDERIUM_AXE,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL);

        valueLookupBuilder(ItemTags.PICKAXES).add(ModItems.VIBRANIUM_PICKAXE,
                ModItems.VULPUS_PICKAXE,
                ModItems.ENDERIUM_PICKAXE,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL);

        valueLookupBuilder(ItemTags.SHOVELS).add(ModItems.VIBRANIUM_SHOVEL,
                ModItems.VULPUS_SHOVEL,
                ModItems.ENDERIUM_SHOVEL,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL);

        valueLookupBuilder(ItemTags.HOES).add(ModItems.VIBRANIUM_HOE,
                ModItems.VULPUS_HOE,
                ModItems.ENDERIUM_HOE);

        valueLookupBuilder(ConventionalItemTags.BOW_TOOLS).add(ModItems.VIBRANIUM_BOW,
                ModItems.VULPUS_BOW,
                ModItems.ENDERIUM_BOW);

        valueLookupBuilder(ConventionalItemTags.TOOLS).add(ModItems.VIBRANIUM_HAMMER,
                ModItems.VULPUS_HAMMER,
                ModItems.ENDERIUM_HAMMER,
                ModItems.VIBRANIUM_EXCAVATOR,
                ModItems.VULPUS_EXCAVATOR,
                ModItems.ENDERIUM_EXCAVATOR,
                ModItems.VIBRANIUM_PICKAXE,
                ModItems.VULPUS_PICKAXE,
                ModItems.ENDERIUM_PICKAXE,
                ModItems.VIBRANIUM_HOE,
                ModItems.VULPUS_HOE,
                ModItems.ENDERIUM_HOE,
                ModItems.VIBRANIUM_AXE,
                ModItems.VULPUS_AXE,
                ModItems.ENDERIUM_AXE,
                ModItems.VIBRANIUM_SHOVEL,
                ModItems.VULPUS_SHOVEL,
                ModItems.ENDERIUM_SHOVEL,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL);

        valueLookupBuilder(ConventionalItemTags.MINING_TOOL_TOOLS).add(ModItems.VIBRANIUM_HAMMER,
                ModItems.VULPUS_HAMMER,
                ModItems.ENDERIUM_HAMMER,
                ModItems.VIBRANIUM_EXCAVATOR,
                ModItems.VULPUS_EXCAVATOR,
                ModItems.ENDERIUM_EXCAVATOR,
                ModItems.VIBRANIUM_PICKAXE,
                ModItems.VULPUS_PICKAXE,
                ModItems.ENDERIUM_PICKAXE,
                ModItems.VIBRANIUM_HOE,
                ModItems.VULPUS_HOE,
                ModItems.ENDERIUM_HOE,
                ModItems.VIBRANIUM_AXE,
                ModItems.VULPUS_AXE,
                ModItems.ENDERIUM_AXE,
                ModItems.VIBRANIUM_SHOVEL,
                ModItems.VULPUS_SHOVEL,
                ModItems.ENDERIUM_SHOVEL,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL);

        valueLookupBuilder(ModTags.Items.TOOLS_NETHERITE).add(Items.NETHERITE_PICKAXE);

        //Enchantments
        valueLookupBuilder(ItemTags.ARMOR_ENCHANTABLE).add(ModItems.VIBRANIUM_HELMET,
                ModItems.VIBRANIUM_CHESTPLATE,
                ModItems.VIBRANIUM_LEGGINGS,
                ModItems.VIBRANIUM_BOOTS,
                ModItems.VULPUS_HELMET,
                ModItems.VULPUS_CHESTPLATE,
                ModItems.VULPUS_LEGGINGS,
                ModItems.VULPUS_BOOTS,
                ModItems.ENDERIUM_HELMET,
                ModItems.ENDERIUM_CHESTPLATE,
                ModItems.ENDERIUM_LEGGINGS,
                ModItems.ENDERIUM_BOOTS);

        valueLookupBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(ModItems.VIBRANIUM_HELMET,
                ModItems.VULPUS_HELMET,
                ModItems.ENDERIUM_HELMET);

        valueLookupBuilder(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(ModItems.VIBRANIUM_CHESTPLATE,
                ModItems.VULPUS_CHESTPLATE,
                ModItems.ENDERIUM_CHESTPLATE);

        valueLookupBuilder(ItemTags.LEG_ARMOR_ENCHANTABLE).add(ModItems.VIBRANIUM_LEGGINGS,
                ModItems.VULPUS_LEGGINGS,
                ModItems.ENDERIUM_LEGGINGS);

        valueLookupBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(ModItems.VIBRANIUM_BOOTS,
                ModItems.VULPUS_BOOTS,
                ModItems.ENDERIUM_BOOTS);

        valueLookupBuilder(ItemTags.BOW_ENCHANTABLE).add(ModItems.VIBRANIUM_BOW,
                ModItems.VULPUS_BOW,
                ModItems.ENDERIUM_BOW);

        valueLookupBuilder(ItemTags.WEAPON_ENCHANTABLE).add(ModItems.VIBRANIUM_SWORD,
                ModItems.VULPUS_SWORD,
                ModItems.ENDERIUM_SWORD,
                ModItems.VIBRANIUM_AXE,
                ModItems.VULPUS_AXE,
                ModItems.ENDERIUM_AXE,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL);

        valueLookupBuilder(ItemTags.SHARP_WEAPON_ENCHANTABLE).add(ModItems.VIBRANIUM_SWORD,
                ModItems.VULPUS_SWORD,
                ModItems.ENDERIUM_SWORD,
                ModItems.VIBRANIUM_AXE,
                ModItems.VULPUS_AXE,
                ModItems.ENDERIUM_AXE,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL);

        valueLookupBuilder(ItemTags.FIRE_ASPECT_ENCHANTABLE).add(ModItems.VIBRANIUM_SWORD,
                ModItems.VULPUS_SWORD,
                ModItems.ENDERIUM_SWORD);

        valueLookupBuilder(ItemTags.MINING_ENCHANTABLE).add(ModItems.VIBRANIUM_HAMMER,
                ModItems.VULPUS_HAMMER,
                ModItems.ENDERIUM_HAMMER,
                ModItems.VIBRANIUM_EXCAVATOR,
                ModItems.VULPUS_EXCAVATOR,
                ModItems.ENDERIUM_EXCAVATOR,
                ModItems.VIBRANIUM_PICKAXE,
                ModItems.VULPUS_PICKAXE,
                ModItems.ENDERIUM_PICKAXE,
                ModItems.VIBRANIUM_HOE,
                ModItems.VULPUS_HOE,
                ModItems.ENDERIUM_HOE,
                ModItems.VIBRANIUM_AXE,
                ModItems.VULPUS_AXE,
                ModItems.ENDERIUM_AXE,
                ModItems.VIBRANIUM_SHOVEL,
                ModItems.VULPUS_SHOVEL,
                ModItems.ENDERIUM_SHOVEL,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL);

        valueLookupBuilder(ItemTags.MINING_LOOT_ENCHANTABLE).add(ModItems.VIBRANIUM_HAMMER,
                ModItems.VULPUS_HAMMER,
                ModItems.ENDERIUM_HAMMER,
                ModItems.VIBRANIUM_EXCAVATOR,
                ModItems.VULPUS_EXCAVATOR,
                ModItems.ENDERIUM_EXCAVATOR,
                ModItems.VIBRANIUM_PICKAXE,
                ModItems.VULPUS_PICKAXE,
                ModItems.ENDERIUM_PICKAXE,
                ModItems.VIBRANIUM_HOE,
                ModItems.VULPUS_HOE,
                ModItems.ENDERIUM_HOE,
                ModItems.VIBRANIUM_AXE,
                ModItems.VULPUS_AXE,
                ModItems.ENDERIUM_AXE,
                ModItems.VIBRANIUM_SHOVEL,
                ModItems.VULPUS_SHOVEL,
                ModItems.ENDERIUM_SHOVEL,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL);

        valueLookupBuilder(ItemTags.VANISHING_ENCHANTABLE).add(ModItems.VIBRANIUM_HELMET,
                ModItems.VIBRANIUM_CHESTPLATE,
                ModItems.VIBRANIUM_LEGGINGS,
                ModItems.VIBRANIUM_BOOTS,
                ModItems.VULPUS_HELMET,
                ModItems.VULPUS_CHESTPLATE,
                ModItems.VULPUS_LEGGINGS,
                ModItems.VULPUS_BOOTS,
                ModItems.ENDERIUM_HELMET,
                ModItems.ENDERIUM_CHESTPLATE,
                ModItems.ENDERIUM_LEGGINGS,
                ModItems.ENDERIUM_BOOTS,
                ModItems.VIBRANIUM_HAMMER,
                ModItems.VULPUS_HAMMER,
                ModItems.ENDERIUM_HAMMER,
                ModItems.VIBRANIUM_EXCAVATOR,
                ModItems.VULPUS_EXCAVATOR,
                ModItems.ENDERIUM_EXCAVATOR,
                ModItems.VIBRANIUM_PICKAXE,
                ModItems.VULPUS_PICKAXE,
                ModItems.ENDERIUM_PICKAXE,
                ModItems.VIBRANIUM_HOE,
                ModItems.VULPUS_HOE,
                ModItems.ENDERIUM_HOE,
                ModItems.VIBRANIUM_AXE,
                ModItems.VULPUS_AXE,
                ModItems.ENDERIUM_AXE,
                ModItems.VIBRANIUM_SHOVEL,
                ModItems.VULPUS_SHOVEL,
                ModItems.ENDERIUM_SHOVEL,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL,
                ModItems.VIBRANIUM_SWORD,
                ModItems.VULPUS_SWORD,
                ModItems.ENDERIUM_SWORD,
                ModItems.VIBRANIUM_AXE,
                ModItems.VULPUS_AXE,
                ModItems.ENDERIUM_AXE,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL,
                ModItems.VIBRANIUM_BOW,
                ModItems.VULPUS_BOW,
                ModItems.ENDERIUM_BOW);

        valueLookupBuilder(ItemTags.DURABILITY_ENCHANTABLE).add(ModItems.VIBRANIUM_HELMET,
                ModItems.VIBRANIUM_CHESTPLATE,
                ModItems.VIBRANIUM_LEGGINGS,
                ModItems.VIBRANIUM_BOOTS,
                ModItems.VULPUS_HELMET,
                ModItems.VULPUS_CHESTPLATE,
                ModItems.VULPUS_LEGGINGS,
                ModItems.VULPUS_BOOTS,
                ModItems.ENDERIUM_HELMET,
                ModItems.ENDERIUM_CHESTPLATE,
                ModItems.ENDERIUM_LEGGINGS,
                ModItems.ENDERIUM_BOOTS,
                ModItems.VIBRANIUM_HAMMER,
                ModItems.VULPUS_HAMMER,
                ModItems.ENDERIUM_HAMMER,
                ModItems.VIBRANIUM_EXCAVATOR,
                ModItems.VULPUS_EXCAVATOR,
                ModItems.ENDERIUM_EXCAVATOR,
                ModItems.VIBRANIUM_PICKAXE,
                ModItems.VULPUS_PICKAXE,
                ModItems.ENDERIUM_PICKAXE,
                ModItems.VIBRANIUM_HOE,
                ModItems.VULPUS_HOE,
                ModItems.ENDERIUM_HOE,
                ModItems.VIBRANIUM_AXE,
                ModItems.VULPUS_AXE,
                ModItems.ENDERIUM_AXE,
                ModItems.VIBRANIUM_SHOVEL,
                ModItems.VULPUS_SHOVEL,
                ModItems.ENDERIUM_SHOVEL,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL,
                ModItems.VIBRANIUM_SWORD,
                ModItems.VULPUS_SWORD,
                ModItems.ENDERIUM_SWORD,
                ModItems.VIBRANIUM_AXE,
                ModItems.VULPUS_AXE,
                ModItems.ENDERIUM_AXE,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL,
                ModItems.VIBRANIUM_BOW,
                ModItems.VULPUS_BOW,
                ModItems.ENDERIUM_BOW);

        //Materials
        valueLookupBuilder(ConventionalItemTags.INGOTS).add(ModItems.VIBRANIUM_INGOT,
                ModItems.VULPUS_INGOT,
                ModItems.ENDERIUM_INGOT);

        valueLookupBuilder(ConventionalItemTags.NUGGETS).add(ModItems.VIBRANIUM_NUGGET,
                ModItems.VULPUS_NUGGET,
                ModItems.ENDERIUM_NUGGET);

        valueLookupBuilder(ConventionalItemTags.RAW_MATERIALS).add(ModItems.RAW_VIBRANIUM,
                ModItems.RAW_VULPUS,
                ModItems.RAW_ENDERIUM);

        //Mining / Harvesting
        valueLookupBuilder(ItemTags.BREAKS_DECORATED_POTS).add(ModItems.VIBRANIUM_HAMMER,
                ModItems.VULPUS_HAMMER,
                ModItems.ENDERIUM_HAMMER,
                ModItems.VIBRANIUM_EXCAVATOR,
                ModItems.VULPUS_EXCAVATOR,
                ModItems.ENDERIUM_EXCAVATOR,
                ModItems.VIBRANIUM_PICKAXE,
                ModItems.VULPUS_PICKAXE,
                ModItems.ENDERIUM_PICKAXE,
                ModItems.VIBRANIUM_HOE,
                ModItems.VULPUS_HOE,
                ModItems.ENDERIUM_HOE,
                ModItems.VIBRANIUM_AXE,
                ModItems.VULPUS_AXE,
                ModItems.ENDERIUM_AXE,
                ModItems.VIBRANIUM_SHOVEL,
                ModItems.VULPUS_SHOVEL,
                ModItems.ENDERIUM_SHOVEL,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL);

        valueLookupBuilder(ItemTags.CLUSTER_MAX_HARVESTABLES).add(ModItems.VIBRANIUM_HAMMER,
                ModItems.VULPUS_HAMMER,
                ModItems.ENDERIUM_HAMMER,
                ModItems.VIBRANIUM_PICKAXE,
                ModItems.VULPUS_PICKAXE,
                ModItems.ENDERIUM_PICKAXE,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL);

        //Conventional wrappers
        valueLookupBuilder(ConventionalItemTags.ENCHANTABLES).add(ModItems.VIBRANIUM_HELMET,
                ModItems.VIBRANIUM_CHESTPLATE,
                ModItems.VIBRANIUM_LEGGINGS,
                ModItems.VIBRANIUM_BOOTS,
                ModItems.VULPUS_HELMET,
                ModItems.VULPUS_CHESTPLATE,
                ModItems.VULPUS_LEGGINGS,
                ModItems.VULPUS_BOOTS,
                ModItems.ENDERIUM_HELMET,
                ModItems.ENDERIUM_CHESTPLATE,
                ModItems.ENDERIUM_LEGGINGS,
                ModItems.ENDERIUM_BOOTS,
                ModItems.VIBRANIUM_HAMMER,
                ModItems.VULPUS_HAMMER,
                ModItems.ENDERIUM_HAMMER,
                ModItems.VIBRANIUM_EXCAVATOR,
                ModItems.VULPUS_EXCAVATOR,
                ModItems.ENDERIUM_EXCAVATOR,
                ModItems.VIBRANIUM_PICKAXE,
                ModItems.VULPUS_PICKAXE,
                ModItems.ENDERIUM_PICKAXE,
                ModItems.VIBRANIUM_HOE,
                ModItems.VULPUS_HOE,
                ModItems.ENDERIUM_HOE,
                ModItems.VIBRANIUM_AXE,
                ModItems.VULPUS_AXE,
                ModItems.ENDERIUM_AXE,
                ModItems.VIBRANIUM_SHOVEL,
                ModItems.VULPUS_SHOVEL,
                ModItems.ENDERIUM_SHOVEL,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL,
                ModItems.VIBRANIUM_SWORD,
                ModItems.VULPUS_SWORD,
                ModItems.ENDERIUM_SWORD,
                ModItems.VIBRANIUM_AXE,
                ModItems.VULPUS_AXE,
                ModItems.ENDERIUM_AXE,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL,
                ModItems.VIBRANIUM_BOW,
                ModItems.VULPUS_BOW,
                ModItems.ENDERIUM_BOW);

        valueLookupBuilder(ConventionalItemTags.RANGED_WEAPON_TOOLS).add(ModItems.VIBRANIUM_BOW,
                ModItems.VULPUS_BOW,
                ModItems.ENDERIUM_BOW);

        valueLookupBuilder(ConventionalItemTags.MELEE_WEAPON_TOOLS).add(ModItems.VIBRANIUM_SWORD,
                ModItems.VULPUS_SWORD,
                ModItems.ENDERIUM_SWORD,
                ModItems.VIBRANIUM_AXE,
                ModItems.VULPUS_AXE,
                ModItems.ENDERIUM_AXE,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL);

        //Repairs Material
        valueLookupBuilder(ModTags.Items.VIBRANIUM_REPAIRS).add(ModItems.VIBRANIUM_INGOT);
        valueLookupBuilder(ModTags.Items.VULPUS_REPAIRS).add(ModItems.VULPUS_INGOT);
        valueLookupBuilder(ModTags.Items.ENDERIUM_REPAIRS).add(ModItems.ENDERIUM_INGOT);
    }
}