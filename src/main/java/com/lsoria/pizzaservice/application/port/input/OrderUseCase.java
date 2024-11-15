package com.lsoria.pizzaservice.application.port.input;

import com.lsoria.pizzaservice.domain.model.Order;

public interface OrderUseCase {
    Order registerOrder(Order order);
}
