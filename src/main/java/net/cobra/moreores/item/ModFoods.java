package net.cobra.moreores.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoods {

    public static final FoodComponent PINEAPPLE = new FoodComponent.Builder()
            .nutrition(6).saturationModifier(3f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 200, 4), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION ,200, 4), 1f).build();

    public static final FoodComponent TOMATO  = new FoodComponent.Builder()
            .nutrition(8).saturationModifier(4f).build();

    public static final FoodComponent DIAMOND_APPLE = new FoodComponent.Builder()
            .nutrition(16).saturationModifier(8f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 200, 4), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 200, 10), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 4), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 200, 4), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 200, 4), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 4), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200, 4), 1f).alwaysEdible().build();
}