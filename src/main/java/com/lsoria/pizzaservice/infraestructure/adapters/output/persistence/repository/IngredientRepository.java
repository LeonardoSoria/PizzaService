package com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.repository;

import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.entity.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {
}
