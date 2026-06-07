package com.blocklegend001.immersiveores.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class VulpusConfig {
    public static final ModConfigSpec COMMON;

    // Armor Protection and Resistance
    public static ModConfigSpec.IntValue TOUGHNESS_VALUE_VULPUS_ARMOR;
    public static ModConfigSpec.IntValue ENCHANTMENT_VALUE_VULPUS_ARMOR;
    public static ModConfigSpec.DoubleValue KNOCKBACK_RESISTANCE_VALUE_VULPUS_ARMOR;
    public static ModConfigSpec.IntValue PROTECTION_VALUE_VULPUS_BOOTS;
    public static ModConfigSpec.IntValue PROTECTION_VALUE_VULPUS_LEGGINGS;
    public static ModConfigSpec.IntValue PROTECTION_VALUE_VULPUS_CHESTPLATE;
    public static ModConfigSpec.IntValue PROTECTION_VALUE_VULPUS_HELMET;

    // Armor Special Effects and Abilities
    public static ModConfigSpec.BooleanValue SPEED_II_VULPUS_ARMOR;
    public static ModConfigSpec.BooleanValue JUMP_II_VULPUS_ARMOR;
    public static ModConfigSpec.BooleanValue NIGHT_VISION_VULPUS_ARMOR;
    public static ModConfigSpec.BooleanValue FIRE_RESISTANCE_VULPUS_ARMOR;
    public static ModConfigSpec.BooleanValue IMMUNE_TO_FALL_DAMAGE_VULPUS_ARMOR;
    public static ModConfigSpec.BooleanValue NEVER_LOSE_HUNGER_VULPUS_ARMOR;
    public static ModConfigSpec.BooleanValue CAN_WALK_ON_POWDERED_SNOW_VULPUS;
    public static ModConfigSpec.BooleanValue MAKES_PIGLINS_NEUTRAL_VULPUS;

    // Bow Settings
    public static ModConfigSpec.IntValue ENCHANTMENT_VALUE_VULPUS_BOW;
    public static ModConfigSpec.IntValue DAMAGE_VULPUS_BOW;
    public static ModConfigSpec.IntValue ARROW_COUNT_VULPUS_BOW;

    // Tool Tier Base Properties
    public static ModConfigSpec.IntValue SPEED_VULPUS_TIER;
    public static ModConfigSpec.IntValue ATTACK_DAMAGE_BONUS_VULPUS_TIER;
    public static ModConfigSpec.IntValue ENCHANTMENT_VALUE_VULPUS_TIER;
    public static ModConfigSpec.IntValue DURABILITY_VULPUS;
    public static ModConfigSpec.BooleanValue UNBREAKABLE_VULPUS;

    // Pickaxe Stats
    public static ModConfigSpec.IntValue ATTACK_DAMAGE_VULPUS_PICKAXE;
    public static ModConfigSpec.DoubleValue ATTACK_SPEED_VULPUS_PICKAXE;

    // Axe Stats
    public static ModConfigSpec.IntValue ATTACK_DAMAGE_VULPUS_AXE;
    public static ModConfigSpec.DoubleValue ATTACK_SPEED_VULPUS_AXE;

    // Shovel Stats
    public static ModConfigSpec.IntValue ATTACK_DAMAGE_VULPUS_SHOVEL;
    public static ModConfigSpec.DoubleValue ATTACK_SPEED_VULPUS_SHOVEL;

    // Sword Stats
    public static ModConfigSpec.IntValue ATTACK_DAMAGE_VULPUS_SWORD;
    public static ModConfigSpec.DoubleValue ATTACK_SPEED_VULPUS_SWORD;

    // Hoe Stats
    public static ModConfigSpec.IntValue ATTACK_DAMAGE_VULPUS_HOE;
    public static ModConfigSpec.DoubleValue ATTACK_SPEED_VULPUS_HOE;

    // Paxel Stats
    public static ModConfigSpec.IntValue ATTACK_DAMAGE_VULPUS_PAXEL;
    public static ModConfigSpec.DoubleValue ATTACK_SPEED_VULPUS_PAXEL;

    // Hammer Stats
    public static ModConfigSpec.IntValue ATTACK_DAMAGE_VULPUS_HAMMER;
    public static ModConfigSpec.DoubleValue ATTACK_SPEED_VULPUS_HAMMER;
    public static ModConfigSpec.IntValue RADIUS_VULPUS_HAMMER;

    // Excavator Stats
    public static ModConfigSpec.IntValue ATTACK_DAMAGE_VULPUS_EXCAVATOR;
    public static ModConfigSpec.DoubleValue ATTACK_SPEED_VULPUS_EXCAVATOR;
    public static ModConfigSpec.IntValue RADIUS_VULPUS_EXCAVATOR;

    static {
        final var BUILDER = new ModConfigSpec.Builder();

        BUILDER.push("Armor Protection and Resistance");
        TOUGHNESS_VALUE_VULPUS_ARMOR = BUILDER
                .comment("Toughness value for Vulpus Armor | Default Value = 7")
                .defineInRange("toughnessValueVulpusArmor", 7, 0, Integer.MAX_VALUE);
        ENCHANTMENT_VALUE_VULPUS_ARMOR = BUILDER
                .comment("Enchantment value for Vulpus Armor | Default Value = 65")
                .defineInRange("enchantmentValueVulpusArmor", 65, 0, Integer.MAX_VALUE);
        KNOCKBACK_RESISTANCE_VALUE_VULPUS_ARMOR = BUILDER
                .comment("Knockback resistance for Vulpus Armor | Default Value = 0.3")
                .defineInRange("knockbackResistanceValueVulpusArmor", 0.3, 0, Double.MAX_VALUE);
        PROTECTION_VALUE_VULPUS_BOOTS = BUILDER
                .comment("Protection value for Vulpus Boots | Default Value = 9")
                .defineInRange("protectionValueVulpusBoots", 9, 0, Integer.MAX_VALUE);
        PROTECTION_VALUE_VULPUS_LEGGINGS = BUILDER
                .comment("Protection value for Vulpus Leggings | Default Value = 12")
                .defineInRange("protectionValueVulpusLeggings", 12, 0, Integer.MAX_VALUE);
        PROTECTION_VALUE_VULPUS_CHESTPLATE = BUILDER
                .comment("Protection value for Vulpus Chestplate | Default Value = 16")
                .defineInRange("protectionValueVulpusChestplate", 16, 0, Integer.MAX_VALUE);
        PROTECTION_VALUE_VULPUS_HELMET = BUILDER
                .comment("Protection value for Vulpus Helmet | Default Value = 9")
                .defineInRange("protectionValueVulpusHelmet", 9, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        BUILDER.push("Armor Special Effects and Abilities");
        SPEED_II_VULPUS_ARMOR = BUILDER
                .comment("Whether Vulpus Armor gives Speed II | Default Value = true")
                .define("speedIIVulpusArmor", true);
        JUMP_II_VULPUS_ARMOR = BUILDER
                .comment("Whether Vulpus Armor gives Jump II | Default Value = true")
                .define("jumpIIVulpusArmor", true);
        NIGHT_VISION_VULPUS_ARMOR = BUILDER
                .comment("Whether Vulpus Armor gives Night Vision | Default Value = true")
                .define("nightVisionVulpusArmor", true);
        FIRE_RESISTANCE_VULPUS_ARMOR = BUILDER
                .comment("Whether Vulpus Armor gives Fire Resistance | Default Value = true")
                .define("fireResistanceVulpusArmor", true);
        IMMUNE_TO_FALL_DAMAGE_VULPUS_ARMOR = BUILDER
                .comment("Whether Vulpus Armor gives Immunity to Fall Damage | Default Value = true")
                .define("immuneToFallDamageVulpusArmor", true);
        NEVER_LOSE_HUNGER_VULPUS_ARMOR = BUILDER
                .comment("Whether Vulpus Armor prevents Hunger loss | Default Value = true")
                .define("neverLoseHungerVulpusArmor", true);
        CAN_WALK_ON_POWDERED_SNOW_VULPUS = BUILDER
                .comment("Whether Vulpus Armor allows walking on Powdered Snow | Default Value = true")
                .define("canWalkOnPowderedSnowVulpus", true);
        MAKES_PIGLINS_NEUTRAL_VULPUS = BUILDER
                .comment("Whether Vulpus Armor makes Piglins Neutral | Default Value = true")
                .define("makesPiglinsNeutralVulpus", true);
        BUILDER.pop();

        BUILDER.push("Bow Settings");
        ENCHANTMENT_VALUE_VULPUS_BOW = BUILDER
                .comment("Enchantment value for Vulpus Bow | Default Value = 5")
                .defineInRange("enchantmentValueVulpusBow", 5, 0, Integer.MAX_VALUE);
        DAMAGE_VULPUS_BOW = BUILDER
                .comment("Damage of Vulpus Bow | Default Value = 10")
                .defineInRange("damageVulpusBow", 10, 0, Integer.MAX_VALUE);
        ARROW_COUNT_VULPUS_BOW = BUILDER
                .comment("Arrow count for Vulpus Bow | Default = 3")
                .defineInRange("arrowCountVulpusBow", 3, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        BUILDER.push("Tool Tier Base Properties");
        SPEED_VULPUS_TIER = BUILDER
                .comment("Speed value of Vulpus Tool Tier | Default Value = 40")
                .defineInRange("speedVulpusTier", 40, 0, Integer.MAX_VALUE);
        ATTACK_DAMAGE_BONUS_VULPUS_TIER = BUILDER
                .comment("Bonus attack damage for Vulpus Tool Tier | Default Value = 3")
                .defineInRange("attackDamageBonusVulpusTier", 3, 0, Integer.MAX_VALUE);
        ENCHANTMENT_VALUE_VULPUS_TIER = BUILDER
                .comment("Enchantment value for Vulpus Tool Tier | Default Value = 65")
                .defineInRange("enchantmentValueVulpusTier", 65, 0, Integer.MAX_VALUE);
        DURABILITY_VULPUS = BUILDER
                .comment("Durability of Vulpus tools | Default Value = 3093")
                .defineInRange("durabilityVulpus", 3093, 0, Integer.MAX_VALUE);
        UNBREAKABLE_VULPUS = BUILDER
                .comment("Whether Vulpus is unbreakable | Default Value = false")
                .define("unbreakableVulpus", false);
        BUILDER.pop();

        BUILDER.push("Pickaxe Stats");
        ATTACK_DAMAGE_VULPUS_PICKAXE = BUILDER
                .comment("Attack damage of Vulpus Pickaxe | Default Value = 10")
                .defineInRange("attackDamageVulpusPickaxe", 10, 0, Integer.MAX_VALUE);
        ATTACK_SPEED_VULPUS_PICKAXE = BUILDER
                .comment("Attack speed of Vulpus Pickaxe | Default Value = 0.5")
                .defineInRange("attackSpeedVulpusPickaxe", 0.5, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Axe Stats");
        ATTACK_DAMAGE_VULPUS_AXE = BUILDER
                .comment("Attack damage of Vulpus Axe | Default Value = 15")
                .defineInRange("attackDamageVulpusAxe", 15, 0, Integer.MAX_VALUE);
        ATTACK_SPEED_VULPUS_AXE = BUILDER
                .comment("Attack speed of Vulpus Axe | Default Value = 0.5")
                .defineInRange("attackSpeedVulpusAxe", 0.5, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Shovel Stats");
        ATTACK_DAMAGE_VULPUS_SHOVEL = BUILDER
                .comment("Attack damage of Vulpus Shovel | Default Value = 10")
                .defineInRange("attackDamageVulpusShovel", 10, 0, Integer.MAX_VALUE);
        ATTACK_SPEED_VULPUS_SHOVEL = BUILDER
                .comment("Attack speed of Vulpus Shovel | Default Value = 0.5")
                .defineInRange("attackSpeedVulpusShovel", 0.5, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Sword Stats");
        ATTACK_DAMAGE_VULPUS_SWORD = BUILDER
                .comment("Attack damage of Vulpus Sword | Default Value = 14")
                .defineInRange("attackDamageVulpusSword", 14, 0, Integer.MAX_VALUE);
        ATTACK_SPEED_VULPUS_SWORD = BUILDER
                .comment("Attack speed of Vulpus Sword | Default Value = 0.5")
                .defineInRange("attackSpeedVulpusSword", 0.5, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Hoe Stats");
        ATTACK_DAMAGE_VULPUS_HOE = BUILDER
                .comment("Attack damage of Vulpus Hoe | Default Value = 10")
                .defineInRange("attackDamageVulpusHoe", 10, 0, Integer.MAX_VALUE);
        ATTACK_SPEED_VULPUS_HOE = BUILDER
                .comment("Attack speed of Vulpus Hoe | Default Value = 0.5")
                .defineInRange("attackSpeedVulpusHoe", 0.5, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Paxel Stats");
        ATTACK_DAMAGE_VULPUS_PAXEL = BUILDER
                .comment("Attack damage of Vulpus Paxel | Default Value = 15")
                .defineInRange("attackDamageVulpusPaxel", 15, 0, Integer.MAX_VALUE);
        ATTACK_SPEED_VULPUS_PAXEL = BUILDER
                .comment("Attack speed of Vulpus Paxel | Default Value = 0.5")
                .defineInRange("attackSpeedVulpusPaxel", 0.5, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Hammer Stats");
        ATTACK_DAMAGE_VULPUS_HAMMER = BUILDER
                .comment("Attack damage of Vulpus Hammer | Default Value = 11")
                .defineInRange("attackDamageVulpusHammer", 11, 0, Integer.MAX_VALUE);
        ATTACK_SPEED_VULPUS_HAMMER = BUILDER
                .comment("Attack speed of Vulpus Hammer | Default Value = 0.5")
                .defineInRange("attackSpeedVulpusHammer", 0.5, 0.0, 1024.0);
        RADIUS_VULPUS_HAMMER = BUILDER
                .comment("Radius of Vulpus Hammer effect | Default Value = 2")
                .defineInRange("radiusVulpusHammer", 2, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        BUILDER.push("Excavator Stats");
        ATTACK_DAMAGE_VULPUS_EXCAVATOR = BUILDER
                .comment("Attack damage of Vulpus Excavator | Default Value = 11")
                .defineInRange("attackDamageVulpusExcavator", 11, 0, Integer.MAX_VALUE);
        ATTACK_SPEED_VULPUS_EXCAVATOR = BUILDER
                .comment("Attack speed of Vulpus Excavator | Default Value = 0.5")
                .defineInRange("attackSpeedVulpusExcavator", 0.5, 0.0, 1024.0);
        RADIUS_VULPUS_EXCAVATOR = BUILDER
                .comment("Radius of Vulpus Excavator effect | Default Value = 2")
                .defineInRange("radiusVulpusExcavator", 2, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        COMMON = BUILDER.build();
    }
}