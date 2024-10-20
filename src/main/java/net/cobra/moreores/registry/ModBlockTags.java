package net.cobra.moreores.registry;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.cobra.moreores.MoreOres;

public class ModBlockTags {

    public static final String MINECRAFT = "minecraft";

    public static final TagKey<Block> NEEDS_RUBY_TOOL = of("needs_ruby_tool");
    public static final TagKey<Block> MOD_ORES = ofVanilla("mod_ores");
    public static final TagKey<Block> RUBY_ORES = ofVanilla("ruby_ores");
    public static final TagKey<Block> SAPPHIRE_ORES = ofVanilla("sapphire_ores");
    public static final TagKey<Block> GREEN_SAPPHIRE_ORES = ofVanilla("green_sapphire_ores");
//    public static final TagKey<Block> BLUE_GARNET_ORES = ofVanilla("blue_garnet_ores");
//    public static final TagKey<Block> PINK_GARNET_ORES = ofVanilla("pink_garnet_ores");
//    public static final TagKey<Block> GREEN_GARNET_ORES = ofVanilla("green_garnet_ores");
//    public static final TagKey<Block> TOPAZ_ORES = ofVanilla("topaz_ores");
//    public static final TagKey<Block> WHITE_TOPAZ_ORES = ofVanilla("white_topaz_ores");
//    public static final TagKey<Block> PERIDOT_ORES = ofVanilla("peridot_ores");
//    public static final TagKey<Block> JADE_ORES = ofVanilla("jade_ores");
//    public static final TagKey<Block> PYROPE_ORES = ofVanilla("pyrope_ores");

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MoreOres.MOD_ID, id));
    }
    private static TagKey<Block> ofVanilla(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MINECRAFT, id));
    }

}
