package com.blocklegend001.immersiveores.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class VulpusConfig {

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    // 1. Armor Protection and Resistance
    public static final ForgeConfigSpec.IntValue toughnessValueVulpusArmor;
    public static final ForgeConfigSpec.IntValue enchantmentValueVulpusArmor;
    public static final ForgeConfigSpec.IntValue knockbackResistanceValueVulpusArmor;
    public static final ForgeConfigSpec.IntValue protectionValueVulpusBoots;
    public static final ForgeConfigSpec.IntValue protectionValueVulpusLeggings;
    public static final ForgeConfigSpec.IntValue protectionValueVulpusChestplate;
    public static final ForgeConfigSpec.IntValue protectionValueVulpusHelmet;

    // 2. Armor Special Effects and Abilities
    public static final ForgeConfigSpec.BooleanValue speedIIVulpusArmor;
    public static final ForgeConfigSpec.BooleanValue jumpIIVulpusArmor;
    public static final ForgeConfigSpec.BooleanValue nightVisionVulpusArmor;
    public static final ForgeConfigSpec.BooleanValue fireResistanceVulpusArmor;
    public static final ForgeConfigSpec.BooleanValue immuneToFallDamageVulpusArmor;
    public static final ForgeConfigSpec.BooleanValue neverLoseHungerVulpusArmor;
    public static final ForgeConfigSpec.BooleanValue canWalkOnPowderedSnowVulpus;
    public static final ForgeConfigSpec.BooleanValue makesPiglinsNeutralVulpus;

    // 3. Bow Settings
    public static final ForgeConfigSpec.IntValue enchantmentValueVulpusBow;
    public static final ForgeConfigSpec.IntValue damageVulpusBow;
    public static final ForgeConfigSpec.IntValue arrowCountVulpusBow;

    // 4. Tool Tier Base Properties
    public static final ForgeConfigSpec.IntValue speedVulpusTier;
    public static final ForgeConfigSpec.IntValue attackDamageBonusVulpusTier;
    public static final ForgeConfigSpec.IntValue enchantmentValueVulpusTier;
    public static final ForgeConfigSpec.IntValue durabilityVulpus;
    public static final ForgeConfigSpec.BooleanValue unbreakableVulpus;

    // 5. Pickaxe Stats
    public static final ForgeConfigSpec.IntValue attackDamageVulpusPickaxe;
    public static final ForgeConfigSpec.DoubleValue attackSpeedVulpusPickaxe;

    // 6. Axe Stats
    public static final ForgeConfigSpec.IntValue attackDamageVulpusAxe;
    public static final ForgeConfigSpec.DoubleValue attackSpeedVulpusAxe;

    // 7. Shovel Stats
    public static final ForgeConfigSpec.IntValue attackDamageVulpusShovel;
    public static final ForgeConfigSpec.DoubleValue attackSpeedVulpusShovel;

    // 8. Sword Stats
    public static final ForgeConfigSpec.IntValue attackDamageVulpusSword;
    public static final ForgeConfigSpec.DoubleValue attackSpeedVulpusSword;

    // 9. Hoe Stats
    public static final ForgeConfigSpec.IntValue attackDamageVulpusHoe;
    public static final ForgeConfigSpec.DoubleValue attackSpeedVulpusHoe;

    // 10. Paxel Stats
    public static final ForgeConfigSpec.IntValue attackDamageVulpusPaxel;
    public static final ForgeConfigSpec.DoubleValue attackSpeedVulpusPaxel;

    // 11. Hammer Stats
    public static final ForgeConfigSpec.IntValue attackDamageVulpusHammer;
    public static final ForgeConfigSpec.DoubleValue attackSpeedVulpusHammer;
    public static final ForgeConfigSpec.IntValue radiusVulpusHammer;

    // 12. Excavator Stats
    public static final ForgeConfigSpec.IntValue attackDamageVulpusExcavator;
    public static final ForgeConfigSpec.DoubleValue attackSpeedVulpusExcavator;
    public static final ForgeConfigSpec.IntValue radiusVulpusExcavator;

    public static final ForgeConfigSpec SPEC;

    static {
        BUILDER.push("Armor Protection and Resistance");
        toughnessValueVulpusArmor = BUILDER
                .comment("Toughness value for Vulpus Armor | Default Value = 150")
                .defineInRange("toughnessValueVulpusArmor", 150, 0, Integer.MAX_VALUE);
        enchantmentValueVulpusArmor = BUILDER
                .comment("Enchantment value for Vulpus Armor | Default Value = 85")
                .defineInRange("enchantmentValueVulpusArmor", 85, 0, Integer.MAX_VALUE);
        knockbackResistanceValueVulpusArmor = BUILDER
                .comment("Knockback resistance for Vulpus Armor | Default Value = 2")
                .defineInRange("knockbackResistanceValueVulpusArmor", 2, 0, Integer.MAX_VALUE);
        protectionValueVulpusBoots = BUILDER
                .comment("Protection value for Vulpus Boots | Default Value = 20")
                .defineInRange("protectionValueVulpusBoots", 20, 0, Integer.MAX_VALUE);
        protectionValueVulpusLeggings = BUILDER
                .comment("Protection value for Vulpus Leggings | Default Value = 25")
                .defineInRange("protectionValueVulpusLeggings", 25, 0, Integer.MAX_VALUE);
        protectionValueVulpusChestplate = BUILDER
                .comment("Protection value for Vulpus Chestplate | Default Value = 35")
                .defineInRange("protectionValueVulpusChestplate", 35, 0, Integer.MAX_VALUE);
        protectionValueVulpusHelmet = BUILDER
                .comment("Protection value for Vulpus Helmet | Default Value = 20")
                .defineInRange("protectionValueVulpusHelmet", 20, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        BUILDER.push("Armor Special Effects and Abilities");
        speedIIVulpusArmor = BUILDER
                .comment("Whether Vulpus Armor gives Speed II | Default Value = true")
                .define("speedIIVulpusArmor", true);
        jumpIIVulpusArmor = BUILDER
                .comment("Whether Vulpus Armor gives Jump II | Default Value = true")
                .define("jumpIIVulpusArmor", true);
        nightVisionVulpusArmor = BUILDER
                .comment("Whether Vulpus Armor gives Night Vision | Default Value = true")
                .define("nightVisionVulpusArmor", true);
        fireResistanceVulpusArmor = BUILDER
                .comment("Whether Vulpus Armor gives Fire Resistance | Default Value = true")
                .define("fireResistanceVulpusArmor", true);
        immuneToFallDamageVulpusArmor = BUILDER
                .comment("Whether Vulpus Armor gives Immunity to Fall Damage | Default Value = true")
                .define("immuneToFallDamageVulpusArmor", true);
        neverLoseHungerVulpusArmor = BUILDER
                .comment("Whether Vulpus Armor prevents Hunger loss | Default Value = true")
                .define("neverLoseHungerVulpusArmor", true);
        canWalkOnPowderedSnowVulpus = BUILDER
                .comment("Whether Vulpus Armor allows walking on Powdered Snow | Default Value = true")
                .define("canWalkOnPowderedSnowVulpus", true);
        makesPiglinsNeutralVulpus = BUILDER
                .comment("Whether Vulpus Armor makes Piglins Neutral | Default Value = true")
                .define("makesPiglinsNeutralVulpus", true);
        BUILDER.pop();

        BUILDER.push("Bow Settings");
        enchantmentValueVulpusBow = BUILDER
                .comment("Enchantment value for Vulpus Bow | Default Value = 5")
                .defineInRange("enchantmentValueVulpusBow", 5, 0, Integer.MAX_VALUE);
        damageVulpusBow = BUILDER
                .comment("Damage of Vulpus Bow | Default Value = 10")
                .defineInRange("damageVulpusBow", 10, 0, Integer.MAX_VALUE);
        arrowCountVulpusBow = BUILDER
                .comment("Arrow count for Vulpus Bow | Default = 3")
                .defineInRange("arrowCountVulpusBow", 3, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        BUILDER.push("Tool Tier Base Properties");
        speedVulpusTier = BUILDER
                .comment("Speed value of Vulpus Tool Tier | Default Value = 75")
                .defineInRange("speedVulpusTier", 75, 0, Integer.MAX_VALUE);
        attackDamageBonusVulpusTier = BUILDER
                .comment("Bonus attack damage for Vulpus Tool Tier | Default Value = 20")
                .defineInRange("attackDamageBonusVulpusTier", 20, 0, Integer.MAX_VALUE);
        enchantmentValueVulpusTier = BUILDER
                .comment("Enchantment value for Vulpus Tool Tier | Default Value = 85")
                .defineInRange("enchantmentValueVulpusTier", 85, 0, Integer.MAX_VALUE);
        durabilityVulpus = BUILDER
                .comment("Durability of Vulpus tools | Default Value = 6093")
                .defineInRange("durabilityVulpus", 6093, 0, Integer.MAX_VALUE);
        unbreakableVulpus = BUILDER
                .comment("Whether Vulpus is unbreakable | Default Value = false")
                .define("unbreakableVulpus", false);
        BUILDER.pop();

        BUILDER.push("Pickaxe Stats");
        attackDamageVulpusPickaxe = BUILDER
                .comment("Attack damage of Vulpus Pickaxe | Default Value = 10")
                .defineInRange("attackDamageVulpusPickaxe", 10, 0, Integer.MAX_VALUE);
        attackSpeedVulpusPickaxe = BUILDER
                .comment("Attack speed of Vulpus Pickaxe | Default Value = 2.0")
                .defineInRange("attackSpeedVulpusPickaxe", 2.0, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Axe Stats");
        attackDamageVulpusAxe = BUILDER
                .comment("Attack damage of Vulpus Axe | Default Value = 15")
                .defineInRange("attackDamageVulpusAxe", 15, 0, Integer.MAX_VALUE);
        attackSpeedVulpusAxe = BUILDER
                .comment("Attack speed of Vulpus Axe | Default Value = 2.0")
                .defineInRange("attackSpeedVulpusAxe", 2.0, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Shovel Stats");
        attackDamageVulpusShovel = BUILDER
                .comment("Attack damage of Vulpus Shovel | Default Value = 12")
                .defineInRange("attackDamageVulpusShovel", 12, 0, Integer.MAX_VALUE);
        attackSpeedVulpusShovel = BUILDER
                .comment("Attack speed of Vulpus Shovel | Default Value = 2.0")
                .defineInRange("attackSpeedVulpusShovel", 2.0, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Sword Stats");
        attackDamageVulpusSword = BUILDER
                .comment("Attack damage of Vulpus Sword | Default Value = 14")
                .defineInRange("attackDamageVulpusSword", 14, 0, Integer.MAX_VALUE);
        attackSpeedVulpusSword = BUILDER
                .comment("Attack speed of Vulpus Sword | Default Value = 2.0")
                .defineInRange("attackSpeedVulpusSword", 2.0, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Hoe Stats");
        attackDamageVulpusHoe = BUILDER
                .comment("Attack damage of Vulpus Hoe | Default Value = 10")
                .defineInRange("attackDamageVulpusHoe", 10, 0, Integer.MAX_VALUE);
        attackSpeedVulpusHoe = BUILDER
                .comment("Attack speed of Vulpus Hoe | Default Value = 2.0")
                .defineInRange("attackSpeedVulpusHoe", 2.0, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Paxel Stats");
        attackDamageVulpusPaxel = BUILDER
                .comment("Attack damage of Vulpus Paxel | Default Value = 18")
                .defineInRange("attackDamageVulpusPaxel", 18, 0, Integer.MAX_VALUE);
        attackSpeedVulpusPaxel = BUILDER
                .comment("Attack speed of Vulpus Paxel | Default Value = 2.0")
                .defineInRange("attackSpeedVulpusPaxel", 2.0, 0.0, 1024.0);
        BUILDER.pop();

        BUILDER.push("Hammer Stats");
        attackDamageVulpusHammer = BUILDER
                .comment("Attack damage of Vulpus Hammer | Default Value = 22")
                .defineInRange("attackDamageVulpusHammer", 22, 0, Integer.MAX_VALUE);
        attackSpeedVulpusHammer = BUILDER
                .comment("Attack speed of Vulpus Hammer | Default Value = 2.0")
                .defineInRange("attackSpeedVulpusHammer", 2.0, 0.0, 1024.0);
        radiusVulpusHammer = BUILDER
                .comment("Radius of Vulpus Hammer effect | Default Value = 2")
                .defineInRange("radiusVulpusHammer", 2, 0, Integer.MAX_VALUE);
        BUILDER.pop();

        BUILDER.push("Excavator Stats");
        attackDamageVulpusExcavator = BUILDER
                .comment("Attack damage of Vulpus Excavator | Default Value = 20")
                .defineInRange("attackDamageVulpusExcavator", 20, 0, Integer.MAX_VALUE);
        attackSpeedVulpusExcavator = BUILDER
                .comment("Attack speed of Vulpus Excavator | Default Value = 2.0")
                .defineInRange("attackSpeedVulpusExcavator", 2.0, 0.0, 1024.0);
        radiusVulpusExcavator = BUILDER
                .comment("Radius of Vulpus Excavator effect | Default Value = 2")
                .defineInRange("radiusVulpusExcavator", 2, 0, Integer.MAX_VALUE);
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
