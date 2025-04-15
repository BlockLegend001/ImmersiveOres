package com.blocklegend001.immersiveores.blocks;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.blocks.custom.enderium.EnderiumBlock;
import com.blocklegend001.immersiveores.blocks.custom.enderium.EnderiumOre;
import com.blocklegend001.immersiveores.blocks.custom.enderium.RawEnderiumBlock;
import com.blocklegend001.immersiveores.blocks.custom.vibranium.RawVibraniumBlock;
import com.blocklegend001.immersiveores.blocks.custom.vibranium.VibraniumBlock;
import com.blocklegend001.immersiveores.blocks.custom.vibranium.VibraniumOre;
import com.blocklegend001.immersiveores.blocks.custom.vulpus.RawVulpusBlock;
import com.blocklegend001.immersiveores.blocks.custom.vulpus.VulpusBlock;
import com.blocklegend001.immersiveores.blocks.custom.vulpus.VulpusOre;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ImmersiveOres.MODID);

    public static final RegistryObject<Block> VIBRANIUM_BLOCK = registerBlock("vibranium_block",
            () -> new VibraniumBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK)
                    .strength(6.5f).requiresCorrectToolForDrops()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vibranium_block")))));

    public static final RegistryObject<Block> VULPUS_BLOCK = registerBlock("vulpus_block",
            () -> new VulpusBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.VIBRANIUM_BLOCK.get())
                    .strength(6.5f).requiresCorrectToolForDrops()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vulpus_block")))));

    public static final RegistryObject<Block> ENDERIUM_BLOCK = registerBlock("enderium_block",
            () -> new EnderiumBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.VULPUS_BLOCK.get())
                    .strength(6.5f).requiresCorrectToolForDrops()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "enderium_block")))));

    public static final RegistryObject<Block> RAW_VIBRANIUM_BLOCK = registerBlock("raw_vibranium_block",
            () -> new RawVibraniumBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK)
                    .strength(6.5f).requiresCorrectToolForDrops()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "raw_vibranium_block")))));

    public static final RegistryObject<Block> RAW_VULPUS_BLOCK = registerBlock("raw_vulpus_block",
            () -> new RawVulpusBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.RAW_VIBRANIUM_BLOCK.get())
                    .strength(6.5f).requiresCorrectToolForDrops()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "raw_vulpus_block")))));

    public static final RegistryObject<Block> RAW_ENDERIUM_BLOCK = registerBlock("raw_enderium_block",
            () -> new RawEnderiumBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.RAW_VULPUS_BLOCK.get())
                    .strength(6.5f).requiresCorrectToolForDrops()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "raw_enderium_block")))));

    public static final RegistryObject<Block> VIBRANIUM_ORE = registerBlock("vibranium_ore",
            () -> new VibraniumOre(BlockBehaviour.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS)
                    .strength(6f).requiresCorrectToolForDrops()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vibranium_ore")))));

    public static final RegistryObject<Block> VULPUS_ORE = registerBlock("vulpus_ore",
            () -> new VulpusOre(BlockBehaviour.Properties.ofFullCopy(ModBlocks.VIBRANIUM_ORE.get())
                    .strength(6f).requiresCorrectToolForDrops()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "vulpus_ore")))));

    public static final RegistryObject<Block> ENDERIUM_ORE = registerBlock("enderium_ore",
            () -> new EnderiumOre(BlockBehaviour.Properties.ofFullCopy(ModBlocks.VULPUS_ORE.get())
                    .strength(6f).requiresCorrectToolForDrops()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, "enderium_ore")))));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(ImmersiveOres.MODID, name)))));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
