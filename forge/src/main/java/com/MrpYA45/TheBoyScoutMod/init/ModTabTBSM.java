package com.MrpYA45.TheBoyScoutMod.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModTabTBSM extends ItemGroup {

	public ModTabTBSM() {
		super("tbsm");
	}

	@Override
	public ItemStack createIcon() {
		ItemStack stack = new ItemStack(ModItems.THE_DIARY_OF_THE_SCOUT);
		return stack;
	}

}
