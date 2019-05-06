package com.MrpYA45.TheBoyScoutMod.entity;

import javax.annotation.Nullable;

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
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

public class EntityFish extends EntitySquid {

	public EntityFish(World worldIn) {
		super(worldIn);
		this.setSize(0.2F, 0.2F);
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
	
    @Nullable
    protected ResourceLocation getLootTable()
    {
        return null;
    }
    
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
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
