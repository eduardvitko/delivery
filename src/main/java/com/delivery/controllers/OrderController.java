package com.delivery.controllers;

import com.delivery.domain.Baggage;
import com.delivery.domain.DeliveryCard;
import com.delivery.domain.Order;
import com.delivery.domain.Routes;
import com.delivery.dto.BaggageDto;
import com.delivery.dto.OrderDto;
import com.delivery.dto.UserDto;
import com.delivery.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Set;
import java.util.stream.Collectors;

@Controller

public class OrderController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private BaggageService baggageService;

    @Autowired
    private DeliveryCardService deliveryCardService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/order-create")
    public ModelAndView createOrderPage(Order order) {
        ModelAndView modelAndView = new ModelAndView("order-create");
        modelAndView.addObject("order", new Order());
        return modelAndView;
    }


    @GetMapping(value = "/deliveryCard/")
    public ModelAndView deliveryCardPage(DeliveryCard deliveryCard) {
            ModelAndView modelAndView = new ModelAndView("deliveryCard");
            return modelAndView;

    }







    @PostMapping(value = "/deliveryCard")
    public String createOrder(@ModelAttribute DeliveryCard deliveryCard, Set<BaggageDto> baggageDtoSet) {
        baggageService.baggageFindAll().stream().collect(Collectors.toSet());
        deliveryCardService.createDeliveryCard(deliveryCard);
        return "redirect:/deliveryCard-all";


    }

    @GetMapping("/update-deliveryCard")
    public String showEditForm() {
        Set<Baggage> baggageSet = new HashSet<>();
        baggageService.baggageFindAll().iterator().forEachRemaining(baggageSet::add);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("form", new BaggageCreationDto(baggageSet));
        return "update-deliveryCard";
    }

}







