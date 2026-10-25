package ianm1647.expandeddelight.client.event;

import ianm1647.expandeddelight.common.registry.EDBlockEntityTypes;
import ianm1647.expandeddelight.common.registry.EDEntityTypes;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.StandingSignRenderer;
import ianm1647.expandeddelight.client.renderer.CinnamonBoatRenderer;

public class ClientSetupEvents {
    public static void onRegisterRenderers() {
        EntityRendererRegistry.register(EDEntityTypes.CINNAMON_BOAT.get(), context -> new CinnamonBoatRenderer(context, false));
        EntityRendererRegistry.register(EDEntityTypes.CINNAMON_CHEST_BOAT.get(), context -> new CinnamonBoatRenderer(context, true));

        BlockEntityRenderers.register(EDBlockEntityTypes.CINNAMON_SIGN.get(), StandingSignRenderer::new);
        BlockEntityRenderers.register(EDBlockEntityTypes.CINNAMON_HANGING_SIGN.get(), HangingSignRenderer::new);
    }
}
