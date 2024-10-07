package net.moreores.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.recipe.book.CookingRecipeCategory;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.moreores.MoreOres;
import net.moreores.block.ModBlocks;
import net.moreores.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RecipeGen extends FabricRecipeProvider {
    public RecipeGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        exporter.accept(Identifier.of(MoreOres.MOD_ID, "test_recipe"), new SmeltingRecipe("ruby", CookingRecipeCategory.MISC, Ingredient.ofItems(ModItems.RAW_RUBY),
                new ItemStack(ModItems.RUBY, 5), 5f, 5), null);

        offerSmithingTrimRecipe(exporter, ModItems.GUARDIAN_ARMOR_TRIM_SMITHING_TEMPLATE, Identifier.of(MoreOres.MOD_ID, "guardian"));
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

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.RADIANT_SWORD, 1)
                .pattern(" I ")
                .pattern(" I ")
                .pattern(" B ")
                .input('I', ModItems.RADIANT)
                .input('B', Items.STICK)
                .criterion(hasItem(ModItems.RADIANT), conditionsFromItem(ModItems.RADIANT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.RADIANT_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, ModBlocks.RUBY_LAMP, 1)
                .pattern("aba")
                .pattern("bcb")
                .pattern("aba")
                .input('a', Items.REDSTONE)
                .input('b', ModItems.RUBY)
                .input('c', Blocks.GLOWSTONE)
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .criterion(hasItem(Blocks.GLOWSTONE), conditionsFromItem(Blocks.GLOWSTONE))
                .offerTo(exporter, Identifier.of(getRecipeName(ModBlocks.RUBY_LAMP)));
    }
}
