package ianm1647.expandeddelight.common.world;

import ianm1647.expandeddelight.ExpandedDelight;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.function.Predicate;

/**
 * Fabric replacement for the NeoForge biome modifier JSONs that shipped with the 1.21 version.
 */
public final class EDWorldGen {
    private EDWorldGen() {
    }

    private static Predicate<net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext> tag(String path) {
        return BiomeSelectors.tag(TagKey.create(Registries.BIOME, net.minecraft.resources.Identifier.fromNamespaceAndPath("c", path)));
    }

    private static ResourceKey<PlacedFeature> feature(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ExpandedDelight.loc(name));
    }

    public static void register() {
        BiomeModifications.addFeature(tag("is_jungle"), GenerationStep.Decoration.VEGETAL_DECORATION, feature("cinnamon_tree"));
        BiomeModifications.addFeature(tag("is_jungle"), GenerationStep.Decoration.VEGETAL_DECORATION, feature("patch_wild_sweet_potato"));
        BiomeModifications.addFeature(tag("is_swamp"), GenerationStep.Decoration.VEGETAL_DECORATION, feature("patch_cranberries"));
        BiomeModifications.addFeature(tag("is_plains"), GenerationStep.Decoration.VEGETAL_DECORATION, feature("patch_wild_asparagus"));
        BiomeModifications.addFeature(tag("is_desert"), GenerationStep.Decoration.VEGETAL_DECORATION, feature("patch_wild_chili_pepper"));
        BiomeModifications.addFeature(tag("is_savanna"), GenerationStep.Decoration.VEGETAL_DECORATION, feature("patch_wild_peanuts"));
        BiomeModifications.addFeature(tag("is_ocean"), GenerationStep.Decoration.UNDERGROUND_ORES, feature("salt_ore"));
    }
}
