package com.MrpYA45.TheBoyScoutMod.blocks;

import java.util.Random;

import com.MrpYA45.TheBoyScoutMod.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class BlockBlueberriesBush extends Block {

	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 1);

	public BlockBlueberriesBush(String name) {
		super(Properties.create(Material.PLANTS).hardnessAndResistance(0.2F).sound(SoundType.PLANT).needsRandomTick());
		setRegistryName(name);
		this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)));
	}

	@Override
	public ToolType getHarvestTool(IBlockState state) {
		return ToolType.AXE;
	}

	public IntegerProperty getAgeProperty() {
		return AGE;
	}

	public boolean isMaxAge(IBlockState state) {
		return state.get(this.getAgeProperty()) >= 1;
	}

	@Override
	public void randomTick(IBlockState state, World worldIn, BlockPos pos, Random random) {
		if (!isMaxAge(state)) {
			worldIn.setBlockState(pos, state.cycle(AGE), 2);
		}
	}

	@Override
	public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer player, EnumHand hand,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!worldIn.isRemote) {
			if (isMaxAge(state)) {
				worldIn.setBlockState(pos, state.cycle(AGE), 2);
				Random rand = new Random();
				ItemStack stack = new ItemStack(ModItems.BLUEBERRIES, 1 + rand.nextInt(2));
				worldIn.spawnEntity(new EntityItem(worldIn, pos.getX(), pos.up().getY(), pos.getZ(), stack));
				return true;
			}
		}
		return false;
	}

	protected void fillStateContainer(StateContainer.Builder<Block, IBlockState> builder) {
		builder.add(AGE);
	}

	@Override
	public void getDrops(IBlockState state, NonNullList<ItemStack> drops, World world, BlockPos pos, int fortune) {
		if (isMaxAge(state)) {
			Random rand = new Random();
			drops.add(new ItemStack(ModItems.BLUEBERRIES, 1 + rand.nextInt(2)));
		}
	}
}