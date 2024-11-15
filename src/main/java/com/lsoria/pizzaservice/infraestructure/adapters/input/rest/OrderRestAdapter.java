package com.lsoria.pizzaservice.infraestructure.adapters.input.rest;

import com.lsoria.pizzaservice.application.port.input.OrderUseCase;
import com.lsoria.pizzaservice.domain.model.Order;
import com.lsoria.pizzaservice.infraestructure.adapters.input.rest.data.request.OrderRequest;
import com.lsoria.pizzaservice.infraestructure.adapters.input.rest.data.response.OrderResponse;
import com.lsoria.pizzaservice.infraestructure.adapters.input.rest.mapper.OrderRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderRestAdapter {

    private final OrderUseCase registerUserUseCase;

    @PostMapping("/createOrder")
    public ResponseEntity<OrderResponse> createOrder(@RequestBody @Valid OrderRequest orderRequest) {
        OrderRestMapper orderMapper = new OrderRestMapper();
        Order order = orderMapper.toOrder(orderRequest);
        order = this
        // User user = this.userRestMapper.toUser(registerUserRequest);
        // user = this.registerUserUseCase.registerUser(user);
        return new ResponseEntity<>(this.orderRestMapper.(orderRequest), HttpStatus.CREATED);
    }
}
