package com.MrpYA45.TheBoyScoutMod.blocks.containers.wooden_box;

import com.MrpYA45.TheBoyScoutMod.blocks.BlockBase;

import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
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

public class BlockWoodenBox extends BlockBase {

	public BlockWoodenBox(String name) {
		super(name, Material.WOOD, 2.0F, 15.0F, SoundType.WOOD); // TODO Cambiar valores resistencia
	}

	@Override
	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,
			BlockRayTraceResult hit) {
		if (!worldIn.isRemote) { // && player instanceof ServerPlayerEntity
			System.out.print("Hit");
			TileEntity tile = worldIn.getTileEntity(pos);
			System.out.print(worldIn.getTileEntity(pos));
			if (tile instanceof TileEntityWoodenBox) {
				System.out.print("Hit 2");
				NetworkHooks.openGui((ServerPlayerEntity) player, new InterfaceWoodenBox((TileEntityWoodenBox) tile), buf -> buf.writeBlockPos(pos));
			}
		}
		return true;
	}

//    @Override
//    public void breakBlock(World world, BlockPos pos, BlockState state) {
//    	TileEntityWoodenBox te = (TileEntityWoodenBox) world.getTileEntity(pos);
//        if (te != null && te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, Direction.NORTH)) {
//            IItemHandler inventory = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, Direction.NORTH);
//            if (inventory != null) {
//                for (int i = 0; i < inventory.getSlots(); i++) {
//                    if (inventory.getStackInSlot(i) != ItemStack.EMPTY) {
//                        ItemEntity item = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, inventory.getStackInSlot(i));
//
//                        float multiplier = 0.1f;
//                        float motionX = world.rand.nextFloat() - 0.5f;
//                        float motionY = world.rand.nextFloat() - 0.5f;
//                        float motionZ = world.rand.nextFloat() - 0.5f;
//
//                        item.motionX = motionX * multiplier;
//                        item.motionY = motionY * multiplier;
//                        item.motionZ = motionZ * multiplier;
//
//                        world.spawnEntity(item);
//                    }
//                }
//            }
//        }
//        super.breakBlock(world, pos, state);
//    }

	@Override
	public boolean hasTileEntity() {
		return true;
	}

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new TileEntityWoodenBox();
	}

	public static class InterfaceWoodenBox implements INamedContainerProvider {
		
		private final TileEntityWoodenBox te;
		
		public InterfaceWoodenBox(TileEntityWoodenBox te) {
			this.te = te;
		}
		
		@Override
		public ITextComponent getDisplayName() {
			return NarratorChatListener.field_216868_a;
		}

		@Override
		public Container createMenu(int windowID, PlayerInventory playerInventory, PlayerEntity playerIn) {
			return new ContainerWoodenBox(windowID, playerInventory, te);
		}
	}

}
