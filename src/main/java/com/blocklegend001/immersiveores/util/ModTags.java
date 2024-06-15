package com.blocklegend001.immersiveores.util;

import com.blocklegend001.immersiveores.ImmersiveOres;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
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

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(ImmersiveOres.MODID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }
}
