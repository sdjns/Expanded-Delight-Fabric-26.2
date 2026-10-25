package ianm1647.expandeddelight.client.gui;

import ianm1647.expandeddelight.ExpandedDelight;
import ianm1647.expandeddelight.common.block.entity.container.JuicerMenu;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

public class JuicerScreen extends AbstractContainerScreen<JuicerMenu> {
    private static final Identifier BACKGROUND = Identifier.fromNamespaceAndPath(ExpandedDelight.MODID, "textures/gui/juicer.png");
    private static final int ARROW_X = 71;
    private static final int ARROW_Y = 25;
    private static final int ARROW_HEIGHT = 17;

    public JuicerScreen(JuicerMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title, 176, 166);
        this.titleLabelX = 8;
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick) {
        super.extractBackground(graphics, mouseX, mouseY, partialTick);
        graphics.blit(RenderPipelines.GUI_TEXTURED, BACKGROUND, this.leftPos, this.topPos, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 256, 256);
    }

    @Override
    protected void extractLabels(GuiGraphicsExtractor graphics, int mouseX, int mouseY) {
        super.extractLabels(graphics, mouseX, mouseY);
        int progress = this.menu.getJuiceProgressionScaled();
        graphics.blit(RenderPipelines.GUI_TEXTURED, BACKGROUND, ARROW_X, ARROW_Y, 176.0F, 15.0F, progress + 1, ARROW_HEIGHT, 256, 256);
    }
}
