package com.delivery.controllers;

import com.delivery.domain.Baggage;
import com.delivery.domain.DeliveryCard;
import com.delivery.domain.Order;
import com.delivery.domain.Routes;
import com.delivery.services.BaggageService;
import com.delivery.services.DeliveryCardService;
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


    @Autowired
    private OrderService orderService;

    @Autowired
    private BaggageService baggageService;

    @Autowired
    private DeliveryCardService deliveryCardService;

    @GetMapping(value = "/order-create")
    public ModelAndView createOrderPage(Order order) {
        ModelAndView modelAndView = new ModelAndView("order-create");
        modelAndView.addObject("order", new Order());
        return modelAndView;
    }

    @PostMapping("/order-create")
    public String createOrder(@ModelAttribute Order order, Baggage baggage, Routes routes) {
        orderService.createOrder(order);
        return "redirect:/personalCabinet";
    }
    @GetMapping(value = "/baggage-create")
    public ModelAndView createBaggagesPage(Baggage baggage){
        ModelAndView modelAndView = new ModelAndView("deliveryCard");
        modelAndView.addObject("baggageList",new Baggage());
        return modelAndView;

    }
    @PostMapping(value = "/baggage-create")
    public String createBaggages(@ModelAttribute Baggage baggage){
        baggageService.createBaggage(baggage);
        return "redirect:/deliveryCard";

    }

    @GetMapping(value = "/deliveryCard")
    public ModelAndView deliveryCardPage(DeliveryCard deliveryCard){{
        ModelAndView modelAndView = new ModelAndView("deliveryCard");
        modelAndView.addObject("deliveryCard", new DeliveryCard());
        return modelAndView;
    }

    }
    @PostMapping(value = "/deliveryCard")
   public String deliveryCardCreate(@ModelAttribute DeliveryCard deliveryCard){
        deliveryCardService.createDeliveryCard(deliveryCard);
        return "redirect:/deliveryCard";
    }





}
