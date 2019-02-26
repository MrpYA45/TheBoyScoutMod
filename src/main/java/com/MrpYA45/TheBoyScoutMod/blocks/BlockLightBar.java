package com.MrpYA45.TheBoyScoutMod.blocks;

import com.MrpYA45.TheBoyScoutMod.Main;
import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;
import com.MrpYA45.TheBoyScoutMod.init.ModItems;
import com.MrpYA45.TheBoyScoutMod.util.IHasModel;

import net.minecraft.block.BlockLadder;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockLightBar extends BlockLadder implements IHasModel {
	
    private static final AxisAlignedBB LIGHTBAR_EAST_AABB = new AxisAlignedBB(0.0D, 0.875D, 0.0D, 0.125D, 1.0D, 1.0D);
    private static final AxisAlignedBB LIGHTBAR_WEST_AABB = new AxisAlignedBB(0.875D, 0.875D, 0.0D, 1.0D, 1.0D, 1.0D);
    private static final AxisAlignedBB LIGHTBAR_SOUTH_AABB = new AxisAlignedBB(0.0D, 0.875D, 0.0D, 1.0D, 1.0D, 0.125D);
    private static final AxisAlignedBB LIGHTBAR_NORTH_AABB = new AxisAlignedBB(0.0D, 0.875D, 0.875D, 1.0D, 1.0D, 1.0D);
	
	public BlockLightBar(String name, Material material, float hardness, float resistance, SoundType soundtype) {
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tabTheBoyScoutMod);
		setHardness(hardness);
		setResistance(resistance);
		setHarvestLevel("pickaxe",0);
		setSoundType(soundtype);
		setLightLevel(1.0F);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        switch ((EnumFacing)state.getValue(FACING))
        {
            case NORTH:
                return LIGHTBAR_NORTH_AABB;
            case SOUTH:
                return LIGHTBAR_SOUTH_AABB;
            case WEST:
                return LIGHTBAR_WEST_AABB;
            case EAST:
            default:
                return LIGHTBAR_EAST_AABB;
        }
    }
	
    @Override public boolean isLadder(IBlockState state, IBlockAccess world, BlockPos pos, EntityLivingBase entity) { return false; }

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");		
	}
}