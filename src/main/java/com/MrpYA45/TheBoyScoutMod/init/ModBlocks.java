package com.MrpYA45.TheBoyScoutMod.init;

import java.util.ArrayList;
import java.util.List;

import com.MrpYA45.TheBoyScoutMod.blocks.BlockBase;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockBlueberriesBush;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockClearGlass;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockBluePowder;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockFlowerCustom;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockLeavesCustom;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockLogCustom;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockFullBlueberriesBush;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockGlowingClearGlass;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockHandheldLantern;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockHandheldLanternOn;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockLightBar;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockRope;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockStrawberryPlant;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.diamond_box.BlockDiamondBox;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.emerald_box.BlockEmeraldBox;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.gold_box.BlockGoldBox;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.iron_box.BlockIronBox;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.paper_bin.BlockPaperBin;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.wooden_box.BlockWoodenBox;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class ModBlocks {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block HAZEL_WOOD_BLOCK = new BlockLogCustom("hazel_wood_block");
	public static final Block HAZEL_PLANKS_BLOCK = new BlockBase("hazel_planks_block", Material.WOOD, 2.0F, 15.0F, SoundType.WOOD);
	public static final Block PALM_WOOD_BLOCK = new BlockLogCustom("palm_wood_block");
	public static final Block PALM_PLANKS_BLOCK = new BlockBase("palm_planks_block", Material.WOOD, 2.0F, 15.0F, SoundType.WOOD);
	public static final Block BAOBAB_WOOD_BLOCK = new BlockLogCustom("baobab_wood_block");
	public static final Block BAOBAB_PLANKS_BLOCK = new BlockBase("baobab_planks_block", Material.WOOD, 2.0F, 15.0F, SoundType.WOOD);
	public static final Block HAZEL_LEAVES_BLOCK = new BlockLeavesCustom("hazel_leaves_block");
	public static final Block PALM_LEAVES_BLOCK = new BlockLeavesCustom("palm_leaves_block");
	public static final Block BLUE_FLOWER_BLOCK = new BlockFlowerCustom("blue_flower_block");
	public static final Block PINK_FLOWER_BLOCK = new BlockFlowerCustom("pink_flower_block");
	public static final Block ORANGE_FLOWER_BLOCK = new BlockFlowerCustom("orange_flower_block");
	public static final Block WEEDS_BLOCK = new BlockFlowerCustom("weeds_block");
	public static final Block BLUE_POWDER_GRAVEL_BLOCK = new BlockBluePowder("blue_powder_gravel_block", Material.SAND);
	public static final Block GREEN_CLEAR_GLASS_BLOCK = new BlockClearGlass("green_clear_glass_block", Material.GLASS, 0.3F, 1.5F, SoundType.GLASS);
	public static final Block BLUE_CLEAR_GLASS_BLOCK = new BlockClearGlass("blue_clear_glass_block", Material.GLASS, 0.3F, 1.5F, SoundType.GLASS);
	public static final Block YELLOW_CLEAR_GLASS_BLOCK = new BlockClearGlass("yellow_clear_glass_block", Material.GLASS, 0.3F, 1.5F, SoundType.GLASS);
	public static final Block RED_CLEAR_GLASS_BLOCK = new BlockClearGlass("red_clear_glass_block", Material.GLASS, 0.3F, 1.5F, SoundType.GLASS);
	public static final Block WHITE_CLEAR_GLASS_BLOCK = new BlockClearGlass("white_clear_glass_block", Material.GLASS, 0.3F, 1.5F, SoundType.GLASS);
	public static final Block GREEN_GLOWING_CLEAR_GLASS_BLOCK = new BlockGlowingClearGlass("green_glowing_clear_glass_block", Material.GLASS, 0.3F, 1.5F, SoundType.GLASS);
	public static final Block BLUE_GLOWING_CLEAR_GLASS_BLOCK = new BlockGlowingClearGlass("blue_glowing_clear_glass_block", Material.GLASS, 0.3F, 1.5F, SoundType.GLASS);
	public static final Block YELLOW_GLOWING_GLASS_BLOCK = new BlockGlowingClearGlass("yellow_glowing_clear_glass_block", Material.GLASS, 0.3F, 1.5F, SoundType.GLASS);
	public static final Block RED_GLOWING_GLASS_BLOCK = new BlockGlowingClearGlass("red_glowing_clear_glass_block", Material.GLASS, 0.3F, 1.5F, SoundType.GLASS);
	public static final Block WHITE_GLOWING_GLASS_BLOCK = new BlockGlowingClearGlass("white_glowing_clear_glass_block", Material.GLASS, 0.3F, 1.5F, SoundType.GLASS);
	public static final Block DARK_STONE_BLOCK = new BlockBase("dark_stone_block", Material.ROCK, 1.5F, 30.0F, SoundType.STONE);
	public static final Block DARK_STONE_BRICK_BLOCK = new BlockBase("dark_stone_brick_block", Material.ROCK, 1.5F, 30.0F, SoundType.STONE);
	public static final Block DARK_COBBLESTONE_BLOCK = new BlockBase("dark_cobblestone_block", Material.ROCK, 2.0F, 30.0F, SoundType.STONE);
	public static final Block CLEAR_STONE_BLOCK = new BlockBase("clear_stone_block", Material.ROCK, 1.5F, 30.0F, SoundType.STONE);
	public static final Block CLEAR_STONE_BRICK_BLOCK = new BlockBase("clear_stone_brick_block", Material.ROCK, 1.5F, 30.0F, SoundType.STONE);
	public static final Block CLEAR_COBBLESTONE_BLOCK = new BlockBase("clear_cobblestone_block", Material.ROCK, 2.0F, 30.0F, SoundType.STONE);
	public static final Block BLUEBERRIES_BUSH_BLOCK = new BlockBlueberriesBush("blueberries_bush_block", Material.LEAVES);
	public static final Block FULL_BLUEBERRIES_BUSH_BLOCK = new BlockFullBlueberriesBush("full_blueberries_bush_block", Material.LEAVES);
	public static final Block WOODEN_BOX_BLOCK = new BlockWoodenBox("wooden_box_block");
	public static final Block IRON_BOX_BLOCK = new BlockIronBox("iron_box_block");
	public static final Block GOLD_BOX_BLOCK = new BlockGoldBox("gold_box_block");
	public static final Block DIAMOND_BOX_BLOCK = new BlockDiamondBox("diamond_box_block");
	public static final Block EMERALD_BOX_BLOCK = new BlockEmeraldBox("emerald_box_block");
	public static final Block PAPER_BIN_BLOCK = new BlockPaperBin("paper_bin_block", Material.IRON, 2.0F, 30.0F, SoundType.METAL);
	public static final Block HANDHELD_LANTERN_BLOCK = new BlockHandheldLantern("handheld_lantern_block", Material.WOOD, 2.0F, 15.0F, SoundType.WOOD);
	public static final Block HANDHELD_LANTERN_ON_BLOCK = new BlockHandheldLanternOn("handheld_lantern_on_block", Material.WOOD, 2.0F, 15.0F, SoundType.WOOD);
	public static final Block LIGHT_BAR_BLOCK = new BlockLightBar("light_bar_block", Material.WOOD, 2.0F, 15.0F, SoundType.WOOD);
	public static final Block STRAWBERRY_PLANT = new BlockStrawberryPlant("strawberry_plant");
	public static final Block ROPE_BLOCK = new BlockRope();
}
