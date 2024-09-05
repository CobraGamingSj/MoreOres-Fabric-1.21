package net.moreores.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.moreores.MoreOres;
import net.moreores.block.data.GemPolisherData;

public class ModScreenHandlers {

    public static final ScreenHandlerType<GemPolisherScreenHandler> GEM_POLISHING_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(MoreOres.MOD_ID, "gem_polisher_screen_handler"), new ExtendedScreenHandlerType<>(
                    GemPolisherScreenHandler::new, GemPolisherData.PACKET_CODEC
            ));

    public static void register() {

    }
}
