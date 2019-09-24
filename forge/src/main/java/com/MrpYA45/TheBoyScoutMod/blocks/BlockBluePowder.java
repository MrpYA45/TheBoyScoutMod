package com.MrpYA45.TheBoyScoutMod.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BlockBluePowder extends FallingBlock {
	public BlockBluePowder(String name) {
		super(Properties.create(Material.SAND).hardnessAndResistance(0.6F).sound(SoundType.GROUND));
		setRegistryName(name);
	}

	@OnlyIn(Dist.CLIENT)
	public int getDustColor(BlockState state)
    {
    	return 4137;
	}

//	@Override
//	public void getDrops(BlockState state, NonNullList<ItemStack> drops, World world, BlockPos pos, int fortune) {
//		drops.clear();
//		Random rand = new Random();
//		drops.add(new ItemStack(ModItems.BLUE_POWDER, 1 + rand.nextInt(2) + fortune));
//	}
}
