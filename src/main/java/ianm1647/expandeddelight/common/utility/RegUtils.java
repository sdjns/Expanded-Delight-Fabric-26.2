package ianm1647.expandeddelight.common.utility;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import ianm1647.expandeddelight.ExpandedDelight;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

public class RegUtils {
    public RegUtils() {
    }

    public static <R, T extends R> Supplier<T> register(String name, Supplier<T> supplier, Registry<R> reg) {
        T object = supplier.get();
        Registry.register(reg, ExpandedDelight.loc(name), object);
        return () -> object;
    }

    public static <B extends EntityType<?>> Supplier<B> regEntity(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.ENTITY_TYPE);
    }

    public static <B extends MenuType<?>> Supplier<B> regMenu(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.MENU);
    }

    public static <B extends PlacementModifierType<?>> Supplier<B> regPlacementMod(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.PLACEMENT_MODIFIER_TYPE);
    }

    public static <B extends RecipeSerializer<?>> Supplier<B> regRecipeSerializer(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.RECIPE_SERIALIZER);
    }

    public static <B extends RecipeType<?>> Supplier<B> regRecipe(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.RECIPE_TYPE);
    }

    public static <B extends ParticleType<?>> Supplier<B> regParticle(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.PARTICLE_TYPE);
    }

    public static <B extends SoundEvent> Supplier<B> regSound(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.SOUND_EVENT);
    }

    public static <B extends Feature<?>> Supplier<B> regFeature(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.FEATURE);
    }

    public static <B extends BlockEntityType<?>> Supplier<B> regBlockEntity(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.BLOCK_ENTITY_TYPE);
    }

    public static <B extends CreativeModeTab> Supplier<B> regTab(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.CREATIVE_MODE_TAB);
    }

    public static <B extends DataComponentType<?>> Supplier<B> regComponent(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.DATA_COMPONENT_TYPE);
    }

    public static <A> Supplier<DataComponentType<A>> regComponent(String name, Consumer<DataComponentType.Builder<A>> stuff) {
        DataComponentType.Builder<A> builder = DataComponentType.builder();
        stuff.accept(builder);
        Objects.requireNonNull(builder);
        return register(name, builder::build, BuiltInRegistries.DATA_COMPONENT_TYPE);
    }

    public static <A> Supplier<DataComponentType<A>> regEnchComponent(String name, Consumer<DataComponentType.Builder<A>> stuff) {
        DataComponentType.Builder<A> builder = DataComponentType.builder();
        stuff.accept(builder);
        Objects.requireNonNull(builder);
        return register(name, builder::build, BuiltInRegistries.ENCHANTMENT_EFFECT_COMPONENT_TYPE);
    }

    public static <B extends MobEffect> Supplier<B> regEffect(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.MOB_EFFECT);
    }

    private static final ThreadLocal<net.minecraft.resources.ResourceKey<Item>> CURRENT_ITEM_KEY = new ThreadLocal<>();

    public static net.minecraft.resources.ResourceKey<Item> currentItemKey() {
        return CURRENT_ITEM_KEY.get();
    }

    public static <B extends Item> Supplier<B> regItem(String name, Supplier<B> supplier) {
        net.minecraft.resources.ResourceKey<Item> key = net.minecraft.resources.ResourceKey.create(
                net.minecraft.core.registries.Registries.ITEM, ExpandedDelight.loc(name));
        CURRENT_ITEM_KEY.set(key);
        try {
            return register(name, supplier, BuiltInRegistries.ITEM);
        } finally {
            CURRENT_ITEM_KEY.remove();
        }
    }

    public static <B extends Block> Supplier<B> regBlock(String name, java.util.function.Function<net.minecraft.resources.ResourceKey<Block>, B> factory) {
        net.minecraft.resources.ResourceKey<Block> key = net.minecraft.resources.ResourceKey.create(
                net.minecraft.core.registries.Registries.BLOCK, ExpandedDelight.loc(name));
        return register(name, () -> factory.apply(key), BuiltInRegistries.BLOCK);
    }

}