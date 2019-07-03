package com.MrpYA45.TheBoyScoutMod.worldgen;

import java.util.Random;

import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.AbstractFlowersFeature;

public class TBSMFlowersFeature extends AbstractFlowersFeature {

	public static final Block[] TBSM_FLOWERS = new Block[] {ModBlocks.BLUE_FLOWER_BLOCK, ModBlocks.PINK_FLOWER_BLOCK, ModBlocks.ORANGE_FLOWER_BLOCK, ModBlocks.WEEDS_BLOCK};

	public IBlockState getRandomFlower(Random p_202355_1_, BlockPos p_202355_2_) {
		return TBSM_FLOWERS[(int) (p_202355_1_.nextDouble() * (double) TBSM_FLOWERS.length)].getDefaultState();
	}
}
