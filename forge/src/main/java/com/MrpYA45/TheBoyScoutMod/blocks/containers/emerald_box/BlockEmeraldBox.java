package com.MrpYA45.TheBoyScoutMod.blocks.containers.emerald_box;

import java.util.Random;

import com.MrpYA45.TheBoyScoutMod.Main;
import com.MrpYA45.TheBoyScoutMod.blocks.BlockBase;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.emerald_box.TileEntityEmeraldBox;
import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;
import com.MrpYA45.TheBoyScoutMod.util.Reference;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class BlockEmeraldBox extends BlockBase implements ITileEntityProvider {

	public BlockEmeraldBox(String name) {
		super(name, Material.WOOD, 2.0F, 15.0F, SoundType.WOOD);
	}
	
	public Item getItemDropped(BlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(ModBlocks.EMERALD_BOX_BLOCK);
	}
	
	public ItemStack getItem(World worldIn, BlockPos pos, BlockState state) {
		return new ItemStack(ModBlocks.EMERALD_BOX_BLOCK);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, BlockState state, PlayerEntity playerIn, Hand hand, Direction facing, float hitX, float hitY, float hitZ) {
		TileEntityEmeraldBox te = (TileEntityEmeraldBox) worldIn.getTileEntity(pos);
		if(!worldIn.isRemote && te != null && te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, Direction.NORTH)) {
			playerIn.openGui(Main.instance, Reference.GUI_EMERALD_BOX, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		
		return true;
	}
	
    @Override
    public void breakBlock(World world, BlockPos pos, BlockState state) {
    	TileEntityEmeraldBox te = (TileEntityEmeraldBox) world.getTileEntity(pos);
        if (te != null && te.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, Direction.NORTH)) {
            IItemHandler inventory = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, Direction.NORTH);
            if (inventory != null) {
                for (int i = 0; i < inventory.getSlots(); i++) {
                    if (inventory.getStackInSlot(i) != ItemStack.EMPTY) {
                        ItemEntity item = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, inventory.getStackInSlot(i));

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
		return new TileEntityEmeraldBox();
	}

}
