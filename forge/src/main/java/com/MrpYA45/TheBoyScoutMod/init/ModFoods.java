package com.MrpYA45.TheBoyScoutMod.init;

import net.minecraft.item.Food;

public class ModFoods {

	public static final Food BREAD_SLICE = (new Food.Builder()).hunger(3).saturation(0.3F).build();
	public static final Food COCOA_CREAM = (new Food.Builder()).hunger(4).saturation(0.3F).build();
	public static final Food CHOCOLATE_SANDWICH = (new Food.Builder()).hunger(5).saturation(0.3F).build();
	public static final Food BLUEBERRIES = (new Food.Builder()).hunger(1).saturation(0.2F).fastToEat().setAlwaysEdible().build();
	public static final Food FRIED_EGG = (new Food.Builder()).hunger(5).saturation(0.3F).build();
	public static final Food CHEESE = (new Food.Builder()).hunger(4).saturation(0.3F).build();
	public static final Food HOT_MILK = (new Food.Builder()).hunger(3).saturation(0.3F).build();
	public static final Food CHOCOLATE_BAR = (new Food.Builder()).hunger(6).saturation(0.3F).build();
	public static final Food HOT_CHOCOLATE = (new Food.Builder()).hunger(7).saturation(0.3F).build();
	public static final Food STRAWBERRY = (new Food.Builder()).hunger(4).saturation(0.3F).build();

}
