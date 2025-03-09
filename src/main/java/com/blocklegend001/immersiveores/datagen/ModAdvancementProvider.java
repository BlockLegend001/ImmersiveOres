package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends AdvancementProvider {

    public ModAdvancementProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(packOutput, lookupProvider, existingFileHelper, List.of(new ModImmersiveOresAdvancement()));
    }

    public static class ModImmersiveOresAdvancement implements AdvancementProvider.AdvancementGenerator {

        @Override
        public void generate(HolderLookup.Provider provider, Consumer<AdvancementHolder> consumer, ExistingFileHelper existingFileHelper) {

            AdvancementHolder rootAdvancement = Advancement.Builder.advancement()
                    .display(ModItems.VIBRANIUM_INGOT.get(),
                            Component.translatable("advancement.immersiveores.root.title"), Component.translatable("advancement.immersiveores.root.descrption"),
                           ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "textures/item/vulpus_block.png"),
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_vibranium_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_INGOT.get()))
                    .save(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "root")));

            AdvancementHolder vibraniumTools = Advancement.Builder.advancement()
                    .parent(rootAdvancement)
                    .display(ModItems.VIBRANIUM_PICKAXE.get(),
                            Component.translatable("advancement.immersiveores.vibraniumtools.title"), Component.translatable("advancement.immersiveores.vibraniumtools.descrption"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_vibranium_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_PICKAXE.get()))
                    .addCriterion("has_vibranium_axe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_AXE.get()))
                    .addCriterion("has_vibranium_sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_SWORD.get()))
                    .addCriterion("has_vibranium_shovel", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_SHOVEL.get()))
                    .addCriterion("has_vibranium_hoe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_HOE.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vibraniumtools")));

            AdvancementHolder vibraniumArmor = Advancement.Builder.advancement()
                    .parent(rootAdvancement)
                    .display(ModItems.VIBRANIUM_CHESTPLATE.get(),
                            Component.translatable("advancement.immersiveores.vibraniumarmor.title"), Component.translatable("advancement.immersiveores.vibraniumarmor.descrption"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_vibranium_helmet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_HELMET.get()))
                    .addCriterion("has_vibranium_chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_CHESTPLATE.get()))
                    .addCriterion("has_vibranium_leggings", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_LEGGINGS.get()))
                    .addCriterion("has_vibranium_boots", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_BOOTS.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vibraniumarmor")));

            AdvancementHolder vibraniumSpecialTools = Advancement.Builder.advancement()
                    .parent(vibraniumTools)
                    .display(ModItems.VIBRANIUM_PAXEL.get(),
                            Component.translatable("advancement.immersiveores.vibraniumspecialtools.title"), Component.translatable("advancement.immersiveores.vibraniumspecialtools.descrption"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_vibranium_hammer", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_HAMMER.get()))
                    .addCriterion("has_vibranium_paxel", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_PAXEL.get()))
                    .addCriterion("has_vibranium_excavator", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_EXCAVATOR.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vibraniumspecialtools")));

            AdvancementHolder vulpus = Advancement.Builder.advancement()
                    .parent(vibraniumTools)
                    .display(ModItems.VULPUS_INGOT.get(),
                            Component.translatable("advancement.immersiveores.vulpus.title"), Component.translatable("advancement.immersiveores.vulpus.descrption"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_vulpus_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VULPUS_INGOT.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vulpus")));

            AdvancementHolder vulpusTools = Advancement.Builder.advancement()
                    .parent(vulpus)
                    .display(ModItems.VULPUS_PICKAXE.get(),
                            Component.translatable("advancement.immersiveores.vulpustools.title"), Component.translatable("advancement.immersiveores.vulpustools.descrption"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_vulpus_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VULPUS_PICKAXE.get()))
                    .addCriterion("has_vulpus_axe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VULPUS_AXE.get()))
                    .addCriterion("has_vulpus_sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VULPUS_SWORD.get()))
                    .addCriterion("has_vulpus_shovel", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VULPUS_SHOVEL.get()))
                    .addCriterion("has_vulpus_hoe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VULPUS_HOE.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vulpustools")));

            AdvancementHolder vulpusArmor = Advancement.Builder.advancement()
                    .parent(vulpus)
                    .display(ModItems.VULPUS_CHESTPLATE.get(),
                            Component.translatable("advancement.immersiveores.vulpusarmor.title"), Component.translatable("advancement.immersiveores.vulpusarmor.descrption"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_vulpus_helmet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VULPUS_HELMET.get()))
                    .addCriterion("has_vulpus_chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VULPUS_CHESTPLATE.get()))
                    .addCriterion("has_vulpus_leggings", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VULPUS_LEGGINGS.get()))
                    .addCriterion("has_vulpus_boots", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VULPUS_BOOTS.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vulpusarmor")));

            AdvancementHolder vulpusSpecialTools = Advancement.Builder.advancement()
                    .parent(vulpusTools)
                    .display(ModItems.VULPUS_PAXEL.get(),
                            Component.translatable("advancement.immersiveores.vulpusspecialtools.title"), Component.translatable("advancement.immersiveores.vulpusspecialtools.descrption"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_vulpus_hammer", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VULPUS_HAMMER.get()))
                    .addCriterion("has_vulpus_paxel", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VULPUS_PAXEL.get()))
                    .addCriterion("has_vulpus_excavator", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VULPUS_EXCAVATOR.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vulpusspecialtools")));

            AdvancementHolder enderium = Advancement.Builder.advancement()
                    .parent(vulpusTools)
                    .display(ModItems.ENDERIUM_INGOT.get(),
                            Component.translatable("advancement.immersiveores.enderium.title"), Component.translatable("advancement.immersiveores.enderium.descrption"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_enderium_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERIUM_INGOT.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "enderium")));

            AdvancementHolder enderiumTools = Advancement.Builder.advancement()
                    .parent(enderium)
                    .display(ModItems.ENDERIUM_PICKAXE.get(),
                            Component.translatable("advancement.immersiveores.enderiumtools.title"), Component.translatable("advancement.immersiveores.enderiumtools.descrption"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_enderium_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERIUM_PICKAXE.get()))
                    .addCriterion("has_enderium_axe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERIUM_AXE.get()))
                    .addCriterion("has_enderium_sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERIUM_SWORD.get()))
                    .addCriterion("has_enderium_shovel", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERIUM_SHOVEL.get()))
                    .addCriterion("has_enderium_hoe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERIUM_HOE.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "enderiumtools")));

            AdvancementHolder enderiumArmor = Advancement.Builder.advancement()
                    .parent(enderium)
                    .display(ModItems.ENDERIUM_CHESTPLATE.get(),
                            Component.translatable("advancement.immersiveores.enderiumarmor.title"), Component.translatable("advancement.immersiveores.enderiumarmor.descrption"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_enderium_helmet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERIUM_HELMET.get()))
                    .addCriterion("has_enderium_chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERIUM_CHESTPLATE.get()))
                    .addCriterion("has_enderium_leggings", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERIUM_LEGGINGS.get()))
                    .addCriterion("has_enderium_boots", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERIUM_BOOTS.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "enderiumarmor")));

            AdvancementHolder enderiumSpecialTools = Advancement.Builder.advancement()
                    .parent(enderiumTools)
                    .display(ModItems.ENDERIUM_PAXEL.get(),
                            Component.translatable("advancement.immersiveores.enderiumspecialtools.title"), Component.translatable("advancement.immersiveores.enderiumspecialtools.descrption"),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_enderium_hammer", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERIUM_HAMMER.get()))
                    .addCriterion("has_enderium_paxel", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERIUM_PAXEL.get()))
                    .addCriterion("has_enderium_excavator", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERIUM_EXCAVATOR.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(consumer, String.valueOf(ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "enderiumspecialtools")));
        }
    }
}
