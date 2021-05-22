//package com.delivery.domain;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//public class Routes {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private  int number;
//    @OneToOne
//    private Address fromAddress;
//    @OneToOne
//    private Address toAddress;
//    @Column(nullable = false)
//    private int distance;
//    @Column(nullable = false)
//    private  int duration;
//}
