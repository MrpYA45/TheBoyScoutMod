package com.MrpYA45.TheBoyScoutMod.blocks;

import net.minecraft.block.BlockState;

public class BlockGlowingClearGlass extends BlockClearGlass {

	public BlockGlowingClearGlass(String name) {
		super(name);
	}
	
	@Override
	public int getLightValue(BlockState state) {
		return 7;
	}

}
