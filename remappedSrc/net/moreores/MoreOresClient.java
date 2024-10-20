package net.cobra.moreores;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.impl.client.model.loading.ModelLoadingEventDispatcher;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.cobra.moreores.block.ModBlocks;
import net.cobra.moreores.block.entity.ModBlockEntityType;
import net.cobra.moreores.client.render.block.entity.GemPolisherBlockEntityRenderer;
import net.cobra.moreores.screen.GemPolisherScreen;
import net.cobra.moreores.screen.ModScreenHandlers;

public class MoreOresClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TOMATO_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PINEAPPLE_CROP, RenderLayer.getCutout());

        HandledScreens.register(ModScreenHandlers.GEM_POLISHING_SCREEN_HANDLER, GemPolisherScreen::new);

        BlockEntityRendererFactories.register(ModBlockEntityType.GEM_POLISHER_BLOCK_ENTITY, GemPolisherBlockEntityRenderer::new);
    }
}
