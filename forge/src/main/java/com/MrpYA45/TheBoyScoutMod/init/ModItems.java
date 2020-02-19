package com.MrpYA45.TheBoyScoutMod.init;

import com.MrpYA45.TheBoyScoutMod.TheBoyScoutMod;
import com.MrpYA45.TheBoyScoutMod.items.BluePowderItem;
import com.MrpYA45.TheBoyScoutMod.items.BlueberriesSeedsItem;
import com.MrpYA45.TheBoyScoutMod.items.DryLeafItem;
import com.MrpYA45.TheBoyScoutMod.items.StrawberryItem;
import com.MrpYA45.TheBoyScoutMod.items.TBSMBaseItem;
import com.MrpYA45.TheBoyScoutMod.items.TBSMDrinkableFoodsItem;
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

@ObjectHolder(TheBoyScoutMod.MOD_ID)
public class ModItems {

	//Items

	public static final Item THE_DIARY_OF_THE_SCOUT = new TBSMBaseItem("the_diary_of_the_scout");
	public static final Item KNIFE = new TBSMBaseItem("knife");
	public static final Item BLOWGUN = new ItemBlowgun("blowgun");
	public static final Item DART = new TBSMBaseItem("dart");
	public static final Item SLINGSHOT = new ItemSlingshot("slingshot");
	public static final Item PEBBLE = new TBSMBaseItem("pebble");
	public static final Item LEAF = new TBSMBaseItem("leaf");
	public static final Item DRY_LEAF = new DryLeafItem("dry_leaf");
	public static final Item BACKPACK = new ItemBackpack();
	public static final Item BLUE_POWDER = new BluePowderItem("blue_powder");
	public static final Item BLUEBERRIES_SEEDS = new BlueberriesSeedsItem("blueberries_seeds");
	public static final Item WOOD_GOLEM_STATUETTE = new TBSMBaseItem("wood_golem_statuette");
	public static final Item STONE_GOLEM_STATUETTE = new TBSMBaseItem("stone_golem_statuette");
	public static final Item IRON_GOLEM_STATUETTE = new TBSMBaseItem("iron_golem_statuette");
	public static final Item GOLD_GOLEM_STATUETTE = new TBSMBaseItem("gold_golem_statuette");
	public static final Item DIAMOND_GOLEM_STATUETTE = new TBSMBaseItem("diamond_golem_statuette");
	public static final Item EMERALD_GOLEM_STATUETTE = new TBSMBaseItem("emerald_golem_statuette");
	public static final Item CHAINSAW = new TBSMBaseItem("chainsaw");
	public static final Item BREAD_SLICE = new TBSMBaseItem("bread_slice", new Item.Properties().group(TheBoyScoutMod.TBSM_TAB).food(ModFoods.BREAD_SLICE));
	public static final Item HAZELNUT = new TBSMBaseItem("hazelnut");
	public static final Item COCOA_CREAM = new TBSMBaseItem("cocoa_cream", new Item.Properties().group(TheBoyScoutMod.TBSM_TAB).food(ModFoods.COCOA_CREAM));
	public static final Item CHOCOLATE_SANDWICH = new TBSMBaseItem("chocolate_sandwich", new Item.Properties().group(TheBoyScoutMod.TBSM_TAB).food(ModFoods.CHOCOLATE_SANDWICH));
	public static final Item BLUEBERRIES = new TBSMBaseItem("blueberries", new Item.Properties().group(TheBoyScoutMod.TBSM_TAB).food(ModFoods.BLUEBERRIES));
	public static final Item FRIED_EGG = new TBSMBaseItem("fried_egg", new Item.Properties().group(TheBoyScoutMod.TBSM_TAB).food(ModFoods.FRIED_EGG));	
	public static final Item CHEESE = new TBSMBaseItem("cheese", new Item.Properties().group(TheBoyScoutMod.TBSM_TAB).food(ModFoods.CHEESE));
	public static final Item HOT_MILK = new TBSMDrinkableFoodsItem("hot_milk", new Item.Properties().group(TheBoyScoutMod.TBSM_TAB).food(ModFoods.HOT_MILK));
	public static final Item CHOCOLATE_BAR = new TBSMBaseItem("chocolate_bar", new Item.Properties().group(TheBoyScoutMod.TBSM_TAB).food(ModFoods.CHOCOLATE_BAR));
	public static final Item HOT_CHOCOLATE = new TBSMDrinkableFoodsItem("hot_chocolate", new Item.Properties().group(TheBoyScoutMod.TBSM_TAB).food(ModFoods.HOT_CHOCOLATE));
	public static final Item STRAWBERRY = new StrawberryItem("strawberry", new Item.Properties().group(TheBoyScoutMod.TBSM_TAB).food(ModFoods.STRAWBERRY));

	//Tools

	public static final Item SCOUT_SHOVEL = new ItemScoutSpadeTool("scout_shovel");
	
	@Mod.EventBusSubscriber(modid = TheBoyScoutMod.MOD_ID, bus = Bus.MOD)
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
