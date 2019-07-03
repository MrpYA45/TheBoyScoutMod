package com.MrpYA45.TheBoyScoutMod.items;

import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class ItemStrawberry extends ItemCustomFood implements IPlantable {

	public ItemStrawberry(String name, int amount, float saturation, boolean isWolfFood) {
		super(name, amount, saturation, isWolfFood);
	}

	@Override
	public EnumActionResult onItemUse(ItemUseContext context) {
		ItemStack stack = context.getItem();
		World world = context.getWorld();
		IBlockState state = world.getBlockState(context.getPos());
		EntityPlayer player = context.getPlayer();
		EnumFacing facing = context.getFace();
		BlockPos pos = context.getPos();
		if (facing == EnumFacing.UP && player.canPlayerEdit(pos.offset(facing), facing, stack)
				&& state.getBlock().canSustainPlant(state, world, pos, EnumFacing.UP, this)
				&& world.isAirBlock(pos.up())) {
			world.setBlockState(pos.up(), ModBlocks.STRAWBERRY_PLANT.getDefaultState());
			stack.shrink(1);
			return EnumActionResult.SUCCESS;
		} else
			return EnumActionResult.FAIL;
	}

	@Override
	public EnumPlantType getPlantType(IBlockReader world, BlockPos pos) {
		return EnumPlantType.Crop;
	}

	@Override
	public IBlockState getPlant(IBlockReader world, BlockPos pos) {
		return ModBlocks.STRAWBERRY_PLANT.getDefaultState();
	}

}