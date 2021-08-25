package com.delivery.controllers;

import com.delivery.domain.Baggage;
import com.delivery.domain.Order;
import com.delivery.domain.Routes;
import com.delivery.services.BaggageService;
import com.delivery.services.OrderService;
import com.delivery.services.RoutesService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private RoutesService routesService;
    @Autowired
    private BaggageService baggageService;

    @GetMapping(value = "/order-create")
    public ModelAndView createOrderPage (Order order){
        ModelAndView modelAndView = new ModelAndView("order-create");
        modelAndView.addObject("order", new Order());
        modelAndView.addObject("baggage", new Baggage());
        modelAndView.addObject("routes", new Routes());
        return modelAndView;
    }

    @PostMapping("/order-create")
    public String createOrder(@ModelAttribute Order order, Baggage baggage, Routes routes){
       orderService.createOrder(order);
       baggageService.createBaggage(baggage);
       routesService.createRoutes(routes);
       return "redirect:/personalCabinet";
    }

}
