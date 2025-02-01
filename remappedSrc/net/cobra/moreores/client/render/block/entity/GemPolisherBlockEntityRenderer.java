package net.cobra.moreores.client.render.block.entity;

import net.cobra.moreores.block.entity.GemPolisherBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.FluidRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

public class GemPolisherBlockEntityRenderer implements BlockEntityRenderer<GemPolisherBlockEntity> {
    public GemPolisherBlockEntityRenderer(BlockEntityRendererFactory.Context context) {

    }
    @Override
    public void render(GemPolisherBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {

        this.renderInputStack(entity, matrices, vertexConsumers);
        this.renderEnergyStack(entity, matrices, vertexConsumers);

        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        ItemStack stack = entity.getOutputStackRenderer();
        matrices.push();
        matrices.translate(0.685f, 0.9f, 0.5f);
        matrices.scale(0.3f, 0.3f, 0.3f);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(270));

        itemRenderer.renderItem(stack, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(), entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers,
                entity.getWorld(), 1);
        matrices.pop();
    }

    private void renderInputStack(GemPolisherBlockEntity entity, MatrixStack matrices, VertexConsumerProvider vertexConsumers) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        ItemStack stack = entity.getInputStackRenderer();
        matrices.push();
        matrices.translate(0.25f, 0.9f, 0.25f);
        matrices.scale(0.25f, 0.25f, 0.25f);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(270));

        itemRenderer.renderItem(stack, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(), entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers,
                entity.getWorld(), 1);
        matrices.pop();
    }

    private void renderEnergyStack(GemPolisherBlockEntity entity, MatrixStack matrices, VertexConsumerProvider vertexConsumers) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        ItemStack stack = entity.getEnergyStackRenderer();
        matrices.push();
        matrices.translate(0.25f, 0.9f, 0.75f);
        matrices.scale(0.25f, 0.25f, 0.25f);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(270));

        itemRenderer.renderItem(stack, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(), entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers,
                entity.getWorld(), 1);
        matrices.pop();
    }

    private void renderEnergyHandler(GemPolisherBlockEntity entity, MatrixStack matrices, VertexConsumerProvider vertexConsumers) {

    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }

}
