package com.MrpYA45.TheBoyScoutMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReaderBase;
import net.minecraftforge.common.ToolType;

public class BlockLightBar extends Block {

	public static final DirectionProperty FACING = BlockHorizontal.HORIZONTAL_FACING;

	private static final VoxelShape LIGHTBAR_EAST_AABB = Block.makeCuboidShape(0.0D, 0.875D, 0.0D, 0.125D, 1.0D, 1.0D);
	private static final VoxelShape LIGHTBAR_WEST_AABB = Block.makeCuboidShape(0.875D, 0.875D, 0.0D, 1.0D, 1.0D, 1.0D);
	private static final VoxelShape LIGHTBAR_SOUTH_AABB = Block.makeCuboidShape(0.0D, 0.875D, 0.0D, 1.0D, 1.0D, 0.125D);
	private static final VoxelShape LIGHTBAR_NORTH_AABB = Block.makeCuboidShape(0.0D, 0.875D, 0.875D, 1.0D, 1.0D, 1.0D);

	public BlockLightBar(String name) {
		super(Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD).lightValue(16));
		setRegistryName(name);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, EnumFacing.NORTH));
	}

	@Override
	public ToolType getHarvestTool(IBlockState state) {
		return ToolType.PICKAXE;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
		switch ((EnumFacing) state.get(FACING)) {
		case NORTH:
			return LIGHTBAR_NORTH_AABB;
		case SOUTH:
			return LIGHTBAR_SOUTH_AABB;
		case WEST:
			return LIGHTBAR_WEST_AABB;
		case EAST:
		default:
			return LIGHTBAR_EAST_AABB;
		}
	}

	private boolean canAttachTo(IBlockReader p_196471_1_, BlockPos p_196471_2_, EnumFacing p_196471_3_) {
		IBlockState iblockstate = p_196471_1_.getBlockState(p_196471_2_);
		boolean flag = isExceptBlockForAttachWithPiston(iblockstate.getBlock());
		return !flag && iblockstate.getBlockFaceShape(p_196471_1_, p_196471_2_, p_196471_3_) == BlockFaceShape.SOLID
				&& !iblockstate.canProvidePower();
	}

	public boolean isValidPosition(IBlockState state, IWorldReaderBase worldIn, BlockPos pos) {
		EnumFacing enumfacing = state.get(FACING);
		return this.canAttachTo(worldIn, pos.offset(enumfacing.getOpposite()), enumfacing);
	}

	protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
		builder.add(FACING);
	}
}