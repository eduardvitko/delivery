package com.delivery.dto;

import com.delivery.domain.Baggage;
import com.delivery.domain.Routes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)

public class OrderDto {

    private  int id;

    private  int numberOrder;

    private  double order_price;

    private LocalDateTime shippet_time;

    private LocalDateTime delivery_time;

    private List<BaggageDto> baggages;

    private RoutesDto route;
}
