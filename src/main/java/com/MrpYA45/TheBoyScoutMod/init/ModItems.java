package com.MrpYA45.TheBoyScoutMod.init;

import java.util.List;
import java.util.ArrayList;

import com.MrpYA45.TheBoyScoutMod.items.ItemBluePowder;
import com.MrpYA45.TheBoyScoutMod.items.ItemBlueberries;
import com.MrpYA45.TheBoyScoutMod.items.ItemBlueberriesSeeds;
import com.MrpYA45.TheBoyScoutMod.items.ItemDryLeaf;
import com.MrpYA45.TheBoyScoutMod.items.ItemCustomFood;
import com.MrpYA45.TheBoyScoutMod.items.ItemCustomFoodDrink;
import com.MrpYA45.TheBoyScoutMod.items.ItemStrawberry;
import com.MrpYA45.TheBoyScoutMod.tools.ItemBlowgun;
import com.MrpYA45.TheBoyScoutMod.tools.ItemSlingshot;
import com.MrpYA45.TheBoyScoutMod.tools.ItemScoutSpadeTool;
import com.MrpYA45.TheBoyScoutMod.items.ItemBase;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {

	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//Materials
	
	public static final ToolMaterial TOOL_SCOUT = EnumHelper.addToolMaterial("tool_scout", 2, 320, 10.0F, 2.5F, 14);
	
	//Tools
	
	public static final Item SCOUT_SHOVEL = new ItemScoutSpadeTool("scout_shovel", TOOL_SCOUT);
	
	//Items
	public static final Item THE_DIARY_OF_THE_SCOUT = new ItemBase("the_diary_of_the_scout");
	public static final Item KNIFE = new ItemBase("knife");
	public static final Item BLOWGUN = new ItemBlowgun("blowgun");
	public static final Item DART = new ItemBase("dart");
	public static final Item SLINGSHOT = new ItemSlingshot("slingshot");
	public static final Item PEBBLE = new ItemBase("pebble");
	public static final Item LEAF = new ItemBase("leaf");
	public static final Item DRY_LEAF = new ItemDryLeaf("dry_leaf");
	public static final Item BACKPACK = new ItemBase("backpack", true);
	public static final Item BLUE_POWDER = new ItemBluePowder("blue_powder");
	public static final Item BLUEBERRIES_SEEDS = new ItemBlueberriesSeeds("blueberries_seeds");
	public static final Item WOOD_GOLEM_STATUETTE = new ItemBase("wood_golem_statuette", true);
	public static final Item STONE_GOLEM_STATUETTE = new ItemBase("stone_golem_statuette", true);
	public static final Item IRON_GOLEM_STATUETTE = new ItemBase("iron_golem_statuette", true);
	public static final Item GOLD_GOLEM_STATUETTE = new ItemBase("gold_golem_statuette", true);
	public static final Item DIAMOND_GOLEM_STATUETTE = new ItemBase("diamond_golem_statuette", true);
	public static final Item EMERALD_GOLEM_STATUETTE = new ItemBase("emerald_golem_statuette", true);
	public static final Item CHAINSAW = new ItemBase("chainsaw", true);
	public static final Item BREAD_SLICE = new ItemCustomFood("bread_slice",3,0.3F, false);
	public static final Item HAZELNUT = new ItemBase("hazelnut");
	public static final Item COCOA_CREAM = new ItemCustomFood("cocoa_cream", 4, 0.3F, false);
	public static final Item CHOCOLATE_SANDWICH = new ItemCustomFood("chocolate_sandwich", 5, 0.3F,false);
	public static final Item BLUEBERRIES = new ItemBlueberries("blueberries", 1, 0.2F, false);
	public static final Item FRIED_EGG = new ItemCustomFood("fried_egg", 5, 0.3F, false);	
	public static final Item CHEESE = new ItemCustomFood("cheese", 5, 0.3F,false);
	public static final Item HOT_MILK = new ItemCustomFoodDrink("hot_milk", 4, 0.3F,false);
	public static final Item CHOCOLATE_BAR = new ItemCustomFood("chocolate_bar", 6, 0.3F, false);
	public static final Item HOT_CHOCOLATE = new ItemCustomFoodDrink("hot_chocolate", 7, 0.3F, false);
	public static final Item STRAWBERRY = new ItemStrawberry("strawberry", 0, 0, false);
}
