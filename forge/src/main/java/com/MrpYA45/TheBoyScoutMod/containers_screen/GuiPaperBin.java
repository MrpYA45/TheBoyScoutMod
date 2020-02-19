package com.MrpYA45.TheBoyScoutMod.containers_screen;

import com.MrpYA45.TheBoyScoutMod.TheBoyScoutMod;
import com.MrpYA45.TheBoyScoutMod.containers.ContainerPaperBin;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class GuiPaperBin extends BaseScreenTBSM<ContainerPaperBin> {

	public GuiPaperBin(ContainerPaperBin screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
	}

	@Override
	public ResourceLocation getBackgroundTexture() {
		return new ResourceLocation(TheBoyScoutMod.MOD_ID + ":textures/gui/paper_bin_container.png");
	}

	@Override
	public TranslationTextComponent getTranslationComponent() {
		return new TranslationTextComponent("tile.paper_bin_container.name");
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