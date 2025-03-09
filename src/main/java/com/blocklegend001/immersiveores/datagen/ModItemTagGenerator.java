package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.item.ModItems;
import com.blocklegend001.immersiveores.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends FabricTagProvider.ItemTagProvider {
    public ModItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    public void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.VIBRANIUM_HELMET,
                        ModItems.VIBRANIUM_CHESTPLATE,
                        ModItems.VIBRANIUM_LEGGINGS,
                        ModItems.VIBRANIUM_BOOTS,

                        ModItems.VULPUS_HELMET,
                        ModItems.VULPUS_CHESTPLATE,
                        ModItems.VULPUS_LEGGINGS,
                        ModItems.VULPUS_BOOTS,

                        ModItems.ENDERIUM_HELMET,
                        ModItems.ENDERIUM_CHESTPLATE,
                        ModItems.ENDERIUM_LEGGINGS,
                        ModItems.ENDERIUM_BOOTS);

        getOrCreateTagBuilder(ModTags.Items.VIBRANIUM_BOW).add(ModItems.VIBRANIUM_BOW);
        getOrCreateTagBuilder(ModTags.Items.VULPUS_BOW).add(ModItems.VULPUS_BOW);
        getOrCreateTagBuilder(ModTags.Items.ENDERIUM_BOW).add(ModItems.ENDERIUM_BOW);

        getOrCreateTagBuilder(ModTags.Items.VIBRANIUM_HAMMER).add(ModItems.VIBRANIUM_HAMMER);
        getOrCreateTagBuilder(ModTags.Items.VULPUS_HAMMER).add(ModItems.VULPUS_HAMMER);
        getOrCreateTagBuilder(ModTags.Items.ENDERIUM_HAMMER).add(ModItems.ENDERIUM_HAMMER);

        getOrCreateTagBuilder(ModTags.Items.VIBRANIUM_EXCAVATOR).add(ModItems.VIBRANIUM_EXCAVATOR);
        getOrCreateTagBuilder(ModTags.Items.VULPUS_EXCAVATOR).add(ModItems.VULPUS_EXCAVATOR);
        getOrCreateTagBuilder(ModTags.Items.ENDERIUM_EXCAVATOR).add(ModItems.ENDERIUM_EXCAVATOR);

        getOrCreateTagBuilder(ModTags.Items.VIBRANIUM_PICKAXE).add(ModItems.VIBRANIUM_PICKAXE);
        getOrCreateTagBuilder(ModTags.Items.VULPUS_PICKAXE).add(ModItems.VULPUS_PICKAXE);
        getOrCreateTagBuilder(ModTags.Items.ENDERIUM_PICKAXE).add(ModItems.ENDERIUM_PICKAXE);

        getOrCreateTagBuilder(ModTags.Items.VIBRANIUM_HOE).add(ModItems.VIBRANIUM_HOE);
        getOrCreateTagBuilder(ModTags.Items.VULPUS_HOE).add(ModItems.VULPUS_HOE);
        getOrCreateTagBuilder(ModTags.Items.ENDERIUM_HOE).add(ModItems.ENDERIUM_HOE);

        getOrCreateTagBuilder(ModTags.Items.VIBRANIUM_AXE).add(ModItems.VIBRANIUM_AXE);
        getOrCreateTagBuilder(ModTags.Items.VULPUS_AXE).add(ModItems.VULPUS_AXE);
        getOrCreateTagBuilder(ModTags.Items.ENDERIUM_AXE).add(ModItems.ENDERIUM_AXE);

        getOrCreateTagBuilder(ModTags.Items.VIBRANIUM_SHOVEL).add(ModItems.VIBRANIUM_SHOVEL);
        getOrCreateTagBuilder(ModTags.Items.VULPUS_SHOVEL).add(ModItems.VULPUS_SHOVEL);
        getOrCreateTagBuilder(ModTags.Items.ENDERIUM_SHOVEL).add(ModItems.ENDERIUM_SHOVEL);

        getOrCreateTagBuilder(ModTags.Items.VIBRANIUM_PAXEL).add(ModItems.VIBRANIUM_PAXEL);
        getOrCreateTagBuilder(ModTags.Items.VULPUS_PAXEL).add(ModItems.VULPUS_PAXEL);
        getOrCreateTagBuilder(ModTags.Items.ENDERIUM_PAXEL).add(ModItems.ENDERIUM_PAXEL);

        getOrCreateTagBuilder(ModTags.Items.VIBRANIUM_SWORD).add(ModItems.VIBRANIUM_SWORD);
        getOrCreateTagBuilder(ModTags.Items.VULPUS_SWORD).add(ModItems.VULPUS_SWORD);
        getOrCreateTagBuilder(ModTags.Items.ENDERIUM_SWORD).add(ModItems.ENDERIUM_SWORD);

        getOrCreateTagBuilder(ModTags.Items.VIBRANIUM_ARMOR).add(ModItems.VIBRANIUM_HELMET,
                ModItems.VIBRANIUM_CHESTPLATE,
                ModItems.VIBRANIUM_LEGGINGS,
                ModItems.VIBRANIUM_BOOTS);

        getOrCreateTagBuilder(ModTags.Items.VULPUS_ARMOR).add(ModItems.VULPUS_HELMET,
                ModItems.VULPUS_CHESTPLATE,
                ModItems.VULPUS_LEGGINGS,
                ModItems.VULPUS_BOOTS);

        getOrCreateTagBuilder(ModTags.Items.ENDERIUM_ARMOR).add(ModItems.ENDERIUM_HELMET,
                ModItems.ENDERIUM_CHESTPLATE,
                ModItems.ENDERIUM_LEGGINGS,
                ModItems.ENDERIUM_BOOTS);

        getOrCreateTagBuilder(ItemTags.BOW_ENCHANTABLE).add(ModItems.VIBRANIUM_BOW,
                ModItems.VULPUS_BOW,
                ModItems.ENDERIUM_BOW);

        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE).add(ModItems.VIBRANIUM_SWORD,
                ModItems.VULPUS_SWORD,
                ModItems.ENDERIUM_SWORD);

        getOrCreateTagBuilder(ItemTags.ARMOR_ENCHANTABLE).add(ModItems.VIBRANIUM_HELMET,
                ModItems.VIBRANIUM_CHESTPLATE,
                ModItems.VIBRANIUM_LEGGINGS,
                ModItems.VIBRANIUM_BOOTS,
                ModItems.VULPUS_HELMET,
                ModItems.VULPUS_CHESTPLATE,
                ModItems.VULPUS_LEGGINGS,
                ModItems.VULPUS_BOOTS,
                ModItems.ENDERIUM_HELMET,
                ModItems.ENDERIUM_CHESTPLATE,
                ModItems.ENDERIUM_LEGGINGS,
                ModItems.ENDERIUM_BOOTS);

        getOrCreateTagBuilder(ItemTags.MINING_LOOT_ENCHANTABLE).add(ModItems.VIBRANIUM_HAMMER,
                ModItems.VULPUS_HAMMER,
                ModItems.ENDERIUM_HAMMER,
                ModItems.VIBRANIUM_EXCAVATOR,
                ModItems.VULPUS_EXCAVATOR,
                ModItems.ENDERIUM_EXCAVATOR,
                ModItems.VIBRANIUM_PICKAXE,
                ModItems.VULPUS_PICKAXE,
                ModItems.ENDERIUM_PICKAXE,
                ModItems.VIBRANIUM_HOE,
                ModItems.VULPUS_HOE,
                ModItems.ENDERIUM_HOE,
                ModItems.VIBRANIUM_AXE,
                ModItems.VULPUS_AXE,
                ModItems.ENDERIUM_AXE,
                ModItems.VIBRANIUM_SHOVEL,
                ModItems.VULPUS_SHOVEL,
                ModItems.ENDERIUM_SHOVEL,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL);

        getOrCreateTagBuilder(ItemTags.VANISHING_ENCHANTABLE).add(ModItems.VIBRANIUM_HAMMER,
                ModItems.VULPUS_HAMMER,
                ModItems.ENDERIUM_HAMMER,
                ModItems.VIBRANIUM_EXCAVATOR,
                ModItems.VULPUS_EXCAVATOR,
                ModItems.ENDERIUM_EXCAVATOR,
                ModItems.VIBRANIUM_PICKAXE,
                ModItems.VULPUS_PICKAXE,
                ModItems.ENDERIUM_PICKAXE,
                ModItems.VIBRANIUM_HOE,
                ModItems.VULPUS_HOE,
                ModItems.ENDERIUM_HOE,
                ModItems.VIBRANIUM_AXE,
                ModItems.VULPUS_AXE,
                ModItems.ENDERIUM_AXE,
                ModItems.VIBRANIUM_SHOVEL,
                ModItems.VULPUS_SHOVEL,
                ModItems.ENDERIUM_SHOVEL,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL);

        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE).add(ModItems.VIBRANIUM_HAMMER,
                ModItems.VULPUS_HAMMER,
                ModItems.ENDERIUM_HAMMER,
                ModItems.VIBRANIUM_EXCAVATOR,
                ModItems.VULPUS_EXCAVATOR,
                ModItems.ENDERIUM_EXCAVATOR,
                ModItems.VIBRANIUM_PICKAXE,
                ModItems.VULPUS_PICKAXE,
                ModItems.ENDERIUM_PICKAXE,
                ModItems.VIBRANIUM_HOE,
                ModItems.VULPUS_HOE,
                ModItems.ENDERIUM_HOE,
                ModItems.VIBRANIUM_AXE,
                ModItems.VULPUS_AXE,
                ModItems.ENDERIUM_AXE,
                ModItems.VIBRANIUM_SHOVEL,
                ModItems.VULPUS_SHOVEL,
                ModItems.ENDERIUM_SHOVEL,
                ModItems.VIBRANIUM_PAXEL,
                ModItems.VULPUS_PAXEL,
                ModItems.ENDERIUM_PAXEL);

        getOrCreateTagBuilder(ModTags.Items.VIBRANIUM_REPAIRS).add(ModItems.VIBRANIUM_INGOT);
        getOrCreateTagBuilder(ModTags.Items.VULPUS_REPAIRS).add(ModItems.VULPUS_INGOT);
        getOrCreateTagBuilder(ModTags.Items.ENDERIUM_REPAIRS).add(ModItems.ENDERIUM_INGOT);
    }
}
