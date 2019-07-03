package com.MrpYA45.TheBoyScoutMod.blocks;

import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockHandheldLanternOn extends BlockHandheldLantern {

	public BlockHandheldLanternOn(String name) {
		super(name);
//		setLightLevel(1.0F);
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, IBlockReader world, BlockPos pos,
			EntityPlayer player) {
		return new ItemStack(ModBlocks.HANDHELD_LANTERN_BLOCK);
	}

	@Override
	public void getDrops(IBlockState state, NonNullList<ItemStack> drops, World world, BlockPos pos, int fortune) {
		drops.add(new ItemStack(ModBlocks.HANDHELD_LANTERN_BLOCK));
	}

	@Override
	public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer player, EnumHand hand,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();
		if (true) {
			EnumFacing rot = worldIn.getBlockState(pos).get(FACING);
			worldIn.setBlockState(new BlockPos(i, j, k),
					ModBlocks.HANDHELD_LANTERN_BLOCK.getDefaultState().with(FACING, rot), 3);
		}
		return true;
	}

}