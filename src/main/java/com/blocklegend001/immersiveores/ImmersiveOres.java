package com.blocklegend001.immersiveores;

import com.blocklegend001.immersiveores.blocks.ModBlocks;
import com.blocklegend001.immersiveores.item.ModCreativeModTabs;
import com.blocklegend001.immersiveores.item.ModItems;
import com.blocklegend001.immersiveores.event.ModEventHandler;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ConfigTracker;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.slf4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Path;

@Mod(ImmersiveOres.MODID)
public class ImmersiveOres {
    public static final String MODID = "immersiveores";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ImmersiveOres() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(new ModEventHandler());
        modEventBus.addListener(this::commonSetup);
        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);
        ModCreativeModTabs.register(modEventBus);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ImmersiveOresConfig.SPEC);

        ModConfig commonConfig = ConfigTracker.INSTANCE.configSets().get(ModConfig.Type.COMMON)
                .stream()
                .filter(modConfig -> modConfig.getModId().equals(MODID))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
        Method openConfig;
        try {
            openConfig = ConfigTracker.INSTANCE.getClass().getDeclaredMethod("openConfig", ModConfig.class, Path.class);
            openConfig.setAccessible(true);
            openConfig.invoke(ConfigTracker.INSTANCE, commonConfig, FMLPaths.CONFIGDIR.get());
            openConfig.setAccessible(false);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException exception) {
            throw new RuntimeException(exception);
        }

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Mod Loaded");
    }
}