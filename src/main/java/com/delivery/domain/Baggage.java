package com.delivery.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class Baggage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int b_id;
    @Column(nullable = false)
   private String name_Baggage;
    @Column(nullable = false)
    private int height;
    @Column(nullable = false)
    private int weight;
    @Column(nullable = false)
    private  int length;
    @Column(nullable = false)
    private int width;


}
