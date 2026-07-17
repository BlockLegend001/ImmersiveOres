package com.blocklegend001.immersiveores;

import com.blocklegend001.immersiveores.blocks.ModBlocks;
import com.blocklegend001.immersiveores.config.EnderiumConfig;
import com.blocklegend001.immersiveores.config.VibraniumConfig;
import com.blocklegend001.immersiveores.config.VulpusConfig;
import com.blocklegend001.immersiveores.item.ModCreativeModTabs;
import com.blocklegend001.immersiveores.item.ModItems;
import com.blocklegend001.immersiveores.util.KeyBinding;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(ImmersiveOres.MODID)
public class ImmersiveOres {
    public static final String MODID = "immersiveores";
    public static boolean SHOW_OUTLINE_ENABLED = true;

    public ImmersiveOres(FMLJavaModLoadingContext context) {
        var modEventBus = context.getModBusGroup();

        context.registerConfig(ModConfig.Type.COMMON, VibraniumConfig.SPEC, "immersiveores/vibranium-common.toml");
        VibraniumConfig.loadConfig(VibraniumConfig.SPEC, FMLPaths.CONFIGDIR.get().resolve("immersiveores/vibranium-common.toml"));

        context.registerConfig(ModConfig.Type.COMMON, VulpusConfig.SPEC, "immersiveores/vulpus-common.toml");
        VulpusConfig.loadConfig(VulpusConfig.SPEC, FMLPaths.CONFIGDIR.get().resolve("immersiveores/vulpus-common.toml"));

        context.registerConfig(ModConfig.Type.COMMON, EnderiumConfig.SPEC, "immersiveores/enderium-common.toml");
        EnderiumConfig.loadConfig(EnderiumConfig.SPEC, FMLPaths.CONFIGDIR.get().resolve("immersiveores/enderium-common.toml"));

        //MinecraftForge.EVENT_BUS.register(ModEventHandler.class);
        ModCreativeModTabs.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        FMLCommonSetupEvent.getBus(modEventBus).addListener(this::setup);

        RegisterKeyMappingsEvent.BUS.addListener(KeyBinding::registerKeys);
    }

    @SubscribeEvent
    public void setup(final FMLCommonSetupEvent event) {
        VibraniumConfig.loadConfig(VibraniumConfig.SPEC, FMLPaths.CONFIGDIR.get().resolve("immersiveores/vibranium-common.toml"));
        VulpusConfig.loadConfig(VulpusConfig.SPEC, FMLPaths.CONFIGDIR.get().resolve("immersiveores/vulpus-common.toml"));
        EnderiumConfig.loadConfig(EnderiumConfig.SPEC, FMLPaths.CONFIGDIR.get().resolve("immersiveores/enderium-common.toml"));
    }
}