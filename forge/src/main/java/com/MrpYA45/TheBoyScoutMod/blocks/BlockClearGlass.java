package com.MrpYA45.TheBoyScoutMod.blocks;

import net.minecraft.block.AbstractGlassBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;

public class BlockClearGlass extends AbstractGlassBlock {

	public BlockClearGlass(String name) {
		super(Properties.create(Material.GLASS).hardnessAndResistance(0.3F).sound(SoundType.GLASS));
		this.setRegistryName(name);
	}

   public BlockRenderLayer getRenderLayer() {
	      return BlockRenderLayer.TRANSLUCENT;
	   }
}
