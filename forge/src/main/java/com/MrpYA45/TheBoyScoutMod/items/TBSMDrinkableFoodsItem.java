package com.MrpYA45.TheBoyScoutMod.items;

import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;

public class TBSMDrinkableFoodsItem extends TBSMBaseItem {

	public TBSMDrinkableFoodsItem(String name, Properties prop) {
		super(name, prop);
	}

	public UseAction getItemUseAction(ItemStack stack) {
		return UseAction.DRINK;
	}

}
