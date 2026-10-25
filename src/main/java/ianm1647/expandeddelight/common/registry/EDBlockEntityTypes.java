package ianm1647.expandeddelight.common.registry;

import ianm1647.expandeddelight.common.block.JuicerBlock;
import ianm1647.expandeddelight.common.block.entity.CinnamonCabinetBlockEntity;
import ianm1647.expandeddelight.common.block.entity.CinnamonHangingSignBlockEntity;
import ianm1647.expandeddelight.common.block.entity.CinnamonSignBlockEntity;
import ianm1647.expandeddelight.common.block.entity.JuicerBlockEntity;
import ianm1647.expandeddelight.common.utility.RegUtils;
import net.minecraft.world.level.block.entity.BlockEntityType;
import vectorwing.farmersdelight.common.block.entity.CookingPotBlockEntity;
import vectorwing.farmersdelight.common.registry.ModBlocks;

import java.util.Set;
import java.util.function.Supplier;

public class EDBlockEntityTypes {

    public static Supplier<BlockEntityType<CinnamonSignBlockEntity>> CINNAMON_SIGN;
    public static Supplier<BlockEntityType<CinnamonHangingSignBlockEntity>> CINNAMON_HANGING_SIGN;
    public static Supplier<BlockEntityType<CinnamonCabinetBlockEntity>> CINNAMON_CABINET;

    public static Supplier<BlockEntityType<JuicerBlockEntity>> JUICER;

    public static final Supplier<BlockEntityType<CookingPotBlockEntity>> COOKING_POT = RegUtils.regBlockEntity("cooking_pot",
            () -> new BlockEntityType<>(CookingPotBlockEntity::new, Set.of(ModBlocks.COOKING_POT.get())));

    public EDBlockEntityTypes() {
    }

    public static void register() {
        CINNAMON_SIGN = RegUtils.regBlockEntity("cinnamon_sign",
                () -> new BlockEntityType<>(CinnamonSignBlockEntity::new, Set.of(EDBlocks.CINNAMON_SIGN.get(), EDBlocks.CINNAMON_WALL_SIGN.get())));
        CINNAMON_HANGING_SIGN = RegUtils.regBlockEntity("cinnamon_hanging_sign",
                () -> new BlockEntityType<>(CinnamonHangingSignBlockEntity::new, Set.of(EDBlocks.CINNAMON_CEILING_HANGING_SIGN.get(), EDBlocks.CINNAMON_WALL_HANGING_SIGN.get())));
        CINNAMON_CABINET = RegUtils.regBlockEntity("cinnamon_cabinet",
                () -> new BlockEntityType<>(CinnamonCabinetBlockEntity::new, Set.of(EDBlocks.CINNAMON_CABINET.get())));

        JUICER = RegUtils.regBlockEntity("juicer",
                () -> new BlockEntityType<>(JuicerBlockEntity::new, Set.of(EDBlocks.JUICER.get())));
    }
}
