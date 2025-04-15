package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.blocks.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
        public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
                DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ImmersiveOres.MODID);

        public static final RegistryObject<CreativeModeTab> IMMERSIVEORES = CREATIVE_MODE_TABS.register("immersiveores",
                () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ENDERIUM_INGOT.get()))
                        .title(Component.translatable("itemGroup.immersiveorestab"))
                        .displayItems((pParameters, pOutput) -> {
                                pOutput.accept(ModBlocks.VIBRANIUM_ORE.get());
                                pOutput.accept(ModBlocks.VULPUS_ORE.get());
                                pOutput.accept(ModBlocks.ENDERIUM_ORE.get());
                                pOutput.accept(ModBlocks.RAW_VIBRANIUM_BLOCK.get());
                                pOutput.accept(ModBlocks.RAW_VULPUS_BLOCK.get());
                                pOutput.accept(ModBlocks.RAW_ENDERIUM_BLOCK.get());
                                pOutput.accept(ModBlocks.VIBRANIUM_BLOCK.get());
                                pOutput.accept(ModBlocks.VULPUS_BLOCK.get());
                                pOutput.accept(ModBlocks.ENDERIUM_BLOCK.get());
                                pOutput.accept(ModItems.RAW_VIBRANIUM.get());
                                pOutput.accept(ModItems.RAW_VULPUS.get());
                                pOutput.accept(ModItems.RAW_ENDERIUM.get());
                                pOutput.accept(ModItems.VIBRANIUM_INGOT.get());
                                pOutput.accept(ModItems.VULPUS_INGOT.get());
                                pOutput.accept(ModItems.ENDERIUM_INGOT.get());
                                pOutput.accept(ModItems.VIBRANIUM_NUGGET.get());
                                pOutput.accept(ModItems.VULPUS_NUGGET.get());
                                pOutput.accept(ModItems.ENDERIUM_NUGGET.get());
                                pOutput.accept(ModItems.VIBRANIUM_STICK.get());
                                pOutput.accept(ModItems.VULPUS_STICK.get());
                                pOutput.accept(ModItems.ENDERIUM_STICK.get());
                                pOutput.accept(ModItems.VIBRANIUM_PICKAXE.get());
                                pOutput.accept(ModItems.VIBRANIUM_AXE.get());
                                pOutput.accept(ModItems.VIBRANIUM_SHOVEL.get());
                                pOutput.accept(ModItems.VIBRANIUM_SWORD.get());
                                pOutput.accept(ModItems.VIBRANIUM_BOW.get());
                                pOutput.accept(ModItems.VIBRANIUM_HOE.get());
                                pOutput.accept(ModItems.VIBRANIUM_PAXEL.get());
                                pOutput.accept(ModItems.VIBRANIUM_HAMMER.get());
                                pOutput.accept(ModItems.VIBRANIUM_EXCAVATOR.get());
                                pOutput.accept(ModItems.VIBRANIUM_HELMET.get());
                                pOutput.accept(ModItems.VIBRANIUM_CHESTPLATE.get());
                                pOutput.accept(ModItems.VIBRANIUM_LEGGINGS.get());
                                pOutput.accept(ModItems.VIBRANIUM_BOOTS.get());
                                pOutput.accept(ModItems.VIBRANIUM_HORSE_ARMOR.get());
                                pOutput.accept(ModItems.VULPUS_PICKAXE.get());
                                pOutput.accept(ModItems.VULPUS_AXE.get());
                                pOutput.accept(ModItems.VULPUS_SHOVEL.get());
                                pOutput.accept(ModItems.VULPUS_SWORD.get());
                                pOutput.accept(ModItems.VULPUS_BOW.get());
                                pOutput.accept(ModItems.VULPUS_HOE.get());
                                pOutput.accept(ModItems.VULPUS_PAXEL.get());
                                pOutput.accept(ModItems.VULPUS_HAMMER.get());
                                pOutput.accept(ModItems.VULPUS_EXCAVATOR.get());
                                pOutput.accept(ModItems.VULPUS_HELMET.get());
                                pOutput.accept(ModItems.VULPUS_CHESTPLATE.get());
                                pOutput.accept(ModItems.VULPUS_LEGGINGS.get());
                                pOutput.accept(ModItems.VULPUS_BOOTS.get());
                                pOutput.accept(ModItems.VULPUS_HORSE_ARMOR.get());
                                pOutput.accept(ModItems.ENDERIUM_PICKAXE.get());
                                pOutput.accept(ModItems.ENDERIUM_AXE.get());
                                pOutput.accept(ModItems.ENDERIUM_SHOVEL.get());
                                pOutput.accept(ModItems.ENDERIUM_SWORD.get());
                                pOutput.accept(ModItems.ENDERIUM_BOW.get());
                                pOutput.accept(ModItems.ENDERIUM_HOE.get());
                                pOutput.accept(ModItems.ENDERIUM_PAXEL.get());
                                pOutput.accept(ModItems.ENDERIUM_HAMMER.get());
                                pOutput.accept(ModItems.ENDERIUM_EXCAVATOR.get());
                                pOutput.accept(ModItems.ENDERIUM_HELMET.get());
                                pOutput.accept(ModItems.ENDERIUM_CHESTPLATE.get());
                                pOutput.accept(ModItems.ENDERIUM_LEGGINGS.get());
                                pOutput.accept(ModItems.ENDERIUM_BOOTS.get());
                                pOutput.accept(ModItems.ENDERIUM_HORSE_ARMOR.get());
                        })
                        .build());

        public static void register(IEventBus pOutputBus) {
                CREATIVE_MODE_TABS.register(pOutputBus);
        }
}