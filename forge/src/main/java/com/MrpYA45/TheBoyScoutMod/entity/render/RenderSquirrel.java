package com.MrpYA45.TheBoyScoutMod.entity.render;

import com.MrpYA45.TheBoyScoutMod.Main;
import com.MrpYA45.TheBoyScoutMod.entity.EntitySquirrel;
import com.MrpYA45.TheBoyScoutMod.entity.model.ModelSquirrel;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderSquirrel extends MobRenderer<EntitySquirrel, ModelSquirrel<EntitySquirrel>> {

	public static final ResourceLocation TEXTURES = new ResourceLocation(Main.MOD_ID, "textures/entity/squirrel.png");

	public RenderSquirrel(EntityRendererManager manager) {
		super(manager, new ModelSquirrel<EntitySquirrel>(), 0.5F);
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
