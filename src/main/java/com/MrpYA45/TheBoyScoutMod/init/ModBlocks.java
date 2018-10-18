package com.MrpYA45.TheBoyScoutMod.init;

import java.util.ArrayList;
import java.util.List;

import com.MrpYA45.TheBoyScoutMod.blocks.BlockBase;
import com.MrpYA45.TheBoyScoutMod.blocks.BlueberriesBushBlock;
import com.MrpYA45.TheBoyScoutMod.blocks.ClearGlassBlocks;
import com.MrpYA45.TheBoyScoutMod.blocks.CustomFallingBlock;
import com.MrpYA45.TheBoyScoutMod.blocks.CustomFlowerBlock;
import com.MrpYA45.TheBoyScoutMod.blocks.CustomLeavesBlock;
import com.MrpYA45.TheBoyScoutMod.blocks.CustomLogBlock;
import com.MrpYA45.TheBoyScoutMod.blocks.FullBlueberriesBushBlock;
import com.MrpYA45.TheBoyScoutMod.blocks.GlowingClearGlassBlocks;
import com.MrpYA45.TheBoyScoutMod.blocks.HandheldLanternBlock;
import com.MrpYA45.TheBoyScoutMod.blocks.HandheldLanternOnBlock;
import com.MrpYA45.TheBoyScoutMod.blocks.LightBarBlock;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.diamond_box.DiamondBoxBlock;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.emerald_box.EmeraldBoxBlock;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.gold_box.GoldBoxBlock;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.iron_box.IronBoxBlock;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.paper_bin.PaperBinBlock;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.wooden_box.WoodenBoxBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class ModBlocks {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block HAZEL_WOOD_BLOCK = new CustomLogBlock("hazel_wood_block");
	public static final Block HAZEL_PLANKS_BLOCK = new BlockBase("hazel_planks_block", Material.WOOD, 2.0F, 15.0F, SoundType.WOOD);
	public static final Block PALM_WOOD_BLOCK = new CustomLogBlock("palm_wood_block");
	public static final Block PALM_PLANKS_BLOCK = new BlockBase("palm_planks_block", Material.WOOD, 2.0F, 15.0F, SoundType.WOOD);
	public static final Block BAOBAB_WOOD_BLOCK = new CustomLogBlock("baobab_wood_block");
	public static final Block BAOBAB_PLANKS_BLOCK = new BlockBase("baobab_planks_block", Material.WOOD, 2.0F, 15.0F, SoundType.WOOD);
	public static final Block HAZEL_LEAVES_BLOCK = new CustomLeavesBlock("hazel_leaves_block");
	public static final Block PALM_LEAVES_BLOCK = new CustomLeavesBlock("palm_leaves_block");
	public static final Block BLUE_FLOWER_BLOCK = new CustomFlowerBlock("blue_flower_block");
	public static final Block PINK_FLOWER_BLOCK = new CustomFlowerBlock("pink_flower_block");
	public static final Block ORANGE_FLOWER_BLOCK = new CustomFlowerBlock("orange_flower_block");
	public static final Block WEEDS_BLOCK = new CustomFlowerBlock("weeds_block");
	public static final Block BLUE_POWDER_GRAVEL_BLOCK = new CustomFallingBlock("blue_powder_gravel_block", Material.SAND);
	public static final Block GREEN_CLEAR_GLASS_BLOCK = new ClearGlassBlocks("green_clear_glass_block", Material.GLASS, 0.3F, 1.5F, SoundType.GLASS);
	public static final Block BLUE_CLEAR_GLASS_BLOCK = new ClearGlassBlocks("blue_clear_glass_block", Material.GLASS, 0.3F, 1.5F, SoundType.GLASS);
	public static final Block YELLOW_CLEAR_GLASS_BLOCK = new ClearGlassBlocks("yellow_clear_glass_block", Material.GLASS, 0.3F, 1.5F, SoundType.GLASS);
	public static final Block RED_CLEAR_GLASS_BLOCK = new ClearGlassBlocks("red_clear_glass_block", Material.GLASS, 0.3F, 1.5F, SoundType.GLASS);
	public static final Block WHITE_CLEAR_GLASS_BLOCK = new ClearGlassBlocks("white_clear_glass_block", Material.GLASS, 0.3F, 1.5F, SoundType.GLASS);
	public static final Block GREEN_GLOWING_CLEAR_GLASS_BLOCK = new GlowingClearGlassBlocks("green_glowing_clear_glass_block", Material.GLASS, 0.3F, 1.5F, SoundType.GLASS);
	public static final Block BLUE_GLOWING_CLEAR_GLASS_BLOCK = new GlowingClearGlassBlocks("blue_glowing_clear_glass_block", Material.GLASS, 0.3F, 1.5F, SoundType.GLASS);
	public static final Block YELLOW_GLOWING_GLASS_BLOCK = new GlowingClearGlassBlocks("yellow_glowing_clear_glass_block", Material.GLASS, 0.3F, 1.5F, SoundType.GLASS);
	public static final Block RED_GLOWING_GLASS_BLOCK = new GlowingClearGlassBlocks("red_glowing_clear_glass_block", Material.GLASS, 0.3F, 1.5F, SoundType.GLASS);
	public static final Block WHITE_GLOWING_GLASS_BLOCK = new GlowingClearGlassBlocks("white_glowing_clear_glass_block", Material.GLASS, 0.3F, 1.5F, SoundType.GLASS);
	public static final Block DARK_STONE_BLOCK = new BlockBase("dark_stone_block", Material.ROCK, 1.5F, 30.0F, SoundType.STONE);
	public static final Block DARK_STONE_BRICK_BLOCK = new BlockBase("dark_stone_brick_block", Material.ROCK, 1.5F, 30.0F, SoundType.STONE);
	public static final Block DARK_COBBLESTONE_BLOCK = new BlockBase("dark_cobblestone_block", Material.ROCK, 2.0F, 30.0F, SoundType.STONE);
	public static final Block CLEAR_STONE_BLOCK = new BlockBase("clear_stone_block", Material.ROCK, 1.5F, 30.0F, SoundType.STONE);
	public static final Block CLEAR_STONE_BRICK_BLOCK = new BlockBase("clear_stone_brick_block", Material.ROCK, 1.5F, 30.0F, SoundType.STONE);
	public static final Block CLEAR_COBBLESTONE_BLOCK = new BlockBase("clear_cobblestone_block", Material.ROCK, 2.0F, 30.0F, SoundType.STONE);
	public static final Block BLUEBERRIES_BUSH_BLOCK = new BlueberriesBushBlock("blueberries_bush_block", Material.LEAVES);
	public static final Block FULL_BLUEBERRIES_BUSH_BLOCK = new FullBlueberriesBushBlock("full_blueberries_bush_block", Material.LEAVES);
	public static final Block WOODEN_BOX_BLOCK = new WoodenBoxBlock("wooden_box_block");
	public static final Block IRON_BOX_BLOCK = new IronBoxBlock("iron_box_block");
	public static final Block GOLD_BOX_BLOCK = new GoldBoxBlock("gold_box_block");
	public static final Block DIAMOND_BOX_BLOCK = new DiamondBoxBlock("diamond_box_block");
	public static final Block EMERALD_BOX_BLOCK = new EmeraldBoxBlock("emerald_box_block");
	public static final Block PAPER_BIN_BLOCK = new PaperBinBlock("paper_bin_block", Material.IRON, 2.0F, 30.0F, SoundType.METAL);
	public static final Block HANDHELD_LANTERN_BLOCK = new HandheldLanternBlock("handheld_lantern_block", Material.WOOD, 2.0F, 15.0F, SoundType.WOOD);
	public static final Block HANDHELD_LANTERN_ON_BLOCK = new HandheldLanternOnBlock("handheld_lantern_on_block", Material.WOOD, 2.0F, 15.0F, SoundType.WOOD);
	public static final Block LIGHT_BAR_BLOCK = new LightBarBlock("light_bar_block", Material.WOOD, 2.0F, 15.0F, SoundType.WOOD);
}
