package com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.repository;

import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
