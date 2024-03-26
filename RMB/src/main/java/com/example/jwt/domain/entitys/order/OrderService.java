package com.example.jwt.domain.entitys.order;

import com.example.jwt.core.generic.ExtendedService;
import com.example.jwt.domain.entitys.order.dto.OrderASCDTO;
import com.example.jwt.domain.entitys.order.dto.OrderCountDTO;
import com.example.jwt.domain.entitys.order.dto.OrderCreateDTO;

import java.util.List;

public interface OrderService extends ExtendedService<Order> {
    Order createOrder(Order order);

    List<Order> findOwn();

    List<OrderCountDTO> findTeas();

    List<OrderASCDTO> findMostActiveUser();

    List<OrderCreateDTO> getAllOrders(Integer pageNo, Integer pageSize);

}
