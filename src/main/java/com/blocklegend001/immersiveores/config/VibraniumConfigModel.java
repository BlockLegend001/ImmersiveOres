package com.blocklegend001.immersiveores.config;

import blue.endless.jankson.Comment;
import com.blocklegend001.immersiveores.ImmersiveOres;
import io.wispforest.owo.config.annotation.*;

@Modmenu(modId = ImmersiveOres.MOD_ID)
@Config(name = "immersiveoresnew/vibranium-common", wrapperName = "VibraniumConfig")
public class VibraniumConfigModel {

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
        @Comment("Protection value of Vibranium Boots")
        @RestartRequired
        public int boots = 6;

        @Comment("Protection value of Vibranium Leggings")
        @RestartRequired
        public int leggings = 9;

        @Comment("Protection value of Vibranium Chestplate")
        @RestartRequired
        public int chestplate = 12;

        @Comment("Protection value of Vibranium Helmet")
        @RestartRequired
        public int helmet = 6;

        @Comment("Toughness value of Vibranium Armor")
        @RestartRequired
        public int toughness = 3;

        @Comment("Knockback resistance value of Vibranium Armor")
        @RestartRequired
        public int knockbackResistance = 1;

        @Comment("Enchantment value of Vibranium Armor")
        @RestartRequired
        public int enchantmentValue = 55;
    }

    // ---------------- ARMOR ABILITIES ----------------
    public static class ArmorAbilities {
        @Comment("Speed I effect for Vibranium Armor")
        @RestartRequired
        public boolean speed = true;

        @Comment("Jump I effect for Vibranium Armor")
        @RestartRequired
        public boolean jump = true;

        @Comment("Night Vision effect for Vibranium Armor")
        @RestartRequired
        public boolean nightVision = true;

        @Comment("Can walk on powdered snow with Vibranium Armor")
        @RestartRequired
        public boolean canWalkOnPowderedSnow = true;
    }

    // ---------------- BOW ----------------
    public static class BowSettings {
        @Comment("Enchantment value of Vibranium Bow")
        @RestartRequired
        public int enchantmentValue = 5;

        @Comment("Damage value of Vibranium Bow")
        @RestartRequired
        public int damage = 5;

        @Comment("Arrow count for Vibranium Bow")
        @RestartRequired
        public int arrowCount = 2;
    }

    // ---------------- TOOL TIER ----------------
    public static class ToolTierSettings {
        @Comment("Mining speed of Vibranium tools")
        @RestartRequired
        public int speed = 30;

        @Comment("Enchantment value of Vibranium tier")
        @RestartRequired
        public int enchantmentValue = 55;

        @Comment("Attack damage bonus of Vibranium tier")
        @RestartRequired
        public int attackDamageBonus = 1;

        @Comment("Durability of Vibranium tools")
        @RestartRequired
        public int durability = 2562;

        @Comment("Whether Vibranium tools are unbreakable")
        @RestartRequired
        public boolean unbreakable = false;
    }

    // ---------------- PICKAXE ----------------
    public static class PickaxeSettings {
        @Comment("Attack damage of Vibranium Pickaxe")
        @RestartRequired
        public int attackDamage = 7;

        @Comment("Attack speed of Vibranium Pickaxe")
        @RestartRequired
        public double attackSpeed = 0.5;
    }

    // ---------------- AXE ----------------
    public static class AxeSettings {
        @Comment("Attack damage of Vibranium Axe")
        @RestartRequired
        public int attackDamage = 12;

        @Comment("Attack speed of Vibranium Axe")
        @RestartRequired
        public double attackSpeed = 0.5;
    }

    // ---------------- SHOVEL ----------------
    public static class ShovelSettings {
        @Comment("Attack damage of Vibranium Shovel")
        @RestartRequired
        public int attackDamage = 7;

        @Comment("Attack speed of Vibranium Shovel")
        @RestartRequired
        public double attackSpeed = 0.5;
    }

    // ---------------- SWORD ----------------
    public static class SwordSettings {
        @Comment("Attack damage of Vibranium Sword")
        @RestartRequired
        public int attackDamage = 10;

        @Comment("Attack speed of Vibranium Sword")
        @RestartRequired
        public double attackSpeed = 0.5;
    }

    // ---------------- HOE ----------------
    public static class HoeSettings {
        @Comment("Attack damage of Vibranium Hoe")
        @RestartRequired
        public int attackDamage = 7;

        @Comment("Attack speed of Vibranium Hoe")
        @RestartRequired
        public double attackSpeed = 0.5;
    }

    // ---------------- PAXEL ----------------
    public static class PaxelSettings {
        @Comment("Attack damage of Vibranium Paxel")
        @RestartRequired
        public int attackDamage = 11;

        @Comment("Attack speed of Vibranium Paxel")
        @RestartRequired
        public double attackSpeed = 0.5;
    }

    // ---------------- HAMMER ----------------
    public static class HammerSettings {
        @Comment("Attack damage of Vibranium Hammer")
        @RestartRequired
        public int attackDamage = 7;

        @Comment("Attack speed of Vibranium Hammer")
        @RestartRequired
        public double attackSpeed = 0.5;

        @Comment("Hammering radius of Vibranium Hammer")
        @RestartRequired
        public int radius = 1;
    }

    // ---------------- EXCAVATOR ----------------
    public static class ExcavatorSettings {
        @Comment("Attack damage of Vibranium Excavator")
        @RestartRequired
        public int attackDamage = 7;

        @Comment("Attack speed of Vibranium Excavator")
        @RestartRequired
        public double attackSpeed = 0.5;

        @Comment("Excavation radius of Vibranium Excavator")
        @RestartRequired
        public int radius = 1;
    }
}
