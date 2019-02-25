package com.MrpYA45.TheBoyScoutMod.tools;

import com.MrpYA45.TheBoyScoutMod.Main;
import com.MrpYA45.TheBoyScoutMod.init.ModItems;
import com.MrpYA45.TheBoyScoutMod.util.IHasModel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

public class ItemSlingshot extends ItemBow implements IHasModel {

	public ItemSlingshot(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tabTheBoyScoutMod);
        //this.maxStackSize = 1;
        this.setMaxDamage(384);
		setFull3D();
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
    protected boolean isArrow(ItemStack stack)
    {
        return stack.getItem() == ModItems.PEBBLE;
    }

    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 54000;
    }
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}