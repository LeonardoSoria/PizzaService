package com.lsoria.pizzaservice.infraestructure.adapters.input.rest.data.request;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PizzaRequest {

    private Long pizzaRecipeId;
    private String pizzaName;
    private List<IngredientRequest> ingredients;
    private int quantity;
}
