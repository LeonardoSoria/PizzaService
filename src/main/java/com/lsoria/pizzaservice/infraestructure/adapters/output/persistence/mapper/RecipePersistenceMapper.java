package com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.mapper;

import com.lsoria.pizzaservice.domain.model.Order;
import com.lsoria.pizzaservice.domain.model.Recipe;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.entity.OrderEntity;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.entity.RecipeEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface RecipePersistenceMapper {

    Recipe toRecipe(RecipeEntity recipeEntity);
}
