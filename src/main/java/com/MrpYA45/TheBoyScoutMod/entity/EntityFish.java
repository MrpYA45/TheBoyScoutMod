package com.MrpYA45.TheBoyScoutMod.entity;

import com.MrpYA45.TheBoyScoutMod.init.ModItems;
import com.google.common.base.Predicate;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIOcelotAttack;
import net.minecraft.entity.ai.EntityAIOcelotSit;
import net.minecraft.entity.ai.EntityAISit;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityFish extends EntityAnimal {

	public EntityFish(World worldIn) {
		super(worldIn);
		this.setSize(0.2F, 0.2F);
	}
	
	@Override
	public EntityFish createChild(EntityAgeable ageable) {
		return new EntityFish(world);
	}
	
	@Override
	protected boolean canDespawn() {
	return true;
	}
	
	@Override
	public float getEyeHeight()
	{
		return 0.15F;
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
    
    public void updateAITasks()
    {
        if (this.getMoveHelper().isUpdating())
        {
            double d0 = this.getMoveHelper().getSpeed();

            if (d0 == 0.6D)
            {
                this.setSneaking(true);
                this.setSprinting(false);
            }
            else if (d0 == 1.33D)
            {
                this.setSneaking(false);
                this.setSprinting(true);
            }
            else
            {
                this.setSneaking(false);
                this.setSprinting(false);
            }
        }
        else
        {
            this.setSneaking(false);
            this.setSprinting(false);
        }
    }
    
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
    }
	
    @Override
    public boolean isBreedingItem(ItemStack stack)
    {
        return stack.getItem() == Items.FISH;
    }
    
	@Override
	protected SoundEvent getAmbientSound() 
	{
		return null;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource source) 
	{
		return null;
	}
	
	@Override
	protected SoundEvent getDeathSound() 
	{
		return null;
	}
}
