package com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.repository;

import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {
}
