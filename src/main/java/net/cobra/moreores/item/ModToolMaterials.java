package net.cobra.moreores.item;

import com.google.common.base.Suppliers;
import java.util.function.Supplier;

import net.cobra.moreores.registry.ModItemTags;
import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

public class ModToolMaterials{
    public static final ToolMaterial RUBY = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2652, 14.0f, 8.0f, 15, ModItemTags.RUBY_TOOL_MATERIALS);
    public static final ToolMaterial SAPPHIRE = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3021, 16f, 10.0f, 16, ModItemTags.SAPPHIRE_TOOL_MATERIALS);
//    GREEN_GARNET(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3723, 18f, 12.0f, 17, () ->
//            Ingredient.ofItems(ModItems.GREEN_SAPPHIRE)),
//    TOPAZ(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4609, 22.0f, 15.0f, 26, () ->
//            Ingredient.ofItems(ModItems.TOPAZ)),
    public static final ToolMaterial RADIANT = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 5031, 25.0f, 72.0f, 30, ModItemTags.RADIANT_TOOL_MATERIALS);
//    AMETHYST(BlockTags.INCORRECT_FOR_IRON_TOOL, 301, 7.5f, 3.5f, 14, () ->
//            Ingredient.ofItems(Items.AMETHYST_SHARD));

}

