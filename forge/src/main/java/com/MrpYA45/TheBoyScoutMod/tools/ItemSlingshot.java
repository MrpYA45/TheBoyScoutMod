package com.MrpYA45.TheBoyScoutMod.tools;

import java.util.function.Predicate;

import com.MrpYA45.TheBoyScoutMod.init.ModItems;

import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;

public class ItemSlingshot extends BowItem {

	public static final Predicate<ItemStack> PEBBLE = (p_220002_0_) -> {
		return p_220002_0_.getItem() == ModItems.PEBBLE;
	};

	public ItemSlingshot(String name) {
		super(new Properties().defaultMaxDamage(384));
		setRegistryName(name);
//		setFull3D();
	}

	@Override
	public Predicate<ItemStack> getInventoryAmmoPredicate() {
		return PEBBLE;
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 54000;
	}
}