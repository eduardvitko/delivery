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

public class PaymentDto {

    private int id;

    private  int namePayment;

    private String checkingAccount;
}
