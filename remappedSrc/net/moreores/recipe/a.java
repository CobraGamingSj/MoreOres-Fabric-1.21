package net.cobra.moreores.recipe;//package net.cobra.moreores.recipe;
//
//import com.google.common.base.Suppliers;
//import net.minecraft.block.Block;
//import net.minecraft.item.ToolMaterial;
//import net.minecraft.recipe.Ingredient;
//import net.minecraft.registry.tag.BlockTags;
//import net.minecraft.registry.tag.TagKey;
//import net.cobra.moreores.item.ModItems;
//
//import java.util.function.Supplier;
//public enum a implements ToolMaterial {
//    STEEL(BlockTags.INCORRECT_FOR_IRON_TOOL,
//            500, 7.0f, 8.0f, 12, ()
//            -> Ingredient.ofItems(ModItems.RUBY));
//    private final int itemDurability;
//    private final float miningSpeed;
//    private final float attackDamage;
//    private final int enchantability;
//    private final Supplier<Ingredient> repairIngredient;
//    private final TagKey<Block> inverseTag;
//
//    a(TagKey<Block> inverseTag, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
//        this.inverseTag = inverseTag;
//        this.itemDurability = itemDurability;
//        this.miningSpeed = miningSpeed;
//        this.attackDamage = attackDamage;
//        this.enchantability = enchantability;
//        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
//    }
//    public int getDurability() {
//        return this.itemDurability;
//    }
//    public float getMiningSpeedMultiplier() {
//        return this.miningSpeed;
//    }
//    public float getAttackDamage() {
//        return this.attackDamage;
//    }
//    public TagKey<Block> getInverseTag() {
//        return this.inverseTag;
//    }
//    public int getEnchantability() {
//        return this.enchantability;
//    }
//    public Ingredient getRepairIngredient() {
//        return (Ingredient)this.repairIngredient.get();
//    }
//}