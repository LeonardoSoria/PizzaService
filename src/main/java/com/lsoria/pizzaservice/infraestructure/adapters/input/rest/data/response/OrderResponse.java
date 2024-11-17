package com.lsoria.pizzaservice.infraestructure.adapters.input.rest.data.response;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private List<OrderItemResponse> orderItemResponse;
    private int pizzaQuantity;
    private double totalPrice;
    private boolean isDeliveryFree;

}
