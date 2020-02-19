package com.MrpYA45.TheBoyScoutMod.entity.render;

import com.MrpYA45.TheBoyScoutMod.TheBoyScoutMod;
import com.MrpYA45.TheBoyScoutMod.entity.EntityPenguin;
import com.MrpYA45.TheBoyScoutMod.entity.model.ModelPenguin;

import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderPenguin extends MobRenderer<EntityPenguin, ModelPenguin<EntityPenguin>> {

	public static final ResourceLocation TEXTURES = new ResourceLocation(TheBoyScoutMod.MOD_ID, "textures/entity/penguin.png");

	public RenderPenguin(EntityRendererManager manager) {
		super(manager, new ModelPenguin<EntityPenguin>(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityPenguin entity) {
		return TEXTURES;
	}

	@Override
	protected void applyRotations(EntityPenguin entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}

}
