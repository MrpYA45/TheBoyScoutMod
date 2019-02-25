package com.MrpYA45.TheBoyScoutMod.tools;

import com.MrpYA45.TheBoyScoutMod.Main;
import com.MrpYA45.TheBoyScoutMod.init.ModItems;
import com.MrpYA45.TheBoyScoutMod.util.IHasModel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

public class ItemBlowgun extends ItemBow implements IHasModel {

	public ItemBlowgun(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tabTheBoyScoutMod);
        //this.maxStackSize = 1;
        this.setMaxDamage(128);
		setFull3D();
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
    protected boolean isArrow(ItemStack stack)
    {
        return stack.getItem() ==  ModItems.DART;
    }
	
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 18000;
    }
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}