package com.blocklegend001.immersiveores.imp.client.compat;

import com.blocklegend001.immersiveores.item.ModItems;
import com.blocklegend001.immersiveores.util.ModTags;
import mcp.mobius.waila.api.*;
import mcp.mobius.waila.api.component.ItemComponent;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

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
            PlayerEntity player = accessor.getPlayer();

            ItemStack requiredTool = null;
            String toolName = "";

            if (state.isIn(ModTags.Blocks.NEEDS_VIBRANIUM_TOOL)) {
                requiredTool = new ItemStack(ModItems.VIBRANIUM_PICKAXE);
                toolName = "Vibranium Tool";
            } else if (state.isIn(ModTags.Blocks.NEEDS_VULPUS_TOOL)) {
                requiredTool = new ItemStack(ModItems.VULPUS_PICKAXE);
                toolName = "Vulpus Tool";
            } else if (state.isIn(ModTags.Blocks.NEEDS_ENDERIUM_TOOL)) {
                requiredTool = new ItemStack(ModItems.ENDERIUM_PICKAXE);
                toolName = "Enderium Tool";
            } else if (state.isIn(ModTags.Blocks.NEEDS_NETHERITE_TOOL)) {
                requiredTool = new ItemStack(Items.NETHERITE_PICKAXE);
                toolName = "Netherite Tool";
            }

            if (requiredTool != null) {
                boolean canHarvest = player != null && canHarvestWithTag(player.getMainHandStack(), state);
                String symbol = canHarvest ? Formatting.GREEN + "✔ " : Formatting.RED + "✖ ";

                tooltip.addLine(new ItemComponent(requiredTool));
                tooltip.addLine(Text.literal(symbol + "Requires " + toolName).formatted(Formatting.GRAY));
            }
        }
    }

    private static boolean canHarvestWithTag(ItemStack held, BlockState state) {
        if (held.isEmpty()) return false;

        if (held.isOf(Items.NETHERITE_PICKAXE)) {
            return state.isIn(ModTags.Blocks.NEEDS_NETHERITE_TOOL);
        }

        if (held.isOf(ModItems.VIBRANIUM_PICKAXE) ||
                held.isOf(ModItems.VIBRANIUM_HAMMER) ||
                held.isOf(ModItems.VIBRANIUM_PAXEL)) {

            return state.isIn(ModTags.Blocks.NEEDS_NETHERITE_TOOL) ||
                    state.isIn(ModTags.Blocks.NEEDS_VIBRANIUM_TOOL);
        }

        if (held.isOf(ModItems.VULPUS_PICKAXE) ||
                held.isOf(ModItems.VULPUS_HAMMER) ||
                held.isOf(ModItems.VULPUS_PAXEL)) {
            return true;
        }

        if (held.isOf(ModItems.ENDERIUM_PICKAXE) ||
                held.isOf(ModItems.ENDERIUM_HAMMER) ||
                held.isOf(ModItems.ENDERIUM_PAXEL)) {
            return true;
        }

        return false;
    }
}
