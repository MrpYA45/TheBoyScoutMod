package com.MrpYA45.TheBoyScoutMod.blocks;

import java.util.Random;

import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;
import com.MrpYA45.TheBoyScoutMod.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockFullBlueberriesBush extends Block {

	public BlockFullBlueberriesBush(String name) {
		super(Properties.create(Material.PLANTS).hardnessAndResistance(0.2F).sound(SoundType.PLANT).needsRandomTick());
		setRegistryName(name);
	}

	@Override
	public boolean onBlockActivated(IBlockState state, World worldIn, BlockPos pos, EntityPlayer player, EnumHand hand,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();
		if (true) {
			worldIn.getBlockState(pos).dropBlockAsItem(worldIn, pos.up(), 0);
			worldIn.setBlockState(new BlockPos(i, j, k), ModBlocks.BLUEBERRIES_BUSH_BLOCK.getDefaultState(), 3);
		}
		return true;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, IBlockReader world, BlockPos pos,
			EntityPlayer player) {
		return new ItemStack(ModBlocks.BLUEBERRIES_BUSH_BLOCK);
	}

	@Override
	public void getDrops(IBlockState state, NonNullList<ItemStack> drops, World world, BlockPos pos, int fortune) {
		Random rand = new Random();
		drops.add(new ItemStack(ModItems.BLUEBERRIES, 1 + rand.nextInt(2)));
	}

}