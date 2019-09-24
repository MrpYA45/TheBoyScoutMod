package com.MrpYA45.TheBoyScoutMod.items.backpack;

import com.MrpYA45.TheBoyScoutMod.Main;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerEntityMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.ItemStackHandler;

public class ItemBackpack extends Item implements IInteractionObject {

	public ItemBackpack() {
		super(new Properties().maxStackSize(1).group(Main.TBSM_TAB));
		this.setRegistryName("backpack");
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack stack = playerIn.getHeldItem(handIn);
		if (!worldIn.isRemote && playerIn instanceof PlayerEntityMP) {
			PlayerEntityMP playerMP = (PlayerEntityMP) playerIn;
			NetworkHooks.openGui(playerMP, this);
		}
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}

	public static ItemStackHandler getInventory(ItemStack stack) {
		ItemStackHandler handler = new ItemStackHandler(18);
		if (stack.hasTag()) {
			handler.deserializeNBT(stack.getTag().getCompound("inventory"));
		}
		return handler;
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
	public Container createContainer(InventoryPlayer playerInventory, PlayerEntity playerIn) {
		return new ContainerBackpack(playerInventory, playerIn);
	}

	@Override
	public String getGuiID() {
		return Main.MOD_ID + "backpack_gui";
	}

}
