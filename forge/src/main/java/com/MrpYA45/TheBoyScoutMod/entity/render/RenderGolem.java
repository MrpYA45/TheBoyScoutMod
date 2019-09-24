package com.MrpYA45.TheBoyScoutMod.entity.render;

import com.MrpYA45.TheBoyScoutMod.Main;
import com.MrpYA45.TheBoyScoutMod.entity.EntityGolem;
import com.MrpYA45.TheBoyScoutMod.entity.model.ModelGolem;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderGolem extends MobRenderer<EntityGolem, ModelGolem<EntityGolem>> {

	public static final ResourceLocation TEXTURES = new ResourceLocation(Main.MOD_ID, "textures/entity/golem.png");

	public RenderGolem(EntityRendererManager manager) {
		super(manager, new ModelGolem<EntityGolem>(), 0.5F);
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
