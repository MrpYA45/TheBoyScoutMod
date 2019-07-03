package com.MrpYA45.TheBoyScoutMod;

import com.MrpYA45.TheBoyScoutMod.blocks.containers.wooden_box.GuiWoodenBox;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.wooden_box.TileEntityWoodenBox;
import com.MrpYA45.TheBoyScoutMod.init.ModTabTBSM;
import com.MrpYA45.TheBoyScoutMod.util.TBSMConfig;
import com.MrpYA45.TheBoyScoutMod.worldgen.WorldGenOreGen;
import com.MrpYA45.TheBoyScoutMod.worldgen.WorldGenTBSMFlowers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.ItemGroup;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ExtensionPoint;
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

@Mod(Main.MOD_ID)
public class Main {
	
	public static final String MOD_ID = "tbsm";
	
	public static final ItemGroup TBSM_TAB = new ModTabTBSM();
	
	public Main() {

//		ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.GUIFACTORY, () -> GuiHandler::DisplayStorageGUI);

		ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.GUIFACTORY, () -> {
			return (openContainer) -> {
				ResourceLocation location = openContainer.getId();
				if(location.toString().equals(MOD_ID + ":wooden_box_gui")) {
					EntityPlayerSP player = Minecraft.getInstance().player;
					BlockPos pos = openContainer.getAdditionalData().readBlockPos();
					TileEntity tile = player.world.getTileEntity(pos);
					if(tile instanceof TileEntityWoodenBox) return new GuiWoodenBox(player.inventory, (TileEntityWoodenBox) tile);
				}
				return null;
			};
		});

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
		WorldGenTBSMFlowers.setup();
	}
	
	public void clientSetup(final FMLClientSetupEvent event) {
		
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
