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
public class RecipeEntity {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "recipe")
    private List<PizzaEntity> pizzas;

    @ManyToMany
    @JoinTable(
            name = "recipe_ingredient",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
    )
    private List<IngredientEntity> ingredients;
}
