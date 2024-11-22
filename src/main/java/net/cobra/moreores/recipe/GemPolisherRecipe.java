package net.cobra.moreores.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.cobra.moreores.block.ModBlocks;
import net.cobra.moreores.recipe.book.ModRecipeBookCategories;
import net.cobra.moreores.recipe.display.GemPolishingRecipeDisplay;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.recipe.display.RecipeDisplay;
import net.minecraft.recipe.display.SlotDisplay;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.List;

public class GemPolisherRecipe implements Recipe<SingleStackRecipeInput> {
    public final Ingredient ingredient;
    public final ItemStack output;

    @Nullable
    private IngredientPlacement ingredientPlacement;

    public GemPolisherRecipe(Ingredient ingredient, ItemStack result) {
        this.ingredient = ingredient;
        this.output = result;
    }

    @Override
    public ItemStack craft(SingleStackRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return this.output.copy();
    }

    public ItemStack getResult() {
        return this.output;
    }

    @Override
    public boolean matches(SingleStackRecipeInput input, World world) {
        if (world.isClient) return false;
        return this.ingredient.test(input.item());
    }

    @Override
    public RecipeSerializer<? extends Recipe<SingleStackRecipeInput>> getSerializer() {
        return Serializer.GEM_POLISHING;
    }

    @Override
    public RecipeType<? extends Recipe<SingleStackRecipeInput>> getType() {
        return Type.GEM_POLISHING;
    }

    @Override
    public List<RecipeDisplay> getDisplays() {
        return List.of(
                new GemPolishingRecipeDisplay(
                        Ingredient.toDisplay(Optional.of(this.ingredient)),
                        new SlotDisplay.StackSlotDisplay(this.output),
                        new SlotDisplay.ItemSlotDisplay(ModBlocks.GEM_POLISHER_BLOCK.asItem())
                )
        );
    }

    @Override
    public IngredientPlacement getIngredientPlacement() {
        if (this.ingredientPlacement == null) {
            this.ingredientPlacement = IngredientPlacement.forSingleSlot(this.ingredient);
        }
        return this.ingredientPlacement;
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return ModRecipeBookCategories.GEM_POLISHING;
    }

    public Ingredient getIngredients() {
        return this.ingredient;
    }

    public static class Type implements RecipeType<GemPolisherRecipe> {

        //RECIPE PROPERTIES
        public static final Type GEM_POLISHING = new Type();
        public static final String ID = "polish_gem"; //Recipe ID
    }

    public static class Serializer implements RecipeSerializer<GemPolisherRecipe> {

        //RECIPE PROPERTIES
        public static final Serializer GEM_POLISHING = new Serializer();
        public static final String ID = "polish_gem"; //Recipe ID

        //CODEC
        private static final MapCodec<GemPolisherRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.CODEC.fieldOf("ingredient").forGetter(r -> r.ingredient),
                ItemStack.VALIDATED_CODEC.fieldOf("result").forGetter(r -> r.output)
        ).apply(instance, GemPolisherRecipe::new));

        //PACKET_CODEC
//        public static final PacketCodec<RegistryByteBuf, GemPolisherRecipe> PACKET_CODEC = PacketCodec.tuple(
//                Ingredient.PACKET_CODEC,
//                recipe -> recipe.ingredient,
//                ItemStack.PACKET_CODEC,
//                recipe -> recipe.output,
//                GemPolisherRecipe::new
//        );

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
            ItemStack.PACKET_CODEC.encode(buf, recipe.output);
        }

        private static GemPolisherRecipe read(RegistryByteBuf buf) {
            Ingredient ingredient = Ingredient.PACKET_CODEC.decode(buf);
            ItemStack result = ItemStack.PACKET_CODEC.decode(buf);
            return new GemPolisherRecipe(ingredient, result);
        }
    }
}
