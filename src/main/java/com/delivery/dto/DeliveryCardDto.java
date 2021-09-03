package com.delivery.dto;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class DeliveryCardDto {

    private  int id;
    private Set<BaggageDto> baggageDtos = new TreeSet<>();


}
