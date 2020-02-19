package com.MrpYA45.TheBoyScoutMod.entity.render;

import com.MrpYA45.TheBoyScoutMod.TheBoyScoutMod;
import com.MrpYA45.TheBoyScoutMod.entity.EntityDiamondGolem;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class RenderDiamondGolem extends BaseRenderGolem<EntityDiamondGolem> {

	public static final ResourceLocation TEXTURES = new ResourceLocation(
			TheBoyScoutMod.MOD_ID + ":textures/entity/golem_diamond.png");

	public RenderDiamondGolem(EntityRendererManager manager) {
		super(manager);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityDiamondGolem entity) {
		return TEXTURES;
	}
}
