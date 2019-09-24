package com.MrpYA45.TheBoyScoutMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class BlockHandheldLantern extends HorizontalBlock {

	public static final BooleanProperty LIT = BlockStateProperties.LIT;

	public BlockHandheldLantern(String name) {
		super(Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD).lightValue(15));
		setRegistryName(name);
		this.setDefaultState(this.getDefaultState().with(LIT, Boolean.valueOf(false)).with(HORIZONTAL_FACING, Direction.NORTH));
	}

	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.AXE;
	}

	@SuppressWarnings("deprecation")
	@Override
	public int getLightValue(BlockState state) {
		return state.get(LIT) ? super.getLightValue(state) : 0;
	}

	@Override
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}

	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(HORIZONTAL_FACING).add(LIT);
	}

//	@Override
//	public BlockState rotate(BlockState state, Rotation rot) {
//		return state.with(HORIZONTAL_FACING, rot.rotate(state.get(HORIZONTAL_FACING)));
//	}

//	@Override
//	public BlockState withMirror(BlockState state, Mirror mirrorIn) {
//		return state.rotate(mirrorIn.toRotation(state.get(HORIZONTAL_FACING)));
//	}
//
//	@Override
//	public BlockState getStateForPlacement(World worldIn, BlockPos pos, Direction facing, float hitX, float hitY,
//			float hitZ, int meta, EntityLivingBase placer) {
//		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
//	}
//
//	@Override
//	protected BlockStateContainer createBlockState() {
//		return new BlockStateContainer(this, FACING);
//	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return Block.makeCuboidShape(3.2D, 0.0D, 3.2D, 12.8D, 14.4D, 12.8D);
//		return Block.makeCuboidShape(0.2D, 0.0D, 0.2D, 0.8D, 0.9D, 0.8D);
	}

	@Override
	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,
			BlockRayTraceResult hit) {
		worldIn.setBlockState(pos, state.cycle(LIT), 2);
		return true;
	}
//
//	@Override
//	public ItemStack getPickBlock(BlockState state, RayTraceResult target, IBlockReader world, BlockPos pos,
//			PlayerEntity player) {
//		return new ItemStack(ModBlocks.HANDHELD_LANTERN_BLOCK);
//	}

}
