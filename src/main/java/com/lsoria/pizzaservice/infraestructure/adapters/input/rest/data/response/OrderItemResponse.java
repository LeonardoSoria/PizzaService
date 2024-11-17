package com.lsoria.pizzaservice.infraestructure.adapters.input.rest.data.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemResponse {

    private String pizzaName;
    private int quantity;

}
