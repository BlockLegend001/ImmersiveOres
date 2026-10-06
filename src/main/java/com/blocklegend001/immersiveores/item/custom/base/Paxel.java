package com.blocklegend001.immersiveores.item.custom.base;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.BlockTransformer;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.BlockTransformers;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

public class Paxel extends Item {
    private static TagKey<Block> paxelMineable;

    public Paxel(ToolMaterial toolMaterial, TagKey<Block> paxelMineable, float attackDamageBaseline,
                 float attackSpeedBaseline, Properties properties) {
        super(properties.tool(toolMaterial, paxelMineable, attackDamageBaseline, attackSpeedBaseline, 1f));
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        Player player = pContext.getPlayer();

        if (playerHasShieldUseIntent(pContext)) {
            return InteractionResult.PASS;
        }

        BlockTransformer axeTransformer = level.registryAccess()
                .lookupOrThrow(Registries.BLOCK_TRANSFORMER)
                .getOrThrow(BlockTransformers.AXE)
                .value();

        InteractionResult axeResult = axeTransformer.transformBlock(pContext);

        if (axeResult.consumesAction()) {
            return axeResult;
        }

        if (pContext.getClickedFace() == Direction.DOWN) {
            return InteractionResult.PASS;
        }

        BlockState blockstate = level.getBlockState(blockpos);

        BlockTransformer shovelTransformer = level.registryAccess()
                .lookupOrThrow(Registries.BLOCK_TRANSFORMER)
                .getOrThrow(BlockTransformers.SHOVEL)
                .value();

        InteractionResult shovelResult = shovelTransformer.transformBlock(pContext);

        if (shovelResult.consumesAction()) {
            return shovelResult;
        }

        if (blockstate.getBlock() instanceof CampfireBlock
                && blockstate.getValue(CampfireBlock.LIT)) {

            if (!level.isClientSide()) {
                level.levelEvent(null, 1009, blockpos, 0);
                CampfireBlock.douse(player, level, blockpos, blockstate);
                BlockState blockstate2 = blockstate.setValue(CampfireBlock.LIT, false);
                level.setBlock(blockpos, blockstate2, 11);
                level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, blockstate2));

                if (player != null) {
                    pContext.getItemInHand().hurtAndBreak(1, player, pContext.getHand());
                }
            }

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    private static boolean playerHasShieldUseIntent(UseOnContext context) {
        Player player = context.getPlayer();
        return context.getHand().equals(InteractionHand.MAIN_HAND) && player.getOffhandItem().is(Items.SHIELD) && !player.isSecondaryUseActive();
    }
}