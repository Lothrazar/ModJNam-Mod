package com.mrbysco.cactusmod.render.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelCactoni - Mrbysco
 * Created using Tabula 7.0.0
 */
public class ModelCactoni extends ModelBase {
    public ModelRenderer cacti_t;
    public ModelRenderer cacti_arm1;
    public ModelRenderer cacti_arm2;
    public ModelRenderer cacti_m;
    public ModelRenderer cacti_b;
    public ModelRenderer hat;
    public ModelRenderer moostache;
    public ModelRenderer bottom_bit1;
    public ModelRenderer bottom_bit2;
    public ModelRenderer bottom_bit3;
    public ModelRenderer bottom_bit4;
    public ModelRenderer middle_bit1;
    public ModelRenderer middle_bit2;
    public ModelRenderer middle_bit3;
    public ModelRenderer middle_bit4;
    public ModelRenderer middle_bit5;
    public ModelRenderer middle_bit6;
    public ModelRenderer middle_bit7;
    public ModelRenderer middle_bit8;
    public ModelRenderer middle_bit9;
    public ModelRenderer middle_bit10;
    public ModelRenderer middle_bit11;
    public ModelRenderer middle_bit12;
    public ModelRenderer top_bit1;
    public ModelRenderer top_bit2;
    public ModelRenderer moostache1;
    public ModelRenderer moostache2;
    public ModelRenderer moostache3;
    public ModelRenderer moostache4;
    public ModelRenderer moostache5;
    public ModelRenderer moostache6;
    public ModelRenderer cacti_arm11;
    public ModelRenderer cacti_arm12;
    public ModelRenderer cacti_arm21;
    public ModelRenderer cacti_arm22;

    public ModelCactoni() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.middle_bit7 = new ModelRenderer(this, 0, 86);
        this.middle_bit7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.middle_bit7.addBox(-6.0F, -8.0F, -7.0F, 1, 1, 1, 0.0F);
        this.cacti_arm11 = new ModelRenderer(this, 0, 44);
        this.cacti_arm11.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.cacti_arm11.addBox(10.5F, -14.0F, -3.0F, 6, 6, 6, 0.0F);
        this.middle_bit11 = new ModelRenderer(this, 0, 90);
        this.middle_bit11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.middle_bit11.addBox(-6.0F, -8.0F, 6.0F, 1, 1, 1, 0.0F);
        this.middle_bit1 = new ModelRenderer(this, 22, 84);
        this.middle_bit1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.middle_bit1.addBox(7.0F, -8.0F, -5.0F, 1, 1, 10, 0.0F);
        this.middle_bit8 = new ModelRenderer(this, 4, 86);
        this.middle_bit8.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.middle_bit8.addBox(-7.0F, -8.0F, -6.0F, 1, 1, 1, 0.0F);
        this.middle_bit4 = new ModelRenderer(this, 22, 82);
        this.middle_bit4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.middle_bit4.addBox(-5.0F, -8.0F, 7.0F, 10, 1, 1, 0.0F);
        this.moostache5 = new ModelRenderer(this, 40, 0);
        this.moostache5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.moostache5.addBox(5.0F, -1.0F, -5.5F, 1, 1, 1, 0.0F);
        this.middle_bit12 = new ModelRenderer(this, 4, 90);
        this.middle_bit12.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.middle_bit12.addBox(-7.0F, -8.0F, 5.0F, 1, 1, 1, 0.0F);
        this.moostache1 = new ModelRenderer(this, 40, 0);
        this.moostache1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.moostache1.addBox(1.0F, -2.0F, -5.5F, 2, 1, 1, 0.0F);
        this.cacti_arm22 = new ModelRenderer(this, 0, 44);
        this.cacti_arm22.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.cacti_arm22.addBox(-16.5F, -16.0F, -3.0F, 6, 6, 6, 0.0F);
        this.moostache3 = new ModelRenderer(this, 40, 0);
        this.moostache3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.moostache3.addBox(-5.0F, -0.0F, -5.5F, 4, 1, 1, 0.0F);
        this.middle_bit9 = new ModelRenderer(this, 0, 88);
        this.middle_bit9.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.middle_bit9.addBox(6.0F, -8.0F, 5.0F, 1, 1, 1, 0.0F);
        this.top_bit1 = new ModelRenderer(this, 0, 95);
        this.top_bit1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.top_bit1.addBox(-4.0F, -11.0F, -4.0F, 8, 4, 8, 0.0F);
        this.bottom_bit2 = new ModelRenderer(this, 0, 69);
        this.bottom_bit2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bottom_bit2.addBox(-5.0F, -7.0F, 6.0F, 10, 1, 1, 0.0F);
        this.moostache = new ModelRenderer(this, 40, 0);
        this.moostache.setRotationPoint(0.0F, -6.0F, 0.0F);
        this.moostache.addBox(-3.0F, -1.0F, -5.5F, 7, 1, 1, 0.0F);
        this.middle_bit6 = new ModelRenderer(this, 4, 84);
        this.middle_bit6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.middle_bit6.addBox(5.0F, -8.0F, -7.0F, 1, 1, 1, 0.0F);
        this.cacti_m = new ModelRenderer(this, 0, 22);
        this.cacti_m.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.cacti_m.addBox(-5.0F, -13.0F, -5.0F, 10, 12, 10, -0.5F);
        this.moostache4 = new ModelRenderer(this, 40, 0);
        this.moostache4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.moostache4.addBox(2.0F, -0.0F, -5.5F, 4, 1, 1, 0.0F);
        this.bottom_bit4 = new ModelRenderer(this, 22, 71);
        this.bottom_bit4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bottom_bit4.addBox(6.0F, -7.0F, -5.0F, 1, 1, 10, 0.0F);
        this.cacti_t = new ModelRenderer(this, 0, 0);
        this.cacti_t.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.cacti_t.addBox(-5.0F, -13.0F, -5.0F, 10, 10, 10, -0.5F);
        this.middle_bit2 = new ModelRenderer(this, 0, 84);
        this.middle_bit2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.middle_bit2.addBox(-8.0F, -8.0F, -5.0F, 1, 1, 10, 0.0F);
        this.top_bit2 = new ModelRenderer(this, 0, 107);
        this.top_bit2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.top_bit2.addBox(-3.0F, -15.0F, -3.0F, 6, 4, 6, 0.0F);
        this.moostache6 = new ModelRenderer(this, 40, 0);
        this.moostache6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.moostache6.addBox(-5.0F, -1.0F, -5.5F, 1, 1, 1, 0.0F);
        this.cacti_arm2 = new ModelRenderer(this, 0, 44);
        this.cacti_arm2.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.cacti_arm2.addBox(-10.5F, -1.0F, -3.0F, 6, 6, 6, 0.0F);
        this.bottom_bit3 = new ModelRenderer(this, 0, 71);
        this.bottom_bit3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bottom_bit3.addBox(-7.0F, -7.0F, -5.0F, 1, 1, 10, 0.0F);
        this.cacti_arm21 = new ModelRenderer(this, 0, 44);
        this.cacti_arm21.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.cacti_arm21.addBox(-16.5F, -10.0F, -3.0F, 6, 6, 6, 0.0F);
        this.bottom_bit1 = new ModelRenderer(this, 22, 69);
        this.bottom_bit1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bottom_bit1.addBox(-5.0F, -7.0F, -7.0F, 10, 1, 1, 0.0F);
        this.cacti_arm1 = new ModelRenderer(this, 0, 44);
        this.cacti_arm1.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.cacti_arm1.addBox(4.5F, -5.0F, -3.0F, 6, 6, 6, 0.0F);
        this.hat = new ModelRenderer(this, 0, 56);
        this.hat.setRotationPoint(0.0F, -6.0F, 0.0F);
        this.hat.addBox(-6.0F, -7.0F, -6.0F, 12, 1, 12, 0.0F);
        this.cacti_arm12 = new ModelRenderer(this, 0, 44);
        this.cacti_arm12.setRotationPoint(0.0F, 9.0F, 0.0F);
        this.cacti_arm12.addBox(10.5F, -20.0F, -3.0F, 6, 6, 6, 0.0F);
        this.middle_bit5 = new ModelRenderer(this, 0, 84);
        this.middle_bit5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.middle_bit5.addBox(6.0F, -8.0F, -6.0F, 1, 1, 1, 0.0F);
        this.moostache2 = new ModelRenderer(this, 40, 0);
        this.moostache2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.moostache2.addBox(-2.0F, -2.0F, -5.5F, 2, 1, 1, 0.0F);
        this.cacti_b = new ModelRenderer(this, 40, 22);
        this.cacti_b.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.cacti_b.addBox(-5.0F, -11.0F, -5.0F, 10, 12, 10, -0.5F);
        this.middle_bit3 = new ModelRenderer(this, 0, 82);
        this.middle_bit3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.middle_bit3.addBox(-5.0F, -8.0F, -8.0F, 10, 1, 1, 0.0F);
        this.middle_bit10 = new ModelRenderer(this, 4, 88);
        this.middle_bit10.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.middle_bit10.addBox(5.0F, -8.0F, 6.0F, 1, 1, 1, 0.0F);
        this.hat.addChild(this.middle_bit7);
        this.cacti_arm1.addChild(this.cacti_arm11);
        this.hat.addChild(this.middle_bit11);
        this.hat.addChild(this.middle_bit1);
        this.hat.addChild(this.middle_bit8);
        this.hat.addChild(this.middle_bit4);
        this.moostache.addChild(this.moostache5);
        this.hat.addChild(this.middle_bit12);
        this.moostache.addChild(this.moostache1);
        this.cacti_arm2.addChild(this.cacti_arm22);
        this.moostache.addChild(this.moostache3);
        this.hat.addChild(this.middle_bit9);
        this.hat.addChild(this.top_bit1);
        this.hat.addChild(this.bottom_bit2);
        this.cacti_t.addChild(this.moostache);
        this.hat.addChild(this.middle_bit6);
        this.moostache.addChild(this.moostache4);
        this.hat.addChild(this.bottom_bit4);
        this.hat.addChild(this.middle_bit2);
        this.hat.addChild(this.top_bit2);
        this.moostache.addChild(this.moostache6);
        this.hat.addChild(this.bottom_bit3);
        this.cacti_arm2.addChild(this.cacti_arm21);
        this.hat.addChild(this.bottom_bit1);
        this.cacti_t.addChild(this.hat);
        this.cacti_arm1.addChild(this.cacti_arm12);
        this.hat.addChild(this.middle_bit5);
        this.moostache.addChild(this.moostache2);
        this.hat.addChild(this.middle_bit3);
        this.hat.addChild(this.middle_bit10);
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        this.cacti_m.render(scale);
        this.cacti_t.render(scale);
        this.cacti_arm2.render(scale);
        this.cacti_arm1.render(scale);
        this.cacti_b.render(scale);
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
        this.cacti_t.rotateAngleY = netHeadYaw * 0.017453292F;
        this.cacti_t.rotateAngleX = headPitch * 0.017453292F;
        this.cacti_arm2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;
        this.cacti_arm1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount * 0.5F;
        this.cacti_arm2.rotateAngleY = 0.0F;
        this.cacti_arm1.rotateAngleY = 0.0F;
    }
}
