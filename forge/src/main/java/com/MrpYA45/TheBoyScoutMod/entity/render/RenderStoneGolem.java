package com.MrpYA45.TheBoyScoutMod.entity.render;

import com.MrpYA45.TheBoyScoutMod.TheBoyScoutMod;
import com.MrpYA45.TheBoyScoutMod.entity.EntityStoneGolem;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class RenderStoneGolem extends BaseRenderGolem<EntityStoneGolem> {

	public static final ResourceLocation TEXTURES = new ResourceLocation(
			TheBoyScoutMod.MOD_ID + ":textures/entity/golem_stone.png");

	public RenderStoneGolem(EntityRendererManager manager) {
		super(manager);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityStoneGolem entity) {
		return TEXTURES;
	}
}
