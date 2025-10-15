package com.blocklegend001.immersiveores.item;

import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.util.ModTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.blocklegend001.immersiveores.item.custom.base.Paxel.getPaxelMineable;

public record ModToolTiers(TagKey<Block> incorrectBlocksForDrops, int durability, float speed,
                           float attackDamageBonus, int enchantmentValue) {

    public static final ModToolTiers VIBRANIUM = new ModToolTiers(
            ModTags.Blocks.INCORRECT_FOR_VIBRANIUM_TOOL,
            VibraniumConfig.DURABILITY_VIBRANIUM.get(),
            VibraniumConfig.SPEED_VIBRANIUM_TIER.get(),
            VibraniumConfig.ATTACK_DAMAGE_BONUS_VIBRANIUM_TIER.get(),
            VibraniumConfig.ENCHANTMENT_VALUE_VIBRANIUM_TIER.get());

    public static final ModToolTiers VULPUS = new ModToolTiers(
            ModTags.Blocks.INCORRECT_FOR_VULPUS_TOOL,
            VulpusConfig.DURABILITY_VULPUS.get(),
            VulpusConfig.SPEED_VULPUS_TIER.get(),
            VulpusConfig.ATTACK_DAMAGE_BONUS_VULPUS_TIER.get(),
            VulpusConfig.ENCHANTMENT_VALUE_VULPUS_TIER.get());

    public static final ModToolTiers ENDERIUM = new ModToolTiers(
            ModTags.Blocks.INCORRECT_FOR_ENDERIUM_TOOL,
            EnderiumConfig.DURABILITY_ENDERIUM.get(),
            EnderiumConfig.SPEED_ENDERIUM_TIER.get(),
            EnderiumConfig.ATTACK_DAMAGE_BONUS_ENDERIUM_TIER.get(),
            EnderiumConfig.ENCHANTMENT_VALUE_ENDERIUM_TIER.get());

    private Item.Properties applyCommonProperties(Item.Properties props) {
        return props
                .durability(this.durability)
                .enchantable(this.enchantmentValue);
    }

    private ItemAttributeModifiers createToolAttributes(float attackDamage, float attackSpeed) {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, attackDamage + this.attackDamageBonus, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, attackSpeed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .build();
    }

    public Item.Properties applyToolProperties(Item.Properties properties, TagKey<Block> effectiveBlocks, float damage, float speed) {
        HolderGetter<Block> blockGetter = BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.BLOCK);

        return applyCommonProperties(properties)
                .component(DataComponents.TOOL, new Tool(
                        List.of(
                                Tool.Rule.deniesDrops(blockGetter.getOrThrow(this.incorrectBlocksForDrops)),
                                Tool.Rule.minesAndDrops(blockGetter.getOrThrow(effectiveBlocks), this.speed)
                        ),
                        1.0F,
                        1,
                        true
                ))
                .attributes(createToolAttributes(damage, speed));
    }

    public Item.Properties applyPaxelProperties(Item.Properties properties, Set<TagKey<Block>> mineableTags, float damage, float speed) {
        HolderGetter<Block> blockGetter = BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.BLOCK);

        List<Tool.Rule> rules = new ArrayList<>();
        rules.add(Tool.Rule.deniesDrops(blockGetter.getOrThrow(this.incorrectBlocksForDrops)));

        for (TagKey<Block> tag : getPaxelMineable()) {
            rules.add(Tool.Rule.minesAndDrops(blockGetter.getOrThrow(tag), this.speed));
        }

        return applyCommonProperties(properties)
                .component(DataComponents.TOOL, new Tool(
                        rules,
                        1.0F,
                        1,
                        true
                ))
                .attributes(createToolAttributes(damage, speed));
    }

    public Item.Properties applySwordProperties(Item.Properties properties, float damage, float speed) {
        HolderGetter<Block> blockGetter = BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.BLOCK);

        return applyCommonProperties(properties)
                .component(DataComponents.TOOL, new Tool(
                        List.of(
                                Tool.Rule.minesAndDrops(
                                        HolderSet.direct(Blocks.COBWEB.builtInRegistryHolder()),
                                        15.0F
                                ),
                                Tool.Rule.overrideSpeed(
                                        blockGetter.getOrThrow(BlockTags.SWORD_EFFICIENT),
                                        1.5F
                                )
                        ),
                        1.0F,
                        2,
                        false
                ))
                .attributes(createToolAttributes(damage, speed));
    }


}