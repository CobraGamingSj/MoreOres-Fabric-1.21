//package net.cobra.moreores.compat;
//
//import com.mojang.serialization.codecs.RecordCodecBuilder;
//import me.shedaniel.rei.api.common.category.CategoryIdentifier;
//import me.shedaniel.rei.api.common.display.Display;
//import me.shedaniel.rei.api.common.display.DisplaySerializer;
//import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
//import me.shedaniel.rei.api.common.entry.EntryIngredient;
//import me.shedaniel.rei.api.common.util.EntryIngredients;
//import me.shedaniel.rei.api.common.util.EntryStacks;
//import net.cobra.moreores.recipe.GemPolisherRecipe;
//import net.minecraft.recipe.RecipeEntry;
//import org.jetbrains.annotations.Nullable;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class GemPolisherDisplay extends BasicDisplay {
//    public static final DisplaySerializer<GemPolisherDisplay> SERIALIZER = DisplaySerializer.of(
//            RecordCodecBuilder.mapCodec(oInstance -> oInstance.group(
//                    EntryIngredient.codec().listOf().fieldOf("inputs").forGetter(GemPolisherDisplay::getInputEntries),
//                    EntryIngredient.codec().listOf().fieldOf("outputs").forGetter(GemPolisherDisplay::getOutputEntries)
//            ).apply(oInstance, GemPolisherDisplay::new))
//    );
//
//    public GemPolisherDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
//        super(inputs, outputs);
//    }
//
//    public GemPolisherDisplay(RecipeEntry<GemPolisherRecipe> recipe) {
//        super(getInputList(recipe.value()), List.of(EntryIngredient.of(EntryStacks.of(recipe.value().output))));
//    }
//
//    @Override
//    public CategoryIdentifier<?> getCategoryIdentifier() {
//        return GemPolisherCategory.GEM_POLISHING;
//    }
//
//    private static List<EntryIngredient> getInputList(GemPolisherRecipe recipe) {
//        if(recipe == null) return Collections.emptyList();
//        List<EntryIngredient> list = new ArrayList<>();
//        list.add(EntryIngredients.ofIngredient(recipe.getIngredients().get(0)));
//        return list;
//    }
//
//    @Override
//    public @Nullable DisplaySerializer<? extends Display> getSerializer() {
//        return SERIALIZER;
//    }
//}
