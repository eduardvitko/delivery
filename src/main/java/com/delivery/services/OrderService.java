package com.delivery.services;

import com.delivery.domain.Order;
import com.delivery.dto.OrderDto;

import java.util.Set;

public interface OrderService {
    Order createOrder(Order order);
    Order updateOrder(Order order);
    void deleteById(int id);
    Order readById(int id);
    Set<OrderDto> ordersAll();
}
