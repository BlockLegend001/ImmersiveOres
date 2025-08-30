package com.blocklegend001.immersiveores.imp.client.compat;

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
import snownee.jade.api.*;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.ui.BoxStyle;
import snownee.jade.api.ui.JadeUI;
import snownee.jade.impl.ui.ItemStackElement;

@WailaPlugin
public class JadeCompatibility implements IWailaPlugin {

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(ToolRequirementComponent.INSTANCE, Block.class);
    }

    static final class ToolRequirementComponent implements IBlockComponentProvider {
        static final ToolRequirementComponent INSTANCE = new ToolRequirementComponent();
        private static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath("immersiveores", "tool_requirement");

        @Override
        public void appendTooltip(ITooltip tooltip, BlockAccessor accessor, IPluginConfig config) {
            BlockState state = accessor.getBlockState();
            Player player = accessor.getPlayer();

            ItemStack pickaxe = pickaxeFor(state);
            if (pickaxe.isEmpty()) return;

            boolean canHarvest = player != null && canHarvestWithTag(player.getMainHandItem(), state);

            ITooltip row = JadeUI.tooltip();
            row.add(ItemStackElement.of(pickaxe));
            row.add(Component.literal(canHarvest ? "✔" : "✖")
                    .withStyle(canHarvest ? ChatFormatting.GREEN : ChatFormatting.RED));

            tooltip.add(JadeUI.box(row, BoxStyle.DEFAULT_NESTED_BOX));
        }

        @Override
        public ResourceLocation getUid() {
            return UID;
        }

        private static ItemStack pickaxeFor(BlockState state) {
            if (state.is(ModTags.Blocks.NEEDS_VIBRANIUM_TOOL)) return new ItemStack(ModItems.VIBRANIUM_PICKAXE.get());
            if (state.is(ModTags.Blocks.NEEDS_VULPUS_TOOL))    return new ItemStack(ModItems.VULPUS_PICKAXE.get());
            if (state.is(ModTags.Blocks.NEEDS_ENDERIUM_TOOL))  return new ItemStack(ModItems.ENDERIUM_PICKAXE.get());
            if (state.is(ModTags.Blocks.NEEDS_NETHERITE_TOOL)) return new ItemStack(Items.NETHERITE_PICKAXE);
            return ItemStack.EMPTY;
        }

        private static boolean canHarvestWithTag(ItemStack held, BlockState state) {
            if (held.isEmpty()) return false;

            if (held.is(Items.NETHERITE_PICKAXE)) {
                return state.is(ModTags.Blocks.NEEDS_NETHERITE_TOOL);
            }

            if (held.is(ModItems.VIBRANIUM_PICKAXE) ||
                    held.is(ModItems.VIBRANIUM_HAMMER) ||
                    held.is(ModItems.VIBRANIUM_PAXEL)) {
                return state.is(ModTags.Blocks.NEEDS_NETHERITE_TOOL)
                        || state.is(ModTags.Blocks.NEEDS_VIBRANIUM_TOOL);
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
