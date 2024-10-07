package net.moreores.item;

import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.moreores.MoreOres;
import net.moreores.block.ModBlocks;
import net.moreores.block.jukebox.ModJukeboxSongs;
import net.moreores.registry.ModRegistry;
import net.moreores.trim.ModArmorTrimPatterns;

import java.util.List;

public class ModItems {
//    public static final Item CUSTOM_BUCKET = Registry.register(Registries.ITEM , Identifier.of("moreores", "custom_bucket"), new BucketItem(Fluids.WATER, new Item.Settings()));

    //Seeds
    public static final Item TOMATO_SEEDS = ModRegistry.ItemRegistry.register("tomato_seeds", new AliasedBlockItem(ModBlocks.TOMATO_CROP, new Item.Settings()));
    public static final Item PINEAPPLE_SEEDS = ModRegistry.ItemRegistry.register("pineapple_seeds", new AliasedBlockItem(ModBlocks.PINEAPPLE_CROP, new Item.Settings()));


    //Foods
    public static final Item PINEAPPLE = ModRegistry.ItemRegistry.register("pineapple", new Item(new Item.Settings().food(ModFoods.PINEAPPLE)));
    public static final Item TOMATO = ModRegistry.ItemRegistry.register("tomato", new Item(new Item.Settings().food(ModFoods.TOMATO)));
    public static final Item DIAMOND_APPLE = ModRegistry.ItemRegistry.register("diamond_apple", new Item(new Item.Settings().food(ModFoods.DIAMOND_APPLE).rarity(Rarity.EPIC)));


    //Gemstones & Ingots
    public static final Item RUBY = ModRegistry.ItemRegistry.register("ruby", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_RUBY = ModRegistry.ItemRegistry.register("raw_ruby", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));
    public static final Item RADIANT = ModRegistry.ItemRegistry.register("radiant", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item SAPPHIRE = ModRegistry.ItemRegistry.register("sapphire", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_SAPPHIRE = ModRegistry.ItemRegistry.register("raw_sapphire", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));
    public static final Item GREEN_SAPPHIRE = ModRegistry.ItemRegistry.register("green_sapphire", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_GREEN_SAPPHIRE = ModRegistry.ItemRegistry.register("raw_green_sapphire", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));
    public static final Item PINK_GARNET = ModRegistry.ItemRegistry.register("pink_garnet", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_PINK_GARNET = ModRegistry.ItemRegistry.register("raw_pink_garnet", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));
    public static final Item BLUE_GARNET = ModRegistry.ItemRegistry.register("blue_garnet", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_BLUE_GARNET = ModRegistry.ItemRegistry.register("raw_blue_garnet", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));
    public static final Item GREEN_GARNET = ModRegistry.ItemRegistry.register("green_garnet", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_GREEN_GARNET = ModRegistry.ItemRegistry.register("raw_green_garnet", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));
    public static final Item TOPAZ = ModRegistry.ItemRegistry.register("topaz", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_TOPAZ = ModRegistry.ItemRegistry.register("raw_topaz", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));
    public static final Item PERIDOT = ModRegistry.ItemRegistry.register("peridot", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_PERIDOT = ModRegistry.ItemRegistry.register("raw_peridot", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));
    public static final Item WHITE_TOPAZ = ModRegistry.ItemRegistry.register("white_topaz", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_WHITE_TOPAZ = ModRegistry.ItemRegistry.register("raw_white_topaz", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));
    public static final Item PYROPE = ModRegistry.ItemRegistry.register("pyrope", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_PYROPE = ModRegistry.ItemRegistry.register("raw_pyrope", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));
    public static final Item JADE = ModRegistry.ItemRegistry.register("jade", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_JADE = ModRegistry.ItemRegistry.register("raw_jade", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));
    public static final Item ENERGY_INGOT = ModRegistry.ItemRegistry.register("energy_ingot", new EnergyIngotItem(new Item.Settings().fireproof().rarity(Rarity.RARE).maxDamage(512)));


    //Fuel
    public static final Item WOOD_PELLET = ModRegistry.ItemRegistry.register("wood_pellet", new Item(new Item.Settings()));


    //Music Discs
    public static final Item MUSIC_DISC_TASWELL = ModRegistry.ItemRegistry.register("music_disc_taswell", new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.TASWELL).rarity(Rarity.RARE).maxCount(1)));
    public static final Item MUSIC_DISC_DREITON = ModRegistry.ItemRegistry.register("music_disc_dreiton", new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.DREITON).rarity(Rarity.RARE).maxCount(1)));
    public static final Item MUSIC_DISC_BIOME_FEST = ModRegistry.ItemRegistry.register("music_disc_biome_fest", new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.BIOME_FEST).rarity(Rarity.RARE).maxCount(1)));
    public static final Item MUSIC_DISC_ARIA_MATH = ModRegistry.ItemRegistry.register("music_disc_aria_math", new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.ARIA_MATH).rarity(Rarity.RARE).maxCount(1)));
    public static final Item MUSIC_DISC_INFINITE_AMETHYST = ModRegistry.ItemRegistry.register("music_disc_infinite_amethyst", new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.INFINITE_AMETHYST).rarity(Rarity.RARE).maxCount(1)));
    public static final Item MUSIC_DISC_ENDLESS = ModRegistry.ItemRegistry.register("music_disc_endless", new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.ENDLESS).rarity(Rarity.RARE).maxCount(1)));
    public static final Item MUSIC_DISC_FEATHERFALL = ModRegistry.ItemRegistry.register("music_disc_featherfall", new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.FEATHERFALL).rarity(Rarity.RARE).maxCount(1)));
    public static final Item MUSIC_DISC_DEEPER = ModRegistry.ItemRegistry.register("music_disc_deeper", new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.DEEPER).rarity(Rarity.RARE).maxCount(1)));
    public static final Item MUSIC_DISC_WATCHER = ModRegistry.ItemRegistry.register("music_disc_watcher", new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.WATCHER).rarity(Rarity.RARE).maxCount(1)));
//    public static final Item DISC = ModRegistry.ItemRegistry.register("disc", new MusicDiscItem(new Item.Settings(), ModJukeboxSongs.ARIA_MATH));


    //  Ruby Tools & Weapons
    public static final Item RUBY_SWORD = ModRegistry.ItemRegistry.register("ruby_sword", new SwordItem(ModToolMaterials.RUBY, new Item.Settings().fireproof().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RUBY, 6, -2.1f))));
    public static final Item RUBY_PICKAXE = ModRegistry.ItemRegistry.register("ruby_pickaxe", new PickaxeItem(ModToolMaterials.RUBY, new Item.Settings().fireproof().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.RUBY, 2, -3.0f))));
    public static final Item RUBY_SHOVEL = ModRegistry.ItemRegistry.register("ruby_shovel", new ShovelItem(ModToolMaterials.RUBY, new Item.Settings().fireproof().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.RUBY, 2.5F, -3.0F))));
    public static final Item RUBY_AXE = ModRegistry.ItemRegistry.register("ruby_axe", new AxeItem(ModToolMaterials.RUBY, new Item.Settings().fireproof().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.RUBY, 6.0F, -2.1F))));
    public static final Item RUBY_HOE = ModRegistry.ItemRegistry.register("ruby_hoe", new HoeItem(ModToolMaterials.RUBY, new Item.Settings().fireproof().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.RUBY, -5.0F, 0.0F))));


    //Ruby Armor
    public static final Item RUBY_HELMET = ModRegistry.ItemRegistry.register(
            "ruby_helmet",
            new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(37)))
    );
    public static final Item RUBY_CHESTPLATE = ModRegistry.ItemRegistry.register(
            "ruby_chestplate",
            new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(37)))
    );
    public static final Item RUBY_LEGGINGS = ModRegistry.ItemRegistry.register(
            "ruby_leggings",
            new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(37)))
    );
    public static final Item RUBY_BOOTS = ModRegistry.ItemRegistry.register(
            "ruby_boots",
            new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(37)))
    );


    // Sapphire Armor
    public static final Item SAPPHIRE_HELMET = ModRegistry.ItemRegistry.register(
            "sapphire_helmet",
            new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.HELMET, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(38)))
    );
    public static final Item SAPPHIRE_CHESTPLATE = ModRegistry.ItemRegistry.register(
            "sapphire_chestplate",
            new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(38)))
    );
    public static final Item SAPPHIRE_LEGGINGS = ModRegistry.ItemRegistry.register(
            "sapphire_leggings",
            new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(38)))
    );
    public static final Item SAPPHIRE_BOOTS = ModRegistry.ItemRegistry.register(
            "sapphire_boots",
            new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.BOOTS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(38)))
    );


    // Green Garnet Armor
    public static final Item GREEN_GARNET_HELMET = ModRegistry.ItemRegistry.register(
            "green_garnet_helmet",
            new ArmorItem(ModArmorMaterials.GREEN_GARNET, ArmorItem.Type.HELMET, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(39)))
    );
    public static final Item GREEN_GARNET_CHESTPLATE = ModRegistry.ItemRegistry.register(
            "green_garnet_chestplate",
            new ArmorItem(ModArmorMaterials.GREEN_GARNET, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(39)))
    );
    public static final Item GREEN_GARNET_LEGGINGS = ModRegistry.ItemRegistry.register(
            "green_garnet_leggings",
            new ArmorItem(ModArmorMaterials.GREEN_GARNET, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(39)))
    );
    public static final Item GREEN_GARNET_BOOTS = ModRegistry.ItemRegistry.register(
            "green_garnet_boots",
            new ArmorItem(ModArmorMaterials.GREEN_GARNET, ArmorItem.Type.BOOTS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(39)))
    );


    //    Sapphire Tools & Weapons
    public static final Item SAPPHIRE_SWORD = ModRegistry.ItemRegistry.register("sapphire_sword", new SwordItem(ModToolMaterials.SAPPHIRE, new Item.Settings().fireproof().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, 8, -2.0f))));
    public static final Item SAPPHIRE_PICKAXE = ModRegistry.ItemRegistry.register("sapphire_pickaxe", new PickaxeItem(ModToolMaterials.SAPPHIRE, new Item.Settings().fireproof().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, 4, -3.0f))));
    public static final Item SAPPHIRE_AXE = ModRegistry.ItemRegistry.register("sapphire_axe", new AxeItem(ModToolMaterials.SAPPHIRE, new Item.Settings().fireproof().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, 8, -2.0f))));
    public static final Item SAPPHIRE_HOE = ModRegistry.ItemRegistry.register("sapphire_hoe", new HoeItem(ModToolMaterials.SAPPHIRE, new Item.Settings().fireproof().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, 4, -3.0f))));
    public static final Item SAPPHIRE_SHOVEL = ModRegistry.ItemRegistry.register("sapphire_shovel", new ShovelItem(ModToolMaterials.SAPPHIRE, new Item.Settings().fireproof().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, 3.5F, -3.0F))));


    //    Radiant Tools & Weapons
    public static final Item RADIANT_SWORD = ModRegistry.ItemRegistry.register("radiant_sword", new SwordItem(ModToolMaterials.RADIANT, new Item.Settings().rarity(Rarity.EPIC).fireproof().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RADIANT, 32, -1.0f))));


    //    Smithing
    public static final Item RUBY_UPGRADE_SMITHING_TEMPLATE = ModRegistry.ItemRegistry.register("ruby_upgrade_smithing_template", RubyUpgradeSmithingTemplate.createRubyUpgrade());
    public static final Item GUARDIAN_ARMOR_TRIM_SMITHING_TEMPLATE = ModRegistry.ItemRegistry.register("guardian_armor_trim",
            SmithingTemplateItem.of(ModArmorTrimPatterns.GUARDIAN, FeatureFlags.VANILLA));

    public static void register() {
        MoreOres.LOGGER.info("Loading ModItems for " + MoreOres.MOD_ID + " mod.");
    }

}