package ianm1647.expandeddelight.common.registry;

import ianm1647.expandeddelight.ExpandedDelight;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeBookCategory;

public class EDRecipeBookCategories {
    public static final RecipeBookCategory JUICING = Registry.register(
            BuiltInRegistries.RECIPE_BOOK_CATEGORY, ExpandedDelight.loc("juicing"), new RecipeBookCategory());
}
