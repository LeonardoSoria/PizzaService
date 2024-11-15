package com.lsoria.pizzaservice.application.port.output;

import com.lsoria.pizzaservice.domain.model.Recipe;

import java.util.Optional;

public interface RecipeOutputPort {
        Optional<Recipe> getRecipeById(Long recipeId);
}
