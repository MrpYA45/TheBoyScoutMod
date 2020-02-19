package com.MrpYA45.TheBoyScoutMod.containers_screen;

import java.awt.Color;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public abstract class BaseScreenTBSM<T extends Container> extends ContainerScreen<T> {

	private ResourceLocation background;
	private TranslationTextComponent name;

	public BaseScreenTBSM(T screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(screenContainer, inv, titleIn);
		xSize = getWidth();
		ySize = getHeight();
		background = getBackgroundTexture();
		name = getTranslationComponent();
	}

	@Override
	public void render(int mouseX, int mouseY, float partialTicks) {
		this.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		super.render(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		font.drawString(name.getFormattedText(), 8, 6, Color.darkGray.getRGB());
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		minecraft.getTextureManager().bindTexture(background);
		blit(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

	public abstract ResourceLocation getBackgroundTexture();

	public abstract TranslationTextComponent getTranslationComponent();

	public abstract int getWidth();

	public abstract int getHeight();
}
