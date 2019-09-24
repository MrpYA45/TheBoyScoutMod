package com.MrpYA45.TheBoyScoutMod.items.backpack;

import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;

public class InventoryBackpack extends InventoryBasic {

	private ItemStack stack;

	public InventoryBackpack(ItemStack stack) {
			super(new TextComponentString("backpack"), 18);
			this.stack = stack;
//			readItemStack();
		}
}