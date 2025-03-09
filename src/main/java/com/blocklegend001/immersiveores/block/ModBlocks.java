package com.blocklegend001.immersiveores.block;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.block.custom.enderium.EnderiumBlock;
import com.blocklegend001.immersiveores.block.custom.enderium.EnderiumOre;
import com.blocklegend001.immersiveores.block.custom.enderium.RawEnderiumBlock;
import com.blocklegend001.immersiveores.block.custom.vibranium.RawVibraniumBlock;
import com.blocklegend001.immersiveores.block.custom.vibranium.VibraniumBlock;
import com.blocklegend001.immersiveores.block.custom.vibranium.VibraniumOre;
import com.blocklegend001.immersiveores.block.custom.vulpus.RawVulpusBlock;
import com.blocklegend001.immersiveores.block.custom.vulpus.VulpusBlock;
import com.blocklegend001.immersiveores.block.custom.vulpus.VulpusOre;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(ImmersiveOres.MODID);

    public static final DeferredBlock<Block> VIBRANIUM_BLOCK = registerBlock("vibranium_block",
            () -> new VibraniumBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK)
                    .strength(6.5f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> VULPUS_BLOCK = registerBlock("vulpus_block",
            () -> new VulpusBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.VIBRANIUM_BLOCK.get())
                    .strength(6.5f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> ENDERIUM_BLOCK = registerBlock("enderium_block",
            () -> new EnderiumBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.VULPUS_BLOCK.get())
                    .strength(6.5f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> RAW_VIBRANIUM_BLOCK = registerBlock("raw_vibranium_block",
            () -> new RawVibraniumBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK)
                    .strength(6.5f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> RAW_VULPUS_BLOCK = registerBlock("raw_vulpus_block",
            () -> new RawVulpusBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.RAW_VIBRANIUM_BLOCK.get())
                    .strength(6.5f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> RAW_ENDERIUM_BLOCK = registerBlock("raw_enderium_block",
            () -> new RawEnderiumBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.RAW_VULPUS_BLOCK.get())
                    .strength(6.5f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> VIBRANIUM_ORE = registerBlock("vibranium_ore",
            () -> new VibraniumOre(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)
                    .strength(6f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> VULPUS_ORE = registerBlock("vulpus_ore",
            () -> new VulpusOre(BlockBehaviour.Properties.ofFullCopy(ModBlocks.VIBRANIUM_ORE.get())
                    .strength(6f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> ENDERIUM_ORE = registerBlock("enderium_ore",
            () -> new EnderiumOre(BlockBehaviour.Properties.ofFullCopy(ModBlocks.VULPUS_ORE.get())
                    .strength(6f).requiresCorrectToolForDrops()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}