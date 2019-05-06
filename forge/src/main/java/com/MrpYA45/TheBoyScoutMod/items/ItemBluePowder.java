package com.MrpYA45.TheBoyScoutMod.items;

import net.minecraft.item.ItemStack;

public class ItemBluePowder extends ItemBase {

	public ItemBluePowder(String name) {
		super(name);
	}
	
    public int getItemBurnTime(ItemStack itemStack)
    {
        return 400;
    }

}
