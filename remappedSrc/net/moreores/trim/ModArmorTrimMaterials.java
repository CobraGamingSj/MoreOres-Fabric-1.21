package net.moreores.trim;

import net.minecraft.item.Item;
import net.minecraft.item.trim.ArmorTrimMaterial;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.moreores.MoreOres;
import net.moreores.item.ModItems;

import java.util.Map;

public class ModArmorTrimMaterials {
    public static final RegistryKey<ArmorTrimMaterial> RUBY = of("ruby");
    public static final RegistryKey<ArmorTrimMaterial> RADIANT = of("radiant");
    public static final RegistryKey<ArmorTrimMaterial> SAPPHIRE = of("sapphire");
    public static final RegistryKey<ArmorTrimMaterial> GREEN_SAPPHIRE = of("green_sapphire");
    public static final RegistryKey<ArmorTrimMaterial> BLUE_GARNET = of("blue_garnet");
    public static final RegistryKey<ArmorTrimMaterial> PINK_GARNET = of("pink_garnet");
    public static final RegistryKey<ArmorTrimMaterial> GREEN_GARNET = of("green_garnet");
    public static final RegistryKey<ArmorTrimMaterial> TOPAZ = of("topaz");
    public static final RegistryKey<ArmorTrimMaterial> WHITE_TOPAZ = of("white_topaz");
    public static final RegistryKey<ArmorTrimMaterial> PERIDOT = of("peridot");
    public static final RegistryKey<ArmorTrimMaterial> JADE = of("jade");
    public static final RegistryKey<ArmorTrimMaterial> PYROPE = of("pyrope");

    public static void bootstrap(Registerable<ArmorTrimMaterial> registerable) {
        register(registerable, RUBY, Registries.ITEM.getEntry(ModItems.RUBY), Style.EMPTY.withColor(TextColor.fromRgb(16711680)), 1.1f);
        register(registerable, RADIANT, Registries.ITEM.getEntry(ModItems.RADIANT), Style.EMPTY.withColor(TextColor.fromRgb(11730944)), 1.2f);
        register(registerable, SAPPHIRE, Registries.ITEM.getEntry(ModItems.SAPPHIRE), Style.EMPTY.withColor(TextColor.fromRgb(6875)), 1.3f);
        register(registerable, GREEN_SAPPHIRE, Registries.ITEM.getEntry(ModItems.GREEN_SAPPHIRE), Style.EMPTY.withColor(TextColor.fromRgb(2925312)), 1.4f);
        register(registerable, BLUE_GARNET, Registries.ITEM.getEntry(ModItems.BLUE_GARNET), Style.EMPTY.withColor(TextColor.fromRgb(1507522)), 1.5f);
        register(registerable, PINK_GARNET, Registries.ITEM.getEntry(ModItems.PINK_GARNET), Style.EMPTY.withColor(TextColor.fromRgb(16711927)), 1.6f);
        register(registerable, GREEN_GARNET, Registries.ITEM.getEntry(ModItems.GREEN_GARNET), Style.EMPTY.withColor(TextColor.fromRgb(65331)), 1.7f);
        register(registerable, TOPAZ, Registries.ITEM.getEntry(ModItems.TOPAZ), Style.EMPTY.withColor(TextColor.fromRgb(13713152)), 1.8f);
        register(registerable, WHITE_TOPAZ, Registries.ITEM.getEntry(ModItems.WHITE_TOPAZ), Style.EMPTY.withColor(TextColor.fromRgb(15328482)), 1.9f);
        register(registerable, PERIDOT, Registries.ITEM.getEntry(ModItems.PERIDOT), Style.EMPTY.withColor(TextColor.fromRgb(52238)), 2.0f);
        register(registerable, JADE, Registries.ITEM.getEntry(ModItems.JADE), Style.EMPTY.withColor(TextColor.fromRgb(11140783)), 2.1f);
        register(registerable, PYROPE, Registries.ITEM.getEntry(ModItems.PYROPE), Style.EMPTY.withColor(TextColor.fromRgb(12717839)), 2.2f);
    }

    private static void register(Registerable<ArmorTrimMaterial> registerable, RegistryKey<ArmorTrimMaterial> armorTrimKey,
                                 RegistryEntry<Item> item, Style style, float itemModelIndex) {
        ArmorTrimMaterial trimMaterial = new ArmorTrimMaterial(armorTrimKey.getValue().getPath(), item, itemModelIndex, Map.of(),
                Text.translatable(Util.createTranslationKey("trim_material", armorTrimKey.getValue())).fillStyle(style));

        registerable.register(armorTrimKey, trimMaterial);
    }

    private static RegistryKey<ArmorTrimMaterial> of(String id) {
        Identifier ID = Identifier.of(MoreOres.MOD_ID, id);
        return RegistryKey.of(RegistryKeys.TRIM_MATERIAL, ID);
    }
}
