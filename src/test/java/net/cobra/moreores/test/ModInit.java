package net.cobra.moreores.test;

import net.cobra.moreores.test.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;

public class ModInit implements ModInitializer {

    public static final String MOD_ID = "moreores";

    @Override
    public void onInitialize() {
        ModItems.initialize();

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.OPERATOR).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModItems.TEST);
        });

    }
}
