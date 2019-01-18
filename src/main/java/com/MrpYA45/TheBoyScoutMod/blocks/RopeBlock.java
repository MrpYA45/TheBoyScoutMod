package com.MrpYA45.TheBoyScoutMod.blocks;

import com.MrpYA45.TheBoyScoutMod.Main;
import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;
import com.MrpYA45.TheBoyScoutMod.init.ModItems;
import com.MrpYA45.TheBoyScoutMod.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.BlockShulkerBox;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RopeBlock extends Block implements IHasModel {

	public RopeBlock() {
		super(Material.CLOTH);
		setUnlocalizedName("rope_block");
		setRegistryName("rope_block");
		setCreativeTab(Main.tabTheBoyScoutMod);
		setHarvestLevel("pickaxe",0);
        setSoundType(SoundType.CLOTH);

		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	public boolean canPlaceBlock(World worldIn, BlockPos pos, EnumFacing side) {
		if (this.canAttachTo(worldIn, pos.up(), side)) {
			return true;
		}
		return false;
	}
	
    private boolean canAttachTo(World worldIn, BlockPos pos, EnumFacing facing) {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        boolean flag = isExceptBlockForAttachWithPiston(iblockstate.getBlock());
        return (!flag && iblockstate.getBlockFaceShape(worldIn, pos, facing) == BlockFaceShape.SOLID && !iblockstate.canProvidePower()) || iblockstate.getBlock() instanceof RopeBlock;
    }
    
    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
    	if(!this.canAttachTo(worldIn, pos.offset(EnumFacing.UP), EnumFacing.DOWN)) {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockToAir(pos);
        }
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
    	if(this.canAttachTo(worldIn, pos.offset(EnumFacing.UP), EnumFacing.DOWN)) {
    		return true;
    	}
		return false;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    	if(!worldIn.isRemote) {
    		if(playerIn.inventory.getCurrentItem().getItem().equals(Item.getItemFromBlock(ModBlocks.ROPE_BLOCK))) {
    			int y = 0;
    			do {
    				y++;
    				System.out.println(pos.getX() + "," + pos.down(y).getY() + "," +  pos.getZ());
    			} while(worldIn.getBlockState(pos.down(y)).getBlock().equals(ModBlocks.ROPE_BLOCK));
    			if(isReplaceable(worldIn, pos.down(y)) && pos.down(y).getY()>=0 && !worldIn.getBlockState(pos.down(y)).getBlock().equals(Blocks.WATER) && !worldIn.getBlockState(pos.down(y)).getBlock().equals(Blocks.LAVA)) {
    	    		playerIn.inventory.getCurrentItem().shrink(1);
    	    		worldIn.destroyBlock(pos.down(y), true);
    	    		worldIn.setBlockState(pos.down(y), this.getDefaultState());
    	    		System.out.println("Colocado");
    	    		return true;
    			}
    		}
    	}
    	return false;
    }

    @Override public boolean isLadder(IBlockState state, IBlockAccess world, BlockPos pos, EntityLivingBase entity) { return true; }

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return new AxisAlignedBB(0.375D, 0.0D, 0.375D, 0.625D, 1.0D, 0.625D);
	}

    @Override
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
    	if(entityIn instanceof EntityPlayer) {
    		if (entityIn.motionY >= 0.1) {
    			entityIn.setPosition(entityIn.posX, entityIn.posY + 0.2F, entityIn.posZ);
    			//entityIn.move(MoverType.SELF, 0, 0.2F, 0);
    			//entityIn.setVelocity(0, 1.05F, 0);
    		}
    	}
    }

    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.UNDEFINED;
    }

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");		
	}
}
