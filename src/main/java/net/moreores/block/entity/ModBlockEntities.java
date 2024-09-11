package net.moreores.block.entity;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.moreores.MoreOres;
import net.moreores.block.ModBlocks;
import team.reborn.energy.api.EnergyStorage;

public class ModBlockEntities {

    public static BlockEntityType<GemPolisherBlockEntity> GEM_POLISHER_BLOCK_ENTITY;


        public static void register() {

            GEM_POLISHER_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MoreOres.MOD_ID, "gem_polisher_block"),
                    BlockEntityType.Builder.create(GemPolisherBlockEntity::new, ModBlocks.GEM_POLISHER_BLOCK).build(null));

//            EnergyStorage.SIDED.registerForBlockEntity((myBlockEntity, direction) -> myBlockEntity.energyStorage, GEM_POLISHER_BLOCK_ENTITY);

            MoreOres.LOGGER.info("Loading ModBlockEntities for " + MoreOres.MOD_ID + " mod.");
        }
    }
