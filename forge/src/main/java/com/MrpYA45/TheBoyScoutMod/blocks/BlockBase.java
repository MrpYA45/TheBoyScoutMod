package com.MrpYA45.TheBoyScoutMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.common.ToolType;

public class BlockBase extends Block {
	public BlockBase(String name, Material material, float f, float g, SoundType sound) {
		super(Properties.create(material).hardnessAndResistance(f, g).sound(sound));
		this.setRegistryName(name);
	}
	
	
	@Override
	public int getHarvestLevel(IBlockState state) {
		return 2;
	}
	
	@Override
	public ToolType getHarvestTool(IBlockState state) {
		return ToolType.PICKAXE;
	}

}