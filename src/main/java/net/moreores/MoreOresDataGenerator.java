package net.moreores;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.moreores.block.jukebox.ModJukeboxSongs;
import net.moreores.datagen.*;
import net.moreores.trim.ModArmorTrimMaterials;
import net.moreores.trim.ModArmorTrimPatterns;
import net.moreores.world.gen.feature.ModConfiguredFeatures;
import net.moreores.world.gen.feature.ModPlacedFeatures;

public class MoreOresDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(DynamicRegistry::new);
		pack.addProvider(ItemTagGen::new);
		pack.addProvider(BlockTagGen::new);
		pack.addProvider(ModelGen::new);
		pack.addProvider(AdvancementGen::new);
		pack.addProvider(LootTableGenerator::new);
		pack.addProvider(PointOfInterestTypeTagGen::new);
		pack.addProvider(RecipeGen::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.JUKEBOX_SONG, ModJukeboxSongs::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.TRIM_MATERIAL, ModArmorTrimMaterials::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.TRIM_PATTERN, ModArmorTrimPatterns::bootstrap);
	}
}
