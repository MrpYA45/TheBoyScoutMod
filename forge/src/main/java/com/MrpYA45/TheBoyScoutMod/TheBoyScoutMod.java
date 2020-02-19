package com.MrpYA45.TheBoyScoutMod;

import com.MrpYA45.TheBoyScoutMod.containers_screen.GuiBackpack;
import com.MrpYA45.TheBoyScoutMod.containers_screen.GuiDiamondBox;
import com.MrpYA45.TheBoyScoutMod.containers_screen.GuiEmeraldBox;
import com.MrpYA45.TheBoyScoutMod.containers_screen.GuiGoldBox;
import com.MrpYA45.TheBoyScoutMod.containers_screen.GuiIronBox;
import com.MrpYA45.TheBoyScoutMod.containers_screen.GuiPaperBin;
import com.MrpYA45.TheBoyScoutMod.containers_screen.GuiWoodenBox;
import com.MrpYA45.TheBoyScoutMod.init.ModContainers;
import com.MrpYA45.TheBoyScoutMod.init.ModTabTBSM;
import com.MrpYA45.TheBoyScoutMod.util.TBSMConfig;
import com.MrpYA45.TheBoyScoutMod.util.handlers.RenderHandler;
import com.MrpYA45.TheBoyScoutMod.worldgen.HazelTreeFeature;
import com.MrpYA45.TheBoyScoutMod.worldgen.TBSMFlowersFeature;
import com.MrpYA45.TheBoyScoutMod.worldgen.TentFeature;
import com.MrpYA45.TheBoyScoutMod.worldgen.WorldGenOreGen;
import com.MrpYA45.TheBoyScoutMod.worldgen.WorldGenTBSM;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.item.ItemGroup;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(TheBoyScoutMod.MOD_ID)
public class TheBoyScoutMod {

	public static final String MOD_ID = "tbsm";

	public static final ItemGroup TBSM_TAB = new ModTabTBSM();

	public TheBoyScoutMod() {
		HazelTreeFeature featurehazel = new HazelTreeFeature();
		TBSMFlowersFeature feature = new TBSMFlowersFeature(NoFeatureConfig::deserialize);
		TentFeature featuretent = new TentFeature(NoFeatureConfig::deserialize, false);
		feature.setRegistryName("tbsm_flowers");
		featurehazel.setRegistryName("hazelfeature");
		featuretent.setRegistryName("tbsm_tent");
		ForgeRegistries.FEATURES.register(feature);
		ForgeRegistries.FEATURES.register(featurehazel);
		ForgeRegistries.FEATURES.register(featuretent);
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, TBSMConfig.SERVER_SPEC);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
		TBSMConfig.loadConfig(TBSMConfig.SERVER_SPEC, FMLPaths.CONFIGDIR.get().resolve("tbsm.toml"));
		MinecraftForge.EVENT_BUS.register(this);
	}

	public void setup(final FMLCommonSetupEvent event) {
		WorldGenOreGen.setup();
		WorldGenTBSM.setup();
	}

	public void clientSetup(final FMLClientSetupEvent event) {
		DeferredWorkQueue.runLater(() -> {
			ScreenManager.registerFactory(ModContainers.WOODEN_BOX, GuiWoodenBox::new);
			ScreenManager.registerFactory(ModContainers.BACKPACK, GuiBackpack::new);
			ScreenManager.registerFactory(ModContainers.IRON_BOX, GuiIronBox::new);
			ScreenManager.registerFactory(ModContainers.GOLD_BOX, GuiGoldBox::new);
			ScreenManager.registerFactory(ModContainers.DIAMOND_BOX, GuiDiamondBox::new);
			ScreenManager.registerFactory(ModContainers.EMERALD_BOX, GuiEmeraldBox::new);
			ScreenManager.registerFactory(ModContainers.PAPER_BIN, GuiPaperBin::new);
		});
		RenderHandler.registerEntityRenders();
	}

	public void enqueueIMC(final InterModEnqueueEvent event) {

	}

	public void processIMC(final InterModProcessEvent event) {

	}

	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {

	}

//	
//	@EventHandler
//	public static void PreInit(FMLPreInitializationEvent event)
//	{
//		RegistryHandler.preInitRegistries();
//		RegistryHandler.otherRegistries();
//	}
//	
//	@EventHandler
//	public static void init(FMLInitializationEvent event)
//	{
//		RegistryHandler.initRegistries();
//		OreDictionaryHandler.registerOreDictionary();
//		RecipeHandler.registerSmeltingRecipes();
//	}
//	
//	@EventHandler
//	public static void Postinit(FMLPostInitializationEvent event)
//	{
//		RegistryHandler.postInitRegistries();
//	}
}
