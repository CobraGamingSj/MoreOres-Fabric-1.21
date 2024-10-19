package net.moreores.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;
import net.moreores.block.ModBlocks;

public class GemPolisherRecipe implements Recipe<SingleStackRecipeInput> {
    private final ItemStack output;
    private final Ingredient ingredient;

    public GemPolisherRecipe(Ingredient ingredient, ItemStack result) {
        this.output = result;
        this.ingredient = ingredient;
    }

    public boolean matches(SingleStackRecipeInput input, World world) {
        if (world.isClient) return false;
        return ingredient.test(input.item());
    }

    @Override
    public ItemStack craft(SingleStackRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModBlocks.GEM_POLISHER_BLOCK);
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<GemPolisherRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "gem_polishing"; //Recipe ID
    }

    public static class Serializer implements RecipeSerializer<GemPolisherRecipe> {

        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "gem_polishing"; //Recipe ID

        //CODEC
        public static final MapCodec<GemPolisherRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(r -> r.ingredient),
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
