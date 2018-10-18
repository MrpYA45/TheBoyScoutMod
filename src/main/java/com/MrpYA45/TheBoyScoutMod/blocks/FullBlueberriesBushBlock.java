package com.MrpYA45.TheBoyScoutMod.blocks;

import java.util.Random;

import com.MrpYA45.TheBoyScoutMod.Main;
import com.MrpYA45.TheBoyScoutMod.init.ModBlocks;
import com.MrpYA45.TheBoyScoutMod.init.ModItems;
import com.MrpYA45.TheBoyScoutMod.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class FullBlueberriesBushBlock extends Block implements IHasModel {

	public FullBlueberriesBushBlock(String name, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(0.2F);
		setResistance(1);
		setHarvestLevel("axe",0);
		setSoundType(SoundType.PLANT);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer entity, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();
		if (true) {
			world.getBlockState(new BlockPos(i, j, k)).getBlock().dropBlockAsItem(world, new BlockPos(i, j + 1, k), world.getBlockState(new BlockPos(i, j, k)), 1);
			world.setBlockState(new BlockPos(i, j, k), ModBlocks.BLUEBERRIES_BUSH_BLOCK.getDefaultState(), 3);
		}
		return true;
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(ModBlocks.BLUEBERRIES_BUSH_BLOCK);
	}
	
	@Override
	public int quantityDropped(Random random) {
		return 1 + random.nextInt(2);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random par2Random, int par3) {
		return new ItemStack(ModItems.BLUEBERRIES).getItem();
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");		
	}

}