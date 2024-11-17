package com.lsoria.pizzaservice.domain.abstraction;

import com.lsoria.pizzaservice.domain.model.Order;


public interface Promotion {
    void apply(Order order);
}
