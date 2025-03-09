package com.blocklegend001.immersiveores.util;

import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

public class ModItemProperties {
    public static void registerModModels() {
        registerBow(ModItems.ENDERIUM_BOW);
        registerBow(ModItems.VIBRANIUM_BOW);
        registerBow(ModItems.VULPUS_BOW);
    }

    private static void registerBow(Item bow) {
        ModelPredicateProviderRegistry.register(Identifier.of("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0f;
            }
            if (entity.getActiveItem() != stack) {
                return 0.0f;
            }
            return (float)(stack.getMaxUseTime(entity) - entity.getItemUseTimeLeft()) / 20.0f;
        });
        ModelPredicateProviderRegistry.register(Identifier.of("pulling"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            }
            return entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F;
        });
    }
}