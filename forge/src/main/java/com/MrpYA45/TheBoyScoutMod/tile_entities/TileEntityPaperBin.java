package com.MrpYA45.TheBoyScoutMod.tile_entities;

import com.MrpYA45.TheBoyScoutMod.blocks.boxes.BlockPaperBin;
import com.MrpYA45.TheBoyScoutMod.init.ModTileEntities;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;

public class TileEntityPaperBin extends TileEntityBaseBox implements ITickableTileEntity {

	public TileEntityPaperBin() {
		super(ModTileEntities.PAPER_BIN);
	}

	@Override
	public int getSize() {
		return 1;
	}

	@Override
	public void tick() {
		if (!this.world.isRemote) {
			if (world.getBlockState(pos).get(BlockPaperBin.ENABLED)) {
				ItemStack stack = getInventory().getStackInSlot(0);
				if (stack != ItemStack.EMPTY) {
					stack.shrink(1);
				}
			}
		}
	}
}