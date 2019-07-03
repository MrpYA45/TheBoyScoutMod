package com.MrpYA45.TheBoyScoutMod.entity.render;

import com.MrpYA45.TheBoyScoutMod.Main;
import com.MrpYA45.TheBoyScoutMod.entity.EntitySquirrel;
import com.MrpYA45.TheBoyScoutMod.entity.model.ModelSquirrel;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSquirrel extends RenderLiving<EntitySquirrel> {

	public static final ResourceLocation TEXTURES = new ResourceLocation(Main.MOD_ID + ":textures/entity/squirrel.png");

	public RenderSquirrel(RenderManager manager) {
		super(manager, new ModelSquirrel(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntitySquirrel entity) {
		return TEXTURES;
	}

	@Override
	protected void applyRotations(EntitySquirrel entityLiving, float p_77043_2_, float rotationYaw,
			float partialTicks) {
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}

}