package com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.mapper;

import com.lsoria.pizzaservice.domain.abstraction.Promotion;
import com.lsoria.pizzaservice.domain.model.FreeDeliveryPromotion;
import com.lsoria.pizzaservice.domain.model.TwoForOnePromotion;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.entity.PromotionEntity;

public class PromotionPersistenceMapper {

    public static Promotion toDomain(PromotionEntity entity) {
        return switch (entity.getPromotionType()) {
            case "TWO_FOR_ONE" ->
                    new TwoForOnePromotion(entity.getId(), entity.getName(), entity.getDescription(), entity.getApplicableDays());
            case "FREE_DELIVERY" ->
                    new FreeDeliveryPromotion(entity.getId(), entity.getName(), entity.getDescription(), entity.getApplicableDays());
            default -> throw new IllegalArgumentException("Unknown promotion type: " + entity.getPromotionType());
        };
    }
}
