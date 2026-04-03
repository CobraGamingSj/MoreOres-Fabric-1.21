package net.cobra.moreores.recipe.display;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.display.RecipeDisplay;
import net.minecraft.recipe.display.SlotDisplay;

public record GemPurifyingRecipeDisplay(SlotDisplay ingredient, SlotDisplay result, SlotDisplay workStation) implements RecipeDisplay {

    @Override
    public SlotDisplay craftingStation() {
        return this.workStation;
    }

    public static final MapCodec<GemPurifyingRecipeDisplay> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                            SlotDisplay.CODEC.fieldOf("ingredient").forGetter(GemPurifyingRecipeDisplay::ingredient),
                            SlotDisplay.CODEC.fieldOf("result").forGetter(GemPurifyingRecipeDisplay::result),
                            SlotDisplay.CODEC.fieldOf("work_station").forGetter(GemPurifyingRecipeDisplay::workStation)
                    )
                    .apply(instance, GemPurifyingRecipeDisplay::new)
    );
    public static final PacketCodec<RegistryByteBuf, GemPurifyingRecipeDisplay> PACKET_CODEC = PacketCodec.tuple(
            SlotDisplay.PACKET_CODEC,
            GemPurifyingRecipeDisplay::ingredient,
            SlotDisplay.PACKET_CODEC,
            GemPurifyingRecipeDisplay::result,
            SlotDisplay.PACKET_CODEC,
            GemPurifyingRecipeDisplay::workStation,
            GemPurifyingRecipeDisplay::new
    );

    public static final RecipeDisplay.Serializer<GemPurifyingRecipeDisplay> SERIALIZER = new RecipeDisplay.Serializer<>(CODEC, PACKET_CODEC);

    @Override
    public RecipeDisplay.Serializer<GemPurifyingRecipeDisplay> serializer() {
        return SERIALIZER;
    }
}
