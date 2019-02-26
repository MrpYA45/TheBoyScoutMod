package com.MrpYA45.TheBoyScoutMod.util.handlers;

import com.MrpYA45.TheBoyScoutMod.Main;
import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;
import com.MrpYA45.TheBoyScoutMod.init.ModEntities;
import com.MrpYA45.TheBoyScoutMod.init.ModItems;
import com.MrpYA45.TheBoyScoutMod.util.IHasModel;
import com.MrpYA45.TheBoyScoutMod.util.TBSMConfig;
import com.MrpYA45.TheBoyScoutMod.worldgen.WorldGenCustomOreGen;
import com.MrpYA45.TheBoyScoutMod.worldgen.WorldGenCustomStructures;
import com.MrpYA45.TheBoyScoutMod.worldgen.WorldGenTBSMFlowers;

import net.minecraft.block.Block;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegistryHandler {
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
		Blocks.FIRE.setFireInfo(ModBlocks.HAZEL_WOOD_BLOCK , 5, 5);
		Blocks.FIRE.setFireInfo(ModBlocks.PALM_WOOD_BLOCK , 5, 5);
		Blocks.FIRE.setFireInfo(ModBlocks.BAOBAB_WOOD_BLOCK , 5, 5);
		Blocks.FIRE.setFireInfo(ModBlocks.HAZEL_PLANKS_BLOCK , 5, 20);
		Blocks.FIRE.setFireInfo(ModBlocks.PALM_PLANKS_BLOCK , 5, 20);
		Blocks.FIRE.setFireInfo(ModBlocks.BAOBAB_PLANKS_BLOCK , 5, 20);
		Blocks.FIRE.setFireInfo(ModBlocks.HAZEL_LEAVES_BLOCK , 30, 60);
		Blocks.FIRE.setFireInfo(ModBlocks.PALM_LEAVES_BLOCK , 30, 60);
		Blocks.FIRE.setFireInfo(ModBlocks.BLUE_FLOWER_BLOCK , 60, 100);
		Blocks.FIRE.setFireInfo(ModBlocks.PINK_FLOWER_BLOCK , 6, 100);
		Blocks.FIRE.setFireInfo(ModBlocks.ORANGE_FLOWER_BLOCK , 60, 100);
		Blocks.FIRE.setFireInfo(ModBlocks.WEEDS_BLOCK , 60, 100);
		Blocks.FIRE.setFireInfo(ModBlocks.BLUEBERRIES_BUSH_BLOCK , 30, 60);
		Blocks.FIRE.setFireInfo(ModBlocks.FULL_BLUEBERRIES_BUSH_BLOCK , 30, 60);
		TileEntityHandler.registerTileEntity();
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.BLUEBERRIES_SEEDS), 4);
		MinecraftForge.addGrassSeed(new ItemStack(ModItems.STRAWBERRY), 1);
	}

	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		for(Item item : ModItems.ITEMS) {
			if(item instanceof IHasModel) {
				((IHasModel)item).registerModels();
			}
		}
		
		for(Block block : ModBlocks.BLOCKS) {
			if(block instanceof IHasModel) {
				((IHasModel)block).registerModels();
			}
		}
		RenderHandler.registerEntityRenders();
	}
	
	public static void preInitRegistries() {
		ModEntities.registerEntities();
		GameRegistry.registerWorldGenerator(new WorldGenCustomStructures(), 0);
	}
	
	public static void initRegistries() {
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
		GameRegistry.registerWorldGenerator(new WorldGenTBSMFlowers(ModBlocks.BLUE_FLOWER_BLOCK, TBSMConfig.Flowers.blue_flower_frecuency, BiomeDictionary.getBiomes(Type.FOREST).toArray(new Biome[0])), 0);
		GameRegistry.registerWorldGenerator(new WorldGenTBSMFlowers(ModBlocks.PINK_FLOWER_BLOCK, TBSMConfig.Flowers.pink_flower_frecuency, BiomeDictionary.getBiomes(Type.FOREST).toArray(new Biome[0])), 0);
		GameRegistry.registerWorldGenerator(new WorldGenTBSMFlowers(ModBlocks.ORANGE_FLOWER_BLOCK, TBSMConfig.Flowers.orange_flower_frecuency, BiomeDictionary.getBiomes(Type.FOREST).toArray(new Biome[0])), 0);
		GameRegistry.registerWorldGenerator(new WorldGenTBSMFlowers(ModBlocks.WEEDS_BLOCK, TBSMConfig.Flowers.weeds_frecuency, BiomeDictionary.getBiomes(Type.FOREST).toArray(new Biome[0])), 0);
	}

	public static void postInitRegistries() {
		
	}
	
	public static void otherRegistries() {
		GameRegistry.registerWorldGenerator(new WorldGenCustomOreGen(), 0);
	}

}
