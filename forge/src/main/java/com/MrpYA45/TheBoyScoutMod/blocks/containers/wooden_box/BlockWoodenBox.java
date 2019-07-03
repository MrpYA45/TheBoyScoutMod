package com.MrpYA45.TheBoyScoutMod.blocks.containers.wooden_box;

import com.MrpYA45.TheBoyScoutMod.blocks.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class BlockWoodenBox extends BlockBase {

	public BlockWoodenBox(String name) {
		super(name, Material.WOOD, 2.0F, 15.0F, SoundType.WOOD); // TODO Cambiar valores resistencia
	}

	@Override
	public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer player, EnumHand hand,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote && player instanceof EntityPlayerMP) {
			TileEntity tile = worldIn.getTileEntity(pos);
			if (tile instanceof TileEntityWoodenBox) {
				NetworkHooks.openGui((EntityPlayerMP) player, new InteractionObjectWB((TileEntityWoodenBox) tile),
						(buffer) -> {
							buffer.writeBlockPos(pos);
						});
			}
		}
		return true;
	}

//    @Override
//    public void breakBlock(World world, BlockPos pos, IBlockState state) {
//    	TileEntityWoodenBox te = (TileEntityWoodenBox) world.getTileEntity(pos);
//        if (te != null && te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH)) {
//            IItemHandler inventory = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
//            if (inventory != null) {
//                for (int i = 0; i < inventory.getSlots(); i++) {
//                    if (inventory.getStackInSlot(i) != ItemStack.EMPTY) {
//                        EntityItem item = new EntityItem(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, inventory.getStackInSlot(i));
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
	public TileEntity createTileEntity(IBlockState state, IBlockReader world) {
		return new TileEntityWoodenBox();
	}

}
