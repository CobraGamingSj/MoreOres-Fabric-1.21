//package net.moreores.mixin;
//
//import net.minecraft.client.MinecraftClient;
//import net.minecraft.client.option.GameOptions;
//import net.minecraft.client.option.SimpleOption;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//@Mixin(GameOptions.class)
//public abstract class GameOptionsMixin {
//
//    @Shadow public abstract SimpleOption<Integer> getViewDistance();
//
//    @Inject(method = "<init>", at = @At("TAIL"))
//    private void modifySettings(CallbackInfo info) {
//        MinecraftClient client = MinecraftClient.getInstance();
//        client.options.getViewDistance();
//    }
//
//}
