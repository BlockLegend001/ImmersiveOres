package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.item.ModItems;
import com.blocklegend001.immersiveores.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.VanillaItemTagsProvider;
import net.minecraft.references.ItemIds;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends VanillaItemTagsProvider {
    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(packOutput, completableFuture);
    }

    private static ResourceKey<Item> key(DeferredItem<?> item) {
        return item.unwrapKey().orElseThrow();
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //Armor
        tag(ItemTags.CHEST_ARMOR).add(key(ModItems.VIBRANIUM_CHESTPLATE),
                key(ModItems.VULPUS_CHESTPLATE),
                key(ModItems.ENDERIUM_CHESTPLATE));

        tag(ItemTags.FOOT_ARMOR).add(key(ModItems.VIBRANIUM_BOOTS),
                key(ModItems.VULPUS_BOOTS),
                key(ModItems.ENDERIUM_BOOTS));

        tag(ItemTags.LEG_ARMOR).add(key(ModItems.VIBRANIUM_LEGGINGS),
                key(ModItems.VULPUS_LEGGINGS),
                key(ModItems.ENDERIUM_LEGGINGS));

        tag(ItemTags.HEAD_ARMOR).add(key(ModItems.VIBRANIUM_HELMET),
                key(ModItems.VULPUS_HELMET),
                key(ModItems.ENDERIUM_HELMET));

        this.tag(ItemTags.TRIMMABLE_ARMOR).add(
                key(ModItems.VIBRANIUM_HELMET),
                key(ModItems.VIBRANIUM_CHESTPLATE),
                key(ModItems.VIBRANIUM_LEGGINGS),
                key(ModItems.VIBRANIUM_BOOTS),
                key(ModItems.VULPUS_HELMET),
                key(ModItems.VULPUS_CHESTPLATE),
                key(ModItems.VULPUS_LEGGINGS),
                key(ModItems.VULPUS_BOOTS),
                key(ModItems.ENDERIUM_HELMET),
                key(ModItems.ENDERIUM_CHESTPLATE),
                key(ModItems.ENDERIUM_LEGGINGS),
                key(ModItems.ENDERIUM_BOOTS));

        tag(ModTags.Items.VIBRANIUM_ARMOR).add(key(ModItems.VIBRANIUM_HELMET),
                key(ModItems.VIBRANIUM_CHESTPLATE),
                key(ModItems.VIBRANIUM_LEGGINGS),
                key(ModItems.VIBRANIUM_BOOTS));

        tag(ModTags.Items.VULPUS_ARMOR).add(key(ModItems.VULPUS_HELMET),
                key(ModItems.VULPUS_CHESTPLATE),
                key(ModItems.VULPUS_LEGGINGS),
                key(ModItems.VULPUS_BOOTS));

        tag(ModTags.Items.ENDERIUM_ARMOR).add(key(ModItems.ENDERIUM_HELMET),
                key(ModItems.ENDERIUM_CHESTPLATE),
                key(ModItems.ENDERIUM_LEGGINGS),
                key(ModItems.ENDERIUM_BOOTS));

        tag(Tags.Items.ARMORS).add(key(ModItems.VIBRANIUM_HELMET),
                key(ModItems.VIBRANIUM_CHESTPLATE),
                key(ModItems.VIBRANIUM_LEGGINGS),
                key(ModItems.VIBRANIUM_BOOTS),
                key(ModItems.VULPUS_HELMET),
                key(ModItems.VULPUS_CHESTPLATE),
                key(ModItems.VULPUS_LEGGINGS),
                key(ModItems.VULPUS_BOOTS),
                key(ModItems.ENDERIUM_HELMET),
                key(ModItems.ENDERIUM_CHESTPLATE),
                key(ModItems.ENDERIUM_LEGGINGS),
                key(ModItems.ENDERIUM_BOOTS));

        //Tools, Sword, Bows ...
        tag(ModTags.Items.VIBRANIUM_BOW).add(key(ModItems.VIBRANIUM_BOW));
        tag(ModTags.Items.VULPUS_BOW).add(key(ModItems.VULPUS_BOW));
        tag(ModTags.Items.ENDERIUM_BOW).add(key(ModItems.ENDERIUM_BOW));

        tag(ModTags.Items.VIBRANIUM_HAMMER).add(key(ModItems.VIBRANIUM_HAMMER));
        tag(ModTags.Items.VULPUS_HAMMER).add(key(ModItems.VULPUS_HAMMER));
        tag(ModTags.Items.ENDERIUM_HAMMER).add(key(ModItems.ENDERIUM_HAMMER));

        tag(ModTags.Items.VIBRANIUM_EXCAVATOR).add(key(ModItems.VIBRANIUM_EXCAVATOR));
        tag(ModTags.Items.VULPUS_EXCAVATOR).add(key(ModItems.VULPUS_EXCAVATOR));
        tag(ModTags.Items.ENDERIUM_EXCAVATOR).add(key(ModItems.ENDERIUM_EXCAVATOR));

        tag(ModTags.Items.VIBRANIUM_PICKAXE).add(key(ModItems.VIBRANIUM_PICKAXE));
        tag(ModTags.Items.VULPUS_PICKAXE).add(key(ModItems.VULPUS_PICKAXE));
        tag(ModTags.Items.ENDERIUM_PICKAXE).add(key(ModItems.ENDERIUM_PICKAXE));

        tag(ModTags.Items.VIBRANIUM_HOE).add(key(ModItems.VIBRANIUM_HOE));
        tag(ModTags.Items.VULPUS_HOE).add(key(ModItems.VULPUS_HOE));
        tag(ModTags.Items.ENDERIUM_HOE).add(key(ModItems.ENDERIUM_HOE));

        tag(ModTags.Items.VIBRANIUM_AXE).add(key(ModItems.VIBRANIUM_AXE));
        tag(ModTags.Items.VULPUS_AXE).add(key(ModItems.VULPUS_AXE));
        tag(ModTags.Items.ENDERIUM_AXE).add(key(ModItems.ENDERIUM_AXE));

        tag(ModTags.Items.VIBRANIUM_SHOVEL).add(key(ModItems.VIBRANIUM_SHOVEL));
        tag(ModTags.Items.VULPUS_SHOVEL).add(key(ModItems.VULPUS_SHOVEL));
        tag(ModTags.Items.ENDERIUM_SHOVEL).add(key(ModItems.ENDERIUM_SHOVEL));

        tag(ModTags.Items.VIBRANIUM_PAXEL).add(key(ModItems.VIBRANIUM_PAXEL));
        tag(ModTags.Items.VULPUS_PAXEL).add(key(ModItems.VULPUS_PAXEL));
        tag(ModTags.Items.ENDERIUM_PAXEL).add(key(ModItems.ENDERIUM_PAXEL));

        tag(ModTags.Items.VIBRANIUM_SWORD).add(key(ModItems.VIBRANIUM_SWORD));
        tag(ModTags.Items.VULPUS_SWORD).add(key(ModItems.VULPUS_SWORD));
        tag(ModTags.Items.ENDERIUM_SWORD).add(key(ModItems.ENDERIUM_SWORD));

        tag(ModTags.Items.TOOLS_NETHERITE)
                .add(ItemIds.NETHERITE_PICKAXE);

        tag(ItemTags.PICKAXES).add(key(ModItems.VIBRANIUM_PICKAXE),
                key(ModItems.VULPUS_PICKAXE),
                key(ModItems.ENDERIUM_PICKAXE),
                key(ModItems.VIBRANIUM_PAXEL),
                key(ModItems.VULPUS_PAXEL),
                key(ModItems.ENDERIUM_PAXEL));

        tag(ItemTags.SHOVELS).add(key(ModItems.VIBRANIUM_SHOVEL),
                key(ModItems.VULPUS_SHOVEL),
                key(ModItems.ENDERIUM_SHOVEL),
                key(ModItems.VIBRANIUM_PAXEL),
                key(ModItems.VULPUS_PAXEL),
                key(ModItems.ENDERIUM_PAXEL));

        tag(ItemTags.AXES).add(key(ModItems.VIBRANIUM_AXE),
                key(ModItems.VULPUS_AXE),
                key(ModItems.ENDERIUM_AXE),
                key(ModItems.VIBRANIUM_PAXEL),
                key(ModItems.VULPUS_PAXEL),
                key(ModItems.ENDERIUM_PAXEL));

        tag(ItemTags.HOES).add(key(ModItems.VIBRANIUM_HOE),
                key(ModItems.VULPUS_HOE),
                key(ModItems.ENDERIUM_HOE));

        tag(ItemTags.SWORDS).add(key(ModItems.VIBRANIUM_SWORD),
                key(ModItems.VULPUS_SWORD),
                key(ModItems.ENDERIUM_SWORD));

        tag(Tags.Items.TOOLS_BOW).add(key(ModItems.VIBRANIUM_BOW),
                key(ModItems.VULPUS_BOW),
                key(ModItems.ENDERIUM_BOW));

        tag(Tags.Items.RANGED_WEAPON_TOOLS).add(key(ModItems.VIBRANIUM_BOW),
                key(ModItems.VULPUS_BOW),
                key(ModItems.ENDERIUM_BOW));

        tag(Tags.Items.TOOLS).add(key(ModItems.VIBRANIUM_HAMMER),
                key(ModItems.VULPUS_HAMMER),
                key(ModItems.ENDERIUM_HAMMER),
                key(ModItems.VIBRANIUM_EXCAVATOR),
                key(ModItems.VULPUS_EXCAVATOR),
                key(ModItems.ENDERIUM_EXCAVATOR),
                key(ModItems.VIBRANIUM_PICKAXE),
                key(ModItems.VULPUS_PICKAXE),
                key(ModItems.ENDERIUM_PICKAXE),
                key(ModItems.VIBRANIUM_HOE),
                key(ModItems.VULPUS_HOE),
                key(ModItems.ENDERIUM_HOE),
                key(ModItems.VIBRANIUM_AXE),
                key(ModItems.VULPUS_AXE),
                key(ModItems.ENDERIUM_AXE),
                key(ModItems.VIBRANIUM_SHOVEL),
                key(ModItems.VULPUS_SHOVEL),
                key(ModItems.ENDERIUM_SHOVEL),
                key(ModItems.VIBRANIUM_PAXEL),
                key(ModItems.VULPUS_PAXEL),
                key(ModItems.ENDERIUM_PAXEL));

        tag(Tags.Items.MINING_TOOL_TOOLS).add(key(ModItems.VIBRANIUM_HAMMER),
                key(ModItems.VULPUS_HAMMER),
                key(ModItems.ENDERIUM_HAMMER),
                key(ModItems.VIBRANIUM_EXCAVATOR),
                key(ModItems.VULPUS_EXCAVATOR),
                key(ModItems.ENDERIUM_EXCAVATOR),
                key(ModItems.VIBRANIUM_PICKAXE),
                key(ModItems.VULPUS_PICKAXE),
                key(ModItems.ENDERIUM_PICKAXE),
                key(ModItems.VIBRANIUM_HOE),
                key(ModItems.VULPUS_HOE),
                key(ModItems.ENDERIUM_HOE),
                key(ModItems.VIBRANIUM_AXE),
                key(ModItems.VULPUS_AXE),
                key(ModItems.ENDERIUM_AXE),
                key(ModItems.VIBRANIUM_SHOVEL),
                key(ModItems.VULPUS_SHOVEL),
                key(ModItems.ENDERIUM_SHOVEL),
                key(ModItems.VIBRANIUM_PAXEL),
                key(ModItems.VULPUS_PAXEL),
                key(ModItems.ENDERIUM_PAXEL));

        tag(Tags.Items.MELEE_WEAPON_TOOLS).add(key(ModItems.VIBRANIUM_SWORD),
                key(ModItems.VULPUS_SWORD),
                key(ModItems.ENDERIUM_SWORD),
                key(ModItems.VIBRANIUM_AXE),
                key(ModItems.VULPUS_AXE),
                key(ModItems.ENDERIUM_AXE),
                key(ModItems.VIBRANIUM_PAXEL),
                key(ModItems.VULPUS_PAXEL),
                key(ModItems.ENDERIUM_PAXEL));

        //Enchantments
        tag(ItemTags.BOW_ENCHANTABLE).add(key(ModItems.VIBRANIUM_BOW),
                key(ModItems.VULPUS_BOW),
                key(ModItems.ENDERIUM_BOW));

        tag(ItemTags.ARMOR_ENCHANTABLE).add(key(ModItems.VIBRANIUM_HELMET),
                key(ModItems.VIBRANIUM_CHESTPLATE),
                key(ModItems.VIBRANIUM_LEGGINGS),
                key(ModItems.VIBRANIUM_BOOTS),
                key(ModItems.VULPUS_HELMET),
                key(ModItems.VULPUS_CHESTPLATE),
                key(ModItems.VULPUS_LEGGINGS),
                key(ModItems.VULPUS_BOOTS),
                key(ModItems.ENDERIUM_HELMET),
                key(ModItems.ENDERIUM_CHESTPLATE),
                key(ModItems.ENDERIUM_LEGGINGS),
                key(ModItems.ENDERIUM_BOOTS));

        tag(ItemTags.MINING_LOOT_ENCHANTABLE).add(key(ModItems.VIBRANIUM_HAMMER),
                key(ModItems.VULPUS_HAMMER),
                key(ModItems.ENDERIUM_HAMMER),
                key(ModItems.VIBRANIUM_EXCAVATOR),
                key(ModItems.VULPUS_EXCAVATOR),
                key(ModItems.ENDERIUM_EXCAVATOR),
                key(ModItems.VIBRANIUM_PICKAXE),
                key(ModItems.VULPUS_PICKAXE),
                key(ModItems.ENDERIUM_PICKAXE),
                key(ModItems.VIBRANIUM_HOE),
                key(ModItems.VULPUS_HOE),
                key(ModItems.ENDERIUM_HOE),
                key(ModItems.VIBRANIUM_AXE),
                key(ModItems.VULPUS_AXE),
                key(ModItems.ENDERIUM_AXE),
                key(ModItems.VIBRANIUM_SHOVEL),
                key(ModItems.VULPUS_SHOVEL),
                key(ModItems.ENDERIUM_SHOVEL),
                key(ModItems.VIBRANIUM_PAXEL),
                key(ModItems.VULPUS_PAXEL),
                key(ModItems.ENDERIUM_PAXEL));

        tag(ItemTags.VANISHING_ENCHANTABLE).add(key(ModItems.VIBRANIUM_HELMET),
                key(ModItems.VIBRANIUM_CHESTPLATE),
                key(ModItems.VIBRANIUM_LEGGINGS),
                key(ModItems.VIBRANIUM_BOOTS),
                key(ModItems.VULPUS_HELMET),
                key(ModItems.VULPUS_CHESTPLATE),
                key(ModItems.VULPUS_LEGGINGS),
                key(ModItems.VULPUS_BOOTS),
                key(ModItems.ENDERIUM_HELMET),
                key(ModItems.ENDERIUM_CHESTPLATE),
                key(ModItems.ENDERIUM_LEGGINGS),
                key(ModItems.ENDERIUM_BOOTS),
                key(ModItems.VIBRANIUM_HAMMER),
                key(ModItems.VULPUS_HAMMER),
                key(ModItems.ENDERIUM_HAMMER),
                key(ModItems.VIBRANIUM_EXCAVATOR),
                key(ModItems.VULPUS_EXCAVATOR),
                key(ModItems.ENDERIUM_EXCAVATOR),
                key(ModItems.VIBRANIUM_PICKAXE),
                key(ModItems.VULPUS_PICKAXE),
                key(ModItems.ENDERIUM_PICKAXE),
                key(ModItems.VIBRANIUM_HOE),
                key(ModItems.VULPUS_HOE),
                key(ModItems.ENDERIUM_HOE),
                key(ModItems.VIBRANIUM_AXE),
                key(ModItems.VULPUS_AXE),
                key(ModItems.ENDERIUM_AXE),
                key(ModItems.VIBRANIUM_SHOVEL),
                key(ModItems.VULPUS_SHOVEL),
                key(ModItems.ENDERIUM_SHOVEL),
                key(ModItems.VIBRANIUM_PAXEL),
                key(ModItems.VULPUS_PAXEL),
                key(ModItems.ENDERIUM_PAXEL),
                key(ModItems.VIBRANIUM_SWORD),
                key(ModItems.VULPUS_SWORD),
                key(ModItems.ENDERIUM_SWORD),
                key(ModItems.VIBRANIUM_AXE),
                key(ModItems.VULPUS_AXE),
                key(ModItems.ENDERIUM_AXE),
                key(ModItems.VIBRANIUM_PAXEL),
                key(ModItems.VULPUS_PAXEL),
                key(ModItems.ENDERIUM_PAXEL));

        tag(ItemTags.MINING_ENCHANTABLE).add(key(ModItems.VIBRANIUM_HAMMER),
                key(ModItems.VULPUS_HAMMER),
                key(ModItems.ENDERIUM_HAMMER),
                key(ModItems.VIBRANIUM_EXCAVATOR),
                key(ModItems.VULPUS_EXCAVATOR),
                key(ModItems.ENDERIUM_EXCAVATOR),
                key(ModItems.VIBRANIUM_PICKAXE),
                key(ModItems.VULPUS_PICKAXE),
                key(ModItems.ENDERIUM_PICKAXE),
                key(ModItems.VIBRANIUM_HOE),
                key(ModItems.VULPUS_HOE),
                key(ModItems.ENDERIUM_HOE),
                key(ModItems.VIBRANIUM_AXE),
                key(ModItems.VULPUS_AXE),
                key(ModItems.ENDERIUM_AXE),
                key(ModItems.VIBRANIUM_SHOVEL),
                key(ModItems.VULPUS_SHOVEL),
                key(ModItems.ENDERIUM_SHOVEL),
                key(ModItems.VIBRANIUM_PAXEL),
                key(ModItems.VULPUS_PAXEL),
                key(ModItems.ENDERIUM_PAXEL));

        tag(ItemTags.FIRE_ASPECT_ENCHANTABLE).add(key(ModItems.VIBRANIUM_SWORD),
                key(ModItems.VULPUS_SWORD),
                key(ModItems.ENDERIUM_SWORD));

        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(key(ModItems.VIBRANIUM_CHESTPLATE),
                key(ModItems.VULPUS_CHESTPLATE),
                key(ModItems.ENDERIUM_CHESTPLATE));

        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(key(ModItems.VIBRANIUM_BOOTS),
                key(ModItems.VULPUS_BOOTS),
                key(ModItems.ENDERIUM_BOOTS));

        tag(ItemTags.LEG_ARMOR_ENCHANTABLE).add(key(ModItems.VIBRANIUM_LEGGINGS),
                key(ModItems.VULPUS_LEGGINGS),
                key(ModItems.ENDERIUM_LEGGINGS));

        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(key(ModItems.VIBRANIUM_HELMET),
                key(ModItems.VULPUS_HELMET),
                key(ModItems.ENDERIUM_HELMET));

        tag(ItemTags.DURABILITY_ENCHANTABLE).add(key(ModItems.VIBRANIUM_HELMET),
                key(ModItems.VIBRANIUM_CHESTPLATE),
                key(ModItems.VIBRANIUM_LEGGINGS),
                key(ModItems.VIBRANIUM_BOOTS),
                key(ModItems.VULPUS_HELMET),
                key(ModItems.VULPUS_CHESTPLATE),
                key(ModItems.VULPUS_LEGGINGS),
                key(ModItems.VULPUS_BOOTS),
                key(ModItems.ENDERIUM_HELMET),
                key(ModItems.ENDERIUM_CHESTPLATE),
                key(ModItems.ENDERIUM_LEGGINGS),
                key(ModItems.ENDERIUM_BOOTS),
                key(ModItems.VIBRANIUM_HAMMER),
                key(ModItems.VULPUS_HAMMER),
                key(ModItems.ENDERIUM_HAMMER),
                key(ModItems.VIBRANIUM_EXCAVATOR),
                key(ModItems.VULPUS_EXCAVATOR),
                key(ModItems.ENDERIUM_EXCAVATOR),
                key(ModItems.VIBRANIUM_PICKAXE),
                key(ModItems.VULPUS_PICKAXE),
                key(ModItems.ENDERIUM_PICKAXE),
                key(ModItems.VIBRANIUM_HOE),
                key(ModItems.VULPUS_HOE),
                key(ModItems.ENDERIUM_HOE),
                key(ModItems.VIBRANIUM_AXE),
                key(ModItems.VULPUS_AXE),
                key(ModItems.ENDERIUM_AXE),
                key(ModItems.VIBRANIUM_SHOVEL),
                key(ModItems.VULPUS_SHOVEL),
                key(ModItems.ENDERIUM_SHOVEL),
                key(ModItems.VIBRANIUM_PAXEL),
                key(ModItems.VULPUS_PAXEL),
                key(ModItems.ENDERIUM_PAXEL),
                key(ModItems.VIBRANIUM_SWORD),
                key(ModItems.VULPUS_SWORD),
                key(ModItems.ENDERIUM_SWORD),
                key(ModItems.VIBRANIUM_AXE),
                key(ModItems.VULPUS_AXE),
                key(ModItems.ENDERIUM_AXE),
                key(ModItems.VIBRANIUM_PAXEL),
                key(ModItems.VULPUS_PAXEL),
                key(ModItems.ENDERIUM_PAXEL),
                key(ModItems.VIBRANIUM_BOW),
                key(ModItems.VULPUS_BOW),
                key(ModItems.ENDERIUM_BOW));

        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).add(key(ModItems.VIBRANIUM_SWORD),
                key(ModItems.VULPUS_SWORD),
                key(ModItems.ENDERIUM_SWORD),
                key(ModItems.VIBRANIUM_AXE),
                key(ModItems.VULPUS_AXE),
                key(ModItems.ENDERIUM_AXE),
                key(ModItems.VIBRANIUM_PAXEL),
                key(ModItems.VULPUS_PAXEL),
                key(ModItems.ENDERIUM_PAXEL));

        tag(ItemTags.WEAPON_ENCHANTABLE).add(key(ModItems.VIBRANIUM_SWORD),
                key(ModItems.VULPUS_SWORD),
                key(ModItems.ENDERIUM_SWORD),
                key(ModItems.VIBRANIUM_AXE),
                key(ModItems.VULPUS_AXE),
                key(ModItems.ENDERIUM_AXE),
                key(ModItems.VIBRANIUM_PAXEL),
                key(ModItems.VULPUS_PAXEL),
                key(ModItems.ENDERIUM_PAXEL));

        //Materials
        tag(Tags.Items.INGOTS)
                .add(key(ModItems.VIBRANIUM_INGOT))
                .add(key(ModItems.VULPUS_INGOT))
                .add(key(ModItems.ENDERIUM_INGOT));

        tag(Tags.Items.NUGGETS)
                .add(key(ModItems.VIBRANIUM_NUGGET),
                        key(ModItems.VULPUS_NUGGET),
                        key(ModItems.ENDERIUM_NUGGET));

        tag(Tags.Items.RAW_MATERIALS)
                .add(key(ModItems.RAW_VIBRANIUM),
                        key(ModItems.RAW_VULPUS),
                        key(ModItems.RAW_ENDERIUM));

        //Mining / Harvesting
        tag(ItemTags.BREAKS_DECORATED_POTS).add(key(ModItems.VIBRANIUM_HAMMER),
                key(ModItems.VULPUS_HAMMER),
                key(ModItems.ENDERIUM_HAMMER),
                key(ModItems.VIBRANIUM_EXCAVATOR),
                key(ModItems.VULPUS_EXCAVATOR),
                key(ModItems.ENDERIUM_EXCAVATOR),
                key(ModItems.VIBRANIUM_PICKAXE),
                key(ModItems.VULPUS_PICKAXE),
                key(ModItems.ENDERIUM_PICKAXE),
                key(ModItems.VIBRANIUM_HOE),
                key(ModItems.VULPUS_HOE),
                key(ModItems.ENDERIUM_HOE),
                key(ModItems.VIBRANIUM_AXE),
                key(ModItems.VULPUS_AXE),
                key(ModItems.ENDERIUM_AXE),
                key(ModItems.VIBRANIUM_SHOVEL),
                key(ModItems.VULPUS_SHOVEL),
                key(ModItems.ENDERIUM_SHOVEL),
                key(ModItems.VIBRANIUM_PAXEL),
                key(ModItems.VULPUS_PAXEL),
                key(ModItems.ENDERIUM_PAXEL));

        tag(ItemTags.CLUSTER_MAX_HARVESTABLES).add(key(ModItems.VIBRANIUM_HAMMER),
                key(ModItems.VULPUS_HAMMER),
                key(ModItems.ENDERIUM_HAMMER),
                key(ModItems.VIBRANIUM_PICKAXE),
                key(ModItems.VULPUS_PICKAXE),
                key(ModItems.ENDERIUM_PICKAXE),
                key(ModItems.VIBRANIUM_PAXEL),
                key(ModItems.VULPUS_PAXEL),
                key(ModItems.ENDERIUM_PAXEL));
    }
}