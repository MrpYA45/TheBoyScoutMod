package com.MrpYA45.TheBoyScoutMod.tile_entities;

import com.MrpYA45.TheBoyScoutMod.init.ModTileEntities;

public class TileEntityEmeraldBox extends TileEntityBaseBox {

	public TileEntityEmeraldBox() {
		super(ModTileEntities.EMERALD_BOX);
	}

	@Override
	public int getSize() {
		return 90;
	}

}