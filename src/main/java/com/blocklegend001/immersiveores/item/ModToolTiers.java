package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.util.ModTags;
import net.minecraft.world.item.ToolMaterial;

public class ModToolTiers {

    public static final ToolMaterial VIBRANIUM = new ToolMaterial(
            ModTags.Blocks.INCORRECT_FOR_VIBRANIUM_TOOL,
            VibraniumConfig.durabilityVibranium.get(),
            VibraniumConfig.speedVibraniumTier.get(),
            VibraniumConfig.attackDamageBonusVibraniumTier.get(),
            VibraniumConfig.enchantmentValueVibraniumTier.get(),
            ModTags.Items.VIBRANIUM_REPAIRS
    );

    public static final ToolMaterial VULPUS = new ToolMaterial(
            ModTags.Blocks.INCORRECT_FOR_VULPUS_TOOL,
            VulpusConfig.durabilityVulpus.get(),
            VulpusConfig.speedVulpusTier.get(),
            VulpusConfig.attackDamageBonusVulpusTier.get(),
            VulpusConfig.enchantmentValueVulpusTier.get(),
            ModTags.Items.VULPUS_REPAIRS
    );

    public static final ToolMaterial ENDERIUM = new ToolMaterial(
            ModTags.Blocks.INCORRECT_FOR_ENDERIUM_TOOL,
            EnderiumConfig.durabilityEnderium.get(),
            EnderiumConfig.speedEnderiumTier.get(),
            EnderiumConfig.attackDamageBonusEnderiumTier.get(),
            EnderiumConfig.enchantmentValueEnderiumTier.get(),
            ModTags.Items.ENDERIUM_REPAIRS
    );
}
