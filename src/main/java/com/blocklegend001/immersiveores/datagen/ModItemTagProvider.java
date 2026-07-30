package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.item.ModItems;
import com.blocklegend001.immersiveores.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ModItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public ModItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    private static List<ResourceKey<Item>> keys(Item... items) {
        return Arrays.stream(items)
                .map(item -> item.builtInRegistryHolder().key())
                .collect(Collectors.toList());
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {

        //Armor
        builder(ItemTags.HEAD_ARMOR).addAll(keys(ModItems.VIBRANIUM_HELMET,
                ModItems.VULPUS_HELMET,
                ModItems.ENDERIUM_HELMET));

        builder(ItemTags.CHEST_ARMOR).addAll(keys(ModItems.VIBRANIUM_CHESTPLATE,
                ModItems.VULPUS_CHESTPLATE,
                ModItems.ENDERIUM_CHESTPLATE));

        builder(ItemTags.LEG_ARMOR).addAll(keys(ModItems.VIBRANIUM_LEGGINGS,
                ModItems.VULPUS_LEGGINGS,
                ModItems.ENDERIUM_LEGGINGS));

        builder(ItemTags.FOOT_ARMOR).addAll(keys(ModItems.VIBRANIUM_BOOTS,
                ModItems.VULPUS_BOOTS,
                ModItems.ENDERIUM_BOOTS));

        builder(ItemTags.TRIMMABLE_ARMOR).addAll(keys(ModItems.VIBRANIUM_HELMET,
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
                ModItems.ENDERIUM_BOOTS));

        builder(ModTags.Items.VIBRANIUM_ARMOR).addAll(keys(ModItems.VIBRANIUM_HELMET,
                ModItems.VIBRANIUM_CHESTPLATE,
                ModItems.VIBRANIUM_LEGGINGS,
                ModItems.VIBRANIUM_BOOTS));

        builder(ModTags.Items.VULPUS_ARMOR).addAll(keys(ModItems.VULPUS_HELMET,
                ModItems.VULPUS_CHESTPLATE,
                ModItems.VULPUS_LEGGINGS,
                ModItems.VULPUS_BOOTS));

        builder(ModTags.Items.ENDERIUM_ARMOR).addAll(keys(ModItems.ENDERIUM_HELMET,
                ModItems.ENDERIUM_CHESTPLATE,
                ModItems.ENDERIUM_LEGGINGS,
                ModItems.ENDERIUM_BOOTS));

        builder(ConventionalItemTags.ARMORS).addAll(keys(ModItems.VIBRANIUM_HELMET,
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
                ModItems.ENDERIUM_BOOTS));

        //Tools, Sword, Bows ...
        builder(ModTags.Items.VIBRANIUM_SWORD).addAll(keys(ModItems.VIBRANIUM_SWORD));
        builder(ModTags.Items.VULPUS_SWORD).addAll(keys(ModItems.VULPUS_SWORD));
        builder(ModTags.Items.ENDERIUM_SWORD).addAll(keys(ModItems.ENDERIUM_SWORD));

        builder(ModTags.Items.VIBRANIUM_AXE).addAll(keys(ModItems.VIBRANIUM_AXE));
        builder(ModTags.Items.VULPUS_AXE).addAll(keys(ModItems.VULPUS_AXE));
        builder(ModTags.Items.ENDERIUM_AXE).addAll(keys(ModItems.ENDERIUM_AXE));

        builder(ModTags.Items.VIBRANIUM_PICKAXE).addAll(keys(ModItems.VIBRANIUM_PICKAXE));
        builder(ModTags.Items.VULPUS_PICKAXE).addAll(keys(ModItems.VULPUS_PICKAXE));
        builder(ModTags.Items.ENDERIUM_PICKAXE).addAll(keys(ModItems.ENDERIUM_PICKAXE));

        builder(ModTags.Items.VIBRANIUM_SHOVEL).addAll(keys(ModItems.VIBRANIUM_SHOVEL));
        builder(ModTags.Items.VULPUS_SHOVEL).addAll(keys(ModItems.VULPUS_SHOVEL));
        builder(ModTags.Items.ENDERIUM_SHOVEL).addAll(keys(ModItems.ENDERIUM_SHOVEL));

        builder(ModTags.Items.VIBRANIUM_HOE).addAll(keys(ModItems.VIBRANIUM_HOE));
        builder(ModTags.Items.VULPUS_HOE).addAll(keys(ModItems.VULPUS_HOE));
        builder(ModTags.Items.ENDERIUM_HOE).addAll(keys(ModItems.ENDERIUM_HOE));

        builder(ModTags.Items.VIBRANIUM_HAMMER).addAll(keys(ModItems.VIBRANIUM_HAMMER));
        builder(ModTags.Items.VULPUS_HAMMER).addAll(keys(ModItems.VULPUS_HAMMER));
        builder(ModTags.Items.ENDERIUM_HAMMER).addAll(keys(ModItems.ENDERIUM_HAMMER));

        builder(ModTags.Items.VIBRANIUM_EXCAVATOR).addAll(keys(ModItems.VIBRANIUM_EXCAVATOR));
        builder(ModTags.Items.VULPUS_EXCAVATOR).addAll(keys(ModItems.VULPUS_EXCAVATOR));
        builder(ModTags.Items.ENDERIUM_EXCAVATOR).addAll(keys(ModItems.ENDERIUM_EXCAVATOR));

        builder(ModTags.Items.VIBRANIUM_PAXEL).addAll(keys(ModItems.VIBRANIUM_PAXEL));
        builder(ModTags.Items.VULPUS_PAXEL).addAll(keys(ModItems.VULPUS_PAXEL));
        builder(ModTags.Items.ENDERIUM_PAXEL).addAll(keys(ModItems.ENDERIUM_PAXEL));

        builder(ModTags.Items.VIBRANIUM_BOW).addAll(keys(ModItems.VIBRANIUM_BOW));
        builder(ModTags.Items.VULPUS_BOW).addAll(keys(ModItems.VULPUS_BOW));
        builder(ModTags.Items.ENDERIUM_BOW).addAll(keys(ModItems.ENDERIUM_BOW));

        builder(ItemTags.SWORDS).addAll(keys(ModItems.VIBRANIUM_SWORD,
                ModItems.VULPUS_SWORD,
                ModItems.ENDERIUM_SWORD));

        builder(ItemTags.AXES).addAll(keys(ModItems.VIBRANIUM_AXE,
                ModItems.VULPUS_AXE,
                ModItems.ENDERIUM_AXE,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL));

        builder(ItemTags.PICKAXES).addAll(keys(ModItems.VIBRANIUM_PICKAXE,
                ModItems.VULPUS_PICKAXE,
                ModItems.ENDERIUM_PICKAXE,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL));

        builder(ItemTags.SHOVELS).addAll(keys(ModItems.VIBRANIUM_SHOVEL,
                ModItems.VULPUS_SHOVEL,
                ModItems.ENDERIUM_SHOVEL,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL));

        builder(ItemTags.HOES).addAll(keys(ModItems.VIBRANIUM_HOE,
                ModItems.VULPUS_HOE,
                ModItems.ENDERIUM_HOE));

        builder(ConventionalItemTags.BOW_TOOLS).addAll(keys(ModItems.VIBRANIUM_BOW,
                ModItems.VULPUS_BOW,
                ModItems.ENDERIUM_BOW));

        builder(ConventionalItemTags.TOOLS).addAll(keys(ModItems.VIBRANIUM_HAMMER,
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
                ModItems.ENDERIUM_PAXEL));

        builder(ConventionalItemTags.MINING_TOOL_TOOLS).addAll(keys(ModItems.VIBRANIUM_HAMMER,
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
                ModItems.ENDERIUM_PAXEL));

        builder(ModTags.Items.TOOLS_NETHERITE).addAll(keys(Items.NETHERITE_PICKAXE));

        //Enchantments
        builder(ItemTags.ARMOR_ENCHANTABLE).addAll(keys(ModItems.VIBRANIUM_HELMET,
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
                ModItems.ENDERIUM_BOOTS));

        builder(ItemTags.HEAD_ARMOR_ENCHANTABLE).addAll(keys(ModItems.VIBRANIUM_HELMET,
                ModItems.VULPUS_HELMET,
                ModItems.ENDERIUM_HELMET));

        builder(ItemTags.CHEST_ARMOR_ENCHANTABLE).addAll(keys(ModItems.VIBRANIUM_CHESTPLATE,
                ModItems.VULPUS_CHESTPLATE,
                ModItems.ENDERIUM_CHESTPLATE));

        builder(ItemTags.LEG_ARMOR_ENCHANTABLE).addAll(keys(ModItems.VIBRANIUM_LEGGINGS,
                ModItems.VULPUS_LEGGINGS,
                ModItems.ENDERIUM_LEGGINGS));

        builder(ItemTags.FOOT_ARMOR_ENCHANTABLE).addAll(keys(ModItems.VIBRANIUM_BOOTS,
                ModItems.VULPUS_BOOTS,
                ModItems.ENDERIUM_BOOTS));

        builder(ItemTags.BOW_ENCHANTABLE).addAll(keys(ModItems.VIBRANIUM_BOW,
                ModItems.VULPUS_BOW,
                ModItems.ENDERIUM_BOW));

        builder(ItemTags.WEAPON_ENCHANTABLE).addAll(keys(ModItems.VIBRANIUM_SWORD,
                ModItems.VULPUS_SWORD,
                ModItems.ENDERIUM_SWORD,
                ModItems.VIBRANIUM_AXE,
                ModItems.VULPUS_AXE,
                ModItems.ENDERIUM_AXE,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL));

        builder(ItemTags.SHARP_WEAPON_ENCHANTABLE).addAll(keys(ModItems.VIBRANIUM_SWORD,
                ModItems.VULPUS_SWORD,
                ModItems.ENDERIUM_SWORD,
                ModItems.VIBRANIUM_AXE,
                ModItems.VULPUS_AXE,
                ModItems.ENDERIUM_AXE,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL));

        builder(ItemTags.FIRE_ASPECT_ENCHANTABLE).addAll(keys(ModItems.VIBRANIUM_SWORD,
                ModItems.VULPUS_SWORD,
                ModItems.ENDERIUM_SWORD));

        builder(ItemTags.MINING_ENCHANTABLE).addAll(keys(ModItems.VIBRANIUM_HAMMER,
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
                ModItems.ENDERIUM_PAXEL));

        builder(ItemTags.MINING_LOOT_ENCHANTABLE).addAll(keys(ModItems.VIBRANIUM_HAMMER,
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
                ModItems.ENDERIUM_PAXEL));

        builder(ItemTags.VANISHING_ENCHANTABLE).addAll(keys(ModItems.VIBRANIUM_HELMET,
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
                ModItems.VIBRANIUM_BOW,
                ModItems.VULPUS_BOW,
                ModItems.ENDERIUM_BOW));

        builder(ItemTags.DURABILITY_ENCHANTABLE).addAll(keys(ModItems.VIBRANIUM_HELMET,
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
                ModItems.VIBRANIUM_BOW,
                ModItems.VULPUS_BOW,
                ModItems.ENDERIUM_BOW));

        //Materials
        builder(ConventionalItemTags.INGOTS).addAll(keys(ModItems.VIBRANIUM_INGOT,
                ModItems.VULPUS_INGOT,
                ModItems.ENDERIUM_INGOT));

        builder(ConventionalItemTags.NUGGETS).addAll(keys(ModItems.VIBRANIUM_NUGGET,
                ModItems.VULPUS_NUGGET,
                ModItems.ENDERIUM_NUGGET));

        builder(ConventionalItemTags.RAW_MATERIALS).addAll(keys(ModItems.RAW_VIBRANIUM,
                ModItems.RAW_VULPUS,
                ModItems.RAW_ENDERIUM));

        //Mining / Harvesting
        builder(ItemTags.BREAKS_DECORATED_POTS).addAll(keys(ModItems.VIBRANIUM_HAMMER,
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
                ModItems.ENDERIUM_PAXEL));

        builder(ItemTags.CLUSTER_MAX_HARVESTABLES).addAll(keys(ModItems.VIBRANIUM_HAMMER,
                ModItems.VULPUS_HAMMER,
                ModItems.ENDERIUM_HAMMER,
                ModItems.VIBRANIUM_PICKAXE,
                ModItems.VULPUS_PICKAXE,
                ModItems.ENDERIUM_PICKAXE,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL));

        //Conventional wrappers
        builder(ConventionalItemTags.ENCHANTABLES).addAll(keys(ModItems.VIBRANIUM_HELMET,
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
                ModItems.VIBRANIUM_BOW,
                ModItems.VULPUS_BOW,
                ModItems.ENDERIUM_BOW));

        builder(ConventionalItemTags.RANGED_WEAPON_TOOLS).addAll(keys(ModItems.VIBRANIUM_BOW,
                ModItems.VULPUS_BOW,
                ModItems.ENDERIUM_BOW));

        builder(ConventionalItemTags.MELEE_WEAPON_TOOLS).addAll(keys(ModItems.VIBRANIUM_SWORD,
                ModItems.VULPUS_SWORD,
                ModItems.ENDERIUM_SWORD,
                ModItems.VIBRANIUM_AXE,
                ModItems.VULPUS_AXE,
                ModItems.ENDERIUM_AXE,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL));

        //Repairs Material
        builder(ModTags.Items.VIBRANIUM_REPAIRS).addAll(keys(ModItems.VIBRANIUM_INGOT));
        builder(ModTags.Items.VULPUS_REPAIRS).addAll(keys(ModItems.VULPUS_INGOT));
        builder(ModTags.Items.ENDERIUM_REPAIRS).addAll(keys(ModItems.ENDERIUM_INGOT));
    }
}