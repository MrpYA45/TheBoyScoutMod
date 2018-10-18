package com.MrpYA45.TheBoyScoutMod.util.handlers;

import com.MrpYA45.TheBoyScoutMod.blocks.containers.diamond_box.DiamondBoxContainer;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.diamond_box.DiamondBoxGui;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.diamond_box.DiamondBoxTileEntity;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.emerald_box.EmeraldBoxContainer;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.emerald_box.EmeraldBoxGui;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.emerald_box.EmeraldBoxTileEntity;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.gold_box.GoldBoxContainer;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.gold_box.GoldBoxGui;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.gold_box.GoldBoxTileEntity;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.iron_box.IronBoxContainer;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.iron_box.IronBoxGui;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.iron_box.IronBoxTileEntity;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.paper_bin.PaperBinContainer;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.paper_bin.PaperBinGui;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.paper_bin.PaperBinTileEntity;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.wooden_box.WoodenBoxContainer;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.wooden_box.WoodenBoxGui;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.wooden_box.WoodenBoxTileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		TileEntity te = world.getTileEntity(pos);
		if (te instanceof WoodenBoxTileEntity) {
			return new WoodenBoxContainer(player.inventory, (WoodenBoxTileEntity) te);
		}
		if (te instanceof IronBoxTileEntity) {
			return new IronBoxContainer(player.inventory, (IronBoxTileEntity) te);
		}
		if (te instanceof GoldBoxTileEntity) {
			return new GoldBoxContainer(player.inventory, (GoldBoxTileEntity) te);
		}
		if (te instanceof DiamondBoxTileEntity) {
			return new DiamondBoxContainer(player.inventory, (DiamondBoxTileEntity) te);
		}
		if (te instanceof EmeraldBoxTileEntity) {
			return new EmeraldBoxContainer(player.inventory, (EmeraldBoxTileEntity) te);
		}
		if (te instanceof PaperBinTileEntity) {
			return new PaperBinContainer(player.inventory, (PaperBinTileEntity) te);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		TileEntity te = world.getTileEntity(pos);
		if (te instanceof WoodenBoxTileEntity) {
			WoodenBoxTileEntity containerTileEntity = (WoodenBoxTileEntity) te;
			return new WoodenBoxGui(containerTileEntity, new WoodenBoxContainer(player.inventory, containerTileEntity));
		}
		if (te instanceof IronBoxTileEntity) {
			IronBoxTileEntity containerTileEntity = (IronBoxTileEntity) te;
			return new IronBoxGui(containerTileEntity, new IronBoxContainer(player.inventory, containerTileEntity));
		}
		if (te instanceof GoldBoxTileEntity) {
			GoldBoxTileEntity containerTileEntity = (GoldBoxTileEntity) te;
			return new GoldBoxGui(containerTileEntity, new GoldBoxContainer(player.inventory, containerTileEntity));
		}
		if (te instanceof DiamondBoxTileEntity) {
			DiamondBoxTileEntity containerTileEntity = (DiamondBoxTileEntity) te;
			return new DiamondBoxGui(containerTileEntity, new DiamondBoxContainer(player.inventory, containerTileEntity));
		}
		if (te instanceof EmeraldBoxTileEntity) {
			EmeraldBoxTileEntity containerTileEntity = (EmeraldBoxTileEntity) te;
			return new EmeraldBoxGui(containerTileEntity, new EmeraldBoxContainer(player.inventory, containerTileEntity));
		}
		if (te instanceof PaperBinTileEntity) {
			PaperBinTileEntity containerTileEntity = (PaperBinTileEntity) te;
			return new PaperBinGui(containerTileEntity, new PaperBinContainer(player.inventory, containerTileEntity));
		}
		return null;
	}

}
