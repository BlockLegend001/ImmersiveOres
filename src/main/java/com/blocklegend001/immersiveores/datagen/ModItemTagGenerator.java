package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.item.ModItems;
import com.blocklegend001.immersiveores.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.VanillaItemTagsProvider;
import net.minecraft.references.ItemIds;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends VanillaItemTagsProvider {
    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(packOutput, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //Armor
        tag(ItemTags.CHEST_ARMOR).add(ModItems.VIBRANIUM_CHESTPLATE.getKey(),
                ModItems.VULPUS_CHESTPLATE.getKey(),
                ModItems.ENDERIUM_CHESTPLATE.getKey());

        tag(ItemTags.FOOT_ARMOR).add(ModItems.VIBRANIUM_BOOTS.getKey(),
                ModItems.VULPUS_BOOTS.getKey(),
                ModItems.ENDERIUM_BOOTS.getKey());

        tag(ItemTags.LEG_ARMOR).add(ModItems.VIBRANIUM_LEGGINGS.getKey(),
                ModItems.VULPUS_LEGGINGS.getKey(),
                ModItems.ENDERIUM_LEGGINGS.getKey());

        tag(ItemTags.HEAD_ARMOR).add(ModItems.VIBRANIUM_HELMET.getKey(),
                ModItems.VULPUS_HELMET.getKey(),
                ModItems.ENDERIUM_HELMET.getKey());

        this.tag(ItemTags.TRIMMABLE_ARMOR).add(ModItems.VIBRANIUM_HELMET.getKey(),
                ModItems.VIBRANIUM_CHESTPLATE.getKey(),
                ModItems.VIBRANIUM_LEGGINGS.getKey(),
                ModItems.VIBRANIUM_BOOTS.getKey(),
                ModItems.VULPUS_HELMET.getKey(),
                ModItems.VULPUS_CHESTPLATE.getKey(),
                ModItems.VULPUS_LEGGINGS.getKey(),
                ModItems.VULPUS_BOOTS.getKey(),
                ModItems.ENDERIUM_HELMET.getKey(),
                ModItems.ENDERIUM_CHESTPLATE.getKey(),
                ModItems.ENDERIUM_LEGGINGS.getKey(),
                ModItems.ENDERIUM_BOOTS.getKey());

        tag(ModTags.Items.VIBRANIUM_ARMOR).add(ModItems.VIBRANIUM_HELMET.getKey(),
                ModItems.VIBRANIUM_CHESTPLATE.getKey(),
                ModItems.VIBRANIUM_LEGGINGS.getKey(),
                ModItems.VIBRANIUM_BOOTS.getKey());

        tag(ModTags.Items.VULPUS_ARMOR).add(ModItems.VULPUS_HELMET.getKey(),
                ModItems.VULPUS_CHESTPLATE.getKey(),
                ModItems.VULPUS_LEGGINGS.getKey(),
                ModItems.VULPUS_BOOTS.getKey());

        tag(ModTags.Items.ENDERIUM_ARMOR).add(ModItems.ENDERIUM_HELMET.getKey(),
                ModItems.ENDERIUM_CHESTPLATE.getKey(),
                ModItems.ENDERIUM_LEGGINGS.getKey(),
                ModItems.ENDERIUM_BOOTS.getKey());

        tag(Tags.Items.ARMORS).add(ModItems.VIBRANIUM_HELMET.getKey(),
                ModItems.VIBRANIUM_CHESTPLATE.getKey(),
                ModItems.VIBRANIUM_LEGGINGS.getKey(),
                ModItems.VIBRANIUM_BOOTS.getKey(),
                ModItems.VULPUS_HELMET.getKey(),
                ModItems.VULPUS_CHESTPLATE.getKey(),
                ModItems.VULPUS_LEGGINGS.getKey(),
                ModItems.VULPUS_BOOTS.getKey(),
                ModItems.ENDERIUM_HELMET.getKey(),
                ModItems.ENDERIUM_CHESTPLATE.getKey(),
                ModItems.ENDERIUM_LEGGINGS.getKey(),
                ModItems.ENDERIUM_BOOTS.getKey());

        //Tools, Sword, Bows ...
        tag(ModTags.Items.VIBRANIUM_BOW).add(ModItems.VIBRANIUM_BOW.getKey());
        tag(ModTags.Items.VULPUS_BOW).add(ModItems.VULPUS_BOW.getKey());
        tag(ModTags.Items.ENDERIUM_BOW).add(ModItems.ENDERIUM_BOW.getKey());

        tag(ModTags.Items.VIBRANIUM_HAMMER).add(ModItems.VIBRANIUM_HAMMER.getKey());
        tag(ModTags.Items.VULPUS_HAMMER).add(ModItems.VULPUS_HAMMER.getKey());
        tag(ModTags.Items.ENDERIUM_HAMMER).add(ModItems.ENDERIUM_HAMMER.getKey());

        tag(ModTags.Items.VIBRANIUM_EXCAVATOR).add(ModItems.VIBRANIUM_EXCAVATOR.getKey());
        tag(ModTags.Items.VULPUS_EXCAVATOR).add(ModItems.VULPUS_EXCAVATOR.getKey());
        tag(ModTags.Items.ENDERIUM_EXCAVATOR).add(ModItems.ENDERIUM_EXCAVATOR.getKey());

        tag(ModTags.Items.VIBRANIUM_PICKAXE).add(ModItems.VIBRANIUM_PICKAXE.getKey());
        tag(ModTags.Items.VULPUS_PICKAXE).add(ModItems.VULPUS_PICKAXE.getKey());
        tag(ModTags.Items.ENDERIUM_PICKAXE).add(ModItems.ENDERIUM_PICKAXE.getKey());

        tag(ModTags.Items.VIBRANIUM_HOE).add(ModItems.VIBRANIUM_HOE.getKey());
        tag(ModTags.Items.VULPUS_HOE).add(ModItems.VULPUS_HOE.getKey());
        tag(ModTags.Items.ENDERIUM_HOE).add(ModItems.ENDERIUM_HOE.getKey());

        tag(ModTags.Items.VIBRANIUM_AXE).add(ModItems.VIBRANIUM_AXE.getKey());
        tag(ModTags.Items.VULPUS_AXE).add(ModItems.VULPUS_AXE.getKey());
        tag(ModTags.Items.ENDERIUM_AXE).add(ModItems.ENDERIUM_AXE.getKey());

        tag(ModTags.Items.VIBRANIUM_SHOVEL).add(ModItems.VIBRANIUM_SHOVEL.getKey());
        tag(ModTags.Items.VULPUS_SHOVEL).add(ModItems.VULPUS_SHOVEL.getKey());
        tag(ModTags.Items.ENDERIUM_SHOVEL).add(ModItems.ENDERIUM_SHOVEL.getKey());

        tag(ModTags.Items.VIBRANIUM_PAXEL).add(ModItems.VIBRANIUM_PAXEL.getKey());
        tag(ModTags.Items.VULPUS_PAXEL).add(ModItems.VULPUS_PAXEL.getKey());
        tag(ModTags.Items.ENDERIUM_PAXEL).add(ModItems.ENDERIUM_PAXEL.getKey());

        tag(ModTags.Items.VIBRANIUM_SWORD).add(ModItems.VIBRANIUM_SWORD.getKey());
        tag(ModTags.Items.VULPUS_SWORD).add(ModItems.VULPUS_SWORD.getKey());
        tag(ModTags.Items.ENDERIUM_SWORD).add(ModItems.ENDERIUM_SWORD.getKey());

        tag(ModTags.Items.TOOLS_NETHERITE)
                .add(ItemIds.NETHERITE_PICKAXE);

        tag(ItemTags.PICKAXES).add(ModItems.VIBRANIUM_PICKAXE.getKey(),
                ModItems.VULPUS_PICKAXE.getKey(),
                ModItems.ENDERIUM_PICKAXE.getKey(),
                ModItems.VIBRANIUM_PAXEL.getKey(),
                ModItems.VULPUS_PAXEL.getKey(),
                ModItems.ENDERIUM_PAXEL.getKey());

        tag(ItemTags.SHOVELS).add(ModItems.VIBRANIUM_SHOVEL.getKey(),
                ModItems.VULPUS_SHOVEL.getKey(),
                ModItems.ENDERIUM_SHOVEL.getKey(),
                ModItems.VIBRANIUM_PAXEL.getKey(),
                ModItems.VULPUS_PAXEL.getKey(),
                ModItems.ENDERIUM_PAXEL.getKey());

        tag(ItemTags.AXES).add(ModItems.VIBRANIUM_AXE.getKey(),
                ModItems.VULPUS_AXE.getKey(),
                ModItems.ENDERIUM_AXE.getKey(),
                ModItems.VIBRANIUM_PAXEL.getKey(),
                ModItems.VULPUS_PAXEL.getKey(),
                ModItems.ENDERIUM_PAXEL.getKey());

        tag(ItemTags.HOES).add(ModItems.VIBRANIUM_HOE.getKey(),
                ModItems.VULPUS_HOE.getKey(),
                ModItems.ENDERIUM_HOE.getKey());

        tag(ItemTags.SWORDS).add(ModItems.VIBRANIUM_SWORD.getKey(),
                ModItems.VULPUS_SWORD.getKey(),
                ModItems.ENDERIUM_SWORD.getKey());

        tag(Tags.Items.TOOLS_BOW).add(ModItems.VIBRANIUM_BOW.getKey(),
                ModItems.VULPUS_BOW.getKey(),
                ModItems.ENDERIUM_BOW.getKey());

        tag(Tags.Items.RANGED_WEAPON_TOOLS).add(ModItems.VIBRANIUM_BOW.getKey(),
                ModItems.VULPUS_BOW.getKey(),
                ModItems.ENDERIUM_BOW.getKey());

        tag(Tags.Items.TOOLS).add(ModItems.VIBRANIUM_HAMMER.getKey(),
                ModItems.VULPUS_HAMMER.getKey(),
                ModItems.ENDERIUM_HAMMER.getKey(),
                ModItems.VIBRANIUM_EXCAVATOR.getKey(),
                ModItems.VULPUS_EXCAVATOR.getKey(),
                ModItems.ENDERIUM_EXCAVATOR.getKey(),
                ModItems.VIBRANIUM_PICKAXE.getKey(),
                ModItems.VULPUS_PICKAXE.getKey(),
                ModItems.ENDERIUM_PICKAXE.getKey(),
                ModItems.VIBRANIUM_HOE.getKey(),
                ModItems.VULPUS_HOE.getKey(),
                ModItems.ENDERIUM_HOE.getKey(),
                ModItems.VIBRANIUM_AXE.getKey(),
                ModItems.VULPUS_AXE.getKey(),
                ModItems.ENDERIUM_AXE.getKey(),
                ModItems.VIBRANIUM_SHOVEL.getKey(),
                ModItems.VULPUS_SHOVEL.getKey(),
                ModItems.ENDERIUM_SHOVEL.getKey(),
                ModItems.VIBRANIUM_PAXEL.getKey(),
                ModItems.VULPUS_PAXEL.getKey(),
                ModItems.ENDERIUM_PAXEL.getKey());

        tag(Tags.Items.MINING_TOOL_TOOLS).add(ModItems.VIBRANIUM_HAMMER.getKey(),
                ModItems.VULPUS_HAMMER.getKey(),
                ModItems.ENDERIUM_HAMMER.getKey(),
                ModItems.VIBRANIUM_EXCAVATOR.getKey(),
                ModItems.VULPUS_EXCAVATOR.getKey(),
                ModItems.ENDERIUM_EXCAVATOR.getKey(),
                ModItems.VIBRANIUM_PICKAXE.getKey(),
                ModItems.VULPUS_PICKAXE.getKey(),
                ModItems.ENDERIUM_PICKAXE.getKey(),
                ModItems.VIBRANIUM_HOE.getKey(),
                ModItems.VULPUS_HOE.getKey(),
                ModItems.ENDERIUM_HOE.getKey(),
                ModItems.VIBRANIUM_AXE.getKey(),
                ModItems.VULPUS_AXE.getKey(),
                ModItems.ENDERIUM_AXE.getKey(),
                ModItems.VIBRANIUM_SHOVEL.getKey(),
                ModItems.VULPUS_SHOVEL.getKey(),
                ModItems.ENDERIUM_SHOVEL.getKey(),
                ModItems.VIBRANIUM_PAXEL.getKey(),
                ModItems.VULPUS_PAXEL.getKey(),
                ModItems.ENDERIUM_PAXEL.getKey());

        tag(Tags.Items.MELEE_WEAPON_TOOLS).add(ModItems.VIBRANIUM_SWORD.getKey(),
                ModItems.VULPUS_SWORD.getKey(),
                ModItems.ENDERIUM_SWORD.getKey(),
                ModItems.VIBRANIUM_AXE.getKey(),
                ModItems.VULPUS_AXE.getKey(),
                ModItems.ENDERIUM_AXE.getKey(),
                ModItems.VIBRANIUM_PAXEL.getKey(),
                ModItems.VULPUS_PAXEL.getKey(),
                ModItems.ENDERIUM_PAXEL.getKey());

        //Enchantments
        tag(ItemTags.BOW_ENCHANTABLE).add(ModItems.VIBRANIUM_BOW.getKey(),
                ModItems.VULPUS_BOW.getKey(),
                ModItems.ENDERIUM_BOW.getKey());

        tag(ItemTags.ARMOR_ENCHANTABLE).add(ModItems.VIBRANIUM_HELMET.getKey(),
                ModItems.VIBRANIUM_CHESTPLATE.getKey(),
                ModItems.VIBRANIUM_LEGGINGS.getKey(),
                ModItems.VIBRANIUM_BOOTS.getKey(),
                ModItems.VULPUS_HELMET.getKey(),
                ModItems.VULPUS_CHESTPLATE.getKey(),
                ModItems.VULPUS_LEGGINGS.getKey(),
                ModItems.VULPUS_BOOTS.getKey(),
                ModItems.ENDERIUM_HELMET.getKey(),
                ModItems.ENDERIUM_CHESTPLATE.getKey(),
                ModItems.ENDERIUM_LEGGINGS.getKey(),
                ModItems.ENDERIUM_BOOTS.getKey());

        tag(ItemTags.MINING_LOOT_ENCHANTABLE).add(ModItems.VIBRANIUM_HAMMER.getKey(),
                ModItems.VULPUS_HAMMER.getKey(),
                ModItems.ENDERIUM_HAMMER.getKey(),
                ModItems.VIBRANIUM_EXCAVATOR.getKey(),
                ModItems.VULPUS_EXCAVATOR.getKey(),
                ModItems.ENDERIUM_EXCAVATOR.getKey(),
                ModItems.VIBRANIUM_PICKAXE.getKey(),
                ModItems.VULPUS_PICKAXE.getKey(),
                ModItems.ENDERIUM_PICKAXE.getKey(),
                ModItems.VIBRANIUM_HOE.getKey(),
                ModItems.VULPUS_HOE.getKey(),
                ModItems.ENDERIUM_HOE.getKey(),
                ModItems.VIBRANIUM_AXE.getKey(),
                ModItems.VULPUS_AXE.getKey(),
                ModItems.ENDERIUM_AXE.getKey(),
                ModItems.VIBRANIUM_SHOVEL.getKey(),
                ModItems.VULPUS_SHOVEL.getKey(),
                ModItems.ENDERIUM_SHOVEL.getKey(),
                ModItems.VIBRANIUM_PAXEL.getKey(),
                ModItems.VULPUS_PAXEL.getKey(),
                ModItems.ENDERIUM_PAXEL.getKey());

        tag(ItemTags.VANISHING_ENCHANTABLE).add(ModItems.VIBRANIUM_HELMET.getKey(),
                ModItems.VIBRANIUM_CHESTPLATE.getKey(),
                ModItems.VIBRANIUM_LEGGINGS.getKey(),
                ModItems.VIBRANIUM_BOOTS.getKey(),
                ModItems.VULPUS_HELMET.getKey(),
                ModItems.VULPUS_CHESTPLATE.getKey(),
                ModItems.VULPUS_LEGGINGS.getKey(),
                ModItems.VULPUS_BOOTS.getKey(),
                ModItems.ENDERIUM_HELMET.getKey(),
                ModItems.ENDERIUM_CHESTPLATE.getKey(),
                ModItems.ENDERIUM_LEGGINGS.getKey(),
                ModItems.ENDERIUM_BOOTS.getKey(),
                ModItems.VIBRANIUM_HAMMER.getKey(),
                ModItems.VULPUS_HAMMER.getKey(),
                ModItems.ENDERIUM_HAMMER.getKey(),
                ModItems.VIBRANIUM_EXCAVATOR.getKey(),
                ModItems.VULPUS_EXCAVATOR.getKey(),
                ModItems.ENDERIUM_EXCAVATOR.getKey(),
                ModItems.VIBRANIUM_PICKAXE.getKey(),
                ModItems.VULPUS_PICKAXE.getKey(),
                ModItems.ENDERIUM_PICKAXE.getKey(),
                ModItems.VIBRANIUM_HOE.getKey(),
                ModItems.VULPUS_HOE.getKey(),
                ModItems.ENDERIUM_HOE.getKey(),
                ModItems.VIBRANIUM_AXE.getKey(),
                ModItems.VULPUS_AXE.getKey(),
                ModItems.ENDERIUM_AXE.getKey(),
                ModItems.VIBRANIUM_SHOVEL.getKey(),
                ModItems.VULPUS_SHOVEL.getKey(),
                ModItems.ENDERIUM_SHOVEL.getKey(),
                ModItems.VIBRANIUM_PAXEL.getKey(),
                ModItems.VULPUS_PAXEL.getKey(),
                ModItems.ENDERIUM_PAXEL.getKey(),
                ModItems.VIBRANIUM_SWORD.getKey(),
                ModItems.VULPUS_SWORD.getKey(),
                ModItems.ENDERIUM_SWORD.getKey(),
                ModItems.VIBRANIUM_AXE.getKey(),
                ModItems.VULPUS_AXE.getKey(),
                ModItems.ENDERIUM_AXE.getKey(),
                ModItems.VIBRANIUM_PAXEL.getKey(),
                ModItems.VULPUS_PAXEL.getKey(),
                ModItems.ENDERIUM_PAXEL.getKey());

        tag(ItemTags.MINING_ENCHANTABLE).add(ModItems.VIBRANIUM_HAMMER.getKey(),
                ModItems.VULPUS_HAMMER.getKey(),
                ModItems.ENDERIUM_HAMMER.getKey(),
                ModItems.VIBRANIUM_EXCAVATOR.getKey(),
                ModItems.VULPUS_EXCAVATOR.getKey(),
                ModItems.ENDERIUM_EXCAVATOR.getKey(),
                ModItems.VIBRANIUM_PICKAXE.getKey(),
                ModItems.VULPUS_PICKAXE.getKey(),
                ModItems.ENDERIUM_PICKAXE.getKey(),
                ModItems.VIBRANIUM_HOE.getKey(),
                ModItems.VULPUS_HOE.getKey(),
                ModItems.ENDERIUM_HOE.getKey(),
                ModItems.VIBRANIUM_AXE.getKey(),
                ModItems.VULPUS_AXE.getKey(),
                ModItems.ENDERIUM_AXE.getKey(),
                ModItems.VIBRANIUM_SHOVEL.getKey(),
                ModItems.VULPUS_SHOVEL.getKey(),
                ModItems.ENDERIUM_SHOVEL.getKey(),
                ModItems.VIBRANIUM_PAXEL.getKey(),
                ModItems.VULPUS_PAXEL.getKey(),
                ModItems.ENDERIUM_PAXEL.getKey());

        tag(ItemTags.FIRE_ASPECT_ENCHANTABLE).add(ModItems.VIBRANIUM_SWORD.getKey(),
                ModItems.VULPUS_SWORD.getKey(),
                ModItems.ENDERIUM_SWORD.getKey());

        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(ModItems.VIBRANIUM_CHESTPLATE.getKey(),
                ModItems.VULPUS_CHESTPLATE.getKey(),
                ModItems.ENDERIUM_CHESTPLATE.getKey());

        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(ModItems.VIBRANIUM_BOOTS.getKey(),
                ModItems.VULPUS_BOOTS.getKey(),
                ModItems.ENDERIUM_BOOTS.getKey());

        tag(ItemTags.LEG_ARMOR_ENCHANTABLE).add(ModItems.VIBRANIUM_LEGGINGS.getKey(),
                ModItems.VULPUS_LEGGINGS.getKey(),
                ModItems.ENDERIUM_LEGGINGS.getKey());

        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(ModItems.VIBRANIUM_HELMET.getKey(),
                ModItems.VULPUS_HELMET.getKey(),
                ModItems.ENDERIUM_HELMET.getKey());

        tag(ItemTags.DURABILITY_ENCHANTABLE).add(ModItems.VIBRANIUM_HELMET.getKey(),
                ModItems.VIBRANIUM_CHESTPLATE.getKey(),
                ModItems.VIBRANIUM_LEGGINGS.getKey(),
                ModItems.VIBRANIUM_BOOTS.getKey(),
                ModItems.VULPUS_HELMET.getKey(),
                ModItems.VULPUS_CHESTPLATE.getKey(),
                ModItems.VULPUS_LEGGINGS.getKey(),
                ModItems.VULPUS_BOOTS.getKey(),
                ModItems.ENDERIUM_HELMET.getKey(),
                ModItems.ENDERIUM_CHESTPLATE.getKey(),
                ModItems.ENDERIUM_LEGGINGS.getKey(),
                ModItems.ENDERIUM_BOOTS.getKey(),
                ModItems.VIBRANIUM_HAMMER.getKey(),
                ModItems.VULPUS_HAMMER.getKey(),
                ModItems.ENDERIUM_HAMMER.getKey(),
                ModItems.VIBRANIUM_EXCAVATOR.getKey(),
                ModItems.VULPUS_EXCAVATOR.getKey(),
                ModItems.ENDERIUM_EXCAVATOR.getKey(),
                ModItems.VIBRANIUM_PICKAXE.getKey(),
                ModItems.VULPUS_PICKAXE.getKey(),
                ModItems.ENDERIUM_PICKAXE.getKey(),
                ModItems.VIBRANIUM_HOE.getKey(),
                ModItems.VULPUS_HOE.getKey(),
                ModItems.ENDERIUM_HOE.getKey(),
                ModItems.VIBRANIUM_AXE.getKey(),
                ModItems.VULPUS_AXE.getKey(),
                ModItems.ENDERIUM_AXE.getKey(),
                ModItems.VIBRANIUM_SHOVEL.getKey(),
                ModItems.VULPUS_SHOVEL.getKey(),
                ModItems.ENDERIUM_SHOVEL.getKey(),
                ModItems.VIBRANIUM_PAXEL.getKey(),
                ModItems.VULPUS_PAXEL.getKey(),
                ModItems.ENDERIUM_PAXEL.getKey(),
                ModItems.VIBRANIUM_SWORD.getKey(),
                ModItems.VULPUS_SWORD.getKey(),
                ModItems.ENDERIUM_SWORD.getKey(),
                ModItems.VIBRANIUM_AXE.getKey(),
                ModItems.VULPUS_AXE.getKey(),
                ModItems.ENDERIUM_AXE.getKey(),
                ModItems.VIBRANIUM_PAXEL.getKey(),
                ModItems.VULPUS_PAXEL.getKey(),
                ModItems.ENDERIUM_PAXEL.getKey(),
                ModItems.VIBRANIUM_BOW.getKey(),
                ModItems.VULPUS_BOW.getKey(),
                ModItems.ENDERIUM_BOW.getKey());

        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).add(ModItems.VIBRANIUM_SWORD.getKey(),
                ModItems.VULPUS_SWORD.getKey(),
                ModItems.ENDERIUM_SWORD.getKey(),
                ModItems.VIBRANIUM_AXE.getKey(),
                ModItems.VULPUS_AXE.getKey(),
                ModItems.ENDERIUM_AXE.getKey(),
                ModItems.VIBRANIUM_PAXEL.getKey(),
                ModItems.VULPUS_PAXEL.getKey(),
                ModItems.ENDERIUM_PAXEL.getKey());

        tag(ItemTags.WEAPON_ENCHANTABLE).add(ModItems.VIBRANIUM_SWORD.getKey(),
                ModItems.VULPUS_SWORD.getKey(),
                ModItems.ENDERIUM_SWORD.getKey(),
                ModItems.VIBRANIUM_AXE.getKey(),
                ModItems.VULPUS_AXE.getKey(),
                ModItems.ENDERIUM_AXE.getKey(),
                ModItems.VIBRANIUM_PAXEL.getKey(),
                ModItems.VULPUS_PAXEL.getKey(),
                ModItems.ENDERIUM_PAXEL.getKey());

        //Materials
        tag(Tags.Items.INGOTS)
                .add(ModItems.VIBRANIUM_INGOT.getKey())
                .add(ModItems.VULPUS_INGOT.getKey())
                .add(ModItems.ENDERIUM_INGOT.getKey());

        tag(Tags.Items.NUGGETS)
                .add(ModItems.VIBRANIUM_NUGGET.getKey(),
                        ModItems.VULPUS_NUGGET.getKey(),
                        ModItems.ENDERIUM_NUGGET.getKey());

        tag(Tags.Items.RAW_MATERIALS)
                .add(ModItems.RAW_VIBRANIUM.getKey(),
                        ModItems.RAW_VULPUS.getKey(),
                        ModItems.RAW_ENDERIUM.getKey());

        //Mining / Harvesting
        tag(ItemTags.BREAKS_DECORATED_POTS).add(ModItems.VIBRANIUM_HAMMER.getKey(),
                ModItems.VULPUS_HAMMER.getKey(),
                ModItems.ENDERIUM_HAMMER.getKey(),
                ModItems.VIBRANIUM_EXCAVATOR.getKey(),
                ModItems.VULPUS_EXCAVATOR.getKey(),
                ModItems.ENDERIUM_EXCAVATOR.getKey(),
                ModItems.VIBRANIUM_PICKAXE.getKey(),
                ModItems.VULPUS_PICKAXE.getKey(),
                ModItems.ENDERIUM_PICKAXE.getKey(),
                ModItems.VIBRANIUM_HOE.getKey(),
                ModItems.VULPUS_HOE.getKey(),
                ModItems.ENDERIUM_HOE.getKey(),
                ModItems.VIBRANIUM_AXE.getKey(),
                ModItems.VULPUS_AXE.getKey(),
                ModItems.ENDERIUM_AXE.getKey(),
                ModItems.VIBRANIUM_SHOVEL.getKey(),
                ModItems.VULPUS_SHOVEL.getKey(),
                ModItems.ENDERIUM_SHOVEL.getKey(),
                ModItems.VIBRANIUM_PAXEL.getKey(),
                ModItems.VULPUS_PAXEL.getKey(),
                ModItems.ENDERIUM_PAXEL.getKey());

        tag(ItemTags.CLUSTER_MAX_HARVESTABLES).add(ModItems.VIBRANIUM_HAMMER.getKey(),
                ModItems.VULPUS_HAMMER.getKey(),
                ModItems.ENDERIUM_HAMMER.getKey(),
                ModItems.VIBRANIUM_PICKAXE.getKey(),
                ModItems.VULPUS_PICKAXE.getKey(),
                ModItems.ENDERIUM_PICKAXE.getKey(),
                ModItems.VIBRANIUM_PAXEL.getKey(),
                ModItems.VULPUS_PAXEL.getKey(),
                ModItems.ENDERIUM_PAXEL.getKey());
    }
}