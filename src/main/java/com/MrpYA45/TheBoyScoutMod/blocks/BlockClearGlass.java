package com.MrpYA45.TheBoyScoutMod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;

public class BlockClearGlass extends BlockBase {

	public BlockClearGlass(String name, Material material, float hardness, float resistance, SoundType soundtype) {
		super(name, material, hardness, resistance, soundtype);
		setSoundType(SoundType.GLASS);
		setHardness(0.3F);
		setResistance(1.5F);
		setHarvestLevel("pickaxe",0);
		setLightOpacity(255);
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
        return false;
    }
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}

}
