package com.MrpYA45.TheBoyScoutMod.tools;

import java.util.function.Predicate;

import com.MrpYA45.TheBoyScoutMod.TheBoyScoutMod;
import com.MrpYA45.TheBoyScoutMod.init.ModItems;

import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;

public class ItemBlowgun extends BowItem {

	public static final Predicate<ItemStack> DART = (p_220002_0_) -> {
		return p_220002_0_.getItem() == ModItems.DART;
	};

	public ItemBlowgun(String name) {
		super(new Properties().defaultMaxDamage(128).group(TheBoyScoutMod.TBSM_TAB));
		setRegistryName(name);
//		setFull3D();
	}


	@Override
	public Predicate<ItemStack> getInventoryAmmoPredicate() {
		return DART;
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 18000;
	}
}