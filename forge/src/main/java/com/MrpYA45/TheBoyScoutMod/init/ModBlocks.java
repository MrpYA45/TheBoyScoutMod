package com.MrpYA45.TheBoyScoutMod.init;

import static com.MrpYA45.TheBoyScoutMod.util.InjectionUtil.Null;

import com.MrpYA45.TheBoyScoutMod.TheBoyScoutMod;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockBase;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockBluePowder;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockBlueberriesBush;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockClearGlass;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockFlowerCustom;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockGlowingClearGlass;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockHandheldLantern;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockLeavesCustom;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockLightBar;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockLogCustom;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockRocksPath;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockRope;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockShell;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockStrawberryPlant;
import com.MrpYA45.TheBoyScoutMod.blocks.boxes.BlockDiamondBox;
import com.MrpYA45.TheBoyScoutMod.blocks.boxes.BlockEmeraldBox;
import com.MrpYA45.TheBoyScoutMod.blocks.boxes.BlockGoldBox;
import com.MrpYA45.TheBoyScoutMod.blocks.boxes.BlockIronBox;
import com.MrpYA45.TheBoyScoutMod.blocks.boxes.BlockPaperBin;
import com.MrpYA45.TheBoyScoutMod.blocks.boxes.BlockWoodenBox;
import com.google.common.base.Preconditions;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(TheBoyScoutMod.MOD_ID)
public class ModBlocks {
	
	public static final BlockLogCustom HAZEL_WOOD_BLOCK = Null();
	public static final Block HAZEL_PLANKS_BLOCK = Null();
	public static final Block PALM_WOOD_BLOCK = Null();
	public static final Block PALM_PLANKS_BLOCK = Null();
	public static final Block BAOBAB_WOOD_BLOCK = Null();
	public static final Block BAOBAB_PLANKS_BLOCK = Null();
	public static final Block HAZEL_LEAVES_BLOCK = Null();
	public static final Block PALM_LEAVES_BLOCK = Null();
	public static final Block BLUE_FLOWER_BLOCK = new BlockFlowerCustom("blue_flower_block");
	public static final Block PINK_FLOWER_BLOCK = new BlockFlowerCustom("pink_flower_block");
	public static final Block ORANGE_FLOWER_BLOCK = new BlockFlowerCustom("orange_flower_block");
	public static final Block WEEDS_BLOCK = new BlockFlowerCustom("weeds_block");
	public static final Block BLUE_POWDER_GRAVEL_BLOCK = Null();
	public static final Block GREEN_CLEAR_GLASS_BLOCK = Null();
	public static final Block BLUE_CLEAR_GLASS_BLOCK = Null();
	public static final Block YELLOW_CLEAR_GLASS_BLOCK = Null();
	public static final Block RED_CLEAR_GLASS_BLOCK = Null();
	public static final Block WHITE_CLEAR_GLASS_BLOCK = Null();
	public static final Block GREEN_GLOWING_CLEAR_GLASS_BLOCK = Null();
	public static final Block BLUE_GLOWING_CLEAR_GLASS_BLOCK = Null();
	public static final Block YELLOW_GLOWING_CLEAR_GLASS_BLOCK = Null();
	public static final Block RED_GLOWING_CLEAR_GLASS_BLOCK = Null();
	public static final Block WHITE_GLOWING_CLEAR_GLASS_BLOCK = Null();
	public static final Block DARK_STONE_BLOCK = Null();
	public static final Block DARK_STONE_BRICK_BLOCK = Null();
	public static final Block DARK_COBBLESTONE_BLOCK = Null();
	public static final Block CLEAR_STONE_BLOCK = Null();
	public static final Block CLEAR_STONE_BRICK_BLOCK = Null();
	public static final Block CLEAR_COBBLESTONE_BLOCK = Null();
	public static final Block BLUEBERRIES_BUSH_BLOCK = Null();
	public static final Block WOODEN_BOX_BLOCK = Null();
	public static final Block IRON_BOX_BLOCK = Null();
	public static final Block GOLD_BOX_BLOCK = Null();
	public static final Block DIAMOND_BOX_BLOCK = Null();
	public static final Block EMERALD_BOX_BLOCK = Null();
	public static final Block PAPER_BIN_BLOCK = Null();
	public static final Block HANDHELD_LANTERN_BLOCK = Null();
	public static final Block LIGHT_BAR_BLOCK = Null();
	public static final Block STRAWBERRY_PLANT = Null();
	public static final Block ROPE_BLOCK = Null();
	public static final Block ROCKS_PATH = Null();
	public static final Block SHELL_BLOCK = Null();
	
	@Mod.EventBusSubscriber(modid = TheBoyScoutMod.MOD_ID, bus = Bus.MOD)
	public static class Register {
		
		@SubscribeEvent
		public static void registerBlock(final RegistryEvent.Register<Block> event) {
			final Block[] blocks = {
					new BlockLogCustom("hazel_wood_block"),
					new BlockBase("hazel_planks_block", Material.WOOD, 2.0F, 3.0F, SoundType.WOOD),
					new BlockLogCustom("palm_wood_block"),
					new BlockBase("palm_planks_block", Material.WOOD, 2.0F, 3.0F, SoundType.WOOD),
					new BlockLogCustom("baobab_wood_block"),
					new BlockBase("baobab_planks_block", Material.WOOD, 2.0F, 3.0F, SoundType.WOOD),
					new BlockLeavesCustom("hazel_leaves_block"),
					new BlockLeavesCustom("palm_leaves_block"),
					BLUE_FLOWER_BLOCK,
					PINK_FLOWER_BLOCK,
					ORANGE_FLOWER_BLOCK,
					WEEDS_BLOCK,
					new BlockBluePowder("blue_powder_gravel_block"),
					new BlockClearGlass("green_clear_glass_block"),
					new BlockClearGlass("blue_clear_glass_block"),
					new BlockClearGlass("yellow_clear_glass_block"),
					new BlockClearGlass("red_clear_glass_block"),
					new BlockClearGlass("white_clear_glass_block"),
					new BlockGlowingClearGlass("green_glowing_clear_glass_block"),
					new BlockGlowingClearGlass("blue_glowing_clear_glass_block"),
					new BlockGlowingClearGlass("yellow_glowing_clear_glass_block"),
					new BlockGlowingClearGlass("red_glowing_clear_glass_block"),
					new BlockGlowingClearGlass("white_glowing_clear_glass_block"),
					new BlockBase("dark_stone_block", Material.ROCK, 1.5F, 6.0F, SoundType.STONE),
					new BlockBase("dark_stone_brick_block", Material.ROCK, 1.5F, 6.0F, SoundType.STONE),
					new BlockBase("dark_cobblestone_block", Material.ROCK, 2.0F, 6.0F, SoundType.STONE),
					new BlockBase("clear_stone_block", Material.ROCK, 1.5F, 6.0F, SoundType.STONE),
					new BlockBase("clear_stone_brick_block", Material.ROCK, 1.5F, 6.0F, SoundType.STONE),
					new BlockBase("clear_cobblestone_block", Material.ROCK, 2.0F, 6.0F, SoundType.STONE),
					new BlockBlueberriesBush("blueberries_bush_block"),
					new BlockWoodenBox("wooden_box_block"),
					new BlockIronBox("iron_box_block"),
					new BlockGoldBox("gold_box_block"),
					new BlockDiamondBox("diamond_box_block"),
					new BlockEmeraldBox("emerald_box_block"),
					new BlockPaperBin("paper_bin_block"),
					new BlockHandheldLantern("handheld_lantern_block"),
					new BlockLightBar("light_bar_block"),
					new BlockStrawberryPlant("strawberry_plant"),
					new BlockRope(),
					new BlockRocksPath(),
					new BlockShell()
			};
			
			event.getRegistry().registerAll(blocks);
		}
		
		@SubscribeEvent
		public static void registerBlockItems(final RegistryEvent.Register<Item> event) {
			final BlockItem[] items = {
					new BlockItem(HAZEL_WOOD_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(HAZEL_PLANKS_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(PALM_WOOD_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(PALM_PLANKS_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(BAOBAB_WOOD_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(BAOBAB_PLANKS_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(HAZEL_LEAVES_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(PALM_LEAVES_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(BLUE_FLOWER_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(PINK_FLOWER_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(ORANGE_FLOWER_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(WEEDS_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(BLUE_POWDER_GRAVEL_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(GREEN_CLEAR_GLASS_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(BLUE_CLEAR_GLASS_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(YELLOW_CLEAR_GLASS_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(RED_CLEAR_GLASS_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(WHITE_CLEAR_GLASS_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(GREEN_GLOWING_CLEAR_GLASS_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(BLUE_GLOWING_CLEAR_GLASS_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(YELLOW_GLOWING_CLEAR_GLASS_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(RED_GLOWING_CLEAR_GLASS_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(WHITE_GLOWING_CLEAR_GLASS_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(DARK_STONE_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(DARK_STONE_BRICK_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(DARK_COBBLESTONE_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(CLEAR_STONE_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(CLEAR_STONE_BRICK_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(CLEAR_COBBLESTONE_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(BLUEBERRIES_BUSH_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(WOODEN_BOX_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(IRON_BOX_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(GOLD_BOX_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(DIAMOND_BOX_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(EMERALD_BOX_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(PAPER_BIN_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(HANDHELD_LANTERN_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(LIGHT_BAR_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(STRAWBERRY_PLANT, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(ROPE_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(ROCKS_PATH, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB)),
					new BlockItem(SHELL_BLOCK, new Item.Properties().group(TheBoyScoutMod.TBSM_TAB))
			};
			
			for(final BlockItem item : items) {
				final Block block = item.getBlock();
				final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has a null registry name", block);
				event.getRegistry().register(item.setRegistryName(registryName));
			}
			
			registerTileEntities();
		}
		
		private static void registerTileEntities() {
			
		}
	}
	
}
