package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.ImmersiveOresConfig;
import com.blocklegend001.immersiveores.item.custom.enderium.EnderiumAxe;
import com.blocklegend001.immersiveores.item.custom.enderium.EnderiumPaxel;
import com.blocklegend001.immersiveores.item.custom.vibranium.*;
import com.blocklegend001.immersiveores.item.custom.vulpus.*;
import com.blocklegend001.immersiveores.item.custom.enderium.*;
import com.blocklegend001.immersiveores.util.BowTiers;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ImmersiveOres.MODID);

    //RAW
    public static final RegistryObject<Item> RAW_VIBRANIUM = ITEMS.register("raw_vibranium",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> RAW_VULPUS = ITEMS.register("raw_vulpus",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> RAW_ENDERIUM = ITEMS.register("raw_enderium",
            () -> new Item(new Item.Properties().fireResistant()));

    //INGOT
    public static final RegistryObject<Item> VIBRANIUM_INGOT = ITEMS.register("vibranium_ingot",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> VULPUS_INGOT = ITEMS.register("vulpus_ingot",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> ENDERIUM_INGOT = ITEMS.register("enderium_ingot",
            () -> new Item(new Item.Properties().fireResistant()));

    //NUGGET
    public static final RegistryObject<Item> VIBRANIUM_NUGGET = ITEMS.register("vibranium_nugget",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> VULPUS_NUGGET = ITEMS.register("vulpus_nugget",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> ENDERIUM_NUGGET = ITEMS.register("enderium_nugget",
            () -> new Item(new Item.Properties().fireResistant()));


    //STICK
    public static final RegistryObject<Item> VIBRANIUM_STICK = ITEMS.register("vibranium_stick",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> VULPUS_STICK = ITEMS.register("vulpus_stick",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> ENDERIUM_STICK = ITEMS.register("enderium_stick",
            () -> new Item(new Item.Properties().fireResistant()));

    //VIBRANIUM
    public static final RegistryObject<Item> VIBRANIUM_PICKAXE = ITEMS.register("vibranium_pickaxe",
            () -> new VibraniumPickaxe(ModToolTiers.VIBRANIUM, ImmersiveOresConfig.attackDamageVibraniumPickaxe.get(), 2f,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> VIBRANIUM_SHOVEL = ITEMS.register("vibranium_shovel",
            () -> new VibraniumShovel(ModToolTiers.VIBRANIUM, ImmersiveOresConfig.attackDamageVibraniumShovel.get(), 2f,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> VIBRANIUM_AXE = ITEMS.register("vibranium_axe",
            () -> new VibraniumAxe(ModToolTiers.VIBRANIUM, ImmersiveOresConfig.attackDamageVibraniumAxe.get(), 2f,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> VIBRANIUM_SWORD = ITEMS.register("vibranium_sword",
            () -> new VibraniumSword(ModToolTiers.VIBRANIUM, ImmersiveOresConfig.attackDamageVibraniumSword.get(), 2f,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> VIBRANIUM_BOW = ITEMS.register("vibranium_bow",
            () -> new VibraniumBow(BowTiers.VIBRANIUM, (new Item.Properties().stacksTo(1).fireResistant())));

    public static final RegistryObject<Item> VIBRANIUM_HOE = ITEMS.register("vibranium_hoe",
            () -> new VibraniumHoe(ModToolTiers.VIBRANIUM, ImmersiveOresConfig.attackDamageVibraniumHoe.get(), 2f,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> VIBRANIUM_PAXEL = ITEMS.register("vibranium_paxel",
            () -> new VibraniumPaxel(ModToolTiers.VIBRANIUM, ImmersiveOresConfig.attackDamageVibraniumPaxel.get(), 2f,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> VIBRANIUM_HAMMER = ITEMS.register("vibranium_hammer",
            () -> new VibraniumHammer(ModToolTiers.VIBRANIUM, ImmersiveOresConfig.attackDamageVibraniumHammer.get(), 2f,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> VIBRANIUM_EXCAVATOR = ITEMS.register("vibranium_excavator",
            () -> new VibraniumExcavator(ModToolTiers.VIBRANIUM, ImmersiveOresConfig.attackDamageVibraniumExcavator.get(), 2f,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> VIBRANIUM_HELMET = ITEMS.register("vibranium_helmet",
            () -> new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> VIBRANIUM_CHESTPLATE = ITEMS.register("vibranium_chestplate",
            () -> new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> VIBRANIUM_LEGGINGS = ITEMS.register("vibranium_leggings",
            () -> new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> VIBRANIUM_BOOTS = ITEMS.register("vibranium_boots",
            () -> new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorItem.Type.BOOTS,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> VIBRANIUM_HORSE_ARMOR = ITEMS.register("vibranium_horse_armor",
            () -> new HorseArmorItem(ImmersiveOresConfig.protectionVibraniumHorseArmor.get(), "vibranium",
                    new Item.Properties().stacksTo(1).fireResistant()));

    //VULPUS
    public static final RegistryObject<Item> VULPUS_PICKAXE = ITEMS.register("vulpus_pickaxe",
            () -> new VulpusPickaxe(ModToolTiers.VULPUS, ImmersiveOresConfig.attackDamageVulpusPickaxe.get(), 2f,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> VULPUS_AXE = ITEMS.register("vulpus_axe",
            () -> new VulpusAxe(ModToolTiers.VULPUS, ImmersiveOresConfig.attackDamageVulpusAxe.get(), 2f,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> VULPUS_SHOVEL = ITEMS.register("vulpus_shovel",
            () -> new VulpusShovel(ModToolTiers.VULPUS, ImmersiveOresConfig.attackDamageVulpusShovel.get(), 2f,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> VULPUS_SWORD = ITEMS.register("vulpus_sword",
            () -> new VulpusSword(ModToolTiers.VULPUS, ImmersiveOresConfig.attackDamageVulpusSword.get(), 2f,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> VULPUS_BOW = ITEMS.register("vulpus_bow",
            () -> new VulpusBow(BowTiers.VULPUS, (new Item.Properties().stacksTo(1).fireResistant())));

    public static final RegistryObject<Item> VULPUS_HOE = ITEMS.register("vulpus_hoe",
            () -> new VulpusHoe(ModToolTiers.VULPUS, ImmersiveOresConfig.attackDamageVulpusHoe.get(), 2f,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> VULPUS_PAXEL = ITEMS.register("vulpus_paxel",
            () -> new VulpusPaxel(ModToolTiers.VULPUS, ImmersiveOresConfig.attackDamageVulpusPaxel.get(), 2f,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> VULPUS_HAMMER = ITEMS.register("vulpus_hammer",
            () -> new VulpusHammer(ModToolTiers.VULPUS, ImmersiveOresConfig.attackDamageVulpusHammer.get(), 2f,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> VULPUS_EXCAVATOR = ITEMS.register("vulpus_excavator",
            () -> new VulpusExcavator(ModToolTiers.VULPUS, ImmersiveOresConfig.attackDamageVulpusExcavator.get(), 2f,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> VULPUS_HELMET = ITEMS.register("vulpus_helmet",
            () -> new VulpusArmor(ModArmorMaterials.VULPUS, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> VULPUS_CHESTPLATE = ITEMS.register("vulpus_chestplate",
            () -> new VulpusArmor(ModArmorMaterials.VULPUS, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> VULPUS_LEGGINGS = ITEMS.register("vulpus_leggings",
            () -> new VulpusArmor(ModArmorMaterials.VULPUS, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> VULPUS_BOOTS = ITEMS.register("vulpus_boots",
            () -> new VulpusArmor(ModArmorMaterials.VULPUS, ArmorItem.Type.BOOTS,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> VULPUS_HORSE_ARMOR = ITEMS.register("vulpus_horse_armor",
            () -> new HorseArmorItem(ImmersiveOresConfig.protectionVulpusHorseArmor.get(), "enderium",
                    new Item.Properties().stacksTo(1).fireResistant()));

    //ENDERIUM
    public static final RegistryObject<Item> ENDERIUM_PICKAXE = ITEMS.register("enderium_pickaxe",
            () -> new EnderiumPickaxe(ModToolTiers.ENDERIUM, ImmersiveOresConfig.attackDamageEnderiumPickaxe.get(), 2f,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> ENDERIUM_AXE = ITEMS.register("enderium_axe",
            () -> new EnderiumAxe(ModToolTiers.ENDERIUM, ImmersiveOresConfig.attackDamageEnderiumAxe.get(), 2f,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> ENDERIUM_SHOVEL = ITEMS.register("enderium_shovel",
            () -> new EnderiumShovel(ModToolTiers.ENDERIUM, ImmersiveOresConfig.attackDamageEnderiumShovel.get(), 2f,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> ENDERIUM_SWORD = ITEMS.register("enderium_sword",
            () -> new EnderiumSword(ModToolTiers.ENDERIUM, ImmersiveOresConfig.attackDamageEnderiumSword.get(), 2f,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> ENDERIUM_BOW = ITEMS.register("enderium_bow",
            () -> new EnderiumBow(BowTiers.ENDERIUM, (new Item.Properties().stacksTo(1).fireResistant())));

    public static final RegistryObject<Item> ENDERIUM_HOE = ITEMS.register("enderium_hoe",
            () -> new EnderiumHoe(ModToolTiers.ENDERIUM, ImmersiveOresConfig.attackDamageEnderiumHoe.get(), 2f,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> ENDERIUM_PAXEL = ITEMS.register("enderium_paxel",
            () -> new EnderiumPaxel(ModToolTiers.ENDERIUM, ImmersiveOresConfig.attackDamageEnderiumPaxel.get(), 2f,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> ENDERIUM_HAMMER = ITEMS.register("enderium_hammer",
            () -> new EnderiumHammer(ModToolTiers.ENDERIUM, ImmersiveOresConfig.attackDamageEnderiumHammer.get(), 1f,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> ENDERIUM_EXCAVATOR = ITEMS.register("enderium_excavator",
            () -> new EnderiumExcavator(ModToolTiers.ENDERIUM, ImmersiveOresConfig.attackDamageEnderiumExcavator.get(), 1f,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> ENDERIUM_HELMET = ITEMS.register("enderium_helmet",
            () -> new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorItem.Type.HELMET,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> ENDERIUM_CHESTPLATE = ITEMS.register("enderium_chestplate",
            () -> new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> ENDERIUM_LEGGINGS = ITEMS.register("enderium_leggings",
            () -> new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> ENDERIUM_BOOTS = ITEMS.register("enderium_boots",
            () -> new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorItem.Type.BOOTS,
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static final RegistryObject<Item> ENDERIUM_HORSE_ARMOR = ITEMS.register("enderium_horse_armor",
            () -> new HorseArmorItem(ImmersiveOresConfig.protectionEnderiumHorseArmor.get(), "enderium",
                    new Item.Properties().stacksTo(1).fireResistant()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
