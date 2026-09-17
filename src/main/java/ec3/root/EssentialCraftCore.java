package ec3.root;

import java.io.File;
import java.util.Arrays;

import net.minecraft.command.CommandHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.LoggerConfig;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.event.FMLServerStoppedEvent;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import ec3.api.config.Config;
import ec3.common.creativetabs.CreativePageBlocks;
import ec3.common.creativetabs.CreativePageItems;
import ec3.common.init.ECAchievements;
import ec3.common.init.ECBiomes;
import ec3.common.init.ECBlocks;
import ec3.common.init.ECDimensions;
import ec3.common.init.ECEntities;
import ec3.common.init.ECItems;
import ec3.common.init.ECPotions;
import ec3.common.init.ECRecipes;
import ec3.common.init.ECStructures;
import ec3.common.init.compat.ECCompatBloodMagic;
import ec3.common.init.custom.ECCorruptionEffects;
import ec3.common.init.custom.ECResearch;
import ec3.common.init.custom.ECWeapons;
import ec3.common.world.structures.WorldGenManager;
import ec3.integration.versionChecker.Check;
import ec3.integration.waila.WailaInitializer;
import ec3.network.proxy.CommonProxy;
import ec3.utils.commands.handlers.CommandEC;
import ec3.utils.commands.handlers.CommandECSimple;
import ec3.utils.dummycore.core.CoreInitializer;

@Mod(
    modid = EssentialCraftCore.modid,
    name = EssentialCraftCore.name,
    version = EssentialCraftCore.version,
    guiFactory = "ec3.client.gui.ModConfigGuiHandler")
public class EssentialCraftCore {

    // ============================================CORE START=================================================//

    // ============================================CORE VARS==================================================//
    @Instance(EssentialCraftCore.modid)
    public static EssentialCraftCore core;
    @SidedProxy(
        clientSide = "ec3.network.proxy.ClientProxy",
        serverSide = "ec3.network.proxy.CommonProxy",
        modId = EssentialCraftCore.modid)
    public static CommonProxy proxy;
    public static Config cfg = new Config();
    // TODO Do not forget to change the version number every git commit.
    public static final String version = "4.7.2";
    public static final String modid = "essentialcraft";
    public static final String name = "EssentialCraft3 Patched";
    public static ModMetadata metadata;
    public static SimpleNetworkWrapper network;

    public static final CreativeTabs modTabBlocks = new CreativePageBlocks("EssentialCraft");
    public static final CreativeTabs modTabItems = new CreativePageItems("EssentialCraft");
    // ============================================CORE FUNCTIONS=============================================//

    public static boolean isThaumcraftLoaded() {
        return Loader.isModLoaded("thaumcraft");
    }

    // ============================================CORE MOD===================================================//
    @EventHandler
    public void serverStart(FMLServerStartingEvent event) {
        MinecraftServer mcserver = event.getServer();

        ((CommandHandler) mcserver.getCommandManager()).registerCommand(new CommandEC());
        ((CommandHandler) mcserver.getCommandManager()).registerCommand(new CommandECSimple());

        CoreInitializer.serverStart(event);
    }

    @EventHandler
    public void onServerStop(FMLServerStoppedEvent e) {
        CoreInitializer.onServerStop(e);
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        CoreInitializer.preInit(event);

        File configFile = new File(event.getModConfigurationDirectory(), "Essential Craft 3.cfg");

        Config.config = new Configuration(configFile);
        cfg.load(Config.config);

        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        LoggerConfig config = context.getConfiguration()
            .getLoggerConfig("TEXTURE ERRORS");
        config.setLevel(Level.OFF);
        context.updateLoggers();

        metadata = event.getModMetadata();

        core = this;

        Check.checkerCommit();
        WailaInitializer.sendIMC();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        if (core == null) core = this;
        ECCoreRegistry.register();

        if (ECDimensions.core != null) ECDimensions.core.registerDimensionMagic();
        else {
            ECDimensions.core = new ECDimensions();
            ECDimensions.core.registerDimensionMagic();
        }
        if (ECBlocks.instance != null) ECBlocks.instance.loadBlocks();
        else {
            ECBlocks.instance = new ECBlocks();
            ECBlocks.instance.loadBlocks();
        }
        if (ECItems.instance != null) ECItems.instance.loadItems();
        else {
            ECItems.instance = new ECItems();
            ECItems.instance.loadItems();
        }
        if (ECRecipes.instance != null) ECRecipes.instance.main();
        else {
            ECRecipes.instance = new ECRecipes();
            ECRecipes.instance.main();
        }

        if (ECBiomes.core != null) ECBiomes.core.register();
        else {
            ECBiomes.core = new ECBiomes();
            ECBiomes.core.register();
        }
        ECBlocks.postInitLoad();
        ECStructures.register();
        if (proxy != null) {
            proxy.registerRenderInformation();
            proxy.registerTileEntitySpecialRenderer();
        } else {

        }
        ECWeapons.register();
        ECCorruptionEffects.register();

        CoreInitializer.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        ECEntities.registerEntities();
        ECCompatBloodMagic.register();
        ECAchievements.register();
        ECPotions.registerPotions();
        GameRegistry.registerWorldGenerator(new WorldGenManager(), 16);
        cfg.postInitParseDecorativeBlocks();
        ECResearch.init();

        metadata.autogenerated = false;
        metadata.modId = modid;
        metadata.version = version;
        metadata.name = name;
        metadata.credits = "Author: Modbder; Patched by: Kodesque;";
        metadata.authorList = Arrays.asList(new String[] { "Modbder", "Kodesque" });
        metadata.description = "EssentialCraft 3 is a huge technomagical mod which adds a new energy system, MRU (Magical Radiation Unit), and various ways to harness it.";
        metadata.url = "https://github.com/Modbder/EssentialCraft3";
        metadata.updateUrl = "https://github.com/Modbder/EssentialCraft3";
        metadata.logoFile = "assets/essentialcraft/textures/special/logo.png";
    }
}
