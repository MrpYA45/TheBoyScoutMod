package com.MrpYA45.TheBoyScoutMod.worldgen;

import java.util.Random;

import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;

import net.minecraft.block.BlockBush;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenCustomFlowers extends WorldGenerator {

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position) {
        BlockBush flower = (BlockBush) ModBlocks.BLUE_FLOWER_BLOCK;
        
        for (int i = 0; i < 64; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.isNether() || blockpos.getY() < 255) && flower.canBlockStay(worldIn, blockpos, flower.getDefaultState()))
            {
                worldIn.setBlockState(blockpos, flower.getDefaultState(), 2);
            }
        }

        return true;
    }

}
