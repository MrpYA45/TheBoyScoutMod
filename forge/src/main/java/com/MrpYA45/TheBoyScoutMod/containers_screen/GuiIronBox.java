package com.MrpYA45.TheBoyScoutMod.containers_screen;

import com.MrpYA45.TheBoyScoutMod.TheBoyScoutMod;
import com.MrpYA45.TheBoyScoutMod.containers.ContainerIronBox;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class GuiIronBox extends BaseScreenTBSM<ContainerIronBox> {

	public GuiIronBox(ContainerIronBox screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
	}

	@Override
	public ResourceLocation getBackgroundTexture() {
		return new ResourceLocation(TheBoyScoutMod.MOD_ID + ":textures/gui/iron_container.png");
	}

	@Override
	public TranslationTextComponent getTranslationComponent() {
		return new TranslationTextComponent("block.tbsm.iron_box_container");
	}

	@Override
	public int getWidth() {
		return 176;
	}

	@Override
	public int getHeight() {
		return 184;
	}
}
