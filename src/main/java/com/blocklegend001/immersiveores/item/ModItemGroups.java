package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.blocks.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup IMMERSIVEORES = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ImmersiveOres.MOD_ID, "immersiveores"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.ENDERIUM_INGOT))
                    .displayName(Text.translatable("itemGroup.immersiveorestab"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.VIBRANIUM_ORE);
                        entries.add(ModBlocks.VULPUS_ORE);
                        entries.add(ModBlocks.ENDERIUM_ORE);
                        entries.add(ModBlocks.RAW_VIBRANIUM_BLOCK);
                        entries.add(ModBlocks.RAW_VULPUS_BLOCK);
                        entries.add(ModBlocks.RAW_ENDERIUM_BLOCK);
                        entries.add(ModBlocks.VIBRANIUM_BLOCK);
                        entries.add(ModBlocks.VULPUS_BLOCK);
                        entries.add(ModBlocks.ENDERIUM_BLOCK);
                        entries.add(ModItems.RAW_VIBRANIUM);
                        entries.add(ModItems.RAW_VULPUS);
                        entries.add(ModItems.RAW_ENDERIUM);
                        entries.add(ModItems.VIBRANIUM_INGOT);
                        entries.add(ModItems.VULPUS_INGOT);
                        entries.add(ModItems.ENDERIUM_INGOT);
                        entries.add(ModItems.VIBRANIUM_NUGGET);
                        entries.add(ModItems.VULPUS_NUGGET);
                        entries.add(ModItems.ENDERIUM_NUGGET);
                        entries.add(ModItems.VIBRANIUM_STICK);
                        entries.add(ModItems.VULPUS_STICK);
                        entries.add(ModItems.ENDERIUM_STICK);
                        entries.add(ModItems.VIBRANIUM_PICKAXE);
                        entries.add(ModItems.VIBRANIUM_AXE);
                        entries.add(ModItems.VIBRANIUM_SHOVEL);
                        entries.add(ModItems.VIBRANIUM_SWORD);
                        entries.add(ModItems.VIBRANIUM_BOW);
                        entries.add(ModItems.VIBRANIUM_HOE);
                        entries.add(ModItems.VIBRANIUM_PAXEL);
                        entries.add(ModItems.VIBRANIUM_HAMMER);
                        entries.add(ModItems.VIBRANIUM_EXCAVATOR);
                        entries.add(ModItems.VIBRANIUM_HELMET);
                        entries.add(ModItems.VIBRANIUM_CHESTPLATE);
                        entries.add(ModItems.VIBRANIUM_LEGGINGS);
                        entries.add(ModItems.VIBRANIUM_BOOTS);
                        entries.add(ModItems.VIBRANIUM_HORSE_ARMOR);
                        entries.add(ModItems.VULPUS_PICKAXE);
                        entries.add(ModItems.VULPUS_AXE);
                        entries.add(ModItems.VULPUS_SHOVEL);
                        entries.add(ModItems.VULPUS_SWORD);
                        entries.add(ModItems.VULPUS_BOW);
                        entries.add(ModItems.VULPUS_HOE);
                        entries.add(ModItems.VULPUS_PAXEL);
                        entries.add(ModItems.VULPUS_HAMMER);
                        entries.add(ModItems.VULPUS_EXCAVATOR);
                        entries.add(ModItems.VULPUS_HELMET);
                        entries.add(ModItems.VULPUS_CHESTPLATE);
                        entries.add(ModItems.VULPUS_LEGGINGS);
                        entries.add(ModItems.VULPUS_BOOTS);
                        entries.add(ModItems.VULPUS_HORSE_ARMOR);
                        entries.add(ModItems.ENDERIUM_PICKAXE);
                        entries.add(ModItems.ENDERIUM_AXE);
                        entries.add(ModItems.ENDERIUM_SHOVEL);
                        entries.add(ModItems.ENDERIUM_SWORD);
                        entries.add(ModItems.ENDERIUM_BOW);
                        entries.add(ModItems.ENDERIUM_HOE);
                        entries.add(ModItems.ENDERIUM_PAXEL);
                        entries.add(ModItems.ENDERIUM_HAMMER);
                        entries.add(ModItems.ENDERIUM_EXCAVATOR);
                        entries.add(ModItems.ENDERIUM_HELMET);
                        entries.add(ModItems.ENDERIUM_CHESTPLATE);
                        entries.add(ModItems.ENDERIUM_LEGGINGS);
                        entries.add(ModItems.ENDERIUM_BOOTS);
                        entries.add(ModItems.ENDERIUM_HORSE_ARMOR);
                    }).build());

    public static void registerItemGroups() {
        ImmersiveOres.LOGGER.info("Registering Item Groups for " + ImmersiveOres.MOD_ID);
    }
}
