package com.MrpYA45.TheBoyScoutMod.entity.render;

import com.MrpYA45.TheBoyScoutMod.Main;
import com.MrpYA45.TheBoyScoutMod.entity.EntityGolem;
import com.MrpYA45.TheBoyScoutMod.entity.model.ModelGolem;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGolem extends RenderLiving<EntityGolem> {

	public static final ResourceLocation TEXTURES = new ResourceLocation(Main.MOD_ID + ":textures/entity/golem.png");

	public RenderGolem(RenderManager manager) {
		super(manager, new ModelGolem(), 0.5F);
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