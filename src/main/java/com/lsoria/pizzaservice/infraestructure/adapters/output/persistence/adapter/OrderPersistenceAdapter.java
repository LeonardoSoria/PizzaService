package com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.adapter;

import com.lsoria.pizzaservice.domain.model.Order;
import com.lsoria.pizzaservice.application.port.output.OrderOutputPort;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.mapper.OrderPersistenceMapper;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderPersistenceAdapter implements OrderOutputPort {

    private final OrderRepository userRepository;
    private final OrderPersistenceMapper orderPersistenceMapper;

//    @Override
//    public User saveUser(User user) {
//        UserEntity userEntity = this.userPersistenceMapper.toUserEntity(user);
//        userEntity = this.userRepository.save(userEntity);
//        return this.userPersistenceMapper.toUser(userEntity);
//    }

    @Override
    public Order saveOrder(Order order) {
        return null;
    }
}

