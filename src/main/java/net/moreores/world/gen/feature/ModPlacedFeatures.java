package net.moreores.world.gen.feature;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.moreores.MoreOres;

import java.util.List;

public class ModPlacedFeatures {

    public static void bootstrap(Registerable<PlacedFeature> featureRegisterable) {
        ModOrePlacedFeatures.bootstrap(featureRegisterable);
    }

    public static RegistryKey<PlacedFeature> of(String id) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MoreOres.MOD_ID, id));
    }
}
