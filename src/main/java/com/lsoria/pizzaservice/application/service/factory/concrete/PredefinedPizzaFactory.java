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
public class PredefinedPizzaFactory implements PizzaFactory {

    private final RecipeOutputPort recipeOutputPort;

    @Override
    public Pizza createPizza(Recipe recipe, List<Ingredient> ingredients) {
        Optional<Recipe> recipeOptional = recipeOutputPort.getRecipeById(recipe.getId());
        if (recipeOptional.isEmpty()) {
            throw new RecipeNotFoundException("Recipe not found");
        }
        recipe = recipeOptional.get();
        double basePrice = recipe.getIngredients().stream()
                .mapToDouble(Ingredient::getPrice)
                .sum();
        return Pizza.builder()
                .name(recipe.getName())
                .isCustom(false)
                .recipe(recipe)
                .ingredients(recipe.getIngredients())
                .basePrice(basePrice)
                .build();
    }
}
