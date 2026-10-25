package ianm1647.expandeddelight.common.registry;

import ianm1647.expandeddelight.ExpandedDelight;
import ianm1647.expandeddelight.common.utility.RegUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;

import java.util.function.Supplier;

public class EDEntityTypes {
    public static Supplier<EntityType<Boat>> CINNAMON_BOAT;
    public static Supplier<EntityType<ChestBoat>> CINNAMON_CHEST_BOAT;

    public static void register() {
        CINNAMON_BOAT = RegUtils.regEntity("cinnamon_boat",
                () -> EntityType.Builder.<Boat>of((type, level) -> new Boat(type, level, () -> EDItems.CINNAMON_BOAT.get()), MobCategory.MISC)
                        .noLootTable().sized(1.375f, 0.5625f).eyeHeight(0.5625f).clientTrackingRange(10)
                        .build(ResourceKey.create(Registries.ENTITY_TYPE, ExpandedDelight.loc("cinnamon_boat"))));
        CINNAMON_CHEST_BOAT = RegUtils.regEntity("cinnamon_chest_boat",
                () -> EntityType.Builder.<ChestBoat>of((type, level) -> new ChestBoat(type, level, () -> EDItems.CINNAMON_CHEST_BOAT.get()), MobCategory.MISC)
                        .noLootTable().sized(1.375f, 0.5625f).eyeHeight(0.5625f).clientTrackingRange(10)
                        .build(ResourceKey.create(Registries.ENTITY_TYPE, ExpandedDelight.loc("cinnamon_chest_boat"))));
    }
}
