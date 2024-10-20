package net.cobra.moreores.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.cobra.moreores.MoreOres;
import net.cobra.moreores.registry.ModRegistry;
import net.cobra.moreores.sound.ModBlockSoundGroup;

public class ModBlocks {

    public static final Block TOMATO_CROP = Registry.register(Registries.BLOCK, Identifier.of(MoreOres.MOD_ID, "tomato_crop"),
            new TomatoCropBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_GREEN)
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block PINEAPPLE_CROP = Registry.register(Registries.BLOCK, Identifier.of(MoreOres.MOD_ID, "pineapple_crop"),
            new PineappleCropBlock(AbstractBlock.Settings.create().mapColor(MapColor.YELLOW)
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block ENERGY_BLOCK = ModRegistry.BlockRegistry.register("energy_block", new EnergyBlock(AbstractBlock.Settings.create().mapColor(MapColor.BLUE).requiresTool().strength(256.0f, 512.0f).strength(512.0f).sounds(ModBlockSoundGroup.ENERGY_BLOCK).luminance((state) -> {
        return 30;
    })));
    public static final Block RUBY_LAMP = ModRegistry.BlockRegistry.register("ruby_lamp", new RubyLampBlock(AbstractBlock.Settings.create().hardness(0.1f).sounds(BlockSoundGroup.GLASS).luminance(state -> state.get(RubyLampBlock.LIT) ? 15:0)));
    public static final Block RUBY_BLOCK = ModRegistry.BlockRegistry.register("ruby_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.DARK_RED).requiresTool().strength(5.0f, 5.0f).strength(5.0f)));
    public static final Block RADIANT_BLOCK = ModRegistry.BlockRegistry.register("radiant_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.BRIGHT_RED).requiresTool().strength(5.0f, 5.0f).strength(5.0f)));
    public static final Block SAPPHIRE_BLOCK = ModRegistry.BlockRegistry.register("sapphire_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLUE).requiresTool().strength(4.0f, 4.0f).strength(4.0f)));
    public static final Block GREEN_SAPPHIRE_BLOCK = ModRegistry.BlockRegistry.register("green_sapphire_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.GREEN).requiresTool().strength(4.0f, 4.0f).strength(4.0f)));
    public static final Block BLUE_GARNET_BLOCK = ModRegistry.BlockRegistry.register("blue_garnet_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLUE).requiresTool().strength(6.0f, 6.5f).strength(7.0f).sounds(BlockSoundGroup.AMETHYST_CLUSTER)));
    public static final Block PINK_GARNET_BLOCK = ModRegistry.BlockRegistry.register("pink_garnet_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.PINK).requiresTool().strength(6.0f, 6.5f).strength(7.0f).sounds(BlockSoundGroup.AMETHYST_CLUSTER)));
    public static final Block GREEN_GARNET_BLOCK = ModRegistry.BlockRegistry.register("green_garnet_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.PINK).requiresTool().strength(6.0f, 6.5f).strength(7.0f).sounds(BlockSoundGroup.AMETHYST_CLUSTER)));
    public static final Block TOPAZ_BLOCK = ModRegistry.BlockRegistry.register("topaz_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).requiresTool().strength(8.0f, 8.0f).strength(9.0f)));
    public static final Block PERIDOT_BLOCK = ModRegistry.BlockRegistry.register("peridot_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.GREEN).requiresTool().strength(8.0f, 8.0f).strength(9.0f).sounds(BlockSoundGroup.METAL)));
    public static final Block WHITE_TOPAZ_BLOCK = ModRegistry.BlockRegistry.register("white_topaz_block", new Block(AbstractBlock.Settings.create().requiresTool().strength(6.0f, 6.5f).strength(7.0f)));
    public static final Block PYROPE_BLOCK = ModRegistry.BlockRegistry.register("pyrope_block", new Block(AbstractBlock.Settings.create().requiresTool().strength(6.0f, 6.5f).strength(7.0f)));
    public static final Block JADE_BLOCK = ModRegistry.BlockRegistry.register("jade_block", new Block(AbstractBlock.Settings.create().requiresTool().strength(6.0f, 6.5f).strength(7.0f)));
    public static final Block GEM_POLISHER_BLOCK = ModRegistry.BlockRegistry.register("gem_polisher_block", new GemPolisherBlock(AbstractBlock.Settings.create().strength(5f).strength(2.75f, 3f).requiresTool().nonOpaque().sounds(BlockSoundGroup.HEAVY_CORE)));

    public static final Block RAW_RUBY_BLOCK = ModRegistry.BlockRegistry.register("raw_ruby_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.DARK_RED).requiresTool().strength(6.0f, 6.0f).strength(6.0f)));
    public static final Block RAW_SAPPHIRE_BLOCK = ModRegistry.BlockRegistry.register("raw_sapphire_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLUE).requiresTool().strength(5.0f, 5.0f).strength(5.0f)));
    public static final Block RAW_GREEN_SAPPHIRE_BLOCK = ModRegistry.BlockRegistry.register("raw_green_sapphire_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.GREEN).requiresTool().strength(5.0f, 5.0f).strength(5.0f)));
    public static final Block RAW_BLUE_GARNET_BLOCK = ModRegistry.BlockRegistry.register("raw_blue_garnet_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLUE).requiresTool().strength(7.0f, 7.5f).strength(8.0f).sounds(BlockSoundGroup.AMETHYST_CLUSTER)));
    public static final Block RAW_PINK_GARNET_BLOCK = ModRegistry.BlockRegistry.register("raw_pink_garnet_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.PINK).requiresTool().strength(7.0f, 7.5f).strength(8.0f).sounds(BlockSoundGroup.AMETHYST_CLUSTER)));
    public static final Block RAW_GREEN_GARNET_BLOCK = ModRegistry.BlockRegistry.register("raw_green_garnet_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.PINK).requiresTool().strength(7.0f, 7.5f).strength(8.0f).sounds(BlockSoundGroup.AMETHYST_CLUSTER)));
    public static final Block RAW_TOPAZ_BLOCK = ModRegistry.BlockRegistry.register("raw_topaz_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).requiresTool().strength(9.0f, 9.0f).strength(10.0f)));
    public static final Block RAW_PERIDOT_BLOCK = ModRegistry.BlockRegistry.register("raw_peridot_block", new Block(AbstractBlock.Settings.create().mapColor(MapColor.GREEN).requiresTool().strength(9.0f, 9.0f).strength(10.0f).sounds(BlockSoundGroup.METAL)));
    public static final Block RAW_WHITE_TOPAZ_BLOCK = ModRegistry.BlockRegistry.register("raw_white_topaz_block", new Block(AbstractBlock.Settings.create().requiresTool().strength(7.0f, 7.5f).strength(8.0f)));
    public static final Block RAW_PYROPE_BLOCK = ModRegistry.BlockRegistry.register("raw_pyrope_block", new Block(AbstractBlock.Settings.create().requiresTool().strength(7.0f, 7.5f).strength(8.0f)));
    public static final Block RAW_JADE_BLOCK = ModRegistry.BlockRegistry.register("raw_jade_block", new Block(AbstractBlock.Settings.create().requiresTool().strength(7.0f, 7.5f).strength(8.0f)));

    public static final Block RUBY_ORE = ModRegistry.BlockRegistry.register("ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 3), AbstractBlock.Settings.create().requiresTool().strength(6.0f, 6.0f).strength(6.0f).sounds(BlockSoundGroup.STONE).mapColor(MapColor.STONE_GRAY)));
    public static final Block DEEPSLATE_RUBY_ORE = ModRegistry.BlockRegistry.register("deepslate_ruby_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 3), AbstractBlock.Settings.create().requiresTool().strength(6.5f, 6.5f).strength(6.5f).sounds(BlockSoundGroup.STONE).mapColor(MapColor.STONE_GRAY)));
    public static final Block SAPPHIRE_ORE = ModRegistry.BlockRegistry.register("sapphire_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 3), AbstractBlock.Settings.create().requiresTool().strength(5.0f, 5.0f).strength(5.0f).sounds(BlockSoundGroup.STONE).mapColor(MapColor.STONE_GRAY)));
    public static final Block DEEPSLATE_SAPPHIRE_ORE = ModRegistry.BlockRegistry.register("deepslate_sapphire_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 3), AbstractBlock.Settings.create().requiresTool().strength(5.5f, 5.5f).strength(5.5f).sounds(BlockSoundGroup.STONE).mapColor(MapColor.STONE_GRAY)));
    public static final Block GREEN_SAPPHIRE_ORE = ModRegistry.BlockRegistry.register("green_sapphire_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 3), AbstractBlock.Settings.create().requiresTool().strength(5.0f, 5.0f).strength(5.0f).sounds(BlockSoundGroup.STONE).mapColor(MapColor.STONE_GRAY)));
    public static final Block DEEPSLATE_GREEN_SAPPHIRE_ORE = ModRegistry.BlockRegistry.register("deepslate_green_sapphire_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 3), AbstractBlock.Settings.create().requiresTool().strength(5.5f, 5.5f).strength(5.5f).sounds(BlockSoundGroup.STONE).mapColor(MapColor.STONE_GRAY)));
    public static final Block BLUE_GARNET_ORE = ModRegistry.BlockRegistry.register("blue_garnet_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 3), AbstractBlock.Settings.create().requiresTool().strength(7.0f, 7.5f).strength(8.0f).sounds(BlockSoundGroup.STONE).mapColor(MapColor.STONE_GRAY)));
    public static final Block DEEPSLATE_BLUE_GARNET_ORE = ModRegistry.BlockRegistry.register("deepslate_blue_garnet_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 3), AbstractBlock.Settings.create().requiresTool().strength(7.5f, 8.0f).strength(8.5f).sounds(BlockSoundGroup.STONE).mapColor(MapColor.STONE_GRAY)));
    public static final Block PINK_GARNET_ORE = ModRegistry.BlockRegistry.register("pink_garnet_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 3), AbstractBlock.Settings.create().requiresTool().strength(7.0f, 7.5f).strength(8.0f).sounds(BlockSoundGroup.STONE).mapColor(MapColor.STONE_GRAY)));
    public static final Block DEEPSLATE_PINK_GARNET_ORE = ModRegistry.BlockRegistry.register("deepslate_pink_garnet_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 3), AbstractBlock.Settings.create().requiresTool().strength(7.5f, 8.0f).strength(8.5f).sounds(BlockSoundGroup.STONE).mapColor(MapColor.STONE_GRAY)));
    public static final Block GREEN_GARNET_ORE = ModRegistry.BlockRegistry.register("green_garnet_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 3), AbstractBlock.Settings.create().requiresTool().strength(7.0f, 7.5f).strength(8.0f).sounds(BlockSoundGroup.STONE).mapColor(MapColor.STONE_GRAY)));
    public static final Block DEEPSLATE_GREEN_GARNET_ORE = ModRegistry.BlockRegistry.register("deepslate_green_garnet_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 3), AbstractBlock.Settings.create().requiresTool().strength(7.5f, 8.0f).strength(8.5f).sounds(BlockSoundGroup.STONE).mapColor(MapColor.STONE_GRAY)));
    public static final Block TOPAZ_ORE = ModRegistry.BlockRegistry.register("topaz_ore", new ExperienceDroppingBlock(UniformIntProvider.create(1, 3), AbstractBlock.Settings.create().requiresTool().strength(9.0f, 9.0f).strength(10.0f).sounds(BlockSoundGroup.STONE).mapColor(MapColor.STONE_GRAY)));
    public static final Block DEEPSLATE_TOPAZ_ORE = ModRegistry.BlockRegistry.register("deepslate_topaz_ore", new ExperienceDroppingBlock(UniformIntProvider.create(1, 3), AbstractBlock.Settings.create().requiresTool().strength(9.5f, 9.5f).strength(10.5f).sounds(BlockSoundGroup.STONE).mapColor(MapColor.STONE_GRAY)));
    public static final Block PERIDOT_ORE = ModRegistry.BlockRegistry.register("peridot_ore", new ExperienceDroppingBlock(UniformIntProvider.create(1, 2), AbstractBlock.Settings.create().requiresTool().strength(9.0f, 9.0f).strength(10.0f).sounds(BlockSoundGroup.STONE).mapColor(MapColor.STONE_GRAY)));
    public static final Block DEEPSLATE_PERIDOT_ORE = ModRegistry.BlockRegistry.register("deepslate_peridot_ore", new ExperienceDroppingBlock(UniformIntProvider.create(1, 2), AbstractBlock.Settings.create().requiresTool().strength(9.5f, 9.5f).strength(10.5f).sounds(BlockSoundGroup.STONE).mapColor(MapColor.STONE_GRAY)));
    public static final Block WHITE_TOPAZ_ORE = ModRegistry.BlockRegistry.register("white_topaz_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 5), AbstractBlock.Settings.create().requiresTool().strength(9.5f, 9.5f).strength(10.5f).sounds(BlockSoundGroup.STONE).mapColor(MapColor.STONE_GRAY)));
    public static final Block DEEPSLATE_WHITE_TOPAZ_ORE = ModRegistry.BlockRegistry.register("deepslate_white_topaz_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 5), AbstractBlock.Settings.create().requiresTool().strength(10.0f, 10.0f).strength(11.0f).sounds(BlockSoundGroup.STONE).mapColor(MapColor.STONE_GRAY)));
    public static final Block PYROPE_ORE = ModRegistry.BlockRegistry.register("pyrope_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 5), AbstractBlock.Settings.create().requiresTool().strength(9.5f, 9.5f).strength(10.5f).sounds(BlockSoundGroup.STONE).mapColor(MapColor.STONE_GRAY)));
    public static final Block DEEPSLATE_PYROPE_ORE = ModRegistry.BlockRegistry.register("deepslate_pyrope_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 5), AbstractBlock.Settings.create().requiresTool().strength(10.0f, 10.0f).strength(11.0f).sounds(BlockSoundGroup.STONE).mapColor(MapColor.STONE_GRAY)));
    public static final Block JADE_ORE = ModRegistry.BlockRegistry.register("jade_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 5), AbstractBlock.Settings.create().requiresTool().strength(10.0f, 10.0f).strength(11.0f).sounds(BlockSoundGroup.STONE).mapColor(MapColor.STONE_GRAY)));
    public static final Block DEEPSLATE_JADE_ORE = ModRegistry.BlockRegistry.register("deepslate_jade_ore", new ExperienceDroppingBlock(UniformIntProvider.create(3, 5), AbstractBlock.Settings.create().requiresTool().strength(10.5f, 10.5f).strength(11.5f).sounds(BlockSoundGroup.STONE).mapColor(MapColor.STONE_GRAY)));
//    public static final Block EXAMPLE_BLOCK = ModRegistry.BlockRegistry.register("examole_block", new ExampleBlock(AbstractBlock.Settings.create()));

    public static void register() {
        MoreOres.LOGGER.info("Loading ModBlocks for " + MoreOres.MOD_ID + " mod.");
    }

}