package com.MrpYA45.TheBoyScoutMod;

import com.MrpYA45.TheBoyScoutMod.init.ModItems;
import com.MrpYA45.TheBoyScoutMod.proxy.CommonProxy;
import com.MrpYA45.TheBoyScoutMod.util.Reference;
import com.MrpYA45.TheBoyScoutMod.util.handlers.OreDictionaryHandler;
import com.MrpYA45.TheBoyScoutMod.util.handlers.RecipeHandler;
import com.MrpYA45.TheBoyScoutMod.util.handlers.RegistryHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
	
	@Instance
	public static Main instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
		RegistryHandler.preInitRegistries();
		RegistryHandler.otherRegistries();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		RegistryHandler.initRegistries();
		OreDictionaryHandler.registerOreDictionary();
		RecipeHandler.registerSmeltingRecipes();
	}
	
	@EventHandler
	public static void Postinit(FMLPostInitializationEvent event)
	{
		RegistryHandler.postInitRegistries();
	}
	
	public static CreativeTabs tabTheBoyScoutMod = new CreativeTabs("tab_theboyscoutmod") {
		
		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(ModItems.THE_DIARY_OF_THE_SCOUT);
		}
	};
}
