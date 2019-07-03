package com.MrpYA45.TheBoyScoutMod.tools;

import com.MrpYA45.TheBoyScoutMod.init.ModItems;

import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;

public class ItemBlowgun extends ItemBow {

	public ItemBlowgun(String name) {
		super(new Properties().defaultMaxDamage(128));
		setRegistryName(name);
//		setFull3D();
	}
	
	@Override
    protected boolean isArrow(ItemStack stack)
    {
        return stack.getItem() ==  ModItems.DART;
    }
	@Override
	public int getUseDuration(ItemStack stack) {
        return 18000;
    }
}