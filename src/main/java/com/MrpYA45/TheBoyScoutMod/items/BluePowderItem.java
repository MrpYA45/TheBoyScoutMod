package com.MrpYA45.TheBoyScoutMod.items;

import com.MrpYA45.TheBoyScoutMod.Main;
import com.MrpYA45.TheBoyScoutMod.init.ModItems;
import com.MrpYA45.TheBoyScoutMod.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BluePowderItem extends ItemBase implements IHasModel {

	public BluePowderItem(String name) {
		super(name);
	}
	
    public int getItemBurnTime(ItemStack itemStack)
    {
        return 400;
    }
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
