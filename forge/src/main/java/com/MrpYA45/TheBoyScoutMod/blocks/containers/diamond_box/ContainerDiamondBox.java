package com.MrpYA45.TheBoyScoutMod.blocks.containers.diamond_box;

import javax.annotation.Nullable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerDiamondBox extends Container {
	
	private TileEntityDiamondBox te;
	
	public ContainerDiamondBox(IInventory playerInventory, TileEntityDiamondBox te) {
		this.te  = te;
		addOwnSlots();
		addPlayerSlots(playerInventory);
	}

	private void addPlayerSlots(IInventory playerInventory) {
		//Main Inventory
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 9; col++) {
				int x = 8 + col * 18;
				int y = row * 18 + 174;
				this.addSlot(new Slot(playerInventory, col + row * 9 + 9, x, y));
			}
		}
		
		//Hotbar
		for (int row = 0; row < 9; row++) {
			int x = 8 + row * 18;
			int y = 232;
			this.addSlot(new Slot(playerInventory, row, x, y));
		}
	}
	
	private void addOwnSlots() {
		IItemHandler itemHandler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		int x = 8;
		int y = 18;
		int row = 0;
		
		//Own Slots
		int slotIndex = 0;
		for (int i = 0; i < itemHandler.getSlots(); i++) {
			if (row > 8) {
				x = 8;
				y += 18;
				row	= 0;
			}	
			addSlot(new SlotItemHandler(itemHandler, slotIndex, x, y));
			slotIndex++;
			row++;
			x += 18;
		}
	}
	
	@Nullable
	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if (index < TileEntityDiamondBox.SIZE) {
				if (!this.mergeItemStack(itemstack1, TileEntityDiamondBox.SIZE, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, TileEntityDiamondBox.SIZE, false)) {
				return ItemStack.EMPTY;
			}
			
			if (itemstack1.isEmpty()) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
		}
		
		return itemstack;
	}
	
	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return te.canInteractWith(playerIn);
	}

}
