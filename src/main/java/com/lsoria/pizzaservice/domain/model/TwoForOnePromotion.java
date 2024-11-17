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
public class TwoForOnePromotion implements Promotion {

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

            for (OrderItem item : order.getOrderItems()) {
                int quantity = item.getQuantity();
                int newQuantity = quantity * 2;
                item.setQuantity(newQuantity);
            }
        }
    }
}
