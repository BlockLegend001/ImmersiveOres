package com.blocklegend001.immersiveores.util.map;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.item.Item;

import java.util.Map;

public class RadiusMap {

    public static final Map<Item, Integer> HAMMERS_RADIUS = Map.of(
            ModItems.VIBRANIUM_HAMMER, ImmersiveOres.VIBRANIUM_CONFIG.hammer().radius,
            ModItems.VULPUS_HAMMER, VulpusConfig.radiusVulpusHammer,
            ModItems.ENDERIUM_HAMMER, ImmersiveOres.ENDERIUM_CONFIG.hammer().radius
    );

    public static final Map<Item, Integer> EXCAVATORS_RADIUS = Map.of(
            ModItems.VIBRANIUM_EXCAVATOR, ImmersiveOres.VIBRANIUM_CONFIG.excavator().radius,
            ModItems.VULPUS_EXCAVATOR, VulpusConfig.radiusVulpusExcavator,
            ModItems.ENDERIUM_EXCAVATOR, ImmersiveOres.ENDERIUM_CONFIG.excavator().radius
    );

    public static final Map<Item, Integer> VIBRANIUM_HAMMER_RADIUS = Map.of(
            ModItems.VIBRANIUM_HAMMER, ImmersiveOres.VIBRANIUM_CONFIG.hammer().radius
    );

    public static final Map<Item, Integer> VIBRANIUM_EXCAVATOR_RADIUS = Map.of(
            ModItems.VIBRANIUM_EXCAVATOR, ImmersiveOres.VIBRANIUM_CONFIG.excavator().radius
    );

    public static final Map<Item, Integer> VULPUS_HAMMER_RADIUS = Map.of(
            ModItems.VULPUS_HAMMER, VulpusConfig.radiusVulpusHammer
    );

    public static final Map<Item, Integer> VULPUS_EXCAVATOR_RADIUS = Map.of(
            ModItems.VULPUS_EXCAVATOR, VulpusConfig.radiusVulpusExcavator
    );

    public static final Map<Item, Integer> ENDERIUM_HAMMER_RADIUS = Map.of(
            ModItems.ENDERIUM_HAMMER, ImmersiveOres.ENDERIUM_CONFIG.hammer().radius
    );

    public static final Map<Item, Integer> ENDERIUM_EXCAVATOR_RADIUS = Map.of(
            ModItems.ENDERIUM_EXCAVATOR, ImmersiveOres.ENDERIUM_CONFIG.excavator().radius
    );
}
