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
public class PizzaEntity {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private boolean isCustom;
    @ManyToOne
    private RecipeEntity recipe;
    @ManyToMany
    private List<IngredientEntity> ingredients;
}
