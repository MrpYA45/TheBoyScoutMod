package com.MrpYA45.TheBoyScoutMod.blocks.containers.diamond_box;

import java.util.Random;

import com.MrpYA45.TheBoyScoutMod.Main;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockBase;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.diamond_box.DiamondBoxTileEntity;
import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;
import com.MrpYA45.TheBoyScoutMod.util.Reference;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class DiamondBoxBlock extends BlockBase implements ITileEntityProvider {

	public DiamondBoxBlock(String name) {
		super(name, Material.WOOD, 2.0F, 15.0F, SoundType.WOOD);
	}
	
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(ModBlocks.DIAMOND_BOX_BLOCK);
	}
	
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(ModBlocks.DIAMOND_BOX_BLOCK);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		DiamondBoxTileEntity te = (DiamondBoxTileEntity) worldIn.getTileEntity(pos);
		if(!worldIn.isRemote && te != null && te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH)) {
			playerIn.openGui(Main.instance, Reference.GUI_DIAMOND_BOX, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		
		return true;
	}
	
    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
    	DiamondBoxTileEntity te = (DiamondBoxTileEntity) world.getTileEntity(pos);
        if (te != null && te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH)) {
            IItemHandler inventory = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
            if (inventory != null) {
                for (int i = 0; i < inventory.getSlots(); i++) {
                    if (inventory.getStackInSlot(i) != ItemStack.EMPTY) {
                        EntityItem item = new EntityItem(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, inventory.getStackInSlot(i));

                        float multiplier = 0.1f;
                        float motionX = world.rand.nextFloat() - 0.5f;
                        float motionY = world.rand.nextFloat() - 0.5f;
                        float motionZ = world.rand.nextFloat() - 0.5f;

                        item.motionX = motionX * multiplier;
                        item.motionY = motionY * multiplier;
                        item.motionZ = motionZ * multiplier;

                        world.spawnEntity(item);
                    }
                }
            }
        }
        super.breakBlock(world, pos, state);
    }

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new DiamondBoxTileEntity();
	}

}
