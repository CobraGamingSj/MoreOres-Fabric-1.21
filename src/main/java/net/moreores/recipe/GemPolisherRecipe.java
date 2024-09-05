package net.moreores.recipe;//package net.moreores.recipe;
//
//import com.mojang.serialization.Codec;
//import com.mojang.serialization.DataResult;
//import com.mojang.serialization.MapCodec;
//import com.mojang.serialization.codecs.RecordCodecBuilder;
//import net.minecraft.inventory.SimpleInventory;
//import net.minecraft.item.ItemStack;
//import net.minecraft.network.RegistryByteBuf;
//import net.minecraft.network.codec.PacketCodec;
//import net.minecraft.recipe.Ingredient;
//import net.minecraft.recipe.Recipe;
//import net.minecraft.recipe.RecipeSerializer;
//import net.minecraft.recipe.RecipeType;
//import net.minecraft.recipe.input.SingleStackRecipeInput;
//import net.minecraft.registry.RegistryWrapper;
//import net.minecraft.util.collection.DefaultedList;
//import net.minecraft.world.World;
//import net.moreores.block.entity.GemPolisherBlockEntity;
//
//import java.util.List;
//
//public class GemPolisherRecipe implements Recipe<SingleStackRecipeInput> {
//    private final ItemStack output;
//    private final List<Ingredient> recipeItem;
//    private final Ingredient energySource;
//
//    public GemPolisherRecipe(List<Ingredient> ingredient, Ingredient energySource, ItemStack result) {
//        this.output = result;
//        this.recipeItem = ingredient;
//        this.energySource = energySource;
//    }
//
//    public static final RecipeType<GemPolisherRecipe> TYPE = RecipeType.register(Type.ID);
//
//    private SingleStackRecipeInput convertToSingleStackRecipeInput(SimpleInventory inventory) {
//        return new SingleStackRecipeInput(inventory.getStack(GemPolisherBlockEntity.INPUT_SLOT));
//    }
//
//    public DefaultedList<Ingredient> getEnergySource() {
//        return DefaultedList.of();
//    }
//
//    @Override
//    public boolean matches(SingleStackRecipeInput input, World world) {
//        if (world.isClient) {
//            return false;
//        }
//        SimpleInventory inventory = new SimpleInventory();
//        return recipeItem.get(0).test(inventory.getStack(0));
//    }
//
//    public boolean matches(SimpleInventory inventory, World world) {
//        SingleStackRecipeInput input = convertToSingleStackRecipeInput(inventory);
//
//        return matches(input, world);
//    }
//
//    @Override
//    public ItemStack craft(SingleStackRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
//        return output;
//    }
//
//    @Override
//    public boolean fits(int width, int height) {
//        return true;
//    }
//
//    @Override
//    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
//        return output;
//    }
//
//
//
//    @Override
//    public RecipeSerializer<?> getSerializer() {
//        return Serializer.INSTANCE;
//    }
//
//    @Override
//    public RecipeType<?> getType() {
//        return Type.INSTANCE;
//    }
//
//    public static class Type implements RecipeType<GemPolisherRecipe> {
//        public static final Type INSTANCE = new Type();
//        public static final String ID = "gem_polishing";
//    }
//
//    public static class Serializer implements RecipeSerializer<GemPolisherRecipe> {
//
//        public static final Serializer INSTANCE = new Serializer();
//        public static final String ID = "gem_polishing";
//
//        public static final MapCodec<GemPolisherRecipe> CODEC = RecordCodecBuilder.mapCodec(ins -> ins.group(
//                validateAmount(Ingredient.DISALLOW_EMPTY_CODEC, 9).fieldOf("ingredients").forGetter(GemPolisherRecipe::getIngredients),
//                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("energySource").forGetter(r -> r.energySource),
//                ItemStack.VALIDATED_CODEC.fieldOf("result").forGetter(r -> r.output)
//                ).apply(ins, GemPolisherRecipe::new));
//
//
//        private static Codec<List<Ingredient>> validateAmount(Codec<Ingredient> delegate, int max) {
//            return delegate.listOf()
//                    .validate(list -> list.size() > max ? DataResult.error(() -> "Recipe has too many ingredients!") :
//                            DataResult.success(list)).validate(list -> list.isEmpty() ? DataResult.error(() -> "Recipe has no ingredients!") :
//                            DataResult.success(list));
//        }
//
//        @Override
//        public MapCodec<GemPolisherRecipe> codec() {
//            return CODEC;
//        }
//
//        @Override
//        public PacketCodec<RegistryByteBuf, GemPolisherRecipe> packetCodec() {
//            return PacketCodec.ofStatic(Serializer::write, Serializer::read);
//        }
//
//        private static GemPolisherRecipe read(RegistryByteBuf buf) {
//            int i = buf.readVarInt();
//            DefaultedList<Ingredient> defaultedList = DefaultedList.ofSize(i, Ingredient.EMPTY);
//            defaultedList.replaceAll(empty -> Ingredient.PACKET_CODEC.decode(buf));
//            Ingredient energy = Ingredient.PACKET_CODEC.decode(buf);
//            ItemStack itemStack = ItemStack.PACKET_CODEC.decode(buf);
//            return new GemPolisherRecipe(defaultedList, energy, itemStack);
//        }
//
//        private static void write(RegistryByteBuf buf, GemPolisherRecipe recipe) {
//
//            buf.writeString(recipe.getGroup());
//            buf.writeVarInt(recipe.getIngredients().size());
//
//            for (Ingredient ingredient : recipe.getIngredients()) {
//                Ingredient.PACKET_CODEC.encode(buf, ingredient);
//            }
//            Ingredient.PACKET_CODEC.encode(buf, recipe.energySource);
//            ItemStack.PACKET_CODEC.encode(buf, recipe.getResult(null));
//        }
//
//    }
//
//}
