package com.MrpYA45.TheBoyScoutMod.entity.render;

import com.MrpYA45.TheBoyScoutMod.Main;
import com.MrpYA45.TheBoyScoutMod.entity.EntityGoldGolem;
import com.MrpYA45.TheBoyScoutMod.entity.model.ModelGolem;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class RenderGoldGolem extends RenderLiving<EntityGoldGolem> {

	public static final ResourceLocation TEXTURES = new ResourceLocation(
			Main.MOD_ID + ":textures/entity/golem_gold.png");

	public RenderGoldGolem(EntityRendererManager manager) {
		super(manager, new ModelGolem(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityGoldGolem entity) {
		return TEXTURES;
	}

	@Override
	protected void applyRotations(EntityGoldGolem entityLiving, float p_77043_2_, float rotationYaw,
			float partialTicks) {
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}

}
