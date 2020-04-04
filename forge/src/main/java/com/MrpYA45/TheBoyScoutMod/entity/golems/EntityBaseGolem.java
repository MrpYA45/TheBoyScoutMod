package com.MrpYA45.TheBoyScoutMod.entity.golems;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.MrpYA45.TheBoyScoutMod.entity.golems.ai.HarvestGoal;
import com.MrpYA45.TheBoyScoutMod.entity.golems.ai.PlowGoal;
import com.MrpYA45.TheBoyScoutMod.entity.golems.ai.RestGoal;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.inventory.Inventory;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class EntityBaseGolem extends CreatureEntity {

	private Inventory inv = new Inventory(9);
	private BlockPos rest_pos;
	private List<BlockPos> effective_area = new ArrayList<BlockPos>();
	@Nullable
	private GolemJob job;
	public EntityBaseGolem(EntityType<? extends EntityBaseGolem> type, World worldIn) {
		super(type, worldIn);
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1.2D);
		;
	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new SwimGoal(this));
		this.goalSelector.addGoal(0, new RestGoal(this));
		this.goalSelector.addGoal(1, new PlowGoal(this));
		this.goalSelector.addGoal(2, new HarvestGoal(this));
		// this.goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, 0.4D));
		// this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 8.0F));
	}

	
	@Override
	public boolean canDespawn(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	public void readAdditional(CompoundNBT compound) {
		super.readAdditional(compound);
		this.setJob(GolemJob.byId(compound.getByte("Job")));
		int[] rest_coords = compound.getIntArray("RestPos");
		this.setRestPos(new BlockPos(rest_coords[0], rest_coords[1], rest_coords[2]));
	}

	public void writeAdditional(CompoundNBT compound) {
		super.writeAdditional(compound);
		compound.putByte("Job", (byte) this.job.getId());
		if (compound.getIntArray("RestPos").length == 0) {
			int[] rest_coords = { rest_pos.getX(), rest_pos.getY(), rest_pos.getZ() };
			compound.putIntArray("RestPos", rest_coords);
		}
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return null;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return null;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return null;
	}

	public void setJob(GolemJob job) {
		this.job = job;
	}

	public GolemJob getJob() {
		return job;
	}

	public Inventory getInventory() {
		return inv;
	}

	public void setEffectiveArea(BlockPos pos) {
		effective_area.clear();
		for (int i = -4; i < 5; i++) {
			for (int j = -4; j < 5; j++) {
				effective_area.add(pos.add(i, -1, j));
				effective_area.add(pos.add(-i, -1, -j));
			}
		}
	}

	public List<BlockPos> getEffectiveArea() {
		return effective_area;
	}

	public void setRestPos(BlockPos pos) {
		rest_pos = pos;
		setEffectiveArea(pos);
	}

	public BlockPos getRestPos() {
		return rest_pos;
	}
}
