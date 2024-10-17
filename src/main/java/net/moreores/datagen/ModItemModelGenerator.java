//package net.moreores.datagen;
//
//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import net.minecraft.data.client.*;
//import net.minecraft.item.ArmorItem;
//import net.minecraft.item.ArmorMaterial;
//import net.minecraft.item.ArmorMaterials;
//import net.minecraft.registry.entry.RegistryEntry;
//import net.minecraft.util.Identifier;
//
//import java.util.List;
//import java.util.Map;
//import java.util.function.BiConsumer;
//import java.util.function.Supplier;
//
//public class ModItemModelGenerator {
//    public static final Identifier TRIM_TYPE = Identifier.ofVanilla("trim_type");
//    private static final List<TrimMaterial> TRIM_MATERIALS = List.of(
//            new TrimMaterial("quartz", 0.1F, Map.of()),
//            new TrimMaterial("iron", 0.2F, Map.of(ArmorMaterials.IRON, "iron_darker")),
//            new TrimMaterial("netherite", 0.3F, Map.of(ArmorMaterials.NETHERITE, "netherite_darker")),
//            new TrimMaterial("redstone", 0.4F, Map.of()),
//            new TrimMaterial("copper", 0.5F, Map.of()),
//            new TrimMaterial("gold", 0.6F, Map.of(ArmorMaterials.GOLD, "gold_darker")),
//            new TrimMaterial("emerald", 0.7F, Map.of()),
//            new TrimMaterial("diamond", 0.8F, Map.of(ArmorMaterials.DIAMOND, "diamond_darker")),
//            new TrimMaterial("lapis", 0.9F, Map.of()),
//            new TrimMaterial("amethyst", 1.0F, Map.of()),
//            new TrimMaterial("ruby", 1.1F, Map.of())
//            );
//    public final BiConsumer<Identifier, Supplier<JsonElement>> writer;
//
//    public ModItemModelGenerator(BiConsumer<Identifier, Supplier<JsonElement>> writer) {
//        this.writer = writer;
//    }
//
//    public final void uploadArmor(Identifier id, Identifier layer0, Identifier layer1) {
//        Models.GENERATED_TWO_LAYERS.upload(id, TextureMap.layered(layer0, layer1), this.writer);
//    }
//
//    public final void uploadArmor(Identifier id, Identifier layer0, Identifier layer1, Identifier layer2) {
//        Models.GENERATED_THREE_LAYERS.upload(id, TextureMap.layered(layer0, layer1, layer2), this.writer);
//    }
//
//    public final Identifier suffixTrim(Identifier id, String trimMaterialName) {
//        return id.withSuffixedPath("_" + trimMaterialName + "_trim");
//    }
//
//    public final JsonObject createArmorJson(Identifier id, Map<TextureKey, Identifier> textures, RegistryEntry<ArmorMaterial> armorMaterial) {
//        JsonObject jsonObject = Models.GENERATED_TWO_LAYERS.createJson(id, textures);
//        JsonArray jsonArray = new JsonArray();
//
//        for (TrimMaterial trimMaterial : TRIM_MATERIALS) {
//            JsonObject jsonObject2 = new JsonObject();
//            JsonObject jsonObject3 = new JsonObject();
//            jsonObject3.addProperty(TRIM_TYPE.getPath(), trimMaterial.itemModelIndex());
//            jsonObject2.add("predicate", jsonObject3);
//            jsonObject2.addProperty("model", this.suffixTrim(id, trimMaterial.getAppliedName(armorMaterial)).toString());
//            jsonArray.add(jsonObject2);
//        }
//
//        jsonObject.add("overrides", jsonArray);
//        return jsonObject;
//    }
//
//    public final void registerArmor(ArmorItem armor) {
//        if (armor.getType().isTrimmable()) {
//            Identifier identifier = ModelIds.getItemModelId(armor);
//            Identifier identifier2 = TextureMap.getId(armor);
//            Identifier identifier3 = TextureMap.getSubId(armor, "_overlay");
//            if (armor.getMaterial().matches(ArmorMaterials.LEATHER)) {
//                Models.GENERATED_TWO_LAYERS
//                        .upload(identifier, TextureMap.layered(identifier2, identifier3), this.writer, (id, textures) -> this.createArmorJson(id, textures, armor.getMaterial()));
//            } else {
//                Models.GENERATED.upload(identifier, TextureMap.layer0(identifier2), this.writer, (id, textures) -> this.createArmorJson(id, textures, armor.getMaterial()));
//            }
//
//            for (TrimMaterial trimMaterial : TRIM_MATERIALS) {
//                String string = trimMaterial.getAppliedName(armor.getMaterial());
//                Identifier identifier4 = this.suffixTrim(identifier, string);
//                String string2 = armor.getType().getName() + "_trim_" + string;
//                Identifier identifier5 = Identifier.ofVanilla(string2).withPrefixedPath("trims/items/");
//                if (armor.getMaterial().matches(ArmorMaterials.LEATHER)) {
//                    this.uploadArmor(identifier4, identifier2, identifier3, identifier5);
//                } else {
//                    this.uploadArmor(identifier4, identifier2, identifier5);
//                }
//            }
//        }
//    }
//
//    record TrimMaterial(String name, float itemModelIndex, Map<RegistryEntry<ArmorMaterial>, String> overrideArmorMaterials) {
//        public String getAppliedName(RegistryEntry<ArmorMaterial> armorMaterial) {
//            return (String)this.overrideArmorMaterials.getOrDefault(armorMaterial, this.name);
//        }
//    }
//}
