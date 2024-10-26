package net.cobra.moreores.item;

import net.cobra.moreores.MoreOres;
import net.cobra.moreores.block.ModBlocks;
import net.cobra.moreores.block.jukebox.ModJukeboxSongs;
import net.cobra.moreores.component.type.ModConsumableComponents;
import net.cobra.moreores.registry.ModRegistry;
import net.cobra.moreores.trim.ModArmorTrimPatterns;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;

import java.util.List;

import static net.cobra.moreores.registry.ModRegistry.ItemRegistry.registerItem;

public class ModItems {


    //Seeds
    public static final Item TOMATO_SEEDS = registerItem("tomato_seeds", new AliasedBlockItem(ModBlocks.TOMATO_CROP, new Item.Settings()));
    public static final Item PINEAPPLE_SEEDS = registerItem("pineapple_seeds", new AliasedBlockItem(ModBlocks.PINEAPPLE_CROP, new Item.Settings()));


    //Foods
    public static final Item PINEAPPLE = registerItem("pineapple", new Item(new Item.Settings().food(ModFoods.PINEAPPLE, ModConsumableComponents.PINEAPPLE)));
    public static final Item TOMATO = registerItem("tomato", new Item(new Item.Settings().food(ModFoods.TOMATO)));
    public static final Item DIAMOND_APPLE = registerItem("diamond_apple", new Item(new Item.Settings().food(ModFoods.DIAMOND_APPLE, ModConsumableComponents.DIAMOND_APPLE).rarity(Rarity.EPIC)));


    //Gemstones & Ingots
    public static final Item RUBY = registerItem("ruby", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));
    public static final Item RADIANT = registerItem("radiant", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item SAPPHIRE = registerItem("sapphire", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_SAPPHIRE = registerItem("raw_sapphire", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));
    public static final Item GREEN_SAPPHIRE = registerItem("green_sapphire", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_GREEN_SAPPHIRE = registerItem("raw_green_sapphire", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));
    public static final Item BLUE_GARNET = registerItem("blue_garnet", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_BLUE_GARNET = registerItem("raw_blue_garnet", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));
    public static final Item GREEN_GARNET = registerItem("green_garnet", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_GREEN_GARNET = registerItem("raw_green_garnet", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));
    public static final Item TOPAZ = registerItem("topaz", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_TOPAZ = registerItem("raw_topaz", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));
    public static final Item PERIDOT = registerItem("peridot", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_PERIDOT = registerItem("raw_peridot", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));
    public static final Item WHITE_TOPAZ = registerItem("white_topaz", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_WHITE_TOPAZ = registerItem("raw_white_topaz", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));
    public static final Item PYROPE = registerItem("pyrope", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_PYROPE = registerItem("raw_pyrope", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));
    public static final Item JADE = registerItem("jade", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("moreores.tooltip.gem").formatted(Formatting.BLUE));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item RAW_JADE = registerItem("raw_jade", new Item(new Item.Settings().fireproof().rarity(Rarity.RARE)));
    public static final Item ENERGY_INGOT = registerItem("energy_ingot", new EnergyIngotItem(new Item.Settings().fireproof().rarity(Rarity.RARE).maxDamage(512)));


    //Fuel
    public static final Item WOOD_PELLET = registerItem("wood_pellet", new Item(new Item.Settings()));


    //Music Discs
    public static final Item MUSIC_DISC_TASWELL = registerItem("music_disc_taswell", new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.TASWELL).rarity(Rarity.RARE).maxCount(1)));
    public static final Item MUSIC_DISC_DREITON = registerItem("music_disc_dreiton", new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.DREITON).rarity(Rarity.RARE).maxCount(1)));
    public static final Item MUSIC_DISC_BIOME_FEST = registerItem("music_disc_biome_fest", new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.BIOME_FEST).rarity(Rarity.RARE).maxCount(1)));
    public static final Item MUSIC_DISC_ARIA_MATH = registerItem("music_disc_aria_math", new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.ARIA_MATH).rarity(Rarity.RARE).maxCount(1)));
    public static final Item MUSIC_DISC_INFINITE_AMETHYST = registerItem("music_disc_infinite_amethyst", new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.INFINITE_AMETHYST).rarity(Rarity.RARE).maxCount(1)));
    public static final Item MUSIC_DISC_ENDLESS = registerItem("music_disc_endless", new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.ENDLESS).rarity(Rarity.RARE).maxCount(1)));
    public static final Item MUSIC_DISC_FEATHERFALL = registerItem("music_disc_featherfall", new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.FEATHERFALL).rarity(Rarity.RARE).maxCount(1)));
    public static final Item MUSIC_DISC_DEEPER = registerItem("music_disc_deeper", new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.DEEPER).rarity(Rarity.RARE).maxCount(1)));
    public static final Item MUSIC_DISC_WATCHER = registerItem("music_disc_watcher", new Item(new Item.Settings().jukeboxPlayable(ModJukeboxSongs.WATCHER).rarity(Rarity.RARE).maxCount(1)));
//    public static final Item DISC = ModRegistry.ItemRegistry.register("disc", new MusicDiscItem(new Item.Settings(), ModJukeboxSongs.ARIA_MATH));


    //  Ruby Tools & Weapons
    public static final Item RUBY_SWORD = registerItem("ruby_sword", new SwordItem(ModToolMaterials.RUBY, new Item.Settings().fireproof().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RUBY, 6, -2.1f))));
    public static final Item RUBY_PICKAXE = registerItem("ruby_pickaxe", new PickaxeItem(ModToolMaterials.RUBY, new Item.Settings().fireproof().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.RUBY, 2, -3.0f))));
    public static final Item RUBY_SHOVEL = registerItem("ruby_shovel", new ShovelItem(ModToolMaterials.RUBY, new Item.Settings().fireproof().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.RUBY, 2.5F, -3.0F))));
    public static final Item RUBY_AXE = registerItem("ruby_axe", new AxeItem(ModToolMaterials.RUBY, new Item.Settings().fireproof().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.RUBY, 6.0F, -2.1F))));
    public static final Item RUBY_HOE = registerItem("ruby_hoe", new HoeItem(ModToolMaterials.RUBY, new Item.Settings().fireproof().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.RUBY, -5.0F, 0.0F))));


    //Ruby Armor
    public static final Item RUBY_HELMET = registerItem(
            "ruby_helmet",
            settings -> new ArmorItem(ModArmorMaterials.RUBY, EquipmentType.HELMET, new Item.Settings()));
    public static final Item RUBY_CHESTPLATE = registerItem(
            "ruby_chestplate",
            new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(37)))
    );
    public static final Item RUBY_LEGGINGS = registerItem(
            "ruby_leggings",
            new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(37)))
    );
    public static final Item RUBY_BOOTS = registerItem(
            "ruby_boots",
            new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(37)))
    );


    // Sapphire Armor
    public static final Item SAPPHIRE_HELMET = registerItem(
            "sapphire_helmet",
            new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.HELMET, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(38)))
    );
    public static final Item SAPPHIRE_CHESTPLATE = registerItem(
            "sapphire_chestplate",
            new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(38)))
    );
    public static final Item SAPPHIRE_LEGGINGS = registerItem(
            "sapphire_leggings",
            new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(38)))
    );
    public static final Item SAPPHIRE_BOOTS = registerItem(
            "sapphire_boots",
            new ArmorItem(ModArmorMaterials.SAPPHIRE, ArmorItem.Type.BOOTS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(38)))
    );


    // Green Garnet Armor
    public static final Item GREEN_GARNET_HELMET = registerItem(
            "green_garnet_helmet",
            new ArmorItem(ModArmorMaterials.GREEN_GARNET, ArmorItem.Type.HELMET, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(39)))
    );
    public static final Item GREEN_GARNET_CHESTPLATE = registerItem(
            "green_garnet_chestplate",
            new ArmorItem(ModArmorMaterials.GREEN_GARNET, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(39)))
    );
    public static final Item GREEN_GARNET_LEGGINGS = registerItem(
            "green_garnet_leggings",
            new ArmorItem(ModArmorMaterials.GREEN_GARNET, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(39)))
    );
    public static final Item GREEN_GARNET_BOOTS = registerItem(
            "green_garnet_boots",
            new ArmorItem(ModArmorMaterials.GREEN_GARNET, ArmorItem.Type.BOOTS, new Item.Settings().fireproof().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(39)))
    );


    //    Sapphire Tools & Weapons
    public static final Item SAPPHIRE_SWORD = registerItem("sapphire_sword", new SwordItem(ModToolMaterials.SAPPHIRE, new Item.Settings().fireproof().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, 8, -2.0f))));
    public static final Item SAPPHIRE_PICKAXE = registerItem("sapphire_pickaxe", new PickaxeItem(ModToolMaterials.SAPPHIRE, new Item.Settings().fireproof().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, 4, -3.0f))));
    public static final Item SAPPHIRE_AXE = registerItem("sapphire_axe", new AxeItem(ModToolMaterials.SAPPHIRE, new Item.Settings().fireproof().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, 8, -2.0f))));
    public static final Item SAPPHIRE_HOE = registerItem("sapphire_hoe", new HoeItem(ModToolMaterials.SAPPHIRE, new Item.Settings().fireproof().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, 4, -3.0f))));
    public static final Item SAPPHIRE_SHOVEL = registerItem("sapphire_shovel", new ShovelItem(ModToolMaterials.SAPPHIRE, new Item.Settings().fireproof().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.SAPPHIRE, 3.5F, -3.0F))));


    //    Radiant Tools & Weapons
    public static final Item RADIANT_SWORD = registerItem("radiant_sword", new SwordItem(ModToolMaterials.RADIANT, new Item.Settings().rarity(Rarity.EPIC).fireproof().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.RADIANT, 32, -1.0f))));


    //    Smithing
    public static final Item RUBY_UPGRADE_SMITHING_TEMPLATE = registerItem("ruby_upgrade_smithing_template", RubyUpgradeSmithingTemplate.createRubyUpgrade());
    public static final Item GUARDIAN_ARMOR_TRIM_SMITHING_TEMPLATE = registerItem("guardian_armor_trim",
            SmithingTemplateItem::of(ModArmorTrimPatterns.GUARDIAN, FeatureFlags.VANILLA));

    public static void register() {
        MoreOres.LOGGER.info("Loading ModItems for " + MoreOres.MOD_ID + " mod.");
    }

}