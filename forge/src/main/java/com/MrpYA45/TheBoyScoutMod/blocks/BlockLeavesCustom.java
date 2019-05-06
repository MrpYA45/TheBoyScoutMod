package com.MrpYA45.TheBoyScoutMod.blocks;

import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;
import com.MrpYA45.TheBoyScoutMod.init.ModItems;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockLeavesCustom extends BlockLeaves {

	public BlockLeavesCustom(String name) {
		super(Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).needsRandomTick().sound(SoundType.PLANT));
//        setDefaultState(blockState.getBaseState().withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
		setRegistryName(name);
	}
	
    @Override
    protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance)
    {
    	if (state.getBlock() == ModBlocks.HAZEL_LEAVES_BLOCK) {
    		if (worldIn.rand.nextInt(chance) <= 75)
    		{
    			spawnAsEntity(worldIn, pos, new ItemStack(ModItems.HAZELNUT));
    		}
    	}
    }
	@Override
	public void getDrops(IBlockState state, NonNullList<ItemStack> drops, World worldIn, BlockPos pos, int fortune) {
		drops.clear();
	}

//    @Override
//    protected ItemStack getSilkTouchDrop(IBlockState state)
//    {
//        return new ItemStack(Item.getItemFromBlock(this));
//    }
//    
//    @Override
//    public IBlockState getStateFromMeta(int meta)
//    {
//        return getDefaultState().withProperty(DECAYABLE, Boolean.valueOf((meta & 2) == 2)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 4) > 2));
//    }
//    
//    @Override
//    public int getMetaFromState(IBlockState state)
//    {
//        int i = 0;
//
//        if (!state.getValue(DECAYABLE).booleanValue())
//        {
//            i |= 4;
//        }
//
//        if (state.getValue(CHECK_DECAY).booleanValue())
//        {
//            i |= 8;
//        }
//
//        return i;
//    }
//
//    @Override
//    protected BlockStateContainer createBlockState()
//    {
//        return new BlockStateContainer(this, new IProperty[] {CHECK_DECAY, DECAYABLE});
//    }
//    
//    @Override
//    public int damageDropped(IBlockState state)
//    {
//        return 0;
//    }
//    
//    @Override
//    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack)
//    {
//        if (!worldIn.isRemote && stack.getItem() == Items.SHEARS)
//        {
//            player.addStat(StatList.getBlockStats(this));
//        }
//        else
//        {
//            super.harvestBlock(worldIn, player, pos, state, te, stack);
//        }
//    }
//    
//	@Override
//	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
//        return NonNullList.withSize(1, new ItemStack(this));
//	}
//
//	@Override
//	public EnumType getWoodType(int meta) {
//		return null;
//	}
//
//    @Override
//    @SideOnly(Side.CLIENT)
//    public BlockRenderLayer getBlockLayer() {
//        return Blocks.LEAVES.getBlockLayer();
//    }
//	
//    @Override
//    public boolean isOpaqueCube(IBlockState state) {
//        return Blocks.LEAVES.isOpaqueCube(state);
//    }
//    
//    @SideOnly(Side.CLIENT)
//    public BlockRenderLayer getBlockLayer1()
//    {
//        return this.leavesFancy ? BlockRenderLayer.CUTOUT_MIPPED : BlockRenderLayer.SOLID;
//    }
//    
//    @Override
//    @SideOnly(Side.CLIENT)
//    public boolean shouldSideBeRendered(@Nonnull IBlockState blockState, @Nonnull IBlockAccess blockAccess, @Nonnull BlockPos pos, @Nonnull EnumFacing side) {
//        this.leavesFancy = !Blocks.LEAVES.isOpaqueCube(blockState);
//
//        return super.shouldSideBeRendered(blockState, blockAccess, pos, side);
//    }
}
