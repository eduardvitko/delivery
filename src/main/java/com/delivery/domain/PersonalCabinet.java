package com.delivery.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Entity
public class PersonalCabinet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @OneToMany
    private List<Order>oreders;
    @OneToMany
    private Set<Bill>bills;



}
