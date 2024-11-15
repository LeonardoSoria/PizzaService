package com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.adapter;

import com.lsoria.pizzaservice.application.port.output.IngredientOutputPort;
import com.lsoria.pizzaservice.domain.model.Ingredient;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.entity.IngredientEntity;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.mapper.IngredientPersistenceMapper;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class IngredientPersistenceAdapter implements IngredientOutputPort {

    private final IngredientRepository ingredientRepository;
    private final IngredientPersistenceMapper ingredientPersistenceMapper;

    @Override
    public List<Ingredient> findIngredientsByIds(List<Long> ids) {
        List<IngredientEntity> ingredientEntities = this.ingredientRepository.findAllById(ids);
        return ingredientEntities.stream().map(ingredientPersistenceMapper::toIngredient).collect(Collectors.toList());
    }
}

