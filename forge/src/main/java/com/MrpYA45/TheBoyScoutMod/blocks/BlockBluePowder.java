package com.MrpYA45.TheBoyScoutMod.blocks;

import java.util.Random;

import com.MrpYA45.TheBoyScoutMod.init.ModItems;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockBluePowder extends BlockFalling {
	public BlockBluePowder(String name) {
		super(Properties.create(Material.SAND).hardnessAndResistance(0.6F).sound(SoundType.GROUND));
		setRegistryName(name);
	}

	@OnlyIn(Dist.CLIENT)
	public int getDustColor(IBlockState state)
    {
    	return 4137;
	}

	@Override
	public void getDrops(IBlockState state, NonNullList<ItemStack> drops, World world, BlockPos pos, int fortune) {
		drops.clear();
		Random rand = new Random();
		drops.add(new ItemStack(ModItems.BLUE_POWDER, 1 + rand.nextInt(2) + fortune));
	}
}