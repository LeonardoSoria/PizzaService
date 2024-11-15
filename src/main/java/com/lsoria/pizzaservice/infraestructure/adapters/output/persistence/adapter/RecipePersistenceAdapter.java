package com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.adapter;

import com.lsoria.pizzaservice.application.port.output.RecipeOutputPort;
import com.lsoria.pizzaservice.domain.model.Recipe;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.entity.RecipeEntity;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.mapper.RecipePersistenceMapper;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class RecipePersistenceAdapter implements RecipeOutputPort {

    private final RecipeRepository recipeRepository;
    private final RecipePersistenceMapper recipePersistenceMapper;

    @Override
    public Optional<Recipe> getRecipeById(Long recipeId) {
        Optional<RecipeEntity> recipeEntityOptional = this.recipeRepository.findById(recipeId);
        return recipeEntityOptional.map(recipePersistenceMapper::toRecipe);
    }
}

