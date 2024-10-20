package net.cobra.moreores.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.cobra.moreores.MoreOres;
import net.cobra.moreores.world.gen.feature.ModOrePlacedFeatures;

public class WorldGeneration {
    public static void generateOres() {

        MoreOres.LOGGER.info("Setting Up world generation for Custom Ores for " + MoreOres.MOD_ID + " mod.");

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModOrePlacedFeatures.ORE_RUBY);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModOrePlacedFeatures.ORE_RUBY_MEDIUM);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModOrePlacedFeatures.ORE_RUBY_LARGE);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModOrePlacedFeatures.ORE_SAPPHIRE);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModOrePlacedFeatures.ORE_SAPPHIRE_MEDIUM);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModOrePlacedFeatures.ORE_SAPPHIRE_LARGE);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModOrePlacedFeatures.ORE_GREEN_SAPPHIRE);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModOrePlacedFeatures.ORE_GREEN_SAPPHIRE_MEDIUM);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModOrePlacedFeatures.ORE_GREEN_SAPPHIRE_LARGE);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModOrePlacedFeatures.ORE_BLUE_GARNET);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModOrePlacedFeatures.ORE_BLUE_GARNET_MEDIUM);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModOrePlacedFeatures.ORE_BLUE_GARNET_LARGE);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModOrePlacedFeatures.ORE_PINK_GARNET);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModOrePlacedFeatures.ORE_PINK_GARNET_MEDIUM);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModOrePlacedFeatures.ORE_PINK_GARNET_LARGE);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModOrePlacedFeatures.ORE_GREEN_GARNET);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModOrePlacedFeatures.ORE_GREEN_GARNET_MEDIUM);

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES, ModOrePlacedFeatures.ORE_GREEN_GARNET_LARGE);
    }
}
