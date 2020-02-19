package com.MrpYA45.TheBoyScoutMod.entity.render;

import com.MrpYA45.TheBoyScoutMod.TheBoyScoutMod;
import com.MrpYA45.TheBoyScoutMod.entity.EntityGolem;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class RenderGolem extends BaseRenderGolem<EntityGolem> {

	public static final ResourceLocation TEXTURES = new ResourceLocation(TheBoyScoutMod.MOD_ID, "textures/entity/golem.png");

	public RenderGolem(EntityRendererManager manager) {
		super(manager);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityGolem entity) {
		return TEXTURES;
	}

	@Override
	protected void applyRotations(EntityGolem entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}

}
