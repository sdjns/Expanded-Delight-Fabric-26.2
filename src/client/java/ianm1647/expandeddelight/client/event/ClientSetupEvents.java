package ianm1647.expandeddelight.client.event;

import ianm1647.expandeddelight.common.registry.EDBlockEntityTypes;
import ianm1647.expandeddelight.common.registry.EDEntityTypes;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.StandingSignRenderer;
import net.minecraft.client.renderer.entity.BoatRenderer;

public class ClientSetupEvents {
    public static void onRegisterRenderers() {
        EntityRendererRegistry.register(EDEntityTypes.CINNAMON_BOAT.get(), context -> new BoatRenderer(context, ModelLayers.OAK_BOAT));
        EntityRendererRegistry.register(EDEntityTypes.CINNAMON_CHEST_BOAT.get(), context -> new BoatRenderer(context, ModelLayers.OAK_CHEST_BOAT));

        BlockEntityRenderers.register(EDBlockEntityTypes.CINNAMON_SIGN.get(), StandingSignRenderer::new);
        BlockEntityRenderers.register(EDBlockEntityTypes.CINNAMON_HANGING_SIGN.get(), HangingSignRenderer::new);
    }
}
