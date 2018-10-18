package com.MrpYA45.TheBoyScoutMod.tools;

import com.MrpYA45.TheBoyScoutMod.Main;
import com.MrpYA45.TheBoyScoutMod.init.ModItems;
import com.MrpYA45.TheBoyScoutMod.util.IHasModel;

import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;

public class CustomBow extends ItemBow implements IHasModel {

	public CustomBow(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tabTheBoyScoutMod);
        this.maxStackSize = 1;
        this.setMaxDamage(220);
		setFull3D();
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
    protected boolean isArrow(ItemStack stack)
    {
        return stack.getItem() instanceof ItemArrow;
    }
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}