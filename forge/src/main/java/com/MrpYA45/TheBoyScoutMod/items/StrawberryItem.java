package com.MrpYA45.TheBoyScoutMod.items;

import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;

public class StrawberryItem extends TBSMBaseItem implements IPlantable {

	public StrawberryItem(String name, Properties prop) {
		super(name, prop);
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		ItemStack stack = context.getItem();
		World world = context.getWorld();
		BlockState state = world.getBlockState(context.getPos());
		PlayerEntity player = context.getPlayer();
		Direction facing = context.getFace();
		BlockPos pos = context.getPos();
		if (facing == Direction.UP && player.canPlayerEdit(pos.offset(facing), facing, stack)
				&& state.getBlock().canSustainPlant(state, world, pos, Direction.UP, this)
				&& world.isAirBlock(pos.up())) {
			world.setBlockState(pos.up(), ModBlocks.STRAWBERRY_PLANT.getDefaultState());
			stack.shrink(1);
			return ActionResultType.SUCCESS;
		} else
			return ActionResultType.FAIL;
	}

	@Override
	public PlantType getPlantType(IBlockReader world, BlockPos pos) {
		return PlantType.Crop;
	}

	@Override
	public BlockState getPlant(IBlockReader world, BlockPos pos) {
		return ModBlocks.STRAWBERRY_PLANT.getDefaultState();
	}

}
