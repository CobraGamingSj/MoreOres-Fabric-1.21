package net.moreores.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.moreores.block.ModBlocks;
import net.moreores.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class RecipeGen extends FabricRecipeProvider {
    public RecipeGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_RUBY, RecipeCategory.DECORATIONS,
                ModBlocks.RAW_RUBY_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_SAPPHIRE, RecipeCategory.DECORATIONS,
                ModBlocks.RAW_SAPPHIRE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_GREEN_SAPPHIRE, RecipeCategory.DECORATIONS,
                ModBlocks.RAW_GREEN_SAPPHIRE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_BLUE_GARNET, RecipeCategory.DECORATIONS,
                ModBlocks.RAW_BLUE_GARNET_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_PINK_GARNET, RecipeCategory.DECORATIONS,
                ModBlocks.RAW_PINK_GARNET_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_GREEN_GARNET, RecipeCategory.DECORATIONS,
                ModBlocks.RAW_GREEN_GARNET_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_TOPAZ, RecipeCategory.DECORATIONS,
                ModBlocks.RAW_TOPAZ_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_WHITE_TOPAZ, RecipeCategory.DECORATIONS,
                ModBlocks.RAW_WHITE_TOPAZ_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_PERIDOT, RecipeCategory.DECORATIONS,
                ModBlocks.RAW_PERIDOT_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_JADE, RecipeCategory.DECORATIONS,
                ModBlocks.RAW_JADE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_PYROPE, RecipeCategory.DECORATIONS,
                ModBlocks.RAW_PYROPE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.GEM_POLISHER_BLOCK, 1)
                .pattern("III")
                .pattern("III")
                .pattern("B B")
                .input('I', Blocks.IRON_BLOCK)
                .input('B', Blocks.IRON_BARS)
                .criterion(hasItem(Blocks.IRON_BLOCK), conditionsFromItem(Blocks.IRON_BLOCK))
                .criterion(hasItem(Blocks.IRON_BARS), conditionsFromItem(Blocks.IRON_BARS))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.GEM_POLISHER_BLOCK)));
    }
}
