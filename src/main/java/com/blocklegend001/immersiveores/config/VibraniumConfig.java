package com.blocklegend001.immersiveores.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class VibraniumConfig {

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    // 1. Armor Protection and Resistance
    public static final ForgeConfigSpec.IntValue toughnessValueVibraniumArmor;
    public static final ForgeConfigSpec.IntValue enchantmentValueVibraniumArmor;
    public static final ForgeConfigSpec.DoubleValue knockbackResistanceValueVibraniumArmor;
    public static final ForgeConfigSpec.IntValue protectionValueVibraniumBoots;
    public static final ForgeConfigSpec.IntValue protectionValueVibraniumLeggings;
    public static final ForgeConfigSpec.IntValue protectionValueVibraniumChestplate;
    public static final ForgeConfigSpec.IntValue protectionValueVibraniumHelmet;
    public static final ForgeConfigSpec.IntValue protectionValueVibraniumHorseArmor;

    // 2. Armor Special Effects and Abilities
    public static final ForgeConfigSpec.BooleanValue speedIVibraniumArmor;
    public static final ForgeConfigSpec.BooleanValue jumpIVibraniumArmor;
    public static final ForgeConfigSpec.BooleanValue nightVisionVibraniumArmor;
    public static final ForgeConfigSpec.BooleanValue canWalkOnPowderedSnowVibranium;

    // 3. Bow Settings
    public static final ForgeConfigSpec.IntValue enchantmentValueVibraniumBow;
    public static final ForgeConfigSpec.IntValue damageVibraniumBow;
    public static final ForgeConfigSpec.IntValue arrowCountVibraniumBow;

    // 4. Tool Tier Base Properties
    public static final ForgeConfigSpec.IntValue speedVibraniumTier;
    public static final ForgeConfigSpec.IntValue attackDamageBonusVibraniumTier;
    public static final ForgeConfigSpec.IntValue enchantmentValueVibraniumTier;
    public static final ForgeConfigSpec.IntValue durabilityVibranium;
    public static final ForgeConfigSpec.BooleanValue unbreakableVibranium;

    // 5. Pickaxe Stats
    public static final ForgeConfigSpec.IntValue attackDamageVibraniumPickaxe;
    public static final ForgeConfigSpec.DoubleValue attackSpeedVibraniumPickaxe;

    // 6. Axe Stats
    public static final ForgeConfigSpec.IntValue attackDamageVibraniumAxe;
    public static final ForgeConfigSpec.DoubleValue attackSpeedVibraniumAxe;

    // 7. Shovel Stats
    public static final ForgeConfigSpec.IntValue attackDamageVibraniumShovel;
    public static final ForgeConfigSpec.DoubleValue attackSpeedVibraniumShovel;

    // 8. Sword Stats
    public static final ForgeConfigSpec.IntValue attackDamageVibraniumSword;
    public static final ForgeConfigSpec.DoubleValue attackSpeedVibraniumSword;

    // 9. Hoe Stats
    public static final ForgeConfigSpec.IntValue attackDamageVibraniumHoe;
    public static final ForgeConfigSpec.DoubleValue attackSpeedVibraniumHoe;

    // 10. Paxel Stats
    public static final ForgeConfigSpec.IntValue attackDamageVibraniumPaxel;
    public static final ForgeConfigSpec.DoubleValue attackSpeedVibraniumPaxel;

    // 11. Hammer Stats
    public static final ForgeConfigSpec.IntValue attackDamageVibraniumHammer;
    public static final ForgeConfigSpec.DoubleValue attackSpeedVibraniumHammer;

    // 12. Excavator Stats
    public static final ForgeConfigSpec.IntValue attackDamageVibraniumExcavator;
    public static final ForgeConfigSpec.DoubleValue attackSpeedVibraniumExcavator;

    // 13. Radius (Hammer/Excavator)
    public static final ForgeConfigSpec.IntValue radiusVibraniumHammer;
    public static final ForgeConfigSpec.IntValue radiusVibraniumExcavator;

    public static final ForgeConfigSpec SPEC;

    static {
        BUILDER.push("Armor Protection and Resistance");
        toughnessValueVibraniumArmor = BUILDER
                .comment("Toughness value for Vibranium Armor | Default Value = 3")
                .defineInRange("toughnessValueVibraniumArmor", 3, 0, Integer.MAX_VALUE);
        enchantmentValueVibraniumArmor = BUILDER
                .comment("Enchantment value for Vibranium Armor | Default Value = 55")
                .defineInRange("enchantmentValueVibraniumArmor", 55, 0, Integer.MAX_VALUE);
        knockbackResistanceValueVibraniumArmor = BUILDER
                .comment("Knockback resistance for Vibranium Armor | Default Value = 0.2")
                .defineInRange("knockbackResistanceValueVibraniumArmor", 0.2F, 0, Double.MAX_VALUE);
        protectionValueVibraniumBoots = BUILDER
                .comment("Protection value for Vibranium Boots | Default Value = 6")
                .defineInRange("protectionValueVibraniumBoots", 6, 0, Integer.MAX_VALUE);
        protectionValueVibraniumLeggings = BUILDER
                .comment("Protection value for Vibranium Leggings | Default Value = 9")
                .defineInRange("protectionValueVibraniumLeggings", 9, 0, Integer.MAX_VALUE);
        protectionValueVibraniumChestplate = BUILDER
                .comment("Protection value for Vibranium Chestplate | Default Value = 12")
                .defineInRange("protectionValueVibraniumChestplate", 12, 0, Integer.MAX_VALUE);
        protectionValueVibraniumHelmet = BUILDER
                .comment("Protection value for Vibranium Helmet | Default Value = 6")
                .defineInRange("protectionValueVibraniumHelmet", 6, 0, Integer.MAX_VALUE);
        protectionValueVibraniumHorseArmor = BUILDER
                .comment("Protection Value for Horse Armor | Default Value = 12")
                .defineInRange("protectionValueVibraniumHorseArmor", 12, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        BUILDER.push("Armor Special Effects and Abilities");
        speedIVibraniumArmor = BUILDER
                .comment("Whether Vibranium Armor gives Speed I | Default Value = true")
                .define("speedIVibraniumArmor", true);
        jumpIVibraniumArmor = BUILDER
                .comment("Whether Vibranium Armor gives Jump I | Default Value = true")
                .define("jumpIVibraniumArmor", true);
        nightVisionVibraniumArmor = BUILDER
                .comment("Whether Vibranium Armor gives Night Vision | Default Value = true")
                .define("nightVisionVibraniumArmor", true);
        canWalkOnPowderedSnowVibranium = BUILDER
                .comment("Whether Vibranium Armor allows walking on Powdered Snow | Default Value = true")
                .define("canWalkOnPowderedSnowVibranium", true);
        BUILDER.pop();

        BUILDER.push("Bow Settings");
        enchantmentValueVibraniumBow = BUILDER
                .comment("Enchantment value for Vibranium Bow | Default Value = 5")
                .defineInRange("enchantmentValueVibraniumBow", 5, 0, Integer.MAX_VALUE);
        damageVibraniumBow = BUILDER
                .comment("Damage of Vibranium Bow | Default Value = 5")
                .defineInRange("damageVibraniumBow", 5, 0, Integer.MAX_VALUE);
        arrowCountVibraniumBow = BUILDER
                .comment("Arrow count for Vibranium Bow | Default = 2")
                .defineInRange("arrowCountVibraniumBow", 2, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        BUILDER.push("Tool Tier Base Properties");
        speedVibraniumTier = BUILDER
                .comment("Speed value of Vibranium Tool Tier | Default Value = 30")
                .defineInRange("speedVibraniumTier", 30, 0, Integer.MAX_VALUE);
        attackDamageBonusVibraniumTier = BUILDER
                .comment("Bonus attack damage for Vibranium Tool Tier | Default Value = 1")
                .defineInRange("attackDamageBonusVibraniumTier", 1, 0, Integer.MAX_VALUE);
        enchantmentValueVibraniumTier = BUILDER
                .comment("Enchantment value for Vibranium Tool Tier | Default Value = 55")
                .defineInRange("enchantmentValueVibraniumTier", 55, 0, Integer.MAX_VALUE);
        durabilityVibranium = BUILDER
                .comment("Durability of Vibranium tools | Default Value = 2562")
                .defineInRange("durabilityVibranium", 2562, 0, Integer.MAX_VALUE);
        unbreakableVibranium = BUILDER
                .comment("Whether Vibranium is unbreakable | Default Value = false")
                .define("unbreakableVibranium", false);
        BUILDER.pop();

        BUILDER.push("Pickaxe Stats");
        attackDamageVibraniumPickaxe = BUILDER
                .comment("Attack damage of Vibranium Pickaxe | Default Value = 7")
                .defineInRange("attackDamageVibraniumPickaxe", 7, 0, Integer.MAX_VALUE);
        attackSpeedVibraniumPickaxe = BUILDER
                .comment("Attack speed of Vibranium Pickaxe | Default Value = 0.5")
                .defineInRange("attackSpeedVibraniumPickaxe", 0.5, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Axe Stats");
        attackDamageVibraniumAxe = BUILDER
                .comment("Attack damage of Vibranium Axe | Default Value = 12")
                .defineInRange("attackDamageVibraniumAxe", 12, 0, Integer.MAX_VALUE);
        attackSpeedVibraniumAxe = BUILDER
                .comment("Attack speed of Vibranium Axe | Default Value = 0.5")
                .defineInRange("attackSpeedVibraniumAxe", 0.5, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Shovel Stats");
        attackDamageVibraniumShovel = BUILDER
                .comment("Attack damage of Vibranium Shovel | Default Value = 7")
                .defineInRange("attackDamageVibraniumShovel", 7, 0, Integer.MAX_VALUE);
        attackSpeedVibraniumShovel = BUILDER
                .comment("Attack speed of Vibranium Shovel | Default Value = 0.5")
                .defineInRange("attackSpeedVibraniumShovel", 0.5, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Sword Stats");
        attackDamageVibraniumSword = BUILDER
                .comment("Attack damage of Vibranium Sword | Default Value = 10")
                .defineInRange("attackDamageVibraniumSword", 10, 0, Integer.MAX_VALUE);
        attackSpeedVibraniumSword = BUILDER
                .comment("Attack speed of Vibranium Sword | Default Value = 0.5")
                .defineInRange("attackSpeedVibraniumSword", 0.5, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Hoe Stats");
        attackDamageVibraniumHoe = BUILDER
                .comment("Attack damage of Vibranium Hoe | Default Value = 7")
                .defineInRange("attackDamageVibraniumHoe", 7, 0, Integer.MAX_VALUE);
        attackSpeedVibraniumHoe = BUILDER
                .comment("Attack speed of Vibranium Hoe | Default Value = 0.5")
                .defineInRange("attackSpeedVibraniumHoe", 0.5, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Paxel Stats");
        attackDamageVibraniumPaxel = BUILDER
                .comment("Attack damage of Vibranium Paxel | Default Value = 11")
                .defineInRange("attackDamageVibraniumPaxel", 11, 0, Integer.MAX_VALUE);
        attackSpeedVibraniumPaxel = BUILDER
                .comment("Attack speed of Vibranium Paxel | Default Value = 0.5")
                .defineInRange("attackSpeedVibraniumPaxel", 0.5, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Hammer Stats");
        attackDamageVibraniumHammer = BUILDER
                .comment("Attack damage of Vibranium Hammer | Default Value = 7")
                .defineInRange("attackDamageVibraniumHammer", 7, 0, Integer.MAX_VALUE);
        attackSpeedVibraniumHammer = BUILDER
                .comment("Attack speed of Vibranium Hammer | Default Value = 0.5")
                .defineInRange("attackSpeedVibraniumHammer", 0.5, 0.0, 1024.0);
        radiusVibraniumHammer = BUILDER
                .comment("Hammering radius for Vibranium Hammer | Default = 1")
                .defineInRange("radiusVibraniumHammer", 1, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        BUILDER.push("Excavator Stats");
        attackDamageVibraniumExcavator = BUILDER
                .comment("Attack damage of Vibranium Excavator | Default Value = 7")
                .defineInRange("attackDamageVibraniumExcavator", 7, 0, Integer.MAX_VALUE);
        attackSpeedVibraniumExcavator = BUILDER
                .comment("Attack speed of Vibranium Excavator | Default Value = 0.5")
                .defineInRange("attackSpeedVibraniumExcavator", 0.5, 0.0, 1024.0);
        radiusVibraniumExcavator = BUILDER
                .comment("Excavation radius for Vibranium Excavator | Default = 1")
                .defineInRange("radiusVibraniumExcavator", 1, 0, Integer.MAX_VALUE);
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
