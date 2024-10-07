package net.moreores.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.moreores.block.ModBlocks;
import net.moreores.registry.ModBlockTags;

import java.util.concurrent.CompletableFuture;

public class BlockTagGen extends FabricTagProvider.BlockTagProvider {
    public BlockTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.GEM_POLISHER_BLOCK)
                .add(ModBlocks.ENERGY_BLOCK)
                .add(ModBlocks.RUBY_BLOCK)
                .add(ModBlocks.RADIANT_BLOCK)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.DEEPSLATE_RUBY_ORE)
                .add(ModBlocks.SAPPHIRE_BLOCK)
                .add(ModBlocks.SAPPHIRE_ORE)
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE)
                .add(ModBlocks.GREEN_SAPPHIRE_BLOCK)
                .add(ModBlocks.GREEN_SAPPHIRE_ORE)
                .add(ModBlocks.DEEPSLATE_GREEN_SAPPHIRE_ORE)
                .add(ModBlocks.BLUE_GARNET_BLOCK)
                .add(ModBlocks.GREEN_GARNET_BLOCK)
                .add(ModBlocks.PINK_GARNET_BLOCK)
                .add(ModBlocks.BLUE_GARNET_ORE)
                .add(ModBlocks.GREEN_GARNET_ORE)
                .add(ModBlocks.PINK_GARNET_ORE)
                .add(ModBlocks.DEEPSLATE_BLUE_GARNET_ORE)
                .add(ModBlocks.DEEPSLATE_GREEN_GARNET_ORE)
                .add(ModBlocks.DEEPSLATE_PINK_GARNET_ORE)
                .add(ModBlocks.TOPAZ_BLOCK)
                .add(ModBlocks.TOPAZ_ORE)
                .add(ModBlocks.DEEPSLATE_TOPAZ_ORE)
                .add(ModBlocks.WHITE_TOPAZ_BLOCK)
                .add(ModBlocks.WHITE_TOPAZ_ORE)
                .add(ModBlocks.DEEPSLATE_WHITE_TOPAZ_ORE)
                .add(ModBlocks.PERIDOT_BLOCK)
                .add(ModBlocks.PERIDOT_ORE)
                .add(ModBlocks.DEEPSLATE_PERIDOT_ORE)
                .add(ModBlocks.JADE_BLOCK)
                .add(ModBlocks.JADE_ORE)
                .add(ModBlocks.DEEPSLATE_JADE_ORE)
                .add(ModBlocks.PYROPE_BLOCK)
                .add(ModBlocks.PYROPE_ORE)
                .add(ModBlocks.DEEPSLATE_PYROPE_ORE)
                .add(ModBlocks.RAW_RUBY_BLOCK)
                .add(ModBlocks.RAW_SAPPHIRE_BLOCK)
                .add(ModBlocks.RAW_GREEN_SAPPHIRE_BLOCK)
                .add(ModBlocks.RAW_BLUE_GARNET_BLOCK)
                .add(ModBlocks.RAW_PINK_GARNET_BLOCK)
                .add(ModBlocks.RAW_GREEN_GARNET_BLOCK)
                .add(ModBlocks.RAW_TOPAZ_BLOCK)
                .add(ModBlocks.RAW_WHITE_TOPAZ_BLOCK)
                .add(ModBlocks.RAW_PERIDOT_BLOCK)
                .add(ModBlocks.RAW_PYROPE_BLOCK)
                .add(ModBlocks.RAW_JADE_BLOCK);

        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
        ;

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, Identifier.of("fabric", "needs_tool_level_4")))
        ;

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.GEM_POLISHER_BLOCK)
                .add(ModBlocks.ENERGY_BLOCK)
                .add(ModBlocks.RUBY_BLOCK)
                .add(ModBlocks.RADIANT_BLOCK)
                .add(ModBlocks.SAPPHIRE_BLOCK)
                .add(ModBlocks.GREEN_SAPPHIRE_BLOCK)
                .add(ModBlocks.BLUE_GARNET_BLOCK)
                .add(ModBlocks.GREEN_GARNET_BLOCK)
                .add(ModBlocks.PINK_GARNET_BLOCK)
                .add(ModBlocks.TOPAZ_BLOCK)
                .add(ModBlocks.WHITE_TOPAZ_BLOCK)
                .add(ModBlocks.PERIDOT_BLOCK)
                .add(ModBlocks.JADE_BLOCK)
                .add(ModBlocks.PYROPE_BLOCK)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.DEEPSLATE_RUBY_ORE)
                .add(ModBlocks.SAPPHIRE_ORE)
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE)
                .add(ModBlocks.GREEN_SAPPHIRE_ORE)
                .add(ModBlocks.DEEPSLATE_GREEN_SAPPHIRE_ORE)
                .add(ModBlocks.BLUE_GARNET_ORE)
                .add(ModBlocks.GREEN_GARNET_ORE)
                .add(ModBlocks.PINK_GARNET_ORE)
                .add(ModBlocks.DEEPSLATE_BLUE_GARNET_ORE)
                .add(ModBlocks.DEEPSLATE_GREEN_GARNET_ORE)
                .add(ModBlocks.DEEPSLATE_PINK_GARNET_ORE)
                .add(ModBlocks.TOPAZ_ORE)
                .add(ModBlocks.DEEPSLATE_TOPAZ_ORE)
                .add(ModBlocks.WHITE_TOPAZ_ORE)
                .add(ModBlocks.DEEPSLATE_WHITE_TOPAZ_ORE)
                .add(ModBlocks.PERIDOT_ORE)
                .add(ModBlocks.DEEPSLATE_PERIDOT_ORE)
                .add(ModBlocks.JADE_ORE)
                .add(ModBlocks.DEEPSLATE_JADE_ORE)
                .add(ModBlocks.PYROPE_ORE)
                .add(ModBlocks.DEEPSLATE_PYROPE_ORE)
                .add(ModBlocks.RAW_RUBY_BLOCK)
                .add(ModBlocks.RAW_SAPPHIRE_BLOCK)
                .add(ModBlocks.RAW_GREEN_SAPPHIRE_BLOCK)
                .add(ModBlocks.RAW_BLUE_GARNET_BLOCK)
                .add(ModBlocks.RAW_PINK_GARNET_BLOCK)
                .add(ModBlocks.RAW_GREEN_GARNET_BLOCK)
                .add(ModBlocks.RAW_TOPAZ_BLOCK)
                .add(ModBlocks.RAW_WHITE_TOPAZ_BLOCK)
                .add(ModBlocks.RAW_PERIDOT_BLOCK)
                .add(ModBlocks.RAW_PYROPE_BLOCK)
                .add(ModBlocks.RAW_JADE_BLOCK);

        getOrCreateTagBuilder(ModBlockTags.NEEDS_RUBY_TOOL)
                ;

        getOrCreateTagBuilder(ModBlockTags.RUBY_ORES)
                .add(ModBlocks.RUBY_ORE)
                .add(ModBlocks.DEEPSLATE_RUBY_ORE);

        getOrCreateTagBuilder(ModBlockTags.SAPPHIRE_ORES)
                .add(ModBlocks.SAPPHIRE_ORE)
                .add(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);

        getOrCreateTagBuilder(ModBlockTags.GREEN_SAPPHIRE_ORES)
                .add(ModBlocks.GREEN_SAPPHIRE_ORE)
                .add(ModBlocks.DEEPSLATE_GREEN_SAPPHIRE_ORE);

        getOrCreateTagBuilder(ModBlockTags.MOD_ORES)
                .forceAddTag(ModBlockTags.RUBY_ORES)
                .forceAddTag(ModBlockTags.SAPPHIRE_ORES)
                .forceAddTag(ModBlockTags.GREEN_SAPPHIRE_ORES);
    }
}
