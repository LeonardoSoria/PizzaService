package com.lsoria.pizzaservice.application.port.output;

import com.lsoria.pizzaservice.domain.model.Ingredient;

import java.util.List;

public interface IngredientOutputPort {
    List<Ingredient> findIngredientsByIds(List<Long> ids);
}
