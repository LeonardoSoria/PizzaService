package com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.repository;

import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RecipeRepository extends JpaRepository<RecipeEntity, Long> {
    @Query("SELECT r FROM RecipeEntity r LEFT JOIN FETCH r.ingredients WHERE r.id = :id")
    Optional<RecipeEntity> findByIdWithIngredients(@Param("id") Long id);
}
