package com.delivery.controllers;

import com.delivery.domain.Routes;
import com.delivery.services.RoutesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller

public class RoutesController {


    @Resource
    private RoutesService routesService;


    @GetMapping(value = "/routes-create")
    public ModelAndView createRoutesPage(Routes routes) {
        ModelAndView modelAndView = new ModelAndView("routes-create");
        modelAndView.addObject("routes", new Routes());
        return  modelAndView;
    }
    @PostMapping
    public String createRoutes(@ModelAttribute Routes routes){
        routesService.createRoutes(routes);
        return  "redirect:/all-routes";
    }
    @GetMapping(value = "/all-routes")
    public ModelAndView routesFindALL(){
        ModelAndView modelAndView = new ModelAndView("all-routes");
        List<Routes> routesList = routesService.getAllRoutes();
        modelAndView.addObject("routesList", routesList);
        return modelAndView;
    }
}
