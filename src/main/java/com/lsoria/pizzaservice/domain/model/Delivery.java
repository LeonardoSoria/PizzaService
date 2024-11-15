package com.lsoria.pizzaservice.domain.model;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {

    private Long id;
    private String address;
}
