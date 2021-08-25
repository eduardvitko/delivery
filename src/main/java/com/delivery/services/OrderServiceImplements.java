package com.delivery.services;

import com.delivery.domain.Order;
import com.delivery.dto.OrderDto;
import com.delivery.maper.BusinessMapper;
import com.delivery.respositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class OrderServiceImplements implements OrderService {

    @Resource
    private OrderRepository orderRepository;

    @Autowired
    private BusinessMapper businessMapper;

    @Override
    public Set<OrderDto> ordersAll() {
        return businessMapper.orderDtoSet(orderRepository.findAll().stream().collect(Collectors.toSet()));
    }

    @Override
    public Order createOrder(Order order) {
      return orderRepository.save(order);

    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteById(int id) {
        Optional<Order> order = orderRepository.findById(id);
        orderRepository.deleteById(id);


    }

    @Override
    public Order readById(int id) {
         Optional<Order> order = orderRepository.findById(id);
         return order.get();

    }
}
