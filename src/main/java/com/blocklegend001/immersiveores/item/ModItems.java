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
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ImmersiveOres.MODID);

    //RAW
    public static final RegistryObject<Item> RAW_VIBRANIUM = ITEMS.register("raw_vibranium",
            () -> new ColoredItem(new Item.Properties().fireResistant(), ChatFormatting.LIGHT_PURPLE));

    public static final RegistryObject<Item> RAW_VULPUS = ITEMS.register("raw_vulpus",
            () -> new ColoredItem(new Item.Properties().fireResistant(), ChatFormatting.RED));

    public static final RegistryObject<Item> RAW_ENDERIUM = ITEMS.register("raw_enderium",
            () -> new ColoredItem(new Item.Properties().fireResistant(), ChatFormatting.DARK_AQUA));

    //INGOT
    public static final RegistryObject<Item> VIBRANIUM_INGOT = ITEMS.register("vibranium_ingot",
            () -> new ColoredItem(new Item.Properties().fireResistant(), ChatFormatting.LIGHT_PURPLE));

    public static final RegistryObject<Item> VULPUS_INGOT = ITEMS.register("vulpus_ingot",
            () -> new ColoredItem(new Item.Properties().fireResistant(), ChatFormatting.RED));

    public static final RegistryObject<Item> ENDERIUM_INGOT = ITEMS.register("enderium_ingot",
            () -> new ColoredItem(new Item.Properties().fireResistant(), ChatFormatting.DARK_AQUA));

    //NUGGET
    public static final RegistryObject<Item> VIBRANIUM_NUGGET = ITEMS.register("vibranium_nugget",
            () -> new ColoredItem(new Item.Properties().fireResistant(), ChatFormatting.LIGHT_PURPLE));

    public static final RegistryObject<Item> VULPUS_NUGGET = ITEMS.register("vulpus_nugget",
            () -> new ColoredItem(new Item.Properties().fireResistant(), ChatFormatting.RED));

    public static final RegistryObject<Item> ENDERIUM_NUGGET = ITEMS.register("enderium_nugget",
            () -> new ColoredItem(new Item.Properties().fireResistant(), ChatFormatting.DARK_AQUA));

    //STICK
    public static final RegistryObject<Item> VIBRANIUM_STICK = ITEMS.register("vibranium_stick",
            () -> new ColoredItem(new Item.Properties().fireResistant(), ChatFormatting.LIGHT_PURPLE));

    public static final RegistryObject<Item> VULPUS_STICK = ITEMS.register("vulpus_stick",
            () -> new ColoredItem(new Item.Properties().fireResistant(), ChatFormatting.RED));

    public static final RegistryObject<Item> ENDERIUM_STICK = ITEMS.register("enderium_stick",
            () -> new ColoredItem(new Item.Properties().fireResistant(), ChatFormatting.DARK_AQUA));

    //VIBRANIUM
    public static final RegistryObject<Item> VIBRANIUM_PICKAXE = ITEMS.register("vibranium_pickaxe",
            () -> new VibraniumPickaxe(ModToolTiers.VIBRANIUM, VibraniumConfig.attackDamageVibraniumPickaxe.get(), VibraniumConfig.attackSpeedVibraniumPickaxe.get().floatValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> VIBRANIUM_SHOVEL = ITEMS.register("vibranium_shovel",
            () -> new VibraniumShovel(ModToolTiers.VIBRANIUM, VibraniumConfig.attackDamageVibraniumShovel.get(), VibraniumConfig.attackSpeedVibraniumShovel.get().floatValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> VIBRANIUM_AXE = ITEMS.register("vibranium_axe",
            () -> new VibraniumAxe(ModToolTiers.VIBRANIUM, VibraniumConfig.attackDamageVibraniumAxe.get(), VibraniumConfig.attackSpeedVibraniumAxe.get().floatValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> VIBRANIUM_SWORD = ITEMS.register("vibranium_sword",
            () -> new VibraniumSword(ModToolTiers.VIBRANIUM, VibraniumConfig.attackDamageVibraniumSword.get(), VibraniumConfig.attackSpeedVibraniumSword.get().floatValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> VIBRANIUM_BOW = ITEMS.register("vibranium_bow",
            () -> new VibraniumBow(BowTiers.VIBRANIUM, (new Item.Properties().fireResistant().stacksTo(1))));

    public static final RegistryObject<Item> VIBRANIUM_HOE = ITEMS.register("vibranium_hoe",
            () -> new VibraniumHoe(ModToolTiers.VIBRANIUM, VibraniumConfig.attackDamageVibraniumHoe.get(), VibraniumConfig.attackSpeedVibraniumHoe.get().floatValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> VIBRANIUM_PAXEL = ITEMS.register("vibranium_paxel",
            () -> new VibraniumPaxel(ModToolTiers.VIBRANIUM, VibraniumConfig.attackDamageVibraniumPaxel.get(), VibraniumConfig.attackSpeedVibraniumPaxel.get().floatValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> VIBRANIUM_HAMMER = ITEMS.register("vibranium_hammer",
            () -> new VibraniumHammer(ModToolTiers.VIBRANIUM, VibraniumConfig.attackDamageVibraniumHammer.get(), VibraniumConfig.attackSpeedVibraniumHammer.get().floatValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> VIBRANIUM_EXCAVATOR = ITEMS.register("vibranium_excavator",
            () -> new VibraniumExcavator(ModToolTiers.VIBRANIUM, VibraniumConfig.attackDamageVibraniumExcavator.get(), VibraniumConfig.attackSpeedVibraniumExcavator.get().floatValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> VIBRANIUM_HELMET = ITEMS.register("vibranium_helmet",
            () -> new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorItem.Type.HELMET,
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> VIBRANIUM_CHESTPLATE = ITEMS.register("vibranium_chestplate",
            () -> new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> VIBRANIUM_LEGGINGS = ITEMS.register("vibranium_leggings",
            () -> new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> VIBRANIUM_BOOTS = ITEMS.register("vibranium_boots",
            () -> new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorItem.Type.BOOTS,
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> VIBRANIUM_HORSE_ARMOR = ITEMS.register("vibranium_horse_armor",
            () -> new HorseArmorItem(VibraniumConfig.protectionValueVibraniumHorseArmor.get(), "vibranium",
                    new Item.Properties().fireResistant().stacksTo(1)) {
                @Override
                public Component getName(ItemStack stack) {
                    return super.getName(stack).copy().withStyle(ChatFormatting.LIGHT_PURPLE);
                }
            });

    //VULPUS
    public static final RegistryObject<Item> VULPUS_PICKAXE = ITEMS.register("vulpus_pickaxe",
            () -> new VulpusPickaxe(ModToolTiers.VULPUS, VulpusConfig.attackDamageVulpusPickaxe.get(), VulpusConfig.attackSpeedVulpusPickaxe.get().floatValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> VULPUS_SHOVEL = ITEMS.register("vulpus_shovel",
            () -> new VulpusShovel(ModToolTiers.VULPUS, VulpusConfig.attackDamageVulpusShovel.get(), VulpusConfig.attackSpeedVulpusShovel.get().floatValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> VULPUS_AXE = ITEMS.register("vulpus_axe",
            () -> new VulpusAxe(ModToolTiers.VULPUS, VulpusConfig.attackDamageVulpusAxe.get(), VulpusConfig.attackSpeedVulpusAxe.get().floatValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> VULPUS_SWORD = ITEMS.register("vulpus_sword",
            () -> new VulpusSword(ModToolTiers.VULPUS, VulpusConfig.attackDamageVulpusSword.get(), VulpusConfig.attackSpeedVulpusSword.get().floatValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> VULPUS_BOW = ITEMS.register("vulpus_bow",
            () -> new VulpusBow(BowTiers.VULPUS, (new Item.Properties().fireResistant().stacksTo(1))));

    public static final RegistryObject<Item> VULPUS_HOE = ITEMS.register("vulpus_hoe",
            () -> new VulpusHoe(ModToolTiers.VULPUS, VulpusConfig.attackDamageVulpusHoe.get(), VulpusConfig.attackSpeedVulpusHoe.get().floatValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> VULPUS_PAXEL = ITEMS.register("vulpus_paxel",
            () -> new VulpusPaxel(ModToolTiers.VULPUS, VulpusConfig.attackDamageVulpusPaxel.get(), VulpusConfig.attackSpeedVulpusPaxel.get().floatValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> VULPUS_HAMMER = ITEMS.register("vulpus_hammer",
            () -> new VulpusHammer(ModToolTiers.VULPUS, VulpusConfig.attackDamageVulpusHammer.get(), VulpusConfig.attackSpeedVulpusHammer.get().floatValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> VULPUS_EXCAVATOR = ITEMS.register("vulpus_excavator",
            () -> new VulpusExcavator(ModToolTiers.VULPUS, VulpusConfig.attackDamageVulpusExcavator.get(), VulpusConfig.attackSpeedVulpusExcavator.get().floatValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> VULPUS_HELMET = ITEMS.register("vulpus_helmet",
            () -> new VulpusArmor(ModArmorMaterials.VULPUS, ArmorItem.Type.HELMET,
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> VULPUS_CHESTPLATE = ITEMS.register("vulpus_chestplate",
            () -> new VulpusArmor(ModArmorMaterials.VULPUS, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> VULPUS_LEGGINGS = ITEMS.register("vulpus_leggings",
            () -> new VulpusArmor(ModArmorMaterials.VULPUS, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> VULPUS_BOOTS = ITEMS.register("vulpus_boots",
            () -> new VulpusArmor(ModArmorMaterials.VULPUS, ArmorItem.Type.BOOTS,
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> VULPUS_HORSE_ARMOR = ITEMS.register("vulpus_horse_armor",
            () -> new HorseArmorItem(VulpusConfig.protectionValueVulpusHorseArmor.get(), "vulpus",
                    new Item.Properties().fireResistant().stacksTo(1)) {
                @Override
                public Component getName(ItemStack stack) {
                    return super.getName(stack).copy().withStyle(ChatFormatting.RED);
                }
            });


    //ENDERIUM
    public static final RegistryObject<Item> ENDERIUM_PICKAXE = ITEMS.register("enderium_pickaxe",
            () -> new EnderiumPickaxe(ModToolTiers.ENDERIUM, EnderiumConfig.attackDamageEnderiumPickaxe.get(), EnderiumConfig.attackSpeedEnderiumPickaxe.get().floatValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> ENDERIUM_SHOVEL = ITEMS.register("enderium_shovel",
            () -> new EnderiumShovel(ModToolTiers.ENDERIUM, EnderiumConfig.attackDamageEnderiumShovel.get(), EnderiumConfig.attackSpeedEnderiumShovel.get().floatValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> ENDERIUM_AXE = ITEMS.register("enderium_axe",
            () -> new EnderiumAxe(ModToolTiers.ENDERIUM, EnderiumConfig.attackDamageEnderiumAxe.get(), EnderiumConfig.attackSpeedEnderiumAxe.get().floatValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> ENDERIUM_SWORD = ITEMS.register("enderium_sword",
            () -> new EnderiumSword(ModToolTiers.ENDERIUM, EnderiumConfig.attackDamageEnderiumSword.get(), EnderiumConfig.attackSpeedEnderiumSword.get().floatValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> ENDERIUM_BOW = ITEMS.register("enderium_bow",
            () -> new EnderiumBow(BowTiers.ENDERIUM, (new Item.Properties().fireResistant().stacksTo(1))));

    public static final RegistryObject<Item> ENDERIUM_HOE = ITEMS.register("enderium_hoe",
            () -> new EnderiumHoe(ModToolTiers.ENDERIUM, EnderiumConfig.attackDamageEnderiumHoe.get(), EnderiumConfig.attackSpeedEnderiumHoe.get().floatValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> ENDERIUM_PAXEL = ITEMS.register("enderium_paxel",
            () -> new EnderiumPaxel(ModToolTiers.ENDERIUM, EnderiumConfig.attackDamageEnderiumPaxel.get(), EnderiumConfig.attackSpeedEnderiumPaxel.get().floatValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> ENDERIUM_HAMMER = ITEMS.register("enderium_hammer",
            () -> new EnderiumHammer(ModToolTiers.ENDERIUM, EnderiumConfig.attackDamageEnderiumHammer.get(), EnderiumConfig.attackSpeedEnderiumHammer.get().floatValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> ENDERIUM_EXCAVATOR = ITEMS.register("enderium_excavator",
            () -> new EnderiumExcavator(ModToolTiers.ENDERIUM, EnderiumConfig.attackDamageEnderiumExcavator.get(), EnderiumConfig.attackSpeedEnderiumExcavator.get().floatValue(),
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> ENDERIUM_HELMET = ITEMS.register("enderium_helmet",
            () -> new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorItem.Type.HELMET,
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> ENDERIUM_CHESTPLATE = ITEMS.register("enderium_chestplate",
            () -> new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> ENDERIUM_LEGGINGS = ITEMS.register("enderium_leggings",
            () -> new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> ENDERIUM_BOOTS = ITEMS.register("enderium_boots",
            () -> new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorItem.Type.BOOTS,
                    new Item.Properties().fireResistant().stacksTo(1)));

    public static final RegistryObject<Item> ENDERIUM_HORSE_ARMOR = ITEMS.register("enderium_horse_armor",
            () -> new HorseArmorItem(EnderiumConfig.protectionValueEnderiumHorseArmor.get(), "enderium",
                    new Item.Properties().fireResistant().stacksTo(1)) {
                @Override
                public Component getName(ItemStack stack) {
                    return super.getName(stack).copy().withStyle(ChatFormatting.DARK_AQUA);
                }
            });


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
