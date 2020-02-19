package com.MrpYA45.TheBoyScoutMod.entity.render;

import com.MrpYA45.TheBoyScoutMod.TheBoyScoutMod;
import com.MrpYA45.TheBoyScoutMod.entity.EntityEmeraldGolem;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

public class RenderEmeraldGolem extends BaseRenderGolem<EntityEmeraldGolem> {

	public static final ResourceLocation TEXTURES = new ResourceLocation(
			TheBoyScoutMod.MOD_ID + ":textures/entity/golem_emerald.png");

	public RenderEmeraldGolem(EntityRendererManager manager) {
		super(manager);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityEmeraldGolem entity) {
		return TEXTURES;
	}
}
