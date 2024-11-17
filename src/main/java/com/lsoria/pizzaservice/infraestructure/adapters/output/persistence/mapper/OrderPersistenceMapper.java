package com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.mapper;

import com.lsoria.pizzaservice.domain.abstraction.Promotion;
import com.lsoria.pizzaservice.domain.model.FreeDeliveryPromotion;
import com.lsoria.pizzaservice.domain.model.Order;
import com.lsoria.pizzaservice.domain.model.TwoForOnePromotion;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.entity.OrderEntity;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.entity.PromotionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface OrderPersistenceMapper {

    @Mapping(target = "promotions", source = "promotions", qualifiedByName = "toPromotionList")
    Order toOrder(OrderEntity orderEntity);

    OrderEntity toOrderEntity(Order order);

    @Named("toPromotionList")
    default List<Promotion> toPromotionList(List<PromotionEntity> entities) {
        return entities.stream()
                .map(this::toConcretePromotion)
                .collect(Collectors.toList());
    }

    default Promotion toConcretePromotion(PromotionEntity entity) {
        return switch (entity.getPromotionType()) {
            case "TWO_FOR_ONE" -> TwoForOnePromotion.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .description(entity.getDescription())
                    .applicableDays(entity.getApplicableDays())
                    .build();
            case "FREE_DELIVERY" -> FreeDeliveryPromotion.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .description(entity.getDescription())
                    .applicableDays(entity.getApplicableDays())
                    .build();
            default -> throw new IllegalArgumentException("Unsupported promotion type: " + entity.getPromotionType());
        };
    }

    default PromotionEntity toPromotionEntity(Promotion promotion) {
        if (promotion instanceof TwoForOnePromotion) {
            TwoForOnePromotion twoForOne = (TwoForOnePromotion) promotion;
            return PromotionEntity.builder()
                    .id(twoForOne.getId())
                    .name(twoForOne.getName())
                    .description(twoForOne.getDescription())
                    .promotionType("TWO_FOR_ONE")
                    .applicableDays(twoForOne.getApplicableDays())
                    .build();
        } else if (promotion instanceof FreeDeliveryPromotion) {
            FreeDeliveryPromotion freeDelivery = (FreeDeliveryPromotion) promotion;
            return PromotionEntity.builder()
                    .id(freeDelivery.getId())
                    .name(freeDelivery.getName())
                    .description(freeDelivery.getDescription())
                    .promotionType("FREE_DELIVERY")
                    .applicableDays(freeDelivery.getApplicableDays())
                    .build();
        } else {
            throw new IllegalArgumentException("Unsupported promotion type: " + promotion.getClass().getName());
        }
    }
}

