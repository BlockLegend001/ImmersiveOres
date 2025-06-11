package com.blocklegend001.immersiveores.item.custom.vibranium;

import com.blocklegend001.immersiveores.util.BowTier;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.function.Consumer;

public class VibraniumBow extends BowItem {
    private final BowTier tier;

    public VibraniumBow(BowTier tier, Properties properties) {
        super(properties.durability(tier.getUses()).enchantable(tier.getEnchantmentValue()));
        this.tier = tier;
    }

    @Override
    public boolean releaseUsing(ItemStack stack, Level world, LivingEntity entityLiving, int timeLeft) {
        if (entityLiving instanceof Player player) {
            ItemStack arrowStack = player.getProjectile(stack);

            Registry<Enchantment> enchantmentRegistry = world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT);
            Holder<Enchantment> enchantmentReference = enchantmentRegistry.getOrThrow(Enchantments.INFINITY);
            boolean hasInfinity = EnchantmentHelper.getItemEnchantmentLevel(enchantmentReference, player.getMainHandItem()) > 0;

            int charge = getUseDuration(stack, entityLiving) - timeLeft;
            float arrowVelocity = getPowerForTime(charge);
            if (arrowVelocity >= 0.1) {
                if (!world.isClientSide) {
                    int arrowCount = 2;
                    boolean isPrimaryArrow = true;

                    for (int i = 0; i < arrowCount; i++) {
                        ArrowItem arrowItem = (ArrowItem) (arrowStack.getItem() instanceof ArrowItem ? arrowStack.getItem() : Items.ARROW);
                        AbstractArrow arrowEntity = arrowItem.createArrow(world, arrowStack, player, stack);

                        arrowEntity.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, arrowVelocity * 3.0F, 1.0F);

                        if (arrowVelocity == 1.0F) {
                            arrowEntity.setCritArrow(true);
                        }

                        if (isPrimaryArrow) {
                            arrowEntity.pickup = hasInfinity ? AbstractArrow.Pickup.DISALLOWED : AbstractArrow.Pickup.ALLOWED;
                            isPrimaryArrow = false;
                        } else {
                            arrowEntity.pickup = AbstractArrow.Pickup.DISALLOWED;
                        }

                        world.addFreshEntity(arrowEntity);
                    }
                }
                world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + arrowVelocity * 0.5F);

                if (!player.getAbilities().instabuild && !hasInfinity) {
                    arrowStack.shrink(1);
                    if (arrowStack.isEmpty()) {
                        player.getInventory().removeItem(arrowStack);
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext p_333372_, TooltipDisplay p_396484_, Consumer<Component> consumer, TooltipFlag p_41424_) {
        super.appendHoverText(pStack, p_333372_, p_396484_, consumer, p_41424_);
        if (Screen.hasShiftDown()) {
            consumer.accept(Component.literal("+" + this.tier.getAttackDamageBonus() + " ")
                    .append(Component.translatable("tooltip.immersiveores.damage.tooltip")).withStyle(ChatFormatting.LIGHT_PURPLE));
            consumer.accept(Component.translatable("tooltip.immersiveores.unbreakble.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
            consumer.accept(Component.translatable("tooltip.immersiveores.immunetofire.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
            consumer.accept(Component.translatable("tooltip.immersiveores.shoot2arrows.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
        } else {
            consumer.accept(Component.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").withStyle(ChatFormatting.LIGHT_PURPLE));
        }
    }
}