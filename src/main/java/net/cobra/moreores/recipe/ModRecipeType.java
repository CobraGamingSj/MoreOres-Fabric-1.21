package net.cobra.moreores.recipe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.cobra.moreores.MoreOres;

public class ModRecipeType {

    public static void register() {
        Registry.register(Registries.RECIPE_TYPE, Identifier.of(MoreOres.MOD_ID, GemPolisherRecipe.Type.ID), GemPolisherRecipe.Type.INSTANCE);
    }

}
