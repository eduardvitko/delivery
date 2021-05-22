//package com.delivery.domain;
//
//import javax.persistence.*;
//import java.util.List;
//@Entity
//@Table(name = "orders")
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private  int id;
//    @Column(nullable = false)
//    private  int numberOrder;
//    @OneToMany
//    private List <Baggage> baggages;
//    @Column(nullable = false)
//    private  double order_price;
//}
