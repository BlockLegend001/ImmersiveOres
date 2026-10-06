package com.blocklegend001.immersiveores.item.custom.base;

import com.blocklegend001.immersiveores.item.ModToolTiers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.BlockTransformers;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class Paxel extends Item {
    private static Set<TagKey<Block>> paxelMineable = null;

    public static Set<TagKey<Block>> getPaxelMineable() {
        if (paxelMineable == null) {
            paxelMineable = Set.of(
                    BlockTags.MINEABLE_WITH_PICKAXE,
                    BlockTags.MINEABLE_WITH_SHOVEL,
                    BlockTags.MINEABLE_WITH_AXE
            );
        }
        return paxelMineable;
    }

    public Paxel(ModToolTiers material, float attackDamage, float attackSpeed, Properties settings) {
        super(material.applyPaxelProperties(settings, getPaxelMineable(), attackDamage, attackSpeed));
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {
        if (state.getDestroySpeed(level, pos) != 0.0F) {
            entity.getMainHandItem().hurtAndBreak(1, entity, InteractionHand.MAIN_HAND);
        }
        return super.mineBlock(stack, level, state, pos, entity);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (playerHasShieldUseIntent(context)) return InteractionResult.PASS;

        Level world = context.getLevel();

        InteractionResult result = world.registryAccess()
                .getOrThrow(BlockTransformers.AXE)
                .value()
                .transformBlock(context);
        if (result.consumesAction()) return result;

        if (context.getClickedFace() == Direction.DOWN) return InteractionResult.PASS;

        result = world.registryAccess()
                .getOrThrow(BlockTransformers.SHOVEL)
                .value()
                .transformBlock(context);
        if (result.consumesAction()) return result;

        BlockPos pos = context.getClickedPos();
        BlockState state = world.getBlockState(pos);
        if (state.getBlock() instanceof CampfireBlock && state.getValue(CampfireBlock.LIT)) {
            Player player = context.getPlayer();
            if (!world.isClientSide()) {
                world.playSound(null, pos, SoundEvents.AXE_SCRAPE.value(), SoundSource.BLOCKS, 1.0F, 1.0F);
                world.setBlock(pos, state.setValue(CampfireBlock.LIT, false), 11);
                if (player != null) context.getItemInHand().hurtAndBreak(1, player, InteractionHand.MAIN_HAND);
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    private static boolean playerHasShieldUseIntent(UseOnContext context) {
        Player player = context.getPlayer();
        return player != null
                && context.getHand().equals(InteractionHand.MAIN_HAND)
                && player.getOffhandItem().is(Items.SHIELD)
                && !player.isSecondaryUseActive();
    }
}