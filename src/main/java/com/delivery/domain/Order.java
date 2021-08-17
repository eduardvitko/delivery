package com.delivery.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int numberOrder;

    @OneToMany
    private List<Baggage> baggages;

    @Column(nullable = false)
    private double order_price;

    @OneToOne
    private Routes route;

    @Column(nullable = false)
    private LocalDateTime shippet_time;

    @Column(nullable = false)
    private LocalDateTime delivery_time;
}
