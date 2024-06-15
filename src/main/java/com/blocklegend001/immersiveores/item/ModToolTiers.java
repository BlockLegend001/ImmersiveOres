package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.ImmersiveOresConfig;
import com.blocklegend001.immersiveores.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static Tier VIBRANIUM;
    public static Tier VULPUS;
    public static Tier ENDERIUM;

    static {
        VIBRANIUM = TierSortingRegistry.registerTier(
                new ForgeTier(5, 0, ImmersiveOresConfig.speedVibraniumTier.get(), ImmersiveOresConfig.attackDamageBonusVibraniumTier.get(), ImmersiveOresConfig.enchantmentValueVibraniumTier.get(),
                        ModTags.Blocks.NEEDS_VIBRANIUM_TOOL, () -> Ingredient.of(ModItems.VIBRANIUM_INGOT.get())),
                new ResourceLocation(ImmersiveOres.MODID, "vibranium"), List.of(Tiers.NETHERITE), List.of());

        VULPUS = TierSortingRegistry.registerTier(
                new ForgeTier(5, 0, ImmersiveOresConfig.speedVulpusTier.get(), ImmersiveOresConfig.attackDamageBonusVulpusTier.get(), ImmersiveOresConfig.enchantmentValueVulpusTier.get(),
                        ModTags.Blocks.NEEDS_VULPUS_TOOL, () -> Ingredient.of(ModItems.VULPUS_INGOT.get())),
                new ResourceLocation(ImmersiveOres.MODID, "vulpus"), List.of(Tiers.NETHERITE), List.of());

        ENDERIUM = TierSortingRegistry.registerTier(
                new ForgeTier(5, 0, ImmersiveOresConfig.speedEnderiumTier.get(), ImmersiveOresConfig.attackDamageBonusEnderiumTier.get(), ImmersiveOresConfig.enchantmentValueEnderiumTier.get(),
                        ModTags.Blocks.NEEDS_ENDERIUM_TOOL, () -> Ingredient.of(ModItems.ENDERIUM_INGOT.get())),
                new ResourceLocation(ImmersiveOres.MODID, "enderium"), List.of(Tiers.NETHERITE), List.of());
    }
}
