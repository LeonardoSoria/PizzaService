package com.lsoria.pizzaservice.domain.model;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pizza {

    private Long id;
    private String name;
    private boolean isCustom;
    private Recipe recipe;
    private List<Ingredient> ingredients;
    private double basePrice;

    public Pizza(String name, boolean isCustom, Recipe recipe, List<Ingredient> ingredients) {
        this.name = name;
        this.isCustom = isCustom;
        this.recipe = recipe;
        this.ingredients = ingredients;
    }

    public double calculatePrice() {
        double total = basePrice;
        if (isCustom) {
            for (Ingredient ingredient : ingredients) {
                total += ingredient.getPrice();
            }
        }
        return total;
    }
}
