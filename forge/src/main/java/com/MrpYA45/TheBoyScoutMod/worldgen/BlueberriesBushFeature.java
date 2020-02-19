package com.MrpYA45.TheBoyScoutMod.worldgen;

import java.util.Random;
import java.util.function.Function;

import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;
import com.mojang.datafixers.Dynamic;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class BlueberriesBushFeature extends Feature<NoFeatureConfig> {

	public BlueberriesBushFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	//TODO
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		for (int i = 0; i < 10; ++i) {
			BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4),
					rand.nextInt(8) - rand.nextInt(8));
			if (worldIn.isAirBlock(blockpos)) {
				//int j = 1 + rand.nextInt(rand.nextInt(3) + 1);
				worldIn.setBlockState(blockpos.up(), ModBlocks.BLUEBERRIES_BUSH_BLOCK.getDefaultState(), 2);
			}
		}

		return true;
	}

}
