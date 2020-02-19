package com.MrpYA45.TheBoyScoutMod.containers;

import javax.annotation.Nullable;

import com.MrpYA45.TheBoyScoutMod.init.ModContainers;
import com.MrpYA45.TheBoyScoutMod.items.backpack.ItemBackpack;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerBackpack extends Container {

	private ItemStackHandler inventory = new ItemStackHandler(SIZE);

	private static final int SIZE = 18;

	private ItemStack backpack;

	public ContainerBackpack(int windowID, PlayerInventory playerInv) {
		super(ModContainers.BACKPACK, windowID);
		backpack = playerInv.player.getHeldItemMainhand();
		if (backpack.isEmpty()) {
			backpack = playerInv.player.getHeldItemOffhand();
		}
		this.inventory = ItemBackpack.getInventory(backpack);
		addOwnSlots(inventory);
		addPlayerSlots(playerInv);
	}

	private void addPlayerSlots(PlayerInventory playerInv) {
		// Main Inventory
		int y = 0;
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 9; col++) {
				int x = 8 + col * 18;
				y = row * 18 + (18 + (SIZE / 9) * 18 + 12);
				this.addSlot(new Slot(playerInv, col + row * 9 + 9, x, y));
			}
		}

		// Hotbar
		y += (18 + 4);
		for (int row = 0; row < 9; row++) {
			int x = 8 + row * 18;
			this.addSlot(new Slot(playerInv, row, x, y));
		}
	}

	private void addOwnSlots(ItemStackHandler inventory) {
		int x = 8;
		int y = 18;
		int row = 0;

		// Own Slots
		int slotIndex = 0;
		for (int i = 0; i < SIZE; i++) {
			if (row > 8) {
				x = 8;
				y += 18;
				row = 0;
			}
			this.addSlot(new SlotItemHandler(inventory, slotIndex, x, y) {
//				@Override
//				public void onSlotChanged() {
//					te.save();
//				}
			});
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

			if (index < SIZE) {
				if (!this.mergeItemStack(itemstack1, SIZE, this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, SIZE, false)) {
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
		return !backpack.isEmpty() && backpack.getItem() instanceof ItemBackpack;
	}

	@Override
	public void onContainerClosed(PlayerEntity playerIn) {
		if (!backpack.hasTag()) {
			backpack.setTag(new CompoundNBT());
		}
		backpack.getTag().put("inv", inventory.serializeNBT());
		super.onContainerClosed(playerIn);
	}
}
