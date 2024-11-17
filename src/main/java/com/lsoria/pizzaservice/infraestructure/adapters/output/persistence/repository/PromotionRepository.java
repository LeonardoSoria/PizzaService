package com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.repository;

import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.entity.PromotionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<PromotionEntity, Long> {
}
