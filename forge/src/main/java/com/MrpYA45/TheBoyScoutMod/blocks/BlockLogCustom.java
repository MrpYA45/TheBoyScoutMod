package com.MrpYA45.TheBoyScoutMod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class BlockLogCustom extends BlockLog {

	public BlockLogCustom(String name) {
		super(MaterialColor.WOOD, Block.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN).hardnessAndResistance(2.0F).sound(SoundType.WOOD));
		this.setRegistryName(name);
	}
}
