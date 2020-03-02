package com.MrpYA45.TheBoyScoutMod.entity.render;

import com.MrpYA45.TheBoyScoutMod.TheBoyScoutMod;
import com.MrpYA45.TheBoyScoutMod.entity.golems.EntityGoldGolem;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class RenderGoldGolem extends BaseRenderGolem<EntityGoldGolem> {

	public static final ResourceLocation TEXTURES = new ResourceLocation(
			TheBoyScoutMod.MOD_ID + ":textures/entity/golem_gold.png");

	public RenderGoldGolem(EntityRendererManager manager) {
		super(manager);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityGoldGolem entity) {
		return TEXTURES;
	}
}
