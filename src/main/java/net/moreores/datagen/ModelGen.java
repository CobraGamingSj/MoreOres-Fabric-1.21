package net.moreores.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.moreores.block.ModBlocks;
import net.moreores.block.PineappleCropBlock;
import net.moreores.block.TomatoCropBlock;
import net.moreores.item.ModItems;

public class ModelGen extends FabricModelProvider {
    public ModelGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_RUBY_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_RADIANT_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_GREEN_SAPPHIRE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_BLUE_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_GREEN_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_TOPAZ_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_WHITE_TOPAZ_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_PYROPE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_JADE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_PERIDOT_ORE);

        blockStateModelGenerator.registerCrop(ModBlocks.TOMATO_CROP, TomatoCropBlock.AGE, 0, 1, 2, 3, 4, 5);
        blockStateModelGenerator.registerCrop(ModBlocks.PINEAPPLE_CROP, PineappleCropBlock.AGE, 0, 1, 2, 3, 4);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_RUBY_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_SAPPHIRE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_GREEN_SAPPHIRE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_BLUE_GARNET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PINK_GARNET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_GREEN_GARNET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_TOPAZ_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_WHITE_TOPAZ_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PERIDOT_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PYROPE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_JADE_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.MUSIC_DISC_DEEPER, Models.TEMPLATE_MUSIC_DISC);
        itemModelGenerator.register(ModItems.MUSIC_DISC_WATCHER, Models.TEMPLATE_MUSIC_DISC);
        itemModelGenerator.register(ModItems.RUBY_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_BOOTS, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.SAPPHIRE_BOOTS, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_SAPPHIRE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_GREEN_SAPPHIRE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_BLUE_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_GREEN_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_TOPAZ, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_WHITE_TOPAZ, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PERIDOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_JADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PYROPE, Models.GENERATED);
    }
}
