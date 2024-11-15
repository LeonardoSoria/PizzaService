package com.lsoria.pizzaservice.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {

    private Long id;
    private String name;
    private double price;

    public Ingredient(Long id) {
        this.id = id;
    }
}
