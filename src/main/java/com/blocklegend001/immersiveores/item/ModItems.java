package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.item.custom.enderium.*;
import com.blocklegend001.immersiveores.item.custom.vibranium.*;
import com.blocklegend001.immersiveores.item.custom.vulpus.*;
import com.blocklegend001.immersiveores.util.tools.bow.BowTiers;
import net.minecraft.world.item.AnimalArmorItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(ImmersiveOres.MODID);

    //RAW
    public static final DeferredItem<Item> RAW_VIBRANIUM = ITEMS.register("raw_vibranium",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> RAW_VULPUS = ITEMS.register("raw_vulpus",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> RAW_ENDERIUM = ITEMS.register("raw_enderium",
            () -> new Item(new Item.Properties().fireResistant()));

    //INGOT
    public static final DeferredItem<Item> VIBRANIUM_INGOT = ITEMS.register("vibranium_ingot",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> VULPUS_INGOT = ITEMS.register("vulpus_ingot",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> ENDERIUM_INGOT = ITEMS.register("enderium_ingot",
            () -> new Item(new Item.Properties().fireResistant()));

    //NUGGET
    public static final DeferredItem<Item> VIBRANIUM_NUGGET = ITEMS.register("vibranium_nugget",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> VULPUS_NUGGET = ITEMS.register("vulpus_nugget",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> ENDERIUM_NUGGET = ITEMS.register("enderium_nugget",
            () -> new Item(new Item.Properties().fireResistant()));

    //STICK
    public static final DeferredItem<Item> VIBRANIUM_STICK = ITEMS.register("vibranium_stick",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> VULPUS_STICK = ITEMS.register("vulpus_stick",
            () -> new Item(new Item.Properties().fireResistant()));

    public static final DeferredItem<Item> ENDERIUM_STICK = ITEMS.register("enderium_stick",
            () -> new Item(new Item.Properties().fireResistant()));

    //VIBRANIUM
    public static final DeferredItem<Item> VIBRANIUM_PICKAXE = ITEMS.register("vibranium_pickaxe",
            () -> new VibraniumPickaxe(ModToolTiers.VIBRANIUM, VibraniumConfig.ATTACK_DAMAGE_VIBRANIUM_PICKAXE.get(), (float) VibraniumConfig.ATTACK_SPEED_VIBRANIUM_PICKAXE.get().doubleValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> VIBRANIUM_SHOVEL = ITEMS.register("vibranium_shovel",
            () -> new VibraniumShovel(ModToolTiers.VIBRANIUM, VibraniumConfig.ATTACK_DAMAGE_VIBRANIUM_SHOVEL.get(), (float) VibraniumConfig.ATTACK_SPEED_VIBRANIUM_SHOVEL.get().doubleValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> VIBRANIUM_AXE = ITEMS.register("vibranium_axe",
            () -> new VibraniumAxe(ModToolTiers.VIBRANIUM, VibraniumConfig.ATTACK_DAMAGE_VIBRANIUM_AXE.get(), (float) VibraniumConfig.ATTACK_SPEED_VIBRANIUM_AXE.get().doubleValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> VIBRANIUM_SWORD = ITEMS.register("vibranium_sword",
            () -> new VibraniumSword(ModToolTiers.VIBRANIUM, VibraniumConfig.ATTACK_DAMAGE_VIBRANIUM_SWORD.get(), (float) VibraniumConfig.ATTACK_SPEED_VIBRANIUM_SWORD.get().doubleValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> VIBRANIUM_BOW = ITEMS.register("vibranium_bow",
            () -> new VibraniumBow(BowTiers.VIBRANIUM, (new Item.Properties().fireResistant().stacksTo(1))));

    public static final DeferredItem<Item> VIBRANIUM_HOE = ITEMS.register("vibranium_hoe",
            () -> new VibraniumHoe(ModToolTiers.VIBRANIUM, VibraniumConfig.ATTACK_DAMAGE_VIBRANIUM_HOE.get(), (float) VibraniumConfig.ATTACK_SPEED_VIBRANIUM_HOE.get().doubleValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> VIBRANIUM_PAXEL = ITEMS.register("vibranium_paxel",
            () -> new VibraniumPaxel(ModToolTiers.VIBRANIUM, VibraniumConfig.ATTACK_DAMAGE_VIBRANIUM_PAXEL.get(), (float) VibraniumConfig.ATTACK_SPEED_VIBRANIUM_PAXEL.get().doubleValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> VIBRANIUM_HAMMER = ITEMS.register("vibranium_hammer",
            () -> new VibraniumHammer(ModToolTiers.VIBRANIUM, VibraniumConfig.ATTACK_DAMAGE_VIBRANIUM_HAMMER.get(), (float) VibraniumConfig.ATTACK_SPEED_VIBRANIUM_HAMMER.get().doubleValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> VIBRANIUM_EXCAVATOR = ITEMS.register("vibranium_excavator",
            () -> new VibraniumExcavator(ModToolTiers.VIBRANIUM, VibraniumConfig.ATTACK_DAMAGE_VIBRANIUM_EXCAVATOR.get(), (float) VibraniumConfig.ATTACK_SPEED_VIBRANIUM_EXCAVATOR.get().doubleValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> VIBRANIUM_HELMET = ITEMS.register("vibranium_helmet",
            () -> new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorItem.Type.HELMET,
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> VIBRANIUM_CHESTPLATE = ITEMS.register("vibranium_chestplate",
            () -> new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> VIBRANIUM_LEGGINGS = ITEMS.register("vibranium_leggings",
            () -> new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> VIBRANIUM_BOOTS = ITEMS.register("vibranium_boots",
            () -> new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorItem.Type.BOOTS,
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> VIBRANIUM_HORSE_ARMOR = ITEMS.register("vibranium_horse_armor",
            () -> new AnimalArmorItem(ModArmorMaterials.VIBRANIUM, AnimalArmorItem.BodyType.EQUESTRIAN, false,
                    new Item.Properties().fireResistant().stacksTo(1)));

    //VULPUS
    public static final DeferredItem<Item> VULPUS_PICKAXE = ITEMS.register("vulpus_pickaxe",
            () -> new VulpusPickaxe(ModToolTiers.VULPUS, VulpusConfig.ATTACK_DAMAGE_VULPUS_PICKAXE.get(), (float) VulpusConfig.ATTACK_SPEED_VULPUS_PICKAXE.get().doubleValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> VULPUS_SHOVEL = ITEMS.register("vulpus_shovel",
            () -> new VulpusShovel(ModToolTiers.VULPUS, VulpusConfig.ATTACK_DAMAGE_VULPUS_SHOVEL.get(), (float) VulpusConfig.ATTACK_SPEED_VULPUS_SHOVEL.get().doubleValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> VULPUS_AXE = ITEMS.register("vulpus_axe",
            () -> new VulpusAxe(ModToolTiers.VULPUS, VulpusConfig.ATTACK_DAMAGE_VULPUS_AXE.get(), (float) VulpusConfig.ATTACK_SPEED_VULPUS_AXE.get().doubleValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> VULPUS_SWORD = ITEMS.register("vulpus_sword",
            () -> new VulpusSword(ModToolTiers.VULPUS, VulpusConfig.ATTACK_DAMAGE_VULPUS_SWORD.get(), (float) VulpusConfig.ATTACK_SPEED_VULPUS_SWORD.get().doubleValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> VULPUS_BOW = ITEMS.register("vulpus_bow",
            () -> new VulpusBow(BowTiers.VULPUS, (new Item.Properties().fireResistant().stacksTo(1))));

    public static final DeferredItem<Item> VULPUS_HOE = ITEMS.register("vulpus_hoe",
            () -> new VulpusHoe(ModToolTiers.VULPUS, VulpusConfig.ATTACK_DAMAGE_VULPUS_HOE.get(), (float) VulpusConfig.ATTACK_SPEED_VULPUS_HOE.get().doubleValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> VULPUS_PAXEL = ITEMS.register("vulpus_paxel",
            () -> new VulpusPaxel(ModToolTiers.VULPUS, VulpusConfig.ATTACK_DAMAGE_VULPUS_PAXEL.get(), (float) VulpusConfig.ATTACK_SPEED_VULPUS_PAXEL.get().doubleValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> VULPUS_HAMMER = ITEMS.register("vulpus_hammer",
            () -> new VulpusHammer(ModToolTiers.VULPUS, VulpusConfig.ATTACK_DAMAGE_VULPUS_HAMMER.get(), (float) VulpusConfig.ATTACK_SPEED_VULPUS_HAMMER.get().doubleValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> VULPUS_EXCAVATOR = ITEMS.register("vulpus_excavator",
            () -> new VulpusExcavator(ModToolTiers.VULPUS, VulpusConfig.ATTACK_DAMAGE_VULPUS_EXCAVATOR.get(), (float) VulpusConfig.ATTACK_SPEED_VULPUS_EXCAVATOR.get().doubleValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> VULPUS_HELMET = ITEMS.register("vulpus_helmet",
            () -> new VulpusArmor(ModArmorMaterials.VULPUS, ArmorItem.Type.HELMET,
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> VULPUS_CHESTPLATE = ITEMS.register("vulpus_chestplate",
            () -> new VulpusArmor(ModArmorMaterials.VULPUS, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> VULPUS_LEGGINGS = ITEMS.register("vulpus_leggings",
            () -> new VulpusArmor(ModArmorMaterials.VULPUS, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> VULPUS_BOOTS = ITEMS.register("vulpus_boots",
            () -> new VulpusArmor(ModArmorMaterials.VULPUS, ArmorItem.Type.BOOTS,
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> VULPUS_HORSE_ARMOR = ITEMS.register("vulpus_horse_armor",
            () -> new AnimalArmorItem(ModArmorMaterials.VULPUS, AnimalArmorItem.BodyType.EQUESTRIAN, false,
                    new Item.Properties().fireResistant().stacksTo(1)));

    //ENDERIUM
    public static final DeferredItem<Item> ENDERIUM_PICKAXE = ITEMS.register("enderium_pickaxe",
            () -> new EnderiumPickaxe(ModToolTiers.ENDERIUM, EnderiumConfig.ATTACK_DAMAGE_ENDERIUM_PICKAXE.get(), (float) EnderiumConfig.ATTACK_SPEED_ENDERIUM_PICKAXE.get().doubleValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> ENDERIUM_SHOVEL = ITEMS.register("enderium_shovel",
            () -> new EnderiumShovel(ModToolTiers.ENDERIUM, EnderiumConfig.ATTACK_DAMAGE_ENDERIUM_SHOVEL.get(), (float) EnderiumConfig.ATTACK_SPEED_ENDERIUM_SHOVEL.get().doubleValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> ENDERIUM_AXE = ITEMS.register("enderium_axe",
            () -> new EnderiumAxe(ModToolTiers.ENDERIUM, EnderiumConfig.ATTACK_DAMAGE_ENDERIUM_AXE.get(), (float) EnderiumConfig.ATTACK_SPEED_ENDERIUM_AXE.get().doubleValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> ENDERIUM_SWORD = ITEMS.register("enderium_sword",
            () -> new EnderiumSword(ModToolTiers.ENDERIUM, EnderiumConfig.ATTACK_DAMAGE_ENDERIUM_SWORD.get(), (float) EnderiumConfig.ATTACK_SPEED_ENDERIUM_SWORD.get().doubleValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> ENDERIUM_BOW = ITEMS.register("enderium_bow",
            () -> new EnderiumBow(BowTiers.ENDERIUM, (new Item.Properties().fireResistant().stacksTo(1))));

    public static final DeferredItem<Item> ENDERIUM_HOE = ITEMS.register("enderium_hoe",
            () -> new EnderiumHoe(ModToolTiers.ENDERIUM, EnderiumConfig.ATTACK_DAMAGE_ENDERIUM_HOE.get(), (float) EnderiumConfig.ATTACK_SPEED_ENDERIUM_HOE.get().doubleValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> ENDERIUM_PAXEL = ITEMS.register("enderium_paxel",
            () -> new EnderiumPaxel(ModToolTiers.ENDERIUM, EnderiumConfig.ATTACK_DAMAGE_ENDERIUM_PAXEL.get(), (float) EnderiumConfig.ATTACK_SPEED_ENDERIUM_PAXEL.get().doubleValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> ENDERIUM_HAMMER = ITEMS.register("enderium_hammer",
            () -> new EnderiumHammer(ModToolTiers.ENDERIUM, EnderiumConfig.ATTACK_DAMAGE_ENDERIUM_HAMMER.get(), (float) EnderiumConfig.ATTACK_SPEED_ENDERIUM_HAMMER.get().doubleValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> ENDERIUM_EXCAVATOR = ITEMS.register("enderium_excavator",
            () -> new EnderiumExcavator(ModToolTiers.ENDERIUM, EnderiumConfig.ATTACK_DAMAGE_ENDERIUM_EXCAVATOR.get(), (float) EnderiumConfig.ATTACK_SPEED_ENDERIUM_EXCAVATOR.get().doubleValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));


    public static final DeferredItem<Item> ENDERIUM_HELMET = ITEMS.register("enderium_helmet",
            () -> new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorItem.Type.HELMET,
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> ENDERIUM_CHESTPLATE = ITEMS.register("enderium_chestplate",
            () -> new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> ENDERIUM_LEGGINGS = ITEMS.register("enderium_leggings",
            () -> new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> ENDERIUM_BOOTS = ITEMS.register("enderium_boots",
            () -> new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorItem.Type.BOOTS,
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final DeferredItem<Item> ENDERIUM_HORSE_ARMOR = ITEMS.register("enderium_horse_armor",
            () -> new AnimalArmorItem(ModArmorMaterials.ENDERIUM, AnimalArmorItem.BodyType.EQUESTRIAN, false,
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
