package com.blocklegend001.immersiveores.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EnderiumConfig {

    private static final File CONFIG_FILE = new File("config/immersiveores/enderium-common.toml");

    public static int toughnessValueEnderiumArmor = 200;
    public static int enchantmentValueEnderiumArmor = 85;
    public static int knockbackResistanceValueEnderiumArmor = 3;
    public static int protectionValueEnderiumBoots = 30;
    public static int protectionValueEnderiumLeggings = 50;
    public static int protectionValueEnderiumChestplate = 70;
    public static int protectionValueEnderiumHelmet = 30;

    public static boolean speedIIIEnderiumArmor = true;
    public static boolean jumpIIIEnderiumArmor = true;
    public static boolean nightVisionEnderiumArmor = true;
    public static boolean immuneToFallDamageEnderiumArmor = true;
    public static boolean fireResistanceEnderiumArmor = true;
    public static boolean neverLoseHungerEnderiumArmor = true;
    public static boolean canFlyEnderiumArmor = true;
    public static boolean canWalkOnPowderedSnowEnderium = true;
    public static boolean makesPiglinsNeutralEnderium = true;
    public static boolean endermanWillNotBeAngryWithYouEnderium = true;

    public static int speedEnderiumTier = 130;
    public static int enchantmentValueEnderiumBow = 5;
    public static int damageEnderiumBow = 14;
    public static int attackDamageBonusEnderiumTier = 40;
    public static int enchantmentValueEnderiumTier = 85;
    public static int attackDamageEnderiumPickaxe = 18;
    public static double attackSpeedEnderiumPickaxe = 2.0;
    public static int attackDamageEnderiumAxe = 20;
    public static double attackSpeedEnderiumAxe = 2.0;
    public static int attackDamageEnderiumShovel = 17;
    public static double attackSpeedEnderiumShovel = 2.0;
    public static int attackDamageEnderiumSword = 22;
    public static double attackSpeedEnderiumSword = 2.0;
    public static int attackDamageEnderiumHoe = 14;
    public static double attackSpeedEnderiumHoe = 2.0;
    public static int attackDamageEnderiumPaxel = 20;
    public static double attackSpeedEnderiumPaxel = 2.0;
    public static int attackDamageEnderiumHammer = 20;
    public static double attackSpeedEnderiumHammer = 2.0;
    public static int attackDamageEnderiumExcavator = 20;
    public static double attackSpeedEnderiumExcavator = 2.0;

    public static void loadConfig() {
        File configDir = new File("config/immersiveores");
        if (!configDir.exists()) {
            configDir.mkdirs();
        }

        if (!CONFIG_FILE.exists()) {
            saveConfig();
        } else {
            try (FileReader reader = new FileReader(CONFIG_FILE)) {
                JsonObject config = JsonParser.parseReader(reader).getAsJsonObject();

                toughnessValueEnderiumArmor = config.get("toughnessValueEnderiumArmor").getAsInt();
                enchantmentValueEnderiumArmor = config.get("enchantmentValueEnderiumArmor").getAsInt();
                knockbackResistanceValueEnderiumArmor = config.get("knockbackResistanceValueEnderiumArmor").getAsInt();
                protectionValueEnderiumBoots = config.get("protectionValueEnderiumBoots").getAsInt();
                protectionValueEnderiumLeggings = config.get("protectionValueEnderiumLeggings").getAsInt();
                protectionValueEnderiumChestplate = config.get("protectionValueEnderiumChestplate").getAsInt();
                protectionValueEnderiumHelmet = config.get("protectionValueEnderiumHelmet").getAsInt();

                speedIIIEnderiumArmor = config.get("speedIIIEnderiumArmor").getAsBoolean();
                jumpIIIEnderiumArmor = config.get("jumpIIIEnderiumArmor").getAsBoolean();
                nightVisionEnderiumArmor = config.get("nightVisionEnderiumArmor").getAsBoolean();
                immuneToFallDamageEnderiumArmor = config.get("immuneToFallDamageEnderiumArmor").getAsBoolean();
                fireResistanceEnderiumArmor = config.get("fireResistanceEnderiumArmor").getAsBoolean();
                neverLoseHungerEnderiumArmor = config.get("neverLoseHungerEnderiumArmor").getAsBoolean();
                canFlyEnderiumArmor = config.get("canFlyEnderiumArmor").getAsBoolean();
                canWalkOnPowderedSnowEnderium = config.get("canWalkOnPowderedSnowEnderium").getAsBoolean();
                makesPiglinsNeutralEnderium = config.get("makesPiglinsNeutralEnderium").getAsBoolean();
                endermanWillNotBeAngryWithYouEnderium = config.get("endermanWillNotBeAngryWithYouEnderium").getAsBoolean();

                speedEnderiumTier = config.get("speedEnderiumTier").getAsInt();

                enchantmentValueEnderiumBow = config.get("enchantmentValueEnderiumBow").getAsInt();
                damageEnderiumBow = config.get("damageEnderiumBow").getAsInt();
                attackDamageBonusEnderiumTier = config.get("attackDamageBonusEnderiumTier").getAsInt();
                enchantmentValueEnderiumTier = config.get("enchantmentValueEnderiumTier").getAsInt();
                attackDamageEnderiumPickaxe = config.get("attackDamageEnderiumPickaxe").getAsInt();
                attackSpeedEnderiumPickaxe = config.get("attackSpeedEnderiumPickaxe").getAsDouble();
                attackDamageEnderiumAxe = config.get("attackDamageEnderiumAxe").getAsInt();
                attackSpeedEnderiumAxe = config.get("attackSpeedEnderiumAxe").getAsDouble();
                attackDamageEnderiumShovel = config.get("attackDamageEnderiumShovel").getAsInt();
                attackSpeedEnderiumShovel = config.get("attackSpeedEnderiumShovel").getAsDouble();
                attackDamageEnderiumSword = config.get("attackDamageEnderiumSword").getAsInt();
                attackSpeedEnderiumSword = config.get("attackSpeedEnderiumSword").getAsDouble();
                attackDamageEnderiumHoe = config.get("attackDamageEnderiumHoe").getAsInt();
                attackSpeedEnderiumHoe = config.get("attackSpeedEnderiumHoe").getAsDouble();
                attackDamageEnderiumPaxel = config.get("attackDamageEnderiumPaxel").getAsInt();
                attackSpeedEnderiumPaxel = config.get("attackSpeedEnderiumPaxel").getAsDouble();
                attackDamageEnderiumHammer = config.get("attackDamageEnderiumHammer").getAsInt();
                attackSpeedEnderiumHammer = config.get("attackSpeedEnderiumHammer").getAsDouble();
                attackDamageEnderiumExcavator = config.get("attackDamageEnderiumExcavator").getAsInt();
                attackSpeedEnderiumExcavator = config.get("attackSpeedEnderiumExcavator").getAsDouble();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveConfig() {
        JsonObject config = new JsonObject();

        config.addProperty("toughnessValueEnderiumArmor", toughnessValueEnderiumArmor);
        config.addProperty("enchantmentValueEnderiumArmor", enchantmentValueEnderiumArmor);
        config.addProperty("knockbackResistanceValueEnderiumArmor", knockbackResistanceValueEnderiumArmor);
        config.addProperty("protectionValueEnderiumBoots", protectionValueEnderiumBoots);
        config.addProperty("protectionValueEnderiumLeggings", protectionValueEnderiumLeggings);
        config.addProperty("protectionValueEnderiumChestplate", protectionValueEnderiumChestplate);
        config.addProperty("protectionValueEnderiumHelmet", protectionValueEnderiumHelmet);
        config.addProperty("speedIIIEnderiumArmor", speedIIIEnderiumArmor);
        config.addProperty("jumpIIIEnderiumArmor", jumpIIIEnderiumArmor);
        config.addProperty("nightVisionEnderiumArmor", nightVisionEnderiumArmor);
        config.addProperty("fireResistanceEnderiumArmor", fireResistanceEnderiumArmor);
        config.addProperty("immuneToFallDamageEnderiumArmor", immuneToFallDamageEnderiumArmor);
        config.addProperty("canFlyEnderiumArmor", canFlyEnderiumArmor);
        config.addProperty("neverLoseHungerEnderiumArmor", neverLoseHungerEnderiumArmor);
        config.addProperty("canWalkOnPowderedSnowEnderium", canWalkOnPowderedSnowEnderium);
        config.addProperty("makesPiglinsNeutralEnderium", makesPiglinsNeutralEnderium);
        config.addProperty("endermanWillNotBeAngryWithYouEnderium", endermanWillNotBeAngryWithYouEnderium);
        config.addProperty("speedEnderiumTier", speedEnderiumTier);
        config.addProperty("enchantmentValueEnderiumBow", enchantmentValueEnderiumBow);
        config.addProperty("damageEnderiumBow", damageEnderiumBow);
        config.addProperty("attackDamageBonusEnderiumTier", attackDamageBonusEnderiumTier);
        config.addProperty("enchantmentValueEnderiumTier", enchantmentValueEnderiumTier);
        config.addProperty("attackDamageEnderiumPickaxe", attackDamageEnderiumPickaxe);
        config.addProperty("attackSpeedEnderiumPickaxe", attackSpeedEnderiumPickaxe);
        config.addProperty("attackDamageEnderiumAxe", attackDamageEnderiumAxe);
        config.addProperty("attackSpeedEnderiumAxe", attackSpeedEnderiumAxe);
        config.addProperty("attackDamageEnderiumShovel", attackDamageEnderiumShovel);
        config.addProperty("attackSpeedEnderiumShovel", attackSpeedEnderiumShovel);
        config.addProperty("attackDamageEnderiumSword", attackDamageEnderiumSword);
        config.addProperty("attackSpeedEnderiumSword", attackSpeedEnderiumSword);
        config.addProperty("attackDamageEnderiumHoe", attackDamageEnderiumHoe);
        config.addProperty("attackSpeedEnderiumHoe", attackSpeedEnderiumHoe);
        config.addProperty("attackDamageEnderiumPaxel", attackDamageEnderiumPaxel);
        config.addProperty("attackSpeedEnderiumPaxel", attackSpeedEnderiumPaxel);
        config.addProperty("attackDamageEnderiumHammer", attackDamageEnderiumHammer);
        config.addProperty("attackSpeedEnderiumHammer", attackSpeedEnderiumHammer);
        config.addProperty("attackDamageEnderiumExcavator", attackDamageEnderiumExcavator);
        config.addProperty("attackSpeedEnderiumExcavator", attackSpeedEnderiumExcavator);

        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            writer.write(gson.toJson(config));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
