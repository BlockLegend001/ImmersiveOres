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

    public static final ResourceKey<Block> VIBRANIUM_BLOCK_KEY = blockKey("vibranium_block");
    public static final Block VIBRANIUM_BLOCK = registerBlock(VIBRANIUM_BLOCK_KEY,
            properties -> new VibraniumBlock(properties.strength(6.5f, 1200.0F).requiresCorrectToolForDrops()));

    public static final ResourceKey<Block> VULPUS_BLOCK_KEY = blockKey("vulpus_block");
    public static final Block VULPUS_BLOCK = registerBlock(VULPUS_BLOCK_KEY,
            properties -> new VulpusBlock(properties.strength(6.5f, 1200.0F).requiresCorrectToolForDrops()));

    public static final ResourceKey<Block> ENDERIUM_BLOCK_KEY = blockKey("enderium_block");
    public static final Block ENDERIUM_BLOCK = registerBlock(ENDERIUM_BLOCK_KEY,
            properties -> new EnderiumBlock(properties.strength(6.5f, 1200.0F).requiresCorrectToolForDrops()));

    public static final ResourceKey<Block> RAW_VIBRANIUM_BLOCK_KEY = blockKey("raw_vibranium_block");
    public static final Block RAW_VIBRANIUM_BLOCK = registerBlock(RAW_VIBRANIUM_BLOCK_KEY,
            properties -> new RawVibraniumBlock(properties.strength(6.5f, 1200.0F).requiresCorrectToolForDrops()));

    public static final ResourceKey<Block> RAW_VULPUS_BLOCK_KEY = blockKey("raw_vulpus_block");
    public static final Block RAW_VULPUS_BLOCK = registerBlock(RAW_VULPUS_BLOCK_KEY,
            properties -> new RawVulpusBlock(properties.strength(6.5f, 1200.0F).requiresCorrectToolForDrops()));

    public static final ResourceKey<Block> RAW_ENDERIUM_BLOCK_KEY = blockKey("raw_enderium_block");
    public static final Block RAW_ENDERIUM_BLOCK = registerBlock(RAW_ENDERIUM_BLOCK_KEY,
            properties -> new RawEnderiumBlock(properties.strength(6.5f, 1200.0F).requiresCorrectToolForDrops()));

    public static final ResourceKey<Block> VIBRANIUM_ORE_KEY = blockKey("vibranium_ore");
    public static final Block VIBRANIUM_ORE = registerBlock(VIBRANIUM_ORE_KEY,
            properties -> new VibraniumOre(properties.strength(6f, 1200.0F).requiresCorrectToolForDrops()));

    public static final ResourceKey<Block> VULPUS_ORE_KEY = blockKey("vulpus_ore");
    public static final Block VULPUS_ORE = registerBlock(VULPUS_ORE_KEY,
            properties -> new VulpusOre(properties.strength(6f, 1200.0F).requiresCorrectToolForDrops()));

    public static final ResourceKey<Block> ENDERIUM_ORE_KEY = blockKey("enderium_ore");
    public static final Block ENDERIUM_ORE = registerBlock(ENDERIUM_ORE_KEY,
            properties -> new EnderiumOre(properties.strength(6f, 1200.0F).requiresCorrectToolForDrops()));


    private static ResourceKey<Block> blockKey(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(ImmersiveOres.MOD_ID, name));
    }

    private static Block registerBlock(ResourceKey<Block> key, Function<BlockBehaviour.Properties, Block> function) {
        Block toRegister = function.apply(BlockBehaviour.Properties.of().setId(key));
        registerBlockItem(key, toRegister);
        return Registry.register(BuiltInRegistries.BLOCK, key, toRegister);
    }

    private static void registerBlockItem(ResourceKey<Block> blockKey, Block block) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, blockKey.identifier());

        Item.Properties settings = new Item.Properties()
                .fireResistant()
                .setId(itemKey)
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

        Registry.register(BuiltInRegistries.ITEM, itemKey, item);
    }


    public static void registerModBlocks() {
        ImmersiveOres.LOGGER.info("Registering Mod Blocks for " + ImmersiveOres.MOD_ID);
    }
}