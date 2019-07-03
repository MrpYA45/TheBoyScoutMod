// Date: 16/11/2016 17:28:10
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package com.MrpYA45.TheBoyScoutMod.entity.model;

import net.minecraft.client.renderer.entity.model.ModelBase;
import net.minecraft.client.renderer.entity.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelGolem extends ModelBase
{
  //fields
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer head;
  
  public ModelGolem()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      rightleg = new ModelRenderer(this, 41, 0);
      rightleg.addBox(0F, 0F, 0F, 2, 6, 2);
      rightleg.setRotationPoint(0F, 18F, -1F);
      rightleg.setTextureSize(64, 32);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 30, 0);
      leftleg.addBox(0F, 0F, 0F, 2, 6, 2);
      leftleg.setRotationPoint(-2F, 18F, -1F);
      leftleg.setTextureSize(64, 32);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      body = new ModelRenderer(this, 52, 0);
      body.addBox(0F, 0F, 0F, 4, 6, 2);
      body.setRotationPoint(-2F, 12F, -1F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 19, 0);
      rightarm.addBox(0F, 0F, 0F, 2, 6, 2);
      rightarm.setRotationPoint(2F, 12F, -1F);
      rightarm.setTextureSize(64, 32);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0F, 0F);
      leftarm = new ModelRenderer(this, 8, 0);
      leftarm.addBox(0F, 0F, 0F, 2, 6, 2);
      leftarm.setRotationPoint(-4F, 12F, -1F);
      leftarm.setTextureSize(64, 32);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, 0F);
      head = new ModelRenderer(this, 48, 11);
      head.addBox(0F, 0F, 0F, 4, 4, 4);
      head.setRotationPoint(-2F, 8F, -2F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    rightleg.render(f5);
    leftleg.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    head.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e)
  {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 2.0F * f1 * 0.5F;
		this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
  }

}
