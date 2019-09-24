package com.MrpYA45.TheBoyScoutMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class BlockLightBar extends Block {

	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	private static final VoxelShape LIGHTBAR_EAST_AABB = Block.makeCuboidShape(0.0D, 0.875D, 0.0D, 0.125D, 1.0D, 1.0D);
	private static final VoxelShape LIGHTBAR_WEST_AABB = Block.makeCuboidShape(0.875D, 0.875D, 0.0D, 1.0D, 1.0D, 1.0D);
	private static final VoxelShape LIGHTBAR_SOUTH_AABB = Block.makeCuboidShape(0.0D, 0.875D, 0.0D, 1.0D, 1.0D, 0.125D);
	private static final VoxelShape LIGHTBAR_NORTH_AABB = Block.makeCuboidShape(0.0D, 0.875D, 0.875D, 1.0D, 1.0D, 1.0D);

	public BlockLightBar(String name) {
		super(Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD).lightValue(16));
		setRegistryName(name);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}

	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.PICKAXE;
	}

//	@Override
//	public boolean isFullCube(BlockState state) {
//		return false;
//	}

	public boolean isOpaqueCube(BlockState state) {
		return false;
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

	private boolean canAttachTo(IBlockReader p_196471_1_, BlockPos p_196471_2_, Direction p_196471_3_) {
		BlockState blockstate = p_196471_1_.getBlockState(p_196471_2_);
		return !blockstate.canProvidePower() && Block.hasSolidSide(blockstate, p_196471_1_, p_196471_2_, p_196471_3_);
	}

	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		Direction Direction = state.get(FACING);
		return this.canAttachTo(worldIn, pos.offset(Direction.getOpposite()), Direction);
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
