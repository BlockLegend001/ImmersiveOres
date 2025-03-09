package com.blocklegend001.immersiveores.util;

import com.blocklegend001.immersiveores.ImmersiveOres;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_ENDERIUM_TOOL
                = createTag("needs_enderium_tool");

        public static final TagKey<Block> NEEDS_VIBRANIUM_TOOL
                = createTag("needs_vibranium_tool");

        public static final TagKey<Block> NEEDS_VULPUS_TOOL
                = createTag("needs_vulpus_tool");

        public static final TagKey<Block> ENDERIUM_PAXEL_MINEABLE =
                createTag("mineable/enderium_paxel");

        public static final TagKey<Block> VIBRANIUM_PAXEL_MINEABLE =
                createTag("mineable/vibranium_paxel");

        public static final TagKey<Block> VULPUS_PAXEL_MINEABLE =
                createTag("mineable/vulpus_paxel");

        public static final TagKey<Block> BEACON_BASE_BLOCKS =
                createTag("beacon_base_blocks");

        public static final TagKey<Block> INCORRECT_FOR_VIBRANIUM_TOOL = createTag("incorrect_for_vibranium_tool");

        public static final TagKey<Block> INCORRECT_FOR_VULPUS_TOOL = createTag("incorrect_for_vulpus_tool");

        public static final TagKey<Block> INCORRECT_FOR_ENDERIUM_TOOL = createTag("incorrect_for_enderium_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(ImmersiveOres.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> VIBRANIUM_BOW = createTag("vibranium_bow");
        public static final TagKey<Item> VULPUS_BOW = createTag("vulpus_bow");
        public static final TagKey<Item> ENDERIUM_BOW = createTag("enderium_bow");

        public static final TagKey<Item> VIBRANIUM_HAMMER = createTag("vibranium_hammer");
        public static final TagKey<Item> VULPUS_HAMMER = createTag("vulpus_hammer");
        public static final TagKey<Item> ENDERIUM_HAMMER = createTag("enderium_hammer");

        public static final TagKey<Item> ENDERIUM_EXCAVATOR = createTag("enderium_excavator");
        public static final TagKey<Item> VIBRANIUM_EXCAVATOR = createTag("vibranium_excavator");
        public static final TagKey<Item> VULPUS_EXCAVATOR = createTag("vulpus_excavator");

        public static final TagKey<Item> VIBRANIUM_PICKAXE = createTag("vibranium_pickaxe");
        public static final TagKey<Item> VULPUS_PICKAXE = createTag("vulpus_pickaxe");
        public static final TagKey<Item> ENDERIUM_PICKAXE = createTag("enderium_pickaxe");

        public static final TagKey<Item> VIBRANIUM_HOE = createTag("vibranium_hoe");
        public static final TagKey<Item> VULPUS_HOE = createTag("vulpus_hoe");
        public static final TagKey<Item> ENDERIUM_HOE = createTag("enderium_hoe");

        public static final TagKey<Item> VIBRANIUM_AXE = createTag("vibranium_axe");
        public static final TagKey<Item> VULPUS_AXE = createTag("vulpus_axe");
        public static final TagKey<Item> ENDERIUM_AXE = createTag("enderium_axe");

        public static final TagKey<Item> VIBRANIUM_PAXEL = createTag("vibranium_paxel");
        public static final TagKey<Item> VULPUS_PAXEL = createTag("vulpus_paxel");
        public static final TagKey<Item> ENDERIUM_PAXEL = createTag("enderium_paxel");

        public static final TagKey<Item> VIBRANIUM_SHOVEL = createTag("vibranium_shovel");
        public static final TagKey<Item> VULPUS_SHOVEL = createTag("vulpus_shovel");
        public static final TagKey<Item> ENDERIUM_SHOVEL = createTag("enderium_shovel");

        public static final TagKey<Item> VIBRANIUM_SWORD = createTag("vibranium_sword");
        public static final TagKey<Item> VULPUS_SWORD = createTag("vulpus_sword");
        public static final TagKey<Item> ENDERIUM_SWORD = createTag("enderium_sword");

        public static final TagKey<Item> VIBRANIUM_ARMOR = createTag("vibranium_armor");
        public static final TagKey<Item> VULPUS_ARMOR = createTag("vulpus_armor");
        public static final TagKey<Item> ENDERIUM_ARMOR = createTag("enderium_armor");

        public static final TagKey<Item> VIBRANIUM_REPAIRS = createTag("vibranium_repairs");
        public static final TagKey<Item> VULPUS_REPAIRS = createTag("vulpus_repairs");
        public static final TagKey<Item> ENDERIUM_REPAIRS = createTag("enderium_repairs");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, name));
        }
    }
}
