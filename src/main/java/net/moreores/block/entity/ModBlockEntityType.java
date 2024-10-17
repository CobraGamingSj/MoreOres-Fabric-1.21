package net.moreores.block.entity;

import com.mojang.datafixers.types.Type;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.moreores.MoreOres;
import net.moreores.block.ModBlocks;

public class ModBlockEntityType {

    public static BlockEntityType<GemPolisherBlockEntity> GEM_POLISHER_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MoreOres.MOD_ID, "gem_polisher_block"), BlockEntityType.Builder
            .create(GemPolisherBlockEntity::new, ModBlocks.GEM_POLISHER_BLOCK).build());
//    public static final BlockEntityType<ExampleBlockEntity> EXAMPLE_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MoreOres.MOD_ID, "example_block"), BlockEntityType.Builder
//            .create(ExampleBlockEntity::new, ModBlocks.EXAMPLE_BLOCK).build());

        public static void register() {

            MoreOres.LOGGER.info("Loading ModBlockEntities for " + MoreOres.MOD_ID + " mod.");
        }
    }
