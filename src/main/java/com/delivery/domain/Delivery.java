//package com.delivery.domain;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//public class Delivery {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int ttn;
//    @OneToMany
//    private List <Baggage> baggages;
//    @OneToOne
//    private Routes route;
//    @Column(nullable = false)
//    private LocalDateTime shippet_time;
//    @Column(nullable = false)
//    private  LocalDateTime delivery_time;
//    @Column(nullable = false)
//    private double cost;
//}
