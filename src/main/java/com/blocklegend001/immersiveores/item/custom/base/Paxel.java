package com.blocklegend001.immersiveores.item.custom.base;

import net.minecraft.block.*;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;

public class Paxel extends Item {
    private static final Map<Block, BlockState> FLATTENABLES = Shovel.getFlattenables();
    private static final Map<Block, Block> STRIPPABLES = Axe.getStrippables();
    private static TagKey<Block> paxelMineable;
    private final ToolMaterial tier;

    public Paxel(ToolMaterial tier, TagKey<Block> paxelMineable, float attackDamage, float attackSpeed, Settings settings) {
        super(computeSettings(tier, paxelMineable, settings, attackDamage, attackSpeed));
        this.paxelMineable = paxelMineable;
        this.tier = tier;
    }

    public ToolMaterial getTier() {
        return tier;
    }

    @Override
    public float getMiningSpeed(ItemStack stack, BlockState state) {
        stack.get(DataComponentTypes.TOOL);
        return state.isIn(paxelMineable) ? tier.speed() : 1.0F;
    }

    @Override
    public boolean canMine(ItemStack stack, BlockState state, World world, BlockPos pos, LivingEntity user) {
        return state.isIn(paxelMineable);
    }

    private static Settings computeSettings(ToolMaterial material, TagKey<Block> paxelMineable, Settings settings, float attackDamage, float attackSpeed) {
        Paxel.paxelMineable = paxelMineable;
        settings.pickaxe(wrapMaterial(material, material.durability()), attackDamage, attackSpeed);
        settings.shovel(wrapMaterial(material, material.durability()), attackDamage, attackSpeed);
        settings.axe(wrapMaterial(material, material.durability()), attackDamage, attackSpeed);
        settings.tool(material, BlockTags.PICKAXE_MINEABLE, attackDamage, attackSpeed, 0.0F);
        return settings;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState state = world.getBlockState(pos);
        BlockState result = getModifiedBlockState(context, state, pos);

        if (shouldCancelStripAttempt(context)) return ActionResult.PASS;

        if (result == null) return ActionResult.PASS;

        if (!world.isClient()) {
            world.setBlockState(pos, result, 11);
        }
        return ActionResult.SUCCESS;
    }

    private BlockState getModifiedBlockState(ItemUsageContext context, BlockState state, BlockPos pos) {
        World world = context.getWorld();
        PlayerEntity player = context.getPlayer();

        if (STRIPPABLES.containsKey(state.getBlock())) {
            world.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return STRIPPABLES.get(state.getBlock()).getDefaultState()
                    .with(PillarBlock.AXIS, state.get(PillarBlock.AXIS));
        }

        Optional<BlockState> newState = evaluateNewBlockState(world, pos, player, state);
        if (newState.isPresent()) {
            return newState.get();
        }

        if (context.getSide() == Direction.DOWN) return null;

        if (FLATTENABLES.containsKey(state.getBlock()) && world.getBlockState(pos.up()).isAir()) {
            world.playSound(player, pos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return FLATTENABLES.get(state.getBlock());
        }

        if (state.getBlock() instanceof CampfireBlock && state.get(CampfireBlock.LIT)) {
            world.playSound(player, pos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return state.with(CampfireBlock.LIT, false);
        }

        return null;
    }

    private static boolean shouldCancelStripAttempt(ItemUsageContext context) {
        PlayerEntity playerEntity = context.getPlayer();
        return context.getHand().equals(Hand.MAIN_HAND) && playerEntity.getOffHandStack().isOf(Items.SHIELD) && !playerEntity.shouldCancelInteraction();
    }

    private Optional<BlockState> evaluateNewBlockState(World world, BlockPos pos, @Nullable PlayerEntity player, BlockState state) {
        Optional<BlockState> optional = this.getStripped(state);
        if (optional.isPresent()) {
            world.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return optional;
        } else {

            Optional<BlockState> optional1 = Oxidizable.getDecreasedOxidationState(state);
            if (optional1.isPresent()) {
                world.playSound(player, pos, SoundEvents.ITEM_AXE_SCRAPE, SoundCategory.BLOCKS, 1.0F, 1.0F);
                world.syncWorldEvent(player, 3005, pos, 0);
                return optional1;
            } else {

                Optional<BlockState> optional2 = Optional.ofNullable(HoneycombItem.WAXED_TO_UNWAXED_BLOCKS.get().get(state.getBlock()))
                        .map(block -> block.getStateWithProperties(state));
                if (optional2.isPresent()) {
                    world.playSound(player, pos, SoundEvents.ITEM_AXE_WAX_OFF, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    world.syncWorldEvent(player, 3004, pos, 0);
                    return optional2;
                } else {

                    return Optional.empty();
                }
            }
        }
    }

    private Optional<BlockState> getStripped(BlockState state) {
        return Optional.ofNullable(STRIPPABLES.get(state.getBlock()))
                .map((block) -> block.getDefaultState().with(PillarBlock.AXIS, state.get(PillarBlock.AXIS)));
    }

    private static final class Axe extends AxeItem {
        public static Map<Block, Block> getStrippables() {
            return AxeItem.STRIPPED_BLOCKS;
        }

        private Axe(ToolMaterial pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Settings pProperties) {
            super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        }
    }

    private static final class Shovel extends ShovelItem {
        public static Map<Block, BlockState> getFlattenables() {
            return ShovelItem.PATH_STATES;
        }

        private Shovel(ToolMaterial pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Settings pProperties) {
            super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        }
    }

    private static ToolMaterial wrapMaterial(ToolMaterial toolMaterial, int durability) {
        return new ToolMaterial(
                toolMaterial.incorrectBlocksForDrops(),
                durability,
                toolMaterial.speed(),
                toolMaterial.attackDamageBonus(),
                toolMaterial.enchantmentValue(),
                toolMaterial.repairItems()
        );
    }
}