package com.MrpYA45.TheBoyScoutMod.items.backpack;

import com.MrpYA45.TheBoyScoutMod.TheBoyScoutMod;
import com.MrpYA45.TheBoyScoutMod.containers.ContainerBackpack;

import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.ItemStackHandler;

public class ItemBackpack extends Item {

	public ItemBackpack() {
		super(new Properties().maxStackSize(1).group(TheBoyScoutMod.TBSM_TAB));
		this.setRegistryName("backpack");
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		if (!worldIn.isRemote) {
			NetworkHooks.openGui((ServerPlayerEntity) playerIn, new InterfaceBackpack());
		}
		return new ActionResult<ItemStack>(ActionResultType.SUCCESS, stack);
	}

	public static ItemStackHandler getInventory(ItemStack stack) {
		if (stack.isEmpty()) return null;
		ItemStackHandler handler = new ItemStackHandler(18);
		if (stack.hasTag()) {
			handler.deserializeNBT(stack.getTag().getCompound("inv"));
		}
		return handler;
	}

	public static class InterfaceBackpack implements INamedContainerProvider {

		@Override
		public ITextComponent getDisplayName() {
			return NarratorChatListener.field_216868_a;
		}

		@Override
		public Container createMenu(int windowID, PlayerInventory playerInventory, PlayerEntity playerIn) {
			return new ContainerBackpack(windowID, playerInventory);
		}
	}

}
