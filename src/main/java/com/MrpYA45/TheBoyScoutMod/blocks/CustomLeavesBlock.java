package com.MrpYA45.TheBoyScoutMod.blocks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.MrpYA45.TheBoyScoutMod.Main;
import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;
import com.MrpYA45.TheBoyScoutMod.init.ModItems;
import com.MrpYA45.TheBoyScoutMod.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CustomLeavesBlock extends BlockLeaves implements IHasModel{

	public CustomLeavesBlock(String name) {
        setDefaultState(blockState.getBaseState().withProperty(CHECK_DECAY, Boolean.valueOf(true)).withProperty(DECAYABLE, Boolean.valueOf(true)));
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Main.tabTheBoyScoutMod);
		setHardness(0.2F);
		setResistance(1);
		setHarvestLevel("axe",0);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
    @Override
    protected void dropApple(World worldIn, BlockPos pos, IBlockState state, int chance)
    {
    	if (Block.isEqualTo(this,ModBlocks.HAZEL_LEAVES_BLOCK)) {
    		if (worldIn.rand.nextInt(chance) <= 75)
    		{
    			spawnAsEntity(worldIn, pos, new ItemStack(ModItems.HAZELNUT));
    		}
    	}
    }
	
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }
	
    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
        items.add(new ItemStack(this));
    }

    @Override
    protected ItemStack getSilkTouchDrop(IBlockState state)
    {
        return new ItemStack(Item.getItemFromBlock(this));
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(DECAYABLE, Boolean.valueOf((meta & 2) == 2)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 4) > 2));
    }
    
    @Override
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;

        if (!state.getValue(DECAYABLE).booleanValue())
        {
            i |= 4;
        }

        if (state.getValue(CHECK_DECAY).booleanValue())
        {
            i |= 8;
        }

        return i;
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {CHECK_DECAY, DECAYABLE});
    }
    
    @Override
    public int damageDropped(IBlockState state)
    {
        return 0;
    }
    
    @Override
    public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack)
    {
        if (!worldIn.isRemote && stack.getItem() == Items.SHEARS)
        {
            player.addStat(StatList.getBlockStats(this));
        }
        else
        {
            super.harvestBlock(worldIn, player, pos, state, te, stack);
        }
    }
    
	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        return NonNullList.withSize(1, new ItemStack(this));
	}

	@Override
	public EnumType getWoodType(int meta) {
		return null;
	}

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return Blocks.LEAVES.getBlockLayer();
    }
	
    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return Blocks.LEAVES.isOpaqueCube(state);
    }
    
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer1()
    {
        return this.leavesFancy ? BlockRenderLayer.CUTOUT_MIPPED : BlockRenderLayer.SOLID;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(@Nonnull IBlockState blockState, @Nonnull IBlockAccess blockAccess, @Nonnull BlockPos pos, @Nonnull EnumFacing side) {
        this.leavesFancy = !Blocks.LEAVES.isOpaqueCube(blockState);

        return super.shouldSideBeRendered(blockState, blockAccess, pos, side);
    }
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");		
	}

}
