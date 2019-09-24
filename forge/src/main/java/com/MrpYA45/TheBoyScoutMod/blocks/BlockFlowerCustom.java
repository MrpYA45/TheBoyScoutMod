package com.MrpYA45.TheBoyScoutMod.blocks;

import net.minecraft.block.FlowerBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.potion.Effects;

public class BlockFlowerCustom extends FlowerBlock {
	public BlockFlowerCustom(String name) {
		super(Effects.LUCK, 0, Properties.create(Material.PLANTS).doesNotBlockMovement().hardnessAndResistance(0.0F).sound(SoundType.PLANT));
		setRegistryName(name);
	}
}