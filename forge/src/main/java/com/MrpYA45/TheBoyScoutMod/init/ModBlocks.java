package com.MrpYA45.TheBoyScoutMod.init;

import static com.MrpYA45.TheBoyScoutMod.util.InjectionUtil.Null;

import com.MrpYA45.TheBoyScoutMod.Main;
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
import com.MrpYA45.TheBoyScoutMod.blocks.BlockStrawberryPlant;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.paper_bin.BlockPaperBin;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.wooden_box.BlockWoodenBox;
import com.google.common.base.Preconditions;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(Main.MOD_ID)
public class ModBlocks {
	
	public static final BlockLogCustom HAZEL_WOOD_BLOCK = Null();
	public static final Block HAZEL_PLANKS_BLOCK = Null();
	public static final Block PALM_WOOD_BLOCK = Null();
	public static final Block PALM_PLANKS_BLOCK = Null();
	public static final Block BAOBAB_WOOD_BLOCK = Null();
	public static final Block BAOBAB_PLANKS_BLOCK = Null();
	public static final Block HAZEL_LEAVES_BLOCK = Null();
	public static final Block PALM_LEAVES_BLOCK = new BlockLeavesCustom("palm_leaves_block");
	public static final Block BLUE_FLOWER_BLOCK = new BlockFlowerCustom("blue_flower_block");
	public static final Block PINK_FLOWER_BLOCK = new BlockFlowerCustom("pink_flower_block");
	public static final Block ORANGE_FLOWER_BLOCK = new BlockFlowerCustom("orange_flower_block");
	public static final Block WEEDS_BLOCK = new BlockFlowerCustom("weeds_block");
	public static final Block BLUE_POWDER_GRAVEL_BLOCK = new BlockBluePowder("blue_powder_gravel_block");
	public static final Block GREEN_CLEAR_GLASS_BLOCK = new BlockClearGlass("green_clear_glass_block");
	public static final Block BLUE_CLEAR_GLASS_BLOCK = new BlockClearGlass("blue_clear_glass_block");
	public static final Block YELLOW_CLEAR_GLASS_BLOCK = new BlockClearGlass("yellow_clear_glass_block");
	public static final Block RED_CLEAR_GLASS_BLOCK = new BlockClearGlass("red_clear_glass_block");
	public static final Block WHITE_CLEAR_GLASS_BLOCK = new BlockClearGlass("white_clear_glass_block");
	public static final Block GREEN_GLOWING_CLEAR_GLASS_BLOCK = new BlockGlowingClearGlass("green_glowing_clear_glass_block");
	public static final Block BLUE_GLOWING_CLEAR_GLASS_BLOCK = new BlockGlowingClearGlass("blue_glowing_clear_glass_block");
	public static final Block YELLOW_GLOWING_CLEAR_GLASS_BLOCK = new BlockGlowingClearGlass("yellow_glowing_clear_glass_block");
	public static final Block RED_GLOWING_CLEAR_GLASS_BLOCK = new BlockGlowingClearGlass("red_glowing_clear_glass_block");
	public static final Block WHITE_GLOWING_CLEAR_GLASS_BLOCK = new BlockGlowingClearGlass("white_glowing_clear_glass_block");
	public static final Block DARK_STONE_BLOCK = new BlockBase("dark_stone_block", Material.ROCK, 1.5F, 6.0F, SoundType.STONE);
	public static final Block DARK_STONE_BRICK_BLOCK = new BlockBase("dark_stone_brick_block", Material.ROCK, 1.5F, 6.0F, SoundType.STONE);
	public static final Block DARK_COBBLESTONE_BLOCK = new BlockBase("dark_cobblestone_block", Material.ROCK, 2.0F, 6.0F, SoundType.STONE);
	public static final Block CLEAR_STONE_BLOCK = new BlockBase("clear_stone_block", Material.ROCK, 1.5F, 6.0F, SoundType.STONE);
	public static final Block CLEAR_STONE_BRICK_BLOCK = new BlockBase("clear_stone_brick_block", Material.ROCK, 1.5F, 6.0F, SoundType.STONE);
	public static final Block CLEAR_COBBLESTONE_BLOCK = new BlockBase("clear_cobblestone_block", Material.ROCK, 2.0F, 6.0F, SoundType.STONE);
	public static final Block BLUEBERRIES_BUSH_BLOCK = new BlockBlueberriesBush("blueberries_bush_block");
	public static final Block WOODEN_BOX_BLOCK = Null();
//	public static final Block IRON_BOX_BLOCK = new BlockIronBox("iron_box_block");
//	public static final Block GOLD_BOX_BLOCK = new BlockGoldBox("gold_box_block");
//	public static final Block DIAMOND_BOX_BLOCK = new BlockDiamondBox("diamond_box_block");
//	public static final Block EMERALD_BOX_BLOCK = new BlockEmeraldBox("emerald_box_block");
	public static final Block PAPER_BIN_BLOCK = new BlockPaperBin("paper_bin_block");
	public static final Block HANDHELD_LANTERN_BLOCK = new BlockHandheldLantern("handheld_lantern_block");
	public static final Block LIGHT_BAR_BLOCK = new BlockLightBar("light_bar_block");
	public static final Block STRAWBERRY_PLANT = new BlockStrawberryPlant("strawberry_plant");
	public static final Block ROPE_BLOCK = new BlockRope();
	public static final Block ROCKS_PATH = new BlockRocksPath();
	
	@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Bus.MOD)
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
					PALM_LEAVES_BLOCK,
					BLUE_FLOWER_BLOCK,
					PINK_FLOWER_BLOCK,
					ORANGE_FLOWER_BLOCK,
					WEEDS_BLOCK,
					BLUE_POWDER_GRAVEL_BLOCK,
					GREEN_CLEAR_GLASS_BLOCK,
					BLUE_CLEAR_GLASS_BLOCK,
					YELLOW_CLEAR_GLASS_BLOCK,
					RED_CLEAR_GLASS_BLOCK,
					WHITE_CLEAR_GLASS_BLOCK,
					GREEN_GLOWING_CLEAR_GLASS_BLOCK,
					BLUE_GLOWING_CLEAR_GLASS_BLOCK,
					YELLOW_GLOWING_CLEAR_GLASS_BLOCK,
					RED_GLOWING_CLEAR_GLASS_BLOCK,
					WHITE_GLOWING_CLEAR_GLASS_BLOCK,
					DARK_STONE_BLOCK,
					DARK_STONE_BRICK_BLOCK,
					DARK_COBBLESTONE_BLOCK,
					CLEAR_STONE_BLOCK,
					CLEAR_STONE_BRICK_BLOCK,
					CLEAR_COBBLESTONE_BLOCK,
					BLUEBERRIES_BUSH_BLOCK,
					new BlockWoodenBox("wooden_box_block"),
					
					PAPER_BIN_BLOCK,
					HANDHELD_LANTERN_BLOCK,
					LIGHT_BAR_BLOCK,
					STRAWBERRY_PLANT,
					ROPE_BLOCK,
					ROCKS_PATH
			};
			
			event.getRegistry().registerAll(blocks);
		}
		
		@SubscribeEvent
		public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
			final ItemBlock[] items = {
					new ItemBlock(HAZEL_WOOD_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(HAZEL_PLANKS_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(PALM_WOOD_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(PALM_PLANKS_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(BAOBAB_WOOD_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(BAOBAB_PLANKS_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(HAZEL_LEAVES_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(PALM_LEAVES_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(BLUE_FLOWER_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(PINK_FLOWER_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(ORANGE_FLOWER_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(WEEDS_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(BLUE_POWDER_GRAVEL_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(GREEN_CLEAR_GLASS_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(BLUE_CLEAR_GLASS_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(YELLOW_CLEAR_GLASS_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(RED_CLEAR_GLASS_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(WHITE_CLEAR_GLASS_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(GREEN_GLOWING_CLEAR_GLASS_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(BLUE_GLOWING_CLEAR_GLASS_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(YELLOW_GLOWING_CLEAR_GLASS_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(RED_GLOWING_CLEAR_GLASS_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(WHITE_GLOWING_CLEAR_GLASS_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(DARK_STONE_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(DARK_STONE_BRICK_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(DARK_COBBLESTONE_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(CLEAR_STONE_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(CLEAR_STONE_BRICK_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(CLEAR_COBBLESTONE_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(BLUEBERRIES_BUSH_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(WOODEN_BOX_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					
					new ItemBlock(PAPER_BIN_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(HANDHELD_LANTERN_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(LIGHT_BAR_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(STRAWBERRY_PLANT, new Item.Properties()),
					new ItemBlock(ROPE_BLOCK, new Item.Properties().group(Main.TBSM_TAB)),
					new ItemBlock(ROCKS_PATH, new Item.Properties().group(Main.TBSM_TAB))
					
			};
			
			for(final ItemBlock item : items) {
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
