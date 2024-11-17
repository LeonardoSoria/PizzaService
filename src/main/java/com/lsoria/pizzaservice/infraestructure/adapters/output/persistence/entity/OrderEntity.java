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

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private UserEntity user;

    private String orderDate;
    private boolean deliveryFree;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItemEntity> orderItems;

    @ManyToMany
    @JoinTable(
            name = "order_promotion",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "promotion_id")
    )
    private List<PromotionEntity> promotions;

    @OneToOne
    private DeliveryEntity delivery;
}
