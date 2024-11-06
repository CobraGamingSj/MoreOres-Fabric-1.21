package net.cobra.moreores.datagen;

import net.cobra.moreores.MoreOres;
import net.cobra.moreores.block.ModBlocks;
import net.cobra.moreores.data.server.recipe.GemPolishingRecipeJsonBuilder;
import net.cobra.moreores.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeGenerator;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.List;

public class RecipeGen extends FabricRecipeProvider {
    public RecipeGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                List<ItemConvertible> RUBY_SMELTABLES = List.of(ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE, ModItems.RAW_RUBY);
                List<ItemConvertible> SAPPHIRE_SMELTABLES = List.of(ModBlocks.SAPPHIRE_ORE, ModBlocks.DEEPSLATE_SAPPHIRE_ORE, ModItems.RAW_SAPPHIRE);
                List<ItemConvertible> GREEN_SAPPHIRE_SMELTABLES = List.of(ModBlocks.GREEN_SAPPHIRE_ORE, ModBlocks.DEEPSLATE_GREEN_SAPPHIRE_ORE, ModItems.RAW_GREEN_SAPPHIRE);
                List<ItemConvertible> BLUE_GARNET_SMELTABLES = List.of(ModBlocks.BLUE_GARNET_ORE, ModBlocks.DEEPSLATE_BLUE_GARNET_ORE, ModItems.RAW_BLUE_GARNET);
                List<ItemConvertible> PINK_GARNET_SMELTABLES = List.of(ModBlocks.PINK_GARNET_ORE, ModBlocks.DEEPSLATE_PINK_GARNET_ORE, ModItems.RAW_PINK_GARNET);
                List<ItemConvertible> GREEN_GARNET_SMELTABLES = List.of(ModBlocks.GREEN_GARNET_ORE, ModBlocks.DEEPSLATE_GREEN_GARNET_ORE, ModItems.RAW_GREEN_GARNET);
                List<ItemConvertible> TOPAZ_SMELTABLES = List.of(ModBlocks.TOPAZ_ORE, ModBlocks.DEEPSLATE_TOPAZ_ORE, ModItems.RAW_TOPAZ);
                List<ItemConvertible> WHITE_TOPAZ_SMELTABLES = List.of(ModBlocks.WHITE_TOPAZ_ORE, ModBlocks.DEEPSLATE_WHITE_TOPAZ_ORE, ModItems.RAW_WHITE_TOPAZ);
                List<ItemConvertible> PERIDOT_SMELTABLES = List.of(ModBlocks.PERIDOT_ORE, ModBlocks.DEEPSLATE_PERIDOT_ORE, ModItems.RAW_PERIDOT);
                List<ItemConvertible> JADE_SMELTABLES = List.of(ModBlocks.JADE_ORE, ModBlocks.DEEPSLATE_JADE_ORE, ModItems.RAW_JADE);
                List<ItemConvertible> PYROPE_SMELTABLES = List.of(ModBlocks.PYROPE_ORE, ModBlocks.DEEPSLATE_PYROPE_ORE, ModItems.RAW_PYROPE);

                offerSmelting(RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.15f, 500, "ruby");
                offerSmelting(SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.15f, 500, "sapphire");
                offerSmelting(GREEN_SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.15f, 500, "green_sapphire");
                offerSmelting(BLUE_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.15f, 500, "blue_garnet");
                offerSmelting(PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.15f, 500, "pink_garnet");
                offerSmelting(GREEN_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.15f, 500, "green_garnet");
                offerSmelting(TOPAZ_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.15f, 500, "topaz");
                offerSmelting(WHITE_TOPAZ_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.15f, 500, "white_topaz");
                offerSmelting(PERIDOT_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.15f, 500, "peridot");
                offerSmelting(JADE_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.15f, 500, "jade");
                offerSmelting(PYROPE_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.15f, 500, "pyrope");

                offerBlasting(RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.15f, 500, "ruby");
                offerBlasting(SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.15f, 500, "sapphire");
                offerBlasting(GREEN_SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.15f, 500, "green_sapphire");
                offerBlasting(BLUE_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.15f, 500, "blue_garnet");
                offerBlasting(PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.15f, 500, "pink_garnet");
                offerBlasting(GREEN_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.15f, 500, "green_garnet");
                offerBlasting(TOPAZ_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.15f, 500, "topaz");
                offerBlasting(WHITE_TOPAZ_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.15f, 500, "white_topaz");
                offerBlasting(PERIDOT_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.15f, 500, "peridot");
                offerBlasting(JADE_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.15f, 500, "jade");
                offerBlasting(PYROPE_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.15f, 500, "pyrope");

                offerSmithingTrimRecipe(ModItems.GUARDIAN_ARMOR_TRIM_SMITHING_TEMPLATE, RegistryKey.of(RegistryKeys.RECIPE,
                        Identifier.ofVanilla(getItemPath(ModItems.GUARDIAN_ARMOR_TRIM_SMITHING_TEMPLATE) + "_smithing_trim")));

                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_RUBY, RecipeCategory.DECORATIONS,
                        ModBlocks.RAW_RUBY_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_SAPPHIRE, RecipeCategory.DECORATIONS,
                        ModBlocks.RAW_SAPPHIRE_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_GREEN_SAPPHIRE, RecipeCategory.DECORATIONS,
                        ModBlocks.RAW_GREEN_SAPPHIRE_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_BLUE_GARNET, RecipeCategory.DECORATIONS,
                        ModBlocks.RAW_BLUE_GARNET_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_PINK_GARNET, RecipeCategory.DECORATIONS,
                        ModBlocks.RAW_PINK_GARNET_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_GREEN_GARNET, RecipeCategory.DECORATIONS,
                        ModBlocks.RAW_GREEN_GARNET_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_TOPAZ, RecipeCategory.DECORATIONS,
                        ModBlocks.RAW_TOPAZ_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_WHITE_TOPAZ, RecipeCategory.DECORATIONS,
                        ModBlocks.RAW_WHITE_TOPAZ_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_PERIDOT, RecipeCategory.DECORATIONS,
                        ModBlocks.RAW_PERIDOT_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_JADE, RecipeCategory.DECORATIONS,
                        ModBlocks.RAW_JADE_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_PYROPE, RecipeCategory.DECORATIONS,
                        ModBlocks.RAW_PYROPE_BLOCK);

                GemPolishingRecipeJsonBuilder.create(
                                Ingredient.ofItems(ModItems.RAW_RUBY), new ItemStack(ModItems.RUBY), RecipeCategory.MISC
                        )
                        .criterion(hasItem(ModItems.RAW_RUBY), conditionsFromItem(ModItems.RAW_RUBY))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.RAW_RUBY) + "_polishing")));

                GemPolishingRecipeJsonBuilder.create(
                                Ingredient.ofItems(ModItems.RAW_SAPPHIRE), new ItemStack(ModItems.SAPPHIRE), RecipeCategory.MISC
                        )
                        .criterion(hasItem(ModItems.RAW_SAPPHIRE), conditionsFromItem(ModItems.RAW_SAPPHIRE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.RAW_SAPPHIRE) + "_polishing")));

                GemPolishingRecipeJsonBuilder.create(
                                Ingredient.ofItems(ModItems.RAW_GREEN_SAPPHIRE), new ItemStack(ModItems.GREEN_SAPPHIRE), RecipeCategory.MISC
                        )
                        .criterion(hasItem(ModItems.RAW_GREEN_SAPPHIRE), conditionsFromItem(ModItems.RAW_GREEN_SAPPHIRE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.GREEN_SAPPHIRE) + "_polishing")));

                GemPolishingRecipeJsonBuilder.create(
                                Ingredient.ofItems(ModItems.RAW_BLUE_GARNET), new ItemStack(ModItems.BLUE_GARNET), RecipeCategory.MISC
                        )
                        .criterion(hasItem(ModItems.RAW_BLUE_GARNET), conditionsFromItem(ModItems.RAW_BLUE_GARNET))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.BLUE_GARNET) + "_polishing")));

                GemPolishingRecipeJsonBuilder.create(
                                Ingredient.ofItems(ModItems.RAW_PINK_GARNET), new ItemStack(ModItems.PINK_GARNET), RecipeCategory.MISC
                        )
                        .criterion(hasItem(ModItems.RAW_PINK_GARNET), conditionsFromItem(ModItems.RAW_PINK_GARNET))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.PINK_GARNET) + "_polishing")));

                GemPolishingRecipeJsonBuilder.create(
                                Ingredient.ofItems(ModItems.RAW_GREEN_GARNET), new ItemStack(ModItems.GREEN_GARNET), RecipeCategory.MISC
                        )
                        .criterion(hasItem(ModItems.RAW_GREEN_GARNET), conditionsFromItem(ModItems.RAW_GREEN_GARNET))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.GREEN_GARNET) + "_polishing")));

                GemPolishingRecipeJsonBuilder.create(
                                Ingredient.ofItems(ModItems.RAW_TOPAZ), new ItemStack(ModItems.TOPAZ), RecipeCategory.MISC
                        )
                        .criterion(hasItem(ModItems.RAW_TOPAZ), conditionsFromItem(ModItems.RAW_TOPAZ))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.TOPAZ) + "_polishing")));

                GemPolishingRecipeJsonBuilder.create(
                                Ingredient.ofItems(ModItems.RAW_WHITE_TOPAZ), new ItemStack(ModItems.WHITE_TOPAZ), RecipeCategory.MISC
                        )
                        .criterion(hasItem(ModItems.RAW_WHITE_TOPAZ), conditionsFromItem(ModItems.RAW_WHITE_TOPAZ))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.WHITE_TOPAZ) + "_polishing")));

                GemPolishingRecipeJsonBuilder.create(
                                Ingredient.ofItems(ModItems.RAW_PERIDOT), new ItemStack(ModItems.PERIDOT), RecipeCategory.MISC
                        )
                        .criterion(hasItem(ModItems.RAW_PERIDOT), conditionsFromItem(ModItems.RAW_PERIDOT))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.PERIDOT) + "_polishing")));

                GemPolishingRecipeJsonBuilder.create(
                                Ingredient.ofItems(ModItems.RAW_JADE), new ItemStack(ModItems.JADE), RecipeCategory.MISC
                        )
                        .criterion(hasItem(ModItems.RAW_JADE), conditionsFromItem(ModItems.RAW_JADE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.JADE) + "_polishing")));

                GemPolishingRecipeJsonBuilder.create(
                                Ingredient.ofItems(ModItems.RAW_PYROPE), new ItemStack(ModItems.PYROPE), RecipeCategory.MISC
                        )
                        .criterion(hasItem(ModItems.RAW_PYROPE), conditionsFromItem(ModItems.RAW_PYROPE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.PYROPE) + "_polishing")));

                createShaped(RecipeCategory.REDSTONE, ModBlocks.GEM_POLISHER_BLOCK, 1)
                        .pattern("III")
                        .pattern("III")
                        .pattern("B B")
                        .input('I', Blocks.IRON_BLOCK)
                        .input('B', Blocks.IRON_BARS)
                        .criterion(hasItem(Blocks.IRON_BLOCK), conditionsFromItem(Blocks.IRON_BLOCK))
                        .criterion(hasItem(Blocks.IRON_BARS), conditionsFromItem(Blocks.IRON_BARS))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModBlocks.GEM_POLISHER_BLOCK))));

                createShaped(RecipeCategory.COMBAT, ModItems.RADIANT_SWORD, 1)
                        .pattern(" I ")
                        .pattern(" I ")
                        .pattern(" B ")
                        .input('I', ModItems.RADIANT)
                        .input('B', Items.STICK)
                        .criterion(hasItem(ModItems.RADIANT), conditionsFromItem(ModItems.RADIANT))
                        .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModItems.RADIANT_SWORD))));

                createShaped(RecipeCategory.REDSTONE, ModBlocks.RUBY_LAMP, 1)
                        .pattern("aba")
                        .pattern("bcb")
                        .pattern("aba")
                        .input('a', Items.REDSTONE)
                        .input('b', ModItems.RUBY)
                        .input('c', Blocks.GLOWSTONE)
                        .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                        .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                        .criterion(hasItem(Blocks.GLOWSTONE), conditionsFromItem(Blocks.GLOWSTONE))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(getRecipeName(ModBlocks.RUBY_LAMP))));

            }
        };
    }

    @Override
    public String getName() {
        return "Mod Recipe Gen!";
    }
}
