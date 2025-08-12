package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {

    protected ModAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {

        AdvancementEntry rootAdvancement = Advancement.Builder.create()
                .display(ModItems.VIBRANIUM_INGOT,
                        Text.translatable("advancement.immersiveores.root.title").formatted(Formatting.LIGHT_PURPLE), Text.translatable("advancement.immersiveores.root.descrption").formatted(Formatting.LIGHT_PURPLE),
                        Identifier.of(ImmersiveOres.MOD_ID, "textures/item/vulpus_block.png"),
                        AdvancementFrame.TASK, true, true, false)
                .criterion("has_vibranium_ingot", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_INGOT))
                .build(consumer, String.valueOf(Identifier.of(ImmersiveOres.MOD_ID, "root")));

        AdvancementEntry vibraniumTools = Advancement.Builder.create()
                .parent(rootAdvancement)
                .display(ModItems.VIBRANIUM_PICKAXE,
                        Text.translatable("advancement.immersiveores.vibraniumtools.title").formatted(Formatting.LIGHT_PURPLE), Text.translatable("advancement.immersiveores.vibraniumtools.descrption").formatted(Formatting.LIGHT_PURPLE),
                        null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("has_vibranium_pickaxe", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_PICKAXE))
                .criterion("has_vibranium_axe", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_AXE))
                .criterion("has_vibranium_sword", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_SWORD))
                .criterion("has_vibranium_shovel", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_SHOVEL))
                .criterion("has_vibranium_hoe", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_HOE))
                .criteriaMerger(AdvancementRequirements.CriterionMerger.AND)
                .build(consumer, String.valueOf(Identifier.of(ImmersiveOres.MOD_ID, "vibraniumtools")));

        AdvancementEntry vibraniumArmor = Advancement.Builder.create()
                .parent(rootAdvancement)
                .display(ModItems.VIBRANIUM_CHESTPLATE,
                        Text.translatable("advancement.immersiveores.vibraniumarmor.title").formatted(Formatting.LIGHT_PURPLE), Text.translatable("advancement.immersiveores.vibraniumarmor.descrption").formatted(Formatting.LIGHT_PURPLE),
                        null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("has_vibranium_helmet", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_HELMET))
                .criterion("has_vibranium_chestplate", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_CHESTPLATE))
                .criterion("has_vibranium_leggings", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_LEGGINGS))
                .criterion("has_vibranium_boots", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_BOOTS))
                .criteriaMerger(AdvancementRequirements.CriterionMerger.AND)
                .build(consumer, String.valueOf(Identifier.of(ImmersiveOres.MOD_ID, "vibraniumarmor")));

        AdvancementEntry vibraniumSpecialTools = Advancement.Builder.create()
                .parent(vibraniumTools)
                .display(ModItems.VIBRANIUM_PAXEL,
                        Text.translatable("advancement.immersiveores.vibraniumspecialtools.title").formatted(Formatting.LIGHT_PURPLE), Text.translatable("advancement.immersiveores.vibraniumspecialtools.descrption").formatted(Formatting.LIGHT_PURPLE),
                        null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("has_vibranium_hammer", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_HAMMER))
                .criterion("has_vibranium_paxel", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_PAXEL))
                .criterion("has_vibranium_excavator", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_EXCAVATOR))
                .criteriaMerger(AdvancementRequirements.CriterionMerger.AND)
                .build(consumer, String.valueOf(Identifier.of(ImmersiveOres.MOD_ID, "vibraniumspecialtools")));

        AdvancementEntry vulpus = Advancement.Builder.create()
                .parent(vibraniumTools)
                .display(ModItems.VULPUS_INGOT,
                        Text.translatable("advancement.immersiveores.vulpus.title").formatted(Formatting.RED), Text.translatable("advancement.immersiveores.vulpus.descrption").formatted(Formatting.RED),
                        null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("has_vulpus_ingot", InventoryChangedCriterion.Conditions.items(ModItems.VULPUS_INGOT))
                .criteriaMerger(AdvancementRequirements.CriterionMerger.AND)
                .build(consumer, String.valueOf(Identifier.of(ImmersiveOres.MOD_ID, "vulpus")));

        AdvancementEntry vulpusTools = Advancement.Builder.create()
                .parent(vulpus)
                .display(ModItems.VULPUS_PICKAXE,
                        Text.translatable("advancement.immersiveores.vulpustools.title").formatted(Formatting.RED), Text.translatable("advancement.immersiveores.vulpustools.descrption").formatted(Formatting.RED),
                        null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("has_vulpus_pickaxe", InventoryChangedCriterion.Conditions.items(ModItems.VULPUS_PICKAXE))
                .criterion("has_vulpus_axe", InventoryChangedCriterion.Conditions.items(ModItems.VULPUS_AXE))
                .criterion("has_vulpus_sword", InventoryChangedCriterion.Conditions.items(ModItems.VULPUS_SWORD))
                .criterion("has_vulpus_shovel", InventoryChangedCriterion.Conditions.items(ModItems.VULPUS_SHOVEL))
                .criterion("has_vulpus_hoe", InventoryChangedCriterion.Conditions.items(ModItems.VULPUS_HOE))
                .criteriaMerger(AdvancementRequirements.CriterionMerger.AND)
                .build(consumer, String.valueOf(Identifier.of(ImmersiveOres.MOD_ID, "vulpustools")));

        AdvancementEntry vulpusArmor = Advancement.Builder.create()
                .parent(vulpus)
                .display(ModItems.VULPUS_CHESTPLATE,
                        Text.translatable("advancement.immersiveores.vulpusarmor.title").formatted(Formatting.RED), Text.translatable("advancement.immersiveores.vulpusarmor.descrption").formatted(Formatting.RED),
                        null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("has_vulpus_helmet", InventoryChangedCriterion.Conditions.items(ModItems.VULPUS_HELMET))
                .criterion("has_vulpus_chestplate", InventoryChangedCriterion.Conditions.items(ModItems.VULPUS_CHESTPLATE))
                .criterion("has_vulpus_leggings", InventoryChangedCriterion.Conditions.items(ModItems.VULPUS_LEGGINGS))
                .criterion("has_vulpus_boots", InventoryChangedCriterion.Conditions.items(ModItems.VULPUS_BOOTS))
                .criteriaMerger(AdvancementRequirements.CriterionMerger.AND)
                .build(consumer, String.valueOf(Identifier.of(ImmersiveOres.MOD_ID, "vulpusarmor")));

        AdvancementEntry vulpusSpecialTools = Advancement.Builder.create()
                .parent(vulpusTools)
                .display(ModItems.VULPUS_PAXEL,
                        Text.translatable("advancement.immersiveores.vulpusspecialtools.title").formatted(Formatting.RED), Text.translatable("advancement.immersiveores.vulpusspecialtools.descrption").formatted(Formatting.RED),
                        null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("has_vulpus_hammer", InventoryChangedCriterion.Conditions.items(ModItems.VULPUS_HAMMER))
                .criterion("has_vulpus_paxel", InventoryChangedCriterion.Conditions.items(ModItems.VULPUS_PAXEL))
                .criterion("has_vulpus_excavator", InventoryChangedCriterion.Conditions.items(ModItems.VULPUS_EXCAVATOR))
                .criteriaMerger(AdvancementRequirements.CriterionMerger.AND)
                .build(consumer, String.valueOf(Identifier.of(ImmersiveOres.MOD_ID, "vulpusspecialtools")));

        AdvancementEntry enderium = Advancement.Builder.create()
                .parent(vulpusTools)
                .display(ModItems.ENDERIUM_INGOT,
                        Text.translatable("advancement.immersiveores.enderium.title").formatted(Formatting.DARK_AQUA), Text.translatable("advancement.immersiveores.enderium.descrption").formatted(Formatting.DARK_AQUA),
                        null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("has_enderium_ingot", InventoryChangedCriterion.Conditions.items(ModItems.ENDERIUM_INGOT))
                .criteriaMerger(AdvancementRequirements.CriterionMerger.AND)
                .build(consumer, String.valueOf(Identifier.of(ImmersiveOres.MOD_ID, "enderium")));

        AdvancementEntry enderiumTools = Advancement.Builder.create()
                .parent(enderium)
                .display(ModItems.ENDERIUM_PICKAXE,
                        Text.translatable("advancement.immersiveores.enderiumtools.title").formatted(Formatting.DARK_AQUA), Text.translatable("advancement.immersiveores.enderiumtools.descrption").formatted(Formatting.DARK_AQUA),
                        null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("has_enderium_pickaxe", InventoryChangedCriterion.Conditions.items(ModItems.ENDERIUM_PICKAXE))
                .criterion("has_enderium_axe", InventoryChangedCriterion.Conditions.items(ModItems.ENDERIUM_AXE))
                .criterion("has_enderium_sword", InventoryChangedCriterion.Conditions.items(ModItems.ENDERIUM_SWORD))
                .criterion("has_enderium_shovel", InventoryChangedCriterion.Conditions.items(ModItems.ENDERIUM_SHOVEL))
                .criterion("has_enderium_hoe", InventoryChangedCriterion.Conditions.items(ModItems.ENDERIUM_HOE))
                .criteriaMerger(AdvancementRequirements.CriterionMerger.AND)
                .build(consumer, String.valueOf(Identifier.of(ImmersiveOres.MOD_ID, "enderiumtools")));

        AdvancementEntry enderiumArmor = Advancement.Builder.create()
                .parent(enderium)
                .display(ModItems.ENDERIUM_CHESTPLATE,
                        Text.translatable("advancement.immersiveores.enderiumarmor.title").formatted(Formatting.DARK_AQUA), Text.translatable("advancement.immersiveores.enderiumarmor.descrption").formatted(Formatting.DARK_AQUA),
                        null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("has_enderium_helmet", InventoryChangedCriterion.Conditions.items(ModItems.ENDERIUM_HELMET))
                .criterion("has_enderium_chestplate", InventoryChangedCriterion.Conditions.items(ModItems.ENDERIUM_CHESTPLATE))
                .criterion("has_enderium_leggings", InventoryChangedCriterion.Conditions.items(ModItems.ENDERIUM_LEGGINGS))
                .criterion("has_enderium_boots", InventoryChangedCriterion.Conditions.items(ModItems.ENDERIUM_BOOTS))
                .criteriaMerger(AdvancementRequirements.CriterionMerger.AND)
                .build(consumer, String.valueOf(Identifier.of(ImmersiveOres.MOD_ID, "enderiumarmor")));

        AdvancementEntry enderiumSpecialTools = Advancement.Builder.create()
                .parent(enderiumTools)
                .display(ModItems.ENDERIUM_PAXEL,
                        Text.translatable("advancement.immersiveores.enderiumspecialtools.title").formatted(Formatting.DARK_AQUA), Text.translatable("advancement.immersiveores.enderiumspecialtools.descrption").formatted(Formatting.DARK_AQUA),
                        null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("has_enderium_hammer", InventoryChangedCriterion.Conditions.items(ModItems.ENDERIUM_HAMMER))
                .criterion("has_enderium_paxel", InventoryChangedCriterion.Conditions.items(ModItems.ENDERIUM_PAXEL))
                .criterion("has_enderium_excavator", InventoryChangedCriterion.Conditions.items(ModItems.ENDERIUM_EXCAVATOR))
                .criteriaMerger(AdvancementRequirements.CriterionMerger.AND)
                .build(consumer, String.valueOf(Identifier.of(ImmersiveOres.MOD_ID, "enderiumspecialtools")));
    }
}
