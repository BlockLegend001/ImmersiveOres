package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.util.ModTags;
import net.minecraft.world.item.ToolMaterial;

public class ModToolTiers {

    public static final ToolMaterial VIBRANIUM = new ToolMaterial(
            ModTags.Blocks.INCORRECT_FOR_VIBRANIUM_TOOL,
            VibraniumConfig.DURABILITY_VIBRANIUM.get(),
            VibraniumConfig.SPEED_VIBRANIUM_TIER.get(),
            VibraniumConfig.ATTACK_DAMAGE_BONUS_VIBRANIUM_TIER.get(),
            VibraniumConfig.ENCHANTMENT_VALUE_VIBRANIUM_TIER.get(),
            ModTags.Items.VIBRANIUM_REPAIRS
    );

    public static final ToolMaterial VULPUS = new ToolMaterial(
            ModTags.Blocks.INCORRECT_FOR_VULPUS_TOOL,
            VulpusConfig.DURABILITY_VULPUS.get(),
            VulpusConfig.SPEED_VULPUS_TIER.get(),
            VulpusConfig.ATTACK_DAMAGE_BONUS_VULPUS_TIER.get(),
            VulpusConfig.ENCHANTMENT_VALUE_VULPUS_TIER.get(),
            ModTags.Items.VULPUS_REPAIRS
    );

    public static final ToolMaterial ENDERIUM = new ToolMaterial(
            ModTags.Blocks.INCORRECT_FOR_ENDERIUM_TOOL,
            EnderiumConfig.DURABILITY_ENDERIUM.get(),
            EnderiumConfig.SPEED_ENDERIUM_TIER.get(),
            EnderiumConfig.ATTACK_DAMAGE_BONUS_ENDERIUM_TIER.get(),
            EnderiumConfig.ENCHANTMENT_VALUE_ENDERIUM_TIER.get(),
            ModTags.Items.ENDERIUM_REPAIRS
    );
}
