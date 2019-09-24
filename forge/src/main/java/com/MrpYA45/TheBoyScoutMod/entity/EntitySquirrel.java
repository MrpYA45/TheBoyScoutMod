package com.MrpYA45.TheBoyScoutMod.entity;

import com.MrpYA45.TheBoyScoutMod.init.ModEntities;
import com.MrpYA45.TheBoyScoutMod.init.ModItems;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntitySquirrel extends AnimalEntity {

	public EntitySquirrel(EntityType<? extends EntitySquirrel> type, World worldIn) {
		super(type, worldIn);
	}


	@Override
	public AgeableEntity createChild(AgeableEntity ageable) {
		return (AgeableEntity) ModEntities.SQUIRREL.create(this.world);
	}

//	@Override
//	protected boolean canDespawn() {
//	return true;
//	}

//	@Override
//	public float getEyeHeight() {
//		return 0.45F;
//	}

	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new SwimGoal(this));
//		this.goalSelector.addGoal(1, new EntityAILeapAtTarget(this, 0.3F));
//		this.goalSelector.addGoal(2, new EntityAIOcelotAttack(this));
//		this.goalSelector.addGoal(3, new EntityAIMate(this, 0.8D));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
		this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
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

	protected void registerAttributes() {
		super.registerAttributes();
		this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
		this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)0.3F);
	}

	@Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == ModItems.HAZELNUT;
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
