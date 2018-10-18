package com.MrpYA45.TheBoyScoutMod.blocks.containers.diamond_box;

import java.awt.Color;

import com.MrpYA45.TheBoyScoutMod.util.Reference;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;

public class DiamondBoxGui extends GuiContainer {
	public static final int WIDTH = 176;
	public static final int HEIGHT = 256;
	
	private static final ResourceLocation background = new ResourceLocation(Reference.MOD_ID + ":textures/gui/diamond_container.png");
	
	public DiamondBoxGui(DiamondBoxTileEntity tileEntity, DiamondBoxContainer container) {
		super(container);
		
		xSize = WIDTH;
		ySize = HEIGHT;
	}
	
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        fontRenderer.drawString(new TextComponentTranslation("tile.diamond_box_container.name").getFormattedText(), 8, 6, Color.darkGray.getRGB());
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		mc.getTextureManager().bindTexture(background);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
	

}
