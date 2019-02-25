package com.MrpYA45.TheBoyScoutMod.util.handlers;

import com.MrpYA45.TheBoyScoutMod.blocks.containers.diamond_box.TileEntityDiamondBox;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.emerald_box.TileEntityEmeraldBox;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.gold_box.TileEntityGoldBox;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.iron_box.TileEntityIronBox;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.paper_bin.TileEntityPaperBin;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.wooden_box.TileEntityWoodenBox;
import com.MrpYA45.TheBoyScoutMod.util.Reference;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
	public static void registerTileEntity() {
		GameRegistry.registerTileEntity(TileEntityWoodenBox.class, Reference.MOD_ID + ":wooden_box");
		GameRegistry.registerTileEntity(TileEntityIronBox.class, Reference.MOD_ID + ":iron_box");
		GameRegistry.registerTileEntity(TileEntityGoldBox.class, Reference.MOD_ID + ":gold_box");
		GameRegistry.registerTileEntity(TileEntityDiamondBox.class, Reference.MOD_ID + ":diamond_box");
		GameRegistry.registerTileEntity(TileEntityEmeraldBox.class, Reference.MOD_ID + ":emerald_box");
		GameRegistry.registerTileEntity(TileEntityPaperBin.class, Reference.MOD_ID + ":paper_bin");
	}

}
