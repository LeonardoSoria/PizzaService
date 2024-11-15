package com.lsoria.pizzaservice.application.service;

import com.lsoria.pizzaservice.application.port.input.OrderUseCase;
import com.lsoria.pizzaservice.domain.model.Order;
import com.lsoria.pizzaservice.application.port.output.OrderOutputPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderService implements OrderUseCase {

    private final OrderOutputPort userOutputPort;

    @Override
    public Order registerOrder(Order order) {
        return null;
    }
}
