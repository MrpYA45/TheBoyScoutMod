package com.MrpYA45.TheBoyScoutMod.blocks;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockFlowerCustom extends BlockFlower {
	public BlockFlowerCustom(String name) {
		super(Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0.0F).sound(SoundType.PLANT));
		setRegistryName(name);
	}
}