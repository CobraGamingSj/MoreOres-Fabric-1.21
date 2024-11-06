package net.cobra.moreores.item;

import net.cobra.moreores.MoreOres;
import net.cobra.moreores.block.ModBlocks;
import net.cobra.moreores.block.jukebox.ModJukeboxSongs;
import net.cobra.moreores.component.type.ModConsumableComponents;
import net.cobra.moreores.trim.ModArmorTrimPatterns;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.equipment.trim.ArmorTrimPatterns;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import java.util.List;

public class ModItems {


    //Seeds
    public static final Item TOMATO_SEEDS = register("tomato_seeds", createBlockItemWithUniqueName(ModBlocks.TOMATO_CROP));
    public static final Item PINEAPPLE_SEEDS = register("pineapple_seeds", createBlockItemWithUniqueName(ModBlocks.PINEAPPLE_CROP));


    //Foods
    public static final Item PINEAPPLE = register("pineapple", new Item(new Item.Settings().food(ModFoods.PINEAPPLE, ModConsumableComponents.PINEAPPLE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "pineapple")))));
    public static final Item TOMATO = register("tomato", new Item(new Item.Settings().food(ModFoods.TOMATO).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "tomato")))));
    public static final Item DIAMOND_APPLE = register("diamond_apple", new Item(new Item.Settings().food(ModFoods.DIAMOND_APPLE, ModConsumableComponents.DIAMOND_APPLE).rarity(Rarity.EPIC).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "diamond_apple")))));


    //Gemstones & Ingots
    public static final Item RUBY = register("ruby", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "ruby")))) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_RUBY = register("raw_ruby", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "raw_ruby")))));
    public static final Item RADIANT = register("radiant", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "radiant")))) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item SAPPHIRE = register("sapphire", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "sapphire")))) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_SAPPHIRE = register("raw_sapphire", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "raw_sapphire")))));
    public static final Item GREEN_SAPPHIRE = register("green_sapphire", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "green_sapphire")))) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_GREEN_SAPPHIRE = register("raw_green_sapphire", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "raw_green_sapphire")))));
    public static final Item PINK_GARNET = register("pink_garnet", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "pink_garnet")))) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_PINK_GARNET = register("raw_pink_garnet", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "raw_pink_garnet")))));
    public static final Item BLUE_GARNET = register("blue_garnet", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "blue_garnet")))) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_BLUE_GARNET = register("raw_blue_garnet", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "raw_blue_garnet")))));
    public static final Item GREEN_GARNET = register("green_garnet", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "green_garnet")))) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_GREEN_GARNET = register("raw_green_garnet", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "raw_green_garnet")))));
    public static final Item TOPAZ = register("topaz", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "topaz")))) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_TOPAZ = register("raw_topaz", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "raw_topaz")))));
    public static final Item PERIDOT = register("peridot", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "peridot")))) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_PERIDOT = register("raw_peridot", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "raw_peridot")))));
    public static final Item WHITE_TOPAZ = register("white_topaz", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "white_topaz")))) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_WHITE_TOPAZ = register("raw_white_topaz", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "raw_white_topaz")))));
    public static final Item PYROPE = register("pyrope", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "pyrope")))) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_PYROPE = register("raw_pyrope",new Item(new Item.Settings().fireproof().rarity(Rarity.RARE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "pyrope")))));
    public static final Item JADE = register("jade", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "jade")))) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_JADE = register("raw_jade", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "raw_jade")))));
    public static final Item ENERGY_INGOT = register("energy_ingot", new EnergyIngotItem(new Item.Settings().fireproof().rarity(Rarity.RARE).maxDamage(512).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "energy_ingot")))));


    //Fuel
    public static final Item WOOD_PELLET = register("wood_pellet", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "wood_pellet")))));


    //Music Discs
    public static final Item MUSIC_DISC_TASWELL = register("music_disc_taswell", new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.TASWELL).rarity(Rarity.RARE).maxCount(1).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "music_disc_taswell")))));
    public static final Item MUSIC_DISC_DREITON = register("music_disc_dreiton", new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.DREITON).rarity(Rarity.RARE).maxCount(1).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "music_disc_dreiton")))));
    public static final Item MUSIC_DISC_BIOME_FEST = register("music_disc_biome_fest", new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.BIOME_FEST).rarity(Rarity.RARE).maxCount(1).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "music_disc_biome_fest")))));
    public static final Item MUSIC_DISC_ARIA_MATH = register("music_disc_aria_math", new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.ARIA_MATH).rarity(Rarity.RARE).maxCount(1).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "music_disc_aria_math")))));
    public static final Item MUSIC_DISC_INFINITE_AMETHYST = register("music_disc_infinite_amethyst", new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.INFINITE_AMETHYST).rarity(Rarity.RARE).maxCount(1).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "music_disc_infinite_amethyst")))));
    public static final Item MUSIC_DISC_ENDLESS = register("music_disc_endless", new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.ENDLESS).rarity(Rarity.RARE).maxCount(1).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "music_disc_endless")))));
    public static final Item MUSIC_DISC_FEATHERFALL = register("music_disc_featherfall", new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.FEATHERFALL).rarity(Rarity.RARE).maxCount(1).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "music_disc_featherfall")))));
    public static final Item MUSIC_DISC_DEEPER = register("music_disc_deeper", new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.DEEPER).rarity(Rarity.RARE).maxCount(1).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "music_disc_deeper")))));
    public static final Item MUSIC_DISC_WATCHER = register("music_disc_watcher", new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.WATCHER).rarity(Rarity.RARE).maxCount(1).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "music_disc_watcher")))));


    //  Ruby Tools & Weapons
    public static final Item RUBY_SWORD = register("ruby_sword", new SwordItem(ModToolMaterials.RUBY, 6, -2.1f, new Item.Settings().fireproof().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "ruby_sword")))));
    public static final Item RUBY_PICKAXE = register("ruby_pickaxe", new PickaxeItem(ModToolMaterials.RUBY,  2, -3.0f, new Item.Settings().fireproof().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "ruby_pickaxe")))));
    public static final Item RUBY_SHOVEL = register("ruby_shovel", new ShovelItem(ModToolMaterials.RUBY,  2.5F, -3.0F, new Item.Settings().fireproof().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "ruby_shovel")))));
    public static final Item RUBY_AXE = register("ruby_axe", new AxeItem(ModToolMaterials.RUBY,  6.0F, -2.1F, new Item.Settings().fireproof().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "ruby_axe")))));
    public static final Item RUBY_HOE = register("ruby_hoe", new HoeItem(ModToolMaterials.RUBY,  -5.0F, 0.0F, new Item.Settings().fireproof().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "ruby_hoe")))));


    //Ruby Armor
    public static final Item RUBY_HELMET = register(
            "ruby_helmet",
            new ArmorItem(ModArmorMaterials.RUBY, EquipmentType.HELMET, new Item.Settings().fireproof().maxDamage(37).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "ruby_helmet"))))
    );
    public static final Item RUBY_CHESTPLATE = register(
            "ruby_chestplate",
            new ArmorItem(ModArmorMaterials.RUBY, EquipmentType.CHESTPLATE, new Item.Settings().fireproof().maxDamage(37).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "ruby_chestplate"))))
    );
    public static final Item RUBY_LEGGINGS = register(
            "ruby_leggings",
            new ArmorItem(ModArmorMaterials.RUBY, EquipmentType.LEGGINGS, new Item.Settings().fireproof().maxDamage(37).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "ruby_leggings"))))
    );
    public static final Item RUBY_BOOTS = register(
            "ruby_boots",
            new ArmorItem(ModArmorMaterials.RUBY, EquipmentType.BOOTS, new Item.Settings().fireproof().maxDamage(37).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "ruby_boots"))))
    );


    // Sapphire Armor
    public static final Item SAPPHIRE_HELMET = register(
            "sapphire_helmet",
            new ArmorItem(ModArmorMaterials.SAPPHIRE, EquipmentType.HELMET, new Item.Settings().fireproof().maxDamage(38).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "sapphire_helmet"))))
    );
    public static final Item SAPPHIRE_CHESTPLATE = register(
            "sapphire_chestplate",
            new ArmorItem(ModArmorMaterials.SAPPHIRE, EquipmentType.CHESTPLATE, new Item.Settings().fireproof().maxDamage(38).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "sapphire_chestplate"))))
    );
    public static final Item SAPPHIRE_LEGGINGS = register(
            "sapphire_leggings",
            new ArmorItem(ModArmorMaterials.SAPPHIRE, EquipmentType.LEGGINGS, new Item.Settings().fireproof().maxDamage(38).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "sapphire_leggings"))))
    );
    public static final Item SAPPHIRE_BOOTS = register(
            "sapphire_boots",
            new ArmorItem(ModArmorMaterials.SAPPHIRE, EquipmentType.BOOTS, new Item.Settings().fireproof().maxDamage(38).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "sapphire_boots"))))
    );


    //    Sapphire Tools & Weapons
    public static final Item SAPPHIRE_SWORD = register("sapphire_sword", new SwordItem(ModToolMaterials.SAPPHIRE,  8, -2.0f, new Item.Settings().fireproof().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "sapphire_sword")))));
    public static final Item SAPPHIRE_PICKAXE = register("sapphire_pickaxe", new PickaxeItem(ModToolMaterials.SAPPHIRE,  4, -3.0f, new Item.Settings().fireproof().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "sapphire_pickaxe")))));
    public static final Item SAPPHIRE_AXE = register("sapphire_axe", new AxeItem(ModToolMaterials.SAPPHIRE,  8, -2.0f, new Item.Settings().fireproof().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "sapphire_axe")))));
    public static final Item SAPPHIRE_HOE = register("sapphire_hoe", new HoeItem(ModToolMaterials.SAPPHIRE,  4, -3.0f, new Item.Settings().fireproof().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "sapphire_hoe")))));
    public static final Item SAPPHIRE_SHOVEL = register("sapphire_shovel", new ShovelItem(ModToolMaterials.SAPPHIRE,  3.5F, -3.0F, new Item.Settings().fireproof().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "sapphire_shovel")))));


    //    Radiant Tools & Weapons
    public static final Item RADIANT_SWORD = register("radiant_sword", new SwordItem(ModToolMaterials.RADIANT,  32, -1.0f, new Item.Settings().fireproof().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "radiant_sword")))));


    //    Smithing
    public static final Item RUBY_UPGRADE_SMITHING_TEMPLATE = register("ruby_upgrade_smithing_template", RubyUpgradeSmithingTemplate.createRubyUpgrade(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "ruby_upgrade_smithing_template")))));
    public static final Item GUARDIAN_ARMOR_TRIM_SMITHING_TEMPLATE = register("guardian_armor_trim_smithing_template",
            SmithingTemplateItem.of(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoreOres.MOD_ID, "guardian_armor_trim_smithing_template")))));

    private static Item createBlockItemWithUniqueName(Block block) {
        return new BlockItem(block, new Item.Settings().useItemPrefixedTranslationKey());
    }

    public static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MoreOres.MOD_ID, id), item);
    }

    public static void register() {
        MoreOres.LOGGER.info("Loading ModItems for " + MoreOres.MOD_ID + " mod.");
    }

}