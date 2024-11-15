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
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "user")
    private List<OrderEntity> orders;
}
