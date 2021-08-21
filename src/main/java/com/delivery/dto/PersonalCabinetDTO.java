package com.delivery.dto;

import com.delivery.domain.Bill;
import com.delivery.domain.Delivery;
import com.delivery.domain.Order;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)

public class PersonalCabinetDTO {

    private  int id;

    private  List<OrderDto> oreders;

    private Set<BillDto> bills;


}
