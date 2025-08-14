package com.blocklegend001.immersiveores.config;

import com.blocklegend001.immersiveores.config.provider.ModConfigProvider;
import com.blocklegend001.immersiveores.config.provider.SimpleConfig;
import com.mojang.datafixers.util.Pair;

public class EnderiumConfig {
    public static SimpleConfig ENDERIUM_CONFIG;
    private static ModConfigProvider configs;

    public static int toughnessValueEnderiumArmor;
    public static int enchantmentValueEnderiumArmor;
    public static int knockbackResistanceValueEnderiumArmor;
    public static int protectionValueEnderiumBoots;
    public static int protectionValueEnderiumLeggings;
    public static int protectionValueEnderiumChestplate;
    public static int protectionValueEnderiumHelmet;

    public static boolean speedIIIEnderiumArmor;
    public static boolean jumpIIIEnderiumArmor;
    public static boolean nightVisionEnderiumArmor;
    public static boolean immuneToFallDamageEnderiumArmor;
    public static boolean fireResistanceEnderiumArmor;
    public static boolean neverLoseHungerEnderiumArmor;
    public static boolean canFlyEnderiumArmor;
    public static boolean canWalkOnPowderedSnowEnderium;
    public static boolean makesPiglinsNeutralEnderium;
    public static boolean endermanWillNotBeAngryWithYouEnderium;

    public static int speedEnderiumTier;
    public static int enchantmentValueEnderiumBow;
    public static int damageEnderiumBow;
    public static int attackDamageBonusEnderiumTier;
    public static int enchantmentValueEnderiumTier;
    public static int attackDamageEnderiumPickaxe;
    public static double attackSpeedEnderiumPickaxe;
    public static int attackDamageEnderiumAxe;
    public static double attackSpeedEnderiumAxe;
    public static int attackDamageEnderiumShovel;
    public static double attackSpeedEnderiumShovel;
    public static int attackDamageEnderiumSword;
    public static double attackSpeedEnderiumSword;
    public static int attackDamageEnderiumHoe;
    public static double attackSpeedEnderiumHoe;
    public static int attackDamageEnderiumPaxel;
    public static double attackSpeedEnderiumPaxel;
    public static int attackDamageEnderiumHammer;
    public static double attackSpeedEnderiumHammer;
    public static int attackDamageEnderiumExcavator;
    public static double attackSpeedEnderiumExcavator;
    public static int radiusEnderiumHammer;
    public static int radiusEnderiumExcavator;
    public static int arrowCountEnderiumBow;
    public static int durabilityEnderium;
    public static boolean unbreakableEnderium;
    public static double attackRangeEnderiumSword;
    public static double blockRangeEnderiumTool;


    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        ENDERIUM_CONFIG = SimpleConfig.of("enderium-common.toml")
                .provider(configs)
                .request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addComment("Enderium Armor Protection and Resistance");
        configs.addKeyValuePair(new Pair<>("protectionValueEnderiumBoots", 30), "Protection value of Enderium Boots");
        configs.addKeyValuePair(new Pair<>("protectionValueEnderiumLeggings", 50), "Protection value of Enderium Leggings");
        configs.addKeyValuePair(new Pair<>("protectionValueEnderiumChestplate", 70), "Protection value of Enderium Chestplate");
        configs.addKeyValuePair(new Pair<>("protectionValueEnderiumHelmet", 30), "Protection value of Enderium Helmet");

        configs.addKeyValuePair(new Pair<>("toughnessValueEnderiumArmor", 200), "Toughness value of Enderium Armor");
        configs.addKeyValuePair(new Pair<>("knockbackResistanceValueEnderiumArmor", 3), "Knockback resistance of Enderium Armor");
        configs.addKeyValuePair(new Pair<>("enchantmentValueEnderiumArmor", 85), "Enchantment value of Enderium Armor");

        configs.addComment("Enderium Armor Special Effects and Abilities");
        configs.addKeyValuePair(new Pair<>("speedIIIEnderiumArmor", true), "Speed III effect for Enderium Armor");
        configs.addKeyValuePair(new Pair<>("jumpIIIEnderiumArmor", true), "Jump III effect for Enderium Armor");
        configs.addKeyValuePair(new Pair<>("nightVisionEnderiumArmor", true), "Night Vision effect for Enderium Armor");
        configs.addKeyValuePair(new Pair<>("immuneToFallDamageEnderiumArmor", true), "Immunity to fall damage for Enderium Armor");
        configs.addKeyValuePair(new Pair<>("fireResistanceEnderiumArmor", true), "Fire resistance for Enderium Armor");
        configs.addKeyValuePair(new Pair<>("neverLoseHungerEnderiumArmor", true), "Never lose hunger with Enderium Armor");
        configs.addKeyValuePair(new Pair<>("canFlyEnderiumArmor", true), "Ability to fly with Enderium Armor");
        configs.addKeyValuePair(new Pair<>("canWalkOnPowderedSnowEnderium", true), "Can walk on powdered snow with Enderium Armor");
        configs.addKeyValuePair(new Pair<>("makesPiglinsNeutralEnderium", true), "Makes Piglins neutral with Enderium Armor");
        configs.addKeyValuePair(new Pair<>("endermanWillNotBeAngryWithYouEnderium", true), "Endermen won't be angry with you with Enderium Armor");

        configs.addComment("Enderium Bow Settings");
        configs.addKeyValuePair(new Pair<>("enchantmentValueEnderiumBow", 5), "Enchantment value of Enderium Bow");
        configs.addKeyValuePair(new Pair<>("damageEnderiumBow", 14), "Damage value of Enderium Bow");
        configs.addKeyValuePair(new Pair<>("arrowCountEnderiumBow", 4), "Arrow count for Enderium Bow");

        configs.addComment("Enderium Tool Tier Base Properties");
        configs.addKeyValuePair(new Pair<>("speedEnderiumTier", 130), "Speed value of Enderium tier");
        configs.addKeyValuePair(new Pair<>("enchantmentValueEnderiumTier", 85), "Enchantment value of Enderium tier");
        configs.addKeyValuePair(new Pair<>("attackDamageBonusEnderiumTier", 40), "Attack damage bonus of Enderium tier");
        configs.addKeyValuePair(new Pair<>("durabilityEnderium", 9139), "Durability of Enderium tools");
        configs.addKeyValuePair(new Pair<>("unbreakableEnderium", false), "Whether Enderium tools are unbreakable");
        configs.addKeyValuePair(new Pair<>("blockRangeEnderiumTool", 1.75), "Block range of Enderium Tools");

        configs.addComment("Enderium Pickaxe Stats");
        configs.addKeyValuePair(new Pair<>("attackDamageEnderiumPickaxe", 18), "Attack damage of Enderium Pickaxe");
        configs.addKeyValuePair(new Pair<>("attackSpeedEnderiumPickaxe", 2.0), "Attack speed of Enderium Pickaxe");

        configs.addComment("Enderium Axe Stats");
        configs.addKeyValuePair(new Pair<>("attackDamageEnderiumAxe", 20), "Attack damage of Enderium Axe");
        configs.addKeyValuePair(new Pair<>("attackSpeedEnderiumAxe", 2.0), "Attack speed of Enderium Axe");

        configs.addComment("Enderium Shovel Stats");
        configs.addKeyValuePair(new Pair<>("attackDamageEnderiumShovel", 17), "Attack damage of Enderium Shovel");
        configs.addKeyValuePair(new Pair<>("attackSpeedEnderiumShovel", 2.0), "Attack speed of Enderium Shovel");

        configs.addComment("Enderium Sword Stats");
        configs.addKeyValuePair(new Pair<>("attackDamageEnderiumSword", 22), "Attack damage of Enderium Sword");
        configs.addKeyValuePair(new Pair<>("attackSpeedEnderiumSword", 2.0), "Attack speed of Enderium Sword");
        configs.addKeyValuePair(new Pair<>("attackRangeEnderiumSword", 1.75), "Attack range of Enderium Sword");

        configs.addComment("Enderium Hoe Stats");
        configs.addKeyValuePair(new Pair<>("attackDamageEnderiumHoe", 14), "Attack damage of Enderium Hoe");
        configs.addKeyValuePair(new Pair<>("attackSpeedEnderiumHoe", 2.0), "Attack speed of Enderium Hoe");

        configs.addComment("Enderium Paxel Stats");
        configs.addKeyValuePair(new Pair<>("attackDamageEnderiumPaxel", 20), "Attack damage of Enderium Paxel");
        configs.addKeyValuePair(new Pair<>("attackSpeedEnderiumPaxel", 2.0), "Attack speed of Enderium Paxel");

        configs.addComment("Enderium Hammer Stats");
        configs.addKeyValuePair(new Pair<>("attackDamageEnderiumHammer", 20), "Attack damage of Enderium Hammer");
        configs.addKeyValuePair(new Pair<>("attackSpeedEnderiumHammer", 2.0), "Attack speed of Enderium Hammer");
        configs.addKeyValuePair(new Pair<>("radiusEnderiumHammer", 3), "Hammering radius for Enderium Hammer");

        configs.addComment("Enderium Excavator Stats");
        configs.addKeyValuePair(new Pair<>("attackDamageEnderiumExcavator", 20), "Attack damage of Enderium Excavator");
        configs.addKeyValuePair(new Pair<>("attackSpeedEnderiumExcavator", 2.0), "Attack speed of Enderium Excavator");
        configs.addKeyValuePair(new Pair<>("radiusEnderiumExcavator", 3), "Excavation radius for Enderium Excavator");
    }

    private static void assignConfigs() {
        protectionValueEnderiumBoots = ENDERIUM_CONFIG.getOrDefault("protectionValueEnderiumBoots", 30);
        protectionValueEnderiumLeggings = ENDERIUM_CONFIG.getOrDefault("protectionValueEnderiumLeggings", 50);
        protectionValueEnderiumChestplate = ENDERIUM_CONFIG.getOrDefault("protectionValueEnderiumChestplate", 70);
        protectionValueEnderiumHelmet = ENDERIUM_CONFIG.getOrDefault("protectionValueEnderiumHelmet", 30);
        toughnessValueEnderiumArmor = ENDERIUM_CONFIG.getOrDefault("toughnessValueEnderiumArmor", 200);
        knockbackResistanceValueEnderiumArmor = ENDERIUM_CONFIG.getOrDefault("knockbackResistanceValueEnderiumArmor", 3);
        enchantmentValueEnderiumArmor = ENDERIUM_CONFIG.getOrDefault("enchantmentValueEnderiumArmor", 85);
        speedIIIEnderiumArmor = ENDERIUM_CONFIG.getOrDefault("speedIIIEnderiumArmor", true);
        jumpIIIEnderiumArmor = ENDERIUM_CONFIG.getOrDefault("jumpIIIEnderiumArmor", true);
        nightVisionEnderiumArmor = ENDERIUM_CONFIG.getOrDefault("nightVisionEnderiumArmor", true);
        immuneToFallDamageEnderiumArmor = ENDERIUM_CONFIG.getOrDefault("immuneToFallDamageEnderiumArmor", true);
        fireResistanceEnderiumArmor = ENDERIUM_CONFIG.getOrDefault("fireResistanceEnderiumArmor", true);
        neverLoseHungerEnderiumArmor = ENDERIUM_CONFIG.getOrDefault("neverLoseHungerEnderiumArmor", true);
        canFlyEnderiumArmor = ENDERIUM_CONFIG.getOrDefault("canFlyEnderiumArmor", true);
        canWalkOnPowderedSnowEnderium = ENDERIUM_CONFIG.getOrDefault("canWalkOnPowderedSnowEnderium", true);
        makesPiglinsNeutralEnderium = ENDERIUM_CONFIG.getOrDefault("makesPiglinsNeutralEnderium", true);
        endermanWillNotBeAngryWithYouEnderium = ENDERIUM_CONFIG.getOrDefault("endermanWillNotBeAngryWithYouEnderium", true);
        enchantmentValueEnderiumBow = ENDERIUM_CONFIG.getOrDefault("enchantmentValueEnderiumBow", 5);
        damageEnderiumBow = ENDERIUM_CONFIG.getOrDefault("damageEnderiumBow", 14);
        arrowCountEnderiumBow = ENDERIUM_CONFIG.getOrDefault("arrowCountEnderiumBow", 4);
        speedEnderiumTier = ENDERIUM_CONFIG.getOrDefault("speedEnderiumTier", 130);
        enchantmentValueEnderiumTier = ENDERIUM_CONFIG.getOrDefault("enchantmentValueEnderiumTier", 85);
        attackDamageBonusEnderiumTier = ENDERIUM_CONFIG.getOrDefault("attackDamageBonusEnderiumTier", 40);
        durabilityEnderium = ENDERIUM_CONFIG.getOrDefault("durabilityEnderium", 9139);
        unbreakableEnderium = ENDERIUM_CONFIG.getOrDefault("unbreakableEnderium", false);
        attackDamageEnderiumPickaxe = ENDERIUM_CONFIG.getOrDefault("attackDamageEnderiumPickaxe", 18);
        attackSpeedEnderiumPickaxe = ENDERIUM_CONFIG.getOrDefault("attackSpeedEnderiumPickaxe", 2.0);
        attackDamageEnderiumAxe = ENDERIUM_CONFIG.getOrDefault("attackDamageEnderiumAxe", 20);
        attackSpeedEnderiumAxe = ENDERIUM_CONFIG.getOrDefault("attackSpeedEnderiumAxe", 2.0);
        attackDamageEnderiumShovel = ENDERIUM_CONFIG.getOrDefault("attackDamageEnderiumShovel", 17);
        attackSpeedEnderiumShovel = ENDERIUM_CONFIG.getOrDefault("attackSpeedEnderiumShovel", 2.0);
        attackDamageEnderiumSword = ENDERIUM_CONFIG.getOrDefault("attackDamageEnderiumSword", 22);
        attackSpeedEnderiumSword = ENDERIUM_CONFIG.getOrDefault("attackSpeedEnderiumSword", 2.0);
        attackDamageEnderiumHoe = ENDERIUM_CONFIG.getOrDefault("attackDamageEnderiumHoe", 14);
        attackSpeedEnderiumHoe = ENDERIUM_CONFIG.getOrDefault("attackSpeedEnderiumHoe", 2.0);
        attackDamageEnderiumPaxel = ENDERIUM_CONFIG.getOrDefault("attackDamageEnderiumPaxel", 20);
        attackSpeedEnderiumPaxel = ENDERIUM_CONFIG.getOrDefault("attackSpeedEnderiumPaxel", 2.0);
        attackDamageEnderiumHammer = ENDERIUM_CONFIG.getOrDefault("attackDamageEnderiumHammer", 20);
        attackSpeedEnderiumHammer = ENDERIUM_CONFIG.getOrDefault("attackSpeedEnderiumHammer", 2.0);
        radiusEnderiumHammer = ENDERIUM_CONFIG.getOrDefault("radiusEnderiumHammer", 3);
        attackDamageEnderiumExcavator = ENDERIUM_CONFIG.getOrDefault("attackDamageEnderiumExcavator", 20);
        attackSpeedEnderiumExcavator = ENDERIUM_CONFIG.getOrDefault("attackSpeedEnderiumExcavator", 2.0);
        radiusEnderiumExcavator = ENDERIUM_CONFIG.getOrDefault("radiusEnderiumExcavator", 3);
        attackRangeEnderiumSword = ENDERIUM_CONFIG.getOrDefault("attackRangeEnderiumSword", 1.75);
        blockRangeEnderiumTool = ENDERIUM_CONFIG.getOrDefault("blockRangeEnderiumTool", 1.75);

        System.out.println("All " + configs.getConfigsList().size() + " have been set properly");
    }
}
