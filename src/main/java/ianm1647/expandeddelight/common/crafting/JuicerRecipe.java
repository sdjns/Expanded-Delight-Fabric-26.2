package ianm1647.expandeddelight.common.crafting;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import ianm1647.expandeddelight.common.registry.EDItems;
import ianm1647.expandeddelight.common.registry.EDRecipeBookCategories;
import ianm1647.expandeddelight.common.registry.EDRecipeSerializers;
import ianm1647.expandeddelight.common.registry.EDRecipeTypes;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.PlacementInfo;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.refabricated.inventory.RecipeWrapper;

import java.util.List;

public class JuicerRecipe implements Recipe<RecipeWrapper> {
   public static final int INPUT_SLOTS = 2;

   public static final MapCodec<JuicerRecipe> MAP_CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
         Codec.STRING.optionalFieldOf("group", "").forGetter(JuicerRecipe::group),
         Ingredient.CODEC.listOf().fieldOf("ingredients").xmap(ingredients -> {
            NonNullList<Ingredient> list = NonNullList.create();
            list.addAll(ingredients);
            return list;
         }, ingredients -> ingredients).forGetter(JuicerRecipe::getIngredients),
         ItemStackTemplate.CODEC.fieldOf("result").forGetter(r -> r.output),
         ItemStackTemplate.CODEC.optionalFieldOf("container").forGetter(r -> java.util.Optional.ofNullable(r.containerOverride)),
         Codec.FLOAT.optionalFieldOf("experience", 0.0F).forGetter(JuicerRecipe::getExperience),
         Codec.INT.optionalFieldOf("juicingtime", 200).forGetter(JuicerRecipe::getJuiceTime)
   ).apply(inst, JuicerRecipe::new));

   public static final StreamCodec<RegistryFriendlyByteBuf, JuicerRecipe> STREAM_CODEC = StreamCodec.of(
         (buf, recipe) -> {
            buf.writeUtf(recipe.group);
            buf.writeVarInt(recipe.inputItems.size());
            for (Ingredient ingredient : recipe.inputItems) {
               Ingredient.CONTENTS_STREAM_CODEC.encode(buf, ingredient);
            }
            ItemStackTemplate.STREAM_CODEC.encode(buf, recipe.output);
            buf.writeBoolean(recipe.containerOverride != null);
            if (recipe.containerOverride != null) ItemStackTemplate.STREAM_CODEC.encode(buf, recipe.containerOverride);
            buf.writeFloat(recipe.experience);
            buf.writeVarInt(recipe.juiceTime);
         },
         buf -> {
            String group = buf.readUtf();
            int size = buf.readVarInt();
            NonNullList<Ingredient> inputs = NonNullList.create();
            for (int i = 0; i < size; i++) {
               inputs.add(Ingredient.CONTENTS_STREAM_CODEC.decode(buf));
            }
            ItemStackTemplate output = ItemStackTemplate.STREAM_CODEC.decode(buf);
            ItemStackTemplate container = buf.readBoolean() ? ItemStackTemplate.STREAM_CODEC.decode(buf) : null;
            float experience = buf.readFloat();
            int juiceTime = buf.readVarInt();
            return new JuicerRecipe(group, inputs, output, java.util.Optional.ofNullable(container), experience, juiceTime);
         });

   private final String group;
   private final NonNullList<Ingredient> inputItems;
   private final ItemStackTemplate output;
   private final ItemStackTemplate containerOverride;
   private final float experience;
   private final int juiceTime;

   public JuicerRecipe(String group, NonNullList<Ingredient> inputItems, ItemStackTemplate output, java.util.Optional<ItemStackTemplate> containerOpt, float experience, int juiceTime) {
      ItemStackTemplate container = containerOpt.orElse(null);
      this.group = group;
      this.inputItems = inputItems;
      this.output = output;
      this.containerOverride = container;
      this.experience = experience;
      this.juiceTime = juiceTime;
   }

   @Override
   public boolean matches(RecipeWrapper inv, Level level) {
      return inv.ingredientAmount() == this.inputItems.size() && inv.stackedContents().canCraft(this, null);
   }

   @Override
   public ItemStack assemble(RecipeWrapper inv) {
      return this.output.create();
   }

   @Override
   public boolean isSpecial() {
      return false;
   }

   @Override
   public boolean showNotification() {
      return true;
   }

   @Override
   public String group() {
      return this.group;
   }

   @Override
   public RecipeSerializer<? extends Recipe<RecipeWrapper>> getSerializer() {
      return EDRecipeSerializers.JUICING.get();
   }

   @Override
   public RecipeType<? extends Recipe<RecipeWrapper>> getType() {
      return EDRecipeTypes.JUICING.get();
   }

   @Override
   public PlacementInfo placementInfo() {
      return PlacementInfo.NOT_PLACEABLE;
   }

   @Override
   public RecipeBookCategory recipeBookCategory() {
      return EDRecipeBookCategories.JUICING;
   }

   public NonNullList<Ingredient> getIngredients() {
      return this.inputItems;
   }

   public ItemStack getResultItem() {
      return this.output.create();
   }

   public ItemStack getOutputContainer() {
      if (this.containerOverride != null) {
         return this.containerOverride.create();
      }
      var remainder = this.output.item().value().getCraftingRemainder();
      return remainder == null ? ItemStack.EMPTY : remainder.create();
   }

   public ItemStackTemplate getContainerOverride() {
      return this.containerOverride;
   }

   public float getExperience() {
      return this.experience;
   }

   public int getJuiceTime() {
      return this.juiceTime;
   }

   public ItemStack getToastSymbol() {
      return new ItemStack(EDItems.JUICER.get());
   }
}
