package com.MrpYA45.TheBoyScoutMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class BlockHandheldLantern extends BlockHorizontal {

	public static final BooleanProperty LIT = BlockStateProperties.LIT;
	public static final DirectionProperty FACING = BlockHorizontal.HORIZONTAL_FACING;

	public BlockHandheldLantern(String name) {
		super(Properties.create(Material.WOOD).hardnessAndResistance(2.0F, 3.0F).sound(SoundType.WOOD).lightValue(15));
		setRegistryName(name);
		this.setDefaultState(this.getDefaultState().with(LIT, Boolean.valueOf(false)).with(FACING, EnumFacing.NORTH));
	}

	@Override
	public ToolType getHarvestTool(IBlockState state) {
		return ToolType.AXE;
	}

	@Override
	public int getLightValue(IBlockState state, IWorldReader world, BlockPos pos) {
		return state.get(LIT) ? super.getLightValue(state, world, pos) : 0;
	}

	@Override
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public boolean isBlockNormalCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	public IBlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}
	
	protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
		builder.add(FACING).add(LIT);
	}

//	@Override
//	public IBlockState withRotation(IBlockState state, Rotation rot) {
//		return state.withProperty(FACING, rot.rotate((EnumFacing) state.getValue(FACING)));
//	}
//
//	@Override
//	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
//		return state.withRotation(mirrorIn.toRotation((EnumFacing) state.getValue(FACING)));
//	}
//
//	@Override
//	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
//			float hitZ, int meta, EntityLivingBase placer) {
//		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
//	}
//
//	@Override
//	protected BlockStateContainer createBlockState() {
//		return new BlockStateContainer(this, FACING);
//	}

	@Override
	public VoxelShape getShape(IBlockState state, IBlockReader worldIn, BlockPos pos) {
		return Block.makeCuboidShape(3.2D, 0.0D, 3.2D, 12.8D, 14.4D, 12.8D);
//		return Block.makeCuboidShape(0.2D, 0.0D, 0.2D, 0.8D, 0.9D, 0.8D);
	}

	@Override
	public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer player, EnumHand hand,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		worldIn.setBlockState(pos, state.cycle(LIT), 2);
		return true;
	}
//
//	@Override
//	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, IBlockReader world, BlockPos pos,
//			EntityPlayer player) {
//		return new ItemStack(ModBlocks.HANDHELD_LANTERN_BLOCK);
//	}

}