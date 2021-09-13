package com.delivery.dto;

import com.delivery.domain.DeliveryCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class UserSignUpRequest {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String firstPassword;
    private String secondPassword;


}
