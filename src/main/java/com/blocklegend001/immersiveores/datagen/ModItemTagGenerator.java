package com.blocklegend001.immersiveores.datagen;

import com.blocklegend001.immersiveores.ImmersiveOres;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, ImmersiveOres.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.VIBRANIUM_HELMET.get(),
                        ModItems.VIBRANIUM_CHESTPLATE.get(),
                        ModItems.VIBRANIUM_LEGGINGS.get(),
                        ModItems.VIBRANIUM_BOOTS.get(),

                        ModItems.VULPUS_HELMET.get(),
                        ModItems.VULPUS_CHESTPLATE.get(),
                        ModItems.VULPUS_LEGGINGS.get(),
                        ModItems.VULPUS_BOOTS.get(),

                        ModItems.ENDERIUM_HELMET.get(),
                        ModItems.ENDERIUM_CHESTPLATE.get(),
                        ModItems.ENDERIUM_LEGGINGS.get(),
                        ModItems.ENDERIUM_BOOTS.get());
    }
}
