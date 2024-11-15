package com.lsoria.pizzaservice.infraestructure.adapters.input.rest.data.response;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private int quantity;
    private double totalPrice;

}
