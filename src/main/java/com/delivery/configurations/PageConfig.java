package com.delivery.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class PageConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/addresses").setViewName("addresses");
        registry.addViewController("/create-address").setViewName("create-address");
        registry.addViewController("/address/delete").setViewName("address-delete");
        registry.addViewController("update/address-form").setViewName("address-update");

        registry.addViewController("/baggage").setViewName("baggage");
        registry.addViewController("baggage-create").setViewName("baggage-create");
        registry.addViewController("/baggage/delete").setViewName("baggage-delete");
        registry.addViewController("/baggage/update-form").setViewName("update-baggage");
        registry.addViewController("/startpage").setViewName("startpage");

        registry.addViewController("/registration-form").setViewName("registration-form");
        registry.addViewController("/user-all").setViewName("user-all");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/user-update").setViewName("user-update");
        registry.addViewController("/admin").setViewName("admin");
        registry.addViewController("/user/delete").setViewName("user-delete");
        registry.addViewController("/personalCabinet").setViewName("personalCabinet");
        registry.addViewController("/navigation").setViewName("navigation");
        registry.addViewController("/order-create").setViewName("order-create");





    }


}
