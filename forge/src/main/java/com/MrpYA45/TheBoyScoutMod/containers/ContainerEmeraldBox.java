package com.MrpYA45.TheBoyScoutMod.containers;

import com.MrpYA45.TheBoyScoutMod.init.ModContainers;
import com.MrpYA45.TheBoyScoutMod.tile_entities.TileEntityEmeraldBox;

import net.minecraft.entity.player.PlayerInventory;

public class ContainerEmeraldBox extends ContainerBaseBox {

	public ContainerEmeraldBox(final int windowID, PlayerInventory player) {
		this(windowID, player, new TileEntityEmeraldBox());
	}

	public ContainerEmeraldBox(int windowID, PlayerInventory player, TileEntityEmeraldBox te) {
		super(windowID, player, te, ModContainers.EMERALD_BOX);
	}

}
