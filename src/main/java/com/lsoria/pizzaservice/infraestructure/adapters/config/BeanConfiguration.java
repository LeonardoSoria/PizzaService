package com.lsoria.pizzaservice.infraestructure.adapters.config;

import com.lsoria.pizzaservice.application.service.OrderService;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.adapter.OrderPersistenceAdapter;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.mapper.OrderPersistenceMapper;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.repository.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public OrderPersistenceAdapter userPersistenceAdapter(final OrderRepository orderRepository, final OrderPersistenceMapper orderPersistenceMapper) {
        return new OrderPersistenceAdapter(orderRepository, orderPersistenceMapper);
    }

    @Bean
    public OrderService orderService(final OrderPersistenceAdapter orderPersistenceAdapter) {
        return new OrderService(orderPersistenceAdapter);
    }
}
