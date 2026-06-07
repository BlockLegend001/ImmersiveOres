package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.blocks.ModBlocks;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroups {
    public static final CreativeModeTab IMMERSIVEORES = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(ImmersiveOres.MOD_ID, "immersiveores"),
            FabricCreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ENDERIUM_INGOT))
                    .title(Component.translatable("itemGroup.immersiveorestab").withStyle(ChatFormatting.DARK_AQUA))
                    .displayItems((parameters, output) -> {
                        output.accept(ModBlocks.VIBRANIUM_ORE);
                        output.accept(ModBlocks.VULPUS_ORE);
                        output.accept(ModBlocks.ENDERIUM_ORE);
                        output.accept(ModBlocks.RAW_VIBRANIUM_BLOCK);
                        output.accept(ModBlocks.RAW_VULPUS_BLOCK);
                        output.accept(ModBlocks.RAW_ENDERIUM_BLOCK);
                        output.accept(ModBlocks.VIBRANIUM_BLOCK);
                        output.accept(ModBlocks.VULPUS_BLOCK);
                        output.accept(ModBlocks.ENDERIUM_BLOCK);
                        output.accept(ModItems.RAW_VIBRANIUM);
                        output.accept(ModItems.RAW_VULPUS);
                        output.accept(ModItems.RAW_ENDERIUM);
                        output.accept(ModItems.VIBRANIUM_INGOT);
                        output.accept(ModItems.VULPUS_INGOT);
                        output.accept(ModItems.ENDERIUM_INGOT);
                        output.accept(ModItems.VIBRANIUM_NUGGET);
                        output.accept(ModItems.VULPUS_NUGGET);
                        output.accept(ModItems.ENDERIUM_NUGGET);
                        output.accept(ModItems.VIBRANIUM_STICK);
                        output.accept(ModItems.VULPUS_STICK);
                        output.accept(ModItems.ENDERIUM_STICK);
                        output.accept(ModItems.VIBRANIUM_PICKAXE);
                        output.accept(ModItems.VIBRANIUM_AXE);
                        output.accept(ModItems.VIBRANIUM_SHOVEL);
                        output.accept(ModItems.VIBRANIUM_SWORD);
                        output.accept(ModItems.VIBRANIUM_BOW);
                        output.accept(ModItems.VIBRANIUM_HOE);
                        output.accept(ModItems.VIBRANIUM_PAXEL);
                        output.accept(ModItems.VIBRANIUM_HAMMER);
                        output.accept(ModItems.VIBRANIUM_EXCAVATOR);
                        output.accept(ModItems.VIBRANIUM_HELMET);
                        output.accept(ModItems.VIBRANIUM_CHESTPLATE);
                        output.accept(ModItems.VIBRANIUM_LEGGINGS);
                        output.accept(ModItems.VIBRANIUM_BOOTS);
                        output.accept(ModItems.VIBRANIUM_HORSE_ARMOR);
                        output.accept(ModItems.VULPUS_PICKAXE);
                        output.accept(ModItems.VULPUS_AXE);
                        output.accept(ModItems.VULPUS_SHOVEL);
                        output.accept(ModItems.VULPUS_SWORD);
                        output.accept(ModItems.VULPUS_BOW);
                        output.accept(ModItems.VULPUS_HOE);
                        output.accept(ModItems.VULPUS_PAXEL);
                        output.accept(ModItems.VULPUS_HAMMER);
                        output.accept(ModItems.VULPUS_EXCAVATOR);
                        output.accept(ModItems.VULPUS_HELMET);
                        output.accept(ModItems.VULPUS_CHESTPLATE);
                        output.accept(ModItems.VULPUS_LEGGINGS);
                        output.accept(ModItems.VULPUS_BOOTS);
                        output.accept(ModItems.VULPUS_HORSE_ARMOR);
                        output.accept(ModItems.ENDERIUM_PICKAXE);
                        output.accept(ModItems.ENDERIUM_AXE);
                        output.accept(ModItems.ENDERIUM_SHOVEL);
                        output.accept(ModItems.ENDERIUM_SWORD);
                        output.accept(ModItems.ENDERIUM_BOW);
                        output.accept(ModItems.ENDERIUM_HOE);
                        output.accept(ModItems.ENDERIUM_PAXEL);
                        output.accept(ModItems.ENDERIUM_HAMMER);
                        output.accept(ModItems.ENDERIUM_EXCAVATOR);
                        output.accept(ModItems.ENDERIUM_HELMET);
                        output.accept(ModItems.ENDERIUM_CHESTPLATE);
                        output.accept(ModItems.ENDERIUM_LEGGINGS);
                        output.accept(ModItems.ENDERIUM_BOOTS);
                        output.accept(ModItems.ENDERIUM_HORSE_ARMOR);
                    }).build());

    public static void registerItemGroups() {
        ImmersiveOres.LOGGER.info("Registering Item Groups for " + ImmersiveOres.MOD_ID);
    }
}
