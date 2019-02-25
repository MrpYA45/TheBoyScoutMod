package com.MrpYA45.TheBoyScoutMod.items;

import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemBlueberries extends ItemCustomFood {

	private boolean alwaysEdible;

	public ItemBlueberries(String name, int amount, float saturation, boolean isWolfFood) {
		super(name, amount, saturation, isWolfFood);
        this.setAlwaysEdible();
	}

    public int getMaxItemUseDuration(ItemStack stack) {
        return 12;
    }
}
