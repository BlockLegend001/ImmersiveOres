package com.blocklegend001.immersiveores.item.custom.vibranium;

import com.blocklegend001.immersiveores.util.BowTier;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class VibraniumBow extends BowItem {
    private final BowTier tier;

    public VibraniumBow(BowTier tier, Settings properties) {
        super(properties.maxDamage(tier.getUses()));
        this.tier = tier;
    }

    @Override
    public int getEnchantability() {
        return super.getEnchantability();
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity player) {
            ItemStack arrowStack = user.getProjectileType(stack);

            int charge = getMaxUseTime(stack, player) - remainingUseTicks;
            boolean bl2 = arrowStack.isOf(Items.ARROW);
            float arrowVelocity = getPullProgress(charge);

            if (arrowVelocity >= 0.1) {
                int arrowCount = 2;
                for (int i = 0; i < arrowCount; i++) {
                    ArrowItem arrowItem = (ArrowItem) (arrowStack.getItem() instanceof ArrowItem ? arrowStack.getItem() : Items.ARROW);
                    PersistentProjectileEntity arrowEntity = arrowItem.createArrow(world, arrowStack, user, stack);
                    arrowEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, arrowVelocity * 3.0F, 1.0F);

                    if (i == 0) {
                        arrowEntity.pickupType = PersistentProjectileEntity.PickupPermission.ALLOWED;
                    } else {
                        arrowEntity.pickupType = PersistentProjectileEntity.PickupPermission.DISALLOWED;
                    }

                    if (arrowVelocity == 1.0F) {
                        arrowEntity.setCritical(true);
                    }

                    world.spawnEntity(arrowEntity);
                }

                world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + arrowVelocity * 0.5F);

                if (bl2 && !player.getAbilities().creativeMode) {
                    arrowStack.decrement(1);
                    if (arrowStack.isEmpty()) {
                        player.getInventory().removeOne(arrowStack);
                    }
                }
            }
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.literal("+" + this.tier.getAttackDamageBonus() + " ")
                    .append(Text.translatable("tooltip.immersiveores.damage.tooltip")).formatted(Formatting.LIGHT_PURPLE));
            tooltip.add(Text.translatable("tooltip.immersiveores.unbreakble.tooltip").formatted(Formatting.LIGHT_PURPLE));
            tooltip.add(Text.translatable("tooltip.immersiveores.immunetofire.tooltip").formatted(Formatting.LIGHT_PURPLE));
            tooltip.add(Text.translatable("tooltip.immersiveores.shoot2arrows.tooltip").formatted(Formatting.LIGHT_PURPLE));
        } else {
            tooltip.add(Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip").formatted(Formatting.LIGHT_PURPLE));
        }
    }
}