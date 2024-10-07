package net.moreores.trim;

import net.minecraft.item.Item;
import net.minecraft.item.trim.ArmorTrimPattern;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.moreores.MoreOres;
import net.moreores.item.ModItems;

public class ModArmorTrimPatterns {
    public static final RegistryKey<ArmorTrimPattern> GUARDIAN = of("guardian");

    public static void bootstrap(Registerable<ArmorTrimPattern> registerable) {
        register(registerable, ModItems.GUARDIAN_ARMOR_TRIM_SMITHING_TEMPLATE, GUARDIAN);
    }

    private static void register(Registerable<ArmorTrimPattern> context, Item item, RegistryKey<ArmorTrimPattern> key) {
        ArmorTrimPattern trimPattern = new ArmorTrimPattern(key.getValue(), Registries.ITEM.getEntry(item),
                Text.translatable(Util.createTranslationKey("trim_pattern", key.getValue())), false);

        context.register(key, trimPattern);
    }

    private static RegistryKey<ArmorTrimPattern> of(String id) {
        Identifier ID = Identifier.of(MoreOres.MOD_ID, id);
        return RegistryKey.of(RegistryKeys.TRIM_PATTERN, ID);
    }
}
