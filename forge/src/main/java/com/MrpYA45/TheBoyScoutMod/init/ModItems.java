package com.MrpYA45.TheBoyScoutMod.init;

import com.MrpYA45.TheBoyScoutMod.Main;
import com.MrpYA45.TheBoyScoutMod.items.ItemBase;
import com.MrpYA45.TheBoyScoutMod.items.ItemBluePowder;
import com.MrpYA45.TheBoyScoutMod.items.ItemBlueberries;
import com.MrpYA45.TheBoyScoutMod.items.ItemBlueberriesSeeds;
import com.MrpYA45.TheBoyScoutMod.items.ItemCustomFood;
import com.MrpYA45.TheBoyScoutMod.items.ItemCustomFoodDrink;
import com.MrpYA45.TheBoyScoutMod.items.ItemDryLeaf;
import com.MrpYA45.TheBoyScoutMod.items.ItemStrawberry;
import com.MrpYA45.TheBoyScoutMod.items.backpack.ItemBackpack;
import com.MrpYA45.TheBoyScoutMod.tools.ItemBlowgun;
import com.MrpYA45.TheBoyScoutMod.tools.ItemScoutSpadeTool;
import com.MrpYA45.TheBoyScoutMod.tools.ItemSlingshot;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Main.MOD_ID)
public class ModItems {

	//Items

	public static final Item THE_DIARY_OF_THE_SCOUT = new ItemBase("the_diary_of_the_scout");
	public static final Item KNIFE = new ItemBase("knife");
	public static final Item BLOWGUN = new ItemBlowgun("blowgun");
	public static final Item DART = new ItemBase("dart");
	public static final Item SLINGSHOT = new ItemSlingshot("slingshot");
	public static final Item PEBBLE = new ItemBase("pebble");
	public static final Item LEAF = new ItemBase("leaf");
	public static final Item DRY_LEAF = new ItemDryLeaf("dry_leaf");
	public static final Item BACKPACK = new ItemBackpack();
	public static final Item BLUE_POWDER = new ItemBluePowder("blue_powder");
	public static final Item BLUEBERRIES_SEEDS = new ItemBlueberriesSeeds("blueberries_seeds");
	public static final Item WOOD_GOLEM_STATUETTE = new ItemBase("wood_golem_statuette");
	public static final Item STONE_GOLEM_STATUETTE = new ItemBase("stone_golem_statuette");
	public static final Item IRON_GOLEM_STATUETTE = new ItemBase("iron_golem_statuette");
	public static final Item GOLD_GOLEM_STATUETTE = new ItemBase("gold_golem_statuette");
	public static final Item DIAMOND_GOLEM_STATUETTE = new ItemBase("diamond_golem_statuette");
	public static final Item EMERALD_GOLEM_STATUETTE = new ItemBase("emerald_golem_statuette");
	public static final Item CHAINSAW = new ItemBase("chainsaw");
	public static final Item BREAD_SLICE = new ItemCustomFood("bread_slice",3,0.3F, false);
	public static final Item HAZELNUT = new ItemBase("hazelnut");
	public static final Item COCOA_CREAM = new ItemCustomFood("cocoa_cream", 4, 0.3F, false);
	public static final Item CHOCOLATE_SANDWICH = new ItemCustomFood("chocolate_sandwich", 5, 0.3F,false);
	public static final Item BLUEBERRIES = new ItemBlueberries("blueberries", 1, 0.2F, false);
	public static final Item FRIED_EGG = new ItemCustomFood("fried_egg", 5, 0.3F, false);	
	public static final Item CHEESE = new ItemCustomFood("cheese", 4, 0.3F,false);
	public static final Item HOT_MILK = new ItemCustomFoodDrink("hot_milk", 3, 0.3F,false);
	public static final Item CHOCOLATE_BAR = new ItemCustomFood("chocolate_bar", 6, 0.3F, false);
	public static final Item HOT_CHOCOLATE = new ItemCustomFoodDrink("hot_chocolate", 7, 0.3F, false);
	public static final Item STRAWBERRY = new ItemStrawberry("strawberry", 4, 0.3F, false);

	//Tools

	public static final Item SCOUT_SHOVEL = new ItemScoutSpadeTool("scout_shovel");
	
	@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Bus.MOD)
	public static class Register {
		
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			final Item[] item = {
				THE_DIARY_OF_THE_SCOUT,
				KNIFE,
				BLOWGUN,
				DART,
				SLINGSHOT,
				PEBBLE,
				LEAF,
				DRY_LEAF,
				BACKPACK,
				BLUE_POWDER,
				BLUEBERRIES_SEEDS,
				WOOD_GOLEM_STATUETTE,
				STONE_GOLEM_STATUETTE,
				IRON_GOLEM_STATUETTE,
				GOLD_GOLEM_STATUETTE,
				DIAMOND_GOLEM_STATUETTE,
				EMERALD_GOLEM_STATUETTE,
				CHAINSAW,
				BREAD_SLICE,
				HAZELNUT,
				COCOA_CREAM,
				CHOCOLATE_SANDWICH,
				BLUEBERRIES,
				FRIED_EGG,
				CHEESE,
				HOT_MILK,
				CHOCOLATE_BAR,
				HOT_CHOCOLATE,
				STRAWBERRY,
				SCOUT_SHOVEL
			};
			
			event.getRegistry().registerAll(item);
		}
		
	}
//	//Materials
//	
//	public static final ToolMaterial TOOL_SCOUT = EnumHelper.addToolMaterial("tool_scout", 2, 320, 10.0F, 2.5F, 14);

}