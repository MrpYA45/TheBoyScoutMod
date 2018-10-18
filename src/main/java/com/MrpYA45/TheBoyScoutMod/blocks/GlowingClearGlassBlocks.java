package com.MrpYA45.TheBoyScoutMod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class GlowingClearGlassBlocks extends ClearGlassBlocks {

	public GlowingClearGlassBlocks(String name, Material material, float hardness, float resistance, SoundType soundtype) {
		super(name, material, hardness, resistance, soundtype);
		setLightLevel(7.0F);
	}

}
