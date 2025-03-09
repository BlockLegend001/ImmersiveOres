package com.blocklegend001.immersiveores.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class VulpusConfig {

    private static final File CONFIG_FILE = new File("config/immersiveores/vulpus-common.toml");

    public static int toughnessValueVulpusArmor = 150;
    public static int enchantmentValueVulpusArmor = 85;
    public static int knockbackResistanceValueVulpusArmor = 2;
    public static int protectionValueVulpusBoots = 20;
    public static int protectionValueVulpusLeggings = 25;
    public static int protectionValueVulpusChestplate = 35;
    public static int protectionValueVulpusHelmet = 20;

    public static boolean speedIIVulpusArmor = true;
    public static boolean jumpIIVulpusArmor = true;
    public static boolean nightVisionVulpusArmor = true;
    public static boolean fireResistanceVulpusArmor = true;
    public static boolean immuneToFallDamageVulpusArmor = true;
    public static boolean neverLoseHungerVulpusArmor = true;
    public static boolean canWalkOnPowderedSnowVulpus = true;
    public static boolean makesPiglinsNeutralVulpus = true;

    public static int speedVulpusTier = 75;
    public static int enchantmentValueVulpusBow = 5;
    public static int damageVulpusBow = 10;
    public static int attackDamageBonusVulpusTier = 20;
    public static int enchantmentValueVulpusTier = 85;
    public static int attackDamageVulpusPickaxe = 10;
    public static double attackSpeedVulpusPickaxe = 2.0;
    public static int attackDamageVulpusAxe = 15;
    public static double attackSpeedVulpusAxe = 2.0;
    public static int attackDamageVulpusShovel = 12;
    public static double attackSpeedVulpusShovel = 2.0;
    public static int attackDamageVulpusSword = 14;
    public static double attackSpeedVulpusSword = 2.0;
    public static int attackDamageVulpusHoe = 10;
    public static double attackSpeedVulpusHoe = 2.0;
    public static int attackDamageVulpusPaxel = 18;
    public static double attackSpeedVulpusPaxel = 2.0;
    public static int attackDamageVulpusHammer = 17;
    public static double attackSpeedVulpusHammer = 2.0;
    public static int attackDamageVulpusExcavator = 17;
    public static double attackSpeedVulpusExcavator = 2.0;

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

                toughnessValueVulpusArmor = config.get("toughnessValueVulpusArmor").getAsInt();
                enchantmentValueVulpusArmor = config.get("enchantmentValueVulpusArmor").getAsInt();
                knockbackResistanceValueVulpusArmor = config.get("knockbackResistanceValueVulpusArmor").getAsInt();
                protectionValueVulpusBoots = config.get("protectionValueVulpusBoots").getAsInt();
                protectionValueVulpusLeggings = config.get("protectionValueVulpusLeggings").getAsInt();
                protectionValueVulpusChestplate = config.get("protectionValueVulpusChestplate").getAsInt();
                protectionValueVulpusHelmet = config.get("protectionValueVulpusHelmet").getAsInt();
                speedIIVulpusArmor = config.get("speedIIVulpusArmor").getAsBoolean();
                jumpIIVulpusArmor = config.get("jumpIIVulpusArmor").getAsBoolean();
                nightVisionVulpusArmor = config.get("nightVisionVulpusArmor").getAsBoolean();
                fireResistanceVulpusArmor = config.get("fireResistanceVulpusArmor").getAsBoolean();
                immuneToFallDamageVulpusArmor = config.get("immuneToFallDamageVulpusArmor").getAsBoolean();
                neverLoseHungerVulpusArmor = config.get("neverLoseHungerVulpusArmor").getAsBoolean();
                canWalkOnPowderedSnowVulpus = config.get("canWalkOnPowderedSnowVulpus").getAsBoolean();
                makesPiglinsNeutralVulpus = config.get("makesPiglinsNeutralVulpus").getAsBoolean();
                speedVulpusTier = config.get("speedVulpusTier").getAsInt();
                enchantmentValueVulpusBow = config.get("enchantmentValueVulpusBow").getAsInt();
                damageVulpusBow = config.get("damageVulpusBow").getAsInt();
                attackDamageBonusVulpusTier = config.get("attackDamageBonusVulpusTier").getAsInt();
                enchantmentValueVulpusTier = config.get("enchantmentValueVulpusTier").getAsInt();
                attackDamageVulpusPickaxe = config.get("attackDamageVulpusPickaxe").getAsInt();
                attackSpeedVulpusPickaxe = config.get("attackSpeedVulpusPickaxe").getAsDouble();
                attackDamageVulpusAxe = config.get("attackDamageVulpusAxe").getAsInt();
                attackSpeedVulpusAxe = config.get("attackSpeedVulpusAxe").getAsDouble();
                attackDamageVulpusShovel = config.get("attackDamageVulpusShovel").getAsInt();
                attackSpeedVulpusShovel = config.get("attackSpeedVulpusShovel").getAsDouble();
                attackDamageVulpusSword = config.get("attackDamageVulpusSword").getAsInt();
                attackSpeedVulpusSword = config.get("attackSpeedVulpusSword").getAsDouble();
                attackDamageVulpusHoe = config.get("attackDamageVulpusHoe").getAsInt();
                attackSpeedVulpusHoe = config.get("attackSpeedVulpusHoe").getAsDouble();
                attackDamageVulpusPaxel = config.get("attackDamageVulpusPaxel").getAsInt();
                attackSpeedVulpusPaxel = config.get("attackSpeedVulpusPaxel").getAsDouble();
                attackDamageVulpusHammer = config.get("attackDamageVulpusHammer").getAsInt();
                attackSpeedVulpusHammer = config.get("attackSpeedVulpusHammer").getAsDouble();
                attackDamageVulpusExcavator = config.get("attackDamageVulpusExcavator").getAsInt();
                attackSpeedVulpusExcavator = config.get("attackSpeedVulpusExcavator").getAsDouble();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void saveConfig() {
        JsonObject config = new JsonObject();
        config.addProperty("toughnessValueVulpusArmor", toughnessValueVulpusArmor);
        config.addProperty("enchantmentValueVulpusArmor", enchantmentValueVulpusArmor);
        config.addProperty("knockbackResistanceValueVulpusArmor", knockbackResistanceValueVulpusArmor);
        config.addProperty("protectionValueVulpusBoots", protectionValueVulpusBoots);
        config.addProperty("protectionValueVulpusLeggings", protectionValueVulpusLeggings);
        config.addProperty("protectionValueVulpusChestplate", protectionValueVulpusChestplate);
        config.addProperty("protectionValueVulpusHelmet", protectionValueVulpusHelmet);
        config.addProperty("speedIIVulpusArmor", speedIIVulpusArmor);
        config.addProperty("jumpIIVulpusArmor", jumpIIVulpusArmor);
        config.addProperty("nightVisionVulpusArmor", nightVisionVulpusArmor);
        config.addProperty("fireResistanceVulpusArmor", fireResistanceVulpusArmor);
        config.addProperty("immuneToFallDamageVulpusArmor", immuneToFallDamageVulpusArmor);
        config.addProperty("neverLoseHungerVulpusArmor", neverLoseHungerVulpusArmor);
        config.addProperty("canWalkOnPowderedSnowVulpus", canWalkOnPowderedSnowVulpus);
        config.addProperty("makesPiglinsNeutralVulpus", makesPiglinsNeutralVulpus);
        config.addProperty("speedVulpusTier", speedVulpusTier);
        config.addProperty("enchantmentValueVulpusBow", enchantmentValueVulpusBow);
        config.addProperty("damageVulpusBow", damageVulpusBow);
        config.addProperty("attackDamageBonusVulpusTier", attackDamageBonusVulpusTier);
        config.addProperty("enchantmentValueVulpusTier", enchantmentValueVulpusTier);
        config.addProperty("attackDamageVulpusPickaxe", attackDamageVulpusPickaxe);
        config.addProperty("attackSpeedVulpusPickaxe", attackSpeedVulpusPickaxe);
        config.addProperty("attackDamageVulpusAxe", attackDamageVulpusAxe);
        config.addProperty("attackSpeedVulpusAxe", attackSpeedVulpusAxe);
        config.addProperty("attackDamageVulpusShovel", attackDamageVulpusShovel);
        config.addProperty("attackSpeedVulpusShovel", attackSpeedVulpusShovel);
        config.addProperty("attackDamageVulpusSword", attackDamageVulpusSword);
        config.addProperty("attackSpeedVulpusSword", attackSpeedVulpusSword);
        config.addProperty("attackDamageVulpusHoe", attackDamageVulpusHoe);
        config.addProperty("attackSpeedVulpusHoe", attackSpeedVulpusHoe);
        config.addProperty("attackDamageVulpusPaxel", attackDamageVulpusPaxel);
        config.addProperty("attackSpeedVulpusPaxel", attackSpeedVulpusPaxel);
        config.addProperty("attackDamageVulpusHammer", attackDamageVulpusHammer);
        config.addProperty("attackSpeedVulpusHammer", attackSpeedVulpusHammer);
        config.addProperty("attackDamageVulpusExcavator", attackDamageVulpusExcavator);
        config.addProperty("attackSpeedVulpusExcavator", attackSpeedVulpusExcavator);

        try (FileWriter writer = new FileWriter(CONFIG_FILE)) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                writer.write(gson.toJson(config));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
