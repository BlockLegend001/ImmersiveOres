package com.blocklegend001.immersiveores.item.custom.enderium;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.item.ModToolTiers;
import com.blocklegend001.immersiveores.item.custom.base.Paxel;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Unit;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.WeatheringCopper;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public class EnderiumShovel extends Item {
    private static final Map<Block, BlockState> FLATTENABLES = Shovel.getFlattenables();
    private static Properties createSettings(Properties properties, boolean unbreakable, int durability) {
        properties.durability(durability);

        if (unbreakable) {
            properties.component(DataComponents.UNBREAKABLE, Unit.INSTANCE);
        }
        return properties;
    }

    public EnderiumShovel(ModToolTiers material, float attackDamage, float attackSpeed, Properties settings) {
        super(
                material.applyToolProperties(
                        createSettings(settings, EnderiumConfig.unbreakableEnderium.get(), EnderiumConfig.durabilityEnderium.get()),
                        BlockTags.MINEABLE_WITH_SHOVEL,
                        attackDamage,
                        attackSpeed
                )
        );
    }

    @Override
    public Component getName(ItemStack stack) {
        return super.getName(stack).copy().withStyle(ChatFormatting.DARK_AQUA);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Player player = context.getPlayer();
        BlockState state = world.getBlockState(pos);
        BlockState result = getModifiedBlockState(context, state, pos);

        if (result == null) return InteractionResult.PASS;

        if (!world.isClientSide()) {
            world.setBlock(pos, result, 11);
        }
        return InteractionResult.SUCCESS;
    }

    private BlockState getModifiedBlockState(UseOnContext context, BlockState state, BlockPos pos) {
        Level world = context.getLevel();
        Player player = context.getPlayer();

        if (context.getClickedFace() == Direction.DOWN) return null;

        if (FLATTENABLES.containsKey(state.getBlock()) && world.getBlockState(pos.above()).isAir()) {
            world.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
            return FLATTENABLES.get(state.getBlock());
        }

        return null;
    }

    private static final class Shovel extends ShovelItem {
        public static Map<Block, BlockState> getFlattenables() {
            return ShovelItem.FLATTENABLES;
        }

        private Shovel(ToolMaterial tier, float attackDamage, float attackSpeed, Properties properties) {
            super(tier, attackDamage, attackSpeed, properties);
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext p_333372_, TooltipDisplay p_396484_, Consumer<Component> consumer, TooltipFlag p_41424_) {
        super.appendHoverText(pStack, p_333372_, p_396484_, consumer, p_41424_);
        if(Screen.hasShiftDown()) {
            if (EnderiumConfig.unbreakableEnderium.get()) {
                consumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.DARK_AQUA));
            }
            consumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.DARK_AQUA));
        } else {
            consumer.accept(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.DARK_AQUA));
        }
    }
}
