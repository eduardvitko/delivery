package com.delivery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int id;

    private String firstName;

    private String lastName;
    private String phoneNumber;

    private String email;

    private String password;
    private List<RoleDto> roles = new ArrayList<>();


    private AddressDto addressDto;
    private PersonalCabinetDTO personalCabinetDTO;

    //private Set<BillDto> bills;

}

