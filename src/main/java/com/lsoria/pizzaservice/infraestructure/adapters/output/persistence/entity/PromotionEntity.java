package com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.DayOfWeek;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
public class PromotionEntity {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String promotionType;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<DayOfWeek> applicableDays;

    @ManyToMany(mappedBy = "promotions")
    private List<OrderEntity> orders;
}
