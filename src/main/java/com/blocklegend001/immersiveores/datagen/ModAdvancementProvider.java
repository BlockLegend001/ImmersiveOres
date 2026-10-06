package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.predicates.ItemPredicate;
import net.minecraft.advancements.triggers.Criterion;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import java.util.List;

public class ModAdvancementProvider extends AdvancementProvider {

    public ModAdvancementProvider() {
        super(List.of(ModImmersiveOresAdvancements::new));
    }

    public static class ModImmersiveOresAdvancements extends AdvancementSubProvider {

        private HolderGetter<Item> items;

        public ModImmersiveOresAdvancements(BootstrapContext<Advancement> output) {
            super(output);
        }

        private Criterion<InventoryChangeTrigger.TriggerInstance> has(ItemLike item) {
            return InventoryChangeTrigger.TriggerInstance.hasItems(
                    ItemPredicate.Builder.item().of(items, item));
        }

        private static Identifier id(String path) {
            return Identifier.fromNamespaceAndPath(ImmersiveOres.MODID, path);
        }

        @Override
        public void generate() {
            items = output.lookup(Registries.ITEM);

            // ---------- VIBRANIUM ----------
            AdvancementHolder rootAdvancement = Advancement.Builder.advancement()
                    .rootDisplay(ModItems.VIBRANIUM_INGOT.get(),
                            Component.translatable("advancement.immersiveores.root.title").withStyle(ChatFormatting.LIGHT_PURPLE),
                            Component.translatable("advancement.immersiveores.root.descrption").withStyle(ChatFormatting.LIGHT_PURPLE),
                            Identifier.fromNamespaceAndPath("minecraft", "gui/advancements/backgrounds/stone"),
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_vibranium_ingot", has(ModItems.VIBRANIUM_INGOT.get()))
                    .save(output, id("root").toString());

            AdvancementHolder vibraniumTools = Advancement.Builder.advancement()
                    .parent(rootAdvancement)
                    .display(ModItems.VIBRANIUM_PICKAXE.get(),
                            Component.translatable("advancement.immersiveores.vibraniumtools.title").withStyle(ChatFormatting.LIGHT_PURPLE),
                            Component.translatable("advancement.immersiveores.vibraniumtools.descrption").withStyle(ChatFormatting.LIGHT_PURPLE),
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_vibranium_pickaxe", has(ModItems.VIBRANIUM_PICKAXE.get()))
                    .addCriterion("has_vibranium_axe", has(ModItems.VIBRANIUM_AXE.get()))
                    .addCriterion("has_vibranium_sword", has(ModItems.VIBRANIUM_SWORD.get()))
                    .addCriterion("has_vibranium_shovel", has(ModItems.VIBRANIUM_SHOVEL.get()))
                    .addCriterion("has_vibranium_hoe", has(ModItems.VIBRANIUM_HOE.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(output, id("vibraniumtools").toString());

            AdvancementHolder vibraniumArmor = Advancement.Builder.advancement()
                    .parent(rootAdvancement)
                    .display(ModItems.VIBRANIUM_CHESTPLATE.get(),
                            Component.translatable("advancement.immersiveores.vibraniumarmor.title").withStyle(ChatFormatting.LIGHT_PURPLE),
                            Component.translatable("advancement.immersiveores.vibraniumarmor.descrption").withStyle(ChatFormatting.LIGHT_PURPLE),
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_vibranium_helmet", has(ModItems.VIBRANIUM_HELMET.get()))
                    .addCriterion("has_vibranium_chestplate", has(ModItems.VIBRANIUM_CHESTPLATE.get()))
                    .addCriterion("has_vibranium_leggings", has(ModItems.VIBRANIUM_LEGGINGS.get()))
                    .addCriterion("has_vibranium_boots", has(ModItems.VIBRANIUM_BOOTS.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(output, id("vibraniumarmor").toString());

            AdvancementHolder vibraniumSpecialTools = Advancement.Builder.advancement()
                    .parent(vibraniumTools)
                    .display(ModItems.VIBRANIUM_PAXEL.get(),
                            Component.translatable("advancement.immersiveores.vibraniumspecialtools.title").withStyle(ChatFormatting.LIGHT_PURPLE),
                            Component.translatable("advancement.immersiveores.vibraniumspecialtools.descrption").withStyle(ChatFormatting.LIGHT_PURPLE),
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_vibranium_hammer", has(ModItems.VIBRANIUM_HAMMER.get()))
                    .addCriterion("has_vibranium_paxel", has(ModItems.VIBRANIUM_PAXEL.get()))
                    .addCriterion("has_vibranium_excavator", has(ModItems.VIBRANIUM_EXCAVATOR.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(output, id("vibraniumspecialtools").toString());

            // ---------- VULPUS ----------
            AdvancementHolder vulpus = Advancement.Builder.advancement()
                    .parent(vibraniumTools)
                    .display(ModItems.VULPUS_INGOT.get(),
                            Component.translatable("advancement.immersiveores.vulpus.title").withStyle(ChatFormatting.RED),
                            Component.translatable("advancement.immersiveores.vulpus.descrption").withStyle(ChatFormatting.RED),
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_vulpus_ingot", has(ModItems.VULPUS_INGOT.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(output, id("vulpus").toString());

            AdvancementHolder vulpusTools = Advancement.Builder.advancement()
                    .parent(vulpus)
                    .display(ModItems.VULPUS_PICKAXE.get(),
                            Component.translatable("advancement.immersiveores.vulpustools.title").withStyle(ChatFormatting.RED),
                            Component.translatable("advancement.immersiveores.vulpustools.descrption").withStyle(ChatFormatting.RED),
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_vulpus_pickaxe", has(ModItems.VULPUS_PICKAXE.get()))
                    .addCriterion("has_vulpus_axe", has(ModItems.VULPUS_AXE.get()))
                    .addCriterion("has_vulpus_sword", has(ModItems.VULPUS_SWORD.get()))
                    .addCriterion("has_vulpus_shovel", has(ModItems.VULPUS_SHOVEL.get()))
                    .addCriterion("has_vulpus_hoe", has(ModItems.VULPUS_HOE.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(output, id("vulpustools").toString());

            AdvancementHolder vulpusArmor = Advancement.Builder.advancement()
                    .parent(vulpus)
                    .display(ModItems.VULPUS_CHESTPLATE.get(),
                            Component.translatable("advancement.immersiveores.vulpusarmor.title").withStyle(ChatFormatting.RED),
                            Component.translatable("advancement.immersiveores.vulpusarmor.descrption").withStyle(ChatFormatting.RED),
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_vulpus_helmet", has(ModItems.VULPUS_HELMET.get()))
                    .addCriterion("has_vulpus_chestplate", has(ModItems.VULPUS_CHESTPLATE.get()))
                    .addCriterion("has_vulpus_leggings", has(ModItems.VULPUS_LEGGINGS.get()))
                    .addCriterion("has_vulpus_boots", has(ModItems.VULPUS_BOOTS.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(output, id("vulpusarmor").toString());

            AdvancementHolder vulpusSpecialTools = Advancement.Builder.advancement()
                    .parent(vulpusTools)
                    .display(ModItems.VULPUS_PAXEL.get(),
                            Component.translatable("advancement.immersiveores.vulpusspecialtools.title").withStyle(ChatFormatting.RED),
                            Component.translatable("advancement.immersiveores.vulpusspecialtools.descrption").withStyle(ChatFormatting.RED),
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_vulpus_hammer", has(ModItems.VULPUS_HAMMER.get()))
                    .addCriterion("has_vulpus_paxel", has(ModItems.VULPUS_PAXEL.get()))
                    .addCriterion("has_vulpus_excavator", has(ModItems.VULPUS_EXCAVATOR.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(output, id("vulpusspecialtools").toString());

            // ---------- ENDERIUM ----------
            AdvancementHolder enderium = Advancement.Builder.advancement()
                    .parent(vulpusTools)
                    .display(ModItems.ENDERIUM_INGOT.get(),
                            Component.translatable("advancement.immersiveores.enderium.title").withStyle(ChatFormatting.DARK_AQUA),
                            Component.translatable("advancement.immersiveores.enderium.descrption").withStyle(ChatFormatting.DARK_AQUA),
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_enderium_ingot", has(ModItems.ENDERIUM_INGOT.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(output, id("enderium").toString());

            AdvancementHolder enderiumTools = Advancement.Builder.advancement()
                    .parent(enderium)
                    .display(ModItems.ENDERIUM_PICKAXE.get(),
                            Component.translatable("advancement.immersiveores.enderiumtools.title").withStyle(ChatFormatting.DARK_AQUA),
                            Component.translatable("advancement.immersiveores.enderiumtools.descrption").withStyle(ChatFormatting.DARK_AQUA),
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_enderium_pickaxe", has(ModItems.ENDERIUM_PICKAXE.get()))
                    .addCriterion("has_enderium_axe", has(ModItems.ENDERIUM_AXE.get()))
                    .addCriterion("has_enderium_sword", has(ModItems.ENDERIUM_SWORD.get()))
                    .addCriterion("has_enderium_shovel", has(ModItems.ENDERIUM_SHOVEL.get()))
                    .addCriterion("has_enderium_hoe", has(ModItems.ENDERIUM_HOE.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(output, id("enderiumtools").toString());

            AdvancementHolder enderiumArmor = Advancement.Builder.advancement()
                    .parent(enderium)
                    .display(ModItems.ENDERIUM_CHESTPLATE.get(),
                            Component.translatable("advancement.immersiveores.enderiumarmor.title").withStyle(ChatFormatting.DARK_AQUA),
                            Component.translatable("advancement.immersiveores.enderiumarmor.descrption").withStyle(ChatFormatting.DARK_AQUA),
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_enderium_helmet", has(ModItems.ENDERIUM_HELMET.get()))
                    .addCriterion("has_enderium_chestplate", has(ModItems.ENDERIUM_CHESTPLATE.get()))
                    .addCriterion("has_enderium_leggings", has(ModItems.ENDERIUM_LEGGINGS.get()))
                    .addCriterion("has_enderium_boots", has(ModItems.ENDERIUM_BOOTS.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(output, id("enderiumarmor").toString());

            AdvancementHolder enderiumSpecialTools = Advancement.Builder.advancement()
                    .parent(enderiumTools)
                    .display(ModItems.ENDERIUM_PAXEL.get(),
                            Component.translatable("advancement.immersiveores.enderiumspecialtools.title").withStyle(ChatFormatting.DARK_AQUA),
                            Component.translatable("advancement.immersiveores.enderiumspecialtools.descrption").withStyle(ChatFormatting.DARK_AQUA),
                            AdvancementType.TASK, true, true, false)
                    .addCriterion("has_enderium_hammer", has(ModItems.ENDERIUM_HAMMER.get()))
                    .addCriterion("has_enderium_paxel", has(ModItems.ENDERIUM_PAXEL.get()))
                    .addCriterion("has_enderium_excavator", has(ModItems.ENDERIUM_EXCAVATOR.get()))
                    .requirements(AdvancementRequirements.Strategy.AND)
                    .save(output, id("enderiumspecialtools").toString());
        }
    }
}