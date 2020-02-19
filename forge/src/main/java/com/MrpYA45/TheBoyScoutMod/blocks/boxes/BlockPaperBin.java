package com.MrpYA45.TheBoyScoutMod.blocks.boxes;

import com.MrpYA45.TheBoyScoutMod.containers.ContainerPaperBin;
import com.MrpYA45.TheBoyScoutMod.tile_entities.TileEntityPaperBin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BlockPaperBin extends BlockAbstractBox {

	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	public static final BooleanProperty ENABLED = BlockStateProperties.ENABLED;

	public BlockPaperBin(String name) {
		// super(Properties.create(Material.IRON).hardnessAndResistance(2.0F, 30.0F).sound(SoundType.METAL));
		super(name);
		this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH).with(ENABLED, Boolean.valueOf(false)));
	}

	public boolean isOpaqueCube(BlockState state) {
		return false;
	}

	@Override
	public BlockRenderLayer getRenderLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	public boolean isFullCube(BlockState state) {
		return false;
	}

	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing().getOpposite());
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING, ENABLED);
	}

	@Override
	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,
			BlockRayTraceResult hit) {
		if (!worldIn.isRemote) {
			TileEntity tile = worldIn.getTileEntity(pos);
			if (tile instanceof TileEntityPaperBin) {
				NetworkHooks.openGui((ServerPlayerEntity) player, new InterfacePaperBin((TileEntityPaperBin) tile),
						(buffer) -> {
							buffer.writeBlockPos(pos);
						});
			}
		}
		return true;
	}

	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		if (oldState.getBlock() != state.getBlock()) {
			this.updateState(worldIn, pos, state);
		}
	}

	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos,
			boolean isMoving) {
		this.updateState(worldIn, pos, state);
	}

	private void updateState(World worldIn, BlockPos pos, BlockState state) {
		boolean flag = !worldIn.isBlockPowered(pos);
		if (flag != state.get(ENABLED)) {
			worldIn.setBlockState(pos, state.with(ENABLED, Boolean.valueOf(flag)), 4);
		}

	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return Block.makeCuboidShape(3.2D, 0.0D, 3.2D, 12.8D, 14.4D, 12.8D);
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new TileEntityPaperBin();
	}

	public static class InterfacePaperBin implements INamedContainerProvider {

		private final TileEntityPaperBin te;

		public InterfacePaperBin(TileEntityPaperBin te) {
			this.te = te;
		}

		@Override
		public ITextComponent getDisplayName() {
			return NarratorChatListener.field_216868_a;
		}

		@Override
		public Container createMenu(int windowID, PlayerInventory playerInventory, PlayerEntity playerIn) {
			return new ContainerPaperBin(windowID, playerInventory, te);
		}
	}
}
