package com.lsoria.pizzaservice.application.service.factory.concrete;

import com.lsoria.pizzaservice.application.port.output.RecipeOutputPort;
import com.lsoria.pizzaservice.application.service.factory.abstraction.PizzaFactory;
import com.lsoria.pizzaservice.domain.exception.RecipeNotFoundException;
import com.lsoria.pizzaservice.domain.model.Ingredient;
import com.lsoria.pizzaservice.domain.model.Pizza;
import com.lsoria.pizzaservice.domain.model.Recipe;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class CustomPizzaFactory implements PizzaFactory {

    private RecipeOutputPort recipeOutputPort;

    @Override
    public Pizza createPizza(Recipe recipe, List<Ingredient> ingredients) {
        return Pizza.builder()
                .name("Custom Pizza")
                .isCustom(true)
                .ingredients(ingredients)
                .basePrice(0)
                .build();
    }
}
