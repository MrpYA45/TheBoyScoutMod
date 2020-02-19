package com.MrpYA45.TheBoyScoutMod.containers;

import com.MrpYA45.TheBoyScoutMod.init.ModContainers;
import com.MrpYA45.TheBoyScoutMod.tile_entities.TileEntityDiamondBox;

import net.minecraft.entity.player.PlayerInventory;

public class ContainerDiamondBox extends ContainerBaseBox {

	public ContainerDiamondBox(final int windowID, PlayerInventory player) {
		this(windowID, player, new TileEntityDiamondBox());
	}

	public ContainerDiamondBox(int windowID, PlayerInventory player, TileEntityDiamondBox te) {
		super(windowID, player, te, ModContainers.DIAMOND_BOX);
	}

}
