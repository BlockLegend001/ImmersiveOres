package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.item.custom.enderium.*;
import com.blocklegend001.immersiveores.item.custom.vibranium.*;
import com.blocklegend001.immersiveores.item.custom.vulpus.*;
import com.blocklegend001.immersiveores.util.color.ColoredItem;
import com.blocklegend001.immersiveores.util.tools.bow.BowTiers;
import net.minecraft.item.AnimalArmorItem;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

public class ModItems {

    //RAW
    public static final Item RAW_VIBRANIUM = registerItem("raw_vibranium",
            new ColoredItem(new Item.Settings().fireproof(), Formatting.LIGHT_PURPLE));

    public static final Item RAW_VULPUS = registerItem("raw_vulpus",
            new ColoredItem(new Item.Settings().fireproof(), Formatting.RED));

    public static final Item RAW_ENDERIUM = registerItem("raw_enderium",
            new ColoredItem(new Item.Settings().fireproof(), Formatting.DARK_AQUA));

    //INGOT
    public static final Item VIBRANIUM_INGOT = registerItem("vibranium_ingot",
            new ColoredItem(new Item.Settings().fireproof(), Formatting.LIGHT_PURPLE));

    public static final Item VULPUS_INGOT = registerItem("vulpus_ingot",
            new ColoredItem(new Item.Settings().fireproof(), Formatting.RED));

    public static final Item ENDERIUM_INGOT = registerItem("enderium_ingot",
            new ColoredItem(new Item.Settings().fireproof(), Formatting.DARK_AQUA));

    //NUGGET
    public static final Item VIBRANIUM_NUGGET = registerItem("vibranium_nugget",
            new ColoredItem(new Item.Settings().fireproof(), Formatting.LIGHT_PURPLE));

    public static final Item VULPUS_NUGGET = registerItem("vulpus_nugget",
            new ColoredItem(new Item.Settings().fireproof(), Formatting.RED));

    public static final Item ENDERIUM_NUGGET = registerItem("enderium_nugget",
            new ColoredItem(new Item.Settings().fireproof(), Formatting.DARK_AQUA));

    //STICK
    public static final Item VIBRANIUM_STICK = registerItem("vibranium_stick",
            new ColoredItem(new Item.Settings().fireproof(), Formatting.LIGHT_PURPLE));

    public static final Item VULPUS_STICK = registerItem("vulpus_stick",
            new ColoredItem(new Item.Settings().fireproof(), Formatting.RED));

    public static final Item ENDERIUM_STICK = registerItem("enderium_stick",
            new ColoredItem(new Item.Settings().fireproof(), Formatting.DARK_AQUA));

    //VIBRANIUM
    public static final Item VIBRANIUM_PICKAXE = registerItem("vibranium_pickaxe",
            new VibraniumPickaxe(ModToolMaterials.VIBRANIUM, ImmersiveOres.VIBRANIUM_CONFIG.pickaxe().attackDamage, (float) ImmersiveOres.VIBRANIUM_CONFIG.pickaxe().attackSpeed));

    public static final Item VIBRANIUM_SHOVEL = registerItem("vibranium_shovel",
            new VibraniumShovel(ModToolMaterials.VIBRANIUM, ImmersiveOres.VIBRANIUM_CONFIG.shovel().attackDamage, (float) ImmersiveOres.VIBRANIUM_CONFIG.shovel().attackSpeed));

    public static final Item VIBRANIUM_AXE = registerItem("vibranium_axe",
            new VibraniumAxe(ModToolMaterials.VIBRANIUM, ImmersiveOres.VIBRANIUM_CONFIG.axe().attackDamage, (float) ImmersiveOres.VIBRANIUM_CONFIG.axe().attackSpeed));

    public static final Item VIBRANIUM_SWORD = registerItem("vibranium_sword",
            new VibraniumSword(ModToolMaterials.VIBRANIUM, ImmersiveOres.VIBRANIUM_CONFIG.sword().attackDamage, (float) ImmersiveOres.VIBRANIUM_CONFIG.sword().attackSpeed));

    public static final Item VIBRANIUM_BOW = registerItem("vibranium_bow",
            new VibraniumBow(BowTiers.VIBRANIUM));

    public static final Item VIBRANIUM_HOE = registerItem("vibranium_hoe",
            new VibraniumHoe(ModToolMaterials.VIBRANIUM, ImmersiveOres.VIBRANIUM_CONFIG.hoe().attackDamage, (float) ImmersiveOres.VIBRANIUM_CONFIG.hoe().attackSpeed));

    public static final Item VIBRANIUM_PAXEL = registerItem("vibranium_paxel",
            new VibraniumPaxel(ModToolMaterials.VIBRANIUM, ImmersiveOres.VIBRANIUM_CONFIG.paxel().attackDamage, (float) ImmersiveOres.VIBRANIUM_CONFIG.paxel().attackSpeed));

    public static final Item VIBRANIUM_HAMMER = registerItem("vibranium_hammer",
            new VibraniumHammer(ModToolMaterials.VIBRANIUM, ImmersiveOres.VIBRANIUM_CONFIG.hammer().attackDamage, (float) ImmersiveOres.VIBRANIUM_CONFIG.hammer().attackSpeed));

    public static final Item VIBRANIUM_EXCAVATOR = registerItem("vibranium_excavator",
            new VibraniumExcavator(ModToolMaterials.VIBRANIUM, ImmersiveOres.VIBRANIUM_CONFIG.excavator().attackDamage, (float) ImmersiveOres.VIBRANIUM_CONFIG.excavator().attackSpeed));

    public static final Item VIBRANIUM_HELMET = registerItem("vibranium_helmet",
            new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorItem.Type.HELMET,
                    new Item.Settings().fireproof().maxCount(1)));

    public static final Item VIBRANIUM_CHESTPLATE = registerItem("vibranium_chestplate",
            new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().fireproof().maxCount(1)));

    public static final Item VIBRANIUM_LEGGINGS = registerItem("vibranium_leggings",
            new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().fireproof().maxCount(1)));

    public static final Item VIBRANIUM_BOOTS = registerItem("vibranium_boots",
            new VibraniumArmor(ModArmorMaterials.VIBRANIUM, ArmorItem.Type.BOOTS,
                    new Item.Settings().fireproof().maxCount(1)));

    public static final Item VIBRANIUM_HORSE_ARMOR = registerItem("vibranium_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.VIBRANIUM, AnimalArmorItem.Type.EQUESTRIAN, false,
                    new Item.Settings().fireproof().maxCount(1)) {
                @Override
                public Text getName(ItemStack stack) {
                    return super.getName(stack).copy().formatted(Formatting.LIGHT_PURPLE);
                }
            });

    //VULPUS
    public static final Item VULPUS_PICKAXE = registerItem("vulpus_pickaxe",
            new VulpusPickaxe(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusPickaxe, (float) VulpusConfig.attackSpeedVulpusPickaxe));

    public static final Item VULPUS_SHOVEL = registerItem("vulpus_shovel",
            new VulpusShovel(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusShovel, (float) VulpusConfig.attackSpeedVulpusShovel));

    public static final Item VULPUS_AXE = registerItem("vulpus_axe",
            new VulpusAxe(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusAxe, (float) VulpusConfig.attackSpeedVulpusAxe));

    public static final Item VULPUS_SWORD = registerItem("vulpus_sword",
            new VulpusSword(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusSword, (float) VulpusConfig.attackSpeedVulpusSword));

    public static final Item VULPUS_BOW = registerItem("vulpus_bow",
            new VulpusBow(BowTiers.VULPUS));

    public static final Item VULPUS_HOE = registerItem("vulpus_hoe",
            new VulpusHoe(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusHoe, (float) VulpusConfig.attackSpeedVulpusHoe));

    public static final Item VULPUS_PAXEL = registerItem("vulpus_paxel",
            new VulpusPaxel(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusPaxel, (float) VulpusConfig.attackSpeedVulpusPaxel));

    public static final Item VULPUS_HAMMER = registerItem("vulpus_hammer",
            new VulpusHammer(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusHammer, (float) VulpusConfig.attackSpeedVulpusHammer));

    public static final Item VULPUS_EXCAVATOR = registerItem("vulpus_excavator",
            new VulpusExcavator(ModToolMaterials.VULPUS, VulpusConfig.attackDamageVulpusExcavator, (float) VulpusConfig.attackSpeedVulpusExcavator));

    public static final Item VULPUS_HELMET = registerItem("vulpus_helmet",
            new VulpusArmor(ModArmorMaterials.VULPUS, ArmorItem.Type.HELMET,
                    new Item.Settings().fireproof().maxCount(1)));

    public static final Item VULPUS_CHESTPLATE = registerItem("vulpus_chestplate",
            new VulpusArmor(ModArmorMaterials.VULPUS, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().fireproof().maxCount(1)));

    public static final Item VULPUS_LEGGINGS = registerItem("vulpus_leggings",
            new VulpusArmor(ModArmorMaterials.VULPUS, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().fireproof().maxCount(1)));

    public static final Item VULPUS_BOOTS = registerItem("vulpus_boots",
            new VulpusArmor(ModArmorMaterials.VULPUS, ArmorItem.Type.BOOTS,
                    new Item.Settings().fireproof().maxCount(1)));

    public static final Item VULPUS_HORSE_ARMOR = registerItem("vulpus_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.VULPUS, AnimalArmorItem.Type.EQUESTRIAN, false,
                    new Item.Settings().fireproof().maxCount(1)) {
                @Override
                public Text getName(ItemStack stack) {
                    return super.getName(stack).copy().formatted(Formatting.RED);
                }
            });

    //ENDERIUM
    public static final Item ENDERIUM_PICKAXE = registerItem("enderium_pickaxe",
            new EnderiumPickaxe(ModToolMaterials.ENDERIUM, ImmersiveOres.ENDERIUM_CONFIG.pickaxe().attackDamage, (float) ImmersiveOres.ENDERIUM_CONFIG.pickaxe().attackSpeed));

    public static final Item ENDERIUM_SHOVEL = registerItem("enderium_shovel",
            new EnderiumShovel(ModToolMaterials.ENDERIUM, ImmersiveOres.ENDERIUM_CONFIG.shovel().attackDamage, (float) ImmersiveOres.ENDERIUM_CONFIG.shovel().attackSpeed));

    public static final Item ENDERIUM_AXE = registerItem("enderium_axe",
            new EnderiumAxe(ModToolMaterials.ENDERIUM, ImmersiveOres.ENDERIUM_CONFIG.axe().attackDamage, (float) ImmersiveOres.ENDERIUM_CONFIG.axe().attackSpeed));

    public static final Item ENDERIUM_SWORD = registerItem("enderium_sword",
            new EnderiumSword(ModToolMaterials.ENDERIUM, ImmersiveOres.ENDERIUM_CONFIG.sword().attackDamage, (float) ImmersiveOres.ENDERIUM_CONFIG.sword().attackSpeed));

    public static final Item ENDERIUM_BOW = registerItem("enderium_bow",
            new EnderiumBow(BowTiers.ENDERIUM));

    public static final Item ENDERIUM_HOE = registerItem("enderium_hoe",
            new EnderiumHoe(ModToolMaterials.ENDERIUM, ImmersiveOres.ENDERIUM_CONFIG.hoe().attackDamage, (float) ImmersiveOres.ENDERIUM_CONFIG.hoe().attackSpeed));

    public static final Item ENDERIUM_PAXEL = registerItem("enderium_paxel",
            new EnderiumPaxel(ModToolMaterials.ENDERIUM, ImmersiveOres.ENDERIUM_CONFIG.paxel().attackDamage, (float) ImmersiveOres.ENDERIUM_CONFIG.paxel().attackSpeed));

    public static final Item ENDERIUM_HAMMER = registerItem("enderium_hammer",
            new EnderiumHammer(ModToolMaterials.ENDERIUM, ImmersiveOres.ENDERIUM_CONFIG.hammer().attackDamage, (float) ImmersiveOres.ENDERIUM_CONFIG.hammer().attackSpeed));

    public static final Item ENDERIUM_EXCAVATOR = registerItem("enderium_excavator",
            new EnderiumExcavator(ModToolMaterials.ENDERIUM, ImmersiveOres.ENDERIUM_CONFIG.excavator().attackDamage, (float) ImmersiveOres.ENDERIUM_CONFIG.excavator().attackSpeed));

    public static final Item ENDERIUM_HELMET = registerItem("enderium_helmet",
            new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorItem.Type.HELMET,
                    new Item.Settings().fireproof().maxCount(1)));

    public static final Item ENDERIUM_CHESTPLATE = registerItem("enderium_chestplate",
            new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorItem.Type.CHESTPLATE,
                    new Item.Settings().fireproof().maxCount(1)));

    public static final Item ENDERIUM_LEGGINGS = registerItem("enderium_leggings",
            new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorItem.Type.LEGGINGS,
                    new Item.Settings().fireproof().maxCount(1)));

    public static final Item ENDERIUM_BOOTS = registerItem("enderium_boots",
            new EnderiumArmor(ModArmorMaterials.ENDERIUM, ArmorItem.Type.BOOTS,
                    new Item.Settings().fireproof().maxCount(1)));

    public static final Item ENDERIUM_HORSE_ARMOR = registerItem("enderium_horse_armor",
            new AnimalArmorItem(ModArmorMaterials.ENDERIUM, AnimalArmorItem.Type.EQUESTRIAN, false,
                    new Item.Settings().fireproof().maxCount(1)) {
                @Override
                public Text getName(ItemStack stack) {
                    return super.getName(stack).copy().formatted(Formatting.DARK_AQUA);
                }
            }
    );

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ImmersiveOres.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ImmersiveOres.LOGGER.info("Registering Mod Items for " + ImmersiveOres.MOD_ID);
    }
}
