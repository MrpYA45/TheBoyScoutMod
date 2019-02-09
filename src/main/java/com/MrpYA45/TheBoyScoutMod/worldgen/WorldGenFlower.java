package com.MrpYA45.TheBoyScoutMod.worldgen;

import java.util.Random;

import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenFlower extends WorldGenerator {

	public BlockBush flower;
	
	public WorldGenFlower(Block flower) {
		this.flower = (BlockBush) flower;
	}
	
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
        IBlockState state = flower.getDefaultState();
        
        for (int i = 0; i < 64; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < 255) && flower.canBlockStay(worldIn, blockpos, flower.getDefaultState()))
            {
                worldIn.setBlockState(blockpos, state, 2);
            }
        }

        return true;
    }

}
