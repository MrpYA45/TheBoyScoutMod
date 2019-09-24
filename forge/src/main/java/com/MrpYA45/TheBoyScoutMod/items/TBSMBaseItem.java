package com.MrpYA45.TheBoyScoutMod.items;

import java.util.List;

import com.MrpYA45.TheBoyScoutMod.Main;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class TBSMBaseItem extends Item {
	
	public TBSMBaseItem(String name) {
		super(new Properties().group(Main.TBSM_TAB));
		this.setRegistryName(name);
	}
	public TBSMBaseItem(String name, Properties prop) {
		super(prop);
		this.setRegistryName(name);
	}

	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		tooltip.add(new StringTextComponent(TextFormatting.RED + "WIP"));
	}

}
