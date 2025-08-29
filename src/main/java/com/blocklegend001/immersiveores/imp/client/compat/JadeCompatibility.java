package com.blocklegend001.immersiveores.imp.client.compat;

import com.blocklegend001.immersiveores.block.ModBlocks;
import com.blocklegend001.immersiveores.item.ModItems;
import com.blocklegend001.immersiveores.util.ModTags;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec2;
import snownee.jade.api.*;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.ui.IElement;
import snownee.jade.api.ui.IElementHelper;

import java.util.List;

@WailaPlugin
public class JadeCompatibility implements IWailaPlugin {

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(ToolRequirementComponent.INSTANCE, Block.class);
    }

    private static class ToolRequirementComponent implements IBlockComponentProvider {
        public static final ToolRequirementComponent INSTANCE = new ToolRequirementComponent();

        @Override
        public void appendTooltip(ITooltip tooltip, BlockAccessor accessor, IPluginConfig config) {
            BlockState state = accessor.getBlockState();
            IElementHelper elements = IElementHelper.get();
            ItemStack pickaxe = null;
            Player player = accessor.getPlayer();

            if (state.is(ModTags.Blocks.NEEDS_VIBRANIUM_TOOL)) {
                pickaxe = new ItemStack(ModItems.VIBRANIUM_PICKAXE.get());
            } else if (state.is(ModTags.Blocks.NEEDS_VULPUS_TOOL)) {
                pickaxe = new ItemStack(ModItems.VULPUS_PICKAXE.get());
            } else if (state.is(ModTags.Blocks.NEEDS_ENDERIUM_TOOL)) {
                pickaxe = new ItemStack(ModItems.ENDERIUM_PICKAXE.get());
            }

            if (pickaxe != null) {
                boolean canHarvest = player != null && canHarvestWithTag(player.getMainHandItem(), state);

                IElement icon = elements.item(pickaxe, 0.5f).size(new Vec2(10, 10));
                icon.message(null);

                IElement check = elements.text(
                        canHarvest
                                ? Component.literal("✔").withStyle(ChatFormatting.GREEN)
                                : Component.literal("✖").withStyle(ChatFormatting.RED)
                );

                tooltip.add(List.of(icon, check));
            }
        }

        @Override
        public ResourceLocation getUid() {
            return ResourceLocation.fromNamespaceAndPath("immersiveores", "tool_requirement");
        }

        private static boolean canHarvestWithTag(ItemStack held, BlockState state) {
            if (held.isEmpty()) return false;

            if (held.is(Items.NETHERITE_PICKAXE)) {
                return state.is(ModTags.Blocks.NEEDS_NETHERITE_TOOL);
            }

            if (held.is(ModItems.VIBRANIUM_PICKAXE) ||
                    held.is(ModItems.VIBRANIUM_HAMMER) ||
                    held.is(ModItems.VIBRANIUM_PAXEL)) {

                return state.is(ModTags.Blocks.NEEDS_NETHERITE_TOOL) ||
                        state.is(ModTags.Blocks.NEEDS_VIBRANIUM_TOOL);
            }

            if (held.is(ModItems.VULPUS_PICKAXE) ||
                    held.is(ModItems.VULPUS_HAMMER) ||
                    held.is(ModItems.VULPUS_PAXEL)) {
                return true;
            }

            if (held.is(ModItems.ENDERIUM_PICKAXE) ||
                    held.is(ModItems.ENDERIUM_HAMMER) ||
                    held.is(ModItems.ENDERIUM_PAXEL)) {
                return true;
            }

            return false;
        }
    }
}
