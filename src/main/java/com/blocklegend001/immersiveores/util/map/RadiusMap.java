package com.blocklegend001.immersiveores.util.map;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.world.item.Item;

import java.util.Map;

public class RadiusMap {
    public static Map<Item, Integer> hammerRadius = null;
    public static Map<Item, Integer> excavatorRadius = null;
    public static Map<Item, Integer> vibraniumHammerRadius = null;
    public static Map<Item, Integer> vulpusHammerRadius = null;
    public static Map<Item, Integer> enderiumHammerRadius = null;
    public static Map<Item, Integer> vibraniumExcavatorRadius = null;
    public static Map<Item, Integer> vulpusExcavatorRadius = null;
    public static Map<Item, Integer> enderiumExcavatorRadius = null;

    public static Map<Item, Integer> getHammerRadius() {
        if (hammerRadius == null) {
            hammerRadius = Map.of(
                    ModItems.VIBRANIUM_HAMMER.get(), VibraniumConfig.RADIUS_VIBRANIUM_HAMMER.get(),
                    ModItems.VULPUS_HAMMER.get(), VulpusConfig.RADIUS_VULPUS_HAMMER.get(),
                    ModItems.ENDERIUM_HAMMER.get(), EnderiumConfig.RADIUS_ENDERIUM_HAMMER.get()
            );
        }
        return hammerRadius;
    }

    public static Map<Item, Integer> getExcavatorRadius() {
        if (excavatorRadius == null) {
            excavatorRadius = Map.of(
                    ModItems.VIBRANIUM_EXCAVATOR.get(), VibraniumConfig.RADIUS_VIBRANIUM_EXCAVATOR.get(),
                    ModItems.VULPUS_EXCAVATOR.get(), VulpusConfig.RADIUS_VULPUS_EXCAVATOR.get(),
                    ModItems.ENDERIUM_EXCAVATOR.get(), EnderiumConfig.RADIUS_ENDERIUM_EXCAVATOR.get()
            );
        }
        return excavatorRadius;
    }

    public static Map<Item, Integer> getVibraniumHammerRadius() {
        if (vibraniumHammerRadius == null) {
            vibraniumHammerRadius = Map.of(
                    ModItems.VIBRANIUM_HAMMER.get(), VibraniumConfig.RADIUS_VIBRANIUM_HAMMER.get()
            );
        }
        return vibraniumHammerRadius;
    }

    public static Map<Item, Integer> getVulpusHammerRadius() {
        if (vulpusHammerRadius == null) {
            vulpusHammerRadius = Map.of(
                    ModItems.VULPUS_HAMMER.get(), VulpusConfig.RADIUS_VULPUS_HAMMER.get()
            );
        }
        return vulpusHammerRadius;
    }

    public static Map<Item, Integer> getEnderiumHammerRadius() {
        if (enderiumHammerRadius == null) {
            enderiumHammerRadius = Map.of(
                    ModItems.ENDERIUM_HAMMER.get(), EnderiumConfig.RADIUS_ENDERIUM_HAMMER.get()
            );
        }
        return enderiumHammerRadius;
    }

    public static Map<Item, Integer> getVibraniumExcavatorRadius() {
        if (vibraniumExcavatorRadius == null) {
            vibraniumExcavatorRadius = Map.of(
                    ModItems.VIBRANIUM_EXCAVATOR.get(), VibraniumConfig.RADIUS_VIBRANIUM_EXCAVATOR.get()
            );
        }
        return vibraniumExcavatorRadius;
    }

    public static Map<Item, Integer> getVulpusExcavatorRadius() {
        if (vulpusExcavatorRadius == null) {
            vulpusExcavatorRadius = Map.of(
                    ModItems.VULPUS_EXCAVATOR.get(), VulpusConfig.RADIUS_VULPUS_EXCAVATOR.get()
            );
        }
        return vulpusExcavatorRadius;
    }

    public static Map<Item, Integer> getEnderiumExcavatorRadius() {
        if (enderiumExcavatorRadius == null) {
            enderiumExcavatorRadius = Map.of(
                    ModItems.ENDERIUM_EXCAVATOR.get(), EnderiumConfig.RADIUS_ENDERIUM_EXCAVATOR.get()
            );
        }
        return enderiumExcavatorRadius;
    }
}
