package com.MrpYA45.TheBoyScoutMod.tools;

import net.minecraft.item.ItemTier;
import net.minecraft.item.ShovelItem;
import net.minecraftforge.common.ToolType;

public class ItemScoutSpadeTool extends ShovelItem {

	public ItemScoutSpadeTool(String name) {
		super(ItemTier.IRON, 10.0F, 2.5F, new Properties().addToolType(ToolType.SHOVEL, 2).defaultMaxDamage(320));
		setRegistryName(name);
	}
}