package net.cobra.moreores.registry;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.cobra.moreores.MoreOres;
import net.cobra.moreores.block.ModBlocks;
import net.cobra.moreores.item.ModItems;

import java.util.function.Function;

public class ModRegistry {

    public static class ItemRegistry {


        public static Item register(String id, Function<Item.Settings, Item> factory) {
            return register(keyOf(id), factory, new Item.Settings());
        }

        public static Item register(String id, Function<Item.Settings, Item> factory, Item.Settings settings) {
            return register(keyOf(id), factory, settings);
        }

        public static Item register(String id, Item.Settings settings) {
            return register(keyOf(id), Item::new, settings);
        }

        public static Item register(String id) {
            return register(keyOf(id), Item::new, new Item.Settings());
        }

        public static Item register(RegistryKey<Item> key, Function<Item.Settings, Item> factory) {
            return register(key, factory, new Item.Settings());
        }

        public static Item register(RegistryKey<Item> key, Function<Item.Settings, Item> factory, Item.Settings settings) {
            Item item = (Item)factory.apply(settings.registryKey(key));
            if (item instanceof BlockItem blockItem) {
                blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
            }

            return Registry.register(Registries.ITEM, key, item);
        }


        //Items Registry
        public static Item registerItem(String id, Item item) {
            Identifier iD = Identifier.of(MoreOres.MOD_ID, id);
            RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, iD);

            Item.Settings settings = new Item.Settings()
                    // If your item is based on a block
                    .useBlockPrefixedTranslationKey()
                    .registryKey(key);
            return Registry.register(Registries.ITEM, key, new Item(settings));
        }

        //Class Registry
        public static void register() {
            ModItems.register();
        }

    }
    public static class BlockRegistry{


        //Block Registry
        public static Block register(String id, Block block) {
            registerBlockItem(id, block);
            Identifier ID = Identifier.of(MoreOres.MOD_ID, id);
            return Registry.register(Registries.BLOCK, ID, block);
        }

        //BlockItem Registry
        public static Item registerBlockItem(String id, Block block) {
            Identifier ID = Identifier.of(MoreOres.MOD_ID, id);
            return Registry.register(Registries.ITEM, ID, new BlockItem(block, new Item.Settings()));
        }

        public static void register() {
            ModBlocks.register();
        }

    }
}
