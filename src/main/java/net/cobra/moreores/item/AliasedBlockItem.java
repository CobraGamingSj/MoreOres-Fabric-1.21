package net.cobra.moreores.item;

import net.cobra.moreores.MoreOres;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class AliasedBlockItem extends BlockItem {
    private AliasedBlockItem(Block block) {
        super(block, new Settings());
    }

    public static Item of(String itemId, Block block) {
        Settings settings = new Settings();

        Identifier ID = Identifier.of(MoreOres.MOD_ID, itemId);

        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, ID);

        return new BlockItem(block, settings.registryKey(key).useItemPrefixedTranslationKey());
    }
}
