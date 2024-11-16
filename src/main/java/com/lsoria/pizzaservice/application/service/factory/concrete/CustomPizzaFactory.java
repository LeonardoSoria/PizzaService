package com.lsoria.pizzaservice.application.service.factory.concrete;

import com.lsoria.pizzaservice.application.port.output.IngredientOutputPort;
import com.lsoria.pizzaservice.application.service.factory.abstraction.PizzaFactory;
import com.lsoria.pizzaservice.domain.model.Ingredient;
import com.lsoria.pizzaservice.domain.model.Pizza;
import com.lsoria.pizzaservice.domain.model.Recipe;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class CustomPizzaFactory implements PizzaFactory {

    private final IngredientOutputPort ingredientOutputPort;

    @Override
    public Pizza createPizza(Recipe recipe, List<Ingredient> ingredients) {
        ingredients = this.ingredientOutputPort.findIngredientsByIds(
                ingredients.stream()
                        .map(Ingredient::getId)
                        .collect(Collectors.toList())
        );

        // Calculate the base price of the pizza
        double basePrice = ingredients.stream()
                .mapToDouble(Ingredient::getPrice)
                .sum();

        // Build and return the Pizza
        return Pizza.builder()
                .name("Custom Pizza")
                .isCustom(true)
                .ingredients(ingredients)
                .basePrice(basePrice)
                .build();
    }
}
