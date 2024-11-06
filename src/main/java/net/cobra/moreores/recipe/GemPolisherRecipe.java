package net.cobra.moreores.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.cobra.moreores.recipe.book.ModRecipeBookCategories;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;

import java.util.List;

public class GemPolisherRecipe implements Recipe<SingleStackRecipeInput> {
    private final ItemStack output;
    private final Ingredient ingredient;

    public GemPolisherRecipe(Ingredient ingredient, ItemStack result) {
        this.output = result;
        this.ingredient = ingredient;
    }

    @Override
    public boolean matches(SingleStackRecipeInput input, World world) {
        if (world.isClient) return false;
        return ingredient.test(input.item());
    }

    @Override
    public ItemStack craft(SingleStackRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<? extends Recipe<SingleStackRecipeInput>> getSerializer() {
        return Serializer.GEM_POLISHING;
    }

    @Override
    public RecipeType<? extends Recipe<SingleStackRecipeInput>> getType() {
        return Type.GEM_POLISHING;
    }

//    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output;
    }

    @Override
    public IngredientPlacement getIngredientPlacement() {
        return IngredientPlacement.forMultipleSlots(List.of());
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return ModRecipeBookCategories.GEM_POLISHING;
    }

    public static class Type implements RecipeType<GemPolisherRecipe> {
        public static final Type GEM_POLISHING = new Type();
        public static final String ID = "polish_gem"; //Recipe ID
    }

    public static class Serializer implements RecipeSerializer<GemPolisherRecipe> {

        public static final Serializer GEM_POLISHING = new Serializer();
        public static final String ID = "polish_gem"; //Recipe ID

        //CODEC
        private static final MapCodec<GemPolisherRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.CODEC.fieldOf("ingredient").forGetter(r -> r.ingredient),
                ItemStack.VALIDATED_CODEC.fieldOf("result").forGetter(r -> r.output)
        ).apply(instance, GemPolisherRecipe::new));

        @Override
        public MapCodec<GemPolisherRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, GemPolisherRecipe> packetCodec() {
            return PacketCodec.ofStatic(Serializer::write, Serializer::read);
        }

        private static void write(RegistryByteBuf buf, GemPolisherRecipe recipe) {
            Ingredient.PACKET_CODEC.encode(buf, recipe.ingredient);
            ItemStack.PACKET_CODEC.encode(buf, recipe.getResult(null));
        }

        private static GemPolisherRecipe read(RegistryByteBuf buf) {
            Ingredient ingredient = Ingredient.PACKET_CODEC.decode(buf);
            ItemStack result = ItemStack.PACKET_CODEC.decode(buf);
            return new GemPolisherRecipe(ingredient, result);
        }
    }
}
