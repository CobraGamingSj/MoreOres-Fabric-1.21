package net.moreores.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.moreores.MoreOres;
import net.moreores.block.ModBlocks;

public class ModBlockEntityType {

    public static BlockEntityType<GemPolisherBlockEntity> GEM_POLISHER_BLOCK_ENTITY;

//    public static final EntityType<BasicBallProjectileEntity> BASIC_BALL = Registry.register(Registries.ENTITY_TYPE, Identifier.of(MoreOres.MOD_ID, "basic_ball"),
//            EntityType.Builder.<BasicBallProjectileEntity>create(BasicBallProjectileEntity::new, SpawnGroup.MISC).build());

        public static void register() {

            GEM_POLISHER_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MoreOres.MOD_ID, "gem_polisher_block"),
                    BlockEntityType.Builder.create(GemPolisherBlockEntity::new, ModBlocks.GEM_POLISHER_BLOCK).build(null));

//            EnergyStorage.SIDED.registerForBlockEntity((myBlockEntity, direction) -> myBlockEntity.energyStorage, GEM_POLISHER_BLOCK_ENTITY);

            MoreOres.LOGGER.info("Loading ModBlockEntities for " + MoreOres.MOD_ID + " mod.");
        }
    }
