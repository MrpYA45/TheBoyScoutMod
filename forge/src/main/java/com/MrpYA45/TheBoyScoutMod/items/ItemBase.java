package com.MrpYA45.TheBoyScoutMod.items;

import java.util.List;

import com.MrpYA45.TheBoyScoutMod.Main;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemBase extends Item {
	
	public ItemBase(String name) {
		super(new Properties().maxStackSize(62).group(Main.TBSM_TAB));
		this.setRegistryName(name);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new TextComponentString(TextFormatting.RED + "WIP"));
	}

}
