package com.blocklegend001.immersiveores.config;

import blue.endless.jankson.Comment;
import io.wispforest.owo.config.annotation.*;

@Config(name = "immersiveoresnew/enderium-common", wrapperName = "EnderiumConfig")
public class EnderiumConfigModel {

    @SectionHeader("Armor Protection and Resistance")
    public ArmorSettings armor = new ArmorSettings();

    @SectionHeader("Armor Special Abilities")
    public ArmorAbilities armorAbilities = new ArmorAbilities();

    @SectionHeader("Bow Settings")
    public BowSettings bow = new BowSettings();

    @SectionHeader("Tool Tier Base Properties")
    public ToolTierSettings toolTier = new ToolTierSettings();

    @SectionHeader("Pickaxe Stats")
    public PickaxeSettings pickaxe = new PickaxeSettings();

    @SectionHeader("Axe Stats")
    public AxeSettings axe = new AxeSettings();

    @SectionHeader("Shovel Stats")
    public ShovelSettings shovel = new ShovelSettings();

    @SectionHeader("Sword Stats")
    public SwordSettings sword = new SwordSettings();

    @SectionHeader("Hoe Stats")
    public HoeSettings hoe = new HoeSettings();

    @SectionHeader("Paxel Stats")
    public PaxelSettings paxel = new PaxelSettings();

    @SectionHeader("Hammer Stats")
    public HammerSettings hammer = new HammerSettings();

    @SectionHeader("Excavator Stats")
    public ExcavatorSettings excavator = new ExcavatorSettings();

    // ---------------- ARMOR ----------------
    public static class ArmorSettings {
        @Comment("Protection value of Enderium Boots")
        @RestartRequired
        public int boots = 12;

        @Comment("Protection value of Enderium Leggings")
        @RestartRequired
        public int leggings = 16;

        @Comment("Protection value of Enderium Chestplate")
        @RestartRequired
        public int chestplate = 20;

        @Comment("Protection value of Enderium Helmet")
        @RestartRequired
        public int helmet = 12;

        @Comment("Toughness value of Enderium Armor")
        @RestartRequired
        public int toughness = 10;

        @Comment("Knockback resistance value of Enderium Armor")
        @RestartRequired
        public int knockbackResistance = 3;

        @Comment("Enchantment value of Enderium Armor")
        @RestartRequired
        public int enchantmentValue = 65;
    }

    // ---------------- ARMOR ABILITIES ----------------
    public static class ArmorAbilities {
        @Comment("Speed III effect for Enderium Armor")
        @RestartRequired
        public boolean speedIII = true;

        @Comment("Jump III effect for Enderium Armor")
        @RestartRequired
        public boolean jumpIII = true;

        @Comment("Night Vision effect for Enderium Armor")
        @RestartRequired
        public boolean nightVision = true;

        @Comment("Immunity to fall damage for Enderium Armor")
        @RestartRequired
        public boolean immuneToFallDamage = true;

        @Comment("Fire resistance for Enderium Armor")
        @RestartRequired
        public boolean fireResistance = true;

        @Comment("Never lose hunger while wearing Enderium Armor")
        @RestartRequired
        public boolean neverLoseHunger = true;

        @Comment("Grants the ability to fly with Enderium Armor")
        @RestartRequired
        public boolean canFly = true;

        @Comment("Can walk on powdered snow with Enderium Armor")
        @RestartRequired
        public boolean canWalkOnPowderedSnow = true;

        @Comment("Piglins are neutral while wearing Enderium Armor")
        @RestartRequired
        public boolean makesPiglinsNeutral = true;

        @Comment("Endermen will not get angry at you while wearing Enderium Armor")
        @RestartRequired
        public boolean endermenNeutral = true;
    }

    // ---------------- BOW ----------------
    public static class BowSettings {
        @Comment("Enchantment value of Enderium Bow")
        @RestartRequired
        public int enchantmentValue = 5;

        @Comment("Damage value of Enderium Bow")
        @RestartRequired
        public int damage = 14;

        @Comment("Arrow count for Enderium Bow")
        @RestartRequired
        public int arrowCount = 4;
    }

    // ---------------- TOOL TIER ----------------
    public static class ToolTierSettings {
        @Comment("Mining speed of Enderium tools")
        @RestartRequired
        public int speed = 50;

        @Comment("Enchantment value of Enderium tools")
        @RestartRequired
        public int enchantmentValue = 65;

        @Comment("Attack damage bonus of Enderium tool tier")
        @RestartRequired
        public int attackDamageBonus = 3;

        @Comment("Durability of Enderium tools")
        @RestartRequired
        public int durability = 5139;

        @Comment("Whether Enderium tools are unbreakable")
        @RestartRequired
        public boolean unbreakable = false;
    }

    // ---------------- PICKAXE ----------------
    public static class PickaxeSettings {
        @Comment("Attack damage of Enderium Pickaxe")
        @RestartRequired
        public int attackDamage = 15;

        @Comment("Attack speed of Enderium Pickaxe")
        @RestartRequired
        public double attackSpeed = 1.0;
    }

    // ---------------- AXE ----------------
    public static class AxeSettings {
        @Comment("Attack damage of Enderium Axe")
        @RestartRequired
        public int attackDamage = 18;

        @Comment("Attack speed of Enderium Axe")
        @RestartRequired
        public double attackSpeed = 1.0;
    }

    // ---------------- SHOVEL ----------------
    public static class ShovelSettings {
        @Comment("Attack damage of Enderium Shovel")
        @RestartRequired
        public int attackDamage = 15;

        @Comment("Attack speed of Enderium Shovel")
        @RestartRequired
        public double attackSpeed = 1.0;
    }

    // ---------------- SWORD ----------------
    public static class SwordSettings {
        @Comment("Attack damage of Enderium Sword")
        @RestartRequired
        public int attackDamage = 22;

        @Comment("Attack speed of Enderium Sword")
        @RestartRequired
        public double attackSpeed = 1.0;
    }

    // ---------------- HOE ----------------
    public static class HoeSettings {
        @Comment("Attack damage of Enderium Hoe")
        @RestartRequired
        public int attackDamage = 15;

        @Comment("Attack speed of Enderium Hoe")
        @RestartRequired
        public double attackSpeed = 1.0;
    }

    // ---------------- PAXEL ----------------
    public static class PaxelSettings {
        @Comment("Attack damage of Enderium Paxel")
        @RestartRequired
        public int attackDamage = 18;

        @Comment("Attack speed of Enderium Paxel")
        @RestartRequired
        public double attackSpeed = 1.0;
    }

    // ---------------- HAMMER ----------------
    public static class HammerSettings {
        @Comment("Attack damage of Enderium Hammer")
        @RestartRequired
        public int attackDamage = 16;

        @Comment("Attack speed of Enderium Hammer")
        @RestartRequired
        public double attackSpeed = 1.0;

        @Comment("Hammering radius of Enderium Hammer")
        @RestartRequired
        public int radius = 3;
    }

    // ---------------- EXCAVATOR ----------------
    public static class ExcavatorSettings {
        @Comment("Attack damage of Enderium Excavator")
        @RestartRequired
        public int attackDamage = 16;

        @Comment("Attack speed of Enderium Excavator")
        @RestartRequired
        public double attackSpeed = 1.0;

        @Comment("Excavation radius of Enderium Excavator")
        @RestartRequired
        public int radius = 3;
    }
}
