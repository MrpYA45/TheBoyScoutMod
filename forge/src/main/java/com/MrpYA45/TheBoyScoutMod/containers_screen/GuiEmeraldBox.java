package com.MrpYA45.TheBoyScoutMod.containers_screen;

import com.MrpYA45.TheBoyScoutMod.TheBoyScoutMod;
import com.MrpYA45.TheBoyScoutMod.containers.ContainerEmeraldBox;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class GuiEmeraldBox extends BaseScreenTBSM<ContainerEmeraldBox> {

	public GuiEmeraldBox(ContainerEmeraldBox screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		minecraft.getTextureManager().bindTexture(getBackgroundTexture());
		blit(guiLeft, guiTop, 0, 0, xSize, ySize, xSize, ySize);
	}

	@Override
	public ResourceLocation getBackgroundTexture() {
		return new ResourceLocation(TheBoyScoutMod.MOD_ID + ":textures/gui/emerald_container.png");
	}

	@Override
	public TranslationTextComponent getTranslationComponent() {
		return new TranslationTextComponent("block.tbsm.emerald_box_container");
	}

	@Override
	public int getWidth() {
		return 176;
	}

	@Override
	public int getHeight() {
		return 292;
	}
}
