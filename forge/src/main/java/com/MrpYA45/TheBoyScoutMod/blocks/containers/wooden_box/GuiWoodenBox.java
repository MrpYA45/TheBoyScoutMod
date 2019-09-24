package com.MrpYA45.TheBoyScoutMod.blocks.containers.wooden_box;

import java.awt.Color;

import com.MrpYA45.TheBoyScoutMod.Main;

import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class GuiWoodenBox extends ContainerScreen<ContainerWoodenBox> {
	public static final int WIDTH = 176;
	public static final int HEIGHT = 148;
	
	private static final ResourceLocation background = new ResourceLocation(Main.MOD_ID + ":textures/gui/wooden_container.png");
	
	public GuiWoodenBox(ContainerWoodenBox container, PlayerInventory player, ITextComponent name) {
		super(container, player, name);
		
		xSize = WIDTH;
		ySize = HEIGHT;
	}

	@Override
	public void render(int mouseX, int mouseY, float partialTicks) {
        this.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }
	
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        font.drawString(new TranslationTextComponent("tile.wooden_box_container.name").getFormattedText(), 8, 6, Color.darkGray.getRGB());
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		minecraft.getTextureManager().bindTexture(background);
		blit(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
	

}
