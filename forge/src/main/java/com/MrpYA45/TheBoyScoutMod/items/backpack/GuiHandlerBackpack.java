package com.MrpYA45.TheBoyScoutMod.items.backpack;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandlerBackpack implements IGuiHandler {

	public static final int ITEM_BACKPACK = 0;

	@Override
	public Object getServerGuiElement(int ID, PlayerEntity player, World world, int x, int y, int z) {
		if(ID == ITEM_BACKPACK ) {
			return new ContainerBackpack(player.inventory, player);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, PlayerEntity player, World world, int x, int y, int z) {
		if(ID == ITEM_BACKPACK ) {
			return new ContainerBackpack(player.inventory, player);
		}
		return null;
	}

}
