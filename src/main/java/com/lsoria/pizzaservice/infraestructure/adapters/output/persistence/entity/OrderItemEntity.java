package com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class OrderItemEntity {

    @Id @GeneratedValue
    private Long id;
    @ManyToOne
    private OrderEntity order;
    @ManyToOne
    private PizzaEntity pizza;
    private int quantity;
}
