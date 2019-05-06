package com.MrpYA45.TheBoyScoutMod.blocks.containers.wooden_box;

import com.MrpYA45.TheBoyScoutMod.blocks.BlockBase;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockWoodenBox extends BlockBase {

	public BlockWoodenBox(String name) {
		super(name, Material.WOOD, 2.0F, 15.0F, SoundType.WOOD); //TODO Cambiar valores resistencia
	}
	
//	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
//		return Item.getItemFromBlock(ModBlocks.WOODEN_BOX_BLOCK);
//	}
	
//	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
//		return new ItemStack(ModBlocks.WOODEN_BOX_BLOCK);
//	}
	
//	@Override
//	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
//		TileEntityWoodenBox te = (TileEntityWoodenBox) worldIn.getTileEntity(pos);
//		if(!worldIn.isRemote && te != null && te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH)) {
//			playerIn.openGui(Main.instance, Reference.GUI_WOODEN_BOX, worldIn, pos.getX(), pos.getY(), pos.getZ());
//		}
//		
//		return true;
//	}
	
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

//	@Override
//	public TileEntity createNewTileEntity(World worldIn, int meta) {
//		return new TileEntityWoodenBox();
//	}

}
