package com.MrpYA45.TheBoyScoutMod.util.handlers;

import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;
import com.MrpYA45.TheBoyScoutMod.init.ModItems;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RecipeHandler {
	
	public static void registerSmeltingRecipes() {
		GameRegistry.addSmelting(Items.EGG, new ItemStack(ModItems.FRIED_EGG), 0F);
		GameRegistry.addSmelting(Items.MILK_BUCKET, new ItemStack(ModItems.HOT_MILK), 0F);
		GameRegistry.addSmelting(ModBlocks.DARK_COBBLESTONE_BLOCK, new ItemStack(ModBlocks.DARK_STONE_BLOCK), 0F);
		GameRegistry.addSmelting(ModBlocks.CLEAR_COBBLESTONE_BLOCK, new ItemStack(ModBlocks.CLEAR_STONE_BLOCK), 0F);
	}

}
