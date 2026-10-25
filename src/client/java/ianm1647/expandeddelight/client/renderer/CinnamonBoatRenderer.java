package ianm1647.expandeddelight.client.renderer;

import ianm1647.expandeddelight.ExpandedDelight;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.object.boat.BoatModel;
import net.minecraft.client.renderer.entity.AbstractBoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.BoatRenderState;
import net.minecraft.resources.Identifier;

public class CinnamonBoatRenderer extends AbstractBoatRenderer {
    private final EntityModel<BoatRenderState> model;

    public CinnamonBoatRenderer(EntityRendererProvider.Context context, boolean chest) {
        super(context, Identifier.fromNamespaceAndPath(ExpandedDelight.MODID,
                "textures/entity/" + (chest ? "chest_boat" : "boat") + "/cinnamon.png"));
        this.model = new BoatModel(context.bakeLayer(chest ? ModelLayers.OAK_CHEST_BOAT : ModelLayers.OAK_BOAT));
    }

    @Override
    protected EntityModel<BoatRenderState> model() {
        return this.model;
    }
}
