package com.delivery.domain;

import com.delivery.dto.AddressDto;
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
public class Address extends AddressDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private int numberBranch;

}
