package net.cobra.moreores.data.datagen;

import net.cobra.moreores.item.ModItems;
import net.cobra.moreores.registry.ModItemTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ItemTagGen extends FabricTagProvider.ItemTagProvider {

    public ItemTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(ModItems.MUSIC_DISC_WATCHER)
                .add(ModItems.MUSIC_DISC_ENDLESS)
                .add(ModItems.MUSIC_DISC_DEEPER)
                .add(ModItems.MUSIC_DISC_DREITON)
                .add(ModItems.MUSIC_DISC_TASWELL)
                .add(ModItems.MUSIC_DISC_ARIA_MATH)
                .add(ModItems.MUSIC_DISC_BIOME_FEST)
                .add(ModItems.MUSIC_DISC_FEATHERFALL)
                .add(ModItems.MUSIC_DISC_INFINITE_AMETHYST);

        getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModItems.RUBY)
                .add(ModItems.RADIANT)
                .add(ModItems.SAPPHIRE)
                .add(ModItems.GREEN_SAPPHIRE)
                .add(ModItems.BLUE_GARNET)
                .add(ModItems.PINK_GARNET)
                .add(ModItems.GREEN_GARNET)
                .add(ModItems.TOPAZ)
                .add(ModItems.WHITE_TOPAZ)
                .add(ModItems.PERIDOT)
                .add(ModItems.JADE)
                .add(ModItems.PYROPE);

        getOrCreateTagBuilder(ItemTags.VILLAGER_PLANTABLE_SEEDS)
                .add(ModItems.TOMATO_SEEDS)
                .add(ModItems.PINEAPPLE_SEEDS);

        getOrCreateTagBuilder(ModItemTags.ARCSHAPERS);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.RUBY_SWORD)
                .add(ModItems.SAPPHIRE_SWORD)
                .add(ModItems.RADIANT_SWORD);

        getOrCreateTagBuilder(ItemTags.FIRE_ASPECT_ENCHANTABLE)
                .forceAddTag(ItemTags.SWORD_ENCHANTABLE);

        getOrCreateTagBuilder(ItemTags.SWORD_ENCHANTABLE)
                .forceAddTag(ItemTags.SWORDS);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.RUBY_PICKAXE)
                .add(ModItems.SAPPHIRE_PICKAXE);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.RUBY_AXE)
                .add(ModItems.SAPPHIRE_AXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.RUBY_SHOVEL)
                .add(ModItems.SAPPHIRE_SHOVEL);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.RUBY_HOE)
                .add(ModItems.SAPPHIRE_HOE);

        getOrCreateTagBuilder(ItemTags.EQUIPPABLE_ENCHANTABLE)
                .forceAddTag(ItemTags.HEAD_ARMOR)
                .forceAddTag(ItemTags.CHEST_ARMOR)
                .forceAddTag(ItemTags.LEG_ARMOR)
                .forceAddTag(ItemTags.FOOT_ARMOR);

        getOrCreateTagBuilder(ItemTags.MINING_ENCHANTABLE)
                .forceAddTag(ItemTags.PICKAXES)
                .forceAddTag(ItemTags.HOES)
                .forceAddTag(ItemTags.AXES)
                .forceAddTag(ItemTags.SHOVELS);

        getOrCreateTagBuilder(ItemTags.MINING_LOOT_ENCHANTABLE)
                .forceAddTag(ItemTags.PICKAXES)
                .forceAddTag(ItemTags.HOES)
                .forceAddTag(ItemTags.AXES)
                .forceAddTag(ItemTags.SHOVELS);

        getOrCreateTagBuilder(ItemTags.WEAPON_ENCHANTABLE)
                .forceAddTag(ItemTags.SHARP_WEAPON_ENCHANTABLE);

        getOrCreateTagBuilder(ItemTags.VANISHING_ENCHANTABLE)
                .forceAddTag(ItemTags.DURABILITY_ENCHANTABLE);

        getOrCreateTagBuilder(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .forceAddTag(ItemTags.SWORDS)
                .forceAddTag(ItemTags.AXES);

        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR)
                .add(ModItems.RUBY_BOOTS)
                .add(ModItems.SAPPHIRE_BOOTS);

        getOrCreateTagBuilder(ItemTags.LEG_ARMOR)
                .add(ModItems.RUBY_LEGGINGS)
                .add(ModItems.SAPPHIRE_LEGGINGS);

        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR)
                .add(ModItems.RUBY_HELMET)
                .add(ModItems.SAPPHIRE_HELMET);

        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR)
                .add(ModItems.RUBY_CHESTPLATE)
                .add(ModItems.SAPPHIRE_CHESTPLATE);

        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .forceAddTag(ItemTags.FOOT_ARMOR);

        getOrCreateTagBuilder(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .forceAddTag(ItemTags.LEG_ARMOR);

        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .forceAddTag(ItemTags.HEAD_ARMOR);

        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .forceAddTag(ItemTags.CHEST_ARMOR);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.RUBY_HELMET)
                .add(ModItems.RUBY_CHESTPLATE)
                .add(ModItems.RUBY_LEGGINGS)
                .add(ModItems.RUBY_BOOTS)
                .add(ModItems.SAPPHIRE_HELMET)
                .add(ModItems.SAPPHIRE_CHESTPLATE)
                .add(ModItems.SAPPHIRE_LEGGINGS)
                .add(ModItems.SAPPHIRE_BOOTS);

        getOrCreateTagBuilder(ItemTags.ARMOR_ENCHANTABLE)
                .forceAddTag(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .forceAddTag(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .forceAddTag(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .forceAddTag(ItemTags.FOOT_ARMOR_ENCHANTABLE);

        getOrCreateTagBuilder(ModItemTags.GEMSTONE)
                .add(ModItems.RUBY)
                .add(ModItems.RADIANT)
                .add(ModItems.SAPPHIRE)
                .add(ModItems.GREEN_SAPPHIRE)
                .add(ModItems.BLUE_GARNET)
                .add(ModItems.PINK_GARNET)
                .add(ModItems.GREEN_GARNET)
                .add(ModItems.TOPAZ)
                .add(ModItems.WHITE_TOPAZ)
                .add(ModItems.PERIDOT)
                .add(ModItems.JADE)
                .add(ModItems.PYROPE)
                .add(Items.LAPIS_LAZULI)
                .add(Items.QUARTZ)
                .add(Items.DIAMOND);

        getOrCreateTagBuilder(ModItemTags.RAW_GEMSTONE)
                .add(ModItems.RAW_RUBY)
                .add(ModItems.RAW_SAPPHIRE)
                .add(ModItems.RAW_GREEN_SAPPHIRE)
                .add(ModItems.RAW_BLUE_GARNET)
                .add(ModItems.RAW_PINK_GARNET)
                .add(ModItems.RAW_GREEN_GARNET)
                .add(ModItems.RAW_TOPAZ)
                .add(ModItems.RAW_WHITE_TOPAZ)
                .add(ModItems.RAW_PERIDOT)
                .add(ModItems.RAW_JADE)
                .add(ModItems.RAW_PYROPE);

        getOrCreateTagBuilder(ModItemTags.METAL)
                .add(Items.IRON_INGOT)
                .add(Items.COPPER_INGOT)
                .add(Items.GOLD_INGOT);

        getOrCreateTagBuilder(ModItemTags.RARE)
                .forceAddTag(ModItemTags.GEMSTONE)
                .forceAddTag(ModItemTags.METAL);

        getOrCreateTagBuilder(ModItemTags.JUKEBOX_PLAYABLE_DISCS)
                .add(ModItems.MUSIC_DISC_ARIA_MATH)
                .add(ModItems.MUSIC_DISC_DREITON)
                .add(ModItems.MUSIC_DISC_TASWELL)
                .add(ModItems.MUSIC_DISC_BIOME_FEST)
                .add(ModItems.MUSIC_DISC_FEATHERFALL)
                .add(ModItems.MUSIC_DISC_ENDLESS)
                .add(ModItems.MUSIC_DISC_INFINITE_AMETHYST)
                .add(ModItems.MUSIC_DISC_DEEPER)
                .add(ModItems.MUSIC_DISC_WATCHER);

        getOrCreateTagBuilder(ModItemTags.REPAIRS_RUBY_ARMOR)
                .add(ModItems.RUBY);

        getOrCreateTagBuilder(ModItemTags.REPAIRS_SAPPHIRE_ARMOR)
                .add(ModItems.SAPPHIRE);

        getOrCreateTagBuilder(ModItemTags.REPAIRS_RADIANT_ARMOR)
                .add(ModItems.RADIANT);

        getOrCreateTagBuilder(ModItemTags.RUBY_TOOL_MATERIALS)
                .add(ModItems.RUBY);

        getOrCreateTagBuilder(ModItemTags.SAPPHIRE_TOOL_MATERIALS)
                .add(ModItems.SAPPHIRE);

        getOrCreateTagBuilder(ModItemTags.RADIANT_TOOL_MATERIALS)
                .add(ModItems.RADIANT);
    }
}
