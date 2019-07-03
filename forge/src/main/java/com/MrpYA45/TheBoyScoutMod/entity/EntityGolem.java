package com.MrpYA45.TheBoyScoutMod.entity;

import com.MrpYA45.TheBoyScoutMod.init.ModEntities;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIOcelotAttack;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityGolem extends EntityAnimal {

	public EntityGolem(World worldIn) {
		super(ModEntities.GOLEM, worldIn);
		this.setSize(0.5F, 1.0F);
	}

	@Override
	public EntityGolem createChild(EntityAgeable ageable) {
		return new EntityGolem(world);
	}

	@Override
	public float getEyeHeight() {
		return 0.9F;
	}

	@Override
	protected void initEntityAI() {
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAILeapAtTarget(this, 0.3F));
		this.tasks.addTask(3, new EntityAIOcelotAttack(this));
		this.tasks.addTask(4, new EntityAIMate(this, 0.8D));
		this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 0.8D, 1.0000001E-5F));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
	}

	public void updateAITasks() {
		if (this.getMoveHelper().isUpdating()) {
			double d0 = this.getMoveHelper().getSpeed();

			if (d0 == 0.6D) {
				this.setSneaking(true);
				this.setSprinting(false);
			} else if (d0 == 1.33D) {
				this.setSneaking(false);
				this.setSprinting(true);
			} else {
				this.setSneaking(false);
				this.setSprinting(false);
			}
		} else {
			this.setSneaking(false);
			this.setSprinting(false);
		}
	}

	@Override
	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
	}

	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == Items.COD;
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
}