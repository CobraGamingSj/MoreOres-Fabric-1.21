package net.cobra.moreores.item;

import com.google.common.base.Suppliers;
import java.util.function.Supplier;
import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

public enum ModToolMaterials implements ToolMaterial
{
    RUBY(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2652, 14.0f, 8.0f, 15, () ->
            Ingredient.ofItems(ModItems.RUBY)),
    SAPPHIRE(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3021, 16f, 10.0f, 16, () ->
            Ingredient.ofItems(ModItems.SAPPHIRE)),
    GREEN_GARNET(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3723, 18f, 12.0f, 17, () ->
            Ingredient.ofItems(ModItems.GREEN_SAPPHIRE)),
    TOPAZ(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4609, 22.0f, 15.0f, 26, () ->
            Ingredient.ofItems(ModItems.TOPAZ)),
    RADIANT(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 5031, 25.0f, 72.0f, 30, () ->
            Ingredient.ofItems(ModItems.RADIANT)),
    AMETHYST(BlockTags.INCORRECT_FOR_IRON_TOOL, 301, 7.5f, 3.5f, 14, () ->
            Ingredient.ofItems(Items.AMETHYST_SHARD));

    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterials(TagKey<Block> inverseTag, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }


    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return (Ingredient) this.repairIngredient.get();
    }
}

