package com.MrpYA45.TheBoyScoutMod.blocks.containers.wooden_box;

import com.MrpYA45.TheBoyScoutMod.init.ModTileEntities;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityWoodenBox extends TileEntity {

	public static final int SIZE = 18;

	private ItemStackHandler inventory = new ItemStackHandler(SIZE)/* {
		@Override
		protected void onContentsChanged(int slot) {
			TileEntityWoodenBox.this.markDirty();
		}

	}*/;

	public TileEntityWoodenBox() {
		super(ModTileEntities.WOODEN_BOX);
	}

	public void save() {
		IBlockState state = this.world.getBlockState(this.pos);
		this.world.markBlockRangeForRenderUpdate(this.pos, this.pos);
		this.world.notifyBlockUpdate(pos, state, state, 3);
		this.markDirty();
	}

	@Override
	public void read(NBTTagCompound compound) {
		this.inventory.deserializeNBT(compound.getCompound("inventory"));
		super.read(compound);
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound) {
		compound.setTag("inventory", inventory.serializeNBT());
		return super.write(compound);
	}

	public ItemStackHandler getInventory() {
		return this.inventory;
	}

	public boolean interact(EntityPlayer player) {
		return this.world.getTileEntity(this.pos) != this ? false : player.getDistanceSq(player) <= 64.0D;
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		return this.write(new NBTTagCompound());
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		this.read(pkt.getNbtCompound());
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		return new SPacketUpdateTileEntity(pos, 0, this.getUpdateTag());
	}

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, EnumFacing side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return LazyOptional.of(() -> this.inventory).cast();
		return super.getCapability(cap, side);
	}

}