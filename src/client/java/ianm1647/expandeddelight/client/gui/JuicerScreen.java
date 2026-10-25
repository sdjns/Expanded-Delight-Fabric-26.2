package ianm1647.expandeddelight.client.gui;

import ianm1647.expandeddelight.common.block.entity.container.JuicerMenu;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

/**
 * Juicer container screen. The 26.2 GUI pipeline was rewritten around
 * GuiGraphicsExtractor; this keeps the functional container UI and leaves the
 * custom background/progress arrow for a later pass.
 */
public class JuicerScreen extends AbstractContainerScreen<JuicerMenu> {
    public JuicerScreen(JuicerMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
    }
}
