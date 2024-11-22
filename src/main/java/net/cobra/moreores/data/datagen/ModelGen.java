package net.cobra.moreores.data.datagen;

import net.cobra.moreores.block.ModBlocks;
import net.cobra.moreores.block.PineappleCropBlock;
import net.cobra.moreores.block.TomatoCropBlock;
import net.cobra.moreores.item.ModItems;
import net.cobra.moreores.item.equipment.ModEquipmentModels;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.equipment.EquipmentModel;

public class ModelGen extends FabricModelProvider {
    public ModelGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_RUBY_ORE);
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

        itemModelGenerator.register(ModItems.GUARDIAN_ARMOR_TRIM_SMITHING_TEMPLATE, Models.GENERATED);

        itemModelGenerator.registerArmor((ModItems.RUBY_CHESTPLATE), ModEquipmentModels.RUBY, EquipmentModel.builder().addHumanoidLayers(ModEquipmentModels.RUBY).build(), EquipmentSlot.CHEST);
        itemModelGenerator.registerArmor(ModItems.RUBY_HELMET, ModEquipmentModels.RUBY, EquipmentModel.builder().addHumanoidLayers(ModEquipmentModels.RUBY).build(), EquipmentSlot.HEAD);
        itemModelGenerator.registerArmor(ModItems.RUBY_LEGGINGS, ModEquipmentModels.RUBY, EquipmentModel.builder().addHumanoidLayers(ModEquipmentModels.RUBY).build(), EquipmentSlot.LEGS);
        itemModelGenerator.registerArmor(ModItems.RUBY_BOOTS, ModEquipmentModels.RUBY, EquipmentModel.builder().addHumanoidLayers(ModEquipmentModels.RUBY).build(), EquipmentSlot.FEET);
        itemModelGenerator.registerArmor((ModItems.SAPPHIRE_CHESTPLATE), ModEquipmentModels.SAPPHIRE, EquipmentModel.builder().addHumanoidLayers(ModEquipmentModels.SAPPHIRE).build(), EquipmentSlot.CHEST);
        itemModelGenerator.registerArmor(ModItems.SAPPHIRE_HELMET, ModEquipmentModels.SAPPHIRE, EquipmentModel.builder().addHumanoidLayers(ModEquipmentModels.SAPPHIRE).build(), EquipmentSlot.HEAD);
        itemModelGenerator.registerArmor(ModItems.SAPPHIRE_LEGGINGS, ModEquipmentModels.SAPPHIRE, EquipmentModel.builder().addHumanoidLayers(ModEquipmentModels.SAPPHIRE).build(), EquipmentSlot.LEGS);
        itemModelGenerator.registerArmor(ModItems.SAPPHIRE_BOOTS, ModEquipmentModels.SAPPHIRE, EquipmentModel.builder().addHumanoidLayers(ModEquipmentModels.SAPPHIRE).build(), EquipmentSlot.FEET);
    }
}
