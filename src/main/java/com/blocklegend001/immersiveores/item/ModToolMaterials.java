package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.util.ModTags;
import net.minecraft.world.item.ToolMaterial;

public class ModToolMaterials {

    public static final ToolMaterial VIBRANIUM = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_VIBRANIUM_TOOL, VibraniumConfig.durabilityVibranium, VibraniumConfig.speedVibraniumTier,
           VibraniumConfig.attackDamageBonusVibraniumTier, VibraniumConfig.enchantmentValueVibraniumTier, ModTags.Items.VIBRANIUM_REPAIRS);

    public static final ToolMaterial VULPUS = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_VULPUS_TOOL, VulpusConfig.durabilityVulpus, VulpusConfig.speedVulpusTier,
            VulpusConfig.attackDamageBonusVulpusTier, VulpusConfig.enchantmentValueVulpusTier, ModTags.Items.VULPUS_REPAIRS);

    public static final ToolMaterial ENDERIUM = new ToolMaterial(ModTags.Blocks.INCORRECT_FOR_ENDERIUM_TOOL, EnderiumConfig.durabilityEnderium, EnderiumConfig.speedEnderiumTier,
            EnderiumConfig.attackDamageBonusEnderiumTier, EnderiumConfig.enchantmentValueEnderiumTier, ModTags.Items.ENDERIUM_REPAIRS);

}
