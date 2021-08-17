package com.delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)

public class RoutesDto {


    private  int number;

    private AddressDto fromAddress;

    private AddressDto toAddress;

    private int distance;

    private  int duration;
}
