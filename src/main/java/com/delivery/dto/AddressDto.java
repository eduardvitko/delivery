package com.delivery.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Setter
@Getter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor

public class AddressDto {

    private int id;

    private String city;

    private String street;

    private int numberBranch;
}
