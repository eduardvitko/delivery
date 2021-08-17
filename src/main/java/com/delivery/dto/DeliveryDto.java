package com.delivery.dto;

import com.delivery.domain.Baggage;
import com.delivery.domain.Routes;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)

public class DeliveryDto {

    private int ttn;

    private Baggage nameBaggage;

    private Routes route;

    private LocalDateTime shippet_time;

    private LocalDateTime delivery_time;

    private double cost;
}
