package com.delivery.controllers;

import com.delivery.domain.Order;
import com.delivery.services.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller

public class OrderController {


    @Resource
    private OrderService orderService;

    @GetMapping(value = "order-create")
    public ModelAndView createOrderPage (Order order){
        ModelAndView modelAndView = new ModelAndView("order-create");
        modelAndView.addObject("order", new Order());
        return modelAndView;
    }

    @PostMapping("/order-create")
    public String createOrder(@ModelAttribute Order order){
       orderService.createOrder(order);
       return "redirect:/personalCabinet";
    }

}
