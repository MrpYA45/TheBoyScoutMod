package com.MrpYA45.TheBoyScoutMod.worldgen;

import java.util.Random;
import java.util.Set;

import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class HazelTreeFeature extends AbstractTreeFeature<NoFeatureConfig> {

	public HazelTreeFeature() {
		super(NoFeatureConfig::deserialize, false);
	}

	@Override
	protected boolean place(Set<BlockPos> changedBlocks, IWorldGenerationReader worldIn, Random rand, BlockPos position,
			MutableBoundingBox p_208519_5_) {
		BlockState log = ModBlocks.HAZEL_WOOD_BLOCK.getDefaultState();
		BlockState leaves = ModBlocks.HAZEL_LEAVES_BLOCK.getDefaultState();
		int height = rand.nextInt(2) + 7;
		//int i = position.getX();
		//int j = position.getY();
		int k = position.getZ();
		if (k >= 1 && k + height + 1 < worldIn.getMaxHeight()) {
			BlockPos blockpos = position.down();
			if (!isSoil(worldIn, blockpos, getSapling())) {
				return false;
			} else {
				this.setDirtAt(worldIn, blockpos, position);
				for (int h1 = 0; h1 < height; h1++) {
					this.setLogState(changedBlocks, worldIn, blockpos.up(h1), log, p_208519_5_);
				}
				this.setLogState(changedBlocks, worldIn, blockpos.up(height), leaves, p_208519_5_);
				for (int h2 = height - 1; h2 > height - 4; h2--) {
					BlockPos pos2 = blockpos.up(h2);
					this.setLogState(changedBlocks, worldIn, pos2.north(), leaves, p_208519_5_);
					this.setLogState(changedBlocks, worldIn, pos2.south(), leaves, p_208519_5_);
					this.setLogState(changedBlocks, worldIn, pos2.east(), leaves, p_208519_5_);
					this.setLogState(changedBlocks, worldIn, pos2.west(), leaves, p_208519_5_);
				}
				//System.out.print("Hazel tree placed at: i" + i + " j" + j + " k" + k);
				return true;
			}
		} else {
			return false;
		}
	}

}
