package com.MrpYA45.TheBoyScoutMod.blocks;

import javax.annotation.Nonnull;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockClearGlass extends BlockBase {

	public BlockClearGlass(String name, Material material, float hardness, float resistance, SoundType soundtype) {
		super(name, material, hardness, resistance, soundtype);
		setSoundType(SoundType.GLASS);
		setHardness(0.3F);
		setResistance(1.5F);
		setHarvestLevel("pickaxe",0);
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

	@Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public boolean shouldSideBeRendered(IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, EnumFacing side) {
		Block block = world.getBlockState(pos.offset(side)).getBlock();
		return block == this ? false : super.shouldSideBeRendered(state, world, pos, side);
	}

	@SideOnly(Side.CLIENT)
	@Nonnull
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}

}
