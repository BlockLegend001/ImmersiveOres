package com.blocklegend001.immersiveores.util.map;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.world.item.Item;

import java.util.Map;

public class ArrowCountMap {
    public static Map<Item, Integer> vibraniumBowArrowCount = null;
    public static Map<Item, Integer> vulpusBowArrowCount = null;
    public static Map<Item, Integer> enderiumBowArrowCount = null;


    public static Map<Item, Integer> getVibraniumBowArrowCount() {
        if (vibraniumBowArrowCount == null) {
            vibraniumBowArrowCount = Map.of(
                    ModItems.VIBRANIUM_BOW.get(), VibraniumConfig.arrowCountVibraniumBow.get()
            );
        }
        return vibraniumBowArrowCount;
    }

    public static Map<Item, Integer> getVulpusBowArrowCount() {
        if (vulpusBowArrowCount == null) {
            vulpusBowArrowCount = Map.of(
                    ModItems.VULPUS_BOW.get(), VulpusConfig.arrowCountVulpusBow.get()
            );
        }
        return vulpusBowArrowCount;
    }

    public static Map<Item, Integer> getEnderiumBowArrowCount() {
        if (enderiumBowArrowCount == null) {
            enderiumBowArrowCount = Map.of(
                    ModItems.ENDERIUM_BOW.get(), EnderiumConfig.arrowCountEnderiumBow.get()
            );
        }
        return enderiumBowArrowCount;
    }
}
