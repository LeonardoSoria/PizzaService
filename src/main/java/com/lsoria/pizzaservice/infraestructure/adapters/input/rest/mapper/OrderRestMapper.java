package com.lsoria.pizzaservice.infraestructure.adapters.input.rest.mapper;

import com.lsoria.pizzaservice.domain.model.*;
import com.lsoria.pizzaservice.infraestructure.adapters.input.rest.data.request.IngredientRequest;
import com.lsoria.pizzaservice.infraestructure.adapters.input.rest.data.request.OrderRequest;
import com.lsoria.pizzaservice.infraestructure.adapters.input.rest.data.request.PizzaRequest;
import com.lsoria.pizzaservice.infraestructure.adapters.input.rest.data.response.OrderItemResponse;
import com.lsoria.pizzaservice.infraestructure.adapters.input.rest.data.response.OrderResponse;

import java.util.List;
import java.util.stream.Collectors;

public class OrderRestMapper {

    public OrderResponse toOrderResponse(Order order) {
        int pizzaQuantity = order.getOrderItems().stream()
                .mapToInt(OrderItem::getQuantity)
                .sum();

        List<OrderItemResponse> orderItemResponses = order.getOrderItems().stream()
                .map(orderItem -> {
                    double itemPrice = orderItem.getPizza().calculatePrice() * orderItem.getQuantity();
                    return new OrderItemResponse(
                            orderItem.getPizza().getName(),
                            orderItem.getQuantity()
                    );
                })
                .collect(Collectors.toList());

        return OrderResponse.builder()
                .totalPrice(order.calculateTotalPrice())
                .pizzaQuantity(pizzaQuantity)
                .orderItemResponse(orderItemResponses)
                .isDeliveryFree(order.isDeliveryFree())
                .build();
    }

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
        Pizza pizza;

        if (pizzaRequest.getPizzaRecipeId() != null) {
            // Set the recipe if pizzaRecipeId is provided
            pizza = new Pizza(
                    "",
                    false,
                    new Recipe(pizzaRequest.getPizzaRecipeId()),
                    null
            );
        } else if (pizzaRequest.getIngredients() != null) {
            // Set the ingredients if provided
            pizza = new Pizza(
                    "",
                    false,
                    null,
                    this.mapIngredientRequestsToIngredients(pizzaRequest.getIngredients())
            );
        } else {
            throw new IllegalArgumentException("Either pizzaRecipeId or ingredients must be provided.");
        }

        return OrderItem.builder()
                .pizza(pizza)
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
