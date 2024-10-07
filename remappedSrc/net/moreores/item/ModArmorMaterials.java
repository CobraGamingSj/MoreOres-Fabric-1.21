package net.moreores.item;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.moreores.MoreOres;

public class ModArmorMaterials {
    public static final RegistryEntry<ArmorMaterial> RUBY = register("ruby", Util.make(new EnumMap(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 5);
        map.put(ArmorItem.Type.LEGGINGS, 8);
        map.put(ArmorItem.Type.CHESTPLATE, 10);
        map.put(ArmorItem.Type.HELMET, 5);
        map.put(ArmorItem.Type.BODY, 13);
    }), 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.0F, 0.2F, () -> Ingredient.ofItems(ModItems.RUBY));
    public static final RegistryEntry<ArmorMaterial> SAPPHIRE = register("sapphire", Util.make(new EnumMap(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 7);
        map.put(ArmorItem.Type.LEGGINGS, 10);
        map.put(ArmorItem.Type.CHESTPLATE, 12);
        map.put(ArmorItem.Type.HELMET, 7);
        map.put(ArmorItem.Type.BODY, 15);
    }), 10, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, 4.5F, 0.3F, () -> Ingredient.ofItems(ModItems.SAPPHIRE));
    public static final RegistryEntry<ArmorMaterial> GREEN_GARNET = register("green_garnet", Util.make(new EnumMap(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 9);
        map.put(ArmorItem.Type.LEGGINGS, 12);
        map.put(ArmorItem.Type.CHESTPLATE, 14);
        map.put(ArmorItem.Type.HELMET, 9);
        map.put(ArmorItem.Type.BODY, 17);
    }), 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.55F, 0.35F, () -> Ingredient.ofItems(ModItems.GREEN_GARNET));
    public static final RegistryEntry<ArmorMaterial> TOPAZ = register("topaz", Util.make(new EnumMap(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 10);
        map.put(ArmorItem.Type.LEGGINGS, 13);
        map.put(ArmorItem.Type.CHESTPLATE, 15);
        map.put(ArmorItem.Type.HELMET, 10);
        map.put(ArmorItem.Type.BODY, 18);
    }), 17, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.75F, 0.375F, () -> Ingredient.ofItems(ModItems.TOPAZ));
    public static final RegistryEntry<ArmorMaterial> AMETHYST = register("amethyst", Util.make(new EnumMap(ArmorItem.Type.class), map -> {
        map.put(ArmorItem.Type.BOOTS, 3);
        map.put(ArmorItem.Type.LEGGINGS, 6);
        map.put(ArmorItem.Type.CHESTPLATE, 7);
        map.put(ArmorItem.Type.HELMET, 3);
        map.put(ArmorItem.Type.BODY, 6);
    }), 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F, 1.0F, () -> Ingredient.ofItems(Items.AMETHYST_SHARD));

    public static RegistryEntry<ArmorMaterial> getDefault(Registry<ArmorMaterial> registry) {
        return RUBY;
    }

    private static RegistryEntry<ArmorMaterial> register(
            String id,
            EnumMap<ArmorItem.Type, Integer> defense,
            int enchantability,
            RegistryEntry<SoundEvent> equipSound,
            float toughness,
            float knockbackResistance,
            Supplier<Ingredient> repairIngredient
    ) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(Identifier.of(MoreOres.MOD_ID, id)));
        return register(id, defense, enchantability, equipSound, toughness, knockbackResistance, repairIngredient, list);
    }

    private static RegistryEntry<ArmorMaterial> register(
            String id,
            EnumMap<ArmorItem.Type, Integer> defense,
            int enchantability,
            RegistryEntry<SoundEvent> equipSound,
            float toughness,
            float knockbackResistance,
            Supplier<Ingredient> repairIngredient,
            List<ArmorMaterial.Layer> layers
    ) {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap(ArmorItem.Type.class);

        for (ArmorItem.Type type : ArmorItem.Type.values()) {
            enumMap.put(type, (Integer)defense.get(type));
        }

        return Registry.registerReference(
                Registries.ARMOR_MATERIAL,
                Identifier.of(MoreOres.MOD_ID, id),
                new ArmorMaterial(enumMap, enchantability, equipSound, repairIngredient, layers, toughness, knockbackResistance)
        );
    }
}
