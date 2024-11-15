package com.lsoria.pizzaservice.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    private Long id;
    private Pizza pizza;
    private int quantity;

    public OrderItem(Pizza pizza, int quantity) {
        this.pizza = pizza;
        this.quantity = quantity;
    }
    public double calculateItemPrice() {
        return pizza.calculatePrice() * quantity;
    }
}
