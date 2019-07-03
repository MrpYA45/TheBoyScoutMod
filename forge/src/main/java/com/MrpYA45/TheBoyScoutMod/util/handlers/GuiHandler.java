package com.MrpYA45.TheBoyScoutMod.util.handlers;

import javax.annotation.Nullable;

import com.MrpYA45.TheBoyScoutMod.Main;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.wooden_box.GuiWoodenBox;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.wooden_box.TileEntityWoodenBox;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.FMLPlayMessages;

public class GuiHandler {
	@Nullable
	public static GuiScreen DisplayStorageGUI(FMLPlayMessages.OpenContainer container) {
		BlockPos pos = container.getAdditionalData().readBlockPos();

		switch (container.getId().toString()) {
		case (Main.MOD_ID + ":wooden_box_gui"):
			return new GuiWoodenBox(Minecraft.getInstance().player.inventory,
					(TileEntityWoodenBox) Minecraft.getInstance().world.getTileEntity(pos));
		default:
			return null;
		}
	}
}