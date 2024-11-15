package com.lsoria.pizzaservice.domain.model;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private String name;
    private String email;
    private List<Order> orderHistory;

    public User(Long id) {
        this.id = id;
    }
}
