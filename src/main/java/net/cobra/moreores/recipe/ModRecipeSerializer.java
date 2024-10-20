package net.cobra.moreores.recipe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.cobra.moreores.MoreOres;

public class ModRecipeSerializer {

    public static void register() {
        Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(MoreOres.MOD_ID, GemPolisherRecipe.Serializer.ID), GemPolisherRecipe.Serializer.INSTANCE);
    }

}
