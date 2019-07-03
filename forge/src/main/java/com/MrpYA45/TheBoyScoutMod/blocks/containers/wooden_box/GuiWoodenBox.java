package com.MrpYA45.TheBoyScoutMod.blocks.containers.wooden_box;

import java.awt.Color;

import com.MrpYA45.TheBoyScoutMod.Main;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;

public class GuiWoodenBox extends GuiContainer {
	public static final int WIDTH = 176;
	public static final int HEIGHT = 148;
	
	private static final ResourceLocation background = new ResourceLocation(Main.MOD_ID + ":textures/gui/wooden_container.png");
	
	public GuiWoodenBox(InventoryPlayer player, TileEntityWoodenBox inventory) {
		super(new ContainerWoodenBox(player, inventory));
		
		xSize = WIDTH;
		ySize = HEIGHT;
	}

	@Override
	public void render(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }
	
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        fontRenderer.drawString(new TextComponentTranslation("tile.wooden_box_container.name").getFormattedText(), 8, 6, Color.darkGray.getRGB());
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		mc.getTextureManager().bindTexture(background);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
	

}
