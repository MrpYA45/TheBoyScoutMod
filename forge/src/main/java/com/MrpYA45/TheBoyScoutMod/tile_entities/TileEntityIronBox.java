package com.MrpYA45.TheBoyScoutMod.tile_entities;

import com.MrpYA45.TheBoyScoutMod.init.ModTileEntities;

public class TileEntityIronBox extends TileEntityBaseBox {

	public TileEntityIronBox() {
		super(ModTileEntities.IRON_BOX);
	}

	@Override
	public int getSize() {
		return 36;
	}
}