package com.blocklegend001.immersiveores;

import com.blocklegend001.immersiveores.blocks.ModBlocks;
import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.event.ModEventHandler;
import com.blocklegend001.immersiveores.item.ModCreativeModTabs;
import com.blocklegend001.immersiveores.item.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ImmersiveOres.MODID)
public class ImmersiveOres {
    public static final String MODID = "immersiveores";

    public ImmersiveOres(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        ModCreativeModTabs.register(modEventBus);
        VibraniumConfig.loadConfig();
        VulpusConfig.loadConfig();
        EnderiumConfig.loadConfig();
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(ModEventHandler.class);
        MinecraftForge.EVENT_BUS.register(this);
    }
}