package com.blocklegend001.immersiveores.config;

import com.blocklegend001.immersiveores.config.provider.ModConfigProvider;
import com.blocklegend001.immersiveores.config.provider.SimpleConfig;
import com.mojang.datafixers.util.Pair;

public class VibraniumConfig {
    public static SimpleConfig VIBRANIUM_CONFIG;
    private static ModConfigProvider configs;

    public static int toughnessValueVibraniumArmor;
    public static int enchantmentValueVibraniumArmor;
    public static float knockbackResistanceValueVibraniumArmor;
    public static int protectionValueVibraniumBoots;
    public static int protectionValueVibraniumLeggings;
    public static int protectionValueVibraniumChestplate;
    public static int protectionValueVibraniumHelmet;

    public static boolean speedIVibraniumArmor;
    public static boolean jumpIVibraniumArmor;
    public static boolean nightVisionVibraniumArmor;
    public static boolean canWalkOnPowderedSnowVibranium;

    public static int speedVibraniumTier;
    public static int enchantmentValueVibraniumBow;
    public static int damageVibraniumBow;
    public static int attackDamageBonusVibraniumTier;
    public static int enchantmentValueVibraniumTier;
    public static int attackDamageVibraniumPickaxe;
    public static double attackSpeedVibraniumPickaxe;
    public static int attackDamageVibraniumAxe;
    public static double attackSpeedVibraniumAxe;
    public static int attackDamageVibraniumShovel;
    public static double attackSpeedVibraniumShovel;
    public static int attackDamageVibraniumSword;
    public static double attackSpeedVibraniumSword;
    public static int attackDamageVibraniumHoe;
    public static double attackSpeedVibraniumHoe;
    public static int attackDamageVibraniumPaxel;
    public static double attackSpeedVibraniumPaxel;
    public static int attackDamageVibraniumHammer;
    public static double attackSpeedVibraniumHammer;
    public static int attackDamageVibraniumExcavator;
    public static double attackSpeedVibraniumExcavator;
    public static int radiusVibraniumHammer;
    public static int radiusVibraniumExcavator;
    public static int arrowCountVibraniumBow;
    public static int durabilityVibranium;
    public static boolean unbreakableVibranium;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        VIBRANIUM_CONFIG = SimpleConfig.of("vibranium-common")
                .provider(configs)
                .request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addComment("--- Vibranium Armor Protection and Resistance ---");
        configs.addKeyValuePair(new Pair<>("protectionValueVibraniumBoots", 6), "Protection value of Vibranium Boots");
        configs.addKeyValuePair(new Pair<>("protectionValueVibraniumLeggings", 9), "Protection value of Vibranium Leggings");
        configs.addKeyValuePair(new Pair<>("protectionValueVibraniumChestplate", 12), "Protection value of Vibranium Chestplate");
        configs.addKeyValuePair(new Pair<>("protectionValueVibraniumHelmet", 6), "Protection value of Vibranium Helmet");

        configs.addKeyValuePair(new Pair<>("toughnessValueVibraniumArmor", 3), "Toughness value of Vibranium Armor");
        configs.addKeyValuePair(new Pair<>("knockbackResistanceValueVibraniumArmor", 0.1), "Knockback resistance of Vibranium Armor");
        configs.addKeyValuePair(new Pair<>("enchantmentValueVibraniumArmor", 55), "Enchantment value of Vibranium Armor");

        configs.addComment("--- Vibranium Armor Special Effects and Abilities ---");
        configs.addKeyValuePair(new Pair<>("speedIVibraniumArmor", true), "Speed I effect for Vibranium Armor");
        configs.addKeyValuePair(new Pair<>("jumpIVibraniumArmor", true), "Jump I effect for Vibranium Armor");
        configs.addKeyValuePair(new Pair<>("nightVisionVibraniumArmor", true), "Night Vision effect for Vibranium Armor");
        configs.addKeyValuePair(new Pair<>("canWalkOnPowderedSnowVibranium", true), "Can walk on powdered snow with Vibranium Armor");

        configs.addComment("--- Vibranium Bow Settings ---");
        configs.addKeyValuePair(new Pair<>("enchantmentValueVibraniumBow", 5), "Enchantment value of Vibranium Bow");
        configs.addKeyValuePair(new Pair<>("damageVibraniumBow", 5), "Damage value of Vibranium Bow");
        configs.addKeyValuePair(new Pair<>("arrowCountVibraniumBow", 2), "Arrow count for Vibranium Bow");

        configs.addComment("--- Vibranium Tool Tier Base Properties ---");
        configs.addKeyValuePair(new Pair<>("speedVibraniumTier", 30), "Speed value of Vibranium tier");
        configs.addKeyValuePair(new Pair<>("enchantmentValueVibraniumTier", 55), "Enchantment value of Vibranium tier");
        configs.addKeyValuePair(new Pair<>("attackDamageBonusVibraniumTier", 1), "Attack damage bonus of Vibranium tier");
        configs.addKeyValuePair(new Pair<>("durabilityVibranium", 2562), "Durability of Vibranium tools");
        configs.addKeyValuePair(new Pair<>("unbreakableVibranium", false), "Whether Vibranium tools are unbreakable");

        configs.addComment("--- Vibranium Pickaxe Stats ---");
        configs.addKeyValuePair(new Pair<>("attackDamageVibraniumPickaxe", 7), "Attack damage of Vibranium Pickaxe");
        configs.addKeyValuePair(new Pair<>("attackSpeedVibraniumPickaxe", 0.5), "Attack speed of Vibranium Pickaxe");

        configs.addComment("--- Vibranium Axe Stats ---");
        configs.addKeyValuePair(new Pair<>("attackDamageVibraniumAxe", 12), "Attack damage of Vibranium Axe");
        configs.addKeyValuePair(new Pair<>("attackSpeedVibraniumAxe", 0.5), "Attack speed of Vibranium Axe");

        configs.addComment("--- Vibranium Shovel Stats ---");
        configs.addKeyValuePair(new Pair<>("attackDamageVibraniumShovel", 7), "Attack damage of Vibranium Shovel");
        configs.addKeyValuePair(new Pair<>("attackSpeedVibraniumShovel", 0.5), "Attack speed of Vibranium Shovel");

        configs.addComment("--- Vibranium Sword Stats ---");
        configs.addKeyValuePair(new Pair<>("attackDamageVibraniumSword", 10), "Attack damage of Vibranium Sword");
        configs.addKeyValuePair(new Pair<>("attackSpeedVibraniumSword", 0.5), "Attack speed of Vibranium Sword");

        configs.addComment("--- Vibranium Hoe Stats ---");
        configs.addKeyValuePair(new Pair<>("attackDamageVibraniumHoe", 7), "Attack damage of Vibranium Hoe");
        configs.addKeyValuePair(new Pair<>("attackSpeedVibraniumHoe", 0.5), "Attack speed of Vibranium Hoe");

        configs.addComment("--- Vibranium Paxel Stats ---");
        configs.addKeyValuePair(new Pair<>("attackDamageVibraniumPaxel", 11), "Attack damage of Vibranium Paxel");
        configs.addKeyValuePair(new Pair<>("attackSpeedVibraniumPaxel", 0.5), "Attack speed of Vibranium Paxel");

        configs.addComment("--- Vibranium Hammer Stats ---");
        configs.addKeyValuePair(new Pair<>("attackDamageVibraniumHammer", 7), "Attack damage of Vibranium Hammer");
        configs.addKeyValuePair(new Pair<>("attackSpeedVibraniumHammer", 0.5), "Attack speed of Vibranium Hammer");
        configs.addKeyValuePair(new Pair<>("radiusVibraniumHammer", 1), "Hammering radius for Vibranium Hammer");

        configs.addComment("--- Vibranium Excavator Stats ---");
        configs.addKeyValuePair(new Pair<>("attackDamageVibraniumExcavator", 7), "Attack damage of Vibranium Excavator");
        configs.addKeyValuePair(new Pair<>("attackSpeedVibraniumExcavator", 0.5), "Attack speed of Vibranium Excavator");
        configs.addKeyValuePair(new Pair<>("radiusVibraniumExcavator", 1), "Excavation radius for Vibranium Excavator");
    }

    private static void assignConfigs() {
        protectionValueVibraniumBoots = VIBRANIUM_CONFIG.getOrDefault("protectionValueVibraniumBoots", 6);
        protectionValueVibraniumLeggings = VIBRANIUM_CONFIG.getOrDefault("protectionValueVibraniumLeggings", 9);
        protectionValueVibraniumChestplate = VIBRANIUM_CONFIG.getOrDefault("protectionValueVibraniumChestplate", 12);
        protectionValueVibraniumHelmet = VIBRANIUM_CONFIG.getOrDefault("protectionValueVibraniumHelmet", 6);

        toughnessValueVibraniumArmor = VIBRANIUM_CONFIG.getOrDefault("toughnessValueVibraniumArmor", 3);
        knockbackResistanceValueVibraniumArmor = VIBRANIUM_CONFIG.getOrDefault("knockbackResistanceValueVibraniumArmor", 1);
        enchantmentValueVibraniumArmor = VIBRANIUM_CONFIG.getOrDefault("enchantmentValueVibraniumArmor", 55);
        durabilityVibranium = VIBRANIUM_CONFIG.getOrDefault("durabilityVibranium", 2562);
        unbreakableVibranium = VIBRANIUM_CONFIG.getOrDefault("unbreakableVibranium", false);

        speedIVibraniumArmor = VIBRANIUM_CONFIG.getOrDefault("speedIVibraniumArmor", true);
        jumpIVibraniumArmor = VIBRANIUM_CONFIG.getOrDefault("jumpIVibraniumArmor", true);
        nightVisionVibraniumArmor = VIBRANIUM_CONFIG.getOrDefault("nightVisionVibraniumArmor", true);
        canWalkOnPowderedSnowVibranium = VIBRANIUM_CONFIG.getOrDefault("canWalkOnPowderedSnowVibranium", true);

        speedVibraniumTier = VIBRANIUM_CONFIG.getOrDefault("speedVibraniumTier", 30);
        enchantmentValueVibraniumBow = VIBRANIUM_CONFIG.getOrDefault("enchantmentValueVibraniumBow", 5);
        damageVibraniumBow = VIBRANIUM_CONFIG.getOrDefault("damageVibraniumBow", 5);
        attackDamageBonusVibraniumTier = VIBRANIUM_CONFIG.getOrDefault("attackDamageBonusVibraniumTier", 1);
        enchantmentValueVibraniumTier = VIBRANIUM_CONFIG.getOrDefault("enchantmentValueVibraniumTier", 55);

        attackDamageVibraniumPickaxe = VIBRANIUM_CONFIG.getOrDefault("attackDamageVibraniumPickaxe", 7);
        attackSpeedVibraniumPickaxe = VIBRANIUM_CONFIG.getOrDefault("attackSpeedVibraniumPickaxe", 0.5);

        attackDamageVibraniumAxe = VIBRANIUM_CONFIG.getOrDefault("attackDamageVibraniumAxe", 12);
        attackSpeedVibraniumAxe = VIBRANIUM_CONFIG.getOrDefault("attackSpeedVibraniumAxe", 0.5);

        attackDamageVibraniumShovel = VIBRANIUM_CONFIG.getOrDefault("attackDamageVibraniumShovel", 7);
        attackSpeedVibraniumShovel = VIBRANIUM_CONFIG.getOrDefault("attackSpeedVibraniumShovel", 0.5);

        attackDamageVibraniumSword = VIBRANIUM_CONFIG.getOrDefault("attackDamageVibraniumSword", 10);
        attackSpeedVibraniumSword = VIBRANIUM_CONFIG.getOrDefault("attackSpeedVibraniumSword", 0.5);

        attackDamageVibraniumHoe = VIBRANIUM_CONFIG.getOrDefault("attackDamageVibraniumHoe", 7);
        attackSpeedVibraniumHoe = VIBRANIUM_CONFIG.getOrDefault("attackSpeedVibraniumHoe", 0.5);

        attackDamageVibraniumPaxel = VIBRANIUM_CONFIG.getOrDefault("attackDamageVibraniumPaxel", 11);
        attackSpeedVibraniumPaxel = VIBRANIUM_CONFIG.getOrDefault("attackSpeedVibraniumPaxel", 0.5);

        attackDamageVibraniumHammer = VIBRANIUM_CONFIG.getOrDefault("attackDamageVibraniumHammer", 7);
        attackSpeedVibraniumHammer = VIBRANIUM_CONFIG.getOrDefault("attackSpeedVibraniumHammer", 0.5);
        radiusVibraniumHammer = VIBRANIUM_CONFIG.getOrDefault("radiusVibraniumHammer", 1);

        attackDamageVibraniumExcavator = VIBRANIUM_CONFIG.getOrDefault("attackDamageVibraniumExcavator", 7);
        attackSpeedVibraniumExcavator = VIBRANIUM_CONFIG.getOrDefault("attackSpeedVibraniumExcavator", 0.5);
        radiusVibraniumExcavator = VIBRANIUM_CONFIG.getOrDefault("radiusVibraniumExcavator", 1);

        arrowCountVibraniumBow = VIBRANIUM_CONFIG.getOrDefault("arrowCountVibraniumBow", 2);
    }
}
