package com.delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserSignUpDto {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String firstPassword;
    private String secondPassword;
}
