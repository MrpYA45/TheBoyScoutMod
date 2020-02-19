package com.MrpYA45.TheBoyScoutMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class BlockLightBar extends Block {

	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	private static final VoxelShape LIGHTBAR_EAST_AABB = Block.makeCuboidShape(0.0D, 14.0D, 0.0D, 2.0D, 16.0D, 16.0D);
	private static final VoxelShape LIGHTBAR_WEST_AABB = Block.makeCuboidShape(14.0D, 14.0D, 0.0D, 16.0D, 16.0D, 16.0D);
	private static final VoxelShape LIGHTBAR_SOUTH_AABB = Block.makeCuboidShape(0.0D, 14.0D, 0.0D, 16.0D, 16.0D, 2.0D);
	private static final VoxelShape LIGHTBAR_NORTH_AABB = Block.makeCuboidShape(0.0D, 14.0D, 14.0D, 16.0D, 16.0D,
			16.0D);

	public BlockLightBar(String name) {
		super(Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD).lightValue(16));
		setRegistryName(name);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}

	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.PICKAXE;
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch ((Direction) state.get(FACING)) {
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

	private boolean canAttachTo(IBlockReader worldIn, BlockPos pos, Direction direction) {
		BlockState state = worldIn.getBlockState(pos);
		return !state.canProvidePower() && state.func_224755_d(worldIn, pos, direction);
	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		Direction direction = state.get(FACING);
		return this.canAttachTo(worldIn, pos.offset(direction.getOpposite()), direction);
	}

	@SuppressWarnings("deprecation")
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn,
			BlockPos currentPos, BlockPos facingPos) {
		if (facing.getOpposite() == stateIn.get(FACING) && !stateIn.isValidPosition(worldIn, currentPos)) {
			return Blocks.AIR.getDefaultState();
		} else {
			return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
		}
	}

	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		return true;
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING);

	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}
}
