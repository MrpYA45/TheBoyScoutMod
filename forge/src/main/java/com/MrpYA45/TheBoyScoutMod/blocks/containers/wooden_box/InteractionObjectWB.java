package com.MrpYA45.TheBoyScoutMod.blocks.containers.wooden_box;

import com.MrpYA45.TheBoyScoutMod.Main;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IInteractionObject;

public class InteractionObjectWB implements IInteractionObject {

	private final TileEntityWoodenBox inventory;
	
	public InteractionObjectWB(TileEntityWoodenBox inventory) {
		this.inventory = inventory;
	}

	@Override
	public ITextComponent getName() {
		return null;
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}

	@Override
	public ITextComponent getCustomName() {
		return null;
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		return new ContainerWoodenBox(playerInventory, inventory);
	}

	@Override
	public String getGuiID() {
		return Main.MOD_ID + ":wooden_box_gui";
	}

}
