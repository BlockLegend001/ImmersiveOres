package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.item.custom.enderium.*;
import com.blocklegend001.immersiveores.item.custom.vibranium.*;
import com.blocklegend001.immersiveores.item.custom.vulpus.*;
import com.blocklegend001.immersiveores.util.color.ColoredItem;
import com.blocklegend001.immersiveores.util.tools.bow.BowTiers;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;

public class ModItems {

    //RAW
    public static final Item RAW_VIBRANIUM = registerItem("raw_vibranium",
            properties ->  new ColoredItem(properties.fireResistant(), ChatFormatting.LIGHT_PURPLE));

    public static final Item RAW_VULPUS = registerItem("raw_vulpus",
            properties -> new ColoredItem(properties.fireResistant(), ChatFormatting.RED));

    public static final Item RAW_ENDERIUM = registerItem("raw_enderium",
            properties -> new ColoredItem(properties.fireResistant(), ChatFormatting.DARK_AQUA));

    //INGOT
    public static final Item VIBRANIUM_INGOT = registerItem("vibranium_ingot",
            properties -> new ColoredItem(properties.fireResistant(), ChatFormatting.LIGHT_PURPLE));

    public static final Item VULPUS_INGOT = registerItem("vulpus_ingot",
            properties -> new ColoredItem(properties.fireResistant(), ChatFormatting.RED));

    public static final Item ENDERIUM_INGOT = registerItem("enderium_ingot",
            properties -> new ColoredItem(properties.fireResistant(), ChatFormatting.DARK_AQUA));

    //NUGGET
    public static final Item VIBRANIUM_NUGGET = registerItem("vibranium_nugget",
            properties -> new ColoredItem(properties.fireResistant(), ChatFormatting.LIGHT_PURPLE));

    public static final Item VULPUS_NUGGET = registerItem("vulpus_nugget",
            properties -> new ColoredItem(properties.fireResistant(), ChatFormatting.RED));

    public static final Item ENDERIUM_NUGGET = registerItem("enderium_nugget",
            properties -> new ColoredItem(properties.fireResistant(), ChatFormatting.DARK_AQUA));

    //STICK
    public static final Item VIBRANIUM_STICK = registerItem("vibranium_stick",
            properties -> new ColoredItem(properties.fireResistant(), ChatFormatting.LIGHT_PURPLE));

    public static final Item VULPUS_STICK = registerItem("vulpus_stick",
            properties -> new ColoredItem(properties.fireResistant(), ChatFormatting.RED));

    public static final Item ENDERIUM_STICK = registerItem("enderium_stick",
            properties -> new ColoredItem(properties.fireResistant(), ChatFormatting.DARK_AQUA));

    //VIBRANIUM
    public static final Item VIBRANIUM_PICKAXE = registerItem("vibranium_pickaxe",
            properties -> new VibraniumPickaxe(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumPickaxe, (float) VibraniumConfig.attackSpeedVibraniumPickaxe,
                    properties.fireResistant()));

    public static final Item VIBRANIUM_SHOVEL = registerItem("vibranium_shovel",
            properties -> new VibraniumShovel(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumShovel, (float) VibraniumConfig.attackSpeedVibraniumShovel,
                    properties.fireResistant()));

    public static final Item VIBRANIUM_AXE = registerItem("vibranium_axe",
            properties -> new VibraniumAxe(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumAxe, (float) VibraniumConfig.attackSpeedVibraniumAxe,
                    properties.fireResistant()));

    public static final Item VIBRANIUM_SWORD = registerItem("vibranium_sword",
            properties -> new VibraniumSword(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumSword, (float) VibraniumConfig.attackSpeedVibraniumSword,
                    properties.fireResistant()));

    public static final Item VIBRANIUM_BOW = registerItem("vibranium_bow",
            properties -> new VibraniumBow(BowTiers.VIBRANIUM, (properties.fireResistant())));

    public static final Item VIBRANIUM_HOE = registerItem("vibranium_hoe",
            properties -> new VibraniumHoe(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumHoe, (float) VibraniumConfig.attackSpeedVibraniumHoe,
                    properties.fireResistant()));

    public static final Item VIBRANIUM_PAXEL = registerItem("vibranium_paxel",
            properties -> new VibraniumPaxel(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumPaxel, (float) VibraniumConfig.attackSpeedVibraniumPaxel,
                    properties.fireResistant()));

    public static final Item VIBRANIUM_HAMMER = registerItem("vibranium_hammer",
            properties -> new VibraniumHammer(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumHammer, (float) VibraniumConfig.attackSpeedVibraniumHammer,
                    properties.fireResistant()));

    public static final Item VIBRANIUM_EXCAVATOR = registerItem("vibranium_excavator",
            properties -> new VibraniumExcavator(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumExcavator, (float) VibraniumConfig.attackSpeedVibraniumExcavator,
                    properties.fireResistant()));

    public static final Item VIBRANIUM_HELMET = registerItem("vibranium_helmet",
            properties -> new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorType.HELMET,
                    properties.fireResistant().stacksTo(1)));

    public static final Item VIBRANIUM_CHESTPLATE = registerItem("vibranium_chestplate",
            properties -> new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorType.CHESTPLATE,
                    properties.fireResistant().stacksTo(1)));

    public static final Item VIBRANIUM_LEGGINGS = registerItem("vibranium_leggings",
            properties -> new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorType.LEGGINGS,
                    properties.fireResistant().stacksTo(1)));

    public static final Item VIBRANIUM_BOOTS = registerItem("vibranium_boots",
            properties -> new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorType.BOOTS,
                    properties.fireResistant().stacksTo(1)));

    public static final Item VIBRANIUM_HORSE_ARMOR = registerItem("vibranium_horse_armor",
            properties -> new Item(properties.fireResistant().horseArmor(ModArmorMaterials.VIBRANIUM).stacksTo(1)) {
                @Override
                public Component getName(ItemStack stack) {
                    return super.getName(stack).copy().withStyle(ChatFormatting.LIGHT_PURPLE);
                }
            });

    //VULPUS
    public static final Item VULPUS_PICKAXE = registerItem("vulpus_pickaxe",
            properties -> new VulpusPickaxe(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusPickaxe, (float) VulpusConfig.attackSpeedVulpusPickaxe,
                    properties.fireResistant()));

    public static final Item VULPUS_SHOVEL = registerItem("vulpus_shovel",
            properties -> new VulpusShovel(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusShovel, (float) VulpusConfig.attackSpeedVulpusShovel,
                    properties.fireResistant()));

    public static final Item VULPUS_AXE = registerItem("vulpus_axe",
            properties -> new VulpusAxe(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusAxe, (float) VulpusConfig.attackSpeedVulpusAxe,
                    properties.fireResistant()));

    public static final Item VULPUS_SWORD = registerItem("vulpus_sword",
            properties -> new VulpusSword(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusSword, (float) VulpusConfig.attackSpeedVulpusSword,
                    properties.fireResistant()));

    public static final Item VULPUS_BOW = registerItem("vulpus_bow",
            properties -> new VulpusBow(BowTiers.VULPUS, (properties.fireResistant())));

    public static final Item VULPUS_HOE = registerItem("vulpus_hoe",
            properties -> new VulpusHoe(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusHoe, (float) VulpusConfig.attackSpeedVulpusHoe,
                    properties.fireResistant()));

    public static final Item VULPUS_PAXEL = registerItem("vulpus_paxel",
            properties -> new VulpusPaxel(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusPaxel, (float) VulpusConfig.attackSpeedVulpusPaxel,
                    properties.fireResistant()));

    public static final Item VULPUS_HAMMER = registerItem("vulpus_hammer",
            properties -> new VulpusHammer(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusHammer, (float) VulpusConfig.attackSpeedVulpusHammer,
                    properties.fireResistant()));

    public static final Item VULPUS_EXCAVATOR = registerItem("vulpus_excavator",
            properties -> new VulpusExcavator(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusExcavator, (float) VulpusConfig.attackSpeedVulpusExcavator,
                    properties.fireResistant()));

    public static final Item VULPUS_HELMET = registerItem("vulpus_helmet",
            properties -> new VulpusArmor(ModArmorMaterials.VULPUS, ArmorType.HELMET,
                    properties.fireResistant().stacksTo(1)));

    public static final Item VULPUS_CHESTPLATE = registerItem("vulpus_chestplate",
            properties -> new VulpusArmor(ModArmorMaterials.VULPUS, ArmorType.CHESTPLATE,
                    properties.fireResistant().stacksTo(1)));

    public static final Item VULPUS_LEGGINGS = registerItem("vulpus_leggings",
            properties -> new VulpusArmor(ModArmorMaterials.VULPUS, ArmorType.LEGGINGS,
                    properties.fireResistant().stacksTo(1)));

    public static final Item VULPUS_BOOTS = registerItem("vulpus_boots",
            properties -> new VulpusArmor(ModArmorMaterials.VULPUS, ArmorType.BOOTS,
                    properties.fireResistant().stacksTo(1)));

    public static final Item VULPUS_HORSE_ARMOR = registerItem("vulpus_horse_armor",
            properties -> new Item(properties.fireResistant().horseArmor(ModArmorMaterials.VULPUS).stacksTo(1)) {
                @Override
                public Component getName(ItemStack stack) {
                    return super.getName(stack).copy().withStyle(ChatFormatting.RED);
                }
            });

    //ENDERIUM
    public static final Item ENDERIUM_PICKAXE = registerItem("enderium_pickaxe",
            properties -> new EnderiumPickaxe(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumPickaxe, (float) EnderiumConfig.attackSpeedEnderiumPickaxe,
                    properties.fireResistant()));

    public static final Item ENDERIUM_SHOVEL = registerItem("enderium_shovel",
            properties -> new EnderiumShovel(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumShovel, (float) EnderiumConfig.attackSpeedEnderiumShovel,
                    properties.fireResistant()));

    public static final Item ENDERIUM_AXE = registerItem("enderium_axe",
            properties -> new EnderiumAxe(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumAxe, (float) EnderiumConfig.attackSpeedEnderiumAxe,
                    properties.fireResistant()));

    public static final Item ENDERIUM_SWORD = registerItem("enderium_sword",
            properties -> new EnderiumSword(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumSword, (float) EnderiumConfig.attackSpeedEnderiumSword,
                    properties.fireResistant()));

    public static final Item ENDERIUM_BOW = registerItem("enderium_bow",
            properties -> new EnderiumBow(BowTiers.ENDERIUM, (properties.fireResistant())));

    public static final Item ENDERIUM_HOE = registerItem("enderium_hoe",
            properties -> new EnderiumHoe(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumHoe, (float) EnderiumConfig.attackSpeedEnderiumHoe,
                    properties.fireResistant()));

    public static final Item ENDERIUM_PAXEL = registerItem("enderium_paxel",
            properties -> new EnderiumPaxel(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumPaxel, (float) EnderiumConfig.attackSpeedEnderiumPaxel,
                    properties.fireResistant()));

    public static final Item ENDERIUM_HAMMER = registerItem("enderium_hammer",
            properties -> new EnderiumHammer(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumHammer, (float) EnderiumConfig.attackSpeedEnderiumHammer,
                    properties.fireResistant()));

    public static final Item ENDERIUM_EXCAVATOR = registerItem("enderium_excavator",
            properties -> new EnderiumExcavator(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumExcavator, (float) EnderiumConfig.attackSpeedEnderiumExcavator,
                    properties.fireResistant()));

    public static final Item ENDERIUM_HELMET = registerItem("enderium_helmet",
            properties -> new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorType.HELMET,
                    properties.fireResistant().stacksTo(1)));

    public static final Item ENDERIUM_CHESTPLATE = registerItem("enderium_chestplate",
            properties -> new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorType.CHESTPLATE,
                    properties.fireResistant().stacksTo(1)));

    public static final Item ENDERIUM_LEGGINGS = registerItem("enderium_leggings",
            properties -> new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorType.LEGGINGS,
                    properties.fireResistant().stacksTo(1)));

    public static final Item ENDERIUM_BOOTS = registerItem("enderium_boots",
            properties -> new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorType.BOOTS,
                    properties.fireResistant().stacksTo(1)));

    public static final Item ENDERIUM_HORSE_ARMOR = registerItem("enderium_horse_armor",
            properties -> new Item(properties.fireResistant().horseArmor(ModArmorMaterials.ENDERIUM).stacksTo(1)) {
                @Override
                public Component getName(ItemStack stack) {
                    return super.getName(stack).copy().withStyle(ChatFormatting.DARK_AQUA);
                }
            });

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(ImmersiveOres.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ImmersiveOres.MOD_ID, name)))));
    }

    public static void registerModItems() {
        ImmersiveOres.LOGGER.info("Registering Mod Items for " + ImmersiveOres.MOD_ID);
    }
}
