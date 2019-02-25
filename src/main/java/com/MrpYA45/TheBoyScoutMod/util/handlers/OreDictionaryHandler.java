package com.MrpYA45.TheBoyScoutMod.util.handlers;

import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;

import net.minecraft.init.Blocks;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryHandler {
	
	public static void registerOreDictionary() {
		OreDictionary.registerOre("logWood", ModBlocks.HAZEL_WOOD_BLOCK);
		OreDictionary.registerOre("logWood", ModBlocks.PALM_WOOD_BLOCK);
		OreDictionary.registerOre("logWood", ModBlocks.BAOBAB_WOOD_BLOCK);
		OreDictionary.registerOre("plankWood", ModBlocks.HAZEL_PLANKS_BLOCK);
		OreDictionary.registerOre("plankWood", ModBlocks.PALM_PLANKS_BLOCK);
		OreDictionary.registerOre("plankWood", ModBlocks.BAOBAB_PLANKS_BLOCK);
		OreDictionary.registerOre("treeLeaves", ModBlocks.HAZEL_LEAVES_BLOCK);
		OreDictionary.registerOre("treeLeaves", ModBlocks.PALM_LEAVES_BLOCK);
		OreDictionary.registerOre("stone", ModBlocks.CLEAR_STONE_BLOCK);
		OreDictionary.registerOre("stone", ModBlocks.DARK_STONE_BLOCK);
		OreDictionary.registerOre("cobblestone", ModBlocks.CLEAR_COBBLESTONE_BLOCK);
		OreDictionary.registerOre("cobblestone", ModBlocks.DARK_COBBLESTONE_BLOCK);
		OreDictionary.registerOre("stonebrick", ModBlocks.CLEAR_STONE_BRICK_BLOCK);
		OreDictionary.registerOre("stonebrick", ModBlocks.DARK_STONE_BRICK_BLOCK);
		OreDictionary.registerOre("blockWool", Blocks.WOOL);
	}

}