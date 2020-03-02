package com.MrpYA45.TheBoyScoutMod.entity.golems.ai;

import com.MrpYA45.TheBoyScoutMod.entity.golems.EntityBaseGolem;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RestGoal extends Goal {

	private EntityBaseGolem entity;
	private World worldIn;

	public RestGoal(EntityBaseGolem entity) {
		this.entity = entity;
		this.worldIn = entity.getEntityWorld();
	}

	@Override
	public boolean shouldExecute() {
		return !worldIn.isDaytime() && entity.getRestPos() != null;
	}

	@Override
	public void tick() {
		System.out.println("GOLEM NIGHT");
		BlockPos pos = entity.getRestPos();
		System.out.println("Tengo esta pos: " + pos);
		this.entity.getNavigator().tryMoveToXYZ(pos.getX(), pos.getY(), pos.getZ(), 2.0F);
	}

	@Override
	public boolean shouldContinueExecuting() {
		return !worldIn.isDaytime();
	}

}
