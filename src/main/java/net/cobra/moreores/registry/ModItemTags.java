package net.cobra.moreores.registry;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.cobra.moreores.MoreOres;

public class ModItemTags {

    private static final String MINECRAFT = "minecraft";

    public static final TagKey<Item> IS_GEMSTONE = of("rare/is_gemstone");
    public static final TagKey<Item> IS_METAL = ofVanilla("is_metal");
    public static final TagKey<Item> IS_RARE = ofVanilla("rare/is_rare");
    public static final TagKey<Item> JUKEBOX_PLAYABLE_DISCS = ofVanilla("jukebox_playable_discs");
    public static final TagKey<Item> REPAIRS_RUBY_ARMOR = ofVanilla("repairs_ruby_armor");
    public static final TagKey<Item> REPAIRS_SAPPHIRE_ARMOR = ofVanilla("repairs_sapphire_armor");
    public static final TagKey<Item> REPAIRS_GREEN_GARNET_ARMOR = ofVanilla("repairs_green_garnet_armor");
    public static final TagKey<Item> REPAIRS_TOPAZ_ARMOR = ofVanilla("repairs_topaz_armor");
    public static final TagKey<Item> REPAIRS_AMETHYST_ARMOR = ofVanilla("repairs_amethyst_armor");
    public static final TagKey<Item> RUBY_TOOL_MATERIALS = ofVanilla("ruby_tool_materials");
    public static final TagKey<Item> SAPPHIRE_TOOL_MATERIALS = ofVanilla("sapphire_tool_materials");
    public static final TagKey<Item> RADIANT_TOOL_MATERIALS = ofVanilla("radiant_tool_materials");

    private static TagKey<Item> of(String id) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, id));
    }
    private static TagKey<Item> ofVanilla(String id) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(MINECRAFT, id));
    }
}
