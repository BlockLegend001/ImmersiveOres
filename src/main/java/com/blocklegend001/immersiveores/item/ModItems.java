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
import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    //RAW
    public static final Item RAW_VIBRANIUM = registerItem("raw_vibranium",
            new Item(new Item.Settings().fireproof()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "raw_vibranium")))));

    public static final Item RAW_VULPUS = registerItem("raw_vulpus",
            new Item(new Item.Settings().fireproof()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "raw_vulpus")))));

    public static final Item RAW_ENDERIUM = registerItem("raw_enderium",
            new Item(new Item.Settings().fireproof()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "raw_enderium")))));

    //INGOT
    public static final Item VIBRANIUM_INGOT = registerItem("vibranium_ingot",
            new Item(new Item.Settings().fireproof()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vibranium_ingot")))));

    public static final Item VULPUS_INGOT = registerItem("vulpus_ingot",
            new Item(new Item.Settings().fireproof()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vulpus_ingot")))));

    public static final Item ENDERIUM_INGOT = registerItem("enderium_ingot",
            new Item(new Item.Settings().fireproof()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "enderium_ingot")))));

    //NUGGET
    public static final Item VIBRANIUM_NUGGET = registerItem("vibranium_nugget",
            new Item(new Item.Settings().fireproof()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vibranium_nugget")))));

    public static final Item VULPUS_NUGGET = registerItem("vulpus_nugget",
            new Item(new Item.Settings().fireproof()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vulpus_nugget")))));

    public static final Item ENDERIUM_NUGGET = registerItem("enderium_nugget",
            new Item(new Item.Settings().fireproof()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "enderium_nugget")))));

    //STICK
    public static final Item VIBRANIUM_STICK = registerItem("vibranium_stick",
            new Item(new Item.Settings().fireproof()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vibranium_stick")))));

    public static final Item VULPUS_STICK = registerItem("vulpus_stick",
            new Item(new Item.Settings().fireproof()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vulpus_stick")))));

    public static final Item ENDERIUM_STICK = registerItem("enderium_stick",
            new Item(new Item.Settings().fireproof()
                    .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "enderium_stick")))));

    //VIBRANIUM
    public static final Item VIBRANIUM_PICKAXE = registerItem("vibranium_pickaxe",
            new VibraniumPickaxe(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumPickaxe, (float) VibraniumConfig.attackSpeedVibraniumPickaxe,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vibranium_pickaxe")))));

    public static final Item VIBRANIUM_SHOVEL = registerItem("vibranium_shovel",
            new VibraniumShovel(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumShovel, (float) VibraniumConfig.attackSpeedVibraniumShovel,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vibranium_shovel")))));

    public static final Item VIBRANIUM_AXE = registerItem("vibranium_axe",
            new VibraniumAxe(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumAxe, (float) VibraniumConfig.attackSpeedVibraniumAxe,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vibranium_axe")))));

    public static final Item VIBRANIUM_SWORD = registerItem("vibranium_sword",
            new VibraniumSword(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumSword, (float) VibraniumConfig.attackSpeedVibraniumSword,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vibranium_sword")))));

    public static final Item VIBRANIUM_BOW = registerItem("vibranium_bow",
            new VibraniumBow(BowTiers.VIBRANIUM, (new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vibranium_bow"))))));

    public static final Item VIBRANIUM_HOE = registerItem("vibranium_hoe",
            new VibraniumHoe(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumHoe, (float) VibraniumConfig.attackSpeedVibraniumHoe,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vibranium_hoe")))));

    public static final Item VIBRANIUM_PAXEL = registerItem("vibranium_paxel",
            new VibraniumPaxel(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumPaxel, (float) VibraniumConfig.attackSpeedVibraniumPaxel,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vibranium_paxel")))));

    public static final Item VIBRANIUM_HAMMER = registerItem("vibranium_hammer",
            new VibraniumHammer(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumHammer, (float) VibraniumConfig.attackSpeedVibraniumHammer,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vibranium_hammer")))));

    public static final Item VIBRANIUM_EXCAVATOR = registerItem("vibranium_excavator",
            new VibraniumExcavator(ModToolMaterials.VIBRANIUM, VibraniumConfig.attackDamageVibraniumExcavator, (float) VibraniumConfig.attackSpeedVibraniumExcavator,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vibranium_excavator")))));

    public static final Item VIBRANIUM_HELMET = registerItem("vibranium_helmet",
            new VibraniumArmor(ModArmorMaterials.VIBRANIUM, EquipmentType.HELMET,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vibranium_helmet")))));

    public static final Item VIBRANIUM_CHESTPLATE = registerItem("vibranium_chestplate",
            new VibraniumArmor(ModArmorMaterials.VIBRANIUM, EquipmentType.CHESTPLATE,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vibranium_chestplate")))));

    public static final Item VIBRANIUM_LEGGINGS = registerItem("vibranium_leggings",
            new VibraniumArmor(ModArmorMaterials.VIBRANIUM, EquipmentType.LEGGINGS,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vibranium_leggings")))));

    public static final Item VIBRANIUM_BOOTS = registerItem("vibranium_boots",
            new VibraniumArmor(ModArmorMaterials.VIBRANIUM, EquipmentType.BOOTS,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vibranium_boots")))));

    public static final Item VIBRANIUM_HORSE_ARMOR = registerItem("vibranium_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.VIBRANIUM, AnimalArmorItem.Type.EQUESTRIAN,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vibranium_horse_armor")))));

    //VULPUS
    public static final Item VULPUS_PICKAXE = registerItem("vulpus_pickaxe",
            new VulpusPickaxe(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusPickaxe, (float) VulpusConfig.attackSpeedVulpusPickaxe,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vulpus_pickaxe")))));

    public static final Item VULPUS_SHOVEL = registerItem("vulpus_shovel",
            new VulpusShovel(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusShovel, (float) VulpusConfig.attackSpeedVulpusShovel,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vulpus_shovel")))));

    public static final Item VULPUS_AXE = registerItem("vulpus_axe",
            new VulpusAxe(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusAxe, (float) VulpusConfig.attackSpeedVulpusAxe,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vulpus_axe")))));

    public static final Item VULPUS_SWORD = registerItem("vulpus_sword",
            new VulpusSword(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusSword, (float) VulpusConfig.attackSpeedVulpusSword,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vulpus_sword")))));

    public static final Item VULPUS_BOW = registerItem("vulpus_bow",
            new VulpusBow(BowTiers.VULPUS, (new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vulpus_bow"))))));

    public static final Item VULPUS_HOE = registerItem("vulpus_hoe",
            new VulpusHoe(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusHoe, (float) VulpusConfig.attackSpeedVulpusHoe,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vulpus_hoe")))));

    public static final Item VULPUS_PAXEL = registerItem("vulpus_paxel",
            new VulpusPaxel(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusPaxel, (float) VulpusConfig.attackSpeedVulpusPaxel,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vulpus_paxel")))));

    public static final Item VULPUS_HAMMER = registerItem("vulpus_hammer",
            new VulpusHammer(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusHammer, (float) VulpusConfig.attackSpeedVulpusHammer,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vulpus_hammer")))));

    public static final Item VULPUS_EXCAVATOR = registerItem("vulpus_excavator",
            new VulpusExcavator(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusExcavator, (float) VulpusConfig.attackSpeedVulpusExcavator,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vulpus_excavator")))));

    public static final Item VULPUS_HELMET = registerItem("vulpus_helmet",
            new VulpusArmor(ModArmorMaterials.VULPUS, EquipmentType.HELMET,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vulpus_helmet")))));

    public static final Item VULPUS_CHESTPLATE = registerItem("vulpus_chestplate",
            new VulpusArmor(ModArmorMaterials.VULPUS, EquipmentType.CHESTPLATE,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vulpus_chestplate")))));

    public static final Item VULPUS_LEGGINGS = registerItem("vulpus_leggings",
            new VulpusArmor(ModArmorMaterials.VULPUS, EquipmentType.LEGGINGS,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vulpus_leggings")))));

    public static final Item VULPUS_BOOTS = registerItem("vulpus_boots",
            new VulpusArmor(ModArmorMaterials.VULPUS, EquipmentType.BOOTS,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vulpus_boots")))));

    public static final Item VULPUS_HORSE_ARMOR = registerItem("vulpus_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.VULPUS, AnimalArmorItem.Type.EQUESTRIAN,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "vulpus_horse_armor")))));

    //ENDERIUM
    public static final Item ENDERIUM_PICKAXE = registerItem("enderium_pickaxe",
            new EnderiumPickaxe(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumPickaxe, (float) EnderiumConfig.attackSpeedEnderiumPickaxe,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "enderium_pickaxe")))));

    public static final Item ENDERIUM_SHOVEL = registerItem("enderium_shovel",
            new EnderiumShovel(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumShovel, (float) EnderiumConfig.attackSpeedEnderiumShovel,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "enderium_shovel")))));

    public static final Item ENDERIUM_AXE = registerItem("enderium_axe",
            new EnderiumAxe(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumAxe, (float) EnderiumConfig.attackSpeedEnderiumAxe,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "enderium_axe")))));

    public static final Item ENDERIUM_SWORD = registerItem("enderium_sword",
            new EnderiumSword(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumSword, (float) EnderiumConfig.attackSpeedEnderiumSword,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "enderium_sword")))));

    public static final Item ENDERIUM_BOW = registerItem("enderium_bow",
            new EnderiumBow(BowTiers.ENDERIUM, (new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "enderium_bow"))))));

    public static final Item ENDERIUM_HOE = registerItem("enderium_hoe",
            new EnderiumHoe(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumHoe, (float) EnderiumConfig.attackSpeedEnderiumHoe,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "enderium_hoe")))));

    public static final Item ENDERIUM_PAXEL = registerItem("enderium_paxel",
            new EnderiumPaxel(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumPaxel, (float) EnderiumConfig.attackSpeedEnderiumPaxel,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "enderium_paxel")))));

    public static final Item ENDERIUM_HAMMER = registerItem("enderium_hammer",
            new EnderiumHammer(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumHammer, (float) EnderiumConfig.attackSpeedEnderiumHammer,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "enderium_hammer")))));

    public static final Item ENDERIUM_EXCAVATOR = registerItem("enderium_excavator",
            new EnderiumExcavator(ModToolMaterials.ENDERIUM, EnderiumConfig.attackDamageEnderiumExcavator, (float) EnderiumConfig.attackSpeedEnderiumExcavator,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true))
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "enderium_excavator")))));

    public static final Item ENDERIUM_HELMET = registerItem("enderium_helmet",
            new EnderiumArmor(ModArmorMaterials.ENDERIUM, EquipmentType.HELMET,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "enderium_helmet")))));

    public static final Item ENDERIUM_CHESTPLATE = registerItem("enderium_chestplate",
            new EnderiumArmor(ModArmorMaterials.ENDERIUM, EquipmentType.CHESTPLATE,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "enderium_chestplate")))));

    public static final Item ENDERIUM_LEGGINGS = registerItem("enderium_leggings",
            new EnderiumArmor(ModArmorMaterials.ENDERIUM, EquipmentType.LEGGINGS,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "enderium_leggings")))));

    public static final Item ENDERIUM_BOOTS = registerItem("enderium_boots",
            new EnderiumArmor(ModArmorMaterials.ENDERIUM, EquipmentType.BOOTS,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "enderium_boots")))));

    public static final Item ENDERIUM_HORSE_ARMOR = registerItem("enderium_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.ENDERIUM, AnimalArmorItem.Type.EQUESTRIAN,
                    new Item.Settings().fireproof().component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true)).maxCount(1)
                            .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ImmersiveOres.MOD_ID, "enderium_horse_armor")))));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ImmersiveOres.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ImmersiveOres.LOGGER.info("Registering Mod Items for " + ImmersiveOres.MOD_ID);
    }
}
