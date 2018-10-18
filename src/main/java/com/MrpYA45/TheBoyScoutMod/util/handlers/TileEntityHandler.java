package com.MrpYA45.TheBoyScoutMod.util.handlers;

import com.MrpYA45.TheBoyScoutMod.blocks.containers.diamond_box.DiamondBoxTileEntity;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.emerald_box.EmeraldBoxTileEntity;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.gold_box.GoldBoxTileEntity;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.iron_box.IronBoxTileEntity;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.paper_bin.PaperBinTileEntity;
import com.MrpYA45.TheBoyScoutMod.blocks.containers.wooden_box.WoodenBoxTileEntity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
	public static void registerTileEntity() {
		GameRegistry.registerTileEntity(WoodenBoxTileEntity.class, "wooden_box");
		GameRegistry.registerTileEntity(IronBoxTileEntity.class, "iron_box");
		GameRegistry.registerTileEntity(GoldBoxTileEntity.class, "gold_box");
		GameRegistry.registerTileEntity(DiamondBoxTileEntity.class, "diamond_box");
		GameRegistry.registerTileEntity(EmeraldBoxTileEntity.class, "emerald_box");
		GameRegistry.registerTileEntity(PaperBinTileEntity.class, "paper_bin");
	}

}
