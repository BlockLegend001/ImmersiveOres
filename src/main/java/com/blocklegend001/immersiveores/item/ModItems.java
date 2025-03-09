package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.item.custom.enderium.*;
import com.blocklegend001.immersiveores.item.custom.vibranium.*;
import com.blocklegend001.immersiveores.item.custom.vulpus.*;
import com.blocklegend001.immersiveores.util.BowTiers;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ImmersiveOres.MODID);

    //RAW
    public static final RegistryObject<Item> RAW_VIBRANIUM = ITEMS.register("raw_vibranium",
            () -> new Item(new Item.Properties().fireResistant()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "raw_vibranium")))));

    public static final RegistryObject<Item> RAW_VULPUS = ITEMS.register("raw_vulpus",
            () -> new Item(new Item.Properties().fireResistant()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "raw_vulpus")))));

    public static final RegistryObject<Item> RAW_ENDERIUM = ITEMS.register("raw_enderium",
            () -> new Item(new Item.Properties().fireResistant()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "raw_enderium")))));

    //INGOT
    public static final RegistryObject<Item> VIBRANIUM_INGOT = ITEMS.register("vibranium_ingot",
            () -> new Item(new Item.Properties().fireResistant()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vibranium_ingot")))));

    public static final RegistryObject<Item> VULPUS_INGOT = ITEMS.register("vulpus_ingot",
            () -> new Item(new Item.Properties().fireResistant()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vulpus_ingot")))));

    public static final RegistryObject<Item> ENDERIUM_INGOT = ITEMS.register("enderium_ingot",
            () -> new Item(new Item.Properties().fireResistant()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "enderium_ingot")))));

    //NUGGET
    public static final RegistryObject<Item> VIBRANIUM_NUGGET = ITEMS.register("vibranium_nugget",
            () -> new Item(new Item.Properties().fireResistant()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vibranium_nugget")))));

    public static final RegistryObject<Item> VULPUS_NUGGET = ITEMS.register("vulpus_nugget",
            () -> new Item(new Item.Properties().fireResistant()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vulpus_nugget")))));

    public static final RegistryObject<Item> ENDERIUM_NUGGET = ITEMS.register("enderium_nugget",
            () -> new Item(new Item.Properties().fireResistant()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "enderium_nugget")))));

    //STICK
    public static final RegistryObject<Item> VIBRANIUM_STICK = ITEMS.register("vibranium_stick",
            () -> new Item(new Item.Properties().fireResistant()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vibranium_stick")))));

    public static final RegistryObject<Item> VULPUS_STICK = ITEMS.register("vulpus_stick",
            () -> new Item(new Item.Properties().fireResistant()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vulpus_stick")))));

    public static final RegistryObject<Item> ENDERIUM_STICK = ITEMS.register("enderium_stick",
            () -> new Item(new Item.Properties().fireResistant()
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "enderium_stick")))));

    //VIBRANIUM
    public static final RegistryObject<Item> VIBRANIUM_PICKAXE = ITEMS.register("vibranium_pickaxe",
            () -> new VibraniumPickaxe(ModToolTiers.VIBRANIUM, VibraniumConfig.attackDamageVibraniumPickaxe, (float) VibraniumConfig.attackSpeedVibraniumPickaxe,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vibranium_pickaxe")))));

    public static final RegistryObject<Item> VIBRANIUM_SHOVEL = ITEMS.register("vibranium_shovel",
            () -> new VibraniumShovel(ModToolTiers.VIBRANIUM, VibraniumConfig.attackDamageVibraniumShovel, (float) VibraniumConfig.attackSpeedVibraniumShovel,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vibranium_shovel")))));

    public static final RegistryObject<Item> VIBRANIUM_AXE = ITEMS.register("vibranium_axe",
            () -> new VibraniumAxe(ModToolTiers.VIBRANIUM, VibraniumConfig.attackDamageVibraniumAxe, (float) VibraniumConfig.attackSpeedVibraniumAxe,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vibranium_axe")))));

    public static final RegistryObject<Item> VIBRANIUM_SWORD = ITEMS.register("vibranium_sword",
            () -> new VibraniumSword(ModToolTiers.VIBRANIUM, VibraniumConfig.attackDamageVibraniumSword, (float) VibraniumConfig.attackSpeedVibraniumSword,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vibranium_sword")))));

    public static final RegistryObject<Item> VIBRANIUM_BOW = ITEMS.register("vibranium_bow",
            () -> new VibraniumBow(BowTiers.VIBRANIUM, (new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vibranium_bow"))))));

    public static final RegistryObject<Item> VIBRANIUM_HOE = ITEMS.register("vibranium_hoe",
            () -> new VibraniumHoe(ModToolTiers.VIBRANIUM, VibraniumConfig.attackDamageVibraniumHoe, (float) VibraniumConfig.attackSpeedVibraniumHoe,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vibranium_hoe")))));

    public static final RegistryObject<Item> VIBRANIUM_PAXEL = ITEMS.register("vibranium_paxel",
            () -> new VibraniumPaxel(ModToolTiers.VIBRANIUM, VibraniumConfig.attackDamageVibraniumPaxel, (float) VibraniumConfig.attackSpeedVibraniumPaxel,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vibranium_paxel")))));

    public static final RegistryObject<Item> VIBRANIUM_HAMMER = ITEMS.register("vibranium_hammer",
            () -> new VibraniumHammer(ModToolTiers.VIBRANIUM, VibraniumConfig.attackDamageVibraniumHammer, (float) VibraniumConfig.attackSpeedVibraniumHammer,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vibranium_hammer")))));

    public static final RegistryObject<Item> VIBRANIUM_EXCAVATOR = ITEMS.register("vibranium_excavator",
            () -> new VibraniumExcavator(ModToolTiers.VIBRANIUM, VibraniumConfig.attackDamageVibraniumExcavator, (float) VibraniumConfig.attackSpeedVibraniumExcavator,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vibranium_excavator")))));

    public static final RegistryObject<Item> VIBRANIUM_HELMET = ITEMS.register("vibranium_helmet",
            () -> new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorType.HELMET,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vibranium_helmet")))));

    public static final RegistryObject<Item> VIBRANIUM_CHESTPLATE = ITEMS.register("vibranium_chestplate",
            () -> new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorType.CHESTPLATE,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vibranium_chestplate")))));

    public static final RegistryObject<Item> VIBRANIUM_LEGGINGS = ITEMS.register("vibranium_leggings",
            () -> new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorType.LEGGINGS,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vibranium_leggings")))));

    public static final RegistryObject<Item> VIBRANIUM_BOOTS = ITEMS.register("vibranium_boots",
            () -> new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorType.BOOTS,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vibranium_boots")))));

    public static final RegistryObject<Item> VIBRANIUM_HORSE_ARMOR = ITEMS.register("vibranium_horse_armor",
            () -> new AnimalArmorItem(ModArmorMaterials.VIBRANIUM, AnimalArmorItem.BodyType.EQUESTRIAN,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vibranium_horse_armor")))));

    //VULPUS
    public static final RegistryObject<Item> VULPUS_PICKAXE = ITEMS.register("vulpus_pickaxe",
            () -> new VulpusPickaxe(ModToolTiers.VULPUS, VulpusConfig.attackDamageVulpusPickaxe, (float) VulpusConfig.attackSpeedVulpusPickaxe,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vulpus_pickaxe")))));

    public static final RegistryObject<Item> VULPUS_SHOVEL = ITEMS.register("vulpus_shovel",
            () -> new VulpusShovel(ModToolTiers.VULPUS, VulpusConfig.attackDamageVulpusShovel, (float) VulpusConfig.attackSpeedVulpusShovel,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vulpus_shovel")))));

    public static final RegistryObject<Item> VULPUS_AXE = ITEMS.register("vulpus_axe",
            () -> new VulpusAxe(ModToolTiers.VULPUS, VulpusConfig.attackDamageVulpusAxe, (float) VulpusConfig.attackSpeedVulpusAxe,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vulpus_axe")))));

    public static final RegistryObject<Item> VULPUS_SWORD = ITEMS.register("vulpus_sword",
            () -> new VulpusSword(ModToolTiers.VULPUS, VulpusConfig.attackDamageVulpusSword, (float) VulpusConfig.attackSpeedVulpusSword,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vulpus_sword")))));

    public static final RegistryObject<Item> VULPUS_BOW = ITEMS.register("vulpus_bow",
            () -> new VulpusBow(BowTiers.VULPUS, (new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vulpus_bow"))))));

    public static final RegistryObject<Item> VULPUS_HOE = ITEMS.register("vulpus_hoe",
            () -> new VulpusHoe(ModToolTiers.VULPUS, VulpusConfig.attackDamageVulpusHoe, (float) VulpusConfig.attackSpeedVulpusHoe,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vulpus_hoe")))));

    public static final RegistryObject<Item> VULPUS_PAXEL = ITEMS.register("vulpus_paxel",
            () -> new VulpusPaxel(ModToolTiers.VULPUS, VulpusConfig.attackDamageVulpusPaxel, (float) VulpusConfig.attackSpeedVulpusPaxel,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vulpus_paxel")))));

    public static final RegistryObject<Item> VULPUS_HAMMER = ITEMS.register("vulpus_hammer",
            () -> new VulpusHammer(ModToolTiers.VULPUS, VulpusConfig.attackDamageVulpusHammer, (float) VulpusConfig.attackSpeedVulpusHammer,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vulpus_hammer")))));

    public static final RegistryObject<Item> VULPUS_EXCAVATOR = ITEMS.register("vulpus_excavator",
            () -> new VulpusExcavator(ModToolTiers.VULPUS, VulpusConfig.attackDamageVulpusExcavator, (float) VulpusConfig.attackSpeedVulpusExcavator,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vulpus_excavator")))));

    public static final RegistryObject<Item> VULPUS_HELMET = ITEMS.register("vulpus_helmet",
            () -> new VulpusArmor(ModArmorMaterials.VULPUS, ArmorType.HELMET,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vulpus_helmet")))));

    public static final RegistryObject<Item> VULPUS_CHESTPLATE = ITEMS.register("vulpus_chestplate",
            () -> new VulpusArmor(ModArmorMaterials.VULPUS, ArmorType.CHESTPLATE,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vulpus_chestplate")))));

    public static final RegistryObject<Item> VULPUS_LEGGINGS = ITEMS.register("vulpus_leggings",
            () -> new VulpusArmor(ModArmorMaterials.VULPUS, ArmorType.LEGGINGS,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vulpus_leggings")))));

    public static final RegistryObject<Item> VULPUS_BOOTS = ITEMS.register("vulpus_boots",
            () -> new VulpusArmor(ModArmorMaterials.VULPUS, ArmorType.BOOTS,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vulpus_boots")))));

    public static final RegistryObject<Item> VULPUS_HORSE_ARMOR = ITEMS.register("vulpus_horse_armor",
            () -> new AnimalArmorItem(ModArmorMaterials.VULPUS, AnimalArmorItem.BodyType.EQUESTRIAN,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vulpus_horse_armor")))));

    //ENDERIUM
    public static final RegistryObject<Item> ENDERIUM_PICKAXE = ITEMS.register("enderium_pickaxe",
            () -> new EnderiumPickaxe(ModToolTiers.ENDERIUM, EnderiumConfig.attackDamageEnderiumPickaxe, (float) EnderiumConfig.attackSpeedEnderiumPickaxe,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "enderium_pickaxe")))));

    public static final RegistryObject<Item> ENDERIUM_SHOVEL = ITEMS.register("enderium_shovel",
            () -> new EnderiumShovel(ModToolTiers.ENDERIUM, EnderiumConfig.attackDamageEnderiumShovel, (float) EnderiumConfig.attackSpeedEnderiumShovel,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "enderium_shovel")))));

    public static final RegistryObject<Item> ENDERIUM_AXE = ITEMS.register("enderium_axe",
            () -> new EnderiumAxe(ModToolTiers.ENDERIUM, EnderiumConfig.attackDamageEnderiumAxe, (float) EnderiumConfig.attackSpeedEnderiumAxe,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "enderium_axe")))));

    public static final RegistryObject<Item> ENDERIUM_SWORD = ITEMS.register("enderium_sword",
            () -> new EnderiumSword(ModToolTiers.ENDERIUM, EnderiumConfig.attackDamageEnderiumSword, (float) EnderiumConfig.attackSpeedEnderiumSword,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "enderium_sword")))));

    public static final RegistryObject<Item> ENDERIUM_BOW = ITEMS.register("enderium_bow",
            () -> new EnderiumBow(BowTiers.ENDERIUM, (new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                    .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "enderium_bow"))))));

    public static final RegistryObject<Item> ENDERIUM_HOE = ITEMS.register("enderium_hoe",
            () -> new EnderiumHoe(ModToolTiers.ENDERIUM, EnderiumConfig.attackDamageEnderiumHoe, (float) EnderiumConfig.attackSpeedEnderiumHoe,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "enderium_hoe")))));

    public static final RegistryObject<Item> ENDERIUM_PAXEL = ITEMS.register("enderium_paxel",
            () -> new EnderiumPaxel(ModToolTiers.ENDERIUM, EnderiumConfig.attackDamageEnderiumPaxel, (float) EnderiumConfig.attackSpeedEnderiumPaxel,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "enderium_paxel")))));

    public static final RegistryObject<Item> ENDERIUM_HAMMER = ITEMS.register("enderium_hammer",
            () -> new EnderiumHammer(ModToolTiers.ENDERIUM, EnderiumConfig.attackDamageEnderiumHammer, (float) EnderiumConfig.attackSpeedEnderiumHammer,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "enderium_hammer")))));

    public static final RegistryObject<Item> ENDERIUM_EXCAVATOR = ITEMS.register("enderium_excavator",
            () -> new EnderiumExcavator(ModToolTiers.ENDERIUM, EnderiumConfig.attackDamageEnderiumExcavator, (float) EnderiumConfig.attackSpeedEnderiumExcavator,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "enderium_excavator")))));

    public static final RegistryObject<Item> ENDERIUM_HELMET = ITEMS.register("enderium_helmet",
            () -> new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorType.HELMET,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "enderium_helmet")))));

    public static final RegistryObject<Item> ENDERIUM_CHESTPLATE = ITEMS.register("enderium_chestplate",
            () -> new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorType.CHESTPLATE,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "enderium_chestplate")))));

    public static final RegistryObject<Item> ENDERIUM_LEGGINGS = ITEMS.register("enderium_leggings",
            () -> new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorType.LEGGINGS,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "enderium_leggings")))));

    public static final RegistryObject<Item> ENDERIUM_BOOTS = ITEMS.register("enderium_boots",
            () -> new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorType.BOOTS,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "enderium_boots")))));

    public static final RegistryObject<Item> ENDERIUM_HORSE_ARMOR = ITEMS.register("enderium_horse_armor",
            () -> new AnimalArmorItem(ModArmorMaterials.ENDERIUM, AnimalArmorItem.BodyType.EQUESTRIAN,
                    new Item.Properties().fireResistant().stacksTo(1).component(DataComponents.UNBREAKABLE, new Unbreakable(true))
                            .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "enderium_horse_armor")))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}