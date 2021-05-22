//package com.delivery.domain;
//
//import javax.persistence.*;
//@Entity
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private  int id;
//    @Column(nullable = false)
//    private String Surname;
//    @Column(nullable = false)
//    private  String Name;
//    @Column(nullable = false)
//    private  String Patronymic;
//    @Column(nullable = false)
//    private String Phone;
//
//    @OneToOne
//    private Address address;
//
//    @OneToOne
//    private PersonalCabinet userCabinet;
//}
