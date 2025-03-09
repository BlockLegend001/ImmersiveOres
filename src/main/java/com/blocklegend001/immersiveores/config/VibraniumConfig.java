package com.blocklegend001.immersiveores.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static com.blocklegend001.immersiveores.ImmersiveOres.LOGGER;

public class VibraniumConfig {

    private static final File CONFIG_FILE = new File("config/immersiveores/vibranium-common.toml");

    public static int toughnessValueVibraniumArmor = 100;
    public static int enchantmentValueVibraniumArmor = 85;
    public static int knockbackResistanceValueVibraniumArmor = 1;
    public static int protectionValueVibraniumBoots = 10;
    public static int protectionValueVibraniumLeggings = 15;
    public static int protectionValueVibraniumChestplate = 20;
    public static int protectionValueVibraniumHelmet = 10;

    public static boolean speedIVibraniumArmor = true;
    public static boolean jumpIVibraniumArmor = true;
    public static boolean nightVisionVibraniumArmor = true;
    public static boolean canWalkOnPowderedSnowVibranium = true;

    public static int speedVibraniumTier = 40;
    public static int enchantmentValueVibraniumBow = 5;
    public static int damageVibraniumBow = 8;
    public static int attackDamageBonusVibraniumTier = 11;
    public static int enchantmentValueVibraniumTier = 85;
    public static int attackDamageVibraniumPickaxe = 9;
    public static double attackSpeedVibraniumPickaxe = 2.0;
    public static int attackDamageVibraniumAxe = 10;
    public static double attackSpeedVibraniumAxe = 2.0;
    public static int attackDamageVibraniumShovel = 9;
    public static double attackSpeedVibraniumShovel = 2.0;
    public static int attackDamageVibraniumSword = 10;
    public static double attackSpeedVibraniumSword = 2.0;
    public static int attackDamageVibraniumHoe = 7;
    public static double attackSpeedVibraniumHoe = 2.0;
    public static int attackDamageVibraniumPaxel = 15;
    public static double attackSpeedVibraniumPaxel = 2.0;
    public static int attackDamageVibraniumHammer = 13;
    public static double attackSpeedVibraniumHammer = 2.0;
    public static int attackDamageVibraniumExcavator = 13;
    public static double attackSpeedVibraniumExcavator = 2.0;

    public static void loadConfig() {
        LOGGER.info("Loading Vibranium Config...");
        File configDir = new File("config/immersiveores");
        if (!configDir.exists()) {
            configDir.mkdirs();
        }

        if (!CONFIG_FILE.exists()) {
            saveConfig();
        } else {
            try (FileReader reader = new FileReader(CONFIG_FILE)) {
                JsonObject config = JsonParser.parseReader(reader).getAsJsonObject();

                toughnessValueVibraniumArmor = config.get("toughnessValueVibraniumArmor").getAsInt();
                enchantmentValueVibraniumArmor = config.get("enchantmentValueVibraniumArmor").getAsInt();
                knockbackResistanceValueVibraniumArmor = config.get("knockbackResistanceValueVibraniumArmor").getAsInt();
                protectionValueVibraniumBoots = config.get("protectionValueVibraniumBoots").getAsInt();
                protectionValueVibraniumLeggings = config.get("protectionValueVibraniumLeggings").getAsInt();
                protectionValueVibraniumChestplate = config.get("protectionValueVibraniumChestplate").getAsInt();
                protectionValueVibraniumHelmet = config.get("protectionValueVibraniumHelmet").getAsInt();

                speedIVibraniumArmor = config.get("speedIVibraniumArmor").getAsBoolean();
                jumpIVibraniumArmor = config.get("jumpIVibraniumArmor").getAsBoolean();
                nightVisionVibraniumArmor = config.get("nightVisionVibraniumArmor").getAsBoolean();
                canWalkOnPowderedSnowVibranium = config.get("canWalkOnPowderedSnowVibranium").getAsBoolean();

                speedVibraniumTier = config.get("speedVibraniumTier").getAsInt();
                enchantmentValueVibraniumBow = config.get("enchantmentValueVibraniumBow").getAsInt();
                damageVibraniumBow = config.get("damageVibraniumBow").getAsInt();
                attackDamageBonusVibraniumTier = config.get("attackDamageBonusVibraniumTier").getAsInt();
                enchantmentValueVibraniumTier = config.get("enchantmentValueVibraniumTier").getAsInt();
                attackDamageVibraniumPickaxe = config.get("attackDamageVibraniumPickaxe").getAsInt();
                attackSpeedVibraniumPickaxe = config.get("attackSpeedVibraniumPickaxe").getAsDouble();
                attackDamageVibraniumAxe = config.get("attackDamageVibraniumAxe").getAsInt();
                attackSpeedVibraniumAxe = config.get("attackSpeedVibraniumAxe").getAsDouble();
                attackDamageVibraniumShovel = config.get("attackDamageVibraniumShovel").getAsInt();
                attackSpeedVibraniumShovel = config.get("attackSpeedVibraniumShovel").getAsDouble();
                attackDamageVibraniumSword = config.get("attackDamageVibraniumSword").getAsInt();
                attackSpeedVibraniumSword = config.get("attackSpeedVibraniumSword").getAsDouble();
                attackDamageVibraniumHoe = config.get("attackDamageVibraniumHoe").getAsInt();
                attackSpeedVibraniumHoe = config.get("attackSpeedVibraniumHoe").getAsDouble();
                attackDamageVibraniumPaxel = config.get("attackDamageVibraniumPaxel").getAsInt();
                attackSpeedVibraniumPaxel = config.get("attackSpeedVibraniumPaxel").getAsDouble();
                attackDamageVibraniumHammer = config.get("attackDamageVibraniumHammer").getAsInt();
                attackSpeedVibraniumHammer = config.get("attackSpeedVibraniumHammer").getAsDouble();
                attackDamageVibraniumExcavator = config.get("attackDamageVibraniumExcavator").getAsInt();
                attackSpeedVibraniumExcavator = config.get("attackSpeedVibraniumExcavator").getAsDouble();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveConfig() {
        JsonObject config = new JsonObject();
        config.addProperty("toughnessValueVibraniumArmor", toughnessValueVibraniumArmor);
        config.addProperty("enchantmentValueVibraniumArmor", enchantmentValueVibraniumArmor);
        config.addProperty("knockbackResistanceValueVibraniumArmor", knockbackResistanceValueVibraniumArmor);
        config.addProperty("protectionValueVibraniumBoots", protectionValueVibraniumBoots);
        config.addProperty("protectionValueVibraniumLeggings", protectionValueVibraniumLeggings);
        config.addProperty("protectionValueVibraniumChestplate", protectionValueVibraniumChestplate);
        config.addProperty("protectionValueVibraniumHelmet", protectionValueVibraniumHelmet);
        config.addProperty("speedIVibraniumArmor", speedIVibraniumArmor);
        config.addProperty("jumpIVibraniumArmor", jumpIVibraniumArmor);
        config.addProperty("nightVisionVibraniumArmor", nightVisionVibraniumArmor);
        config.addProperty("canWalkOnPowderedSnowVibranium", canWalkOnPowderedSnowVibranium);
        config.addProperty("speedVibraniumTier", speedVibraniumTier);
        config.addProperty("enchantmentValueVibraniumBow", enchantmentValueVibraniumBow);
        config.addProperty("damageVibraniumBow", damageVibraniumBow);
        config.addProperty("attackDamageBonusVibraniumTier", attackDamageBonusVibraniumTier);
        config.addProperty("enchantmentValueVibraniumTier", enchantmentValueVibraniumTier);
        config.addProperty("attackDamageVibraniumPickaxe", attackDamageVibraniumPickaxe);
        config.addProperty("attackSpeedVibraniumPickaxe", attackSpeedVibraniumPickaxe);
        config.addProperty("attackDamageVibraniumAxe", attackDamageVibraniumAxe);
        config.addProperty("attackSpeedVibraniumAxe", attackSpeedVibraniumAxe);
        config.addProperty("attackDamageVibraniumShovel", attackDamageVibraniumShovel);
        config.addProperty("attackSpeedVibraniumShovel", attackSpeedVibraniumShovel);
        config.addProperty("attackDamageVibraniumSword", attackDamageVibraniumSword);
        config.addProperty("attackSpeedVibraniumSword", attackSpeedVibraniumSword);
        config.addProperty("attackDamageVibraniumHoe", attackDamageVibraniumHoe);
        config.addProperty("attackSpeedVibraniumHoe", attackSpeedVibraniumHoe);
        config.addProperty("attackDamageVibraniumPaxel", attackDamageVibraniumPaxel);
        config.addProperty("attackSpeedVibraniumPaxel", attackSpeedVibraniumPaxel);
        config.addProperty("attackDamageVibraniumHammer", attackDamageVibraniumHammer);
        config.addProperty("attackSpeedVibraniumHammer", attackSpeedVibraniumHammer);
        config.addProperty("attackDamageVibraniumExcavator", attackDamageVibraniumExcavator);
        config.addProperty("attackSpeedVibraniumExcavator", attackSpeedVibraniumExcavator);
        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            writer.write(gson.toJson(config));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
