package com.MrpYA45.TheBoyScoutMod.blocks.boxes;

import com.MrpYA45.TheBoyScoutMod.containers.ContainerGoldBox;
import com.MrpYA45.TheBoyScoutMod.tile_entities.TileEntityGoldBox;

import net.minecraft.block.BlockState;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BlockGoldBox extends BlockAbstractBox {

	public BlockGoldBox(String name) {
		super(name);
	}

	@Override
	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,
			BlockRayTraceResult hit) {
		if (!worldIn.isRemote) {
			TileEntity tile = worldIn.getTileEntity(pos);
			if (tile instanceof TileEntityGoldBox) {
				NetworkHooks.openGui((ServerPlayerEntity) player, new InterfaceGoldBox((TileEntityGoldBox) tile),
						(buffer) -> {
							buffer.writeBlockPos(pos);
						});
			}
		}
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new TileEntityGoldBox();
	}

	public static class InterfaceGoldBox implements INamedContainerProvider {

		private final TileEntityGoldBox te;

		public InterfaceGoldBox(TileEntityGoldBox te) {
			this.te = te;
		}

		@Override
		public ITextComponent getDisplayName() {
			return NarratorChatListener.field_216868_a;
		}

		@Override
		public Container createMenu(int windowID, PlayerInventory playerInventory, PlayerEntity playerIn) {
			return new ContainerGoldBox(windowID, playerInventory, te);
		}
	}
}
