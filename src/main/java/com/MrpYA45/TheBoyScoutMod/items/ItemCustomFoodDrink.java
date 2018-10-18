package com.MrpYA45.TheBoyScoutMod.items;

import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;

public class ItemCustomFoodDrink extends ItemCustomFood{

	public ItemCustomFoodDrink(String name, int amount, float saturation, boolean isWolfFood) {
		super(name, amount, saturation, isWolfFood);
	}
	
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.DRINK;
    }

}
