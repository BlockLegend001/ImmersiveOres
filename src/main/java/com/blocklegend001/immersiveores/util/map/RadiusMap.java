package com.blocklegend001.immersiveores.util.map;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class RadiusMap {

    public static final Map<Item, Integer> HAMMERS_RADIUS = new HashMap<>();
    public static final Map<Item, Integer> EXCAVATORS_RADIUS = new HashMap<>();

    public static final Map<Item, Integer> VIBRANIUM_HAMMER_RADIUS = new HashMap<>();
    public static final Map<Item, Integer> VULPUS_HAMMER_RADIUS = new HashMap<>();
    public static final Map<Item, Integer> ENDERIUM_HAMMER_RADIUS = new HashMap<>();
    public static final Map<Item, Integer> VIBRANIUM_EXCAVATOR_RADIUS = new HashMap<>();
    public static final Map<Item, Integer> VULPUS_EXCAVATOR_RADIUS = new HashMap<>();
    public static final Map<Item, Integer> ENDERIUM_EXCAVATOR_RADIUS = new HashMap<>();

    static {
        addHammer(ModItems.VIBRANIUM_HAMMER, VibraniumConfig.radiusVibraniumHammer);
        addHammer(ModItems.VULPUS_HAMMER, VulpusConfig.radiusVulpusHammer);
        addHammer(ModItems.ENDERIUM_HAMMER, EnderiumConfig.radiusEnderiumHammer);

        addExcavator(ModItems.VIBRANIUM_EXCAVATOR, VibraniumConfig.radiusVibraniumExcavator);
        addExcavator(ModItems.VULPUS_EXCAVATOR, VulpusConfig.radiusVulpusExcavator);
        addExcavator(ModItems.ENDERIUM_EXCAVATOR, EnderiumConfig.radiusEnderiumExcavator);
    }

    private static void addHammer(Item item, int radius) {
        int r = Math.max(radius, 1);
        HAMMERS_RADIUS.put(item, r);

        if (item == ModItems.VIBRANIUM_HAMMER) VIBRANIUM_HAMMER_RADIUS.put(item, r);
        else if (item == ModItems.VULPUS_HAMMER) VULPUS_HAMMER_RADIUS.put(item, r);
        else if (item == ModItems.ENDERIUM_HAMMER) ENDERIUM_HAMMER_RADIUS.put(item, r);
    }

    private static void addExcavator(Item item, int radius) {
        int r = Math.max(radius, 1);
        EXCAVATORS_RADIUS.put(item, r);

        if (item == ModItems.VIBRANIUM_EXCAVATOR) VIBRANIUM_EXCAVATOR_RADIUS.put(item, r);
        else if (item == ModItems.VULPUS_EXCAVATOR) VULPUS_EXCAVATOR_RADIUS.put(item, r);
        else if (item == ModItems.ENDERIUM_EXCAVATOR) ENDERIUM_EXCAVATOR_RADIUS.put(item, r);
    }
}
