package com.blocklegend001.immersiveores;

import com.blocklegend001.immersiveores.blocks.ModBlocks;
import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.event.ModEventHandler;
import com.blocklegend001.immersiveores.item.ModCreativeModTabs;
import com.blocklegend001.immersiveores.item.ModItems;
import com.blocklegend001.immersiveores.util.ModItemProperties;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(ImmersiveOres.MODID)
public class ImmersiveOres {
    public static final String MODID = "immersiveores";
    public static boolean SHOW_OUTLINE_ENABLED = true;

    public ImmersiveOres(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        context.registerConfig(ModConfig.Type.COMMON, VibraniumConfig.SPEC, "immersiveores/vibranium-common.toml");
        VibraniumConfig.loadConfig(VibraniumConfig.SPEC, FMLPaths.CONFIGDIR.get().resolve("immersiveores/vibranium-common.toml"));

        context.registerConfig(ModConfig.Type.COMMON, VulpusConfig.SPEC, "immersiveores/vulpus-common.toml");
        VulpusConfig.loadConfig(VulpusConfig.SPEC, FMLPaths.CONFIGDIR.get().resolve("immersiveores/vulpus-common.toml"));

        context.registerConfig(ModConfig.Type.COMMON, EnderiumConfig.SPEC, "immersiveores/enderium-common.toml");
        EnderiumConfig.loadConfig(EnderiumConfig.SPEC, FMLPaths.CONFIGDIR.get().resolve("immersiveores/enderium-common.toml"));

        MinecraftForge.EVENT_BUS.register(ModEventHandler.class);
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModCreativeModTabs.register(modEventBus);
        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void clientSetup(final FMLClientSetupEvent event) {
        ModItemProperties.addCustomItemProperties();
    }

    @SubscribeEvent
    public void setup(final FMLCommonSetupEvent event) {
        VibraniumConfig.loadConfig(VibraniumConfig.SPEC, FMLPaths.CONFIGDIR.get().resolve("immersiveores/vibranium-common.toml"));
        VulpusConfig.loadConfig(VulpusConfig.SPEC, FMLPaths.CONFIGDIR.get().resolve("immersiveores/vulpus-common.toml"));
        EnderiumConfig.loadConfig(EnderiumConfig.SPEC, FMLPaths.CONFIGDIR.get().resolve("immersiveores/enderium-common.toml"));
    }
}