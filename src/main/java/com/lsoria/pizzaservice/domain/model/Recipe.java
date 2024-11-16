package com.lsoria.pizzaservice.domain.model;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    private Long id;
    private String name;
    private List<Ingredient> ingredients;

    public Recipe(Long id) {
        this.id = id;
    }
}
