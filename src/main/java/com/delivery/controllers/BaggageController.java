//package com.delivery.controllers;
//
//
//import com.delivery.domain.Baggage;
//import com.delivery.services.BaggageService;
//import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//@Controller
//public class BaggageController {
//
//    @Resource
//    private BaggageService baggageService;
//
//
//    @GetMapping(value = "/baggage/all")
//    public ModelAndView baggageFindAll() {
//        ModelAndView modelAndView = new ModelAndView("baggage");
//        List<Baggage> baggageList = baggageService.baggageFindAll();
//        modelAndView.addObject("baggageList", baggageList);
//        return modelAndView;
//    }
//
//}
