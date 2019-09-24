package com.MrpYA45.TheBoyScoutMod.worldgen;

import java.util.Random;
import java.util.function.Function;

import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.FlowersFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class TBSMFlowersFeature extends FlowersFeature {

	public TBSMFlowersFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49876_1_) {
		super(p_i49876_1_);
	}

	public static final Block[] TBSM_FLOWERS = new Block[] {ModBlocks.BLUE_FLOWER_BLOCK, ModBlocks.PINK_FLOWER_BLOCK, ModBlocks.ORANGE_FLOWER_BLOCK, ModBlocks.WEEDS_BLOCK};

	public BlockState getRandomFlower(Random p_202355_1_, BlockPos p_202355_2_) {
		return TBSM_FLOWERS[(int) (p_202355_1_.nextDouble() * (double) TBSM_FLOWERS.length)].getDefaultState();
	}
}
