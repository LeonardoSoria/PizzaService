package com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.mapper;

import com.lsoria.pizzaservice.domain.model.Order;
import com.lsoria.pizzaservice.domain.model.User;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.entity.OrderEntity;
import com.lsoria.pizzaservice.infraestructure.adapters.output.persistence.entity.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface OrderPersistenceMapper {

    OrderEntity toOrderEntity(Order order);

    Order toOrder(OrderEntity orderEntity);
}
