package com.blocklegend001.immersiveores.config;

import com.blocklegend001.immersiveores.config.provider.ModConfigProvider;
import com.blocklegend001.immersiveores.config.provider.SimpleConfig;
import com.mojang.datafixers.util.Pair;

public class VulpusConfig {
    public static SimpleConfig VULPUS_CONFIG;
    private static ModConfigProvider configs;

    public static int toughnessValueVulpusArmor;
    public static int enchantmentValueVulpusArmor;
    public static int knockbackResistanceValueVulpusArmor;
    public static int protectionValueVulpusBoots;
    public static int protectionValueVulpusLeggings;
    public static int protectionValueVulpusChestplate;
    public static int protectionValueVulpusHelmet;

    public static boolean speedIIVulpusArmor;
    public static boolean jumpIIVulpusArmor;
    public static boolean nightVisionVulpusArmor;
    public static boolean immuneToFallDamageVulpusArmor;
    public static boolean fireResistanceVulpusArmor;
    public static boolean neverLoseHungerVulpusArmor;
    public static boolean canWalkOnPowderedSnowVulpus;
    public static boolean makesPiglinsNeutralVulpus;

    public static int speedVulpusTier;
    public static int enchantmentValueVulpusBow;
    public static int damageVulpusBow;
    public static int attackDamageBonusVulpusTier;
    public static int enchantmentValueVulpusTier;
    public static int attackDamageVulpusPickaxe;
    public static double attackSpeedVulpusPickaxe;
    public static int attackDamageVulpusAxe;
    public static double attackSpeedVulpusAxe;
    public static int attackDamageVulpusShovel;
    public static double attackSpeedVulpusShovel;
    public static int attackDamageVulpusSword;
    public static double attackSpeedVulpusSword;
    public static int attackDamageVulpusHoe;
    public static double attackSpeedVulpusHoe;
    public static int attackDamageVulpusPaxel;
    public static double attackSpeedVulpusPaxel;
    public static int attackDamageVulpusHammer;
    public static double attackSpeedVulpusHammer;
    public static int attackDamageVulpusExcavator;
    public static double attackSpeedVulpusExcavator;
    public static int radiusVulpusHammer;
    public static int radiusVulpusExcavator;
    public static int arrowCountVulpusBow;
    public static int durabilityVulpus;
    public static boolean unbreakableVulpus;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        VULPUS_CONFIG = SimpleConfig.of("vulpus-common.toml")
                .provider(configs)
                .request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addComment("Vulpus Armor Protection and Resistance");
        configs.addKeyValuePair(new Pair<>("protectionValueVulpusBoots", 9), "Protection value of Vulpus Boots");
        configs.addKeyValuePair(new Pair<>("protectionValueVulpusLeggings", 12), "Protection value of Vulpus Leggings");
        configs.addKeyValuePair(new Pair<>("protectionValueVulpusChestplate", 16), "Protection value of Vulpus Chestplate");
        configs.addKeyValuePair(new Pair<>("protectionValueVulpusHelmet", 9), "Protection value of Vulpus Helmet");
        configs.addKeyValuePair(new Pair<>("toughnessValueVulpusArmor", 7), "Toughness value of Vulpus Armor");
        configs.addKeyValuePair(new Pair<>("enchantmentValueVulpusArmor", 65), "Enchantment value of Vulpus Armor");
        configs.addKeyValuePair(new Pair<>("knockbackResistanceValueVulpusArmor", 2), "Knockback resistance of Vulpus Armor");

        configs.addComment("Vulpus Armor Special Effects and Abilities");
        configs.addKeyValuePair(new Pair<>("speedIIVulpusArmor", true), "Speed II effect for Vulpus Armor");
        configs.addKeyValuePair(new Pair<>("jumpIIVulpusArmor", true), "Jump II effect for Vulpus Armor");
        configs.addKeyValuePair(new Pair<>("nightVisionVulpusArmor", true), "Night Vision for Vulpus Armor");
        configs.addKeyValuePair(new Pair<>("fireResistanceVulpusArmor", true), "Fire Resistance for Vulpus Armor");
        configs.addKeyValuePair(new Pair<>("immuneToFallDamageVulpusArmor", true), "Fall Damage Immunity for Vulpus Armor");
        configs.addKeyValuePair(new Pair<>("neverLoseHungerVulpusArmor", true), "Prevention of Hunger Loss for Vulpus Armor");
        configs.addKeyValuePair(new Pair<>("canWalkOnPowderedSnowVulpus", true), "Walking on Powdered Snow with Vulpus Armor");
        configs.addKeyValuePair(new Pair<>("makesPiglinsNeutralVulpus", true), "Piglins become Neutral with Vulpus Armor");

        configs.addComment("Vulpus Bow");
        configs.addKeyValuePair(new Pair<>("enchantmentValueVulpusBow", 5), "Enchantment value of Vulpus Bow");
        configs.addKeyValuePair(new Pair<>("damageVulpusBow", 10), "Damage of Vulpus Bow");
        configs.addKeyValuePair(new Pair<>("arrowCountVulpusBow", 3), "Arrow count for Vulpus Bow");

        configs.addComment("Vulpus Tool Tier Base");
        configs.addKeyValuePair(new Pair<>("speedVulpusTier", 40), "Mining speed of Vulpus tier");
        configs.addKeyValuePair(new Pair<>("enchantmentValueVulpusTier", 65), "Enchantment value of Vulpus tier");
        configs.addKeyValuePair(new Pair<>("attackDamageBonusVulpusTier", 3), "Attack damage bonus of Vulpus tier");
        configs.addKeyValuePair(new Pair<>("durabilityVulpus", 3093), "Durability of Vulpus tools");
        configs.addKeyValuePair(new Pair<>("unbreakableVulpus", false), "Whether Vulpus tools are unbreakable");

        configs.addComment("Vulpus Pickaxe");
        configs.addKeyValuePair(new Pair<>("attackDamageVulpusPickaxe", 10), "Attack damage of Vulpus Pickaxe");
        configs.addKeyValuePair(new Pair<>("attackSpeedVulpusPickaxe", 0.5), "Attack speed of Vulpus Pickaxe");

        configs.addComment("Vulpus Axe");
        configs.addKeyValuePair(new Pair<>("attackDamageVulpusAxe", 15), "Attack damage of Vulpus Axe");
        configs.addKeyValuePair(new Pair<>("attackSpeedVulpusAxe", 0.5), "Attack speed of Vulpus Axe");

        configs.addComment("Vulpus Shovel");
        configs.addKeyValuePair(new Pair<>("attackDamageVulpusShovel", 10), "Attack damage of Vulpus Shovel");
        configs.addKeyValuePair(new Pair<>("attackSpeedVulpusShovel", 0.5), "Attack speed of Vulpus Shovel");

        configs.addComment("Vulpus Sword");
        configs.addKeyValuePair(new Pair<>("attackDamageVulpusSword", 14), "Attack damage of Vulpus Sword");
        configs.addKeyValuePair(new Pair<>("attackSpeedVulpusSword", 0.5), "Attack speed of Vulpus Sword");

        configs.addComment("Vulpus Hoe");
        configs.addKeyValuePair(new Pair<>("attackDamageVulpusHoe", 10), "Attack damage of Vulpus Hoe");
        configs.addKeyValuePair(new Pair<>("attackSpeedVulpusHoe", 0.5), "Attack speed of Vulpus Hoe");

        configs.addComment("Vulpus Paxel");
        configs.addKeyValuePair(new Pair<>("attackDamageVulpusPaxel", 15), "Attack damage of Vulpus Paxel");
        configs.addKeyValuePair(new Pair<>("attackSpeedVulpusPaxel", 0.5), "Attack speed of Vulpus Paxel");

        configs.addComment("Vulpus Hammer");
        configs.addKeyValuePair(new Pair<>("attackDamageVulpusHammer", 11), "Attack damage of Vulpus Hammer");
        configs.addKeyValuePair(new Pair<>("attackSpeedVulpusHammer", 0.5), "Attack speed of Vulpus Hammer");
        configs.addKeyValuePair(new Pair<>("radiusVulpusHammer", 2), "Hammering radius for Vulpus Hammer");

        configs.addComment("Vulpus Excavator");
        configs.addKeyValuePair(new Pair<>("attackDamageVulpusExcavator", 11), "Attack damage of Vulpus Excavator");
        configs.addKeyValuePair(new Pair<>("attackSpeedVulpusExcavator", 0.5), "Attack speed of Vulpus Excavator");
        configs.addKeyValuePair(new Pair<>("radiusVulpusExcavator", 2), "Excavation radius for Vulpus Excavator");
    }

    private static void assignConfigs() {
        protectionValueVulpusBoots = VULPUS_CONFIG.getOrDefault("protectionValueVulpusBoots", 9);
        protectionValueVulpusLeggings = VULPUS_CONFIG.getOrDefault("protectionValueVulpusLeggings", 12);
        protectionValueVulpusChestplate = VULPUS_CONFIG.getOrDefault("protectionValueVulpusChestplate", 16);
        protectionValueVulpusHelmet = VULPUS_CONFIG.getOrDefault("protectionValueVulpusHelmet", 9);

        toughnessValueVulpusArmor = VULPUS_CONFIG.getOrDefault("toughnessValueVulpusArmor", 7);
        knockbackResistanceValueVulpusArmor = VULPUS_CONFIG.getOrDefault("knockbackResistanceValueVulpusArmor", 2);
        enchantmentValueVulpusArmor = VULPUS_CONFIG.getOrDefault("enchantmentValueVulpusArmor", 65);
        durabilityVulpus = VULPUS_CONFIG.getOrDefault("durabilityVulpus", 3093);
        unbreakableVulpus = VULPUS_CONFIG.getOrDefault("unbreakableVulpus", false);

        speedIIVulpusArmor = VULPUS_CONFIG.getOrDefault("speedIIVulpusArmor", true);
        jumpIIVulpusArmor = VULPUS_CONFIG.getOrDefault("jumpIIVulpusArmor", true);
        nightVisionVulpusArmor = VULPUS_CONFIG.getOrDefault("nightVisionVulpusArmor", true);
        fireResistanceVulpusArmor = VULPUS_CONFIG.getOrDefault("fireResistanceVulpusArmor", true);
        immuneToFallDamageVulpusArmor = VULPUS_CONFIG.getOrDefault("immuneToFallDamageVulpusArmor", true);
        neverLoseHungerVulpusArmor = VULPUS_CONFIG.getOrDefault("neverLoseHungerVulpusArmor", true);
        canWalkOnPowderedSnowVulpus = VULPUS_CONFIG.getOrDefault("canWalkOnPowderedSnowVulpus", true);
        makesPiglinsNeutralVulpus = VULPUS_CONFIG.getOrDefault("makesPiglinsNeutralVulpus", true);

        speedVulpusTier = VULPUS_CONFIG.getOrDefault("speedVulpusTier", 40);
        attackDamageBonusVulpusTier = VULPUS_CONFIG.getOrDefault("attackDamageBonusVulpusTier", 3);
        enchantmentValueVulpusTier = VULPUS_CONFIG.getOrDefault("enchantmentValueVulpusTier", 65);
        durabilityVulpus = VULPUS_CONFIG.getOrDefault("durabilityVulpus", 3093);
        unbreakableVulpus = VULPUS_CONFIG.getOrDefault("unbreakableVulpus", false);

        enchantmentValueVulpusBow = VULPUS_CONFIG.getOrDefault("enchantmentValueVulpusBow", 5);
        damageVulpusBow = VULPUS_CONFIG.getOrDefault("damageVulpusBow", 10);
        arrowCountVulpusBow = VULPUS_CONFIG.getOrDefault("arrowCountVulpusBow", 3);

        attackDamageVulpusPickaxe = VULPUS_CONFIG.getOrDefault("attackDamageVulpusPickaxe", 10);
        attackSpeedVulpusPickaxe = VULPUS_CONFIG.getOrDefault("attackSpeedVulpusPickaxe", 0.5);

        attackDamageVulpusAxe = VULPUS_CONFIG.getOrDefault("attackDamageVulpusAxe", 15);
        attackSpeedVulpusAxe = VULPUS_CONFIG.getOrDefault("attackSpeedVulpusAxe", 0.5);

        attackDamageVulpusShovel = VULPUS_CONFIG.getOrDefault("attackDamageVulpusShovel", 10);
        attackSpeedVulpusShovel = VULPUS_CONFIG.getOrDefault("attackSpeedVulpusShovel", 0.5);

        attackDamageVulpusSword = VULPUS_CONFIG.getOrDefault("attackDamageVulpusSword", 14);
        attackSpeedVulpusSword = VULPUS_CONFIG.getOrDefault("attackSpeedVulpusSword", 0.5);

        attackDamageVulpusHoe = VULPUS_CONFIG.getOrDefault("attackDamageVulpusHoe", 10);
        attackSpeedVulpusHoe = VULPUS_CONFIG.getOrDefault("attackSpeedVulpusHoe", 0.5);

        attackDamageVulpusPaxel = VULPUS_CONFIG.getOrDefault("attackDamageVulpusPaxel", 15);
        attackSpeedVulpusPaxel = VULPUS_CONFIG.getOrDefault("attackSpeedVulpusPaxel", 0.5);

        attackDamageVulpusHammer = VULPUS_CONFIG.getOrDefault("attackDamageVulpusHammer", 11);
        attackSpeedVulpusHammer = VULPUS_CONFIG.getOrDefault("attackSpeedVulpusHammer", 0.5);
        radiusVulpusHammer = VULPUS_CONFIG.getOrDefault("radiusVulpusHammer", 2);

        attackDamageVulpusExcavator = VULPUS_CONFIG.getOrDefault("attackDamageVulpusExcavator", 11);
        attackSpeedVulpusExcavator = VULPUS_CONFIG.getOrDefault("attackSpeedVulpusExcavator", 0.5);
        radiusVulpusExcavator = VULPUS_CONFIG.getOrDefault("radiusVulpusExcavator", 2);
    }

}
