package com.delivery.domain;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private int number;
    @Column(nullable = false)
    private double amountToPay;

    @OneToOne
    private Payment paymentSystem;

    @Column(nullable = false)
    boolean isPayed;

}