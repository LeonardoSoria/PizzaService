package com.lsoria.pizzaservice.application.service.factory.abstraction;

import com.lsoria.pizzaservice.domain.model.Ingredient;
import com.lsoria.pizzaservice.domain.model.Pizza;
import com.lsoria.pizzaservice.domain.model.Recipe;

import java.util.List;

public interface PizzaFactory {
    Pizza createPizza(Recipe recipe, List<Ingredient> ingredients);
}
