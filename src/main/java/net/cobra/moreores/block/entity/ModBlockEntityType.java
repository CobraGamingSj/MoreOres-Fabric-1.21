package net.cobra.moreores.block.entity;

import net.cobra.moreores.MoreOresModInitializer;
import net.cobra.moreores.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntityType {

    public static final BlockEntityType<GemPolisherBlockEntity> GEM_POLISHER_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MoreOresModInitializer.MOD_ID, "gem_polisher"), FabricBlockEntityTypeBuilder.create(GemPolisherBlockEntity::new, ModBlocks.GEM_POLISHER_BLOCK).build());

        public static void register() {

            MoreOresModInitializer.LOGGER.info("Loading ModBlockEntities for " + MoreOresModInitializer.MOD_ID + " mod.");
        }
    }
