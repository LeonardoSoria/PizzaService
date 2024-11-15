package com.lsoria.pizzaservice.domain.model;

import com.lsoria.pizzaservice.domain.abstraction.Promotion;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
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
    private DayOfWeek applicableDay;

    @Override
    public boolean isApplicable(LocalDate orderDate) {
        return orderDate.getDayOfWeek().equals(applicableDay);
    }

    @Override
    public double applyDiscount(double total) {
        return total;  // Free delivery, no price discount but free shipping
    }
}
