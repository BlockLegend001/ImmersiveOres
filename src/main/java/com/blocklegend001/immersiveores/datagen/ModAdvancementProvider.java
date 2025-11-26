package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {

    public ModAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<Advancement> consumer) {

        // ROOT ADVANCEMENT
        Advancement rootAdvancement = Advancement.Builder.create()
                .display(ModItems.VIBRANIUM_INGOT,
                        Text.translatable("advancement.immersiveores.root.title").formatted(Formatting.LIGHT_PURPLE),
                        Text.translatable("advancement.immersiveores.root.descrption").formatted(Formatting.LIGHT_PURPLE),
                        new Identifier(ImmersiveOres.MOD_ID, "textures/item/vulpus_block.png"),
                        AdvancementFrame.TASK, true, true, false)
                .criterion("has_vibranium_ingot", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_INGOT))
                .requirements(new String[][]{{"has_vibranium_ingot"}})
                .build(consumer, ImmersiveOres.MOD_ID + ":root");

        // VIBRANIUM TOOLS
        Advancement vibraniumTools = Advancement.Builder.create()
                .parent(rootAdvancement)
                .display(ModItems.VIBRANIUM_PICKAXE,
                        Text.translatable("advancement.immersiveores.vibraniumtools.title").formatted(Formatting.LIGHT_PURPLE),
                        Text.translatable("advancement.immersiveores.vibraniumtools.descrption").formatted(Formatting.LIGHT_PURPLE),
                        null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("has_vibranium_pickaxe", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_PICKAXE))
                .criterion("has_vibranium_axe", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_AXE))
                .criterion("has_vibranium_sword", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_SWORD))
                .criterion("has_vibranium_shovel", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_SHOVEL))
                .criterion("has_vibranium_hoe", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_HOE))
                .requirements(new String[][] {
                        {"has_vibranium_pickaxe"},
                        {"has_vibranium_axe"},
                        {"has_vibranium_sword"},
                        {"has_vibranium_shovel"},
                        {"has_vibranium_hoe"}
                })
                .build(consumer, ImmersiveOres.MOD_ID + ":vibraniumtools");

        // VIBRANIUM ARMOR
        Advancement vibraniumArmor = Advancement.Builder.create()
                .parent(rootAdvancement)
                .display(ModItems.VIBRANIUM_CHESTPLATE,
                        Text.translatable("advancement.immersiveores.vibraniumarmor.title").formatted(Formatting.LIGHT_PURPLE),
                        Text.translatable("advancement.immersiveores.vibraniumarmor.descrption").formatted(Formatting.LIGHT_PURPLE),
                        null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("has_vibranium_helmet", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_HELMET))
                .criterion("has_vibranium_chestplate", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_CHESTPLATE))
                .criterion("has_vibranium_leggings", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_LEGGINGS))
                .criterion("has_vibranium_boots", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_BOOTS))
                .requirements(new String[][]{
                        {"has_vibranium_helmet"},
                        {"has_vibranium_chestplate"},
                        {"has_vibranium_leggings"},
                        {"has_vibranium_boots"}
                })
                .build(consumer, ImmersiveOres.MOD_ID + ":vibraniumarmor");

        // VIBRANIUM SPECIAL TOOLS
        Advancement vibraniumSpecialTools = Advancement.Builder.create()
                .parent(vibraniumTools)
                .display(ModItems.VIBRANIUM_PAXEL,
                        Text.translatable("advancement.immersiveores.vibraniumspecialtools.title").formatted(Formatting.LIGHT_PURPLE),
                        Text.translatable("advancement.immersiveores.vibraniumspecialtools.descrption").formatted(Formatting.LIGHT_PURPLE),
                        null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("has_vibranium_hammer", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_HAMMER))
                .criterion("has_vibranium_paxel", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_PAXEL))
                .criterion("has_vibranium_excavator", InventoryChangedCriterion.Conditions.items(ModItems.VIBRANIUM_EXCAVATOR))
                .requirements(new String[][]{
                        {"has_vibranium_hammer"},
                        {"has_vibranium_paxel"},
                        {"has_vibranium_excavator"}
                })
                .build(consumer, ImmersiveOres.MOD_ID + ":vibraniumspecialtools");

        // VULPUS INGOT
        Advancement vulpus = Advancement.Builder.create()
                .parent(vibraniumTools)
                .display(ModItems.VULPUS_INGOT,
                        Text.translatable("advancement.immersiveores.vulpus.title").formatted(Formatting.RED),
                        Text.translatable("advancement.immersiveores.vulpus.descrption").formatted(Formatting.RED),
                        null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("has_vulpus_ingot", InventoryChangedCriterion.Conditions.items(ModItems.VULPUS_INGOT))
                .requirements(new String[][]{{"has_vulpus_ingot"}})
                .build(consumer, ImmersiveOres.MOD_ID + ":vulpus");

        // VULPUS TOOLS
        Advancement vulpusTools = Advancement.Builder.create()
                .parent(vulpus)
                .display(ModItems.VULPUS_PICKAXE,
                        Text.translatable("advancement.immersiveores.vulpustools.title").formatted(Formatting.RED),
                        Text.translatable("advancement.immersiveores.vulpustools.descrption").formatted(Formatting.RED),
                        null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("has_vulpus_pickaxe", InventoryChangedCriterion.Conditions.items(ModItems.VULPUS_PICKAXE))
                .criterion("has_vulpus_axe", InventoryChangedCriterion.Conditions.items(ModItems.VULPUS_AXE))
                .criterion("has_vulpus_sword", InventoryChangedCriterion.Conditions.items(ModItems.VULPUS_SWORD))
                .criterion("has_vulpus_shovel", InventoryChangedCriterion.Conditions.items(ModItems.VULPUS_SHOVEL))
                .criterion("has_vulpus_hoe", InventoryChangedCriterion.Conditions.items(ModItems.VULPUS_HOE))
                .requirements(new String[][]{
                        {"has_vulpus_pickaxe"},
                        {"has_vulpus_axe"},
                        {"has_vulpus_sword"},
                        {"has_vulpus_shovel"},
                        {"has_vulpus_hoe"}
                })
                .build(consumer, ImmersiveOres.MOD_ID + ":vulpustools");

        // VULPUS ARMOR
        Advancement vulpusArmor = Advancement.Builder.create()
                .parent(vulpus)
                .display(ModItems.VULPUS_CHESTPLATE,
                        Text.translatable("advancement.immersiveores.vulpusarmor.title").formatted(Formatting.RED),
                        Text.translatable("advancement.immersiveores.vulpusarmor.descrption").formatted(Formatting.RED),
                        null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("has_vulpus_helmet", InventoryChangedCriterion.Conditions.items(ModItems.VULPUS_HELMET))
                .criterion("has_vulpus_chestplate", InventoryChangedCriterion.Conditions.items(ModItems.VULPUS_CHESTPLATE))
                .criterion("has_vulpus_leggings", InventoryChangedCriterion.Conditions.items(ModItems.VULPUS_LEGGINGS))
                .criterion("has_vulpus_boots", InventoryChangedCriterion.Conditions.items(ModItems.VULPUS_BOOTS))
                .requirements(new String[][]{
                        {"has_vulpus_helmet"},
                        {"has_vulpus_chestplate"},
                        {"has_vulpus_leggings"},
                        {"has_vulpus_boots"}
                })
                .build(consumer, ImmersiveOres.MOD_ID + ":vulpusarmor");

        // VULPUS SPECIAL TOOLS
        Advancement vulpusSpecialTools = Advancement.Builder.create()
                .parent(vulpusTools)
                .display(ModItems.VULPUS_PAXEL,
                        Text.translatable("advancement.immersiveores.vulpusspecialtools.title").formatted(Formatting.RED),
                        Text.translatable("advancement.immersiveores.vulpusspecialtools.descrption").formatted(Formatting.RED),
                        null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("has_vulpus_hammer", InventoryChangedCriterion.Conditions.items(ModItems.VULPUS_HAMMER))
                .criterion("has_vulpus_paxel", InventoryChangedCriterion.Conditions.items(ModItems.VULPUS_PAXEL))
                .criterion("has_vulpus_excavator", InventoryChangedCriterion.Conditions.items(ModItems.VULPUS_EXCAVATOR))
                .requirements(new String[][]{
                        {"has_vulpus_hammer"},
                        {"has_vulpus_paxel"},
                        {"has_vulpus_excavator"}
                })
                .build(consumer, ImmersiveOres.MOD_ID + ":vulpusspecialtools");

        // ENDERIUM INGOT
        Advancement enderium = Advancement.Builder.create()
                .parent(vulpusTools)
                .display(ModItems.ENDERIUM_INGOT,
                        Text.translatable("advancement.immersiveores.enderium.title").formatted(Formatting.DARK_AQUA),
                        Text.translatable("advancement.immersiveores.enderium.descrption").formatted(Formatting.DARK_AQUA),
                        null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("has_enderium_ingot", InventoryChangedCriterion.Conditions.items(ModItems.ENDERIUM_INGOT))
                .requirements(new String[][]{{"has_enderium_ingot"}})
                .build(consumer, ImmersiveOres.MOD_ID + ":enderium");

        // ENDERIUM TOOLS
        Advancement enderiumTools = Advancement.Builder.create()
                .parent(enderium)
                .display(ModItems.ENDERIUM_PICKAXE,
                        Text.translatable("advancement.immersiveores.enderiumtools.title").formatted(Formatting.DARK_AQUA),
                        Text.translatable("advancement.immersiveores.enderiumtools.descrption").formatted(Formatting.DARK_AQUA),
                        null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("has_enderium_pickaxe", InventoryChangedCriterion.Conditions.items(ModItems.ENDERIUM_PICKAXE))
                .criterion("has_enderium_axe", InventoryChangedCriterion.Conditions.items(ModItems.ENDERIUM_AXE))
                .criterion("has_enderium_sword", InventoryChangedCriterion.Conditions.items(ModItems.ENDERIUM_SWORD))
                .criterion("has_enderium_shovel", InventoryChangedCriterion.Conditions.items(ModItems.ENDERIUM_SHOVEL))
                .criterion("has_enderium_hoe", InventoryChangedCriterion.Conditions.items(ModItems.ENDERIUM_HOE))
                .requirements(new String[][]{
                        {"has_enderium_pickaxe"},
                        {"has_enderium_axe"},
                        {"has_enderium_sword"},
                        {"has_enderium_shovel"},
                        {"has_enderium_hoe"}
                })
                .build(consumer, ImmersiveOres.MOD_ID + ":enderiumtools");

        // ENDERIUM ARMOR
        Advancement enderiumArmor = Advancement.Builder.create()
                .parent(enderium)
                .display(ModItems.ENDERIUM_CHESTPLATE,
                        Text.translatable("advancement.immersiveores.enderiumarmor.title").formatted(Formatting.DARK_AQUA),
                        Text.translatable("advancement.immersiveores.enderiumarmor.descrption").formatted(Formatting.DARK_AQUA),
                        null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("has_enderium_helmet", InventoryChangedCriterion.Conditions.items(ModItems.ENDERIUM_HELMET))
                .criterion("has_enderium_chestplate", InventoryChangedCriterion.Conditions.items(ModItems.ENDERIUM_CHESTPLATE))
                .criterion("has_enderium_leggings", InventoryChangedCriterion.Conditions.items(ModItems.ENDERIUM_LEGGINGS))
                .criterion("has_enderium_boots", InventoryChangedCriterion.Conditions.items(ModItems.ENDERIUM_BOOTS))
                .requirements(new String[][]{
                        {"has_enderium_helmet"},
                        {"has_enderium_chestplate"},
                        {"has_enderium_leggings"},
                        {"has_enderium_boots"}
                })
                .build(consumer, ImmersiveOres.MOD_ID + ":enderiumarmor");

        // ENDERIUM SPECIAL TOOLS
        Advancement enderiumSpecialTools = Advancement.Builder.create()
                .parent(enderiumTools)
                .display(ModItems.ENDERIUM_PAXEL,
                        Text.translatable("advancement.immersiveores.enderiumspecialtools.title").formatted(Formatting.DARK_AQUA),
                        Text.translatable("advancement.immersiveores.enderiumspecialtools.descrption").formatted(Formatting.DARK_AQUA),
                        null,
                        AdvancementFrame.TASK, true, true, false)
                .criterion("has_enderium_hammer", InventoryChangedCriterion.Conditions.items(ModItems.ENDERIUM_HAMMER))
                .criterion("has_enderium_paxel", InventoryChangedCriterion.Conditions.items(ModItems.ENDERIUM_PAXEL))
                .criterion("has_enderium_excavator", InventoryChangedCriterion.Conditions.items(ModItems.ENDERIUM_EXCAVATOR))
                .requirements(new String[][]{
                        {"has_enderium_hammer"},
                        {"has_enderium_paxel"},
                        {"has_enderium_excavator"}
                })
                .build(consumer, ImmersiveOres.MOD_ID + ":enderiumspecialtools");
    }
}
