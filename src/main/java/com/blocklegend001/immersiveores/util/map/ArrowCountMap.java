package com.blocklegend001.immersiveores.util.map;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.world.item.Item;

import java.util.Map;

public class ArrowCountMap {
    public static final Map<Item, Integer> VIBRANIUM_BOW_ARROW_COUNT = Map.of(
            ModItems.VIBRANIUM_BOW, VibraniumConfig.arrowCountVibraniumBow
    );

    public static final Map<Item, Integer> VULPUS_BOW_ARROW_COUNT = Map.of(
            ModItems.VULPUS_BOW, VulpusConfig.arrowCountVulpusBow
    );

    public static final Map<Item, Integer> ENDERIUM_BOW_ARROW_COUNT = Map.of(
            ModItems.ENDERIUM_BOW, EnderiumConfig.arrowCountEnderiumBow
    );
}
