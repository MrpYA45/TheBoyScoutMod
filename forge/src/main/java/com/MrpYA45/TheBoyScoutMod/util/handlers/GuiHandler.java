package com.MrpYA45.TheBoyScoutMod.util.handlers;

import com.MrpYA45.TheBoyScoutMod.blocks.containers.diamond_box.ContainerDiamondBox;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.diamond_box.GuiDiamondBox;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.diamond_box.TileEntityDiamondBox;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.emerald_box.ContainerEmeraldBox;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.emerald_box.GuiEmeraldBox;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.emerald_box.TileEntityEmeraldBox;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.gold_box.ContainerGoldBox;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.gold_box.GuiGoldBox;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.gold_box.TileEntityGoldBox;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.iron_box.ContainerIronBox;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.iron_box.GuiIronBox;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.iron_box.TileEntityIronBox;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.paper_bin.ContainerPaperBin;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.paper_bin.GuiPaperBin;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.paper_bin.TileEntityPaperBin;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.wooden_box.ContainerWoodenBox;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.wooden_box.GuiWoodenBox;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.wooden_box.TileEntityWoodenBox;

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
		if (te instanceof TileEntityWoodenBox) {
			return new ContainerWoodenBox(player.inventory, (TileEntityWoodenBox) te);
		}
		if (te instanceof TileEntityIronBox) {
			return new ContainerIronBox(player.inventory, (TileEntityIronBox) te);
		}
		if (te instanceof TileEntityGoldBox) {
			return new ContainerGoldBox(player.inventory, (TileEntityGoldBox) te);
		}
		if (te instanceof TileEntityDiamondBox) {
			return new ContainerDiamondBox(player.inventory, (TileEntityDiamondBox) te);
		}
		if (te instanceof TileEntityEmeraldBox) {
			return new ContainerEmeraldBox(player.inventory, (TileEntityEmeraldBox) te);
		}
		if (te instanceof TileEntityPaperBin) {
			return new ContainerPaperBin(player.inventory, (TileEntityPaperBin) te);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		TileEntity te = world.getTileEntity(pos);
		if (te instanceof TileEntityWoodenBox) {
			TileEntityWoodenBox containerTileEntity = (TileEntityWoodenBox) te;
			return new GuiWoodenBox(containerTileEntity, new ContainerWoodenBox(player.inventory, containerTileEntity));
		}
		if (te instanceof TileEntityIronBox) {
			TileEntityIronBox containerTileEntity = (TileEntityIronBox) te;
			return new GuiIronBox(containerTileEntity, new ContainerIronBox(player.inventory, containerTileEntity));
		}
		if (te instanceof TileEntityGoldBox) {
			TileEntityGoldBox containerTileEntity = (TileEntityGoldBox) te;
			return new GuiGoldBox(containerTileEntity, new ContainerGoldBox(player.inventory, containerTileEntity));
		}
		if (te instanceof TileEntityDiamondBox) {
			TileEntityDiamondBox containerTileEntity = (TileEntityDiamondBox) te;
			return new GuiDiamondBox(containerTileEntity, new ContainerDiamondBox(player.inventory, containerTileEntity));
		}
		if (te instanceof TileEntityEmeraldBox) {
			TileEntityEmeraldBox containerTileEntity = (TileEntityEmeraldBox) te;
			return new GuiEmeraldBox(containerTileEntity, new ContainerEmeraldBox(player.inventory, containerTileEntity));
		}
		if (te instanceof TileEntityPaperBin) {
			TileEntityPaperBin containerTileEntity = (TileEntityPaperBin) te;
			return new GuiPaperBin(containerTileEntity, new ContainerPaperBin(player.inventory, containerTileEntity));
		}
		return null;
	}

}
