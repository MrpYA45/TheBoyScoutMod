package com.MrpYA45.TheBoyScoutMod.entity.render;

import com.MrpYA45.TheBoyScoutMod.TheBoyScoutMod;
import com.MrpYA45.TheBoyScoutMod.entity.EntityIronGolem;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class RenderIronGolem extends BaseRenderGolem<EntityIronGolem> {

	public static final ResourceLocation TEXTURES = new ResourceLocation(
			TheBoyScoutMod.MOD_ID + ":textures/entity/golem_iron.png");

	public RenderIronGolem(EntityRendererManager manager) {
		super(manager);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityIronGolem entity) {
		return TEXTURES;
	}
}
