package vitu.modao.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {

    //GERAÇÃO DE COMIDA

    public static final FoodComponent PAMONHA = new FoodComponent.Builder()
            .nutrition(8)
            .saturationModifier(0.6f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 10 * 20, 1), 0.1f)
            .build();
    public static final FoodComponent MILHO = new FoodComponent.Builder().nutrition(2).saturationModifier(0.2f).build();
}
