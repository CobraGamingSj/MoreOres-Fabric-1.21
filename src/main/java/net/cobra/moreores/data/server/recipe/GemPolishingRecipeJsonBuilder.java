package net.cobra.moreores.data.server.recipe;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import net.cobra.moreores.recipe.GemPolisherRecipe;

import java.util.LinkedHashMap;
import java.util.Map;

public class GemPolishingRecipeJsonBuilder {
    private final ItemStack output;
    private final Ingredient ingredient;
    private final RecipeCategory category;
    private final Map<String, AdvancementCriterion<?>> criterion = new LinkedHashMap<>();

    public GemPolishingRecipeJsonBuilder(Ingredient ingredient, ItemStack output, RecipeCategory category) {
        this.output = output;
        this.ingredient = ingredient;
        this.category = category;
    }

    public static GemPolishingRecipeJsonBuilder create(Ingredient ingredient, ItemStack result, RecipeCategory category) {
        return new GemPolishingRecipeJsonBuilder(ingredient, result, category);
    }

    public GemPolishingRecipeJsonBuilder criterion(String name, AdvancementCriterion<?> criterion) {
        this.criterion.put(name, criterion);
        return this;
    }

    public void offerTo(RecipeExporter exporter, String recipeId) {
        this.offerTo(exporter, Identifier.of(recipeId));
    }

    public void offerTo(RecipeExporter exporter, Identifier recipeId) {
        this.validate(recipeId);
        Advancement.Builder builder = exporter.getAdvancementBuilder()
                .criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeId))
                .rewards(AdvancementRewards.Builder.recipe(recipeId))
                .criteriaMerger(AdvancementRequirements.CriterionMerger.OR);
        this.criterion.forEach(builder::criterion);
        GemPolisherRecipe gemPolishingRecipe = new GemPolisherRecipe(this.ingredient, this.output);
        exporter.accept(recipeId, gemPolishingRecipe, builder.build(recipeId.withPrefixedPath("recipes/" + this.category.getName() + "/")));
    }

    private void validate(Identifier recipeId) {
        if (this.criterion.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + recipeId);
        }
    }
}
