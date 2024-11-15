package com.lsoria.pizzaservice.application.port.output;

import com.lsoria.pizzaservice.domain.model.Order;
import com.lsoria.pizzaservice.domain.model.User;

import java.util.Optional;

public interface OrderOutputPort {
    Order saveOrder(Order order);
}
