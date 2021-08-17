package com.delivery.dto;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)

public class TariffDto {

    private  int id;

    private double priceOfWeight;

    private double priceOfVolume;

    private double priceOfDistance;
}
