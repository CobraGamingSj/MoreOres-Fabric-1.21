package net.moreores.village;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import net.moreores.MoreOres;
import net.moreores.block.ModBlocks;

public class ModVillagerProfessions {
    public static final RegistryKey<PointOfInterestType> JEWEL_POI = poiKey("jewel_poi");
    public static final PointOfInterestType JEWEL = registerPoi("jewel_poi", ModBlocks.GEM_POLISHER_BLOCK);

    public static final VillagerProfession JEWELLER = registerProfession("jeweller", JEWEL_POI);


    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, Identifier.of(MoreOres.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_SHEPHERD));
    }

    private static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(Identifier.of(MoreOres.MOD_ID, name), 1, 1, block);
    }

    private static RegistryKey<PointOfInterestType> poiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(MoreOres.MOD_ID, name));
    }

    public static void register() {
        MoreOres.LOGGER.info("Loading ModVillagerProfessions for " + MoreOres.MOD_ID + " mod.");
    }
}