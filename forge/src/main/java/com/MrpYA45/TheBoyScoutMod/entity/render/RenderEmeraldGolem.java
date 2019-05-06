package com.MrpYA45.TheBoyScoutMod.entity.render;

import com.MrpYA45.TheBoyScoutMod.entity.EntityEmeraldGolem;
import com.MrpYA45.TheBoyScoutMod.entity.model.ModelGolem;
import com.MrpYA45.TheBoyScoutMod.util.Reference;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderEmeraldGolem extends RenderLiving<EntityEmeraldGolem> {

	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/golem_emerald.png");
	
	public RenderEmeraldGolem(RenderManager manager) {
		super(manager, new ModelGolem(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityEmeraldGolem entity) {
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityEmeraldGolem entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}

}
