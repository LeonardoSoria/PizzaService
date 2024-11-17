package com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.adapter;

import com.lsoria.pizzaservice.application.port.output.IngredientOutputPort;
import com.lsoria.pizzaservice.application.port.output.PromotionOutputPort;
import com.lsoria.pizzaservice.domain.abstraction.Promotion;
import com.lsoria.pizzaservice.domain.model.Ingredient;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.entity.IngredientEntity;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.mapper.IngredientPersistenceMapper;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.mapper.PromotionPersistenceMapper;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.repository.IngredientRepository;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.repository.PromotionRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PromotionPersistenceAdapter implements PromotionOutputPort {

    private final PromotionRepository promotionRepository;

    @Override
    public List<Promotion> getPromotions() {
        return promotionRepository.findAll().stream()
                .map(PromotionPersistenceMapper::toDomain)
                .collect(Collectors.toList());
    }
}

