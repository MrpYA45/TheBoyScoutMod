package com.MrpYA45.TheBoyScoutMod.items;

import com.MrpYA45.TheBoyScoutMod.entity.golems.EntityBaseGolem;
import com.MrpYA45.TheBoyScoutMod.entity.golems.GolemJob;
import com.MrpYA45.TheBoyScoutMod.init.ModEntities;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StatuetteItem extends TBSMBaseItem {

	public StatuetteItem(String name) {
		super(name);
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		ItemStack stack = context.getItem();
		World worldIn = context.getWorld();
		BlockPos pos = context.getPos();
		BlockState state = worldIn.getBlockState(pos);
		PlayerEntity playerIn = context.getPlayer();
		if (state.getBlock() == Blocks.GOLD_BLOCK) {
			EntityBaseGolem entity = (EntityBaseGolem) ModEntities.GOLEM.spawn(worldIn, stack, playerIn, pos.up(), SpawnReason.EVENT, true, false);
			entity.setRestPos(pos.up());
			entity.setJob(GolemJob.FARMER);
			stack.shrink(1);
			return ActionResultType.SUCCESS;
		}
		return ActionResultType.FAIL;
	}
}
