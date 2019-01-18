package com.MrpYA45.TheBoyScoutMod.items;

import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlueberriesSeeds extends ItemBase {

	public BlueberriesSeeds(String name) {
		super(name);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack stack = player.getHeldItem(hand);
		IBlockState state = worldIn.getBlockState(pos);
		if (player.canPlayerEdit(pos.offset(facing), facing, stack) && state.getBlock().isLeaves(state, worldIn, pos)) {
			worldIn.destroyBlock(pos, false);
			worldIn.setBlockState(pos, ModBlocks.BLUEBERRIES_BUSH_BLOCK.getDefaultState());
			stack.shrink(1);
			return EnumActionResult.SUCCESS;
		} else
			return EnumActionResult.FAIL;
	}
}
