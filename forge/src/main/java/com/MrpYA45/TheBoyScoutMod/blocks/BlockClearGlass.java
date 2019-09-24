package com.MrpYA45.TheBoyScoutMod.blocks;

import net.minecraft.block.GlassBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockClearGlass extends GlassBlock {

	public BlockClearGlass(String name) {
		super(Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS));
		this.setRegistryName(name);
	}
}
