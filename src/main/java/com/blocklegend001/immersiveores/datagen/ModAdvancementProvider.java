package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.predicates.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import static net.minecraft.advancements.triggers.InventoryChangeTrigger.TriggerInstance.hasItems;

public class ModAdvancementProvider extends AdvancementProvider {

    protected ModAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup, List.of(new ImmersiveOresAdvancements()));
    }

    public static class ImmersiveOresAdvancements implements AdvancementSubProvider {
        @Override
        public void generate(HolderLookup.Provider registryLookup, Consumer<AdvancementHolder> consumer) {
            var items = registryLookup.lookupOrThrow(Registries.ITEM);
            var blocks = registryLookup.lookupOrThrow(Registries.BLOCK);
            
            AdvancementHolder rootAdvancement = Advancement.Builder.advancement()
                    .display(ModItems.VIBRANIUM_INGOT,
                            Component.translatable("advancement.immersiveores.root.title").withStyle(ChatFormatting.LIGHT_PURPLE), Component.translatable("advancement.immersiveores.root.descrption").withStyle(ChatFormatting.LIGHT_PURPLE),
                            Identifier.fromNamespaceAndPath(ImmersiveOres.MOD_ID, "textures/item/vulpus_block.png"),
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_vibranium_ingot", hasItems(ItemPredicate.Builder.item().of(items, ModItems.VIBRANIUM_INGOT)))
                    .save(consumer, String.valueOf(Identifier.fromNamespaceAndPath(ImmersiveOres.MOD_ID, "root")));

            AdvancementHolder vibraniumTools = Advancement.Builder.advancement()
                    .parent(rootAdvancement)
                    .display(ModItems.VIBRANIUM_PICKAXE,
                            Component.translatable("advancement.immersiveores.vibraniumtools.title").withStyle(ChatFormatting.LIGHT_PURPLE), Component.translatable("advancement.immersiveores.vibraniumtools.descrption").withStyle(ChatFormatting.LIGHT_PURPLE),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_vibranium_pickaxe", hasItems(ItemPredicate.Builder.item().of(items, ModItems.VIBRANIUM_PICKAXE)))
                    .addCriterion("has_vibranium_axe", hasItems(ItemPredicate.Builder.item().of(items, ModItems.VIBRANIUM_AXE)))
                    .addCriterion("has_vibranium_sword", hasItems(ItemPredicate.Builder.item().of(items, ModItems.VIBRANIUM_SWORD)))
                    .addCriterion("has_vibranium_shovel", hasItems(ItemPredicate.Builder.item().of(items, ModItems.VIBRANIUM_SHOVEL)))
                    .addCriterion("has_vibranium_hoe", hasItems(ItemPredicate.Builder.item().of(items, ModItems.VIBRANIUM_HOE)))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(consumer, String.valueOf(Identifier.fromNamespaceAndPath(ImmersiveOres.MOD_ID, "vibraniumtools")));

            AdvancementHolder vibraniumArmor = Advancement.Builder.advancement()
                    .parent(rootAdvancement)
                    .display(ModItems.VIBRANIUM_CHESTPLATE,
                            Component.translatable("advancement.immersiveores.vibraniumarmor.title").withStyle(ChatFormatting.LIGHT_PURPLE), Component.translatable("advancement.immersiveores.vibraniumarmor.descrption").withStyle(ChatFormatting.LIGHT_PURPLE),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_vibranium_helmet", hasItems(ItemPredicate.Builder.item().of(items, ModItems.VIBRANIUM_HELMET)))
                    .addCriterion("has_vibranium_chestplate", hasItems(ItemPredicate.Builder.item().of(items, ModItems.VIBRANIUM_CHESTPLATE)))
                    .addCriterion("has_vibranium_leggings", hasItems(ItemPredicate.Builder.item().of(items, ModItems.VIBRANIUM_LEGGINGS)))
                    .addCriterion("has_vibranium_boots", hasItems(ItemPredicate.Builder.item().of(items, ModItems.VIBRANIUM_BOOTS)))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(consumer, String.valueOf(Identifier.fromNamespaceAndPath(ImmersiveOres.MOD_ID, "vibraniumarmor")));

            AdvancementHolder vibraniumSpecialTools = Advancement.Builder.advancement()
                    .parent(vibraniumTools)
                    .display(ModItems.VIBRANIUM_PAXEL,
                            Component.translatable("advancement.immersiveores.vibraniumspecialtools.title").withStyle(ChatFormatting.LIGHT_PURPLE), Component.translatable("advancement.immersiveores.vibraniumspecialtools.descrption").withStyle(ChatFormatting.LIGHT_PURPLE),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_vibranium_hammer", hasItems(ItemPredicate.Builder.item().of(items, ModItems.VIBRANIUM_HAMMER)))
                    .addCriterion("has_vibranium_paxel", hasItems(ItemPredicate.Builder.item().of(items, ModItems.VIBRANIUM_PAXEL)))
                    .addCriterion("has_vibranium_excavator", hasItems(ItemPredicate.Builder.item().of(items, ModItems.VIBRANIUM_EXCAVATOR)))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(consumer, String.valueOf(Identifier.fromNamespaceAndPath(ImmersiveOres.MOD_ID, "vibraniumspecialtools")));

            AdvancementHolder vulpus = Advancement.Builder.advancement()
                    .parent(vibraniumTools)
                    .display(ModItems.VULPUS_INGOT,
                            Component.translatable("advancement.immersiveores.vulpus.title").withStyle(ChatFormatting.RED), Component.translatable("advancement.immersiveores.vulpus.descrption").withStyle(ChatFormatting.RED),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_vulpus_ingot", hasItems(ItemPredicate.Builder.item().of(items, ModItems.VULPUS_INGOT)))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(consumer, String.valueOf(Identifier.fromNamespaceAndPath(ImmersiveOres.MOD_ID, "vulpus")));

            AdvancementHolder vulpusTools = Advancement.Builder.advancement()
                    .parent(vulpus)
                    .display(ModItems.VULPUS_PICKAXE,
                            Component.translatable("advancement.immersiveores.vulpustools.title").withStyle(ChatFormatting.RED), Component.translatable("advancement.immersiveores.vulpustools.descrption").withStyle(ChatFormatting.RED),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_vulpus_pickaxe", hasItems(ItemPredicate.Builder.item().of(items, ModItems.VULPUS_PICKAXE)))
                    .addCriterion("has_vulpus_axe", hasItems(ItemPredicate.Builder.item().of(items, ModItems.VULPUS_AXE)))
                    .addCriterion("has_vulpus_sword", hasItems(ItemPredicate.Builder.item().of(items, ModItems.VULPUS_SWORD)))
                    .addCriterion("has_vulpus_shovel", hasItems(ItemPredicate.Builder.item().of(items, ModItems.VULPUS_SHOVEL)))
                    .addCriterion("has_vulpus_hoe", hasItems(ItemPredicate.Builder.item().of(items, ModItems.VULPUS_HOE)))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(consumer, String.valueOf(Identifier.fromNamespaceAndPath(ImmersiveOres.MOD_ID, "vulpustools")));

            AdvancementHolder vulpusArmor = Advancement.Builder.advancement()
                    .parent(vulpus)
                    .display(ModItems.VULPUS_CHESTPLATE,
                            Component.translatable("advancement.immersiveores.vulpusarmor.title").withStyle(ChatFormatting.RED), Component.translatable("advancement.immersiveores.vulpusarmor.descrption").withStyle(ChatFormatting.RED),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_vulpus_helmet", hasItems(ItemPredicate.Builder.item().of(items, ModItems.VULPUS_HELMET)))
                    .addCriterion("has_vulpus_chestplate", hasItems(ItemPredicate.Builder.item().of(items, ModItems.VULPUS_CHESTPLATE)))
                    .addCriterion("has_vulpus_leggings", hasItems(ItemPredicate.Builder.item().of(items, ModItems.VULPUS_LEGGINGS)))
                    .addCriterion("has_vulpus_boots", hasItems(ItemPredicate.Builder.item().of(items, ModItems.VULPUS_BOOTS)))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(consumer, String.valueOf(Identifier.fromNamespaceAndPath(ImmersiveOres.MOD_ID, "vulpusarmor")));

            AdvancementHolder vulpusSpecialTools = Advancement.Builder.advancement()
                    .parent(vulpusTools)
                    .display(ModItems.VULPUS_PAXEL,
                            Component.translatable("advancement.immersiveores.vulpusspecialtools.title").withStyle(ChatFormatting.RED), Component.translatable("advancement.immersiveores.vulpusspecialtools.descrption").withStyle(ChatFormatting.RED),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_vulpus_hammer", hasItems(ItemPredicate.Builder.item().of(items, ModItems.VULPUS_HAMMER)))
                    .addCriterion("has_vulpus_paxel", hasItems(ItemPredicate.Builder.item().of(items, ModItems.VULPUS_PAXEL)))
                    .addCriterion("has_vulpus_excavator", hasItems(ItemPredicate.Builder.item().of(items, ModItems.VULPUS_EXCAVATOR)))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(consumer, String.valueOf(Identifier.fromNamespaceAndPath(ImmersiveOres.MOD_ID, "vulpusspecialtools")));

            AdvancementHolder enderium = Advancement.Builder.advancement()
                    .parent(vulpusTools)
                    .display(ModItems.ENDERIUM_INGOT,
                            Component.translatable("advancement.immersiveores.enderium.title").withStyle(ChatFormatting.DARK_AQUA), Component.translatable("advancement.immersiveores.enderium.descrption").withStyle(ChatFormatting.DARK_AQUA),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_enderium_ingot", hasItems(ItemPredicate.Builder.item().of(items, ModItems.ENDERIUM_INGOT)))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(consumer, String.valueOf(Identifier.fromNamespaceAndPath(ImmersiveOres.MOD_ID, "enderium")));

            AdvancementHolder enderiumTools = Advancement.Builder.advancement()
                    .parent(enderium)
                    .display(ModItems.ENDERIUM_PICKAXE,
                            Component.translatable("advancement.immersiveores.enderiumtools.title").withStyle(ChatFormatting.DARK_AQUA), Component.translatable("advancement.immersiveores.enderiumtools.descrption").withStyle(ChatFormatting.DARK_AQUA),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_enderium_pickaxe", hasItems(ItemPredicate.Builder.item().of(items, ModItems.ENDERIUM_PICKAXE)))
                    .addCriterion("has_enderium_axe", hasItems(ItemPredicate.Builder.item().of(items, ModItems.ENDERIUM_AXE)))
                    .addCriterion("has_enderium_sword", hasItems(ItemPredicate.Builder.item().of(items, ModItems.ENDERIUM_SWORD)))
                    .addCriterion("has_enderium_shovel", hasItems(ItemPredicate.Builder.item().of(items, ModItems.ENDERIUM_SHOVEL)))
                    .addCriterion("has_enderium_hoe", hasItems(ItemPredicate.Builder.item().of(items, ModItems.ENDERIUM_HOE)))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(consumer, String.valueOf(Identifier.fromNamespaceAndPath(ImmersiveOres.MOD_ID, "enderiumtools")));

            AdvancementHolder enderiumArmor = Advancement.Builder.advancement()
                    .parent(enderium)
                    .display(ModItems.ENDERIUM_CHESTPLATE,
                            Component.translatable("advancement.immersiveores.enderiumarmor.title").withStyle(ChatFormatting.DARK_AQUA), Component.translatable("advancement.immersiveores.enderiumarmor.descrption").withStyle(ChatFormatting.DARK_AQUA),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_enderium_helmet", hasItems(ItemPredicate.Builder.item().of(items, ModItems.ENDERIUM_HELMET)))
                    .addCriterion("has_enderium_chestplate", hasItems(ItemPredicate.Builder.item().of(items, ModItems.ENDERIUM_CHESTPLATE)))
                    .addCriterion("has_enderium_leggings", hasItems(ItemPredicate.Builder.item().of(items, ModItems.ENDERIUM_LEGGINGS)))
                    .addCriterion("has_enderium_boots", hasItems(ItemPredicate.Builder.item().of(items, ModItems.ENDERIUM_BOOTS)))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(consumer, String.valueOf(Identifier.fromNamespaceAndPath(ImmersiveOres.MOD_ID, "enderiumarmor")));

            AdvancementHolder enderiumSpecialTools = Advancement.Builder.advancement()
                    .parent(enderiumTools)
                    .display(ModItems.ENDERIUM_PAXEL,
                            Component.translatable("advancement.immersiveores.enderiumspecialtools.title").withStyle(ChatFormatting.DARK_AQUA), Component.translatable("advancement.immersiveores.enderiumspecialtools.descrption").withStyle(ChatFormatting.DARK_AQUA),
                            null,
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_enderium_hammer", hasItems(ItemPredicate.Builder.item().of(items, ModItems.ENDERIUM_HAMMER)))
                    .addCriterion("has_enderium_paxel", hasItems(ItemPredicate.Builder.item().of(items, ModItems.ENDERIUM_PAXEL)))
                    .addCriterion("has_enderium_excavator", hasItems(ItemPredicate.Builder.item().of(items, ModItems.ENDERIUM_EXCAVATOR)))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(consumer, String.valueOf(Identifier.fromNamespaceAndPath(ImmersiveOres.MOD_ID, "enderiumspecialtools")));
        }
    }
}
