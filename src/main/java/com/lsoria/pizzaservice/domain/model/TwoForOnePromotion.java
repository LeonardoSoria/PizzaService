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
public class TwoForOnePromotion implements Promotion {

    private Long id;
    private String name;
    private String description;
    private List<DayOfWeek> applicableDays;

    @Override
    public boolean isApplicable(LocalDate orderDate) {
        return applicableDays.contains(orderDate.getDayOfWeek());
    }

    @Override
    public double applyDiscount(double total) {
        return total / 2;
    }
}
