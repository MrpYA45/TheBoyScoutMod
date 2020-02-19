package com.MrpYA45.TheBoyScoutMod.blocks;

import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockLeavesCustom extends LeavesBlock {

	public BlockLeavesCustom(String name) {
		super(Properties.create(Material.LEAVES).hardnessAndResistance(0.2F).tickRandomly().sound(SoundType.PLANT));
		setRegistryName(name);
	}
	
//    @Override
//    protected void dropApple(World worldIn, BlockPos pos, BlockState state, int chance)
//    {
//    	if (state.getBlock() == ModBlocks.HAZEL_LEAVES_BLOCK) {
//    		if (worldIn.rand.nextInt(chance) <= 75)
//    		{
//    			spawnAsEntity(worldIn, pos, new ItemStack(ModItems.HAZELNUT));
//    		}
//    	}
//    }
}
