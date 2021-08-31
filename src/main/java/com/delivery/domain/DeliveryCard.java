package com.delivery.domain;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity
public class DeliveryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Baggage> baggages;
}
