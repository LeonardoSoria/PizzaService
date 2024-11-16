package com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.adapter;

import com.lsoria.pizzaservice.domain.model.Order;
import com.lsoria.pizzaservice.application.port.output.OrderOutputPort;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.entity.OrderEntity;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.mapper.OrderPersistenceMapper;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderPersistenceAdapter implements OrderOutputPort {

    private final OrderRepository userRepository;
    private final OrderPersistenceMapper orderPersistenceMapper;

    @Override
    public Order saveOrder(Order order) {
        OrderEntity orderEntity = this.orderPersistenceMapper.toOrderEntity(order);
        orderEntity = this.userRepository.save(orderEntity);
        return orderPersistenceMapper.toOrder(orderEntity);
    }
}

