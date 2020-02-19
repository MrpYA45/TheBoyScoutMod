package com.MrpYA45.TheBoyScoutMod.tile_entities;

import com.MrpYA45.TheBoyScoutMod.init.ModTileEntities;

public class TileEntityWoodenBox extends TileEntityBaseBox {

	public TileEntityWoodenBox() {
		super(ModTileEntities.WOODEN_BOX);
	}

	@Override
	public int getSize() {
		return 18;
	}

}