package net.moreores.world.gen.feature;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.moreores.block.ModBlocks;

import java.util.List;

public class ModOreConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_RUBY_SMALL = ModConfiguredFeatures.of("ore_ruby_small");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_RUBY_MEDIUM = ModConfiguredFeatures.of("ore_ruby_medium");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_RUBY_LARGE = ModConfiguredFeatures.of("ore_ruby_large");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_SAPPHIRE_SMALL = ModConfiguredFeatures.of("ore_sapphire_small");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_SAPPHIRE_MEDIUM = ModConfiguredFeatures.of("ore_sapphire_medium");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_SAPPHIRE_LARGE = ModConfiguredFeatures.of("ore_sapphire_large");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_GREEN_SAPPHIRE_SMALL = ModConfiguredFeatures.of("ore_green_sapphire_small");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_GREEN_SAPPHIRE_MEDIUM = ModConfiguredFeatures.of("ore_green_sapphire_medium");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_GREEN_SAPPHIRE_LARGE = ModConfiguredFeatures.of("ore_green_sapphire_large");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_BLUE_GARNET_SMALL = ModConfiguredFeatures.of("ore_blue_garnet_small");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_BLUE_GARNET_MEDIUM = ModConfiguredFeatures.of("ore_blue_garnet_medium");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_BLUE_GARNET_LARGE = ModConfiguredFeatures.of("ore_blue_garnet_large");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_PINK_GARNET_SMALL = ModConfiguredFeatures.of("ore_pink_garnet_small");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_PINK_GARNET_MEDIUM = ModConfiguredFeatures.of("ore_pink_garnet_medium");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_PINK_GARNET_LARGE = ModConfiguredFeatures.of("ore_pink_garnet_large");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_GREEN_GARNET_SMALL = ModConfiguredFeatures.of("ore_green_garnet_small");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_GREEN_GARNET_MEDIUM = ModConfiguredFeatures.of("ore_green_garnet_medium");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_GREEN_GARNET_LARGE = ModConfiguredFeatures.of("ore_green_garnet_large");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_TOPAZ_SMALL = ModConfiguredFeatures.of("ore_topaz_small");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_TOPAZ_MEDIUM = ModConfiguredFeatures.of("ore_topaz_medium");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_TOPAZ_LARGE = ModConfiguredFeatures.of("ore_topaz_large");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_WHITE_TOPAZ_SMALL = ModConfiguredFeatures.of("ore_white_topaz_small");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_WHITE_TOPAZ_MEDIUM = ModConfiguredFeatures.of("ore_white_topaz_medium");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_WHITE_TOPAZ_LARGE = ModConfiguredFeatures.of("ore_white_topaz_large");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_PERIDOT_SMALL = ModConfiguredFeatures.of("ore_peridot_small");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_PERIDOT_MEDIUM = ModConfiguredFeatures.of("ore_peridot_medium");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_PERIDOT_LARGE = ModConfiguredFeatures.of("ore_peridot_large");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_JADE_SMALL = ModConfiguredFeatures.of("ore_jade_small");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_JADE_MEDIUM = ModConfiguredFeatures.of("ore_jade_medium");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_JADE_LARGE = ModConfiguredFeatures.of("ore_jade_large");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_PYROPE_SMALL = ModConfiguredFeatures.of("ore_pyrope_small");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_PYROPE_MEDIUM = ModConfiguredFeatures.of("ore_pyrope_medium");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_PYROPE_LARGE = ModConfiguredFeatures.of("ore_pyrope_large");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
        RuleTest ruleTest2 = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest ruleTest3 = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        List<OreFeatureConfig.Target> list3 = List.of(
                OreFeatureConfig.createTarget(ruleTest2, ModBlocks.RUBY_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(ruleTest3, ModBlocks.DEEPSLATE_RUBY_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(ruleTest2, ModBlocks.SAPPHIRE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(ruleTest3, ModBlocks.DEEPSLATE_SAPPHIRE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(ruleTest2, ModBlocks.GREEN_SAPPHIRE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(ruleTest3, ModBlocks.DEEPSLATE_GREEN_SAPPHIRE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(ruleTest2, ModBlocks.BLUE_GARNET_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(ruleTest3, ModBlocks.DEEPSLATE_BLUE_GARNET_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(ruleTest2, ModBlocks.PINK_GARNET_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(ruleTest3, ModBlocks.DEEPSLATE_PINK_GARNET_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(ruleTest2, ModBlocks.GREEN_GARNET_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(ruleTest3, ModBlocks.DEEPSLATE_GREEN_GARNET_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(ruleTest2, ModBlocks.TOPAZ_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(ruleTest3, ModBlocks.DEEPSLATE_TOPAZ_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(ruleTest2, ModBlocks.WHITE_TOPAZ_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(ruleTest3, ModBlocks.DEEPSLATE_WHITE_TOPAZ_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(ruleTest2, ModBlocks.PERIDOT_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(ruleTest3, ModBlocks.DEEPSLATE_PERIDOT_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(ruleTest2, ModBlocks.JADE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(ruleTest3, ModBlocks.DEEPSLATE_JADE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(ruleTest2, ModBlocks.PYROPE_ORE.getDefaultState()),
                OreFeatureConfig.createTarget(ruleTest3, ModBlocks.DEEPSLATE_PYROPE_ORE.getDefaultState())
        );
        ConfiguredFeatures.register(featureRegisterable, ORE_RUBY_SMALL, Feature.ORE, new OreFeatureConfig(list3, 4, 0.5F));
        ConfiguredFeatures.register(featureRegisterable, ORE_RUBY_LARGE, Feature.ORE, new OreFeatureConfig(list3, 12, 0.7F));
        ConfiguredFeatures.register(featureRegisterable, ORE_RUBY_MEDIUM, Feature.ORE, new OreFeatureConfig(list3, 8, 0.5F));
        ConfiguredFeatures.register(featureRegisterable, ORE_SAPPHIRE_SMALL, Feature.ORE, new OreFeatureConfig(list3, 5, 0.5F));
        ConfiguredFeatures.register(featureRegisterable, ORE_SAPPHIRE_LARGE, Feature.ORE, new OreFeatureConfig(list3, 13, 0.7F));
        ConfiguredFeatures.register(featureRegisterable, ORE_SAPPHIRE_MEDIUM, Feature.ORE, new OreFeatureConfig(list3, 8, 0.5F));
        ConfiguredFeatures.register(featureRegisterable, ORE_GREEN_SAPPHIRE_SMALL, Feature.ORE, new OreFeatureConfig(list3, 3, 0.5F));
        ConfiguredFeatures.register(featureRegisterable, ORE_GREEN_SAPPHIRE_LARGE, Feature.ORE, new OreFeatureConfig(list3, 12, 0.7F));
        ConfiguredFeatures.register(featureRegisterable, ORE_GREEN_SAPPHIRE_MEDIUM, Feature.ORE, new OreFeatureConfig(list3, 8, 0.5F));
        ConfiguredFeatures.register(featureRegisterable, ORE_BLUE_GARNET_SMALL, Feature.ORE, new OreFeatureConfig(list3, 4, 0.5F));
        ConfiguredFeatures.register(featureRegisterable, ORE_BLUE_GARNET_LARGE, Feature.ORE, new OreFeatureConfig(list3, 11, 0.7F));
        ConfiguredFeatures.register(featureRegisterable, ORE_BLUE_GARNET_MEDIUM, Feature.ORE, new OreFeatureConfig(list3, 5, 0.5F));
        ConfiguredFeatures.register(featureRegisterable, ORE_PINK_GARNET_SMALL, Feature.ORE, new OreFeatureConfig(list3, 4, 0.5F));
        ConfiguredFeatures.register(featureRegisterable, ORE_PINK_GARNET_LARGE, Feature.ORE, new OreFeatureConfig(list3, 11, 0.7F));
        ConfiguredFeatures.register(featureRegisterable, ORE_PINK_GARNET_MEDIUM, Feature.ORE, new OreFeatureConfig(list3, 5, 0.5F));
        ConfiguredFeatures.register(featureRegisterable, ORE_GREEN_GARNET_SMALL, Feature.ORE, new OreFeatureConfig(list3, 4, 0.5F));
        ConfiguredFeatures.register(featureRegisterable, ORE_GREEN_GARNET_LARGE, Feature.ORE, new OreFeatureConfig(list3, 11, 0.7F));
        ConfiguredFeatures.register(featureRegisterable, ORE_GREEN_GARNET_MEDIUM, Feature.ORE, new OreFeatureConfig(list3, 5, 0.5F));
        ConfiguredFeatures.register(featureRegisterable, ORE_TOPAZ_SMALL, Feature.ORE, new OreFeatureConfig(list3, 3, 0.5F));
        ConfiguredFeatures.register(featureRegisterable, ORE_TOPAZ_LARGE, Feature.ORE, new OreFeatureConfig(list3, 10, 0.7F));
        ConfiguredFeatures.register(featureRegisterable, ORE_TOPAZ_MEDIUM, Feature.ORE, new OreFeatureConfig(list3, 4, 0.5F));
        ConfiguredFeatures.register(featureRegisterable, ORE_WHITE_TOPAZ_SMALL, Feature.ORE, new OreFeatureConfig(list3, 3, 0.5F));
        ConfiguredFeatures.register(featureRegisterable, ORE_WHITE_TOPAZ_LARGE, Feature.ORE, new OreFeatureConfig(list3, 10, 0.7F));
        ConfiguredFeatures.register(featureRegisterable, ORE_WHITE_TOPAZ_MEDIUM, Feature.ORE, new OreFeatureConfig(list3, 4, 0.5F));
        ConfiguredFeatures.register(featureRegisterable, ORE_PERIDOT_SMALL, Feature.ORE, new OreFeatureConfig(list3, 4, 0.5F));
        ConfiguredFeatures.register(featureRegisterable, ORE_PERIDOT_LARGE, Feature.ORE, new OreFeatureConfig(list3, 11, 0.7F));
        ConfiguredFeatures.register(featureRegisterable, ORE_PERIDOT_MEDIUM, Feature.ORE, new OreFeatureConfig(list3, 5, 0.5F));
        ConfiguredFeatures.register(featureRegisterable, ORE_JADE_SMALL, Feature.ORE, new OreFeatureConfig(list3, 4, 0.5F));
        ConfiguredFeatures.register(featureRegisterable, ORE_JADE_LARGE, Feature.ORE, new OreFeatureConfig(list3, 11, 0.7F));
        ConfiguredFeatures.register(featureRegisterable, ORE_JADE_MEDIUM, Feature.ORE, new OreFeatureConfig(list3, 5, 0.5F));
        ConfiguredFeatures.register(featureRegisterable, ORE_PYROPE_SMALL, Feature.ORE, new OreFeatureConfig(list3, 4, 0.5F));
        ConfiguredFeatures.register(featureRegisterable, ORE_PYROPE_LARGE, Feature.ORE, new OreFeatureConfig(list3, 11, 0.7F));
        ConfiguredFeatures.register(featureRegisterable, ORE_PYROPE_MEDIUM, Feature.ORE, new OreFeatureConfig(list3, 5, 0.5F));
    }

}
