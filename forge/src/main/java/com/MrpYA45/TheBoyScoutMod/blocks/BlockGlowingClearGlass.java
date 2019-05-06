package com.MrpYA45.TheBoyScoutMod.blocks;

import net.minecraft.block.state.IBlockState;

public class BlockGlowingClearGlass extends BlockClearGlass {

	public BlockGlowingClearGlass(String name) {
		super(name);
	}
	
	@Override
	public int getLightValue(IBlockState state) {
		return 7;
	}

}
