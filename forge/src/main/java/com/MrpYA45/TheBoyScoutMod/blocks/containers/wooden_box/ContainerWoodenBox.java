package com.MrpYA45.TheBoyScoutMod.blocks.containers.wooden_box;

import javax.annotation.Nullable;

import com.MrpYA45.TheBoyScoutMod.init.ModContainers;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerWoodenBox extends Container {
	
	private final TileEntityWoodenBox te;

	public ContainerWoodenBox(final int windowID, PlayerInventory player) {
		this(windowID, player, new TileEntityWoodenBox());
	}

	public ContainerWoodenBox(final int windowID, PlayerInventory player, TileEntityWoodenBox te) {
		super(ModContainers.WOODEN_BOX, windowID);
		this.te  = te;
		ItemStackHandler inventory = te.getInventory();
		addOwnSlots(inventory);
		addPlayerSlots(player);
	}

	private void addPlayerSlots(PlayerInventory player) {
		//Main Inventory
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 9; col++) {
				int x = 8 + col * 18;
				int y = row * 18 + 66;
				this.addSlot(new Slot(player, col + row * 9 + 9, x, y));
			}
		}
		
		//Hotbar
		for (int row = 0; row < 9; row++) {
			int x = 8 + row * 18;
			int y = 124;
			this.addSlot(new Slot(player, row, x, y));
		}
	}
	
	private void addOwnSlots(ItemStackHandler inventory) {
		int x = 8;
		int y = 18;
		int row = 0;
		
		//Own Slots
		int slotIndex = 0;
		for (int i = 0; i < TileEntityWoodenBox.SIZE; i++) {
			if (row > 8) {
				x = 8;
				y += 18;
				row	= 0;
			}	
			this.addSlot(new SlotItemHandler(inventory, slotIndex, x, y){
				@Override
				public void onSlotChanged() {
					te.save();
				}
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
	public boolean canInteractWith(PlayerEntity playerIn) {
		return this.te.interact(playerIn);
	}

}
