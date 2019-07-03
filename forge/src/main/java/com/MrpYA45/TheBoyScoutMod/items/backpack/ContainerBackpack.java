package com.MrpYA45.TheBoyScoutMod.items.backpack;

import javax.annotation.Nullable;

import com.MrpYA45.TheBoyScoutMod.blocks.containers.wooden_box.TileEntityWoodenBox;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerBackpack extends Container {

	private ItemStack stack;

	public ContainerBackpack(InventoryPlayer playerInventory, EntityPlayer playerIn) {
		stack = playerIn.getActiveItemStack();
		addOwnSlots(stack);
		addPlayerSlots(playerInventory);
	}

	private void addPlayerSlots(IInventory playerInventory) {
		// Main Inventory
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 9; col++) {
				int x = 8 + col * 18;
				int y = row * 18 + 66;
				this.addSlot(new Slot(playerInventory, col + row * 9 + 9, x, y));
			}
		}

		// Hotbar
		for (int row = 0; row < 9; row++) {
			int x = 8 + row * 18;
			int y = 124;
			this.addSlot(new Slot(playerInventory, row, x, y));
		}
	}

	private void addOwnSlots(ItemStack stack) {
		int x = 8;
		int y = 18;
		int row = 0;

		// Own Slots
		int slotIndex = 0;
		for (int i = 0; i < TileEntityWoodenBox.SIZE; i++) {
			if (row > 8) {
				x = 8;
				y += 18;
				row = 0;
			}
			addSlot(new SlotItemHandler(ItemBackpack.getInventory(stack), slotIndex, x, y));
			slotIndex++;
			row++;
			x += 18;
		}
	}

	@Nullable
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (index < TileEntityWoodenBox.SIZE) {
				if (!this.mergeItemStack(itemstack1, TileEntityWoodenBox.SIZE, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, TileEntityWoodenBox.SIZE, false)) {
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
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}

	@Override
	public void onContainerClosed(EntityPlayer player) {
		if (!stack.hasTag()) {
			stack.setTag(new NBTTagCompound());
		}
		ItemStackHandler stackHandler = ItemBackpack.getInventory(stack);
		stack.getTag().setTag("inventory", stackHandler.serializeNBT());
		super.onContainerClosed(player);
	}

}
