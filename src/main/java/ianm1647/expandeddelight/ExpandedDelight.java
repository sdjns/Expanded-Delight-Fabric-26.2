package ianm1647.expandeddelight;

import ianm1647.expandeddelight.common.block.JuicerBlock;
import ianm1647.expandeddelight.common.block.entity.JuicerBlockEntity;
import ianm1647.expandeddelight.common.event.EDEvents;
import ianm1647.expandeddelight.common.registry.*;
import ianm1647.expandeddelight.common.world.EDWorldGen;
import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExpandedDelight implements ModInitializer {
	public static final String MODID = "expandeddelight";
	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public void onInitialize() {
		EDConfig.bootstrap();
		EDEntityTypes.register();
		EDBlocks.register();
		EDItems.register();
		EDDataComponents.register();
		EDBlockEntityTypes.register();
		EDMenuTypes.register();
		EDRecipeTypes.register();
		EDRecipeSerializers.register();
		EDTabs.register();
		EDWoodTypes.bootstrap();

		EDEvents.register();
		EDWorldGen.register();
		JuicerBlockEntity.init();

		LOGGER.info("Expanded Delight is loading...");
	}

	public static Identifier loc(String path) {
		return Identifier.fromNamespaceAndPath(MODID, path);
	}
}