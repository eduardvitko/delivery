package com.delivery.controllers;


import com.delivery.domain.Address;
import com.delivery.services.AddressService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class AddressControler {
    @Resource
    private AddressService service;

    @GetMapping(value = "/address/all")
    public ModelAndView getAllAddresses() {
        ModelAndView modelAndView =new ModelAndView("addresses");
        List<Address> addressList = service.getAllAdresses();
        modelAndView.addObject("addressesList",addressList);
        return  modelAndView;
    }
    @GetMapping(value = "/address/add")
    public ModelAndView createAddressPage() {
        ModelAndView modelAndView =new ModelAndView("create-address");

        modelAndView.addObject("address",new Address());
        return  modelAndView;
    }
    @PostMapping(value = "/address/add")
    public String createAddress (@ModelAttribute Address address ){
        service.createAddress(address);
        return "redirect:/address/all";
    }
   @GetMapping(value = "/address/delete/{id}")
   public String deleteById(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("address-delete");
        service.deleteById(id);
       return "redirect:/address/all";
    }
    @GetMapping(value = "/update/address/{id}")
    ModelAndView updateAddressPage(@PathVariable("id") int id){
        Address address = service.readById(id);
        ModelAndView modelAndView = new ModelAndView("address-update");
        modelAndView.addObject("address", address);
        return  modelAndView;
    }
    @PostMapping(value = "/update/address-form")
    String updateAddress(Address address){
        service.update(address);
        return "redirect:/address/all";
    }

}
