package com.blocklegend001.immersiveores.util;

import com.blocklegend001.immersiveores.ImmersiveOres;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_ENDERIUM_TOOL
                = tag("needs_enderium_tool");

        public static final TagKey<Block> NEEDS_VIBRANIUM_TOOL
                = tag("needs_vibranium_tool");

        public static final TagKey<Block> NEEDS_VULPUS_TOOL
                = tag("needs_vulpus_tool");

        public static final TagKey<Block> ENDERIUM_PAXEL_MINEABLE =
                tag("mineable/enderium_paxel");

        public static final TagKey<Block> VIBRANIUM_PAXEL_MINEABLE =
                tag("mineable/vibranium_paxel");

        public static final TagKey<Block> VULPUS_PAXEL_MINEABLE =
                tag("mineable/vulpus_paxel");

        public static final TagKey<Block> BEACON_BASE_BLOCKS =
                tag("beacon_base_blocks");

        public static final TagKey<Block> INCORRECT_FOR_VIBRANIUM_TOOL = tag("incorrect_for_vibranium_tool");

        public static final TagKey<Block> INCORRECT_FOR_VULPUS_TOOL = tag("incorrect_for_vulpus_tool");

        public static final TagKey<Block> INCORRECT_FOR_ENDERIUM_TOOL = tag("incorrect_for_enderium_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> VIBRANIUM_BOW = tag("vibranium_bow");
        public static final TagKey<Item> VULPUS_BOW = tag("vulpus_bow");
        public static final TagKey<Item> ENDERIUM_BOW = tag("enderium_bow");

        public static final TagKey<Item> VIBRANIUM_HAMMER = tag("vibranium_hammer");
        public static final TagKey<Item> VULPUS_HAMMER = tag("vulpus_hammer");
        public static final TagKey<Item> ENDERIUM_HAMMER = tag("enderium_hammer");

        public static final TagKey<Item> ENDERIUM_EXCAVATOR = tag("enderium_excavator");
        public static final TagKey<Item> VIBRANIUM_EXCAVATOR = tag("vibranium_excavator");
        public static final TagKey<Item> VULPUS_EXCAVATOR = tag("vulpus_excavator");

        public static final TagKey<Item> VIBRANIUM_PICKAXE = tag("vibranium_pickaxe");
        public static final TagKey<Item> VULPUS_PICKAXE = tag("vulpus_pickaxe");
        public static final TagKey<Item> ENDERIUM_PICKAXE = tag("enderium_pickaxe");

        public static final TagKey<Item> VIBRANIUM_HOE = tag("vibranium_hoe");
        public static final TagKey<Item> VULPUS_HOE = tag("vulpus_hoe");
        public static final TagKey<Item> ENDERIUM_HOE = tag("enderium_hoe");

        public static final TagKey<Item> VIBRANIUM_AXE = tag("vibranium_axe");
        public static final TagKey<Item> VULPUS_AXE = tag("vulpus_axe");
        public static final TagKey<Item> ENDERIUM_AXE = tag("enderium_axe");

        public static final TagKey<Item> VIBRANIUM_PAXEL = tag("vibranium_paxel");
        public static final TagKey<Item> VULPUS_PAXEL = tag("vulpus_paxel");
        public static final TagKey<Item> ENDERIUM_PAXEL = tag("enderium_paxel");

        public static final TagKey<Item> VIBRANIUM_SHOVEL = tag("vibranium_shovel");
        public static final TagKey<Item> VULPUS_SHOVEL = tag("vulpus_shovel");
        public static final TagKey<Item> ENDERIUM_SHOVEL = tag("enderium_shovel");

        public static final TagKey<Item> VIBRANIUM_SWORD = tag("vibranium_sword");
        public static final TagKey<Item> VULPUS_SWORD = tag("vulpus_sword");
        public static final TagKey<Item> ENDERIUM_SWORD = tag("enderium_sword");

        public static final TagKey<Item> VIBRANIUM_ARMOR = tag("vibranium_armor");
        public static final TagKey<Item> VULPUS_ARMOR = tag("vulpus_armor");
        public static final TagKey<Item> ENDERIUM_ARMOR = tag("enderium_armor");

        private static TagKey<Item> tag(String name) {
            return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, name));
        }
    }
}
