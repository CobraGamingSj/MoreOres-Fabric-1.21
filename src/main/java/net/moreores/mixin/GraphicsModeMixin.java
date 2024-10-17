//package net.moreores.mixin;
//
//import net.minecraft.client.option.GraphicsMode;
//import org.spongepowered.asm.mixin.*;
//import org.spongepowered.asm.mixin.gen.Invoker;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//@Mixin(GraphicsMode.class)
//public class GraphicsModeMixin {
//    @Shadow
//    @Final
//    @Mutable
//    private static GraphicsMode[] field_25433;
//
//    @Shadow @Final private String translationKey;
//    @Unique private static final GraphicsMode FASTEST = moreores$new("FASTEST", 3, "otions.graphics.fastest");
//
//    @Invoker("<init>")
//    public static GraphicsMode moreores$invokeInit(String internalName, int internalId, final int id, final String translationKey) {
//        throw new AssertionError();
//    }
//
//    @Unique
//    private static GraphicsMode moreores$new(String internalName, final int id, final String translationKey) {
//        if (GraphicsModeMixin.field_25433 == null) throw new IllegalStateException();
//        ArrayList<GraphicsMode> variants = new ArrayList<>(Arrays.asList(GraphicsModeMixin.field_25433));
//        GraphicsMode graphicsMode = moreores$invokeInit(internalName, variants.getLast().ordinal() + 1, id, translationKey);
//        variants.add(graphicsMode);
//        GraphicsModeMixin.field_25433 = variants.toArray(new GraphicsMode[0]);
//        return graphicsMode;
//    }
//}