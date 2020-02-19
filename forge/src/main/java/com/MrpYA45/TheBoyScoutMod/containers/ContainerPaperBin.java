package com.MrpYA45.TheBoyScoutMod.containers;

import javax.annotation.Nullable;

import com.MrpYA45.TheBoyScoutMod.init.ModContainers;
import com.MrpYA45.TheBoyScoutMod.tile_entities.TileEntityPaperBin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerPaperBin extends Container {

	private final TileEntityPaperBin te;

	public ContainerPaperBin(final int windowID, PlayerInventory player) {
		this(windowID, player, new TileEntityPaperBin());
	}

	public ContainerPaperBin(int windowID, PlayerInventory player, TileEntityPaperBin te) {
		super(ModContainers.PAPER_BIN, windowID);
		this.te = te;
		ItemStackHandler inventory = te.getInventory();
		addOwnSlots(inventory);
		addPlayerSlots(player);
	}

	private void addPlayerSlots(PlayerInventory player) {
		// Main Inventory
		int y = 0;
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 9; col++) {
				int x = 8 + col * 18;
				y = row * 18 + (18 + 4 * 18 + 12);
				this.addSlot(new Slot(player, col + row * 9 + 9, x, y));
			}
		}

		// Hotbar
		y += (18 + 4);
		for (int row = 0; row < 9; row++) {
			int x = 8 + row * 18;
			this.addSlot(new Slot(player, row, x, y));
		}
	}

	private void addOwnSlots(ItemStackHandler inventory) {
		int x = 8 + 18 * 4;
		int y = 2 * 18;

		// Own Slot
		this.addSlot(new SlotItemHandler(inventory, 0, x, y) {
			@Override
			public void onSlotChanged() {
				te.save();
			}
		});
	}

	@Nullable
	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (index < te.getSize()) {
				if (!this.mergeItemStack(itemstack1, te.getSize(), this.inventorySlots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, te.getSize(), false)) {
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
		return this.te.interact(playerIn);
	}

}