package com.lsoria.pizzaservice.domain.abstraction;

import java.time.LocalDate;

public interface Promotion {
    boolean isApplicable(LocalDate orderDate);
    double applyDiscount(double total);
}
