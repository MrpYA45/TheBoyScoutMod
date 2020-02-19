package com.MrpYA45.TheBoyScoutMod.entity.render;

import com.MrpYA45.TheBoyScoutMod.TheBoyScoutMod;
import com.MrpYA45.TheBoyScoutMod.entity.EntityFish;
import com.MrpYA45.TheBoyScoutMod.entity.model.ModelFish;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderFish extends MobRenderer<EntityFish, ModelFish<EntityFish>> {

	public static final ResourceLocation TEXTURES = new ResourceLocation(TheBoyScoutMod.MOD_ID, "textures/entity/fish.png");

	public RenderFish(EntityRendererManager manager) {
		super(manager, new ModelFish<EntityFish>(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityFish entity) {
		return TEXTURES;
	}

	@Override
	protected void applyRotations(EntityFish entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}

}
