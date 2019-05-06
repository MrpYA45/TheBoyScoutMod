package com.MrpYA45.TheBoyScoutMod.items;

import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemBlueberriesSeeds extends ItemBase {

	public ItemBlueberriesSeeds(String name) {
		super(name);
	}

	@Override
	public EnumActionResult onItemUse(ItemUseContext context) {
		ItemStack stack = context.getItem();
		World world = context.getWorld();
		IBlockState state = world.getBlockState(context.getPos());
		EntityPlayer player = context.getPlayer();
		EnumFacing facing = context.getFace();
		BlockPos pos = context.getPos();
		if (player.canPlayerEdit(pos.offset(facing), facing, stack) && state.getBlock() instanceof BlockLeaves) {
			world.destroyBlock(pos, false);
			world.setBlockState(pos, ModBlocks.BLUEBERRIES_BUSH_BLOCK.getDefaultState());
			stack.shrink(1);
			return EnumActionResult.SUCCESS;
		} else
			return EnumActionResult.FAIL;
	}
}
