package com.MrpYA45.TheBoyScoutMod.items;

import com.MrpYA45.TheBoyScoutMod.Main;

import net.minecraft.item.ItemFood;

public class ItemCustomFood extends ItemFood {

	public ItemCustomFood(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood, new Properties().group(Main.TBSM_TAB));
		setRegistryName(name);
	}
}
