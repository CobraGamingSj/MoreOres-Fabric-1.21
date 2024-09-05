package net.moreores.registry;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.moreores.MoreOres;

public class ModBlockTags {

    public static final String MINECRAFT = "minecraft";

    public static final TagKey<Block> NEEDS_RUBY_TOOL = of("needs_ruby_tool");
    public static final TagKey<Block> RUBY_ORES = ofVanilla("ruby_ores");

    private static TagKey<Block> of(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MoreOres.MOD_ID, id));
    }
    private static TagKey<Block> ofVanilla(String id) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MINECRAFT, id));
    }

}
