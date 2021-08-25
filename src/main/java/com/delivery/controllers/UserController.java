package com.delivery.controllers;


import com.delivery.domain.User;
import com.delivery.dto.UserDto;
import com.delivery.dto.UserSignIn;
import com.delivery.dto.UserSignUpRequest;
import com.delivery.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller

public class UserController {
    @Resource
    UserService userService;

    @GetMapping(value = "/registration-form")
    public ModelAndView showRegistrationForm() {
        ModelAndView modelAndView = new ModelAndView("registration-form");
        modelAndView.addObject("userSignUpRequest", new UserSignUpRequest());
        return modelAndView;
    }

    @PostMapping(value = "/registration-form")
    public String signUp(@ModelAttribute UserSignUpRequest userSignUpRequest, BindingResult result) {
        userService.signup(userSignUpRequest);
        return "redirect:/navigation";

    }

    @GetMapping(value = "/personalCabinet/user/{id}")
    public ModelAndView personalCabinet(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("personalCabinet");
        modelAndView.addObject("users", userService.findById(id));
        return modelAndView;

    }

    @GetMapping(value = "/user-all")
    public ModelAndView usersAll() {
        ModelAndView modelAndView = new ModelAndView("user-all");
        modelAndView.addObject("users", userService.usersAll());
        return modelAndView;
    }



    @GetMapping(value = "/admin")
    public ModelAndView admin() {
        ModelAndView modelAndView = new ModelAndView("admin");
        modelAndView.addObject("users", userService.usersAll());
        return modelAndView;
    }


    @GetMapping(value = "/form-login")
    public ModelAndView loginForm() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("userSignIn", new UserSignIn());
        return modelAndView;
    }

    @GetMapping(value = "/user/update/{email}")
    public ModelAndView updateUser(@PathVariable("email") String email) {
        UserDto user = userService.findUserByEmail(email);
        ModelAndView modelAndView = new ModelAndView("user-update");
        modelAndView.addObject("UserSignUpRequest", new User());
        return modelAndView;
    }

    @PostMapping(value = "/user/update")
    public String UpdateProfile(@ModelAttribute UserDto user) {
        userService.updateProfile(user);
        return "redirect:/user-all";


    }

    @GetMapping(value = "/user/delete/{id}")
    public String deleteById(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("user-delete");
        userService.deleteById(id);
        return "redirect:/user-all";
    }

    @GetMapping(value = "/navigation")
    public ModelAndView startPage() {
        ModelAndView modelAndView = new ModelAndView("navigation");
        return modelAndView;
    }


}

