package com.blocklegend001.immersiveores;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@SuppressWarnings("ALL")
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ImmersiveOresConfig {
    public static final ForgeConfigSpec.Builder mycfg = new ForgeConfigSpec.Builder();

    public static ForgeConfigSpec SPEC;

    static {
        initmycfg(mycfg);
        SPEC = mycfg.build();
    }

    //VIBRANIUM
    public static ForgeConfigSpec.ConfigValue<Integer> toughnessValueVibraniumArmor;
    public static ForgeConfigSpec.ConfigValue<Integer> enchantmentValueVibraniumArmor;
    public static ForgeConfigSpec.ConfigValue<Integer> knockbackResistanceValueVibraniumArmor;
    public static ForgeConfigSpec.ConfigValue<Integer> protectionValueVibraniumBoots;
    public static ForgeConfigSpec.ConfigValue<Integer> protectionValueVibraniumLeggings;
    public static ForgeConfigSpec.ConfigValue<Integer> protectionValueVibraniumChestplate;
    public static ForgeConfigSpec.ConfigValue<Integer> protectionValueVibraniumHelmet;
    public static ForgeConfigSpec.ConfigValue<Integer> speedVibraniumTier;
    public static ForgeConfigSpec.ConfigValue<Integer> enchantmentValueVibraniumBow;
    public static ForgeConfigSpec.ConfigValue<Integer> damageVibraniumBow;
    public static ForgeConfigSpec.ConfigValue<Integer> attackDamageBonusVibraniumTier;
    public static ForgeConfigSpec.ConfigValue<Integer> enchantmentValueVibraniumTier;
    public static ForgeConfigSpec.ConfigValue<Integer> attackDamageVibraniumPickaxe;
    public static ForgeConfigSpec.ConfigValue<Integer> attackDamageVibraniumAxe;
    public static ForgeConfigSpec.ConfigValue<Integer> attackDamageVibraniumShovel;
    public static ForgeConfigSpec.ConfigValue<Integer> attackDamageVibraniumSword;
    public static ForgeConfigSpec.ConfigValue<Integer> attackDamageVibraniumHoe;
    public static ForgeConfigSpec.ConfigValue<Integer> attackDamageVibraniumPaxel;
    public static ForgeConfigSpec.ConfigValue<Integer> attackDamageVibraniumHammer;
    public static ForgeConfigSpec.ConfigValue<Integer> attackDamageVibraniumExcavator;
    public static ForgeConfigSpec.ConfigValue<Integer> protectionVibraniumHorseArmor;
    public static ForgeConfigSpec.ConfigValue<Integer> VeinsPerChunkVibranium;
    public static ForgeConfigSpec.ConfigValue<Integer> OrePerVeinVibranium;

    //VULPUS
    public static ForgeConfigSpec.ConfigValue<Integer> toughnessValueVulpusArmor;
    public static ForgeConfigSpec.ConfigValue<Integer> enchantmentValueVulpusArmor;
    public static ForgeConfigSpec.ConfigValue<Integer> knockbackResistanceValueVulpusArmor;
    public static ForgeConfigSpec.ConfigValue<Integer> protectionValueVulpusBoots;
    public static ForgeConfigSpec.ConfigValue<Integer> protectionValueVulpusLeggings;
    public static ForgeConfigSpec.ConfigValue<Integer> protectionValueVulpusChestplate;
    public static ForgeConfigSpec.ConfigValue<Integer> protectionValueVulpusHelmet;
    public static ForgeConfigSpec.ConfigValue<Integer> speedVulpusTier;
    public static ForgeConfigSpec.ConfigValue<Integer> enchantmentValueVulpusBow;
    public static ForgeConfigSpec.ConfigValue<Integer> damageVulpusBow;
    public static ForgeConfigSpec.ConfigValue<Integer> attackDamageBonusVulpusTier;
    public static ForgeConfigSpec.ConfigValue<Integer> enchantmentValueVulpusTier;
    public static ForgeConfigSpec.ConfigValue<Integer> attackDamageVulpusPickaxe;
    public static ForgeConfigSpec.ConfigValue<Integer> attackDamageVulpusAxe;
    public static ForgeConfigSpec.ConfigValue<Integer> attackDamageVulpusShovel;
    public static ForgeConfigSpec.ConfigValue<Integer> attackDamageVulpusSword;
    public static ForgeConfigSpec.ConfigValue<Integer> attackDamageVulpusHoe;
    public static ForgeConfigSpec.ConfigValue<Integer> attackDamageVulpusPaxel;
    public static ForgeConfigSpec.ConfigValue<Integer> attackDamageVulpusHammer;
    public static ForgeConfigSpec.ConfigValue<Integer> attackDamageVulpusExcavator;
    public static ForgeConfigSpec.ConfigValue<Integer> protectionVulpusHorseArmor;
    public static ForgeConfigSpec.ConfigValue<Integer> VeinsPerChunkVulpus;
    public static ForgeConfigSpec.ConfigValue<Integer> OrePerVeinVulpus;

    //ENDERIUM
    public static ForgeConfigSpec.ConfigValue<Integer> toughnessValueEnderiumArmor;
    public static ForgeConfigSpec.ConfigValue<Integer> enchantmentValueEnderiumArmor;
    public static ForgeConfigSpec.ConfigValue<Integer> knockbackResistanceValueEnderiumArmor;
    public static ForgeConfigSpec.ConfigValue<Integer> protectionValueEnderiumBoots;
    public static ForgeConfigSpec.ConfigValue<Integer> protectionValueEnderiumLeggings;
    public static ForgeConfigSpec.ConfigValue<Integer> protectionValueEnderiumChestplate;
    public static ForgeConfigSpec.ConfigValue<Integer> protectionValueEnderiumHelmet;
    public static ForgeConfigSpec.ConfigValue<Integer> speedEnderiumTier;
    public static ForgeConfigSpec.ConfigValue<Integer> enchantmentValueEnderiumBow;
    public static ForgeConfigSpec.ConfigValue<Integer> damageEnderiumBow;
    public static ForgeConfigSpec.ConfigValue<Integer> attackDamageBonusEnderiumTier;
    public static ForgeConfigSpec.ConfigValue<Integer> enchantmentValueEnderiumTier;
    public static ForgeConfigSpec.ConfigValue<Integer> attackDamageEnderiumPickaxe;
    public static ForgeConfigSpec.ConfigValue<Integer> attackDamageEnderiumAxe;
    public static ForgeConfigSpec.ConfigValue<Integer> attackDamageEnderiumShovel;
    public static ForgeConfigSpec.ConfigValue<Integer> attackDamageEnderiumSword;
    public static ForgeConfigSpec.ConfigValue<Integer> attackDamageEnderiumHoe;
    public static ForgeConfigSpec.ConfigValue<Integer> attackDamageEnderiumPaxel;
    public static ForgeConfigSpec.ConfigValue<Integer> attackDamageEnderiumHammer;
    public static ForgeConfigSpec.ConfigValue<Integer> attackDamageEnderiumExcavator;
    public static ForgeConfigSpec.ConfigValue<Integer> protectionEnderiumHorseArmor;
    public static ForgeConfigSpec.ConfigValue<Integer> VeinsPerChunkEnderium;
    public static ForgeConfigSpec.ConfigValue<Integer> OrePerVeinEnderium;

    public static void initmycfg(ForgeConfigSpec.Builder mycfg) {
        //VIBRANIUM

        mycfg.push("Vibranium Config");

        toughnessValueVibraniumArmor = mycfg
                .comment("Define Toughness Value for Vibranium Armor. Default = 145")
                .defineInRange("toughnessValueVibraniumArmor", 145, 0, Integer.MAX_VALUE);

        enchantmentValueVibraniumArmor = mycfg
                .comment("Define Enchantment Value for Vibranium Armor. Default = 85")
                .defineInRange("enchantmentValueVibraniumArmor", 85, 0, Integer.MAX_VALUE);

        knockbackResistanceValueVibraniumArmor = mycfg
                .comment("Define Knockback Resistance Value for Vibranium Armor. Default = 1")
                .defineInRange("knockbackResistanceValueVibraniumArmor", 1, 0, Integer.MAX_VALUE);

        protectionValueVibraniumBoots = mycfg
                .comment("Define Protection Value for Vibranium Boots. Default = 14")
                .defineInRange("protectionValueVibraniumBoots", 14, 0, Integer.MAX_VALUE);

        protectionValueVibraniumLeggings = mycfg
                .comment("Define Protection Value for Vibranium Leggings. Default = 20")
                .defineInRange("protectionValueVibraniumLeggings", 20, 0, Integer.MAX_VALUE);

        protectionValueVibraniumChestplate = mycfg
                .comment("Define Protection Value for Vibranium Chestplate. Default = 26")
                .defineInRange("protectionValueVibraniumChestplate", 26, 0, Integer.MAX_VALUE);

        protectionValueVibraniumHelmet = mycfg
                .comment("Define Protection Value for Vibranium Helmet. Default = 14")
                .defineInRange("protectionValueVibraniumHelmet", 14, 0, Integer.MAX_VALUE);

        speedVibraniumTier = mycfg
                .comment("Define Speed Value for Vibranium Tier. Default = 40")
                .defineInRange("speedVibraniumTier", 40, 0, Integer.MAX_VALUE);

        enchantmentValueVibraniumBow = mycfg
                .comment("Define Enchantment Value for Vibranium Bow. Default = 5")
                .defineInRange("enchantmentValueVibraniumBow", 5, 0, Integer.MAX_VALUE);

        damageVibraniumBow = mycfg
                .comment("Define Damage Value for Vibranium Bow. Default = 8")
                .defineInRange("damageVibraniumBow", 8, 0, Integer.MAX_VALUE);

        attackDamageBonusVibraniumTier = mycfg
                .comment("Define Attack Damage Bonus Value for Vibranium Tier. Default = 11")
                .defineInRange("attackDamageBonusVibraniumTier", 11, 0, Integer.MAX_VALUE);

        enchantmentValueVibraniumTier = mycfg
                .comment("Define Enchantment Value for Vibranium Tier. Default = 85")
                .defineInRange("enchantmentValueVibraniumTier", 85, 0, Integer.MAX_VALUE);

        attackDamageVibraniumPickaxe = mycfg
                .comment("Define Attack Damage Value for Vibranium Pickaxe. Default = 10")
                .defineInRange("attackDamageVibraniumPickaxe", 10, 0, Integer.MAX_VALUE);

        attackDamageVibraniumAxe = mycfg
                .comment("Define Attack Damage Value for Vibranium Axe. Default = 13")
                .defineInRange("attackDamageVibraniumAxe", 13, 0, Integer.MAX_VALUE);

        attackDamageVibraniumShovel = mycfg
                .comment("Define Attack Damage Value for Vibranium Shovel. Default = 11")
                .defineInRange("attackDamageVibraniumShovel", 11, 0, Integer.MAX_VALUE);

        attackDamageVibraniumSword = mycfg
                .comment("Define Attack Damage Value for Vibranium Sword. Default = 12")
                .defineInRange("attackDamageVibraniumSword", 12, 0, Integer.MAX_VALUE);

        attackDamageVibraniumHoe = mycfg
                .comment("Define Attack Damage Value for Vibranium Hoe. Default = 7")
                .defineInRange("attackDamageVibraniumHoe", 7, 0, Integer.MAX_VALUE);

        attackDamageVibraniumPaxel = mycfg
                .comment("Define Attack Damage Value for Vibranium Paxel. Default = 18")
                .defineInRange("attackDamageVibraniumPaxel", 18, 0, Integer.MAX_VALUE);

        attackDamageVibraniumHammer = mycfg
                .comment("Define Attack Damage Value for Vibranium Hammer. Default = 15")
                .defineInRange("attackDamageVibraniumHammer", 15, 0, Integer.MAX_VALUE);

        attackDamageVibraniumExcavator = mycfg
                .comment("Define Attack Damage Value for Vibranium Excavator. Default = 15")
                .defineInRange("attackDamageVibraniumExcavator", 15, 0, Integer.MAX_VALUE);

        protectionVibraniumHorseArmor = mycfg
                .comment("Define Protection Value for Vibranium Horse Armor. Default = 18")
                .defineInRange("protectionVibraniumHorseArmor", 18, 0, Integer.MAX_VALUE);

        VeinsPerChunkVibranium = mycfg
                .comment("Define How Many Vibranium Ore Veins Spawn per Chunk. Default = 6")
                .defineInRange("VeinsPerChunkVibranium", 6, 0, 64);

        OrePerVeinVibranium = mycfg
                .comment("Define How Many Vibranium Ore Spawn per Vein. Default = 5")
                .defineInRange("OrePerVeinVibranium", 5, 0, 64);

        mycfg.pop();

        //VULPUS

        mycfg.push("Vulpus Config");

        toughnessValueVulpusArmor = mycfg
                .comment("Define Toughness Value for Vulpus Armor. Default = 293")
                .defineInRange("toughnessValueVulpusArmor", 293, 0, Integer.MAX_VALUE);

        enchantmentValueVulpusArmor = mycfg
                .comment("Define Enchantment Value for Vulpus Armor. Default = 85")
                .defineInRange("enchantmentValueVulpusArmor", 85, 0, Integer.MAX_VALUE);

        knockbackResistanceValueVulpusArmor = mycfg
                .comment("Define Knockback Resistance Value for Vulpus Armor. Default = 2")
                .defineInRange("knockbackResistanceValueVulpusArmor", 2, 0, Integer.MAX_VALUE);

        protectionValueVulpusBoots = mycfg
                .comment("Define Protection Value for Vulpus Boots. Default = 26")
                .defineInRange("protectionValueVulpusBoots", 26, 0, Integer.MAX_VALUE);

        protectionValueVulpusLeggings = mycfg
                .comment("Define Protection Value for Vulpus Leggings. Default = 40")
                .defineInRange("protectionValueVulpusLeggings", 40, 0, Integer.MAX_VALUE);

        protectionValueVulpusChestplate = mycfg
                .comment("Define Protection Value for Vulpus Chestplate. Default = 53")
                .defineInRange("protectionValueVulpusChestplate", 53, 0, Integer.MAX_VALUE);

        protectionValueVulpusHelmet = mycfg
                .comment("Define Protection Value for Vulpus Helmet. Default = 26")
                .defineInRange("protectionValueVulpusHelmet", 26, 0, Integer.MAX_VALUE);

        speedVulpusTier = mycfg
                .comment("Define Speed Value for Vulpus Tier. Default = 75")
                .defineInRange("speedVulpusTier", 75, 0, Integer.MAX_VALUE);

        enchantmentValueVulpusBow = mycfg
                .comment("Define Enchantment Value for Vulpus Bow. Default = 5")
                .defineInRange("enchantmentValueVulpusBow", 5, 0, Integer.MAX_VALUE);

        damageVulpusBow = mycfg
                .comment("Define Damage Value for Vulpus Bow. Default = 12")
                .defineInRange("damageVulpusBow", 12, 0, Integer.MAX_VALUE);

        attackDamageBonusVulpusTier = mycfg
                .comment("Define Attack Damage Bonus Value for Vulpus Tier. Default = 20")
                .defineInRange("attackDamageBonusVulpusTier", 20, 0, Integer.MAX_VALUE);

        enchantmentValueVulpusTier = mycfg
                .comment("Define Enchantment Value for Vulpus Tier. Default = 85")
                .defineInRange("enchantmentValueVulpusTier", 85, 0, Integer.MAX_VALUE);

        attackDamageVulpusPickaxe = mycfg
                .comment("Define Attack Damage Value for Vulpus Pickaxe. Default = 20")
                .defineInRange("attackDamageVulpusPickaxe", 20, 0, Integer.MAX_VALUE);

        attackDamageVulpusAxe = mycfg
                .comment("Define Attack Damage Value for Vulpus Axe. Default = 25")
                .defineInRange("attackDamageVulpusAxe", 25, 0, Integer.MAX_VALUE);

        attackDamageVulpusShovel = mycfg
                .comment("Define Attack Damage Value for Vulpus Shovel. Default = 21")
                .defineInRange("attackDamageVulpusShovel", 21, 0, Integer.MAX_VALUE);

        attackDamageVulpusSword = mycfg
                .comment("Define Attack Damage Value for Vulpus Sword. Default = 24")
                .defineInRange("attackDamageVulpusSword", 24, 0, Integer.MAX_VALUE);

        attackDamageVulpusHoe = mycfg
                .comment("Define Attack Damage Value for Vulpus Hoe. Default = 13")
                .defineInRange("attackDamageVulpusHoe", 13, 0, Integer.MAX_VALUE);

        attackDamageVulpusPaxel = mycfg
                .comment("Define Attack Damage Value for Vulpus Paxel. Default = 27")
                .defineInRange("attackDamageVulpusPaxel", 27, 0, Integer.MAX_VALUE);

        attackDamageVulpusHammer = mycfg
                .comment("Define Attack Damage Value for Vulpus Hammer. Default = 22")
                .defineInRange("attackDamageVulpusHammer", 22, 0, Integer.MAX_VALUE);

        attackDamageVulpusExcavator = mycfg
                .comment("Define Attack Damage Value for Vulpus Excavator. Default = 22")
                .defineInRange("attackDamageVulpusExcavator", 22, 0, Integer.MAX_VALUE);

        protectionVulpusHorseArmor = mycfg
                .comment("Define Protection Value for Vulpus Horse Armor. Default = 36")
                .defineInRange("protectionVulpusHorseArmor", 36, 0, Integer.MAX_VALUE);

        VeinsPerChunkVulpus = mycfg
                .comment("Define How Many Vulpus Ore Veins Spawn per Chunk. Default = 5")
                .defineInRange("VeinsPerChunkVulpus", 5, 0, 64);

        OrePerVeinVulpus = mycfg
                .comment("Define How Many Vulpus Ore Spawn per Vein. Default = 4")
                .defineInRange("OrePerVeinVulpus", 4, 0, 64);

        mycfg.pop();

        //ENDERIUM

        mycfg.push("Enderium Config");

        toughnessValueEnderiumArmor = mycfg
                .comment("Define Toughness Value for Enderium Armor. Default = 880")
                .defineInRange("toughnessValueEnderiumArmor", 880, 0, Integer.MAX_VALUE);

        enchantmentValueEnderiumArmor = mycfg
                .comment("Define Enchantment Value for Enderium Armor. Default = 85")
                .defineInRange("enchantmentValueEnderiumArmor", 85, 0, Integer.MAX_VALUE);

        knockbackResistanceValueEnderiumArmor = mycfg
                .comment("Define Knockback Resistance Value for Enderium Armor. Default = 3")
                .defineInRange("knockbackResistanceValueEnderiumArmor", 3, 0, Integer.MAX_VALUE);

        protectionValueEnderiumBoots = mycfg
                .comment("Define Protection Value for Enderium Boots. Default = 80")
                .defineInRange("protectionValueEnderiumBoots", 80, 0, Integer.MAX_VALUE);

        protectionValueEnderiumLeggings = mycfg
                .comment("Define Protection Value for Enderium Leggings. Default = 120")
                .defineInRange("protectionValueEnderiumLeggings", 120, 0, Integer.MAX_VALUE);

        protectionValueEnderiumChestplate = mycfg
                .comment("Define Protection Value for Enderium Chestplate. Default = 160")
                .defineInRange("protectionValueEnderiumChestplate", 160, 0, Integer.MAX_VALUE);

        protectionValueEnderiumHelmet = mycfg
                .comment("Define Protection Value for Enderium Helmet. Default = 80")
                .defineInRange("protectionValueEnderiumHelmet", 80, 0, Integer.MAX_VALUE);

        speedEnderiumTier = mycfg
                .comment("Define Speed Value for Enderium Tier. Default = 115")
                .defineInRange("speedEnderiumTier", 115, 0, Integer.MAX_VALUE);

        enchantmentValueEnderiumBow = mycfg
                .comment("Define Enchantment Value for Enderium Bow. Default = 5")
                .defineInRange("enchantmentValueEnderiumBow", 5, 0, Integer.MAX_VALUE);

        damageEnderiumBow = mycfg
                .comment("Define Damage Value for Enderium Bow. Default = 16")
                .defineInRange("damageEnderiumBow", 16, 0, Integer.MAX_VALUE);

        attackDamageBonusEnderiumTier = mycfg
                .comment("Define Attack Damage Bonus Value for Enderium Tier. Default = 45")
                .defineInRange("attackDamageBonusEnderiumTier", 45, 0, Integer.MAX_VALUE);

        enchantmentValueEnderiumTier = mycfg
                .comment("Define Enchantment Value for Enderium Tier. Default = 85")
                .defineInRange("enchantmentValueEnderiumTier", 85, 0, Integer.MAX_VALUE);

        attackDamageEnderiumPickaxe = mycfg
                .comment("Define Attack Damage Value for Enderium Pickaxe. Default = 40")
                .defineInRange("attackDamageEnderiumPickaxe", 40, 0, Integer.MAX_VALUE);

        attackDamageEnderiumAxe = mycfg
                .comment("Define Attack Damage Value for Enderium Axe. Default = 51")
                .defineInRange("attackDamageEnderiumAxe", 51, 0, Integer.MAX_VALUE);

        attackDamageEnderiumShovel = mycfg
                .comment("Define Attack Damage Value for Enderium Shovel. Default = 42")
                .defineInRange("attackDamageEnderiumShovel", 42, 0, Integer.MAX_VALUE);

        attackDamageEnderiumSword = mycfg
                .comment("Define Attack Damage Value for Enderium Sword. Default = 47")
                .defineInRange("attackDamageEnderiumSword", 47, 0, Integer.MAX_VALUE);

        attackDamageEnderiumHoe = mycfg
                .comment("Define Attack Damage Value for Enderium Hoe. Default = 27")
                .defineInRange("attackDamageEnderiumHoe", 27, 0, Integer.MAX_VALUE);

        attackDamageEnderiumPaxel = mycfg
                .comment("Define Attack Damage Value for Enderium Paxel. Default = 55")
                .defineInRange("attackDamageEnderiumPaxel", 55, 0, Integer.MAX_VALUE);

        attackDamageEnderiumHammer = mycfg
                .comment("Define Attack Damage Value for Enderium Hammer. Default = 45")
                .defineInRange("attackDamageEnderiumHammer", 45, 0, Integer.MAX_VALUE);

        attackDamageEnderiumExcavator = mycfg
                .comment("Define Attack Damage Value for Enderium Excavator. Default = 45")
                .defineInRange("attackDamageEnderiumExcavator", 45, 0, Integer.MAX_VALUE);

        protectionEnderiumHorseArmor = mycfg
                .comment("Define Protection Value for Enderium Horse Armor. Default = 73")
                .defineInRange("protectionEnderiumHorseArmor", 73, 0, Integer.MAX_VALUE);

        VeinsPerChunkEnderium = mycfg
                .comment("Define How Many Enderium Ore Veins Spawn per Chunk. Default = 4")
                .defineInRange("VeinsPerChunkEnderium", 4, 0, 64);

        OrePerVeinEnderium = mycfg
                .comment("Define How Many Enderium Ore Spawn per Vein. Default = 3")
                .defineInRange("OrePerVeinEnderium", 3, 0, 64);

         mycfg.pop();
    }
}