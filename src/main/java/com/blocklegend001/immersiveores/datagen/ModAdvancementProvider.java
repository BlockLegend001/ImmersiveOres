package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;

import java.util.function.Consumer;

public class ModAdvancementProvider implements ForgeAdvancementProvider.AdvancementGenerator {
    @Override
    public void generate(HolderLookup.Provider provider, Consumer<Advancement> consumer, ExistingFileHelper existingFileHelper) {

        Advancement rootAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.VIBRANIUM_INGOT.get()),
                        Component.translatable("advancement.immersiveores.root.title"), Component.translatable("advancement.immersiveores.root.descrption"),
                        new ResourceLocation(ImmersiveOres.MODID, "textures/item/vulpus_block.png"), FrameType.TASK,
                        true, true, false))
                .addCriterion("has_vibranium_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_INGOT.get()))
                .save(consumer, new ResourceLocation(ImmersiveOres.MODID, "root"), existingFileHelper);

        Advancement vibraniumTools = Advancement.Builder.advancement()
                .parent(rootAdvancement)
                .display(new DisplayInfo(new ItemStack(ModItems.VIBRANIUM_PICKAXE.get()),
                        Component.translatable("advancement.immersiveores.vibraniumtools.title"), Component.translatable("advancement.immersiveores.vibraniumtools.descrption"),
                        null,
                        FrameType.TASK, true, true, false))
                .addCriterion("has_vibranium_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_PICKAXE.get()))
                .addCriterion("has_vibranium_axe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_AXE.get()))
                .addCriterion("has_vibranium_sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_SWORD.get()))
                .addCriterion("has_vibranium_shovel", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_SHOVEL.get()))
                .addCriterion("has_vibranium_hoe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_HOE.get()))
                .requirements(RequirementsStrategy.AND)
                .save(consumer, new ResourceLocation(ImmersiveOres.MODID, "vibraniumtools"), existingFileHelper);

        Advancement vibraniumArmor = Advancement.Builder.advancement()
                .parent(rootAdvancement)
                .display(new DisplayInfo(new ItemStack(ModItems.VIBRANIUM_CHESTPLATE.get()),
                        Component.translatable("advancement.immersiveores.vibraniumarmor.title"), Component.translatable("advancement.immersiveores.vibraniumarmor.descrption"),
                        null,
                        FrameType.TASK, true, true, false))
                .addCriterion("has_vibranium_helmet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_HELMET.get()))
                .addCriterion("has_vibranium_chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_CHESTPLATE.get()))
                .addCriterion("has_vibranium_leggings", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_LEGGINGS.get()))
                .addCriterion("has_vibranium_boots", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_BOOTS.get()))
                .requirements(RequirementsStrategy.AND)
                .save(consumer, new ResourceLocation(ImmersiveOres.MODID, "vibraniumarmor"), existingFileHelper);

        Advancement vibraniumSpecialTools = Advancement.Builder.advancement()
                .parent(vibraniumTools)
                .display(new DisplayInfo(new ItemStack(ModItems.VIBRANIUM_PAXEL.get()),
                        Component.translatable("advancement.immersiveores.vibraniumspecialtools.title"), Component.translatable("advancement.immersiveores.vibraniumspecialtools.descrption"),
                        null,
                        FrameType.TASK, true, true, false))
                .addCriterion("has_vibranium_hammer", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_HAMMER.get()))
                .addCriterion("has_vibranium_paxel", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_PAXEL.get()))
                .addCriterion("has_vibranium_excavator", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VIBRANIUM_EXCAVATOR.get()))
                .requirements(RequirementsStrategy.AND)
                .save(consumer, new ResourceLocation(ImmersiveOres.MODID, "vibraniumspecialtools"), existingFileHelper);

        Advancement vulpus = Advancement.Builder.advancement()
                .parent(vibraniumTools)
                .display(new DisplayInfo(new ItemStack(ModItems.VULPUS_INGOT.get()),
                        Component.translatable("advancement.immersiveores.vulpus.title"), Component.translatable("advancement.immersiveores.vulpus.descrption"),
                        null,
                        FrameType.TASK, true, true, false))
                .addCriterion("has_vulpus_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VULPUS_INGOT.get()))
                .requirements(RequirementsStrategy.AND)
                .save(consumer, new ResourceLocation(ImmersiveOres.MODID, "vulpus"), existingFileHelper);

        Advancement vulpusTools = Advancement.Builder.advancement()
                .parent(vulpus)
                .display(new DisplayInfo(new ItemStack(ModItems.VULPUS_PICKAXE.get()),
                        Component.translatable("advancement.immersiveores.vulpustools.title"), Component.translatable("advancement.immersiveores.vulpustools.descrption"),
                        null,
                        FrameType.TASK, true, true, false))
                .addCriterion("has_vulpus_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VULPUS_PICKAXE.get()))
                .addCriterion("has_vulpus_axe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VULPUS_AXE.get()))
                .addCriterion("has_vulpus_sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VULPUS_SWORD.get()))
                .addCriterion("has_vulpus_shovel", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VULPUS_SHOVEL.get()))
                .addCriterion("has_vulpus_hoe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VULPUS_HOE.get()))
                .requirements(RequirementsStrategy.AND)
                .save(consumer, new ResourceLocation(ImmersiveOres.MODID, "vulpustools"), existingFileHelper);

        Advancement vulpusArmor = Advancement.Builder.advancement()
                .parent(vulpus)
                .display(new DisplayInfo(new ItemStack(ModItems.VULPUS_CHESTPLATE.get()),
                        Component.translatable("advancement.immersiveores.vulpusarmor.title"), Component.translatable("advancement.immersiveores.vulpusarmor.descrption"),
                        null,
                        FrameType.TASK, true, true, false))
                .addCriterion("has_vulpus_helmet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VULPUS_HELMET.get()))
                .addCriterion("has_vulpus_chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VULPUS_CHESTPLATE.get()))
                .addCriterion("has_vulpus_leggings", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VULPUS_LEGGINGS.get()))
                .addCriterion("has_vulpus_boots", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VULPUS_BOOTS.get()))
                .requirements(RequirementsStrategy.AND)
                .save(consumer, new ResourceLocation(ImmersiveOres.MODID, "vulpusarmor"), existingFileHelper);

        Advancement vulpusSpecialTools = Advancement.Builder.advancement()
                .parent(vulpusTools)
                .display(new DisplayInfo(new ItemStack(ModItems.VULPUS_PAXEL.get()),
                        Component.translatable("advancement.immersiveores.vulpusspecialtools.title"), Component.translatable("advancement.immersiveores.vulpusspecialtools.descrption"),
                        null,
                        FrameType.TASK, true, true, false))
                .addCriterion("has_vulpus_hammer", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VULPUS_HAMMER.get()))
                .addCriterion("has_vulpus_paxel", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VULPUS_PAXEL.get()))
                .addCriterion("has_vulpus_excavator", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.VULPUS_EXCAVATOR.get()))
                .requirements(RequirementsStrategy.AND)
                .save(consumer, new ResourceLocation(ImmersiveOres.MODID, "vulpusspecialtools"), existingFileHelper);

        Advancement enderium = Advancement.Builder.advancement()
                .parent(vulpusTools)
                .display(new DisplayInfo(new ItemStack(ModItems.ENDERIUM_INGOT.get()),
                        Component.translatable("advancement.immersiveores.enderium.title"), Component.translatable("advancement.immersiveores.enderium.descrption"),
                        null,
                        FrameType.TASK, true, true, false))
                .addCriterion("has_enderium_ingot", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERIUM_INGOT.get()))
                .requirements(RequirementsStrategy.AND)
                .save(consumer, new ResourceLocation(ImmersiveOres.MODID, "enderium"), existingFileHelper);

        Advancement enderiumTools = Advancement.Builder.advancement()
                .parent(enderium)
                .display(new DisplayInfo(new ItemStack(ModItems.ENDERIUM_PICKAXE.get()),
                        Component.translatable("advancement.immersiveores.enderiumtools.title"), Component.translatable("advancement.immersiveores.enderiumtools.descrption"),
                        null,
                        FrameType.TASK, true, true, false))
                .addCriterion("has_enderium_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERIUM_PICKAXE.get()))
                .addCriterion("has_enderium_axe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERIUM_AXE.get()))
                .addCriterion("has_enderium_sword", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERIUM_SWORD.get()))
                .addCriterion("has_enderium_shovel", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERIUM_SHOVEL.get()))
                .addCriterion("has_enderium_hoe", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERIUM_HOE.get()))
                .requirements(RequirementsStrategy.AND)
                .save(consumer, new ResourceLocation(ImmersiveOres.MODID, "enderiumtools"), existingFileHelper);

        Advancement enderiumArmor = Advancement.Builder.advancement()
                .parent(enderium)
                .display(new DisplayInfo(new ItemStack(ModItems.ENDERIUM_CHESTPLATE.get()),
                        Component.translatable("advancement.immersiveores.enderiumarmor.title"), Component.translatable("advancement.immersiveores.enderiumarmor.descrption"),
                        null,
                        FrameType.TASK, true, true, false))
                .addCriterion("has_enderium_helmet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERIUM_HELMET.get()))
                .addCriterion("has_enderium_chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERIUM_CHESTPLATE.get()))
                .addCriterion("has_enderium_leggings", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERIUM_LEGGINGS.get()))
                .addCriterion("has_enderium_boots", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERIUM_BOOTS.get()))
                .requirements(RequirementsStrategy.AND)
                .save(consumer, new ResourceLocation(ImmersiveOres.MODID, "enderiumarmor"), existingFileHelper);

        Advancement enderiumSpecialTools = Advancement.Builder.advancement()
                .parent(enderiumTools)
                .display(new DisplayInfo(new ItemStack(ModItems.ENDERIUM_PAXEL.get()),
                        Component.translatable("advancement.immersiveores.enderiumspecialtools.title"), Component.translatable("advancement.immersiveores.enderiumspecialtools.descrption"),
                        null,
                        FrameType.TASK, true, true, false))
                .addCriterion("has_enderium_hammer", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERIUM_HAMMER.get()))
                .addCriterion("has_enderium_paxel", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERIUM_PAXEL.get()))
                .addCriterion("has_enderium_excavator", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.ENDERIUM_EXCAVATOR.get()))
                .requirements(RequirementsStrategy.AND)
                .save(consumer, new ResourceLocation(ImmersiveOres.MODID, "enderiumspecialtools"), existingFileHelper);
    }
}
