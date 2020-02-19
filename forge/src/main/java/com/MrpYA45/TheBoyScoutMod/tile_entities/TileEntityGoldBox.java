package com.MrpYA45.TheBoyScoutMod.tile_entities;

import com.MrpYA45.TheBoyScoutMod.init.ModTileEntities;

public class TileEntityGoldBox extends TileEntityBaseBox {

	public TileEntityGoldBox() {
		super(ModTileEntities.GOLD_BOX);
	}

	@Override
	public int getSize() {
		return 54;
	}

}