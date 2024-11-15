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
public class IngredientEntity {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private double price;
    @ManyToMany(mappedBy = "ingredients")
    private List<RecipeEntity> recipes;
    @ManyToMany(mappedBy = "ingredients")
    private List<PizzaEntity> pizzas;
}
