package com.MrpYA45.TheBoyScoutMod.items;

import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlueberriesSeedsItem extends TBSMBaseItem {

	public BlueberriesSeedsItem(String name) {
		super(name);
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		ItemStack stack = context.getItem();
		World world = context.getWorld();
		BlockState state = world.getBlockState(context.getPos());
		PlayerEntity player = context.getPlayer();
		Direction facing = context.getFace();
		BlockPos pos = context.getPos();
		if (player.canPlayerEdit(pos.offset(facing), facing, stack) && state.getBlock() instanceof LeavesBlock) {
			world.destroyBlock(pos, false);
			world.setBlockState(pos, ModBlocks.BLUEBERRIES_BUSH_BLOCK.getDefaultState());
			stack.shrink(1);
			return ActionResultType.SUCCESS;
		}
		return ActionResultType.FAIL;
	}
}
