package com.delivery.domain;

import javax.persistence.*;
@Entity
public class Servise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(nullable = false)
    private  String nameServise;

    @OneToOne
    private Address addressServises;
    @OneToOne
    private  Tariff tariffService;


}
