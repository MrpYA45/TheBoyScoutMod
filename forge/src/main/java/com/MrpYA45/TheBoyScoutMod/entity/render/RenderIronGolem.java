package com.MrpYA45.TheBoyScoutMod.entity.render;

import com.MrpYA45.TheBoyScoutMod.Main;
import com.MrpYA45.TheBoyScoutMod.entity.EntityIronGolem;
import com.MrpYA45.TheBoyScoutMod.entity.model.ModelGolem;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderIronGolem extends RenderLiving<EntityIronGolem> {

	public static final ResourceLocation TEXTURES = new ResourceLocation(
			Main.MOD_ID + ":textures/entity/golem_iron.png");

	public RenderIronGolem(RenderManager manager) {
		super(manager, new ModelGolem(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityIronGolem entity) {
		return TEXTURES;
	}

	@Override
	protected void applyRotations(EntityIronGolem entityLiving, float p_77043_2_, float rotationYaw,
			float partialTicks) {
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}

}
