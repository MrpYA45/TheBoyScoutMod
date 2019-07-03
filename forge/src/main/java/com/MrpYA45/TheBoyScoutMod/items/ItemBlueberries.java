package com.MrpYA45.TheBoyScoutMod.items;

import net.minecraft.item.ItemStack;

public class ItemBlueberries extends ItemCustomFood {

	public ItemBlueberries(String name, int amount, float saturation, boolean isWolfFood) {
		super(name, amount, saturation, isWolfFood);
		this.setAlwaysEdible();
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 12;
	}
}