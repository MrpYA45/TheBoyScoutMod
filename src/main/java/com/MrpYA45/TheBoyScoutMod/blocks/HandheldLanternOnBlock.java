package com.MrpYA45.TheBoyScoutMod.blocks;

import java.util.Random;

import com.MrpYA45.TheBoyScoutMod.Main;
import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;
import com.MrpYA45.TheBoyScoutMod.init.ModItems;
import com.MrpYA45.TheBoyScoutMod.util.IHasModel;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class HandheldLanternOnBlock extends HandheldLanternBlock implements IHasModel {

	public HandheldLanternOnBlock(String name, Material material, float hardness, float resistance, SoundType soundtype) {
		super(name, material, hardness, resistance, soundtype);
		setCreativeTab(null);
		setLightLevel(1.0F);
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(ModBlocks.HANDHELD_LANTERN_BLOCK);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random par2Random, int par3) {
		return new ItemStack(ModBlocks.HANDHELD_LANTERN_BLOCK).getItem();
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer entity, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();
		if (true) {
			EnumFacing rot = world.getBlockState(pos).getValue(HandheldLanternOnBlock.FACING);
			world.setBlockState(new BlockPos(i, j, k), ModBlocks.HANDHELD_LANTERN_BLOCK.getDefaultState().withProperty(FACING, rot), 3);
		}
		return true;
	}

}
