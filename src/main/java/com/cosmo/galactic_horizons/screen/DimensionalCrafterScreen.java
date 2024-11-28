package com.cosmo.galactic_horizons.screen;

import com.cosmo.galactic_horizons.GalacticHorizons;
import com.cosmo.galactic_horizons.block.entity.DimensionalCrafterBlockEntity;
import com.cosmo.galactic_horizons.effect.ModEffects;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class DimensionalCrafterScreen extends HandledScreen<DimensionalCrafterScreenHandler> {
	private static final Identifier TEXTURE = new Identifier(GalacticHorizons.MOD_ID, "textures/gui/dimensional_crafter_gui.png");

	public DimensionalCrafterScreen(DimensionalCrafterScreenHandler handler, PlayerInventory inventory, Text title) {
		super(handler, inventory, title);
	}
	public ButtonWidget button1;
	protected void init() {
		button1 = ButtonWidget.builder(Text.literal("Button 1"), button -> {
				this.handler.setDim(1);
		}).positionAndSize(width / 2 - 205, 20, 200, 20)
			.tooltip(Tooltip.create(Text.literal("Tooltip of button1"))).build();
		super.init();
		titleY = 1000;
		playerInventoryTitleY = 1000;
		addDrawableChild(button1);
	}
	protected void drawBackground(GuiGraphics context, float delta, int mouseX, int mouseY) {
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
		RenderSystem.setShaderTexture(0, TEXTURE);
		int x = (width - backgroundWidth) / 2;
		int y = (height - backgroundHeight) / 2;

		context.drawTexture(TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight);

		renderProgressArrow(context, x, y);
	}

	private void renderProgressArrow(GuiGraphics context, int x, int y) {
		if(handler.isCrafting()) {
			context.drawTexture(TEXTURE, x + 98, y + 35, 176, 0, handler.getScaledProgress(), 14);
		}
	}
	public void render(GuiGraphics context, int mouseX, int mouseY, float delta) {
		renderBackground(context);
		super.render(context, mouseX, mouseY, delta);
		drawMouseoverTooltip(context, mouseX, mouseY);
	}
}
