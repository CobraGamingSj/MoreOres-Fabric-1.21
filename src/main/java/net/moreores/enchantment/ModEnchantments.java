//package net.moreores.enchantment;
//
//import net.minecraft.block.Block;
//import net.minecraft.component.type.AttributeModifierSlot;
//import net.minecraft.enchantment.Enchantment;
//import net.minecraft.entity.damage.DamageType;
//import net.minecraft.item.Item;
//import net.minecraft.registry.Registerable;
//import net.minecraft.registry.RegistryEntryLookup;
//import net.minecraft.registry.RegistryKey;
//import net.minecraft.registry.RegistryKeys;
//import net.minecraft.registry.tag.ItemTags;
//import net.minecraft.util.Identifier;
//import net.moreores.MoreOres;
//
//public class ModEnchantments {
//    public static final RegistryKey<Enchantment> THUNDER_STRIKER = of("thunder_striker");
//
//    public static void bootstrap(Registerable<Enchantment> context) {
//        RegistryEntryLookup<DamageType> registryEntryLookup = context.getRegistryLookup(RegistryKeys.DAMAGE_TYPE);
//        RegistryEntryLookup<Enchantment> registryEntryLookup2 = context.getRegistryLookup(RegistryKeys.ENCHANTMENT);
//        RegistryEntryLookup<Item> registryEntryLookup3 = context.getRegistryLookup(RegistryKeys.ITEM);
//        RegistryEntryLookup<Block> registryEntryLookup4 = context.getRegistryLookup(RegistryKeys.BLOCK);
//        register(context, THUNDER_STRIKER, Enchantment.builder(
//                Enchantment.definition(
//                        registryEntryLookup3.getOrThrow(ItemTags.TRIDENT_ENCHANTABLE),
//                        1,
//                        2,
//                        Enchantment.constantCost(25),
//                        Enchantment.constantCost(50),
//                        8,
//                        AttributeModifierSlot.MAINHAND
//                )
//        ));
//    }
//
//    private static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder) {
//        registry.register(key, builder.build(key.getValue()));
//    }
//
//    private static RegistryKey<Enchantment> of(String id) {
//        Identifier ID = Identifier.of(MoreOres.MOD_ID, id);
//        return RegistryKey.of(RegistryKeys.ENCHANTMENT, ID);
//    }
//
//}
