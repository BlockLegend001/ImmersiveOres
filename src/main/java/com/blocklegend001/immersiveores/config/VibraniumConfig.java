package com.blocklegend001.immersiveores.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class VibraniumConfig {
    public static final ModConfigSpec COMMON;

    // Armor Protection and Resistance
    public static ModConfigSpec.IntValue TOUGHNESS_VALUE_VIBRANIUM_ARMOR;
    public static ModConfigSpec.IntValue ENCHANTMENT_VALUE_VIBRANIUM_ARMOR;
    public static ModConfigSpec.IntValue KNOCKBACK_RESISTANCE_VALUE_VIBRANIUM_ARMOR;
    public static ModConfigSpec.IntValue PROTECTION_VALUE_VIBRANIUM_BOOTS;
    public static ModConfigSpec.IntValue PROTECTION_VALUE_VIBRANIUM_LEGGINGS;
    public static ModConfigSpec.IntValue PROTECTION_VALUE_VIBRANIUM_CHESTPLATE;
    public static ModConfigSpec.IntValue PROTECTION_VALUE_VIBRANIUM_HELMET;

    // Armor Special Effects and Abilities
    public static ModConfigSpec.BooleanValue SPEED_I_VIBRANIUM_ARMOR;
    public static ModConfigSpec.BooleanValue JUMP_I_VIBRANIUM_ARMOR;
    public static ModConfigSpec.BooleanValue NIGHT_VISION_VIBRANIUM_ARMOR;
    public static ModConfigSpec.BooleanValue CAN_WALK_ON_POWDERED_SNOW_VIBRANIUM;

    // Bow Settings
    public static ModConfigSpec.IntValue ENCHANTMENT_VALUE_VIBRANIUM_BOW;
    public static ModConfigSpec.IntValue DAMAGE_VIBRANIUM_BOW;
    public static ModConfigSpec.IntValue ARROW_COUNT_VIBRANIUM_BOW;

    // Tool Tier Base Properties
    public static ModConfigSpec.IntValue SPEED_VIBRANIUM_TIER;
    public static ModConfigSpec.IntValue ATTACK_DAMAGE_BONUS_VIBRANIUM_TIER;
    public static ModConfigSpec.IntValue ENCHANTMENT_VALUE_VIBRANIUM_TIER;
    public static ModConfigSpec.IntValue DURABILITY_VIBRANIUM;
    public static ModConfigSpec.BooleanValue UNBREAKABLE_VIBRANIUM;

    // Pickaxe Stats
    public static ModConfigSpec.IntValue ATTACK_DAMAGE_VIBRANIUM_PICKAXE;
    public static ModConfigSpec.DoubleValue ATTACK_SPEED_VIBRANIUM_PICKAXE;

    // Axe Stats
    public static ModConfigSpec.IntValue ATTACK_DAMAGE_VIBRANIUM_AXE;
    public static ModConfigSpec.DoubleValue ATTACK_SPEED_VIBRANIUM_AXE;

    // Shovel Stats
    public static ModConfigSpec.IntValue ATTACK_DAMAGE_VIBRANIUM_SHOVEL;
    public static ModConfigSpec.DoubleValue ATTACK_SPEED_VIBRANIUM_SHOVEL;

    // Sword Stats
    public static ModConfigSpec.IntValue ATTACK_DAMAGE_VIBRANIUM_SWORD;
    public static ModConfigSpec.DoubleValue ATTACK_SPEED_VIBRANIUM_SWORD;

    // Hoe Stats
    public static ModConfigSpec.IntValue ATTACK_DAMAGE_VIBRANIUM_HOE;
    public static ModConfigSpec.DoubleValue ATTACK_SPEED_VIBRANIUM_HOE;

    // Paxel Stats
    public static ModConfigSpec.IntValue ATTACK_DAMAGE_VIBRANIUM_PAXEL;
    public static ModConfigSpec.DoubleValue ATTACK_SPEED_VIBRANIUM_PAXEL;

    // Hammer Stats
    public static ModConfigSpec.IntValue ATTACK_DAMAGE_VIBRANIUM_HAMMER;
    public static ModConfigSpec.DoubleValue ATTACK_SPEED_VIBRANIUM_HAMMER;
    public static ModConfigSpec.IntValue RADIUS_VIBRANIUM_HAMMER;

    // Excavator Stats
    public static ModConfigSpec.IntValue ATTACK_DAMAGE_VIBRANIUM_EXCAVATOR;
    public static ModConfigSpec.DoubleValue ATTACK_SPEED_VIBRANIUM_EXCAVATOR;
    public static ModConfigSpec.IntValue RADIUS_VIBRANIUM_EXCAVATOR;

    static {
        final var BUILDER = new ModConfigSpec.Builder();

        BUILDER.push("Armor Protection and Resistance");
        TOUGHNESS_VALUE_VIBRANIUM_ARMOR = BUILDER
                .comment("Toughness value for Vibranium Armor | Default Value = 3")
                .defineInRange("toughnessValueVibraniumArmor", 3, 0, Integer.MAX_VALUE);
        ENCHANTMENT_VALUE_VIBRANIUM_ARMOR = BUILDER
                .comment("Enchantment value for Vibranium Armor | Default Value = 55")
                .defineInRange("enchantmentValueVibraniumArmor", 55, 0, Integer.MAX_VALUE);
        KNOCKBACK_RESISTANCE_VALUE_VIBRANIUM_ARMOR = BUILDER
                .comment("Knockback resistance for Vibranium Armor | Default Value = 1")
                .defineInRange("knockbackResistanceValueVibraniumArmor", 1, 0, Integer.MAX_VALUE);
        PROTECTION_VALUE_VIBRANIUM_BOOTS = BUILDER
                .comment("Protection value for Vibranium Boots | Default Value = 6")
                .defineInRange("protectionValueVibraniumBoots", 6, 0, Integer.MAX_VALUE);
        PROTECTION_VALUE_VIBRANIUM_LEGGINGS = BUILDER
                .comment("Protection value for Vibranium Leggings | Default Value = 9")
                .defineInRange("protectionValueVibraniumLeggings", 9, 0, Integer.MAX_VALUE);
        PROTECTION_VALUE_VIBRANIUM_CHESTPLATE = BUILDER
                .comment("Protection value for Vibranium Chestplate | Default Value = 12")
                .defineInRange("protectionValueVibraniumChestplate", 12, 0, Integer.MAX_VALUE);
        PROTECTION_VALUE_VIBRANIUM_HELMET = BUILDER
                .comment("Protection value for Vibranium Helmet | Default Value = 6")
                .defineInRange("protectionValueVibraniumHelmet", 6, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        BUILDER.push("Armor Special Effects and Abilities");
        SPEED_I_VIBRANIUM_ARMOR = BUILDER
                .comment("Whether Vibranium Armor gives Speed I | Default Value = true")
                .define("speedIVibraniumArmor", true);
        JUMP_I_VIBRANIUM_ARMOR = BUILDER
                .comment("Whether Vibranium Armor gives Jump I | Default Value = true")
                .define("jumpIVibraniumArmor", true);
        NIGHT_VISION_VIBRANIUM_ARMOR = BUILDER
                .comment("Whether Vibranium Armor gives Night Vision | Default Value = true")
                .define("nightVisionVibraniumArmor", true);
        CAN_WALK_ON_POWDERED_SNOW_VIBRANIUM = BUILDER
                .comment("Whether Vibranium Armor allows walking on Powdered Snow | Default Value = true")
                .define("canWalkOnPowderedSnowVibranium", true);
        BUILDER.pop();

        BUILDER.push("Bow Settings");
        ENCHANTMENT_VALUE_VIBRANIUM_BOW = BUILDER
                .comment("Enchantment value for Vibranium Bow | Default Value = 5")
                .defineInRange("enchantmentValueVibraniumBow", 5, 0, Integer.MAX_VALUE);
        DAMAGE_VIBRANIUM_BOW = BUILDER
                .comment("Damage of Vibranium Bow | Default Value = 5")
                .defineInRange("damageVibraniumBow", 5, 0, Integer.MAX_VALUE);
        ARROW_COUNT_VIBRANIUM_BOW = BUILDER
                .comment("Arrow count for Vibranium Bow | Default = 2")
                .defineInRange("arrowCountVibraniumBow", 2, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        BUILDER.push("Tool Tier Base Properties");
        SPEED_VIBRANIUM_TIER = BUILDER
                .comment("Speed value of Vibranium Tool Tier | Default Value = 30")
                .defineInRange("speedVibraniumTier", 30, 0, Integer.MAX_VALUE);
        ATTACK_DAMAGE_BONUS_VIBRANIUM_TIER = BUILDER
                .comment("Bonus attack damage for Vibranium Tool Tier | Default Value = 1")
                .defineInRange("attackDamageBonusVibraniumTier", 1, 0, Integer.MAX_VALUE);
        ENCHANTMENT_VALUE_VIBRANIUM_TIER = BUILDER
                .comment("Enchantment value for Vibranium Tool Tier | Default Value = 55")
                .defineInRange("enchantmentValueVibraniumTier", 55, 0, Integer.MAX_VALUE);
        DURABILITY_VIBRANIUM = BUILDER
                .comment("Durability of Vibranium tools | Default Value = 2562")
                .defineInRange("durabilityVibranium", 2562, 0, Integer.MAX_VALUE);
        UNBREAKABLE_VIBRANIUM = BUILDER
                .comment("Whether Vibranium is unbreakable | Default Value = false")
                .define("unbreakableVibranium", false);
        BUILDER.pop();

        BUILDER.push("Pickaxe Stats");
        ATTACK_DAMAGE_VIBRANIUM_PICKAXE = BUILDER
                .comment("Attack damage of Vibranium Pickaxe | Default Value = 7")
                .defineInRange("attackDamageVibraniumPickaxe", 7, 0, Integer.MAX_VALUE);
        ATTACK_SPEED_VIBRANIUM_PICKAXE = BUILDER
                .comment("Attack speed of Vibranium Pickaxe | Default Value = 0.5")
                .defineInRange("attackSpeedVibraniumPickaxe", 0.5, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Axe Stats");
        ATTACK_DAMAGE_VIBRANIUM_AXE = BUILDER
                .comment("Attack damage of Vibranium Axe | Default Value = 12")
                .defineInRange("attackDamageVibraniumAxe", 12, 0, Integer.MAX_VALUE);
        ATTACK_SPEED_VIBRANIUM_AXE = BUILDER
                .comment("Attack speed of Vibranium Axe | Default Value = 0.5")
                .defineInRange("attackSpeedVibraniumAxe", 0.5, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Shovel Stats");
        ATTACK_DAMAGE_VIBRANIUM_SHOVEL = BUILDER
                .comment("Attack damage of Vibranium Shovel | Default Value = 7")
                .defineInRange("attackDamageVibraniumShovel", 7, 0, Integer.MAX_VALUE);
        ATTACK_SPEED_VIBRANIUM_SHOVEL = BUILDER
                .comment("Attack speed of Vibranium Shovel | Default Value = 0.5")
                .defineInRange("attackSpeedVibraniumShovel", 0.5, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Sword Stats");
        ATTACK_DAMAGE_VIBRANIUM_SWORD = BUILDER
                .comment("Attack damage of Vibranium Sword | Default Value = 10")
                .defineInRange("attackDamageVibraniumSword", 10, 0, Integer.MAX_VALUE);
        ATTACK_SPEED_VIBRANIUM_SWORD = BUILDER
                .comment("Attack speed of Vibranium Sword | Default Value = 0.5")
                .defineInRange("attackSpeedVibraniumSword", 0.5, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Hoe Stats");
        ATTACK_DAMAGE_VIBRANIUM_HOE = BUILDER
                .comment("Attack damage of Vibranium Hoe | Default Value = 7")
                .defineInRange("attackDamageVibraniumHoe", 7, 0, Integer.MAX_VALUE);
        ATTACK_SPEED_VIBRANIUM_HOE = BUILDER
                .comment("Attack speed of Vibranium Hoe | Default Value = 0.5")
                .defineInRange("attackSpeedVibraniumHoe", 0.5, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Paxel Stats");
        ATTACK_DAMAGE_VIBRANIUM_PAXEL = BUILDER
                .comment("Attack damage of Vibranium Paxel | Default Value = 11")
                .defineInRange("attackDamageVibraniumPaxel", 11, 0, Integer.MAX_VALUE);
        ATTACK_SPEED_VIBRANIUM_PAXEL = BUILDER
                .comment("Attack speed of Vibranium Paxel | Default Value = 0.5")
                .defineInRange("attackSpeedVibraniumPaxel", 0.5, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Hammer Stats");
        ATTACK_DAMAGE_VIBRANIUM_HAMMER = BUILDER
                .comment("Attack damage of Vibranium Hammer | Default Value = 7")
                .defineInRange("attackDamageVibraniumHammer", 7, 0, Integer.MAX_VALUE);
        ATTACK_SPEED_VIBRANIUM_HAMMER = BUILDER
                .comment("Attack speed of Vibranium Hammer | Default Value = 0.5")
                .defineInRange("attackSpeedVibraniumHammer", 0.5, 0.0, 1024.0);
        RADIUS_VIBRANIUM_HAMMER = BUILDER
                .comment("Hammering radius for Vibranium Hammer | Default = 1")
                .defineInRange("radiusVibraniumHammer", 1, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        BUILDER.push("Excavator Stats");
        ATTACK_DAMAGE_VIBRANIUM_EXCAVATOR = BUILDER
                .comment("Attack damage of Vibranium Excavator | Default Value = 7")
                .defineInRange("attackDamageVibraniumExcavator", 7, 0, Integer.MAX_VALUE);
        ATTACK_SPEED_VIBRANIUM_EXCAVATOR = BUILDER
                .comment("Attack speed of Vibranium Excavator | Default Value = 0.5")
                .defineInRange("attackSpeedVibraniumExcavator", 0.5, 0.0, 1024.0);
        RADIUS_VIBRANIUM_EXCAVATOR = BUILDER
                .comment("Excavation radius for Vibranium Excavator | Default = 1")
                .defineInRange("radiusVibraniumExcavator", 1, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        COMMON = BUILDER.build();
    }
}