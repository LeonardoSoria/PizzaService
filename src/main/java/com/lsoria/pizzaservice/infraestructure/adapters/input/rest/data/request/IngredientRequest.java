package com.lsoria.pizzaservice.infraestructure.adapters.input.rest.data.request;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientRequest {

    private Long ingredientId;
}
