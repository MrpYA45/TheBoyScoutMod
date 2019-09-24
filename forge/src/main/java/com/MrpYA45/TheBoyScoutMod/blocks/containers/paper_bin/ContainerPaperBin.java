package com.MrpYA45.TheBoyScoutMod.blocks.containers.paper_bin;

import javax.annotation.Nullable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerPaperBin  extends Container {
	
	private TileEntityPaperBin te;
	
	public ContainerPaperBin(IInventory playerInventory, TileEntityPaperBin te) {
		this.te  = te;
		addOwnSlots();
		addPlayerSlots(playerInventory);
	}

	private void addPlayerSlots(IInventory playerInventory) {
		//Main Inventory
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 9; col++) {
				int x = 8 + col * 18;
				int y = row * 18 + 102;
				this.addSlot(new Slot(playerInventory, col + row * 9 + 9, x, y));
			}
		}
		
		//Hotbar
		for (int row = 0; row < 9; row++) {
			int x = 8 + row * 18;
			int y = 160;
			this.addSlot(new Slot(playerInventory, row, x, y));
		}
	}
	
	private void addOwnSlots() {
		IItemHandler itemHandler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		int x = 8 + 18 * 4;
		int y = 18 + 18;
		
		//Own Slot
		addSlot(new SlotItemHandler(itemHandler, 0, x, y));
	}
	
	@Nullable
	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);
		
		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			
			if (index < TileEntityPaperBin.SIZE) {
				if (!this.mergeItemStack(itemstack1, TileEntityPaperBin.SIZE, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, TileEntityPaperBin.SIZE, false)) {
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
		return true;
	}

}