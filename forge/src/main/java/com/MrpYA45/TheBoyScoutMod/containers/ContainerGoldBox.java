package com.MrpYA45.TheBoyScoutMod.containers;

import com.MrpYA45.TheBoyScoutMod.init.ModContainers;
import com.MrpYA45.TheBoyScoutMod.tile_entities.TileEntityGoldBox;

import net.minecraft.entity.player.PlayerInventory;

public class ContainerGoldBox extends ContainerBaseBox {

	public ContainerGoldBox(final int windowID, PlayerInventory player) {
		this(windowID, player, new TileEntityGoldBox());
	}

	public ContainerGoldBox(int windowID, PlayerInventory player, TileEntityGoldBox te) {
		super(windowID, player, te, ModContainers.GOLD_BOX);
	}
}
