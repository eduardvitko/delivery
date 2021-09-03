package com.delivery.dto;

import com.delivery.domain.Baggage;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Set;


@Data
@Setter
@Getter
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class BaggageCreationDto {

    private Set<Baggage> baggageSet;
}
