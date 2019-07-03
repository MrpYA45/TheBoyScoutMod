package com.MrpYA45.TheBoyScoutMod.blocks.containers.paper_bin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockReader;

public class BlockPaperBin extends BlockContainer {

	public static final DirectionProperty FACING = BlockHorizontal.HORIZONTAL_FACING;

	public BlockPaperBin(String name) {
		super(Properties.create(Material.IRON).hardnessAndResistance(2.0F, 30.0F).sound(SoundType.METAL));
		this.setDefaultState(this.getDefaultState().with(FACING, EnumFacing.NORTH));
		setRegistryName(name);
	}

	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	public IBlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		return null;
	}

//	@Override
//	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
//		return new AxisAlignedBB(0.19999999999999998D, 0.0D, 0.2D, 0.8D, 0.9D, 0.8D);
//	}

//	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
//		return Item.getItemFromBlock(ModBlocks.PAPER_BIN_BLOCK);
//	}
//
//	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
//		return new ItemStack(ModBlocks.PAPER_BIN_BLOCK);
//	}

//	@Override
//	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
//		int i = pos.getX();
//		int j = pos.getY();
//		int k = pos.getZ();
//		world.scheduleUpdate(pos, this, this.tickRate(world));
//	}

//	@Override
//	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
//			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
//		TileEntityPaperBin te = (TileEntityPaperBin) worldIn.getTileEntity(pos);
//		if (!worldIn.isRemote && te != null
//				&& te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH)) {
//			playerIn.openGui(Main.instance, Reference.GUI_PAPER_BIN, worldIn, pos.getX(), pos.getY(), pos.getZ());
//		}
//		return true;
//	}

//	@Override
//	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random random) {
//		TileEntity te = worldIn.getTileEntity(pos);
//		if (te != null && (te instanceof TileEntityPaperBin))
//			((TileEntityPaperBin) te).removeStackFromSlot(0);
//		worldIn.scheduleUpdate(new BlockPos(pos), this, this.tickRate(worldIn));
//	}

//	@Override
//	public int tickRate(World world) {
//		return 10;
//	}

//	@Override
//	public void breakBlock(World world, BlockPos pos, IBlockState state) {
//		TileEntityPaperBin te = (TileEntityPaperBin) world.getTileEntity(pos);
//		if (te != null && te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH)) {
//			IItemHandler inventory = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
//			if (inventory != null) {
//				for (int i = 0; i < inventory.getSlots(); i++) {
//					if (inventory.getStackInSlot(i) != ItemStack.EMPTY) {
//						EntityItem item = new EntityItem(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
//								inventory.getStackInSlot(i));
//
//						float multiplier = 0.1f;
//						float motionX = world.rand.nextFloat() - 0.5f;
//						float motionY = world.rand.nextFloat() - 0.5f;
//						float motionZ = world.rand.nextFloat() - 0.5f;
//
//						item.motionX = motionX * multiplier;
//						item.motionY = motionY * multiplier;
//						item.motionZ = motionZ * multiplier;
//
//						world.spawnEntity(item);
//					}
//				}
//			}
//		}
//		super.breakBlock(world, pos, state);
//	}

//	@Override
//	public TileEntity createNewTileEntity(World worldIn, int meta) {
//		return new TileEntityPaperBin();
//	}

//	@Override
//	public EnumBlockRenderType getRenderType(IBlockState iBlockState) {
//		return EnumBlockRenderType.MODEL;
//	}
}