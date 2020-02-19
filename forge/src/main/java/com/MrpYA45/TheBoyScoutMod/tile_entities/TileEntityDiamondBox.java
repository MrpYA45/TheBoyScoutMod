package com.MrpYA45.TheBoyScoutMod.tile_entities;

import com.MrpYA45.TheBoyScoutMod.init.ModTileEntities;

public class TileEntityDiamondBox extends TileEntityBaseBox {

	public TileEntityDiamondBox() {
		super(ModTileEntities.DIAMOND_BOX);
	}

	@Override
	public int getSize() {
		return 72;
	}

}