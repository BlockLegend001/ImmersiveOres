package com.blocklegend001.immersiveores.imp.client.compat;

import com.blocklegend001.immersiveores.item.ModItems;
import com.blocklegend001.immersiveores.util.ModTags;
import mcp.mobius.waila.api.*;
import mcp.mobius.waila.api.component.ItemComponent;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class WthitCompatibility implements IWailaPlugin {

    @Override
    public void register(IRegistrar registrar) {
        registrar.addComponent(ToolRequirementComponent.INSTANCE, TooltipPosition.BODY, Block.class);
    }

    public static class ToolRequirementComponent implements IBlockComponentProvider {
        public static final ToolRequirementComponent INSTANCE = new ToolRequirementComponent();

        @Override
        public void appendBody(ITooltip tooltip, IBlockAccessor accessor, IPluginConfig config) {
            BlockState state = accessor.getBlockState();
            Player player = accessor.getPlayer();

            ItemStack requiredTool = ItemStack.EMPTY;
            String toolName = "";

            if (state.is(ModTags.Blocks.NEEDS_VIBRANIUM_TOOL)) {
                requiredTool = new ItemStack(ModItems.VIBRANIUM_PICKAXE.get());
                toolName = "Vibranium Tool";
            } else if (state.is(ModTags.Blocks.NEEDS_VULPUS_TOOL)) {
                requiredTool = new ItemStack(ModItems.VULPUS_PICKAXE.get());
                toolName = "Vulpus Tool";
            } else if (state.is(ModTags.Blocks.NEEDS_ENDERIUM_TOOL)) {
                requiredTool = new ItemStack(ModItems.ENDERIUM_PICKAXE.get());
                toolName = "Enderium Tool";
            } else if (state.is(ModTags.Blocks.NEEDS_NETHERITE_TOOL)) {
                requiredTool = new ItemStack(Items.NETHERITE_PICKAXE);
                toolName = "Netherite Tool";
            }

            if (!requiredTool.isEmpty()) {
                boolean canHarvest = player != null && canHarvestWithTag(player.getMainHandItem(), state);
                String symbol = canHarvest ? ChatFormatting.GREEN + "✔ " : ChatFormatting.RED + "✖ ";

                tooltip.addLine(new ItemComponent(requiredTool));
                tooltip.addLine(Component.literal(symbol + "Requires " + toolName).withStyle(ChatFormatting.GRAY));
            }
        }

        private static boolean canHarvestWithTag(ItemStack held, BlockState state) {
            if (held.isEmpty()) return false;

            if (held.is(Items.NETHERITE_PICKAXE)) {
                return state.is(ModTags.Blocks.NEEDS_NETHERITE_TOOL);
            }

            if (held.is(ModItems.VIBRANIUM_PICKAXE.get()) ||
                    held.is(ModItems.VIBRANIUM_HAMMER.get()) ||
                    held.is(ModItems.VIBRANIUM_PAXEL.get())) {

                return state.is(ModTags.Blocks.NEEDS_NETHERITE_TOOL) ||
                        state.is(ModTags.Blocks.NEEDS_VIBRANIUM_TOOL);
            }

            if (held.is(ModItems.VULPUS_PICKAXE.get()) ||
                    held.is(ModItems.VULPUS_HAMMER.get()) ||
                    held.is(ModItems.VULPUS_PAXEL.get())) {
                return true;
            }

            if (held.is(ModItems.ENDERIUM_PICKAXE.get()) ||
                    held.is(ModItems.ENDERIUM_HAMMER.get()) ||
                    held.is(ModItems.ENDERIUM_PAXEL.get())) {
                return true;
            }

            return false;
        }
    }
}
