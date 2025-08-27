package com.blocklegend001.immersiveores.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class EnderiumConfig {
    public static final ModConfigSpec COMMON;

    public static ModConfigSpec.IntValue TOUGHNESS_VALUE_ENDERIUM_ARMOR;
    public static ModConfigSpec.IntValue ENCHANTMENT_VALUE_ENDERIUM_ARMOR;
    public static ModConfigSpec.IntValue KNOCKBACK_RESISTANCE_VALUE_ENDERIUM_ARMOR;
    public static ModConfigSpec.IntValue PROTECTION_VALUE_ENDERIUM_BOOTS;
    public static ModConfigSpec.IntValue PROTECTION_VALUE_ENDERIUM_LEGGINGS;
    public static ModConfigSpec.IntValue PROTECTION_VALUE_ENDERIUM_CHESTPLATE;
    public static ModConfigSpec.IntValue PROTECTION_VALUE_ENDERIUM_HELMET;

    public static ModConfigSpec.BooleanValue SPEED_III_ENDERIUM_ARMOR;
    public static ModConfigSpec.BooleanValue JUMP_III_ENDERIUM_ARMOR;
    public static ModConfigSpec.BooleanValue NIGHT_VISION_ENDERIUM_ARMOR;
    public static ModConfigSpec.BooleanValue IMMUNE_TO_FALL_DAMAGE_ENDERIUM_ARMOR;
    public static ModConfigSpec.BooleanValue FIRE_RESISTANCE_ENDERIUM_ARMOR;
    public static ModConfigSpec.BooleanValue NEVER_LOSE_HUNGER_ENDERIUM_ARMOR;
    public static ModConfigSpec.BooleanValue CAN_FLY_ENDERIUM_ARMOR;
    public static ModConfigSpec.BooleanValue CAN_WALK_ON_POWDERED_SNOW_ENDERIUM;
    public static ModConfigSpec.BooleanValue MAKES_PIGLINS_NEUTRAL_ENDERIUM;
    public static ModConfigSpec.BooleanValue ENDERMAN_WILL_NOT_BE_ANGRY_WITH_YOU_ENDERIUM;

    public static ModConfigSpec.IntValue ENCHANTMENT_VALUE_ENDERIUM_BOW;
    public static ModConfigSpec.IntValue DAMAGE_ENDERIUM_BOW;
    public static ModConfigSpec.IntValue ARROW_COUNT_ENDERIUM_BOW;

    public static ModConfigSpec.IntValue SPEED_ENDERIUM_TIER;
    public static ModConfigSpec.IntValue ATTACK_DAMAGE_BONUS_ENDERIUM_TIER;
    public static ModConfigSpec.IntValue ENCHANTMENT_VALUE_ENDERIUM_TIER;

    public static ModConfigSpec.IntValue DURABILITY_ENDERIUM;
    public static ModConfigSpec.BooleanValue UNBREAKABLE_ENDERIUM;

    public static ModConfigSpec.IntValue ATTACK_DAMAGE_ENDERIUM_PICKAXE;
    public static ModConfigSpec.DoubleValue ATTACK_SPEED_ENDERIUM_PICKAXE;

    public static ModConfigSpec.IntValue ATTACK_DAMAGE_ENDERIUM_AXE;
    public static ModConfigSpec.DoubleValue ATTACK_SPEED_ENDERIUM_AXE;

    public static ModConfigSpec.IntValue ATTACK_DAMAGE_ENDERIUM_SHOVEL;
    public static ModConfigSpec.DoubleValue ATTACK_SPEED_ENDERIUM_SHOVEL;

    public static ModConfigSpec.IntValue ATTACK_DAMAGE_ENDERIUM_SWORD;
    public static ModConfigSpec.DoubleValue ATTACK_SPEED_ENDERIUM_SWORD;

    public static ModConfigSpec.IntValue ATTACK_DAMAGE_ENDERIUM_HOE;
    public static ModConfigSpec.DoubleValue ATTACK_SPEED_ENDERIUM_HOE;

    public static ModConfigSpec.IntValue ATTACK_DAMAGE_ENDERIUM_PAXEL;
    public static ModConfigSpec.DoubleValue ATTACK_SPEED_ENDERIUM_PAXEL;

    public static ModConfigSpec.IntValue ATTACK_DAMAGE_ENDERIUM_HAMMER;
    public static ModConfigSpec.DoubleValue ATTACK_SPEED_ENDERIUM_HAMMER;

    public static ModConfigSpec.IntValue ATTACK_DAMAGE_ENDERIUM_EXCAVATOR;
    public static ModConfigSpec.DoubleValue ATTACK_SPEED_ENDERIUM_EXCAVATOR;

    public static ModConfigSpec.IntValue RADIUS_ENDERIUM_HAMMER;
    public static ModConfigSpec.IntValue RADIUS_ENDERIUM_EXCAVATOR;

    static {
        final var BUILDER = new ModConfigSpec.Builder();

        BUILDER.push("Armor Protection and Resistance");
        TOUGHNESS_VALUE_ENDERIUM_ARMOR = BUILDER
                .comment("Toughness value for Enderium Armor | Default Value = 10")
                .defineInRange("toughnessValueEnderiumArmor", 10, 0, Integer.MAX_VALUE);
        ENCHANTMENT_VALUE_ENDERIUM_ARMOR = BUILDER
                .comment("Enchantment value for Enderium Armor | Default Value = 65")
                .defineInRange("enchantmentValueEnderiumArmor", 65, 0, Integer.MAX_VALUE);
        KNOCKBACK_RESISTANCE_VALUE_ENDERIUM_ARMOR = BUILDER
                .comment("Knockback resistance for Enderium Armor | Default Value = 3")
                .defineInRange("knockbackResistanceValueEnderiumArmor", 3, 0, Integer.MAX_VALUE);
        PROTECTION_VALUE_ENDERIUM_BOOTS = BUILDER
                .comment("Protection value for Enderium Boots | Default Value = 12")
                .defineInRange("protectionValueEnderiumBoots", 12, 0, Integer.MAX_VALUE);
        PROTECTION_VALUE_ENDERIUM_LEGGINGS = BUILDER
                .comment("Protection value for Enderium Leggings | Default Value = 16")
                .defineInRange("protectionValueEnderiumLeggings", 16, 0, Integer.MAX_VALUE);
        PROTECTION_VALUE_ENDERIUM_CHESTPLATE = BUILDER
                .comment("Protection value for Enderium Chestplate | Default Value = 20")
                .defineInRange("protectionValueEnderiumChestplate", 20, 0, Integer.MAX_VALUE);
        PROTECTION_VALUE_ENDERIUM_HELMET = BUILDER
                .comment("Protection value for Enderium Helmet | Default Value = 12")
                .defineInRange("protectionValueEnderiumHelmet", 12, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        BUILDER.push("Armor Special Effects and Abilities");
        SPEED_III_ENDERIUM_ARMOR = BUILDER
                .comment("Whether Enderium Armor gives Speed III | Default Value = true")
                .define("speedIIIEnderiumArmor", true);
        JUMP_III_ENDERIUM_ARMOR = BUILDER
                .comment("Whether Enderium Armor gives Jump III | Default Value = true")
                .define("jumpIIIEnderiumArmor", true);
        NIGHT_VISION_ENDERIUM_ARMOR = BUILDER
                .comment("Whether Enderium Armor gives Night Vision | Default Value = true")
                .define("nightVisionEnderiumArmor", true);
        IMMUNE_TO_FALL_DAMAGE_ENDERIUM_ARMOR = BUILDER
                .comment("Whether Enderium Armor negates fall damage | Default Value = true")
                .define("immuneToFallDamageEnderiumArmor", true);
        FIRE_RESISTANCE_ENDERIUM_ARMOR = BUILDER
                .comment("Whether Enderium Armor grants fire resistance | Default Value = true")
                .define("fireResistanceEnderiumArmor", true);
        NEVER_LOSE_HUNGER_ENDERIUM_ARMOR = BUILDER
                .comment("Whether Enderium Armor prevents hunger loss | Default Value = true")
                .define("neverLoseHungerEnderiumArmor", true);
        CAN_FLY_ENDERIUM_ARMOR = BUILDER
                .comment("Whether Enderium Armor allows flight | Default Value = true")
                .define("canFlyEnderiumArmor", true);
        CAN_WALK_ON_POWDERED_SNOW_ENDERIUM = BUILDER
                .comment("Whether Enderium Armor allows walking on Powdered Snow | Default Value = true")
                .define("canWalkOnPowderedSnowEnderium", true);
        MAKES_PIGLINS_NEUTRAL_ENDERIUM = BUILDER
                .comment("Whether Enderium Armor makes Piglins neutral | Default Value = true")
                .define("makesPiglinsNeutralEnderium", true);
        ENDERMAN_WILL_NOT_BE_ANGRY_WITH_YOU_ENDERIUM = BUILDER
                .comment("Whether Endermen will not be angry at player wearing Enderium Armor | Default Value = true")
                .define("endermanWillNotBeAngryWithYouEnderium", true);
        BUILDER.pop();

        BUILDER.push("Bow Settings");
        ENCHANTMENT_VALUE_ENDERIUM_BOW = BUILDER
                .comment("Enchantment value for Enderium Bow | Default Value = 5")
                .defineInRange("enchantmentValueEnderiumBow", 5, 0, Integer.MAX_VALUE);
        DAMAGE_ENDERIUM_BOW = BUILDER
                .comment("Damage of Enderium Bow | Default Value = 14")
                .defineInRange("damageEnderiumBow", 14, 0, Integer.MAX_VALUE);
        ARROW_COUNT_ENDERIUM_BOW = BUILDER
                .comment("Arrow count for Enderium Bow | Default = 4")
                .defineInRange("arrowCountEnderiumBow", 4, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        BUILDER.push("Tool Tier Base Properties");
        SPEED_ENDERIUM_TIER = BUILDER
                .comment("Speed value of Enderium Tool Tier | Default Value = 50")
                .defineInRange("speedEnderiumTier", 50, 0, Integer.MAX_VALUE);
        ATTACK_DAMAGE_BONUS_ENDERIUM_TIER = BUILDER
                .comment("Bonus attack damage for Enderium Tool Tier | Default Value = 3")
                .defineInRange("attackDamageBonusEnderiumTier", 3, 0, Integer.MAX_VALUE);
        ENCHANTMENT_VALUE_ENDERIUM_TIER = BUILDER
                .comment("Enchantment value for Enderium Tool Tier | Default Value = 65")
                .defineInRange("enchantmentValueEnderiumTier", 65, 0, Integer.MAX_VALUE);
        DURABILITY_ENDERIUM = BUILDER
                .comment("Durability of Enderium tools | Default Value = 5139")
                .defineInRange("durabilityEnderium", 5139, 0, Integer.MAX_VALUE);
        UNBREAKABLE_ENDERIUM = BUILDER
                .comment("Whether Enderium is unbreakable | Default Value = false")
                .define("unbreakableEnderium", false);
        BUILDER.pop();

        BUILDER.push("Pickaxe Stats");
        ATTACK_DAMAGE_ENDERIUM_PICKAXE = BUILDER
                .comment("Attack damage of Enderium Pickaxe | Default Value = 15")
                .defineInRange("attackDamageEnderiumPickaxe", 15, 0, Integer.MAX_VALUE);
        ATTACK_SPEED_ENDERIUM_PICKAXE = BUILDER
                .comment("Attack speed of Enderium Pickaxe | Default Value = 1.0")
                .defineInRange("attackSpeedEnderiumPickaxe", 1.0, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Axe Stats");
        ATTACK_DAMAGE_ENDERIUM_AXE = BUILDER
                .comment("Attack damage of Enderium Axe | Default Value = 18")
                .defineInRange("attackDamageEnderiumAxe", 18, 0, Integer.MAX_VALUE);
        ATTACK_SPEED_ENDERIUM_AXE = BUILDER
                .comment("Attack speed of Enderium Axe | Default Value = 1.0")
                .defineInRange("attackSpeedEnderiumAxe", 1.0, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Shovel Stats");
        ATTACK_DAMAGE_ENDERIUM_SHOVEL = BUILDER
                .comment("Attack damage of Enderium Shovel | Default Value = 15")
                .defineInRange("attackDamageEnderiumShovel", 15, 0, Integer.MAX_VALUE);
        ATTACK_SPEED_ENDERIUM_SHOVEL = BUILDER
                .comment("Attack speed of Enderium Shovel | Default Value = 1.0")
                .defineInRange("attackSpeedEnderiumShovel", 1.0, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Sword Stats");
        ATTACK_DAMAGE_ENDERIUM_SWORD = BUILDER
                .comment("Attack damage of Enderium Sword | Default Value = 22")
                .defineInRange("attackDamageEnderiumSword", 22, 0, Integer.MAX_VALUE);
        ATTACK_SPEED_ENDERIUM_SWORD = BUILDER
                .comment("Attack speed of Enderium Sword | Default Value = 1.0")
                .defineInRange("attackSpeedEnderiumSword", 1.0, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Hoe Stats");
        ATTACK_DAMAGE_ENDERIUM_HOE = BUILDER
                .comment("Attack damage of Enderium Hoe | Default Value = 15")
                .defineInRange("attackDamageEnderiumHoe", 15, 0, Integer.MAX_VALUE);
        ATTACK_SPEED_ENDERIUM_HOE = BUILDER
                .comment("Attack speed of Enderium Hoe | Default Value = 1.0")
                .defineInRange("attackSpeedEnderiumHoe", 1.0, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Paxel Stats");
        ATTACK_DAMAGE_ENDERIUM_PAXEL = BUILDER
                .comment("Attack damage of Enderium Paxel | Default Value = 18")
                .defineInRange("attackDamageEnderiumPaxel", 18, 0, Integer.MAX_VALUE);
        ATTACK_SPEED_ENDERIUM_PAXEL = BUILDER
                .comment("Attack speed of Enderium Paxel | Default Value = 1.0")
                .defineInRange("attackSpeedEnderiumPaxel", 1.0, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Hammer Stats");
        ATTACK_DAMAGE_ENDERIUM_HAMMER = BUILDER
                .comment("Attack damage of Enderium Hammer | Default Value = 16")
                .defineInRange("attackDamageEnderiumHammer", 16, 0, Integer.MAX_VALUE);
        ATTACK_SPEED_ENDERIUM_HAMMER = BUILDER
                .comment("Attack speed of Enderium Hammer | Default Value = 1.0")
                .defineInRange("attackSpeedEnderiumHammer", 1.0, 0.0, 1024.0);
        RADIUS_ENDERIUM_HAMMER = BUILDER
                .comment("Hammering radius for Enderium Hammer | Default = 3")
                .defineInRange("radiusEnderiumHammer", 3, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        BUILDER.push("Excavator Stats");
        ATTACK_DAMAGE_ENDERIUM_EXCAVATOR = BUILDER
                .comment("Attack damage of Enderium Excavator | Default Value = 16")
                .defineInRange("attackDamageEnderiumExcavator", 16, 0, Integer.MAX_VALUE);
        ATTACK_SPEED_ENDERIUM_EXCAVATOR = BUILDER
                .comment("Attack speed of Enderium Excavator | Default Value = 1.0")
                .defineInRange("attackSpeedEnderiumExcavator", 1.0, 0.0, 1024.0);
        RADIUS_ENDERIUM_EXCAVATOR = BUILDER
                .comment("Excavation radius for Enderium Excavator | Default = 3")
                .defineInRange("radiusEnderiumExcavator", 3, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        COMMON = BUILDER.build();
    }
}
