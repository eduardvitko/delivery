package com.delivery.controllers;


import com.delivery.domain.Baggage;
import com.delivery.respositories.BaggageRepository;
import com.delivery.services.BaggageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class BaggageController {

    @Resource
    private BaggageService baggageService;
    private BaggageRepository baggageRepository;


//    @GetMapping(value = "/deliveryCard/baggage")
//    public ModelAndView baggageFindAll() {
//        ModelAndView modelAndView = new ModelAndView("baggage");
//        Set<Baggage> baggageList = baggageService.baggageFindAll();
//        modelAndView.addObject("baggageSet",baggageList);
//        return modelAndView;
//    }

    @GetMapping(value = "/baggage/add")
    public ModelAndView createBaggagePage(Baggage baggage) {
        ModelAndView modelAndView = new ModelAndView("baggage-create");
        modelAndView.addObject("baggage", new Baggage());
        return modelAndView;
    }

    @PostMapping(value = "/baggage/add")
    public String createBaggage(@ModelAttribute Baggage baggage) {
        baggageService.createBaggage(baggage);
        return "redirect:/deliveryCard";
    }

    @GetMapping(value = "/baggage/delete/{id}")
    public String deleteById(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("baggage-delete");
        baggageService.deleteById(id);
        return "redirect:/deliveryCard";
    }

    @GetMapping(value = "/baggage/update/{id}")
    public ModelAndView updateBaggagePage(@PathVariable("id") int id) {
        Baggage baggage = baggageService.baggageReadById(id);
        ModelAndView modelAndView = new ModelAndView("update-baggage");
        System.out.println(baggage);
        modelAndView.addObject("baggage", baggage);
        return modelAndView;
    }

    @PostMapping(value = "/baggage/update")
    public String updateBaggage(@ModelAttribute Baggage baggage) {
       baggageService.updateBaggage(baggage);
        return "redirect:/deliveryCard";


    }
}