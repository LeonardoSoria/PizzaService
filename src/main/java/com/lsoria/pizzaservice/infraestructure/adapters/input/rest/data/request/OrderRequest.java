package com.lsoria.pizzaservice.infraestructure.adapters.input.rest.data.request;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {

    private Long userId;
    private LocalDate orderDate;
    private List<PizzaRequest> pizzaOrder;
    private String deliveryAddress;

}
