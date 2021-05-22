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
        registry.addViewController("/baggage").setViewName("baggage");
//        registry.addViewController("address-delete/{id}");


    }


}
