package com.delivery.dto;

import com.delivery.domain.Payment;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)


public class BillDto {

    private int id;

    private int number;

    private double amountToPay;

    private Payment paymentSystem;

    private boolean isPayed;
}
