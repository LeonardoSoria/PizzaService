package com.lsoria.pizzaservice.application.service;

import com.lsoria.pizzaservice.application.port.input.OrderUseCase;
import com.lsoria.pizzaservice.application.port.output.PromotionOutputPort;
import com.lsoria.pizzaservice.application.service.factory.concrete.CustomPizzaFactory;
import com.lsoria.pizzaservice.application.service.factory.concrete.PredefinedPizzaFactory;
import com.lsoria.pizzaservice.domain.abstraction.Promotion;
import com.lsoria.pizzaservice.domain.model.Order;
import com.lsoria.pizzaservice.application.port.output.OrderOutputPort;
import com.lsoria.pizzaservice.domain.model.OrderItem;
import com.lsoria.pizzaservice.domain.model.Pizza;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class OrderService implements OrderUseCase {

    private final OrderOutputPort orderOutputPort;
    private final PromotionOutputPort promotionOutputPort;
    private final PredefinedPizzaFactory predefinedPizzaFactory;
    private final CustomPizzaFactory customPizzaFactory;

    @Override
    public Order registerOrder(Order order) {
        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItem orderItem : order.getOrderItems()) {
            Pizza pizza = createPizza(orderItem);
            OrderItem orderItemCompleteData = new OrderItem(pizza, orderItem.getQuantity());
            orderItems.add(orderItemCompleteData);
        }

        List<Promotion> promotions = this.promotionOutputPort.getPromotions();

        Order orderToSave = new Order(order.getUser(), order.getOrderDate(), orderItems, new ArrayList<>());
        promotions.forEach(promotion -> promotion.apply(orderToSave));
        return this.orderOutputPort.saveOrder(orderToSave);
    }

    private Pizza createPizza(OrderItem orderItem) {
        if (orderItem.getPizza().getIngredients() != null && !orderItem.getPizza().getIngredients().isEmpty()) {
            return customPizzaFactory.createPizza(orderItem.getPizza().getRecipe(), orderItem.getPizza().getIngredients());
        } else if (orderItem.getPizza().getRecipe() != null) {
            return predefinedPizzaFactory.createPizza(orderItem.getPizza().getRecipe(), orderItem.getPizza().getIngredients());
        } else {
            throw new IllegalArgumentException("Either pizzaRecipeId or ingredients must be provided.");
        }
    }
}
