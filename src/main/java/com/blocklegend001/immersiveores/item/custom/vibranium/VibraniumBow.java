package com.blocklegend001.immersiveores.item.custom.vibranium;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.util.map.ArrowCountMap;
import com.blocklegend001.immersiveores.util.tools.bow.BowTier;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
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
import net.minecraft.util.Hand;
import net.minecraft.util.Unit;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Consumer;

public class VibraniumBow extends BowItem {
    private final BowTier tier;
    private final int ARROW_COUNT = VibraniumConfig.arrowCountVibraniumBow;

    private static Settings createSettings(Settings base, boolean unbreakable, int durability) {
        base.maxDamage(durability).fireproof();
        if (unbreakable) {
            base.component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE);
        }
        return base;
    }

    public VibraniumBow(BowTier tier, Settings settings) {
        super(createSettings(settings, EnderiumConfig.unbreakableEnderium, EnderiumConfig.durabilityEnderium));
        this.tier = tier;
    }

    @Override
    public Text getName(ItemStack stack) {
        return super.getName(stack).copy().formatted(Formatting.LIGHT_PURPLE);
    }

    @Override
    public boolean onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        if (user instanceof PlayerEntity player) {
            ItemStack arrowStack = user.getProjectileType(stack);

            Registry<Enchantment> enchantmentRegistry = world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);

            RegistryEntry.Reference<Enchantment> enchantmentReference = enchantmentRegistry.getOrThrow(Enchantments.INFINITY);
            boolean hasInfinity = EnchantmentHelper.getLevel(enchantmentReference, player.getMainHandStack()) > 0;

            RegistryEntry.Reference<Enchantment> enchantmentReferencePower = enchantmentRegistry.getOrThrow(Enchantments.POWER);
            int powerLevel = EnchantmentHelper.getLevel(enchantmentReferencePower, player.getMainHandStack());

            RegistryEntry.Reference<Enchantment> enchantmentReferencePunch = enchantmentRegistry.getOrThrow(Enchantments.PUNCH);
            int punchLevel = EnchantmentHelper.getLevel(enchantmentReferencePunch, player.getMainHandStack());

            int charge = getMaxUseTime(stack, player) - remainingUseTicks;
            boolean hasArrows = arrowStack.isOf(Items.ARROW);

            float arrowVelocity = getPullProgress(charge);

            if (arrowVelocity >= 0.1) {
                for (int i = 0; i < ARROW_COUNT; i++) {
                    ArrowItem arrowItem = (ArrowItem) (arrowStack.getItem() instanceof ArrowItem ? arrowStack.getItem() : Items.ARROW);
                    PersistentProjectileEntity arrowEntity = arrowItem.createArrow(world, arrowStack, user, stack);
                    int damage = stack.getOrDefault(DataComponentTypes.DAMAGE, 0);

                    arrowEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, arrowVelocity * 3.0F, 1.0F);

                    if (powerLevel > 0) {
                        arrowEntity.setDamage(damage + (powerLevel * 0.5 + 1.0));
                    }

                    if (punchLevel > 0) {
                        double resistance = Math.max(0.0, 1.0 - user.getAttributeValue(EntityAttributes.KNOCKBACK_RESISTANCE));
                        Vec3d knockbackVec = arrowEntity.getVelocity()
                                .normalize()
                                .multiply(punchLevel * 0.6 * resistance);

                        arrowEntity.setVelocity(knockbackVec.x, 0.1, knockbackVec.z);
                    }

                    PersistentProjectileEntity.PickupPermission pickupPermission = hasInfinity ? PersistentProjectileEntity.PickupPermission.DISALLOWED : PersistentProjectileEntity.PickupPermission.ALLOWED;

                    if (i == 0) {
                        arrowEntity.pickupType = pickupPermission;
                    } else {
                        arrowEntity.pickupType = PersistentProjectileEntity.PickupPermission.DISALLOWED;
                    }

                    if (arrowVelocity == 1.0F) {
                        arrowEntity.setCritical(true);
                    }

                    world.spawnEntity(arrowEntity);
                }

                world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (player.getRandom().nextFloat() * 0.4F + 1.2F) + arrowVelocity * 0.5F);

                if (hasArrows && !player.getAbilities().creativeMode && !hasInfinity) {
                    arrowStack.decrement(1);
                    if (arrowStack.isEmpty()) {
                        player.getInventory().removeOne(arrowStack);
                    }
                }
                stack.damage(1, player,
                        LivingEntity.getSlotForHand(Hand.MAIN_HAND));
            }
        }
        return false;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        int arrowCount = getArrowCount(stack);
        Formatting color = Formatting.LIGHT_PURPLE;

        if (Screen.hasShiftDown()) {
            Text damage = Text.literal("+" + this.tier.getAttackDamageBonus() + " ")
                    .append(Text.translatable("tooltip.immersiveores.damage.tooltip"))
                    .formatted(color);
            textConsumer.accept(damage);

            if (VibraniumConfig.unbreakableVibranium) {
                Text unbreakable = Text.translatable("tooltip.immersiveores.unbreakble.tooltip")
                        .formatted(color);
                textConsumer.accept(unbreakable);
            }

            Text fireImmune = Text.translatable("tooltip.immersiveores.immunetofire.tooltip")
                    .formatted(color);
            textConsumer.accept(fireImmune);

            Text arrow = Text.literal("Can shoot ")
                    .formatted(color)
                    .append(Text.literal(String.valueOf(arrowCount)).formatted(Formatting.YELLOW))
                    .append(Text.literal(" Arrows").formatted(color));
            textConsumer.accept(arrow);
        } else {
            Text pressShift = Text.translatable("tooltip.immersiveores.pressshiftformoreinfo.tooltip")
                    .formatted(color);
            textConsumer.accept(pressShift);
        }
    }

    private int getArrowCount(ItemStack stack) {
        if (ArrowCountMap.VIBRANIUM_BOW_ARROW_COUNT.containsKey(stack.getItem())) {
            return ArrowCountMap.VIBRANIUM_BOW_ARROW_COUNT.get(stack.getItem());
        }
        return 0;
    }
}