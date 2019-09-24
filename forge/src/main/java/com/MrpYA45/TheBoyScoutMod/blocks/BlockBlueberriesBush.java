package com.MrpYA45.TheBoyScoutMod.blocks;

import java.util.Random;

import com.MrpYA45.TheBoyScoutMod.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class BlockBlueberriesBush extends Block {

	public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 1);

	public BlockBlueberriesBush(String name) {
		super(Properties.create(Material.PLANTS).hardnessAndResistance(0.2F).sound(SoundType.PLANT).tickRandomly());
		setRegistryName(name);
		this.setDefaultState(this.stateContainer.getBaseState().with(AGE, Integer.valueOf(0)));
	}

	@Override
	public ToolType getHarvestTool(BlockState state) {
		return ToolType.AXE;
	}

	public IntegerProperty getAgeProperty() {
		return AGE;
	}

	public boolean isMaxAge(BlockState state) {
		return state.get(this.getAgeProperty()) >= 1;
	}

	@Override
	public void randomTick(BlockState state, World worldIn, BlockPos pos, Random random) {
		if (!isMaxAge(state)) {
			worldIn.setBlockState(pos, state.cycle(AGE), 2);
		}
	}

	@Override
	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,
			BlockRayTraceResult hit) {
		if (!worldIn.isRemote) {
			if (isMaxAge(state)) {
				worldIn.setBlockState(pos, state.cycle(AGE), 2);
				Random rand = new Random();
				ItemStack stack = new ItemStack(ModItems.BLUEBERRIES, 1 + rand.nextInt(2));
				spawnAsEntity(worldIn, pos.up(), stack);
				return true;
			}
		}
		return false;
	}

	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(AGE);
	}

//	@Override
//	public void getDrops(BlockState state, NonNullList<ItemStack> drops, World world, BlockPos pos, int fortune) {
//		if (isMaxAge(state)) {
//			Random rand = new Random();
//			drops.add(new ItemStack(ModItems.BLUEBERRIES, 1 + rand.nextInt(2)));
//		}
//	}
}