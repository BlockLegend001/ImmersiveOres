package com.blocklegend001.immersiveores.item.custom.vulpus;

import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.util.ArrowCountMap;
import com.blocklegend001.immersiveores.util.BowTier;
import com.blocklegend001.immersiveores.util.RadiusMap;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class VulpusBow extends BowItem {
    private final BowTier tier;
    private final int ARROW_COUNT = VulpusConfig.arrowCountVulpusBow;

    public VulpusBow(BowTier tier, Settings properties) {
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

            Registry<Enchantment> enchantmentRegistry = world.getRegistryManager().get(RegistryKeys.ENCHANTMENT);
            RegistryEntry.Reference<Enchantment> enchantmentReference = enchantmentRegistry.getEntry(Enchantments.INFINITY).orElseThrow();
            boolean hasInfinity = EnchantmentHelper.getLevel(enchantmentReference, player.getMainHandStack()) > 0;

            int charge = getMaxUseTime(stack, player) - remainingUseTicks;
            boolean hasArrows = arrowStack.isOf(Items.ARROW);

            float arrowVelocity = getPullProgress(charge);

            if (arrowVelocity >= 0.1) {
                for (int i = 0; i < ARROW_COUNT; i++) {
                    ArrowItem arrowItem = (ArrowItem) (arrowStack.getItem() instanceof ArrowItem ? arrowStack.getItem() : Items.ARROW);
                    PersistentProjectileEntity arrowEntity = arrowItem.createArrow(world, arrowStack, user, stack);
                    arrowEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, arrowVelocity * 3.0F, 1.0F);

                    PersistentProjectileEntity.PickupPermission pickupPermission = hasInfinity ? PersistentProjectileEntity.PickupPermission.DISALLOWED : PersistentProjectileEntity.PickupPermission.ALLOWED;

                    if (i == 0) {
                        arrowEntity.pickupType = pickupPermission;
                    } else {
                        arrowEntity.pickupType = PersistentProjectileEntity.PickupPermission.DISALLOWED;
                    }

                    if (arrowVelocity == 1.0F) {
                        arrowEntity.setCritical(true);
                    }

                    arrowEntity.setOnFireForTicks(600);
                    world.spawnEntity(arrowEntity);
                }

                world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + arrowVelocity * 0.5F);

                if (hasArrows && !player.getAbilities().creativeMode && !hasInfinity) {
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
        int arrowCount = getArrowCount(stack);
        Formatting color = Formatting.RED;

        if (Screen.hasShiftDown()) {
            Text damage = Text.literal("+" + this.tier.getAttackDamageBonus() + " ")
                    .append(Text.translatable("tooltip.immersiveores.damage.tooltip"))
                    .formatted(color);
            tooltip.add(damage);

            Text unbreakable = Text.translatable("tooltip.immersiveores.unbreakble.tooltip")
                    .formatted(color);
            tooltip.add(unbreakable);

            Text fireImmune = Text.translatable("tooltip.immersiveores.immunetofire.tooltip")
                    .formatted(color);
            tooltip.add(fireImmune);

            Text arrow = Text.literal("Can shoot ")
                    .formatted(color)
                    .append(Text.literal(String.valueOf(arrowCount)).formatted(Formatting.YELLOW))
                    .append(Text.literal(" Arrows").formatted(color));
            tooltip.add(arrow);
        } else {
            Text pressShift = Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip")
                    .formatted(color);
            tooltip.add(pressShift);
        }
    }


    private int getArrowCount(ItemStack stack) {
        if (ArrowCountMap.VULPUS_BOW_ARROW_COUNT.containsKey(stack.getItem())) {
            return ArrowCountMap.VULPUS_BOW_ARROW_COUNT.get(stack.getItem());
        }
        return 0;
    }
}
