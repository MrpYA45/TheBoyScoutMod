package com.MrpYA45.TheBoyScoutMod.entity.render;

import com.MrpYA45.TheBoyScoutMod.entity.golems.EntityBaseGolem;
import com.MrpYA45.TheBoyScoutMod.entity.model.ModelGolem;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public abstract class BaseRenderGolem<T extends EntityBaseGolem> extends MobRenderer<T, ModelGolem<T>> {

	public BaseRenderGolem(EntityRendererManager manager) {
		super(manager, new ModelGolem<T>(), 0.5F);
	}

	@Override
	protected abstract ResourceLocation getEntityTexture(T entity);

	@Override
	protected void applyRotations(T entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}

}
