package ianm1647.expandeddelight.client;

import ianm1647.expandeddelight.client.event.ClientSetupEvents;
import ianm1647.expandeddelight.client.gui.JuicerScreen;
import ianm1647.expandeddelight.common.registry.EDMenuTypes;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screens.MenuScreens;

public class ExpandedDelightClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientSetupEvents.onRegisterRenderers();
        MenuScreens.register(EDMenuTypes.JUICER.get(), JuicerScreen::new);
    }
}
