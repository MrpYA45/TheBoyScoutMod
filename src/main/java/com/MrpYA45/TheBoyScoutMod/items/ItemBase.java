package com.MrpYA45.TheBoyScoutMod.items;

import java.util.List;

import com.MrpYA45.TheBoyScoutMod.Main;
import com.MrpYA45.TheBoyScoutMod.init.ModItems;
import com.MrpYA45.TheBoyScoutMod.util.IHasModel;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemBase extends Item implements IHasModel {

	private Boolean ItemWIPLore = false;
	
	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tabTheBoyScoutMod);
		
		ModItems.ITEMS.add(this);
	}
	
	public ItemBase(String name, Boolean WIP) {
		this(name);
		ItemWIPLore = true;
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		if(ItemWIPLore) {
			tooltip.add(TextFormatting.RED + "WIP");
		} else {
			super.addInformation(stack, worldIn, tooltip, flagIn);
		}
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
