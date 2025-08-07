package com.blocklegend001.immersiveores.tooltip;

import net.fabricmc.fabric.api.block.v1.FabricBlock;

/**
 * Interface for blocks that have a tooltip.
 * This method is used in the {@link TooltipBlockItem} class.
 */
public interface TooltipBlock extends TooltipItem, FabricBlock {
}