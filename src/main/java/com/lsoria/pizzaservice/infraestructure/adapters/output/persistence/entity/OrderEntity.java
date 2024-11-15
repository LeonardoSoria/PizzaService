package com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class OrderEntity {

    @Id @GeneratedValue
    private Long id;
    @ManyToOne
    private UserEntity user;
    private String orderDate;
    private boolean isDeliveryFree;
    @OneToMany(mappedBy = "order")
    private List<OrderItemEntity> orderItems;
    @ManyToOne
    private PromotionEntity promotion;
    @OneToOne
    private DeliveryEntity delivery;
}
