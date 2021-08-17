package com.delivery.dto;

import com.delivery.domain.Address;
import com.delivery.domain.Tariff;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)

public class ServiseDto {

    private  int id;

    private  String nameServise;


    private Address addressServises;

    private Tariff tariffService;
}
