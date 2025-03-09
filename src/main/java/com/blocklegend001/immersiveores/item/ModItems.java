package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.item.custom.enderium.*;
import com.blocklegend001.immersiveores.item.custom.vibranium.*;
import com.blocklegend001.immersiveores.item.custom.vulpus.*;
import com.blocklegend001.immersiveores.util.BowTiers;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.item.AnimalArmorItem;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    //RAW
    public static final Item RAW_VIBRANIUM = registerItem("raw_vibranium",
            new Item(new Item.Settings().fireproof()));

    public static final Item RAW_VULPUS = registerItem("raw_vulpus",
            new Item(new Item.Settings().fireproof()));

    public static final Item RAW_ENDERIUM = registerItem("raw_enderium",
            new Item(new Item.Settings().fireproof()));

    //INGOT
    public static final Item VIBRANIUM_INGOT = registerItem("vibranium_ingot",
            new Item(new Item.Settings().fireproof()));

    public static final Item VULPUS_INGOT = registerItem("vulpus_ingot",
            new Item(new Item.Settings().fireproof()));

    public static final Item ENDERIUM_INGOT = registerItem("enderium_ingot",
            new Item(new Item.Settings().fireproof()));

    //NUGGET
    public static final Item VIBRANIUM_NUGGET = registerItem("vibranium_nugget",
            new Item(new Item.Settings().fireproof()));

    public static final Item VULPUS_NUGGET = registerItem("vulpus_nugget",
            new Item(new Item.Settings().fireproof()));

    public static final Item ENDERIUM_NUGGET = registerItem("enderium_nugget",
            new Item(new Item.Settings().fireproof()));

    //STICK
    public static final Item VIBRANIUM_STICK = registerItem("vibranium_stick",
            new Item(new Item.Settings().fireproof()));

    public static final Item VULPUS_STICK = registerItem("vulpus_stick",
            new Item(new Item.Settings().fireproof()));

    public static final Item ENDERIUM_STICK = registerItem("enderium_stick",
            new Item(new Item.Settings().fireproof()));

    //VIBRANIUM
    public static final Item VIBRANIUM_PICKAXE = registerItem("vibranium_pickaxe",
            new VibraniumPickaxe(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumPickaxe, (float) VibraniumConfig.attackSpeedVibraniumPickaxe,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .attributeModifiers(VibraniumPickaxe.createAttributeModifiers(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumPickaxe, (float) VibraniumConfig.attackSpeedVibraniumPickaxe))));

    public static final Item VIBRANIUM_SHOVEL = registerItem("vibranium_shovel",
            new VibraniumShovel(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumShovel, (float) VibraniumConfig.attackSpeedVibraniumShovel,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .attributeModifiers(VibraniumShovel.createAttributeModifiers(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumShovel, (float) VibraniumConfig.attackSpeedVibraniumShovel))));

    public static final Item VIBRANIUM_AXE = registerItem("vibranium_axe",
            new VibraniumAxe(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumAxe, (float) VibraniumConfig.attackSpeedVibraniumAxe,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .attributeModifiers(VibraniumAxe.createAttributeModifiers(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumAxe, (float) VibraniumConfig.attackSpeedVibraniumAxe))));

    public static final Item VIBRANIUM_SWORD = registerItem("vibranium_sword",
            new VibraniumSword(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumSword, (float) VibraniumConfig.attackSpeedVibraniumSword,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .attributeModifiers(VibraniumSword.createAttributeModifiers(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumSword, (float) VibraniumConfig.attackSpeedVibraniumSword))));

    public static final Item VIBRANIUM_BOW = registerItem("vibranium_bow",
            new VibraniumBow(BowTiers.VIBRANIUM, (new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)))));

    public static final Item VIBRANIUM_HOE = registerItem("vibranium_hoe",
            new VibraniumHoe(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumHoe, (float) VibraniumConfig.attackSpeedVibraniumHoe,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .attributeModifiers(VibraniumHoe.createAttributeModifiers(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumHoe, (float) VibraniumConfig.attackSpeedVibraniumHoe))));

    public static final Item VIBRANIUM_PAXEL = registerItem("vibranium_paxel",
            new VibraniumPaxel(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumPaxel, (float) VibraniumConfig.attackSpeedVibraniumPaxel,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .attributeModifiers(VibraniumPaxel.createAttributeModifiers(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumPaxel, (float) VibraniumConfig.attackSpeedVibraniumPaxel))));

    public static final Item VIBRANIUM_HAMMER = registerItem("vibranium_hammer",
            new VibraniumHammer(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumHammer, (float) VibraniumConfig.attackSpeedVibraniumHammer,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .attributeModifiers(VibraniumHammer.createAttributeModifiers(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumHammer, (float) VibraniumConfig.attackSpeedVibraniumHammer))));

    public static final Item VIBRANIUM_EXCAVATOR = registerItem("vibranium_excavator",
            new VibraniumExcavator(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumExcavator, (float) VibraniumConfig.attackSpeedVibraniumExcavator,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .attributeModifiers(VibraniumExcavator.createAttributeModifiers(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumExcavator, (float) VibraniumConfig.attackSpeedVibraniumExcavator))));

    public static final Item VIBRANIUM_HELMET = registerItem("vibranium_helmet",
            new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorItem.Type.HELMET,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)));

    public static final Item VIBRANIUM_CHESTPLATE = registerItem("vibranium_chestplate",
            new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)));

    public static final Item VIBRANIUM_LEGGINGS = registerItem("vibranium_leggings",
            new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)));

    public static final Item VIBRANIUM_BOOTS = registerItem("vibranium_boots",
            new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorItem.Type.BOOTS,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)));

    public static final Item VIBRANIUM_HORSE_ARMOR = registerItem("vibranium_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.VIBRANIUM, AnimalArmorItem.Type.EQUESTRIAN, false,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)));

    //VULPUS
    public static final Item VULPUS_PICKAXE = registerItem("vulpus_pickaxe",
            new VulpusPickaxe(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusPickaxe, (float) VulpusConfig.attackSpeedVulpusPickaxe,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .attributeModifiers(VulpusPickaxe.createAttributeModifiers(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusPickaxe, (float) VulpusConfig.attackSpeedVulpusPickaxe))));

    public static final Item VULPUS_SHOVEL = registerItem("vulpus_shovel",
            new VulpusShovel(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusShovel, (float) VulpusConfig.attackSpeedVulpusShovel,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .attributeModifiers(VulpusShovel.createAttributeModifiers(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusShovel, (float) VulpusConfig.attackSpeedVulpusShovel))));

    public static final Item VULPUS_AXE = registerItem("vulpus_axe",
            new VulpusAxe(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusAxe, (float) VulpusConfig.attackSpeedVulpusAxe,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .attributeModifiers(VulpusAxe.createAttributeModifiers(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusAxe, (float) VulpusConfig.attackSpeedVulpusAxe))));

    public static final Item VULPUS_SWORD = registerItem("vulpus_sword",
            new VulpusSword(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusSword, (float) VulpusConfig.attackSpeedVulpusSword,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .attributeModifiers(VulpusSword.createAttributeModifiers(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusSword, (float) VulpusConfig.attackSpeedVulpusSword))));

    public static final Item VULPUS_BOW = registerItem("vulpus_bow",
            new VulpusBow(BowTiers.VULPUS, (new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)))));

    public static final Item VULPUS_HOE = registerItem("vulpus_hoe",
            new VulpusHoe(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusHoe, (float) VulpusConfig.attackSpeedVulpusHoe,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .attributeModifiers(VulpusHoe.createAttributeModifiers(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusHoe, (float) VulpusConfig.attackSpeedVulpusHoe))));

    public static final Item VULPUS_PAXEL = registerItem("vulpus_paxel",
            new VulpusPaxel(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusPaxel, (float) VulpusConfig.attackSpeedVulpusPaxel,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .attributeModifiers(VulpusPaxel.createAttributeModifiers(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusPaxel, (float) VulpusConfig.attackSpeedVulpusPaxel))));

    public static final Item VULPUS_HAMMER = registerItem("vulpus_hammer",
            new VulpusHammer(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusHammer, (float) VulpusConfig.attackSpeedVulpusHammer,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .attributeModifiers(VulpusHammer.createAttributeModifiers(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusHammer, (float) VulpusConfig.attackSpeedVulpusHammer))));

    public static final Item VULPUS_EXCAVATOR = registerItem("vulpus_excavator",
            new VulpusExcavator(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusExcavator, (float) VulpusConfig.attackSpeedVulpusExcavator,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .attributeModifiers(VulpusExcavator.createAttributeModifiers(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusExcavator, (float) VulpusConfig.attackSpeedVulpusExcavator))));

    public static final Item VULPUS_HELMET = registerItem("vulpus_helmet",
            new VulpusArmor(ModArmorMaterials.VULPUS, ArmorItem.Type.HELMET,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)));

    public static final Item VULPUS_CHESTPLATE = registerItem("vulpus_chestplate",
            new VulpusArmor(ModArmorMaterials.VULPUS, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)));

    public static final Item VULPUS_LEGGINGS = registerItem("vulpus_leggings",
            new VulpusArmor(ModArmorMaterials.VULPUS, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)));

    public static final Item VULPUS_BOOTS = registerItem("vulpus_boots",
            new VulpusArmor(ModArmorMaterials.VULPUS, ArmorItem.Type.BOOTS,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)));

    public static final Item VULPUS_HORSE_ARMOR = registerItem("vulpus_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.VULPUS, AnimalArmorItem.Type.EQUESTRIAN, false,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)));

    //ENDERIUM
    public static final Item ENDERIUM_PICKAXE = registerItem("enderium_pickaxe",
            new EnderiumPickaxe(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumPickaxe, (float) EnderiumConfig.attackSpeedEnderiumPickaxe,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .attributeModifiers(EnderiumPickaxe.createAttributeModifiers(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumPickaxe, (float) EnderiumConfig.attackSpeedEnderiumPickaxe))));

    public static final Item ENDERIUM_SHOVEL = registerItem("enderium_shovel",
            new EnderiumShovel(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumShovel, (float) EnderiumConfig.attackSpeedEnderiumShovel,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .attributeModifiers(EnderiumShovel.createAttributeModifiers(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumShovel, (float) EnderiumConfig.attackSpeedEnderiumShovel))));

    public static final Item ENDERIUM_AXE = registerItem("enderium_axe",
            new EnderiumAxe(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumAxe, (float) EnderiumConfig.attackSpeedEnderiumAxe,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .attributeModifiers(EnderiumAxe.createAttributeModifiers(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumAxe, (float) EnderiumConfig.attackSpeedEnderiumAxe))));

    public static final Item ENDERIUM_SWORD = registerItem("enderium_sword",
            new EnderiumSword(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumSword, (float) EnderiumConfig.attackSpeedEnderiumSword,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .attributeModifiers(EnderiumSword.createAttributeModifiers(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumSword, (float) EnderiumConfig.attackSpeedEnderiumSword))));

    public static final Item ENDERIUM_BOW = registerItem("enderium_bow",
            new EnderiumBow(BowTiers.ENDERIUM, (new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)))));

    public static final Item ENDERIUM_HOE = registerItem("enderium_hoe",
            new EnderiumHoe(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumHoe, (float) EnderiumConfig.attackSpeedEnderiumHoe,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .attributeModifiers(EnderiumHoe.createAttributeModifiers(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumHoe, (float) EnderiumConfig.attackSpeedEnderiumHoe))));

    public static final Item ENDERIUM_PAXEL = registerItem("enderium_paxel",
            new EnderiumPaxel(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumPaxel, (float) EnderiumConfig.attackSpeedEnderiumPaxel,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .attributeModifiers(EnderiumPaxel.createAttributeModifiers(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumPaxel, (float) EnderiumConfig.attackSpeedEnderiumPaxel))));

    public static final Item ENDERIUM_HAMMER = registerItem("enderium_hammer",
            new EnderiumHammer(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumHammer, (float) EnderiumConfig.attackSpeedEnderiumHammer,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .attributeModifiers(EnderiumHammer.createAttributeModifiers(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumHammer, (float) EnderiumConfig.attackSpeedEnderiumHammer))));

    public static final Item ENDERIUM_EXCAVATOR = registerItem("enderium_excavator",
            new EnderiumExcavator(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumExcavator, (float) EnderiumConfig.attackSpeedEnderiumExcavator,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .attributeModifiers(EnderiumExcavator.createAttributeModifiers(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumExcavator, (float) EnderiumConfig.attackSpeedEnderiumExcavator))));

    public static final Item ENDERIUM_HELMET = registerItem("enderium_helmet",
            new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorItem.Type.HELMET,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)));

    public static final Item ENDERIUM_CHESTPLATE = registerItem("enderium_chestplate",
            new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)));

    public static final Item ENDERIUM_LEGGINGS = registerItem("enderium_leggings",
            new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)));

    public static final Item ENDERIUM_BOOTS = registerItem("enderium_boots",
            new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorItem.Type.BOOTS,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)));

    public static final Item ENDERIUM_HORSE_ARMOR = registerItem("enderium_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.ENDERIUM, AnimalArmorItem.Type.EQUESTRIAN, false,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ImmersiveOres.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ImmersiveOres.LOGGER.info("Registering Mod Items for " + ImmersiveOres.MOD_ID);
    }
}
