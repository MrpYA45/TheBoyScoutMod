package com.MrpYA45.TheBoyScoutMod.entity.model;

import com.MrpYA45.TheBoyScoutMod.entity.golems.EntityBaseGolem;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.IHasArm;
import net.minecraft.client.renderer.entity.model.IHasHead;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelGolem<T extends EntityBaseGolem> extends EntityModel<T> implements IHasArm, IHasHead {

	public RendererModel golemHead;
	public RendererModel golemBody;
	public RendererModel golemRightArm;
	public RendererModel golemLeftArm;
	public RendererModel golemRightLeg;
	public RendererModel golemLeftLeg;
	public ModelGolem.ArmPose leftArmPose = ModelGolem.ArmPose.EMPTY;
	public ModelGolem.ArmPose rightArmPose = ModelGolem.ArmPose.EMPTY;

	public ModelGolem() {
		this(0.0F);
	}

	public ModelGolem(float modelSize) {
		this(modelSize, 0.0F, 64, 32);
	}

	public ModelGolem(float modelSize, float p_i1149_2_, int textureWidthIn, int textureHeightIn) {
		this.textureWidth = textureWidthIn;
		this.textureHeight = textureHeightIn;
		this.golemHead = new RendererModel(this, 48, 11);
		this.golemHead.addBox(-2.0F, -4.0F, -2.0F, 4, 4, 4);
		this.golemHead.setRotationPoint(0.0F, 12.0F + p_i1149_2_, 0.0F);
		this.golemBody = new RendererModel(this, 52, 0);
		this.golemBody.addBox(-2.0F, 0.0F, 0.0F, 4, 6, 2);
		this.golemBody.setRotationPoint(0.0F, 12.0F + p_i1149_2_, -1.0F);
		this.golemRightArm = new RendererModel(this, 19, 0);
		this.golemRightArm.addBox(-1.0F, -1.0F, -1.0F, 2, 6, 2, modelSize);
		this.golemRightArm.setRotationPoint(3.0F, 13.0F + p_i1149_2_, 0.0F);
		this.golemLeftArm = new RendererModel(this, 8, 0);
		this.golemLeftArm.mirror = true;
		this.golemLeftArm.addBox(-1.0F, -1.0F, -1.0F, 2, 6, 2, modelSize);
		this.golemLeftArm.setRotationPoint(-3.0F, 13.0F + p_i1149_2_, 0.0F);
		this.golemRightLeg = new RendererModel(this, 41, 0);
		this.golemRightLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2);
		this.golemRightLeg.setRotationPoint(1.0F, 18.0F + p_i1149_2_, 0.0F);
		this.golemLeftLeg = new RendererModel(this, 30, 0);
		this.golemLeftLeg.mirror = true;
		this.golemLeftLeg.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2);
		this.golemLeftLeg.setRotationPoint(-1.0F, 18.0F + p_i1149_2_, 0.0F);
	}

	public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		this.golemRightLeg.render(scale);
		this.golemLeftLeg.render(scale);
		this.golemBody.render(scale);
		this.golemRightArm.render(scale);
		this.golemLeftArm.render(scale);
		this.golemHead.render(scale);
	}

	public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
//		this.golemBody.rotateAngleY = 0.0F;
//		this.golemRightArm.rotationPointZ = 0.0F;
//		this.golemRightArm.rotationPointX = -5.0F;
//		this.golemLeftArm.rotationPointZ = 0.0F;
//		this.golemLeftArm.rotationPointX = 5.0F;

		this.golemRightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.golemLeftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.golemRightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.golemLeftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;

		this.golemRightArm.rotateAngleY = 0.0F;
		this.golemRightArm.rotateAngleZ = 0.0F;
		switch (this.leftArmPose) {
		case EMPTY:
			this.golemLeftArm.rotateAngleY = 0.0F;
			break;
		case BLOCK:
			this.golemLeftArm.rotateAngleX = this.golemLeftArm.rotateAngleX * 0.5F - 0.9424779F;
			this.golemLeftArm.rotateAngleY = ((float) Math.PI / 6F);
			break;
		case ITEM:
			this.golemLeftArm.rotateAngleX = this.golemLeftArm.rotateAngleX * 0.5F - ((float) Math.PI / 10F);
			this.golemLeftArm.rotateAngleY = 0.0F;
		}

		switch (this.rightArmPose) {
		case EMPTY:
			this.golemRightArm.rotateAngleY = 0.0F;
			break;
		case BLOCK:
			this.golemRightArm.rotateAngleX = this.golemRightArm.rotateAngleX * 0.5F - 0.9424779F;
			this.golemRightArm.rotateAngleY = (-(float) Math.PI / 6F);
			break;
		case ITEM:
			this.golemRightArm.rotateAngleX = this.golemRightArm.rotateAngleX * 0.5F - ((float) Math.PI / 10F);
			this.golemRightArm.rotateAngleY = 0.0F;
			break;
		}

		if (this.swingProgress > 0.0F) {
			HandSide handside = this.func_217147_a(entityIn);
			RendererModel renderermodel = this.getArmForSide(handside);
			float f1 = this.swingProgress;
			this.golemBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt(f1) * ((float) Math.PI * 2F)) * 0.2F;
			if (handside == HandSide.LEFT) {
				this.golemBody.rotateAngleY *= -1.0F;
			}

			this.golemRightArm.rotationPointZ = MathHelper.sin(this.golemBody.rotateAngleY) * 5.0F;
			this.golemRightArm.rotationPointX = -MathHelper.cos(this.golemBody.rotateAngleY) * 5.0F;
			this.golemLeftArm.rotationPointZ = -MathHelper.sin(this.golemBody.rotateAngleY) * 5.0F;
			this.golemLeftArm.rotationPointX = MathHelper.cos(this.golemBody.rotateAngleY) * 5.0F;
			this.golemRightArm.rotateAngleY += this.golemBody.rotateAngleY;
			this.golemLeftArm.rotateAngleY += this.golemBody.rotateAngleY;
			this.golemLeftArm.rotateAngleX += this.golemBody.rotateAngleY;
			f1 = 1.0F - this.swingProgress;
			f1 = f1 * f1;
			f1 = f1 * f1;
			f1 = 1.0F - f1;
			float f2 = MathHelper.sin(f1 * (float) Math.PI);
			float f3 = MathHelper.sin(this.swingProgress * (float) Math.PI) * -(this.golemHead.rotateAngleX - 0.7F)
					* 0.75F;
			renderermodel.rotateAngleX = (float) ((double) renderermodel.rotateAngleX - ((double) f2 * 1.2D + (double) f3));
			renderermodel.rotateAngleY += this.golemBody.rotateAngleY * 2.0F;
			renderermodel.rotateAngleZ += MathHelper.sin(this.swingProgress * (float) Math.PI) * -0.4F;
		}
//
//		this.golemBody.rotateAngleX = 0.0F;
//		this.golemRightLeg.rotationPointZ = 0.1F;
//		this.golemLeftLeg.rotationPointZ = 0.1F;
//		this.golemRightLeg.rotationPointY = 12.0F;
//		this.golemLeftLeg.rotationPointY = 12.0F;
//		this.golemHead.rotationPointY = 0.0F;
//
//		this.golemRightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
//		this.golemLeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
//		this.golemRightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
//		this.golemLeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	}

	@Override
	public void postRenderArm(float scale, HandSide side) {
		this.getArmForSide(side).postRender(scale);
	}

	protected RendererModel getArmForSide(HandSide side) {
		return side == HandSide.LEFT ? this.golemLeftArm : this.golemRightArm;
	}

	@Override
	public RendererModel func_205072_a() {
		return this.golemHead;
	}

	protected HandSide func_217147_a(T p_217147_1_) {
		HandSide handside = p_217147_1_.getPrimaryHand();
		return p_217147_1_.swingingHand == Hand.MAIN_HAND ? handside : handside.opposite();
	}

	@OnlyIn(Dist.CLIENT)
	public static enum ArmPose {
		EMPTY, ITEM, BLOCK;
	}

}
