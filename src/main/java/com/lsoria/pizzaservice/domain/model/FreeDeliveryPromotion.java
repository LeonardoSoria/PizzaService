package com.lsoria.pizzaservice.domain.model;

import com.lsoria.pizzaservice.domain.abstraction.Promotion;
import lombok.*;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FreeDeliveryPromotion implements Promotion {

    private Long id;
    private String name;
    private String description;
    private List<DayOfWeek> applicableDays;

    @Override
    public void apply(Order order) {
        if (applicableDays.contains(order.getOrderDate().getDayOfWeek())) {
            if (order.getPromotions() == null) {
                order.setPromotions(new ArrayList<>());
            }
            order.getPromotions().add(this);
            order.setDeliveryFree(true);
        }
    }
}
