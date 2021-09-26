package com.delivery.controllers;

import com.delivery.domain.*;
import com.delivery.dto.BaggageCreationDto;
import com.delivery.dto.DeliveryCardDto;
import com.delivery.dto.UserDto;
import com.delivery.respositories.UserRepository;
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
import java.util.HashSet;
import java.util.Set;

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

    @Autowired
    private UserRepository userRepository;

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
//    @GetMapping(value = "/baggage-create")
//    public ModelAndView createBaggagesPage(Baggage baggage){
//        ModelAndView modelAndView = new ModelAndView("deliveryCard");
//        modelAndView.addObject("baggageList",new Baggage());
//        return modelAndView;
//
//    }
//    @PostMapping(value = "/baggage-create")
//    public String createBaggages(@ModelAttribute Baggage baggage){
//        baggageService.createBaggage(baggage);
//        return "redirect:/deliveryCard";
//
//    }

    @GetMapping(value = "/deliveryCard/user/{email}")
    public ModelAndView deliveryCardPage(@PathVariable("email") String email) {
        ModelAndView modelAndView = new ModelAndView("deliveryCard");
//        UserDto userDto = userService.findUserByEmail(email);
//        DeliveryCardDto deliveryCardDto= userDto.getDeliveryCardDto();
//        modelAndView.addObject("deliveryCard",deliveryCardDto);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDto userDto = userService.findUserByEmail(auth.getName());
        DeliveryCardDto deliveryCardDto = userDto.getDeliveryCardDto();
        modelAndView.addObject("deliveryCard", deliveryCardDto);
        return modelAndView;
    }


    @GetMapping("/update-deliveryCard")
    public String showEditForm() {
        Set<Baggage> baggageSet = new HashSet<>();
        baggageService.baggageFindAll().iterator().forEachRemaining(baggageSet::add);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("form", new BaggageCreationDto(baggageSet));
        return "update-deliveryCard";
    }

    @GetMapping(value = "/deliveryCard/update/{id}")
    public ModelAndView updateDeliveryCard(@PathVariable("id") int id) {
        DeliveryCard deliveryCard = deliveryCardService.readById(id);
        ModelAndView modelAndView = new ModelAndView("update-deliveryCard");
        modelAndView.addObject("deliveryCard", deliveryCard);
        return modelAndView;
    }

    @PostMapping(value = "/deliveryCard/update")
    public String updateDeliveryCardPage(@ModelAttribute DeliveryCard deliveryCard) {
        deliveryCardService.updateDeliveryCard(deliveryCard);
        return "redirect:/deliveryCard";
    }


}
