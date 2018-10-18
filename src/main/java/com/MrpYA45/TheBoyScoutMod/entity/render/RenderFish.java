package com.MrpYA45.TheBoyScoutMod.entity.render;

import com.MrpYA45.TheBoyScoutMod.entity.EntityFish;
import com.MrpYA45.TheBoyScoutMod.entity.model.ModelFish;
import com.MrpYA45.TheBoyScoutMod.util.Reference;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderFish extends RenderLiving<EntityFish> {

	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/fish.png");
	
	public RenderFish(RenderManager manager) {
		super(manager, new ModelFish(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityFish entity) {
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityFish entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}

}
