package com.MrpYA45.TheBoyScoutMod.tools;

import com.MrpYA45.TheBoyScoutMod.init.ModItems;

import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;

public class ItemSlingshot extends ItemBow {

	public ItemSlingshot(String name) {
		super(new Properties().defaultMaxDamage(384));
		setRegistryName(name);
//		setFull3D();
	}

	@Override
    protected boolean isArrow(ItemStack stack)
    {
        return stack.getItem() == ModItems.PEBBLE;
    }

	@Override
	public int getUseDuration(ItemStack stack) {
        return 54000;
    }
}