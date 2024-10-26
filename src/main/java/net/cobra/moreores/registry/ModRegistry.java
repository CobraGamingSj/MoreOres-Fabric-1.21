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

public class ModRegistry {

    public static class ItemRegistry {


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
