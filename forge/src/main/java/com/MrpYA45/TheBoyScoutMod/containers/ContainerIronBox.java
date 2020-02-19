package com.MrpYA45.TheBoyScoutMod.containers;

import com.MrpYA45.TheBoyScoutMod.init.ModContainers;
import com.MrpYA45.TheBoyScoutMod.tile_entities.TileEntityIronBox;

import net.minecraft.entity.player.PlayerInventory;

public class ContainerIronBox extends ContainerBaseBox {

	public ContainerIronBox(final int windowID, PlayerInventory player) {
		this(windowID, player, new TileEntityIronBox());
	}

	public ContainerIronBox(int windowID, PlayerInventory player, TileEntityIronBox te) {
		super(windowID, player, te, ModContainers.IRON_BOX);
	}

}
