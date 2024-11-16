package com.lsoria.pizzaservice.infraestructure.adapters.input.rest.data.request;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;
    private List<PizzaRequest> pizzaOrder;
    private String deliveryAddress;

}
