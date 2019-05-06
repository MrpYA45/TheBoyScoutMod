package com.MrpYA45.TheBoyScoutMod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockRocksPath extends BlockBase {

	public BlockRocksPath() {
		super("rocks_path", Material.ROCK, 1.5F, 6.0F, SoundType.STONE);
	}

//	@Override
//	public boolean isOpaqueCube(IBlockState state) {
//        return false;
//    }

	@Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
	
//	@Override
//    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
//    {
//		return new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.0625D, 1.0D);
//    }
//
//	@Override
//	public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
//		return worldIn.getBlockState(pos.down()).isFullCube();
//	}
}
