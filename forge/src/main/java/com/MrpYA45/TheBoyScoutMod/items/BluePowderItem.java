package com.MrpYA45.TheBoyScoutMod.items;

import net.minecraft.item.ItemStack;

public class BluePowderItem extends TBSMBaseItem {

	public BluePowderItem(String name) {
		super(name);
	}
	
    public int getItemBurnTime(ItemStack itemStack)
    {
        return 400;
    }

}
