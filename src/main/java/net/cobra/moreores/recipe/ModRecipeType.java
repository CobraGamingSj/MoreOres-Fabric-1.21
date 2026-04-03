package net.cobra.moreores.recipe;

import net.cobra.moreores.MoreOresModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipeType {

    public static void register() {
        Registry.register(Registries.RECIPE_TYPE, Identifier.of(MoreOresModInitializer.MOD_ID, GemPurifierRecipe.Type.ID), GemPurifierRecipe.Type.GEM_PURIFYING);
    }

}
