package net.cobra.moreores.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.cobra.moreores.MoreOresModInitializer;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class GemPolisherScreen extends HandledScreen<GemPolisherScreenHandler> {
    public static final Identifier PROGRESS_ARROW_TEXTURE = Identifier.of(MoreOresModInitializer.MOD_ID, "textures/gui/containers/gem_polisher/progress_arrow");
    private static final Identifier TEXTURE = Identifier.of(MoreOresModInitializer.MOD_ID, "textures/gui/container/gem_polisher/gem_polisher_gui.png");

    public GemPolisherScreen(GemPolisherScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleY = 1000;
        playerInventoryTitleY = 1000;
    }

    private void renderProgressArrow(DrawContext context, int x, int y) {
        int textureHeight = 26;
        int textureWidth = 8;
        if(handler.isPolishing()) {
            context.drawGuiTexture(RenderLayer::getGuiTextured, PROGRESS_ARROW_TEXTURE, x + 88, y + 31, 176, 0, 8, handler.progressGetter(), textureWidth, textureHeight);
        }
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        String name = this.handler.blockEntity.getDisplayName().getString();
        int x = 10;
        context.drawText(this.textRenderer, name, x, 6, 4210752, false);
        super.drawForeground(context, mouseX, mouseY);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;

        context.drawTexture(RenderLayer::getGuiTextured, TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight, 256, 256);

        renderProgressArrow(context, x, y);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}