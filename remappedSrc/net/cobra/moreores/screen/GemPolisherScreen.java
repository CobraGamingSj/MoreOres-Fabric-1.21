package net.cobra.moreores.screen;

import net.cobra.moreores.MoreOresModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class GemPolisherScreen extends HandledScreen<GemPolisherScreenHandler> {
    private static final int TEXTURE_WIDTH = 256;
    private static final int TEXTURE_HEIGHT = 256;
    private static final Identifier TEXTURE = MoreOresModInitializer.getId("textures/gui/container/gem_polisher/gem_polisher_gui.png");

    public GemPolisherScreen(GemPolisherScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    public void init() {
        super.init();
        titleY = 1000;
        playerInventoryTitleY = 1000;
    }

    private void renderProgressArrow(DrawContext context, int x, int y) {
        if(this.handler.isPolishing()) {
            context.drawTexture(RenderLayer::getGuiTextured, TEXTURE, x + 87, y + 31, 176, 0, 8, this.handler.progressGetter(), TEXTURE_WIDTH, TEXTURE_HEIGHT);
        }
    }

    @Override
    public void drawForeground(DrawContext context, int mouseX, int mouseY) {
        String name = this.handler.blockEntity.getDisplayName().getString();
        int x = 10;
        int y = 5;
        context.drawText(this.textRenderer, name, x, y, 4210752, false);
        super.drawForeground(context, mouseX, mouseY);
    }

    @Override
    public void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        int i = this.x;
        int j = this.y;
        context.drawTexture(RenderLayer::getGuiTextured, TEXTURE, i, j, 0.0F, 0.0F, this.backgroundWidth, this.backgroundHeight, TEXTURE_WIDTH, TEXTURE_HEIGHT);

        renderProgressArrow(context, i, j);

        int energyBarSize = MathHelper.ceil(this.handler.getEnergyPercent() * 66);
        int gradientStart = 0XFF0000FF;
        int gradientEnd = 0XFF800080;
        context.fillGradient(i + 10, j + 14 + 66 - energyBarSize, i + 10 + 20, j + 14 + 66, gradientStart, gradientEnd);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
        int energyBarSize = MathHelper.ceil(this.handler.getEnergyPercent() * 66);
        if (isPointWithinBounds(10, 14 + 66 - energyBarSize, 25, energyBarSize, mouseX, mouseY)) {
            context.drawTooltip(this.textRenderer, Text.literal(this.handler.getEnergy() + " / " + this.handler.getMaxEnergy() + " J"), mouseX, mouseY);
        }
    }
}