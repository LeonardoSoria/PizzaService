package com.lsoria.pizzaservice.infraestructure.adapters.input.rest.mapper;

import com.lsoria.pizzaservice.domain.model.*;
import com.lsoria.pizzaservice.infraestructure.adapters.input.rest.data.request.IngredientRequest;
import com.lsoria.pizzaservice.infraestructure.adapters.input.rest.data.request.OrderRequest;
import com.lsoria.pizzaservice.infraestructure.adapters.input.rest.data.request.PizzaRequest;

import java.util.List;
import java.util.stream.Collectors;

public class OrderRestMapper {

    public Order toOrder(OrderRequest orderRequest) {
        return Order.builder()
                .user(new User(orderRequest.getUserId()))
                .orderDate(orderRequest.getOrderDate())
                .orderItems(this.mapPizzaRequestsToOrderItems(orderRequest.getPizzaOrder()))
                .build();
    }

    private List<OrderItem> mapPizzaRequestsToOrderItems(List<PizzaRequest> pizzaRequests) {
        return pizzaRequests.stream()
                .map(this::mapPizzaRequestToOrderItem)
                .collect(Collectors.toList());
    }

    private OrderItem mapPizzaRequestToOrderItem(PizzaRequest pizzaRequest) {
        return OrderItem.builder()
                .pizza(new Pizza(
                        pizzaRequest.getPizzaName(),
                        false,
                        new Recipe(pizzaRequest.getPizzaRecipeId()),
                        this.mapIngredientRequestsToIngredients(pizzaRequest.getIngredients())))
                .quantity(pizzaRequest.getQuantity())
                .build();
    }

    private List<Ingredient> mapIngredientRequestsToIngredients(List<IngredientRequest> ingredientRequests) {
        return ingredientRequests.stream()
                .map(this::mapIngredientRequestToIngredient)
                .collect(Collectors.toList());
    }

    private Ingredient mapIngredientRequestToIngredient(IngredientRequest ingredientRequest) {
        return Ingredient.builder()
                .id(ingredientRequest.getIngredientId())
                .build();
    }

}
