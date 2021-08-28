package com.delivery.dto;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class DeliveryCardDto {
    private  int id;
    private List<BaggageDto> baggageDtos;


}
