package net.cobra.moreores.test.item;

import net.cobra.moreores.test.ModInit;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item TEST = register("test");

    private static Item register(String id) {
        return Registry.register(Registries.ITEM, Identifier.of(ModInit.MOD_ID, id), new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ModInit.MOD_ID, id)))));
    }

    public static void initialize() {

    }

}
