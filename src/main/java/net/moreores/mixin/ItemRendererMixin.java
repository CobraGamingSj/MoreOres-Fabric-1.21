package net.moreores.mixin;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.moreores.MoreOres;
import net.moreores.item.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @Shadow
    public abstract ItemModels getModels();

    @ModifyVariable(method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/" +
            "VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V", at = @At("HEAD"), argsOnly = true)
    private BakedModel useRubyPickaxeModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode,
                                           boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers,
                                           int light, int overlay) {
        if (stack.isOf(ModItems.RUBY_PICKAXE)) {
            boolean isGUI = renderMode == ModelTransformationMode.GUI;

            ModelIdentifier modelID;
            if (isGUI) {
                modelID = ModelIdentifier.ofInventoryVariant(Identifier.of(MoreOres.MOD_ID, "ruby_pickaxe_3d"));
            }
            BakedModel newModel = ((ItemRendererAccessor)this).getModels().getModelManager().getModel(modelID);
            return newModel;
        }
        return value;
    }
}
