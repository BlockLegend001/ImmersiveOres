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

        configs.addKeyValuePair(new Pair<>("protectionValueVulpusBoots", 20), "Protection value of Vulpus Boots | Default Value = 20");
        configs.addKeyValuePair(new Pair<>("protectionValueVulpusLeggings", 25), "Protection value of Vulpus Leggings | Default Value = 25");
        configs.addKeyValuePair(new Pair<>("protectionValueVulpusChestplate", 35), "Protection value of Vulpus Chestplate | Default Value = 35");
        configs.addKeyValuePair(new Pair<>("protectionValueVulpusHelmet", 20), "Protection value of Vulpus Helmet | Default Value = 20");

        configs.addKeyValuePair(new Pair<>("toughnessValueVulpusArmor", 150), "Toughness value of Vulpus Armor | Default Value = 150");
        configs.addKeyValuePair(new Pair<>("enchantmentValueVulpusArmor", 85), "Enchantment value of Vulpus Armor | Default Value = 85");
        configs.addKeyValuePair(new Pair<>("knockbackResistanceValueVulpusArmor", 2), "Knockback resistance of Vulpus Armor | Default Value = 2");

        configs.addComment("Vulpus Armor Special Effects and Abilities");

        configs.addKeyValuePair(new Pair<>("speedIIVulpusArmor", true), "Speed II effect for Vulpus Armor | Default Value = true");
        configs.addKeyValuePair(new Pair<>("jumpIIVulpusArmor", true), "Jump II effect for Vulpus Armor | Default Value = true");
        configs.addKeyValuePair(new Pair<>("nightVisionVulpusArmor", true), "Night Vision for Vulpus Armor | Default Value = true");
        configs.addKeyValuePair(new Pair<>("fireResistanceVulpusArmor", true), "Fire Resistance for Vulpus Armor | Default Value = true");
        configs.addKeyValuePair(new Pair<>("immuneToFallDamageVulpusArmor", true), "Fall Damage Immunity for Vulpus Armor | Default Value = true");
        configs.addKeyValuePair(new Pair<>("neverLoseHungerVulpusArmor", true), "Prevention of Hunger Loss for Vulpus Armor | Default Value = true");
        configs.addKeyValuePair(new Pair<>("canWalkOnPowderedSnowVulpus", true), "Walking on Powdered Snow with Vulpus Armor | Default Value = true");
        configs.addKeyValuePair(new Pair<>("makesPiglinsNeutralVulpus", true), "Piglins become Neutral with Vulpus Armor | Default Value = true");

        configs.addComment("Vulpus Bow");

        configs.addKeyValuePair(new Pair<>("enchantmentValueVulpusBow", 5), "Enchantment value of Vulpus Bow | Default Value = 5");
        configs.addKeyValuePair(new Pair<>("damageVulpusBow", 10), "Damage of Vulpus Bow | Default Value = 10");
        configs.addKeyValuePair(new Pair<>("arrowCountVulpusBow", 3), "Arrow count for Vulpus Bow | Default Value = 3");

        configs.addComment("Vulpus Tool Tier Base");

        configs.addKeyValuePair(new Pair<>("speedVulpusTier", 75), "Mining speed of Vulpus tier | Default Value = 75");
        configs.addKeyValuePair(new Pair<>("enchantmentValueVulpusTier", 85), "Enchantment value of Vulpus tier | Default Value = 85");
        configs.addKeyValuePair(new Pair<>("attackDamageBonusVulpusTier", 20), "Attack damage bonus of Vulpus tier | Default Value = 20");
        configs.addKeyValuePair(new Pair<>("durabilityVulpus", 4324), "Durability of Vulpus tools | Default Value = 4324");
        configs.addKeyValuePair(new Pair<>("unbreakableVulpus", false), "Whether Vulpus tools are unbreakable | Default Value = true");


        configs.addComment("Vulpus Pickaxe");

        configs.addKeyValuePair(new Pair<>("attackDamageVulpusPickaxe", 10), "Attack damage of Vulpus Pickaxe | Default Value = 10");
        configs.addKeyValuePair(new Pair<>("attackSpeedVulpusPickaxe", 2.0), "Attack speed of Vulpus Pickaxe | Default Value = 2.0");

        configs.addComment("Vulpus Axe");

        configs.addKeyValuePair(new Pair<>("attackDamageVulpusAxe", 15), "Attack damage of Vulpus Axe | Default Value = 15");
        configs.addKeyValuePair(new Pair<>("attackSpeedVulpusAxe", 2.0), "Attack speed of Vulpus Axe | Default Value = 2.0");

        configs.addComment("Vulpus Shovel");

        configs.addKeyValuePair(new Pair<>("attackDamageVulpusShovel", 12), "Attack damage of Vulpus Shovel | Default Value = 12");
        configs.addKeyValuePair(new Pair<>("attackSpeedVulpusShovel", 2.0), "Attack speed of Vulpus Shovel | Default Value = 2.0");

        configs.addComment("Vulpus Sword");

        configs.addKeyValuePair(new Pair<>("attackDamageVulpusSword", 14), "Attack damage of Vulpus Sword | Default Value = 14");
        configs.addKeyValuePair(new Pair<>("attackSpeedVulpusSword", 2.0), "Attack speed of Vulpus Sword | Default Value = 2.0");

        configs.addComment("Vulpus Hoe");

        configs.addKeyValuePair(new Pair<>("attackDamageVulpusHoe", 10), "Attack damage of Vulpus Hoe | Default Value = 10");
        configs.addKeyValuePair(new Pair<>("attackSpeedVulpusHoe", 2.0), "Attack speed of Vulpus Hoe | Default Value = 2.0");

        configs.addComment("Vulpus Paxel");

        configs.addKeyValuePair(new Pair<>("attackDamageVulpusPaxel", 18), "Attack damage of Vulpus Paxel | Default Value = 18");
        configs.addKeyValuePair(new Pair<>("attackSpeedVulpusPaxel", 2.0), "Attack speed of Vulpus Paxel | Default Value = 2.0");

        configs.addComment("Vulpus Hammer");

        configs.addKeyValuePair(new Pair<>("attackDamageVulpusHammer", 17), "Attack damage of Vulpus Hammer | Default Value = 17");
        configs.addKeyValuePair(new Pair<>("attackSpeedVulpusHammer", 2.0), "Attack speed of Vulpus Hammer | Default Value = 2.0");
        configs.addKeyValuePair(new Pair<>("radiusVulpusHammer", 2), "Hammering radius for Vulpus Hammer | Default Value = 2");

        configs.addComment("Vulpus Excavator");

        configs.addKeyValuePair(new Pair<>("attackDamageVulpusExcavator", 17), "Attack damage of Vulpus Excavator | Default Value = 17");
        configs.addKeyValuePair(new Pair<>("attackSpeedVulpusExcavator", 2.0), "Attack speed of Vulpus Excavator | Default Value = 2.0");
        configs.addKeyValuePair(new Pair<>("radiusVulpusExcavator", 2), "Excavation radius for Vulpus Excavator | Default Value = 2");

    }

    private static void assignConfigs() {
        protectionValueVulpusBoots = VULPUS_CONFIG.getOrDefault("protectionValueVulpusBoots", 20);
        protectionValueVulpusLeggings = VULPUS_CONFIG.getOrDefault("protectionValueVulpusLeggings", 25);
        protectionValueVulpusChestplate = VULPUS_CONFIG.getOrDefault("protectionValueVulpusChestplate", 35);
        protectionValueVulpusHelmet = VULPUS_CONFIG.getOrDefault("protectionValueVulpusHelmet", 20);

        toughnessValueVulpusArmor = VULPUS_CONFIG.getOrDefault("toughnessValueVulpusArmor", 150);
        knockbackResistanceValueVulpusArmor = VULPUS_CONFIG.getOrDefault("knockbackResistanceValueVulpusArmor", 2);
        enchantmentValueVulpusArmor = VULPUS_CONFIG.getOrDefault("enchantmentValueVulpusArmor", 85);
        durabilityVulpus = VULPUS_CONFIG.getOrDefault("durabilityVulpus", 4324);
        unbreakableVulpus = VULPUS_CONFIG.getOrDefault("unbreakableVulpus", false);

        speedIIVulpusArmor = VULPUS_CONFIG.getOrDefault("speedIIVulpusArmor", true);
        jumpIIVulpusArmor = VULPUS_CONFIG.getOrDefault("jumpIIVulpusArmor", true);
        nightVisionVulpusArmor = VULPUS_CONFIG.getOrDefault("nightVisionVulpusArmor", true);
        fireResistanceVulpusArmor = VULPUS_CONFIG.getOrDefault("fireResistanceVulpusArmor", true);
        immuneToFallDamageVulpusArmor = VULPUS_CONFIG.getOrDefault("immuneToFallDamageVulpusArmor", true);
        neverLoseHungerVulpusArmor = VULPUS_CONFIG.getOrDefault("neverLoseHungerVulpusArmor", true);
        canWalkOnPowderedSnowVulpus = VULPUS_CONFIG.getOrDefault("canWalkOnPowderedSnowVulpus", true);
        makesPiglinsNeutralVulpus = VULPUS_CONFIG.getOrDefault("makesPiglinsNeutralVulpus", true);

        speedVulpusTier = VULPUS_CONFIG.getOrDefault("speedVulpusTier", 75);
        attackDamageBonusVulpusTier = VULPUS_CONFIG.getOrDefault("attackDamageBonusVulpusTier", 20);
        enchantmentValueVulpusTier = VULPUS_CONFIG.getOrDefault("enchantmentValueVulpusTier", 85);
        durabilityVulpus = VULPUS_CONFIG.getOrDefault("durabilityVulpus", 4324);
        unbreakableVulpus = VULPUS_CONFIG.getOrDefault("unbreakableVulpus", false);

        enchantmentValueVulpusBow = VULPUS_CONFIG.getOrDefault("enchantmentValueVulpusBow", 5);
        damageVulpusBow = VULPUS_CONFIG.getOrDefault("damageVulpusBow", 10);
        arrowCountVulpusBow = VULPUS_CONFIG.getOrDefault("arrowCountVulpusBow", 3);

        attackDamageVulpusPickaxe = VULPUS_CONFIG.getOrDefault("attackDamageVulpusPickaxe", 10);
        attackSpeedVulpusPickaxe = VULPUS_CONFIG.getOrDefault("attackSpeedVulpusPickaxe", 2.0);

        attackDamageVulpusAxe = VULPUS_CONFIG.getOrDefault("attackDamageVulpusAxe", 15);
        attackSpeedVulpusAxe = VULPUS_CONFIG.getOrDefault("attackSpeedVulpusAxe", 2.0);

        attackDamageVulpusShovel = VULPUS_CONFIG.getOrDefault("attackDamageVulpusShovel", 12);
        attackSpeedVulpusShovel = VULPUS_CONFIG.getOrDefault("attackSpeedVulpusShovel", 2.0);

        attackDamageVulpusSword = VULPUS_CONFIG.getOrDefault("attackDamageVulpusSword", 14);
        attackSpeedVulpusSword = VULPUS_CONFIG.getOrDefault("attackSpeedVulpusSword", 2.0);

        attackDamageVulpusHoe = VULPUS_CONFIG.getOrDefault("attackDamageVulpusHoe", 10);
        attackSpeedVulpusHoe = VULPUS_CONFIG.getOrDefault("attackSpeedVulpusHoe", 2.0);

        attackDamageVulpusPaxel = VULPUS_CONFIG.getOrDefault("attackDamageVulpusPaxel", 18);
        attackSpeedVulpusPaxel = VULPUS_CONFIG.getOrDefault("attackSpeedVulpusPaxel", 2.0);

        attackDamageVulpusHammer = VULPUS_CONFIG.getOrDefault("attackDamageVulpusHammer", 17);
        attackSpeedVulpusHammer = VULPUS_CONFIG.getOrDefault("attackSpeedVulpusHammer", 2.0);
        radiusVulpusHammer = VULPUS_CONFIG.getOrDefault("radiusVulpusHammer", 2);

        attackDamageVulpusExcavator = VULPUS_CONFIG.getOrDefault("attackDamageVulpusExcavator", 17);
        attackSpeedVulpusExcavator = VULPUS_CONFIG.getOrDefault("attackSpeedVulpusExcavator", 2.0);
        radiusVulpusExcavator = VULPUS_CONFIG.getOrDefault("radiusVulpusExcavator", 2);
    }

}
