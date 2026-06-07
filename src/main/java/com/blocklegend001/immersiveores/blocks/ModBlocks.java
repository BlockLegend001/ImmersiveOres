package com.blocklegend001.immersiveores.blocks;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.blocks.custom.enderium.*;
import com.blocklegend001.immersiveores.blocks.custom.vibranium.*;
import com.blocklegend001.immersiveores.blocks.custom.vulpus.*;
import com.blocklegend001.immersiveores.util.tooltip.TooltipBlock;
import com.blocklegend001.immersiveores.util.tooltip.TooltipBlockItem;
import com.blocklegend001.immersiveores.util.color.ColoredBlock;
import com.blocklegend001.immersiveores.util.color.ColoredBlockItem;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class ModBlocks {

    public static final Block VIBRANIUM_BLOCK = registerBlock("vibranium_block",
            properties -> new VibraniumBlock(properties.strength(6.5f, 1200.0F).requiresCorrectToolForDrops()));

    public static final Block VULPUS_BLOCK = registerBlock("vulpus_block",
            properties -> new VulpusBlock(properties.strength(6.5f, 1200.0F).requiresCorrectToolForDrops()));

    public static final Block ENDERIUM_BLOCK = registerBlock("enderium_block",
            properties -> new EnderiumBlock(properties.strength(6.5f, 1200.0F).requiresCorrectToolForDrops()));

    public static final Block RAW_VIBRANIUM_BLOCK = registerBlock("raw_vibranium_block",
            properties -> new RawVibraniumBlock(properties.strength(6.5f, 1200.0F).requiresCorrectToolForDrops()));

    public static final Block RAW_VULPUS_BLOCK = registerBlock("raw_vulpus_block",
            properties -> new RawVulpusBlock(properties.strength(6.5f, 1200.0F).requiresCorrectToolForDrops()));

    public static final Block RAW_ENDERIUM_BLOCK = registerBlock("raw_enderium_block",
            properties -> new RawEnderiumBlock(properties.strength(6.5f, 1200.0F).requiresCorrectToolForDrops()));

    public static final Block VIBRANIUM_ORE = registerBlock("vibranium_ore",
            properties -> new VibraniumOre(properties.strength(6f, 1200.0F).requiresCorrectToolForDrops()));

    public static final Block VULPUS_ORE = registerBlock("vulpus_ore",
            properties -> new VulpusOre(properties.strength(6f, 1200.0F).requiresCorrectToolForDrops()));

    public static final Block ENDERIUM_ORE = registerBlock("enderium_ore",
            properties -> new EnderiumOre(properties.strength(6f, 1200.0F).requiresCorrectToolForDrops()));

    private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(ImmersiveOres.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(ImmersiveOres.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Item.Properties settings = new Item.Properties()
                .fireResistant()
                .setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(ImmersiveOres.MOD_ID, name)))
                .useBlockDescriptionPrefix();

        Item item;

        if (block instanceof ColoredBlock colored && block instanceof TooltipBlock tooltip) {
            item = new TooltipBlockItem(tooltip, settings) {
                @Override
                public Component getName(ItemStack stack) {
                    return super.getName(stack).copy()
                            .setStyle(Style.EMPTY.withColor(colored.getColor()));
                }
            };
        } else if (block instanceof ColoredBlock colored) {
            item = new ColoredBlockItem(block, settings, colored.getColor());
        } else if (block instanceof TooltipBlock tooltip) {
            item = new TooltipBlockItem(tooltip, settings);
        } else {
            item = new BlockItem(block, settings);
        }

        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(ImmersiveOres.MOD_ID, name), item);
    }


    public static void registerModBlocks() {
        ImmersiveOres.LOGGER.info("Registering Mod Blocks for " + ImmersiveOres.MOD_ID);
    }
}