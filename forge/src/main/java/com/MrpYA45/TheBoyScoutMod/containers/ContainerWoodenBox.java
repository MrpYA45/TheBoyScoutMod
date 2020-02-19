package com.MrpYA45.TheBoyScoutMod.containers;

import com.MrpYA45.TheBoyScoutMod.init.ModContainers;
import com.MrpYA45.TheBoyScoutMod.tile_entities.TileEntityWoodenBox;

import net.minecraft.entity.player.PlayerInventory;

public class ContainerWoodenBox extends ContainerBaseBox {
	
	public ContainerWoodenBox(final int windowID, PlayerInventory player) {
		this(windowID, player, new TileEntityWoodenBox());
	}

	public ContainerWoodenBox(int windowID, PlayerInventory player, TileEntityWoodenBox te) {
		super(windowID, player, te, ModContainers.WOODEN_BOX);
	}

}
