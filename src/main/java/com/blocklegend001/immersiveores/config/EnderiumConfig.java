package com.blocklegend001.immersiveores.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class EnderiumConfig {

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    // ---------------------------------------------
    // Armor Protection and Resistance
    // ---------------------------------------------
    public static final ForgeConfigSpec.IntValue toughnessValueEnderiumArmor;
    public static final ForgeConfigSpec.IntValue enchantmentValueEnderiumArmor;
    public static final ForgeConfigSpec.IntValue knockbackResistanceValueEnderiumArmor;
    public static final ForgeConfigSpec.IntValue protectionValueEnderiumBoots;
    public static final ForgeConfigSpec.IntValue protectionValueEnderiumLeggings;
    public static final ForgeConfigSpec.IntValue protectionValueEnderiumChestplate;
    public static final ForgeConfigSpec.IntValue protectionValueEnderiumHelmet;

    // ---------------------------------------------
    // Armor Special Effects and Abilities
    // ---------------------------------------------
    public static final ForgeConfigSpec.BooleanValue speedIIIEnderiumArmor;
    public static final ForgeConfigSpec.BooleanValue jumpIIIEnderiumArmor;
    public static final ForgeConfigSpec.BooleanValue nightVisionEnderiumArmor;
    public static final ForgeConfigSpec.BooleanValue immuneToFallDamageEnderiumArmor;
    public static final ForgeConfigSpec.BooleanValue fireResistanceEnderiumArmor;
    public static final ForgeConfigSpec.BooleanValue neverLoseHungerEnderiumArmor;
    public static final ForgeConfigSpec.BooleanValue canFlyEnderiumArmor;
    public static final ForgeConfigSpec.BooleanValue canWalkOnPowderedSnowEnderium;
    public static final ForgeConfigSpec.BooleanValue makesPiglinsNeutralEnderium;
    public static final ForgeConfigSpec.BooleanValue endermanWillNotBeAngryWithYouEnderium;

    // ---------------------------------------------
    // Bow Settings
    // ---------------------------------------------
    public static final ForgeConfigSpec.IntValue enchantmentValueEnderiumBow;
    public static final ForgeConfigSpec.IntValue damageEnderiumBow;
    public static final ForgeConfigSpec.IntValue arrowCountEnderiumBow;

    // ---------------------------------------------
    // Tool Tier Base Properties
    // ---------------------------------------------
    public static final ForgeConfigSpec.IntValue speedEnderiumTier;
    public static final ForgeConfigSpec.IntValue attackDamageBonusEnderiumTier;
    public static final ForgeConfigSpec.IntValue enchantmentValueEnderiumTier;

    // ---------------------------------------------
    // Durability / Unbreakable
    // ---------------------------------------------
    public static final ForgeConfigSpec.IntValue durabilityEnderium;
    public static final ForgeConfigSpec.BooleanValue unbreakableEnderium;

    // ---------------------------------------------
    // Pickaxe Stats
    // ---------------------------------------------
    public static final ForgeConfigSpec.IntValue attackDamageEnderiumPickaxe;
    public static final ForgeConfigSpec.DoubleValue attackSpeedEnderiumPickaxe;

    // ---------------------------------------------
    // Axe Stats
    // ---------------------------------------------
    public static final ForgeConfigSpec.IntValue attackDamageEnderiumAxe;
    public static final ForgeConfigSpec.DoubleValue attackSpeedEnderiumAxe;

    // ---------------------------------------------
    // Shovel Stats
    // ---------------------------------------------
    public static final ForgeConfigSpec.IntValue attackDamageEnderiumShovel;
    public static final ForgeConfigSpec.DoubleValue attackSpeedEnderiumShovel;

    // ---------------------------------------------
    // Sword Stats
    // ---------------------------------------------
    public static final ForgeConfigSpec.IntValue attackDamageEnderiumSword;
    public static final ForgeConfigSpec.DoubleValue attackSpeedEnderiumSword;

    // ---------------------------------------------
    // Hoe Stats
    // ---------------------------------------------
    public static final ForgeConfigSpec.IntValue attackDamageEnderiumHoe;
    public static final ForgeConfigSpec.DoubleValue attackSpeedEnderiumHoe;

    // ---------------------------------------------
    // Paxel Stats
    // ---------------------------------------------
    public static final ForgeConfigSpec.IntValue attackDamageEnderiumPaxel;
    public static final ForgeConfigSpec.DoubleValue attackSpeedEnderiumPaxel;

    // ---------------------------------------------
    // Hammer Stats
    // ---------------------------------------------
    public static final ForgeConfigSpec.IntValue attackDamageEnderiumHammer;
    public static final ForgeConfigSpec.DoubleValue attackSpeedEnderiumHammer;

    // ---------------------------------------------
    // Excavator Stats
    // ---------------------------------------------
    public static final ForgeConfigSpec.IntValue attackDamageEnderiumExcavator;
    public static final ForgeConfigSpec.DoubleValue attackSpeedEnderiumExcavator;

    // ---------------------------------------------
    // Radius (Hammer/Excavator)
    // ---------------------------------------------
    public static final ForgeConfigSpec.IntValue radiusEnderiumHammer;
    public static final ForgeConfigSpec.IntValue radiusEnderiumExcavator;

    public static final ForgeConfigSpec SPEC;

    static {
        BUILDER.push("Armor Protection and Resistance");
        toughnessValueEnderiumArmor = BUILDER
                .comment("Toughness value for Enderium Armor | Default Value = 200")
                .defineInRange("toughnessValueEnderiumArmor", 200, 0, Integer.MAX_VALUE);
        enchantmentValueEnderiumArmor = BUILDER
                .comment("Enchantment value for Enderium Armor | Default Value = 85")
                .defineInRange("enchantmentValueEnderiumArmor", 85, 0, Integer.MAX_VALUE);
        knockbackResistanceValueEnderiumArmor = BUILDER
                .comment("Knockback resistance for Enderium Armor | Default Value = 3")
                .defineInRange("knockbackResistanceValueEnderiumArmor", 3, 0, Integer.MAX_VALUE);
        protectionValueEnderiumBoots = BUILDER
                .comment("Protection value for Enderium Boots | Default Value = 30")
                .defineInRange("protectionValueEnderiumBoots", 30, 0, Integer.MAX_VALUE);
        protectionValueEnderiumLeggings = BUILDER
                .comment("Protection value for Enderium Leggings | Default Value = 50")
                .defineInRange("protectionValueEnderiumLeggings", 50, 0, Integer.MAX_VALUE);
        protectionValueEnderiumChestplate = BUILDER
                .comment("Protection value for Enderium Chestplate | Default Value = 70")
                .defineInRange("protectionValueEnderiumChestplate", 70, 0, Integer.MAX_VALUE);
        protectionValueEnderiumHelmet = BUILDER
                .comment("Protection value for Enderium Helmet | Default Value = 30")
                .defineInRange("protectionValueEnderiumHelmet", 30, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        BUILDER.push("Armor Special Effects and Abilities");
        speedIIIEnderiumArmor = BUILDER
                .comment("Whether Enderium Armor gives Speed III | Default Value = true")
                .define("speedIIIEnderiumArmor", true);
        jumpIIIEnderiumArmor = BUILDER
                .comment("Whether Enderium Armor gives Jump III | Default Value = true")
                .define("jumpIIIEnderiumArmor", true);
        nightVisionEnderiumArmor = BUILDER
                .comment("Whether Enderium Armor gives Night Vision | Default Value = true")
                .define("nightVisionEnderiumArmor", true);
        immuneToFallDamageEnderiumArmor = BUILDER
                .comment("Whether Enderium Armor negates fall damage | Default Value = true")
                .define("immuneToFallDamageEnderiumArmor", true);
        fireResistanceEnderiumArmor = BUILDER
                .comment("Whether Enderium Armor grants fire resistance | Default Value = true")
                .define("fireResistanceEnderiumArmor", true);
        neverLoseHungerEnderiumArmor = BUILDER
                .comment("Whether Enderium Armor prevents hunger loss | Default Value = true")
                .define("neverLoseHungerEnderiumArmor", true);
        canFlyEnderiumArmor = BUILDER
                .comment("Whether Enderium Armor allows flight | Default Value = true")
                .define("canFlyEnderiumArmor", true);
        canWalkOnPowderedSnowEnderium = BUILDER
                .comment("Whether Enderium Armor allows walking on Powdered Snow | Default Value = true")
                .define("canWalkOnPowderedSnowEnderium", true);
        makesPiglinsNeutralEnderium = BUILDER
                .comment("Whether Enderium Armor makes Piglins neutral | Default Value = true")
                .define("makesPiglinsNeutralEnderium", true);
        endermanWillNotBeAngryWithYouEnderium = BUILDER
                .comment("Whether Endermen will not be angry at player wearing Enderium Armor | Default Value = true")
                .define("endermanWillNotBeAngryWithYouEnderium", true);
        BUILDER.pop();

        BUILDER.push("Bow Settings");
        enchantmentValueEnderiumBow = BUILDER
                .comment("Enchantment value for Enderium Bow | Default Value = 5")
                .defineInRange("enchantmentValueEnderiumBow", 5, 0, Integer.MAX_VALUE);
        damageEnderiumBow = BUILDER
                .comment("Damage of Enderium Bow | Default Value = 14")
                .defineInRange("damageEnderiumBow", 14, 0, Integer.MAX_VALUE);
        arrowCountEnderiumBow = BUILDER
                .comment("Arrow count for Enderium Bow | Default = 4")
                .defineInRange("arrowCountEnderiumBow", 4, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        BUILDER.push("Tool Tier Base Properties");
        speedEnderiumTier = BUILDER
                .comment("Speed value of Enderium Tool Tier | Default Value = 130")
                .defineInRange("speedEnderiumTier", 130, 0, Integer.MAX_VALUE);
        attackDamageBonusEnderiumTier = BUILDER
                .comment("Bonus attack damage for Enderium Tool Tier | Default Value = 40")
                .defineInRange("attackDamageBonusEnderiumTier", 40, 0, Integer.MAX_VALUE);
        enchantmentValueEnderiumTier = BUILDER
                .comment("Enchantment value for Enderium Tool Tier | Default Value = 85")
                .defineInRange("enchantmentValueEnderiumTier", 85, 0, Integer.MAX_VALUE);
        durabilityEnderium = BUILDER
                .comment("Durability of Enderium tools | Default Value = 4096")
                .defineInRange("durabilityEnderium", 4096, 0, Integer.MAX_VALUE);
        unbreakableEnderium = BUILDER
                .comment("Whether Enderium is unbreakable | Default Value = false")
                .define("unbreakableEnderium", false);
        BUILDER.pop();

        BUILDER.push("Pickaxe Stats");
        attackDamageEnderiumPickaxe = BUILDER
                .comment("Attack damage of Enderium Pickaxe | Default Value = 18")
                .defineInRange("attackDamageEnderiumPickaxe", 18, 0, Integer.MAX_VALUE);
        attackSpeedEnderiumPickaxe = BUILDER
                .comment("Attack speed of Enderium Pickaxe | Default Value = 2.0")
                .defineInRange("attackSpeedEnderiumPickaxe", 2.0, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Axe Stats");
        attackDamageEnderiumAxe = BUILDER
                .comment("Attack damage of Enderium Axe | Default Value = 20")
                .defineInRange("attackDamageEnderiumAxe", 20, 0, Integer.MAX_VALUE);
        attackSpeedEnderiumAxe = BUILDER
                .comment("Attack speed of Enderium Axe | Default Value = 2.0")
                .defineInRange("attackSpeedEnderiumAxe", 2.0, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Shovel Stats");
        attackDamageEnderiumShovel = BUILDER
                .comment("Attack damage of Enderium Shovel | Default Value = 17")
                .defineInRange("attackDamageEnderiumShovel", 17, 0, Integer.MAX_VALUE);
        attackSpeedEnderiumShovel = BUILDER
                .comment("Attack speed of Enderium Shovel | Default Value = 2.0")
                .defineInRange("attackSpeedEnderiumShovel", 2.0, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Sword Stats");
        attackDamageEnderiumSword = BUILDER
                .comment("Attack damage of Enderium Sword | Default Value = 22")
                .defineInRange("attackDamageEnderiumSword", 22, 0, Integer.MAX_VALUE);
        attackSpeedEnderiumSword = BUILDER
                .comment("Attack speed of Enderium Sword | Default Value = 2.0")
                .defineInRange("attackSpeedEnderiumSword", 2.0, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Hoe Stats");
        attackDamageEnderiumHoe = BUILDER
                .comment("Attack damage of Enderium Hoe | Default Value = 14")
                .defineInRange("attackDamageEnderiumHoe", 14, 0, Integer.MAX_VALUE);
        attackSpeedEnderiumHoe = BUILDER
                .comment("Attack speed of Enderium Hoe | Default Value = 2.0")
                .defineInRange("attackSpeedEnderiumHoe", 2.0, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Paxel Stats");
        attackDamageEnderiumPaxel = BUILDER
                .comment("Attack damage of Enderium Paxel | Default Value = 20")
                .defineInRange("attackDamageEnderiumPaxel", 20, 0, Integer.MAX_VALUE);
        attackSpeedEnderiumPaxel = BUILDER
                .comment("Attack speed of Enderium Paxel | Default Value = 2.0")
                .defineInRange("attackSpeedEnderiumPaxel", 2.0, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Hammer Stats");
        attackDamageEnderiumHammer = BUILDER
                .comment("Attack damage of Enderium Hammer | Default Value = 20")
                .defineInRange("attackDamageEnderiumHammer", 20, 0, Integer.MAX_VALUE);
        attackSpeedEnderiumHammer = BUILDER
                .comment("Attack speed of Enderium Hammer | Default Value = 2.0")
                .defineInRange("attackSpeedEnderiumHammer", 2.0, 0.0, 1024.0);
        radiusEnderiumHammer = BUILDER
                .comment("Hammering radius for Enderium Hammer | Default = 3")
                .defineInRange("radiusEnderiumHammer", 3, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        BUILDER.push("Excavator Stats");
        attackDamageEnderiumExcavator = BUILDER
                .comment("Attack damage of Enderium Excavator | Default Value = 20")
                .defineInRange("attackDamageEnderiumExcavator", 20, 0, Integer.MAX_VALUE);
        attackSpeedEnderiumExcavator = BUILDER
                .comment("Attack speed of Enderium Excavator | Default Value = 2.0")
                .defineInRange("attackSpeedEnderiumExcavator", 2.0, 0.0, 1024.0);
        radiusEnderiumExcavator = BUILDER
                .comment("Excavation radius for Enderium Excavator | Default = 3")
                .defineInRange("radiusEnderiumExcavator", 3, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        SPEC = BUILDER.build();
    }


    public static void loadConfig(ForgeConfigSpec spec, Path path) {
        try {
            Files.createDirectories(path.getParent());

            final CommentedFileConfig configData = CommentedFileConfig.builder(path)
                    .autosave()
                    .sync()
                    .writingMode(WritingMode.REPLACE)
                    .build();

            configData.load();
            spec.setConfig(configData);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file: " + path, e);
        }
    }
}
