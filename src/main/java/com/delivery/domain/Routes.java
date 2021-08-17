package com.delivery.domain;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class Routes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int number;

    @OneToOne
    private Address fromAddress;

    @OneToOne
    private Address toAddress;

    @Column(nullable = false)
    private int distance;

    @Column(nullable = false)
    private  int duration;
}
